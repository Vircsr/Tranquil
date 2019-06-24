package com.example.tranquil;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class SetMyActivity extends Activity implements View.OnClickListener {


    @ViewInject(R.id.setMyBack)
    public TextView setMyBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_my);
        ViewUtils.inject(this);
        setMyBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setMyBack:
                this.finish();
        }
    }
}
