package com.grosner.painter;

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
     * Default constructor
     */
    public Painter() {
    }

    /**
     * Paints the color, passing in its own color and objects
     * @param objects
     */
    public void paint(Object...objects) {
        paintColor(mColor, objects);
    }

    /**
     * Paint the color in this method to all of the objects passed in
     * @param paint - the hex-value color
     * @param objects - depends on painting class on what it can accept
     */
    public abstract void paintColor(int paint, Object... objects);

}