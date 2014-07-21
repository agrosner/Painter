package com.grosner.painter.slider;

import com.grosner.painter.Painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Slides the passed in objects that can change color.
 */
public class ColorSlider implements PropertySlider {

    /**
     * the color that the background drawable will start at when slide is 0
     */
    private int mStartColor;

    /**
     * the color that the background drawable will be when the slide is 1
     */
    private int mEndColor;

    /**
     * This will tell this class how to paint the colors
     */
    private Painter mPainter;

    /**
     * The current color that we are displaying
     */
    private int mCurrentColor;

    /**
     * Constructs a new instance
     * @param mStartColor - the color that the background drawable will start at when slide is 0
     * @param mEndColor - the color that the background drawable will be when the slide is 1
     */
    public ColorSlider(int mStartColor, int mEndColor) {
        this.mStartColor = mStartColor;
        this.mEndColor = mEndColor;
    }

    /**
     * This needs to get called so we know how to paint the view.
     * @param painter - an {@link com.grosner.painter.IconPainter},
     *                {@link com.grosner.painter.BackgroundPainter}
     *                or your own custom {@link com.grosner.painter.Painter}
     * @return
     */
    public ColorSlider with(Painter painter){
        mPainter = painter;
        return this;
    }

    /**
     * Changes the start color of this slider
     * @param mStartColor
     */
    public void setStartColor(int mStartColor) {
        this.mStartColor = mStartColor;
    }

    /**
     * Changes the end color of the slider
     * @param mEndColor
     */
    public void setEndColor(int mEndColor) {
        this.mEndColor = mEndColor;
    }

    /**
     * the color that the background drawable will start at when slide is 0
     * @return
     */
    public int getStartColor() {
        return mStartColor;
    }

    /**
     * the color that the background drawable will start at when slide is 1
     * @return
     */
    public int getEndColor() {
        return mEndColor;
    }

    /**
     * The current color that we are displaying
     * @return
     */
    public int getCurrentColor() {
        return mCurrentColor;
    }

    @Override
    public void onSlide(float slideOffset, Object... objects) {
        if(mPainter==null){
            throw new IllegalStateException("Color slider needs a Painter class to know how to paint the color!");
        }

        mCurrentColor = SliderUtils.calculateColor(slideOffset, mStartColor, mEndColor);
        for(Object drawable: objects) {
            SliderUtils.checkForActionBarObject(drawable);
            mPainter.paintColor(false, mCurrentColor, drawable);
        }
    }
}
