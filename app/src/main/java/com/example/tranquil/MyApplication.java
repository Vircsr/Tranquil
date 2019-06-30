package com.example.tranquil;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * ============================
 * 作者： 陈帆
 * 日期：  2019/6/30 - 16:14
 * 描述：
 * ============================
 */
public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Utils.init(this);
    }
}
