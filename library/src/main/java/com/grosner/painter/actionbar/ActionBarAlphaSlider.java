package com.grosner.painter.actionbar;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description: Since the ActionBar's background drawable is not accessible without reflection,
 * we create a custom Slider to handle this special case.
 */
public class ActionBarAlphaSlider extends ActionBarSlider{

    private boolean mStartFullAlpha;

    public ActionBarAlphaSlider(boolean startFullAlpha, Object actionBar, int startColor){
        super(startColor);
        mStartFullAlpha = startFullAlpha;
        setBackgroundDrawable(actionBar);
        onSlide(0);
    }

    @Override
    public void onSlide(float slideOffset){
        int alpha = (int) (255 * slideOffset);
        if(!mStartFullAlpha) {
            mDrawable.setAlpha(alpha);
        } else{
            mDrawable.setAlpha(255 - alpha);
        }
    }
}
