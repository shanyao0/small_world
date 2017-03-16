package com.sw.small_world.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.sw.small_world.fragment.base.FragmentFactory;


/**
 * Created by zs on 2016/5/9.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private SparseArray<Fragment> saFragment = new SparseArray<>();
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (saFragment.get(position) == null) {
            saFragment.put(position, FragmentFactory.createForMain(position));
        }
        return saFragment.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
