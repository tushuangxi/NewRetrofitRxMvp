package com.xdw.retrofitrxmvpdemo.libding.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xdw.retrofitrxmvpdemo.R;
import com.xdw.retrofitrxmvpdemo.libding.application.PadApplication;
import com.xdw.retrofitrxmvpdemo.libding.util.Utils;
import com.xdw.retrofitrxmvpdemo.libding.weigit.view.MyBitmapImageViewTarget;

import java.util.List;


public class NewsImageAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public NewsImageAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_news_three_image, null);
            vh = new GridHolder();
            vh.image = (ImageView) convertView.findViewById(R.id.three_icon);

            convertView.setTag(vh);
        } else {
            vh = (GridHolder) convertView.getTag();
        }
        final String item = mList.get(position);

        Glide.with(PadApplication.getContext()).load(item).asBitmap().
                diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().
                placeholder(R.mipmap.homebg).into(new MyBitmapImageViewTarget(vh.image));


        //根据窗口设定自定义GridView的大小
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int wh = display.getWidth();
        int size = Utils.dip2px(mContext,2);
        int width = (wh - size * 2) / 3;
        ViewGroup.LayoutParams p = vh.image.getLayoutParams();
        p.height = width;
        p.width = ViewGroup.LayoutParams.MATCH_PARENT;
        vh.image.setLayoutParams(p);

        return convertView;
    }

    static class GridHolder {
        ImageView image;
    }
}
