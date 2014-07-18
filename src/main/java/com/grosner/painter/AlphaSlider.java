package com.grosner.painter;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description:
 */
public class AlphaSlider implements PropertySlider {

    private final boolean mStartFullAlpha;

    /**
     * Constructs this slider.
     * @param startFullAlpha - start with full color then slide to no alpha,
     *                       otherwise it will start with alpha, and go to full color.
     */
    public AlphaSlider(boolean startFullAlpha){
        mStartFullAlpha = startFullAlpha;
    }

    @Override
    public void onSlide(float slideOffset, Object... drawables) {
        
    }
}
