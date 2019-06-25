package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.R;
import com.example.tranquil.SetAlarmActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FragmentClock extends Fragment implements View.OnClickListener {

    public ImageView clockadd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_clock,null);
        ViewUtils.inject(getActivity());
        clockadd=view.findViewById(R.id.clockadd);
        clockadd.setOnClickListener(this);
        return view;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clockadd:// 新建界面
                startActivity(new Intent(getActivity(),SetAlarmActivity.class));
                break;
        }
    }
}

