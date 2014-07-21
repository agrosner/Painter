package com.grosner.sample.adapter;

import android.graphics.Color;
import android.widget.BaseAdapter;

import java.util.Random;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public abstract class RandomColorAdapter extends BaseAdapter{

    Random mRandom;

    public RandomColorAdapter(){
        mRandom = new Random();
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

}
