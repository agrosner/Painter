package com.grosner.painter;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description:
 */
public class BackgroundPainter extends Painter{

    public BackgroundPainter() {
    }

    public BackgroundPainter(int mColor) {
        this.mColor = mColor;
    }

    @Override
    public void paintColor(int paint, Object... viewObjects) {
        for(Object viewObject: viewObjects){
            paint(viewObject, paint);
        }
    }

    public void paint(Object viewObject, int paint) {
        if(viewObject!=null){
            Drawable drawable;
            if(viewObject instanceof View){
                drawable = ((View) viewObject).getBackground();
                if(drawable==null){
                    drawable = new ColorDrawable(paint);
                    ((View) viewObject).setBackgroundDrawable(drawable);
                }
            } else if(viewObject instanceof MenuItem && ((MenuItem) viewObject).getActionView()!=null){
                drawable = ((MenuItem) viewObject).getActionView().getBackground();
            } else if(viewObject instanceof ActionBar){
                drawable = new ColorDrawable(paint);
                ((ActionBar) viewObject).setBackgroundDrawable(drawable);
            } else if(Build.VERSION.SDK_INT>=11 && viewObject instanceof android.app.ActionBar){
                drawable = new ColorDrawable(paint);
                ((android.app.ActionBar) viewObject).setBackgroundDrawable(drawable);
            } else{
                throw new RuntimeException("Could not find a background to paintColor with: " + viewObject.getClass().getName());
            }

            drawable.setColorFilter(paint, PorterDuff.Mode.MULTIPLY);
        } else{
            throw new InvalidParameterException(getClass());
        }
    }
}
