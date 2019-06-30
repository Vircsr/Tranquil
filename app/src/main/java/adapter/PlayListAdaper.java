package adapter;

import android.content.ContentProvider;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tranquil.R;

import java.util.List;

import entity.Music;
import util.MusicUtils;

/**
 * ============================
 * 作者： 陈帆
 * 日期：  2019/6/29 - 16:56
 * 描述：
 * ============================
 */
public class PlayListAdaper extends BaseAdapter {
    private List<Music> mData;
    private LayoutInflater mInflater ;
    private int mResource;
    private Context mContext;

    public PlayListAdaper(Context context,int resId,List<Music> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
        mResource = resId;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData != null ? mData.get(position): null ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(mResource, parent, false);
        }

        Music item = mData.get(position);

        TextView title = (TextView) convertView.findViewById(R.id.listen_music_name);
        title.setText(item.getName());

        TextView createTime = (TextView) convertView.findViewById(R.id.listen_length);

        String times = MusicUtils.convertMSecendToTime(item.getDuration());
        times = String.format(mContext.getString(R.string.duration), times);
        createTime.setText(times);

        ImageView thumb = (ImageView) convertView.findViewById(R.id.record);


        return convertView;
    }
}
