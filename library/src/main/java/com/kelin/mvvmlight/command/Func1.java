package com.kelin.mvvmlight.command;

/**
 * Created by Jant on 2017/4/17.
 */

public interface Func1<T, R>  {
    R call(T t);
}