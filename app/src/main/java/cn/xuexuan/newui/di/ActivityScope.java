package cn.xuexuan.newui.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jant on 2017/3/28.
 */


@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
