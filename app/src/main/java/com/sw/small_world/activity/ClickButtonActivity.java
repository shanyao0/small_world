package com.sw.small_world.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sw.small_world.R;
import com.sw.small_world.fragment.base.FragmentFactory;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 所有能点击的按钮全部跳转到这个页面
 * Created by zs on 2015/11/3.
 */
public class ClickButtonActivity extends BaseActivity {


    FragmentManager fm;
    public Intent intent;
    public FragmentTransaction ft;
    @Bind(R.id.action_bar_back)
    public ImageView actionBarBack;
    @Bind(R.id.tv_title)
    public TextView tvTitle;
    @Bind(R.id.iv_right)
    public ImageView ivRight;
    @Bind(R.id.rl_actionbar)
    public RelativeLayout rlActionbar;
    @Bind(R.id.fl_click_button)
    public FrameLayout flClickButton;
    @Bind(R.id.tv_right)
    public TextView tvRight;

    public int resId;
    public String id;
    public String parkName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_button);
        ButterKnife.bind(this);
        // 获取传递过来的资源id值
        intent = getIntent();

        resId = intent.getIntExtra("resId", 0);
        if (intent.getExtras() != null) {
            resId = intent.getExtras().getInt("resId");
        }
        id = intent.getStringExtra("id");
        parkName = intent.getStringExtra("parkName");
        /**
         * 根据传递过来的不同的资源id值设置不同的fragment
         */
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fl_click_button, FragmentFactory.createById(resId));
        ft.commit();

        actionBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickButtonActivity.this.finish();
            }
        });
    }

    public void setResult(String data) {
        // 新建一个intent对象
        Intent intent1 = new Intent();
        intent1.putExtra("data", data);
        setResult(0, intent1);
        finish();
    }

    public void setResultAndCode(int resultCode, String data) {
        // 新建一个intent对象
        Intent intent1 = new Intent();
        intent1.putExtra("data", data);
        setResult(resultCode, intent1);
        finish();
    }


}

