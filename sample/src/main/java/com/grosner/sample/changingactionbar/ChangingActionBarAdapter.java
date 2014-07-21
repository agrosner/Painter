package com.grosner.sample.changingactionbar;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public class ChangingActionBarAdapter extends PagerAdapter {

    Random mRandom;

    private ArrayList<Integer> mColors;

    public ChangingActionBarAdapter(){
        mRandom = new Random();
        mColors = new ArrayList<Integer>();
        for(int i = 0 ; i < getCount(); i++){
            mColors.add(getItem());
        }
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = new View(container.getContext());
        view.setBackgroundColor(getColor(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public Integer getItem() {
        return Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
    }

    public Integer getColor(int position){
        if(position<getCount()) {
            return mColors.get(position);
        } else{
            return mColors.get(mColors.size()-1);
        }
    }

}
