package cn.xuexuan.newui.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.di.component.ActivityComponent;
import cn.xuexuan.newui.di.component.DaggerActivityComponent;
import cn.xuexuan.newui.di.module.ActivityModule;
import me.yokeyword.fragmentation.SupportActivity;


/**
 * Created by Jant on 2017/3/27.
 */

public abstract class BaseActivity<T extends BaseVM> extends SupportActivity implements BaseView {


    @Inject
    protected T mViewModel;
    private Unbinder mUnBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //填充布局的是否可以替换为DataBindingUtil.setContentView？？？
        setContentView(getLayout());

        initInject();
        if (mViewModel != null)
            mViewModel.attachView(this);

        mUnBinder = ButterKnife.bind(this);


        initEventAndData();
    }



    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    protected ActivityComponent getActivityComponent(){

        return  DaggerActivityComponent
                .builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }
//


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();

    }
}
