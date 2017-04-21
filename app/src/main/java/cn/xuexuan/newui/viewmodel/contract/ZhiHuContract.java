package cn.xuexuan.newui.viewmodel.contract;

import cn.xuexuan.newui.base.BaseView;

/**
 * Created by Jant on 2017/3/27.
 */

public interface ZhiHuContract {


    interface View extends BaseView {


        //Indicator must setViewPager after setAdapter,but data for ViewPager is load in other ViewModel
        void setViewPager();

    }

    interface ViewModel{

    }

}
