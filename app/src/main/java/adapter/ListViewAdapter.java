package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tranquil.R;

import java.util.ArrayList;

import entity.Music;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Music> musicList;

    public ListViewAdapter(Context context,ArrayList<Music> musicList){
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
        this.musicList=musicList;
    }
    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public TextView song_textview;
        public TextView singer_textview;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            //填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            //把控件所在的布局文件加载到当前类中
            convertView = layoutInflater.inflate(R.layout.list_item,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //获取控件对象
            holder.song_textview=convertView.findViewById(R.id.song);
            holder.singer_textview=convertView.findViewById(R.id.singer);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Music music = musicList.get(position);
        holder.song_textview.setText(music.getName());
        holder.singer_textview.setText(music.getSinger());

        return convertView;
    }
}
