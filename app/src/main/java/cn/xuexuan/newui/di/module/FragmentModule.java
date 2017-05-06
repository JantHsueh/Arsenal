package cn.xuexuan.newui.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import cn.xuexuan.newui.di.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jant on 2017/5/4.
 */

@FragmentScope
@Module
public class FragmentModule {

    Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return mFragment.getActivity();
    }
}
