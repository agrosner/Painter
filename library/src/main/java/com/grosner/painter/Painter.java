package com.grosner.painter;

import android.graphics.PorterDuff;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: The main interface to paint a color on some object.
 */
public abstract class Painter {

    /**
     * The color to paint
     */
    protected int mColor;

    /**
     * whether we want to reuse a drawable globally, or clone it for the specific object
     */
    protected boolean cloneDrawable;

    /**
     * The {@link android.graphics.PorterDuff.Mode} mode that you can set to fill the color on the view with.
     */
    protected PorterDuff.Mode mMode = PorterDuff.Mode.MULTIPLY;

    /**
     * Default constructor
     * @param - whether we want to reuse a drawable globally, or clone it for the specific object
     */
    public Painter(boolean cloneDrawable) {
        this.cloneDrawable = cloneDrawable;
    }

    /**
     * Paints the color, passing in its own color and objects
     * @param objects
     */
    public void paint(Object...objects) {
        paintColor(cloneDrawable, mColor, objects);
    }

    /**
     * Paint the color in this method to all of the objects passed in
     * @param paint - the hex-value color
     * @param objects - depends on painting class on what it can accept
     */
    public abstract void paintColor(boolean cloneDrawable, int paint, Object... objects);

}