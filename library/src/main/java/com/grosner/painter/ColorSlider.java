package com.grosner.painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Slides the passed in objects that can change color.
 */
public class ColorSlider implements PropertySlider{

    private final int mStartColor, mEndColor;

    private Painter mPainter;

    public ColorSlider(int mStartColor, int mEndColor) {
        this.mStartColor = mStartColor;
        this.mEndColor = mEndColor;
    }

    public ColorSlider with(Painter painter){
        mPainter = painter;
        return this;
    }

    @Override
    public void onSlide(float slideOffset, Object...drawables) {
        if(mPainter==null){
            throw new IllegalStateException("Color slider needs a Painter class to know how to paint the color!");
        }

        int color = SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor);
        for(Object drawable: drawables) {
            mPainter.paintColor(color, drawable);
        }
    }
}
