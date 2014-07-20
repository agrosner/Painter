package com.grosner.painter;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;

import com.grosner.painter.exception.InvalidParameterException;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Paints the color on the BG drawable of an object.
 * This will find the background drawable of a view, menuitem's ActionView, or set one on an ActionBar.
 */
public class BackgroundPainter extends Painter{

    /**
     * Basic constructor meant for Sliders
     */
    public BackgroundPainter() {
    }

    /**
     * Stores the color of the paint.
     * @param mColor - non-color-resource value.
     */
    public BackgroundPainter(int mColor) {
        this.mColor = mColor;
    }

    @Override
    public void paintColor(int paint, Object... objects) {
        for(Object viewObject: objects){
            paint(viewObject, paint);
        }
    }

    /**
     * Paint the passed color (non-resource value) on the object
     * @param object - View, MenuItem's ActionView, ActionBar, or Drawable
     * @param paint
     */
    public void paint(Object object, int paint) {
        if(object!=null){
            Drawable drawable;
            if(object instanceof Drawable){
                drawable = (Drawable) object;
            } else if(object instanceof View){
                drawable = ((View) object).getBackground();
                if(drawable==null){
                    drawable = new ColorDrawable(paint);
                    ((View) object).setBackgroundDrawable(drawable);
                }
            } else if(object instanceof MenuItem && ((MenuItem) object).getActionView()!=null){
                drawable = ((MenuItem) object).getActionView().getBackground();
            } else if(object instanceof ActionBar){
                drawable = new ColorDrawable(paint);
                ((ActionBar) object).setBackgroundDrawable(drawable);
            } else if(Build.VERSION.SDK_INT>=11 && object instanceof android.app.ActionBar){
                drawable = new ColorDrawable(paint);
                ((android.app.ActionBar) object).setBackgroundDrawable(drawable);
            } else{
                throw new RuntimeException("Could not find a background to paintColor with: " + object.getClass().getName());
            }

            drawable.setColorFilter(paint, PorterDuff.Mode.MULTIPLY);
        } else{
            throw new InvalidParameterException(getClass());
        }
    }
}
