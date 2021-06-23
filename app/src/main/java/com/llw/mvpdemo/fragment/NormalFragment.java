package com.llw.mvpdemo.fragment;

import android.os.Bundle;

import com.llw.mvpdemo.R;
import com.llw.mvplibrary.base.BaseFragment;

/**
 * 普通Fragment
 * @author gzy
 */
public class NormalFragment extends BaseFragment {

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_normal;
    }
}