package com.example.tranquil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MusicListActivity extends AppCompatActivity {


    //public TextView page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);//
        // page=findViewById(R.id.page);
        Intent intent=getIntent();
        //Jump(Integer.parseInt(intent.getStringExtra("page")));
    }
    public void Jump(int id){
        switch (id){
            case 0:
                //加载 收藏音乐
                break;
            case 1:
                //加载 已购音乐
                break;
            case 2:
                //加载 本地音乐
                break;
        }
    }
}
