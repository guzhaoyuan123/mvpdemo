package com.llw.mvpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.llw.mvpdemo.R;
import com.llw.mvpdemo.bean.User;
import com.llw.mvpdemo.presenter.LoginPresenter;
import com.llw.mvpdemo.view.ILoignView;
import com.llw.mvplibrary.mvp.MvpActivity;

public class LoginActivity extends MvpActivity<LoginPresenter> implements ILoignView {

    private static final String TAG = "MainActivity";
    EditText etUserNmae;
    EditText etPassWord;
    Button btLogin;


    @Override
    public void initData(Bundle savedInstanceState) {
        etUserNmae = findViewById(R.id.et_username);
        etPassWord = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);

        initView();
    }

    private void initView() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUserNmae.getText().toString();
                String password=etPassWord.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    doLoginFailed("请输入用户名或密码");
                }
                else{
                    mPresenter.doLogin(username,password);
                }

            }
        });

    }

    @Override
    protected LoginPresenter createPresenter() {
       return new LoginPresenter();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void doLoginResult(String msg) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        showMsg(msg);
        startActivity(intent);
    }

    @Override
    public void doLoginFailed(String msg) {
        showMsg(msg);
    }
}