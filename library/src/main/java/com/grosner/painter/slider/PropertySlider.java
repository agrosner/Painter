package com.grosner.painter.slider;

import android.graphics.drawable.Drawable;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description:
 */
public interface PropertySlider {

    public void onSlide(float slideOffset, Object...drawables);
}
