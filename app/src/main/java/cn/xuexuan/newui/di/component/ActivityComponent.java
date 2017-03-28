package cn.xuexuan.newui.di.component;

import android.app.Activity;

import javax.inject.Singleton;

import cn.xuexuan.newui.di.module.ActivityModule;
import cn.xuexuan.newui.ui.ZhiHuActivity;
import dagger.Component;

/**
 * Created by Jant on 2017/3/28.
 */
@Singleton
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent  {

    Activity getActivity();
    void inject(ZhiHuActivity zhiHuActivity);

}
