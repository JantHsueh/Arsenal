package cn.xuexuan.newui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.di.component.DaggerFragmentComponent;
import cn.xuexuan.newui.di.component.FragmentComponent;
import cn.xuexuan.newui.di.module.FragmentModule;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Jant on 2017/5/3.
 */

public abstract class BaseFragment<T extends BaseVM> extends SupportFragment implements BaseView {

    @Inject
    protected T mViewModel;
    protected AppCompatActivity mActivity;


    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof AppCompatActivity) {
            mActivity = (AppCompatActivity) activity;
        }
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View lView = inflater.inflate(getLayout(), null);
        initInject();
        return lView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.attachView(this);
        initEventAndData();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mViewModel != null) {
            mViewModel.detachView();

        }
    }



    protected void setTools(Toolbar toolbar){
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public FragmentComponent getFragmentComponent() {

        return DaggerFragmentComponent
                .builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();

    }

    public abstract int getLayout();

    public abstract void initEventAndData();

    public abstract void initInject();

}
