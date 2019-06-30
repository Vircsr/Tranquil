package com.example.tranquil;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.codingending.popuplayout.PopupLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {
    private boolean useRadius = true;//使用圆角特性

    private ImageView recordView;//封面图片
    private ImageButton listenView;
//封面旋转功能
    private ObjectAnimator objectAnimator;
    private static final int STATE_PLAYING = 1;//播放
    private static final int STATE_PAUSE = 2;//暂停
    private static final int STATE_STOP = 3;//停止
    private int state;


    private boolean isPlay = false;
    private MediaPlayer mediaPlayer;
    private Mythread mythread;
    private SeekBar seekBar;
//    private Handler handler = new Handler() {
//        //收到Handler发回的消息被回调
//        public void handleMessage(Message msg) {
//            //更新UI组件
//            if (msg.what == 0x123) {
//                int current = mediaPlayer.getCurrentPosition();
//                seekBar.setProgress(current);
//            }
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this,R.layout.activity_player,null);
        setContentView(view);
        getSupportActionBar().hide();//隐藏顶部栏
        recordView = findViewById(R.id.record);
        listenView = findViewById(R.id.listen_or_not);
        listenView.setOnClickListener(new ButtonListener());
        findViewById(R.id.listen_list).setOnClickListener(new ButtonListener());
        findViewById(R.id.go_back).setOnClickListener(new ButtonListener());
        seekBar  = findViewById(R.id.listen_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //首先获取seekbar拖动后的位置
                int progress=seekBar.getProgress();
                //跳转到某个位置播放
                mediaPlayer.seekTo(progress);
            }
        });

        //InitSeekBar();
    }

    /**
     * 图片旋转具体代码
     */
//

    @SuppressLint("ObjectAnimatorBinding")
    private void initRotate(){
        state = STATE_STOP;
        objectAnimator = ObjectAnimator.ofFloat(this,"rotation",0f,360f);
        objectAnimator.setDuration(5000);
        objectAnimator.setInterpolator(new LinearInterpolator());//线性
        objectAnimator.setRepeatCount(objectAnimator.INFINITE);
        objectAnimator.setRepeatMode(objectAnimator.RESTART);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)//sdk>=19 do work
    private void rotateRecode(){
        switch (state){
            case STATE_PLAYING:
                objectAnimator.pause();
                state = STATE_PAUSE;
                break;
            case STATE_PAUSE:
                objectAnimator.resume();
                state = STATE_PLAYING;
                break;
            case STATE_STOP:
                objectAnimator.start();
                state = STATE_PLAYING;
                break;
                default:
                    break;
        }
    }

    private void stopRecode(){
        objectAnimator.end();
        state = STATE_STOP;
    }
    public void InitMediaPlayer() {
        mediaPlayer = new MediaPlayer();

        //加载资源文件
        String path = "https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/love.mp3";
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void playOrPause(View view){
        if(mediaPlayer==null) {
            isPlay = true;
            InitMediaPlayer();
            initRotate();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    rotateRecode();
                    listenView.setImageResource(R.drawable.ic_pause_circle_24dp);
                    int len_of_time = mediaPlayer.getDuration();
                    seekBar.setMax(len_of_time);
                    mythread = new Mythread();
                    mythread.start();
                    mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                        @Override
                        public void onBufferingUpdate(MediaPlayer mp, int percent) {
                            //得到缓冲值
                            int secendProssed = mediaPlayer.getDuration() / 100 * percent;
                            //设置第二进度
                            seekBar.setSecondaryProgress(secendProssed);

                        }
                    });
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    isPlay = false;
                    mythread = null;
                    //stopRecode();
                    listenView.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                }
            });

        }else if(mediaPlayer.isPlaying()){
            isPlay=false;
            mediaPlayer.pause();
            rotateRecode();
            //改变图标（实现播放）
            listenView.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
            //当停止播放时线程也停止了(这样也可以减少占用的内存)
            mythread=null;

        }else {
            isPlay=true;
            mediaPlayer.start();
            rotateRecode();
            //改变图标（实现暂停）
            listenView.setImageResource(R.drawable.ic_pause_circle_24dp);
            mythread = new Mythread();
            mythread.start();
        }

    }

    //获取示例ListView
    private void initListView(View parent) {
        ListView listView = parent.findViewById(R.id.listview_bottom);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getDataList());
        listView.setAdapter(adapter);
    }

    //获取列表的演示数据
    private List<String> getDataList() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("示例条目" + i);
        }
        return dataList;
    }
    private  class  ButtonListener implements  View.OnClickListener{

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.listen_or_not:
                    playOrPause(v);
                    break;
                case R.id.listen_back:
                    //后退按钮
                    break;
                case R.id.listen_next:
                    //前进按钮
                    break;
                case R.id.listen_change:
                    //播放模式选择
                    break;
                case R.id.listen_list:
                    //播放列表
                    View view = View.inflate(PlayerActivity.this, R.layout.music_bottom_list, null);
                    initListView(view);
                    PopupLayout popupLayout = PopupLayout.init(PlayerActivity.this, view);
                    popupLayout.setUseRadius(useRadius);
                    popupLayout.setHeight(350, true);
                    popupLayout.show();
                    break;
                case R.id.go_back:
                    finish();
                    break;
                    default:
                        break;

            }
        }
    }
    //多线程
    private class Mythread extends Thread{
        @Override
        public void run() {
            super.run();
            while(seekBar.getProgress()<=seekBar.getMax()){
                //设置进度条的进度
                //得到当前音乐的播放位置
                int  currentPosition=mediaPlayer.getCurrentPosition();
                Log.i("test","currentPosition"+currentPosition);
                seekBar.setProgress(currentPosition);
                //让进度条每一秒向前移动
                SystemClock.sleep(1000);
                if (!isPlay){
                    break;

                }

            }

        }
    }

//    public void InitSeekBar(){
//        //tv.setText(convert(mediaPlayer.getDuration()));
//        seekBar.setMax(mediaPlayer.getDuration());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//                int progress = seekBar.getProgress();
//                mediaPlayer.seekTo(progress);
//                //mediaPlayer.start();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                // TODO Auto-generated method stub
//                if (fromUser) {
//                    mediaPlayer.seekTo(progress);
//                }
//            }
//        });
//    }


//    private void start(View view) {
//        mediaPlayer.start();
//        new Thread() {
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }//一秒
//                    Message msg =
//                            handler.obtainMessage();
//                    msg.what = 0x123;
//                    handler.sendMessage(msg);
//                }
//            }
//
//            ;
//        }.start();
//
//
//    }



//    public void stop(View view) {
//        mediaPlayer.pause();
//    }

//    @Override
//    protected void onDestroy() {
//        // TODO Auto-generated method stub
//        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
//            mediaPlayer.stop();
//            mediaPlayer.reset();
//            mediaPlayer=null;//回收资源
//        }
//        super.onDestroy();
//    }

}