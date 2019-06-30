package com.example.tranquil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * 音乐播放界面
 * 参考博客：https://blog.csdn.net/qq_33642117/article/details/51841510
 */

public class PlayerActivity extends AppCompatActivity {

    private ImageView recordView;
    private ImageView listenView;

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler = new Handler() {
        //收到Handler发回的消息被回调
        public void handleMessage(Message msg) {
            //更新UI组件
            if (msg.what == 0x123) {
                int current = mediaPlayer.getCurrentPosition();
                seekBar.setProgress(current);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        //将顶栏隐藏
        getSupportActionBar().hide();
        recordView = findViewById(R.id.record);
        seekBar = findViewById(R.id.listen_bar);
        listenView = findViewById(R.id.listen_or_not);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.listen_or_not:
                        start(v);
                }
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        String path = bundle.getString("path");
        Log.i("Info","Running here");
        Log.i("PlayActivity获取的path",path);

        rotateRecode();
        InitMediaPlayer(path);
        InitSeekBar();
    }

    /**
     * 图片旋转具体代码
     */
    public void rotateRecode() {
        @SuppressLint("ResourceType")
        Animation animation = AnimationUtils.loadAnimation(this, R.layout.img_animation);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        recordView.startAnimation(animation);
    }

    public void InitMediaPlayer(String path) {
        mediaPlayer= new MediaPlayer();
        //加载资源文件
        //String path = "https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/love.mp3";
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
    public void InitSeekBar(){
        //tv.setText(convert(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                //mediaPlayer.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer=null;//回收资源
        }
        super.onDestroy();
    }
    public void start(View view) {
        mediaPlayer.start();
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }//一秒
                    Message msg =
                            handler.obtainMessage();
                    msg.what = 0x123;
                    handler.sendMessage(msg);
                }
            }

            ;
        }.start();

    }
    public void stop(View view) {
        mediaPlayer.pause();
    }

}

