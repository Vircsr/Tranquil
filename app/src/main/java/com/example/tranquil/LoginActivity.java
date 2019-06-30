package com.example.tranquil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import util.UserUtils;
import view.inputView;

public class LoginActivity extends AppCompatActivity {
    private inputView mInputUser,mInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();//隐藏顶部栏
        initView();
    }

    private void initView(){
        mInputUser = findViewById(R.id.input_user);
        mInputPassword = findViewById(R.id.input_password);
    }

    //跳转注册页面点击事件
    public void onRegisterClick(View v){
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    //登录按钮点击事件
    public void onCommitClick(View v){
        String name = mInputUser.getInputHint();
        String password = mInputPassword.getInputHint();
        if(!UserUtils.validateLogin(this,name,password)){
            return;
        }
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }


}
