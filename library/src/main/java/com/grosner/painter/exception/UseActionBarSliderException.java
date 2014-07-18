package com.grosner.painter.exception;

/**
 * Created by: andrewgrosner
 * Date: 7/18/14.
 * Contributors: {}
 * Description:
 */
public class UseActionBarSliderException extends RuntimeException {
    public UseActionBarSliderException() {
        super("You must use an ActionBarSlider in order to use these features on an ActionBar");
    }
}
