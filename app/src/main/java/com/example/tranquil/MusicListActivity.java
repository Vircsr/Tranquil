package com.example.tranquil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
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
        setContentView(R.layout.activity_music_list);
        init();
        // page=findViewById(R.id.page);
        //Intent intent=getIntent();
        //Jump(Integer.parseInt(intent.getStringExtra("page")));
//        musicListView= findViewById(R.id.music_list);
//        musicListView.setAdapter(new ListViewAdapter(this,LoadMusicList()));
//        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MusicListActivity.this,PlayerActivity.class);
//                //intent.putExtra("musicId", position);//携带参数
//                startActivity(intent);
//            }
//        });
    }

    private void init(){

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
//    private static ArrayList<Music> LoadMusicList(){
//
//        ArrayList<Music> musicArrayList = new ArrayList<>();
//
//        Music music_1 = new Music();
//        music_1.setName("大哥大哥");
//        music_1.setSinger("熊佳星");
//
//        Music music_2 = new Music();
//        music_2.setName("天后");
//        music_2.setSinger("陈帆");
//
//        Music music_3 = new Music();
//        music_3.setName("倒数");
//        music_3.setSinger("邓紫棋");
//
//        Music music_4 = new Music();
//        music_4.setName("喜欢你");
//        music_4.setSinger("邓紫棋");
//
//        Music music_5 = new Music();
//        music_5.setName("Way back Home");
//        music_5.setSinger("熊佳星");
//
//        Music music_6 = new Music();
//        music_6.setName("心如止水");
//        music_6.setSinger("Ice");
//
//        Music music_7 = new Music();
//        music_7.setName("盛夏的果实");
//        music_7.setSinger("莫文蔚");
//
//        Music music_8 = new Music();
//        music_8.setName("爱的就是你");
//        music_8.setSinger("王力宏");
//
//        Music music_9 = new Music();
//        music_9.setName("起风了");
//        music_9.setSinger("买辣椒");
//
//        Music music_10 = new Music();
//        music_10.setName("Way back Home");
//        music_10.setSinger("熊佳星");
//
//        musicArrayList.add(music_1);
//        musicArrayList.add(music_2);
//        musicArrayList.add(music_3);
//        musicArrayList.add(music_4);
//        musicArrayList.add(music_5);
//        musicArrayList.add(music_6);
//        musicArrayList.add(music_7);
//        musicArrayList.add(music_8);
//        musicArrayList.add(music_9);
//        musicArrayList.add(music_10);
//        return musicArrayList;
//    }

//    /*加载媒体库里的音频*/
//    public ArrayList<Music> LocalMusicList(){
//        //生成动态数组，并且转载数据
//        ArrayList<Music> mylist = new ArrayList<Music>();
//
//        /*查询媒体数据库
//        参数分别为（路径，要查询的列名，条件语句，条件参数，排序）
//        视频：MediaStore.Video.Media.EXTERNAL_CONTENT_URI
//        图片;MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//
//         */
//        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
//        //遍历媒体数据库
//        if(cursor.moveToFirst()){
//            while (!cursor.isAfterLast()) {
//                //歌曲编号
//                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
//                //歌曲标题
//                String tilte = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
//                //歌曲的专辑名：MediaStore.Audio.Media.ALBUM
//                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
//                int albumId = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
//                //歌曲的歌手名： MediaStore.Audio.Media.ARTIST
//                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
//                //歌曲文件的路径 ：MediaStore.Audio.Media.DATA
//                String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
//                //歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
//                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
//                //歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
//                Long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
//
//
//                if (size >1024*800){//大于800K
//                    Music musicMedia = new Music();
//                    musicMedia.setId(id);
//                    musicMedia.setSinger(artist);
//                    musicMedia.setSize(size);
//                    musicMedia.setName(tilte);
//                    musicMedia.setDuration(duration);
//                    musicMedia.setPath(url);
//                    musicMedia.setAlbum(album);
//                    musicMedia.setAlbumId(albumId);
//
//                    mylist.add(musicMedia);
//
//                }
//                cursor.moveToNext();
//            }
//        }
//        return mylist;
//    }

}
