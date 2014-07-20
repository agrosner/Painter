package com.grosner.painter.actionbar;

import android.graphics.PorterDuff;

import com.grosner.painter.slider.SliderUtils;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description: This slider will change the color of the actionbar from one color to another as
 * you slide a transforming view such as a drawer.
 */
public class ActionBarColorSlider extends ActionBarSlider{

    /**
     * The ending color when the ratio of the slide is 1
     */
    private final int mEndColor;

    /**
     * Constructs a new instance.
     * @param actionBar - support or native ActionBar class
     * @param startColor - the color that the background drawable will start at when slide is 0
     * @param endColor - the color that the background drawable will be when the slide is 1
     */
    public ActionBarColorSlider(Object actionBar, int startColor, int endColor){
        super(startColor);
        mEndColor = endColor;
        setBackgroundDrawable(actionBar);
    }

    @Override
    public void onSlide(float slideOffset) {
        mDrawable.setColorFilter(SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor),
                PorterDuff.Mode.MULTIPLY);
    }
}
