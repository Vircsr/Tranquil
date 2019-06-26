package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.PlayerActivity;
import com.example.tranquil.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import adapter.GridViewAdapter;
import entity.MusicInfo;

public class FragmentDiscover extends Fragment implements View.OnClickListener{

    @ViewInject(R.id.search)
    public TextView search;
    @ViewInject(R.id.recommend)
    public TextView recommend;
    @ViewInject(R.id.grid_view)
    public GridView gridView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_discover,null);
        ViewUtils.inject(getActivity());
        search = view.findViewById(R.id.search);
        search.setOnClickListener(this);
        recommend = view.findViewById(R.id.recommend);
        recommend.setOnClickListener(this);
        gridView=view.findViewById(R.id.grid_view);
        gridView.setAdapter(new GridViewAdapter(getActivity(),LoadMusic()));
        //gridView.setOnClickListener(this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 跳转到音乐播放界面
                Intent intent = new Intent(getActivity(),
                        PlayerActivity.class);
                intent.putExtra("musicId", position);//携带参数
                startActivity(intent);

            }
        });
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
    private static ArrayList<MusicInfo> LoadMusic(){
        ArrayList<String> imgPath = new ArrayList<>();

        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/8.png");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/7.png");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/6.png");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/5.jpg");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/4.png");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/3.png");
        imgPath.add("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/2.png");

        ArrayList<MusicInfo> musicInfos = new ArrayList<>();

        for(int i=0;i<imgPath.size();i++){
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setImagePath(imgPath.get(i));
            musicInfo.setText("图片"+i);
            musicInfos.add(musicInfo);
        }
        return musicInfos;
    }
}

