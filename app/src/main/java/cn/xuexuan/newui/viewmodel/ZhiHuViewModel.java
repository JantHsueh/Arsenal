package cn.xuexuan.newui.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
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

    //如果在这里使用@Inject，注意一定要在构造函数返回后，这个值才不为空，
    //断点调试发现，是在构造函数返回后，才注入变量
    //这也可以理解，因为在baseActivity中 @Inject viewModel需要这个构造函数提供依赖。
    // 所以在生成baseActivity中的变量的时候，就会先使用这个构造函数，但是此时变量为空
//    @Inject RetrofitHelper mRetrofitHelper;
    private String mDateForGet;

    private RetrofitHelper mRetrofitHelper;


    //顶部新闻
    public final ItemView mTopItemView = ItemView.of(BR.viewModel, R.layout.top_news_item);
    public final ObservableList<TopItemViewModel> mTopItemViewModel = new ObservableArrayList();


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


    public final ObservableBoolean mIsRefreshing = new ObservableBoolean(true);
    // viewModel for RecyclerView
    public final ObservableList<ListItemViewModel> mListItemViewModel = new ObservableArrayList<>();


    public final ReplyCommand onRefreshCommand = new ReplyCommand(() -> {
        Observable.just(Calendar.getInstance())
                .doOnNext(calendar -> calendar.add(Calendar.DAY_OF_MONTH, 1))
                .map(calendar -> DAY_FORMAT.format(calendar.getTimeInMillis()))
                .subscribe(s -> {
                    loadListNews(s,true);
                    loadTopNews();
                });
    });


    public final ReplyCommand<Integer> onLoadMoreCommand = new ReplyCommand<>(() -> {
        loadListNews(mDateForGet,false);

    });

    @Inject
    public ZhiHuViewModel(Activity activity, RetrofitHelper retrofitHelper) {

        mContext = activity;
        mRetrofitHelper = retrofitHelper;
        //传入时间如果是2017.04.22，那么获取2017.04.21的文章，所以在日期上+1
        Observable.just(Calendar.getInstance())
                .doOnNext(calendar -> calendar.add(Calendar.DAY_OF_MONTH, 1))
                .map(calendar -> DAY_FORMAT.format(calendar.getTimeInMillis()))
                .subscribe(s -> {
                    loadListNews(s,false);
                    loadTopNews();
                });
    }


    /**
     * 获取类表的文章
     * @param date       文章的日期
     * @param isClear    是否清理之前的获取的文章
     */
    private void loadListNews(String date, boolean isClear) {
        mIsRefreshing.set(true);

        Disposable listNews = mRetrofitHelper.fetchDailyBeforeListInfo(date)

                .filter(d -> !d.getStories().isEmpty())
                .doOnNext(d -> mDateForGet = d.getDate())
                .compose(RxUtil.rxSchedulerHelper())
                .doOnNext(m -> {if (isClear)mListItemViewModel.clear();})
                .flatMap(d -> Observable.fromIterable(d.getStories()))
                .doAfterTerminate(()->mIsRefreshing.set(false))
                .subscribe(storiesBeen -> mListItemViewModel.add(new ListItemViewModel(mContext, storiesBeen)));
    }


    private void loadTopNews() {

        Disposable lTopNews = mRetrofitHelper.fetchDailyListInfo()
                .filter(d -> !d.getTop_stories().isEmpty())
                .compose(RxUtil.rxSchedulerHelper())
                .doOnNext(m -> mTopItemViewModel.clear())
                .flatMap(dailyListBean -> Observable.fromIterable(dailyListBean.getTop_stories()))
                .doOnNext(dailyListBean -> mTopItemViewModel.add(new TopItemViewModel(mContext,dailyListBean)))
                .toList()
                .subscribe((m) ->mView.setViewPager());

    }


    @Override
    public void detachView() {

    }


}
