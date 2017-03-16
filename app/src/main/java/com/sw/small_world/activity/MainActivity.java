package com.sw.small_world.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sw.small_world.R;
import com.sw.small_world.adapter.MainPagerAdapter;
import com.sw.small_world.utils.StartUtils;
import com.sw.small_world.widgets.NoScrollViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.home_title)
    TextView homeTitle;
    @Bind(R.id.viewpager)
    NoScrollViewPager viewpager;
    @Bind(R.id.bottom_home)
    RadioButton bottomHome;
    @Bind(R.id.bottom_small_world)
    RadioButton bottomSmallWorld;
    @Bind(R.id.bottom_message)
    RadioButton bottomMessage;
    @Bind(R.id.bottom_me)
    RadioButton bottomMe;
    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    @Bind(R.id.bottom_publish)
    ImageView bottomPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewpager.setCurrentItem(0);
        bottomHome.setChecked(true);
        viewpager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        bottomPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartUtils.startActivityById(MainActivity.this,v.getId());
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_home:
                        viewpager.setCurrentItem(0, false);
                        break;
                    case R.id.bottom_small_world:
                        viewpager.setCurrentItem(1, false);
                        break;
                    case R.id.bottom_message:
                        viewpager.setCurrentItem(2, false);
                        break;
                    case R.id.bottom_me:
                        viewpager.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }
}
