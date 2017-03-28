package cn.xuexuan.newui.viewmodel;

import javax.inject.Inject;

import cn.xuexuan.newui.base.BaseViewModel;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuContract;

/**
 * Created by Jant on 2017/3/27.
 */

public class ZhiHuViewModel extends BaseViewModel<ZhiHuContract.View> implements ZhiHuContract.ViewModel {


    @Inject
    public ZhiHuViewModel() {
    }
}
