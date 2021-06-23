package com.llw.mvpdemo.view;

import com.llw.mvpdemo.bean.GankResponse;
import com.llw.mvplibrary.base.BaseView;

/**
 * @author : gzy
 * @program: MvpDemo
 * @description:
 * @date : 2021-06-23 15:05
 **/
public interface IMainView extends BaseView {
    //返回列表结果
    void getListResult(GankResponse gankResponse);
    //获取列表失败返回
    void getListFailed(Throwable e);
}