package cn.xuexuan.newui.base;

/**
 * Created by Jant on 2017/3/28.
 */

public interface BaseVM<T extends  BaseView> {

    void attachView(T view);

}
