package com.kelin.mvvmlight.command;

/**
 * Created by Jant on 2017/4/17.
 */

import java.util.concurrent.Callable;


/**
 * Represents a function with zero arguments.
 */
public interface Func0<R> extends Callable<R> {
    @Override
    R call();
}
