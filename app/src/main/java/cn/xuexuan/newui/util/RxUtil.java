package cn.xuexuan.newui.util;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jant on 2017/4/19.
 */

public class RxUtil {

    public static <T>ObservableTransformer<T,T> rxSchedulerHelper(){
        return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
