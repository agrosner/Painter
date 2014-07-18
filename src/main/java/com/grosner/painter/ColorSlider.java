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
        int color = SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor);
        for(Object drawable: drawables) {
            mPainter.paint(drawable, color);
        }
    }
}
