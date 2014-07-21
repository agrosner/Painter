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
        super(false);
    }

    /**
     * Stores the color of the paint.
     * @param mColor - non-color-resource value.
     */
    public BackgroundPainter(int mColor) {
        this(false, mColor);
    }

    /**
     * Stores the color of the paint.
     * @param cloneDrawable - whether we want to reuse a drawable globally,
     *                      or clone it for the specific object. Default is false.
     * @param mColor - non-color-resource value.
     *
     */
    public BackgroundPainter(boolean cloneDrawable, int mColor){
        super(cloneDrawable);
        this.mColor = mColor;
    }

    /**
     * The {@link android.graphics.PorterDuff.Mode} mode that you can set to fill the color on the view with.
     * @param mode
     * @return
     */
    public BackgroundPainter withMode(PorterDuff.Mode mode){
        mMode = mode;
        return this;
    }

    @Override
    public void paintColor(boolean cloneDrawable, int paint, Object... objects) {
        for(Object viewObject: objects){
            paint(cloneDrawable, viewObject, paint);
        }
    }

    /**
     * Paint the passed color (non-resource value) on the object
     * @param cloneDrawable - whether we want to reuse a drawable globally, or clone it for the specific object
     * @param object - View, MenuItem's ActionView, ActionBar, or Drawable
     * @param paint
     */
    public void paint(boolean cloneDrawable, Object object, int paint) {
        if(object!=null){
            Drawable drawable = null;
            if(object instanceof Drawable){
                // we will not copy it here since we will assume a global change
                drawable = (Drawable) object;
            } else if(object instanceof View || object instanceof MenuItem){
                View view = null;
                if(object instanceof MenuItem && Utils.isHoneyComb()){
                    view = ((MenuItem) object).getActionView();
                } else if(object instanceof View){
                    view = ((View) object);
                }
                if(view!=null) {
                    drawable = view.getBackground();

                    //color drawables do not have a colorfilter option
                    if (drawable == null || drawable instanceof ColorDrawable) {
                        drawable = new ColorDrawable(paint);
                        view.setBackgroundDrawable(drawable);
                    } else if (cloneDrawable) {
                        drawable = drawable.getConstantState().newDrawable();
                        view.setBackgroundDrawable(drawable);
                    }
                }
            } else if(object instanceof ActionBar){
                drawable = new ColorDrawable(paint);
                ((ActionBar) object).setBackgroundDrawable(drawable);
            } else if(Utils.isHoneyComb() && object instanceof android.app.ActionBar){
                drawable = new ColorDrawable(paint);
                ((android.app.ActionBar) object).setBackgroundDrawable(drawable);
            } else{
                throw new RuntimeException("Could not find a background to paintColor with: " + object.getClass().getName());
            }

            if(drawable!=null) {
                drawable.setColorFilter(paint, mMode);
            } else {
                throw new RuntimeException("Could not find a background to paint with: " + object.getClass().getName());
            }
        } else{
            throw new InvalidParameterException(getClass());
        }
    }
}
