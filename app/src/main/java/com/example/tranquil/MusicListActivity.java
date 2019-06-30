package com.example.tranquil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.File;
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

                ListView listView = (ListView) parent;
                ListAdapter listAdapter = listView.getAdapter();
                Music music = (Music) listAdapter.getItem(position);

                Intent intent = new Intent(MusicListActivity.this,PlayerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("path",music.getPath());
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

        if(ContextCompat.checkSelfPermission(MusicListActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MusicListActivity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
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
    private ArrayList<Music> LoadMusicList(){

        ArrayList<Music> musicArrayList = new ArrayList<>();
        Music music_1 = new Music();
        music_1 .setName("Honor");
        music_1 .setSinger("邓紫棋");
        File file = new File(Environment.getExternalStorageDirectory(),"Honor.mp3");
        music_1 .setPath(file.getPath());

        Music music_2 = new Music();
        music_2.setName("天使的魔鬼");
        music_2.setSinger("邓紫棋");
        music_2.setPath("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/love.mp3");

        Music music_3 = new Music();
        music_3.setName("喜欢你");
        music_3.setSinger("邓紫棋");
        music_3.setPath("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/love.mp3");
        musicArrayList.add(music_1);
        musicArrayList.add(music_2);
        musicArrayList.add(music_3);
        /*StringBuffer sb = new StringBuffer();//存放data的缓存
        //要返回的列（属性）
        String[] projection = { MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.DATA };
        Cursor cr = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                                                      projection, null,null, MediaStore.Audio.Media.DISPLAY_NAME);
        String displayName = null;
        String singerName=null;
        String data = null;
        while (cr.moveToNext()) {//移动到下一刻度，返回boolean类型值
            displayName = cr.getString(cr.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));//音频文件名
            singerName = cr.getString(cr.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            data = cr.getString(cr.getColumnIndex(MediaStore.Audio.Media.DATA));//音频文件路径+文件名
            if(data!=null&&displayName!=null){
                data = data.replace(displayName, " ");// 替换文件名留下它的上一级目录
            }

            if (!sb.toString().contains(data)) {
                //list.add(new ScanInfo(data, true));//默认全部勾选
                Music music = new Music();
                music.setName(displayName);
                music.setSinger(singerName);
                music.setPath(data);
                musicArrayList.add(music);
                sb.append(data);//加入到缓存里
            }
        }*/
        return musicArrayList;
    }
}
