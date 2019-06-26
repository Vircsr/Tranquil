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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tranquil.MusicListActivity;
import com.example.tranquil.R;
import com.example.tranquil.SetAlarmActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.Set;

import adapter.ClockListAdapter;
import entity.Clock;

public class FragmentClock extends Fragment implements View.OnClickListener {

    public ImageView clockadd;
    public ListView clockListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_clock, null);
        ViewUtils.inject(getActivity());
        clockadd = view.findViewById(R.id.clockadd);
        clockListView = view.findViewById(R.id.clock_List);
        clockListView.setAdapter(new ClockListAdapter(getActivity(), loadClockList()));
        clockListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2=new Intent(getActivity(),SetAlarmActivity.class);
                startActivity(intent2);
            }
        });
        clockadd.setOnClickListener(this);
        return view;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()) {
            case R.id.clockadd:// 新建界面
                startActivity(new Intent(getActivity(), SetAlarmActivity.class));
                break;
        }
    }

    public static ArrayList<Clock> loadClockList() {
        ArrayList<Clock> clockArrayList = new ArrayList<>();

        Clock clock1 = new Clock();
        clock1.setTime("00:46");

        Clock clock2 = new Clock();
        clock2.setTime("00:50");

        Clock clock3 = new Clock();
        clock3.setTime("00:18");

        Clock clock4 = new Clock();
        clock4.setTime("00:50");

        Clock clock5 = new Clock();
        clock5.setTime("00:18");

        clockArrayList.add(clock1);
        clockArrayList.add(clock2);
        clockArrayList.add(clock3);
        clockArrayList.add(clock4);
        clockArrayList.add(clock5);
        return clockArrayList;
    }

}

