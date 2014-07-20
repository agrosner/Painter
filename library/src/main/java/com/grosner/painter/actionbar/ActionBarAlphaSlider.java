package com.grosner.painter.actionbar;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description: Since the ActionBar's background drawable is not accessible without reflection,
 * we create a custom Slider to handle this special case.
 */
public class ActionBarAlphaSlider extends ActionBarSlider{

    /**
     * This property, when true, will show the full color of the object initially
     * before sliding it to invisible. The reverse is false.
     */
    private boolean mStartFullAlpha;

    /**
     * Constructs this slider
     * @param startFullAlpha - This property, when true, will show the full color of the object initially
     * before sliding it to invisible. The reverse is false.
     * @param actionBar - support or native ActionBar class
     * @param fullColor - the color that the background drawable will be
     */
    public ActionBarAlphaSlider(boolean startFullAlpha, Object actionBar, int fullColor){
        super(fullColor);
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
