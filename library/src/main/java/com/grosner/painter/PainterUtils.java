package com.grosner.painter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public class PainterUtils {

    /**
     * This method will check to see if the drawable is null or instance of {@link android.graphics.drawable.ColorDrawable}
     * (see {@link android.graphics.drawable.ColorDrawable#setColorFilter(int, android.graphics.PorterDuff.Mode)},
     * if so it will create one. Otherwise this will see if cloneDrawable is true and clone the drawable.
     * @param cloneDrawable - whether to clone the drawable found
     * @param paint - the paint to initialize the new color drawable with
     * @param drawable - the drawable from an object
     * @return - fully created drawable
     */
    public static Drawable getDrawable(boolean cloneDrawable, int paint, Drawable drawable){
        Drawable retDrawable;
        if(drawable==null || drawable instanceof ColorDrawable){
            retDrawable = new ColorDrawable(paint);
        } else if(cloneDrawable){
            retDrawable = drawable.getCurrent().getCurrent();
        } else{
            retDrawable = drawable;
        }
        return retDrawable;
    }
}
