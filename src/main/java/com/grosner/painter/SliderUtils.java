package com.grosner.painter;

import android.graphics.Color;

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
}
