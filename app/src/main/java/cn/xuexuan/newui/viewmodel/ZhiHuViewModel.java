package cn.xuexuan.newui.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import cn.xuexuan.newui.BR;
import cn.xuexuan.newui.R;
import cn.xuexuan.newui.base.BaseViewModel;
import cn.xuexuan.newui.model.http.RetrofitHelper;
import cn.xuexuan.newui.util.RxUtil;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuContract;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;

/**
 * Created by Jant on 2017/3/27.
 */

public class ZhiHuViewModel extends BaseViewModel<ZhiHuContract.View> implements ZhiHuContract.ViewModel {

    public static final String TOKEN_UPDATE_INDICATOR = "token_update_indicator";
    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");

    private Context mContext;
    //顶部新闻
    public final ItemView mTopItemView = ItemView.of(BR.viewModel, R.layout.top_news_item);
    public final ObservableList<TopItemViewModel> mTopItemViewModel = new ObservableArrayList();
    private RetrofitHelper mRetrofitHelper;


    //列表新闻
    // view layout for RecyclerView
    public final ItemViewSelector<ListItemViewModel> mListItemView = new BaseItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel itemViewModel) {
            itemView.set(BR.viewModel, R.layout.list_news_item);
        }

        @Override
        public int viewTypeCount() {
            return 2;
        }

    };
    // viewModel for RecyclerView
    public final ObservableList<ListItemViewModel> mListItemViewModel = new ObservableArrayList<>();


    public final ReplyCommand onRefreshCommand = new ReplyCommand(() -> {});


    @Inject
    public ZhiHuViewModel(Activity activity, RetrofitHelper retrofitHelper) {

        mContext = activity;
        mRetrofitHelper = retrofitHelper;
        Observable.just(Calendar.getInstance())
                .doOnNext(calendar -> calendar.add(Calendar.DAY_OF_MONTH, 1))
                .map(calendar -> DAY_FORMAT.format(calendar.getTimeInMillis()))
                .subscribe(s -> {
                    loadListNews(s);
                    loadTopNews();
                });

    }


    private void loadListNews(String date) {
        Disposable listNews = mRetrofitHelper.fetchDailyBeforeListInfo(date)

                .filter(d -> !d.getStories().isEmpty())
                .flatMap(d -> Observable.fromIterable(d.getStories()))
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(storiesBeen -> mListItemViewModel.add(new ListItemViewModel(mContext, storiesBeen)));
    }


    private void loadTopNews() {

        Disposable lTopNews = mRetrofitHelper.fetchDailyListInfo()
                .filter(d -> !d.getTop_stories().isEmpty())
                .flatMap(dailyListBean -> Observable.fromIterable(dailyListBean.getTop_stories()))
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(dailyListBean -> mTopItemViewModel.add(new TopItemViewModel(mContext,dailyListBean)));

    }


}
