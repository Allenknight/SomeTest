package hsj.whatever.com.selfviewdemo.adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/6/25.
 * Version 1.0
 */

public class ListViewAdp extends BaseAdapter{

    List<String> myList;
    private LayoutInflater mInflater;

    public ListViewAdp(Context context, List<String> myList){
        mInflater = LayoutInflater.from(context);
        this.myList = myList;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_list_view, null);
            holder.mImg = (ImageView)convertView.findViewById(R.id.list_img_view);
            holder.mText = (TextView)convertView.findViewById(R.id.list_text_view);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder)convertView.getTag();
        }
        holder.mImg.setBackgroundResource(R.mipmap.ic_launcher);
        holder.mText.setText(myList.get(position));
        return convertView;
    }

    public final class ViewHolder{
        public ImageView mImg;
        public TextView mText;
    }

}
