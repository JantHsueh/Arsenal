package cn.xuexuan.newui.di.module;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jant on 2017/3/28.
 */

@Module
public class ActivityModule {


    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Singleton
    @Provides
    Activity getActivity(){
        return mActivity;
    }

}
