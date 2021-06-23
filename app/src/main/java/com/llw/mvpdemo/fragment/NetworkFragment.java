package com.llw.mvpdemo.fragment;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.llw.mvpdemo.R;
import com.llw.mvpdemo.bean.GankResponse;
import com.llw.mvpdemo.presenter.MainPresenter;
import com.llw.mvpdemo.view.IMainView;
import com.llw.mvplibrary.mvp.MvpFragment;

/**
 * 需要访问网络的Fragment
 * @author gzy
 */
public class NetworkFragment extends MvpFragment<MainPresenter> implements IMainView {

    /**
     * 页面初始化
     * @param savedInstanceState
     */
    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getGankList();
    }

    /**
     * 绑定布局
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_network;
    }

    @Override
    protected MainPresenter createPresent() {
        return new MainPresenter();
    }

    /**
     * 数据正常返回
     * @param gankResponse
     */
    @Override
    public void getListResult(GankResponse gankResponse) {
        if (gankResponse.getData() != null && gankResponse.getData().size() > 0) {
            Log.d("Fragment",new Gson().toJson(gankResponse.getData()));
        }
    }

    /**
     * 数据异常返回
     * @param e
     */
    @Override
    public void getListFailed(Throwable e) {

    }
}