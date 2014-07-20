package com.grosner.painter.actionbar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;

import com.grosner.painter.exception.InvalidParameterException;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description: Extend this class to do something with the actionbar when a drawer slides.
 */
public abstract class ActionBarSlider {

    /**
     * The drawable that the actionbar uses
     */
    protected Drawable mDrawable;

    /**
     * The initial color of the drawable
     */
    protected int mStartColor;

    /**
     * Call this when your drawer, sliding pane, or another transforming view slides. The offset should be [0..1].
     * @param slideOffset - a percentage from 0...1
     */
    public abstract void onSlide(float slideOffset);

    /**
     * Constructer that initializes the background drawable of the ActionBar and sets the start color.
     * @param startColor - The color of the drawable that the actionbar uses
     */
    public ActionBarSlider(int startColor){
        mDrawable = new ColorDrawable(startColor);
        mStartColor = startColor;
    }

    /**
     * Call this method in your constructor to set the drawable to the appropriate type.
     * @param actionBar
     */
    protected void setBackgroundDrawable(Object actionBar){
        if(actionBar==null){
            throw new InvalidParameterException(getClass());
        }
        if(actionBar instanceof ActionBar){
            ((ActionBar) actionBar).setBackgroundDrawable(mDrawable);
        } else if(Build.VERSION.SDK_INT>=11 && actionBar instanceof android.app.ActionBar){
            ((android.app.ActionBar) actionBar).setBackgroundDrawable(mDrawable);
        }
    }
}
