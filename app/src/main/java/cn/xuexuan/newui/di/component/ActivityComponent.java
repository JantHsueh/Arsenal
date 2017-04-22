package cn.xuexuan.newui.di.component;

import android.app.Activity;

import cn.xuexuan.newui.di.ActivityScope;
import cn.xuexuan.newui.di.module.ActivityModule;
import cn.xuexuan.newui.ui.ZhiHuActivity;
import cn.xuexuan.newui.ui.ZhiHuDetailActivity;
import dagger.Component;

/**
 * Created by Jant on 2017/3/28.
 */
@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent  {

    Activity getActivity();

    void inject(ZhiHuActivity zhiHuActivity);

    void inject(ZhiHuDetailActivity zhiHuDetailActivity);


}
