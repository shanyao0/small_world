package com.sw.small_world.fragment.base;

import android.support.v4.app.Fragment;

import com.sw.small_world.R;
import com.sw.small_world.fragment.home.HomeFragment;
import com.sw.small_world.fragment.me.MeFragment;
import com.sw.small_world.fragment.message.MessageFragment;
import com.sw.small_world.fragment.publish.PublishFragment;
import com.sw.small_world.fragment.smallworld.SmallWorldFragment;


/**
 * fragment的工厂类
 * zs on 2015/11/3.
 */
public class FragmentFactory {

    /**
     * 根据资源id返回不同的fragment
     */
    public static Fragment createById(int resId) {
        Fragment fragment = null;
        switch (resId) {
            case R.id.bottom_publish:
                fragment = new PublishFragment();
                break;
//            case R.id.carport_more:
//                fragment = new MoreCarportFragment();
//                break;
//            case R.id.rl_setting:
//                fragment = new UserSettingFragment();
//                break;
        }
        return fragment;
    }

    /**
     * main
     *
     * @param position
     * @return
     */
    public static Fragment createForMain(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new SmallWorldFragment();
                break;
            case 2:
                fragment = new MessageFragment();
                break;
            case 3:
                fragment = new MeFragment();
                break;
        }
        return fragment;
    }
}
