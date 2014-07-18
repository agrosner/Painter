package com.grosner.painter.slider;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;

import com.grosner.painter.exception.UseActionBarSliderException;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description:
 */
public class SliderUtils {

    /**
     * Based on how the drawer slides, this will calculate what color to display.
     * @param slideOffset
     * @param mStartColor
     * @param mEndColor
     * @return
     */
    public static int calculateColor(float slideOffset, int mStartColor, int mEndColor){
        int red = (int)Math.abs((slideOffset * Color.red(mEndColor)) + ((1 - slideOffset) * Color.red(mStartColor)));
        int green = (int)Math.abs((slideOffset * Color.green(mEndColor)) + ((1 - slideOffset) * Color.green(mStartColor)));
        int blue = (int)Math.abs((slideOffset * Color.blue(mEndColor)) + ((1 - slideOffset) * Color.blue(mStartColor)));
        return Color.rgb(red, green, blue);
    }

    /**
     * This will check to make sure the object is not an actionbar
     * @param object
     */
    static void checkForActionBarObject(Object object){
        boolean isActionBar;
        isActionBar = (object instanceof ActionBar);
        if(!isActionBar && Build.VERSION.SDK_INT>=11){
            isActionBar = (object instanceof android.app.ActionBar);
        }

        if(isActionBar){
            throw new UseActionBarSliderException();
        }
    }
}
