package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

//import android.support.v4.app.ListFragment;
//import android.util.Log;

public class FragmentMusic extends Fragment implements View.OnClickListener{
    @ViewInject(R.id.local_music)
    public Button b_local;
    @ViewInject(R.id.nearest_music)
    public Button b_nearest;
    @ViewInject(R.id.download_music)
    public Button b_download;
    @ViewInject(R.id.favor_music)
    public Button b_favor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =LayoutInflater.from(getActivity()).inflate(R.layout.frag_music,null);
        ViewUtils.inject(getActivity());
        b_local=view.findViewById(R.id.local_music);
        b_local.setOnClickListener(this);
        b_nearest=view.findViewById(R.id.nearest_music);
        b_nearest.setOnClickListener(this);
        b_download=view.findViewById(R.id.download_music);
        b_download.setOnClickListener(this);
        b_favor=view.findViewById(R.id.favor_music);
        b_favor.setOnClickListener(this);
        return view;
    }
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.local_music:
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                break;
            case R.id.nearest_music:
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                 break;
            case R.id.download_music:
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                break;
            case R.id.favor_music:
                startActivity(new Intent(getActivity(), MusicListActivity.class));
                break;
            default:
                break;
            }
        }

}
