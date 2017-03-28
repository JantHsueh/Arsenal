package cn.xuexuan.newui.base;

/**
 * Created by Jant on 2017/3/27.
 */

public class BaseViewModel <T extends BaseView> implements BaseVM<T> {

    private T mView;


    @Override
    public void attachView(T view) {
        this.mView = view;
    }


}
