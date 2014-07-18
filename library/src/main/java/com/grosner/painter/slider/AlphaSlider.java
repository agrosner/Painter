package com.grosner.painter.slider;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description: Applies an alpha to the object passed (view or MenuItem's ActionView background) based on a slideOffset (0...1).
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
    public void onSlide(float slideOffset, Object... objects) {
        for(Object o: objects){
            applyAlpha(255 * slideOffset, o);
        }
    }

    private void applyAlpha(float alpha, Object object){
        Drawable drawable = null;
        if(object instanceof View){
            drawable = ((View) object).getBackground();
        } else if(object instanceof MenuItem){
            if(((MenuItem) object).getActionView()!=null) {
                drawable = ((MenuItem) object).getActionView().getBackground();
            }
        }

        if(drawable!=null){
            drawable.setAlpha((int) alpha);
        } else{
            throw new RuntimeException("Could not find a background to change alpha with: " + object.getClass().getName());
        }
    }


}
