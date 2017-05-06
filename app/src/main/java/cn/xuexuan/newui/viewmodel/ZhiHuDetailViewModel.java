package cn.xuexuan.newui.viewmodel;

import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.List;

import javax.inject.Inject;

import cn.xuexuan.newui.base.BaseViewModel;
import cn.xuexuan.newui.model.http.RetrofitHelper;
import cn.xuexuan.newui.util.RxUtil;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuDetailContract;
import io.reactivex.Observable;

/**
 * Created by Jant on 2017/4/21.
 */

public class ZhiHuDetailViewModel extends BaseViewModel<ZhiHuDetailContract.View> implements ZhiHuDetailContract.ViewModel {

    private RetrofitHelper mRetrofitHelper;

    public final ObservableField<String> mImageUrl = new ObservableField<>();
    public final ObservableField<String> mHtml = new ObservableField<>();
    public final ObservableField<String> mTitle = new ObservableField<>();
    public final ObservableField<String> mIsRefreshing = new ObservableField(true);


    public final ReplyCommand mOnRefreshCommand = new ReplyCommand(() -> {

    });

    @Inject
    public ZhiHuDetailViewModel(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void loadNews(long id) {
        mRetrofitHelper.fetchZhiHuDetail(id)
                .doOnNext(zhiHuDetailBean ->mImageUrl.set(zhiHuDetailBean.getImage()))
                .doOnNext(zhiHuDetailBean ->mTitle.set(zhiHuDetailBean.getTitle()))
                .map(zhiHuDetailBean ->
                        zhiHuDetailBean.getBody()
                                + "<style type=\"text/css\">"
                                + loadHtmlCss(zhiHuDetailBean.getCss())
                                + "</style>")
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(mHtml::set);
    }


    private String loadHtmlCss(List<String> urls){

        final String[] css = new String[1];

        Observable.fromIterable(urls)
                .doOnNext(cssUrl -> mRetrofitHelper.getNewsDetailCss(cssUrl))
                .scan((s1, s2) -> s1 + s2)
                .last("null")
                .subscribe(s -> css[0] = s);

        return css[0];

    }

    @Override
    public void detachView() {

    }


}
