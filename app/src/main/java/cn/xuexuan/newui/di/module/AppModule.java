package cn.xuexuan.newui.di.module;

import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.model.http.RetrofitHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jant on 2017/3/28.
 */

@Module
public class AppModule {

    private final App application;


    public AppModule( App application) {

        this.application = application;
    }


    @Provides
    App provideApplication(){
     return application;
    }

    @Provides
//    @Singleton
    public RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

//    @Provides
//    @Singleton
//    RealmHelper provideRealmHelper() {
//        return new RealmHelper(application);
//    }

}
