package com.grosner.painter;

import android.os.Build;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public class Utils {

    public static boolean isHoneyComb(){
        return Build.VERSION.SDK_INT>=11;
    }
}
