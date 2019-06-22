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


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.R;

public class FragmentMusic extends Fragment implements View.OnClickListener {

    @ViewInject(R.id.textView0)
    public TextView textView0;
    @ViewInject(R.id.textView1)
    public TextView textView1;
    @ViewInject(R.id.textView2)
    public TextView textView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_music,null);
        ViewUtils.inject(getActivity());
        textView0 = view.findViewById(R.id.textView0);
        textView0.setOnClickListener(this);
        textView1 = view.findViewById(R.id.textView1);
        textView1.setOnClickListener(this);
        textView2 = view.findViewById(R.id.textView2);
        textView2.setOnClickListener(this);
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
            case R.id.textView0://收藏
                Intent intent0= new Intent(getActivity(),MusicListActivity.class);
                intent0.putExtra("page",0);
                startActivity(intent0);
                break;
            case R.id.textView1://已购音乐
                Intent intent1= new Intent(getActivity(),MusicListActivity.class);
                intent1.putExtra("page",1);
                startActivity(intent1);
                break;
            case R.id.textView2://本地音乐
                Intent intent2= new Intent(getActivity(),MusicListActivity.class);
                intent2.putExtra("page",2);
                startActivity(intent2);
                break;
        }
    }
}
