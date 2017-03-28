package cn.xuexuan.newui.di.component;

import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.di.ActivityScope;
import cn.xuexuan.newui.di.module.AppModule;
import dagger.Component;

/**
 * Created by Jant on 2017/3/28.
 */

@ActivityScope
@Component(modules={AppModule.class})
public interface AppComponent {

    App getApplication();

}
