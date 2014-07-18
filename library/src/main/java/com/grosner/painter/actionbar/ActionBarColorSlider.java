package com.grosner.painter.actionbar;

import android.graphics.PorterDuff;

import com.grosner.painter.utils.SliderUtils;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description:
 */
public class ActionBarColorSlider extends ActionBarSlider{

    private final int mEndColor;

    public ActionBarColorSlider(Object actionBar, int startColor, int endColor){
        super(startColor);
        mEndColor = endColor;
        setBackgroundDrawable(actionBar);
    }

    @Override
    public void onSlide(float slideOffset) {
        mDrawable.setColorFilter(SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor), PorterDuff.Mode.MULTIPLY);
    }
}
