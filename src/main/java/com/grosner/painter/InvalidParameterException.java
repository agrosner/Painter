package com.grosner.painter;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description:
 */
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(Class clazz) {
        super("Parameter cannot be null for: " +clazz.getSimpleName());
    }
}
