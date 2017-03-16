package com.sw.small_world.fragment.message;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.sw.small_world.fragment.base.BaseFragment;
import com.sw.small_world.utils.ConstantUtils;

/**
 * Created by Administrator on 2017/3/16.
 */

public class MessageFragment extends BaseFragment {
    @Override
    protected Object requestData() {
        return ConstantUtils.STATE_SUCCESSED;
    }

    @Override
    protected View getSuccessView() {
        TextView view = new TextView(getContext());
        view.setText("消息");
        view.setTextColor(Color.RED);
        view.setTextSize(50);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
