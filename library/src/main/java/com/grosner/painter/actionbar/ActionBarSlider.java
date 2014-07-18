package com.grosner.painter.actionbar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description:
 */
public abstract class ActionBarSlider {

    protected Drawable mDrawable;

    protected int mStartColor;

    public abstract void onSlide(float slideOffset);

    public ActionBarSlider(int startColor){
        mDrawable = new ColorDrawable(startColor);
        mStartColor = startColor;
    }

    protected void setBackgroundDrawable(Object actionBar){
        if(actionBar instanceof ActionBar){
            ((ActionBar) actionBar).setBackgroundDrawable(mDrawable);
        } else if(actionBar instanceof android.app.ActionBar){
            ((android.app.ActionBar) actionBar).setBackgroundDrawable(mDrawable);
        }
    }
}
