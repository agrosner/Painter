package com.grosner.painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: The main interface to paint a view/menuitem/actionbar.
 */
public abstract class Painter {

    int mColor;


    public Painter() {
    }

    public void paint(Object viewObject) {
        paint(viewObject, mColor);
    }

    public abstract void paint(Object viewObject, int paint);

}