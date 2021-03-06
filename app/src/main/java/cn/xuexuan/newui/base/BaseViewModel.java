package cn.xuexuan.newui.base;

/**
 * Created by Jant on 2017/3/27.
 */

public abstract class BaseViewModel <T extends BaseView> implements BaseVM<T> {

    public T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

}
