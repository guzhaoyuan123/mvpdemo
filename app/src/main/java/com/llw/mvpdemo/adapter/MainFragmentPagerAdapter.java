package com.llw.mvpdemo.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
* @program: MvpDemo
* @description: fragment左右滑动适配器
* @author : gzy
* @date : 2021-06-23 14:38
**/
public class MainFragmentPagerAdapter  extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public MainFragmentPagerAdapter(List<Fragment> fragments, FragmentManager fm) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
