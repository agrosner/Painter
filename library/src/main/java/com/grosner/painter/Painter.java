package com.grosner.painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: The main interface to paintColor a view/menuitem/actionbar.
 */
public abstract class Painter {

    int mColor;


    public Painter() {
    }

    public void paint(Object...viewObjects) {
        paintColor(mColor, viewObjects);
    }

    public abstract void paintColor(int paint, Object... viewObjects);

}