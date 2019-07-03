package com.example.tranquil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import frag.FragmentClock;
import frag.FragmentDiscover;
import frag.FragmentMusic;
import frag.FragmentMy;

public class MainActivity extends FragmentActivity {
    @ViewInject(R.id.bottom_bar)
    private RadioGroup bottom_bar;
    @ViewInject(R.id.layout_content)
    private FrameLayout layout_content;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        bottom_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index=0;
                switch (checkedId){
                    case R.id.radio0:
                        index=0;
                        break;
                    case R.id.radio1:
                        index=1;
                        break;
                    case R.id.radio2:
                        index=2;
                        break;
                    case R.id.radio3:
                        index=3;
                        break;
                }
                Fragment fragment= (Fragment) fragmentStatePagerAdapter.instantiateItem(layout_content,index);
                fragmentStatePagerAdapter.setPrimaryItem(layout_content,0,fragment);
                fragmentStatePagerAdapter.finishUpdate(layout_content);
            }
        });
        fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0://音乐
                        fragment=new FragmentMusic();
                        break;
                    case 1://发现
                        fragment=new FragmentDiscover();
                        break;
                    case 2://闹铃
                        fragment=new FragmentClock();
                        break;
                    case 3://我的
                        fragment=new FragmentMy();
                        break;
                    default:
                        fragment=new FragmentDiscover();
                        break;
                }
                return fragment;
            }
        };
    }
}
