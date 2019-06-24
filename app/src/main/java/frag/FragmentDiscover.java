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

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FragmentDiscover extends Fragment implements View.OnClickListener{

    @ViewInject(R.id.search)
    public TextView search;
    @ViewInject(R.id.recommend)
    public TextView recommend;
    //@ViewInject(R.id.list)
    //public TextView list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_discover,null);
        ViewUtils.inject(getActivity());
        search = view.findViewById(R.id.search);
        search.setOnClickListener(this);
        recommend = view.findViewById(R.id.recommend);
        recommend.setOnClickListener(this);
        //list = view.findViewById(R.id.list);
        //list.setOnClickListener(this);
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
            case R.id.search://跳到搜索界面
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                break;
            case R.id.recommend://跳到推荐界面
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                break;
            //case R.id.list:// 跳到排行榜
            //    startActivity(new Intent(getActivity(),MusicListActivity.class));
            //    break;
            default:
                startActivity(new Intent(getActivity(),MusicListActivity.class));
                break;
        }
    }
}

