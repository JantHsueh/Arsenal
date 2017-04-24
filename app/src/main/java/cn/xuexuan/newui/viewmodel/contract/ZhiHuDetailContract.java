package cn.xuexuan.newui.viewmodel.contract;

import cn.xuexuan.newui.base.BaseView;

/**
 * Created by Jant on 2017/4/21.
 */

public interface ZhiHuDetailContract {


    interface View extends BaseView {



    }


    interface ViewModel{

        //设置新闻的id
        void loadNews(long id);
    }
}
