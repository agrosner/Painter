package com.grosner.painter.exception;

/**
 * Created by: andrewgrosner
 * Date: 7/17/14.
 * Contributors: {}
 * Description: This is called when an object you pass into the painter classes is null.
 */
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(Class clazz) {
        super("Parameter cannot be null for: " +clazz.getSimpleName());
    }
}
