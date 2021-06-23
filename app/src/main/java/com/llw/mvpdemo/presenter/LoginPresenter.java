package com.llw.mvpdemo.presenter;

import com.llw.mvpdemo.bean.User;
import com.llw.mvpdemo.view.ILoignView;
import com.llw.mvplibrary.base.BasePresenter;

/**
 * @author : gzy
 * @program: MvpDemo
 * @description:
 * @date : 2021-06-23 15:10
 **/
public class LoginPresenter extends BasePresenter<ILoignView> {

    public void doLogin(String username,String password ){
        if (username.equals("gzy")&&password.equals("123456")){
            getView().doLoginResult("登录成功");
        }else {
            getView().doLoginFailed("用户名或密码不正确");
        }
    }
}
