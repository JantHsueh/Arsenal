package cn.xuexuan.newui.viewmodel;

import javax.inject.Inject;

import cn.xuexuan.newui.base.BaseViewModel;
import cn.xuexuan.newui.viewmodel.contract.MainContract;

/**
 * Created by Jant on 2017/5/4.
 */

public class MainViewModel extends BaseViewModel<MainContract.View> implements MainContract.ViewModel {


    @Inject
    public MainViewModel() {
    }

    @Override
    public void detachView() {

    }

}
