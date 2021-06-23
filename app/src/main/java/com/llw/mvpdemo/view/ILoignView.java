package com.llw.mvpdemo.view;

import com.llw.mvpdemo.bean.User;
import com.llw.mvplibrary.base.BaseView;

/**
 * @author : gzy
 * @program: MvpDemo
 * @description:
 * @date : 2021-06-23 15:10
 **/
public interface ILoignView extends BaseView {
    //登录成功返回结果
    void doLoginResult(String msg);
    //登录失败，失败原因
    void doLoginFailed(String msg);
}
