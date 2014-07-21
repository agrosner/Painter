package com.grosner.sample.colorfulgrid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.grosner.painter.IconPainter;
import com.grosner.painter.Painter;
import com.grosner.sample.R;
import com.grosner.sample.adapter.RandomColorAdapter;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description: This displays the power of Painter. The imageview needs only to set its
 * drawable once its created and painter will paint a new color with the same drawable.
 */
public class ColorfulGridAdapter extends RandomColorAdapter {

    Painter mPainter;

    public ColorfulGridAdapter(){
        super();
        mPainter = new IconPainter();
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
