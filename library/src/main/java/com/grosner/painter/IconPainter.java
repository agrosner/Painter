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
        super(false);
    }

    /**
     * Constructs the painter with a non-resource-color value
     * @param color - must be a hex color value
     */
    public IconPainter(int color) {
        this(false, color);
    }

    /**
     * Constructs the painter with a non-resource-color value
     * @param cloneDrawable - whether we want to reuse a drawable globally, or clone it for the specific object
     * @param color - must be a hex color value
     */
    public IconPainter(boolean cloneDrawable, int color) {
        super(cloneDrawable);
        mColor = color;
    }

    /**
     * The {@link android.graphics.PorterDuff.Mode} mode that you can set to fill the color on the view with.
     * @param mode
     * @return
     */
    public IconPainter withMode(PorterDuff.Mode mode){
        mMode = mode;
        return this;
    }

    @Override
    public void paintColor(boolean cloneDrawable, int paint, Object... objects) {
        for(Object o: objects){
            paint(cloneDrawable, o, paint);
        }
    }

    /**
     * Paint the passed color (non-resource value) on the object
     * @param cloneDrawable - whether we want to reuse a drawable globally, or clone it for the specific object
     * @param viewObject - ImageView, MenuItem's Icon, TextView's first available CompoundDrawables
     * @param paint
     */
    private void paint(boolean cloneDrawable, Object viewObject,int paint){
        if(viewObject!=null) {
            Drawable drawable = null;
            if (viewObject instanceof ImageView) {
                drawable = PainterUtils.getDrawable(cloneDrawable, paint, ((ImageView) viewObject).getDrawable());
                ((ImageView) viewObject).setImageDrawable(drawable);
            } else if (viewObject instanceof TextView) {
                Drawable[] drawables = ((TextView) viewObject).getCompoundDrawables();

                //for now will only take the first one it finds
                for (int i = 0; i < drawables.length; i++) {
                    Drawable d = drawables[i];
                    if (d != null) {
                        drawable = d;
                        drawables[i] = PainterUtils.getDrawable(cloneDrawable, paint, d);
                        break;
                    }
                }
                ((TextView) viewObject).setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
            } else if (viewObject instanceof MenuItem) {
                drawable = PainterUtils.getDrawable(cloneDrawable, paint,((MenuItem) viewObject).getIcon());
                ((MenuItem) viewObject).setIcon(drawable);
            }

            if (drawable != null) {
                drawable.setColorFilter(paint, mMode);
            } else {
                throw new RuntimeException("Could not find an icon to paint with: " + viewObject.getClass().getName());
            }
        } else{
            throw new InvalidParameterException(getClass());
        }
    }
}
