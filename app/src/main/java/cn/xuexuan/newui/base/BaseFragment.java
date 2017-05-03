package cn.xuexuan.newui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Jant on 2017/5/3.
 */

public abstract class BaseFragment<T extends BaseVM> extends SupportFragment implements BaseView {

    @Inject
    protected T mViewModel;


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

    public abstract int getLayout();

    public abstract void initEventAndData();

    public abstract void initInject();




}
