package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tranquil.R;
import com.example.tranquil.SetAlarmActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FragmentClock extends Fragment implements View.OnClickListener {

    @ViewInject(R.id.clock1)
    public TextView clock1;
    @ViewInject(R.id.clock2)
    public TextView clock2;
    @ViewInject(R.id.newClock)
    public TextView newClock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_clock,null);
        ViewUtils.inject(getActivity());
        clock1= view.findViewById(R.id.clock1);
        clock1.setOnClickListener(this);
        clock2 = view.findViewById(R.id.clock2);
        clock2.setOnClickListener(this);
        newClock = view.findViewById(R.id.newClock);
        newClock.setOnClickListener(this);
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
            case R.id.clock1://跳到闹钟1编辑界面
                startActivity(new Intent(getActivity(), SetAlarmActivity.class));
                break;
            case R.id.clock2://跳到闹钟2编辑界面
                startActivity(new Intent(getActivity(), SetAlarmActivity.class));
                break;
            case R.id.newClock:// 新建界面
                startActivity(new Intent(getActivity(),SetAlarmActivity.class));
                break;
        }
    }
}

