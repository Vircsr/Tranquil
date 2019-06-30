package com.example.tranquil;

/**
 *欢迎引导页
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import util.Toolkits;

public class WelcomeActivity extends AppCompatActivity {
    public static final String IS_FIRST="is_first";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();//隐藏顶部栏
        //线程休眠
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(Toolkits.fetchBooble(WelcomeActivity.this,IS_FIRST,false)){
                    startActivity(new Intent(WelcomeActivity.this,WhatsNewActivity.class));
                }else {
                    startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                }
                Toolkits.putBooble(WelcomeActivity.this,IS_FIRST,true);
                return true;
            }
        }).sendEmptyMessageDelayed(0,3000);
    }
}

