package cn.xuexuan.newui.di.component;

import android.app.Activity;

import cn.xuexuan.newui.di.FragmentScope;
import cn.xuexuan.newui.di.module.FragmentModule;
import cn.xuexuan.newui.ui.zhihu.ZhiHuFragment;
import dagger.Component;

/**
 * Created by Jant on 2017/5/4.
 */
@FragmentScope
@Component(modules = {FragmentModule.class}, dependencies = {AppComponent.class})
public interface FragmentComponent {

    Activity getActivity();

    void inject(ZhiHuFragment zhiHuFragment);
}
