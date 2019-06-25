package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tranquil.R;

import java.util.ArrayList;

import entity.MusicInfo;

/**
 * 用来在 FragmentDiscover 即发现页面 加载服务端的图片，并展示在GridView
 * 参考博客: https://blog.csdn.net/qq_36243942/article/details/82178388
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<MusicInfo> musicInfos;

    public GridViewAdapter(Context context, ArrayList<MusicInfo> musicInfos){
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
        this.musicInfos=musicInfos;
    }

    @Override
    public int getCount() {
        return musicInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return musicInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public ImageView Grid_imageview;
        public TextView Grid_textview;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            //填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            //把控件所在的布局文件加载到当前类中
            convertView = layoutInflater.inflate(R.layout.grid_item,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //获取控件对象
            holder.Grid_imageview=convertView.findViewById(R.id.image_id);
            holder.Grid_textview=convertView.findViewById(R.id.text_id);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //修改空间属性
        //holder.Grid_textview.setText("汽车");
        //加载第三方网络图片
        //Glide.with(context).load("https://raw.githubusercontent.com/MLNewbee/OrderingWebsite/master/IMG/9.jpg").into(holder.Grid_imageview);
         MusicInfo musicInfo = musicInfos.get(position);
         holder.Grid_textview.setText(musicInfo.getText());

        Glide.with(context).load(musicInfo.getImagePath()).into(holder.Grid_imageview);

        return convertView;

    }
}
