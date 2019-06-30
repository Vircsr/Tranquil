package frag;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static android.os.Looper.getMainLooper;

/**
 * ============================
 * 作者： 陈帆
 * 日期：  2019/6/28 - 10:52
 * 描述：fragment 基类
 * ============================
 */
public class FragmentBase extends Fragment {
    protected Handler handler;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setListener();
    }

    protected void setListener() {
    }

    public void onDestory(){

    }
}
