package cn.xuexuan.newui.app;

import android.app.Application;

import cn.xuexuan.newui.di.component.AppComponent;
import cn.xuexuan.newui.di.component.DaggerAppComponent;
import cn.xuexuan.newui.di.module.AppModule;

/**
 * Created by Jant on 2017/3/28.
 */

public class App extends Application {



    public static App sInstance;
    public static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }

    public static AppComponent getAppComponent(){


        if (appComponent == null) {
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule(sInstance))
                    .build();
        }
        return appComponent;
    }


}
