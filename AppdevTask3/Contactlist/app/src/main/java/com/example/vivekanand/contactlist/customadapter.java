package com.example.vivekanand.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Vivekanand on 08-07-2016.
 */
public class customadapter extends BaseAdapter {
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public customadapter(Main5Activity mainActivity, int[] prgmImages) {
        // TODO Auto-generated constructor stub

        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View customview;
        customview = inflater.inflate(R.layout.customrow, null);

        ImageView img=(ImageView) customview.findViewById(R.id.imageView);

        img.setImageResource(imageId[position]);

        return customview;
    }

}
