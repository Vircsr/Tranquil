package com.example.tranquil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import util.UserUtils;
import view.inputView;

public class RegisterActivity extends AppCompatActivity {
    private inputView mInputUser,mInputPassword,mInputPasswordAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().hide();//隐藏顶部栏
        initView();
    }

    private void initView(){
        mInputUser = findViewById(R.id.input_user);
        mInputPassword = findViewById(R.id.input_password);
    }

    public void onRegistClick(View v){
        String name = mInputUser.getInputHint();
        String password = mInputPassword.getInputHint();
        String passwordagain = mInputPasswordAgain.getInputHint();
        if(!UserUtils.validateLogin(this,name,password,passwordagain)){
            return;
        }

        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        finish();
    }
}
