package cn.xuexuan.newui.di.component;

import javax.inject.Singleton;

import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.di.module.AppModule;
import cn.xuexuan.newui.model.http.RetrofitHelper;
import dagger.Component;

/**
 * Created by Jant on 2017/3/28.
 */

@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {

    App getApplication();
    RetrofitHelper getRetrofitHelper();
}
