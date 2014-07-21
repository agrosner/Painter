package com.grosner.sample.colorfulgrid;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.grosner.painter.IconPainter;
import com.grosner.painter.Painter;
import com.grosner.sample.R;

import java.util.Random;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public class ColorfulGridAdapter extends BaseAdapter {


    Random mRandom;

    Painter mPainter;

    public ColorfulGridAdapter(){
        mRandom = new Random();
        mPainter = new IconPainter();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer getItem(int position) {
        return Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view;
        if(convertView==null){
            view = new ImageView(parent.getContext());
            view.setImageDrawable(parent.getContext().getResources().getDrawable(R.drawable.ic_action_sun));
        } else{
            view = (ImageView) convertView;
        }
        mPainter.paintColor(true, getItem(position), view);
        return view;
    }
}
