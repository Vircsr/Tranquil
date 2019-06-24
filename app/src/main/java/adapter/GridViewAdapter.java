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

/**
 * 用来在 FragmentDiscover 即发现页面 加载服务端的图片，并展示在GridView
 * 参考：https://blog.csdn.net/qq_36243942/article/details/82178388
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public GridViewAdapter(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView gridImageview;
        public TextView gridTextView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.grid_item,null);
            viewHolder= new ViewHolder();
            viewHolder.gridImageview=convertView.findViewById(R.id.grid_id);
            viewHolder.gridTextView=convertView.findViewById(R.id.grid_id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.gridTextView.setText("歌曲");
        Glide.with
        return null;
    }
}
