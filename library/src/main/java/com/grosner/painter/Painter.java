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

    public void paint(Object...viewObjects) {
        paint(mColor, viewObjects);
    }

    public abstract void paint(int paint, Object...viewObjects);

}