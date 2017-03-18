package com.sw.small_world.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sw.small_world.R;
import com.sw.small_world.activity.MainActivity;
import com.sw.small_world.fragment.base.BaseListFragment;
import com.sw.small_world.utils.CommonUtils;
import com.sw.small_world.utils.ConstantUtils;
import com.sw.small_world.utils.ToastUtil;
import com.sw.small_world.widgets.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/16.
 */

public class HomeFragment extends BaseListFragment<String> {

    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.ll_pager_points)
    LinearLayout llPagerPoints;
    @Bind(R.id.iv_guide_yellow)
    ImageView ivGuideYellow;
    @Bind(R.id.home_one)
    LinearLayout homeOne;
    @Bind(R.id.home_line_one)
    View homeLineOne;
    @Bind(R.id.home_hot_one)
    TextView homeHotOne;
    @Bind(R.id.home_hot_two)
    TextView homeHotTwo;
    @Bind(R.id.home_image1)
    ImageView homeImage1;
    @Bind(R.id.home_text1)
    TextView homeText1;
    @Bind(R.id.home_image2)
    ImageView homeImage2;
    @Bind(R.id.home_text2)
    TextView homeText2;
    @Bind(R.id.home_image3)
    ImageView homeImage3;
    @Bind(R.id.home_text3)
    TextView homeText3;
    @Bind(R.id.home_image4)
    ImageView homeImage4;
    @Bind(R.id.home_text4)
    TextView homeText4;
    private MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    protected Object requestData() {
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        return ConstantUtils.STATE_SUCCESSED;
    }

    @Override
    protected View getSuccessView() {
        View header = View.inflate(activity, R.layout.fragment_home, null);
        ButterKnife.bind(this, header);
        listView.addHeaderView(header);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        return refreshListView;
    }

    @Override
    protected View setView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(activity, R.layout.item_home_hot_answer, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    protected void setRefresh() {
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    CommonUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshListView.onRefreshComplete();
                            ToastUtil.show("刷新成功");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
    }

    @Override
    protected void loadMore() {
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    CommonUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshListView.onRefreshComplete();
                            ToastUtil.show("加载更多成功");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    static class ViewHolder {
        @Bind(R.id.hot_answer_portrait)
        CircleImageView hotAnswerPortrait;
        @Bind(R.id.hot_answer_name)
        TextView hotAnswerName;
        @Bind(R.id.hot_answer_deep)
        TextView hotAnswerDeep;
        @Bind(R.id.hot_answer_time)
        TextView hotAnswerTime;
        @Bind(R.id.hot_answer_question)
        TextView hotAnswerQuestion;
        @Bind(R.id.hot_answer_answer)
        TextView hotAnswerAnswer;
        @Bind(R.id.hot_answer_see_num)
        TextView hotAnswerSeeNum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
