package com.bawei.cinemademo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_wangji)
    Button loginWangji;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.login_Wechat)
    ImageButton loginWechat;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }


}
