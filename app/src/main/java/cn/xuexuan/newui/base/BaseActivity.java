package cn.xuexuan.newui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.di.component.ActivityComponent;
import cn.xuexuan.newui.di.component.DaggerActivityComponent;
import cn.xuexuan.newui.di.module.ActivityModule;

/**
 * Created by Jant on 2017/3/27.
 */

public abstract class BaseActivity<T extends BaseVM> extends AppCompatActivity implements BaseView {


    @Inject
    protected T mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initInject();
        if (mViewModel != null)
            mViewModel.attachView(this);

        initEventAndData();
    }


    protected ActivityComponent getActivityComponent(){

        return  DaggerActivityComponent
                .builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }
//


}
