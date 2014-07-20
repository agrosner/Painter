package com.grosner.painter.slider;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: This interface provides a simple base implementation that passes in a slide value from 0...1
 */
public interface PropertySlider {

    /**
     * Call this when your drawer, sliding pane, or another transforming view slides. The offset should be [0..1].
     * @param slideOffset - a percentage from 0...1
     * @param objects - the objects we want to apply this to.
     */
    public void onSlide(float slideOffset, Object...objects);
}
