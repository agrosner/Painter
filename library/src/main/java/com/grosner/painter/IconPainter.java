package com.grosner.painter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: Paints an icon on an image into a specific color
 */
public class IconPainter extends Painter{

    public IconPainter() {
    }

    public IconPainter(int color) {
        mColor = color;
    }

    @Override
    public void paintColor(int paint, Object... viewObjects) {
        for(Object o: viewObjects){
            paint(o, paint);
        }
    }

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
