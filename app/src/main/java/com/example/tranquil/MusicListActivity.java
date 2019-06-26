package com.example.tranquil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import adapter.ListViewAdapter;
import entity.Music;

public class MusicListActivity extends AppCompatActivity {


    @ViewInject(R.id.music_list)
    public ListView musicListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);//
        // page=findViewById(R.id.page);
        //Intent intent=getIntent();
        //Jump(Integer.parseInt(intent.getStringExtra("page")));
        musicListView= findViewById(R.id.music_list);
        musicListView.setAdapter(new ListViewAdapter(this,LoadMusicList()));
        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MusicListActivity.this,PlayerActivity.class);
                intent.putExtra("musicId", position);//携带参数
                startActivity(intent);
            }
        });
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
    private static ArrayList<Music> LoadMusicList(){

        ArrayList<Music> musicArrayList = new ArrayList<>();

        Music music_1 = new Music();
        music_1.setName("大哥大哥");
        music_1.setSinger("熊佳星");

        Music music_2 = new Music();
        music_2.setName("天后");
        music_2.setSinger("陈帆");

        Music music_3 = new Music();
        music_3.setName("倒数");
        music_3.setSinger("邓紫棋");

        Music music_4 = new Music();
        music_4.setName("喜欢你");
        music_4.setSinger("邓紫棋");

        Music music_5 = new Music();
        music_5.setName("Way back Home");
        music_5.setSinger("熊佳星");

        musicArrayList.add(music_1);
        musicArrayList.add(music_2);
        musicArrayList.add(music_3);
        musicArrayList.add(music_4);
        musicArrayList.add(music_5);
        return musicArrayList;
    }
}
