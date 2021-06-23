package com.llw.mvpdemo.presenter;

import android.annotation.SuppressLint;

import com.llw.mvpdemo.api.ApiService;
import com.llw.mvpdemo.bean.GankResponse;
import com.llw.mvpdemo.view.IMainView;
import com.llw.mvplibrary.base.BasePresenter;
import com.llw.mvplibrary.network.NetworkApi;
import com.llw.mvplibrary.network.observer.BaseObserver;

/**
 * @author : gzy
 * @program: MvpDemo
 * @description:
 * @date : 2021-06-23 15:01
 **/
public  class MainPresenter extends BasePresenter<IMainView> {

    @SuppressLint("CheckResult")
    public void getGankList(){
        ApiService service  = NetworkApi.createService(ApiService.class);
        service.getList().compose(NetworkApi.applySchedulers(new BaseObserver<GankResponse>() {
            @Override
            public void onSuccess(GankResponse gankResponse) {
                if (getView() != null) {
                    getView().getListResult(gankResponse);
                }
            }

            @Override
            public void onFailure(Throwable e) {
                if (getView() != null) {
                    getView().getListFailed(e);
                }
            }
        }));
    }
}