package com.grosner.painter.slider;

import com.grosner.painter.Painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Slides the passed in objects that can change color.
 */
public class ColorSlider implements PropertySlider {

    private int mStartColor, mEndColor;

    private Painter mPainter;

    private int mCurrentColor;

    public ColorSlider(int mStartColor, int mEndColor) {
        this.mStartColor = mStartColor;
        this.mEndColor = mEndColor;
    }

    public ColorSlider with(Painter painter){
        mPainter = painter;
        return this;
    }

    public void setStartColor(int mStartColor) {
        this.mStartColor = mStartColor;
    }

    public void setEndColor(int mEndColor) {
        this.mEndColor = mEndColor;
    }

    public int getStartColor() {
        return mStartColor;
    }

    public int getEndColor() {
        return mEndColor;
    }

    public int getCurrentColor() {
        return mCurrentColor;
    }

    @Override
    public void onSlide(float slideOffset, Object...drawables) {
        if(mPainter==null){
            throw new IllegalStateException("Color slider needs a Painter class to know how to paint the color!");
        }

        mCurrentColor = SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor);
        for(Object drawable: drawables) {
            SliderUtils.checkForActionBarObject(drawable);
            mPainter.paintColor(mCurrentColor, drawable);
        }
    }
}
