package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tranquil.R;
import java.util.ArrayList;
import entity.Clock;


public class ClockListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Clock> clockArrayList;

    public ClockListAdapter(Context context,ArrayList<Clock> clockArrayList){
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
        this.clockArrayList=clockArrayList;

    }


    @Override
    public int getCount() {
        return clockArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return clockArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        //显示item中时间和选择按钮的两个组件
        public TextView clock_ringtime;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ViewHolder holder=null;
        if(convertView == null){
            //填写ListView的图标和标题等控件的来源，来自于layout;clocklist_item这个布局文件
            //把控件所在的布局文件加载到当前类中
            convertView = layoutInflater.inflate(R.layout.clocklist_item,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //获取控件对象
            holder.clock_ringtime=convertView.findViewById(R.id.clock_ringtime);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Clock clock= clockArrayList.get(position);
        holder.clock_ringtime.setText(clock.getTime());

        return convertView;
        }

}