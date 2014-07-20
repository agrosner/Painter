package com.grosner.painter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.grosner.painter.exception.InvalidParameterException;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Paints an icon on an image into a specific color
 */
public class IconPainter extends Painter{

    /**
     * Basic constructor meant for Sliders
     */
    public IconPainter() {
    }

    /**
     * Constructs the painter with a non-resource-color value
     * @param color - must be a hex color value
     */
    public IconPainter(int color) {
        mColor = color;
    }

    @Override
    public void paintColor(int paint, Object... objects) {
        for(Object o: objects){
            paint(o, paint);
        }
    }

    /**
     * Paint the passed color (non-resource value) on the object
     * @param object - ImageView, MenuItem's Icon, TextView's first available CompoundDrawables
     * @param paint
     */
    private void paint(Object viewObject,int paint){
        if(viewObject!=null) {
            Drawable drawable = null;
            if (viewObject instanceof ImageView) {
                drawable = ((ImageView) viewObject).getDrawable();
            } else if (viewObject instanceof TextView) {
                Drawable[] drawables = ((TextView) viewObject).getCompoundDrawables();

                //for now will only take the first one it finds
                for (Drawable d : drawables) {
                    if (d != null) {
                        drawable = d;
                        break;
                    }
                }
            } else if (viewObject instanceof MenuItem) {
                drawable = ((MenuItem) viewObject).getIcon();
            }

            if (drawable != null) {
                drawable.setColorFilter(paint, PorterDuff.Mode.MULTIPLY);
            } else {
                throw new RuntimeException("Could not find an icon to paint with: " + viewObject.getClass().getName());
            }
        } else{
            throw new InvalidParameterException(getClass());
        }
    }
}
