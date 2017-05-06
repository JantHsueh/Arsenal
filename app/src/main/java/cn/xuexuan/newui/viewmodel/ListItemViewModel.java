package cn.xuexuan.newui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.xuexuan.newui.model.bean.DailyBeforeListBean;
import cn.xuexuan.newui.ui.zhihu.ZhiHuDetailActivity;

/**
 * Created by Jant on 2017/4/18.
 */

public class ListItemViewModel {


    public Context mContext;
    public long mNewsID;

    public final ObservableField<String> mTitle = new ObservableField<>();
    public final ObservableField<String> mImageUrl = new ObservableField<>();
    public final ObservableField<String> mDate = new ObservableField<>();
    public final ObservableInt mTitleTextColor = new ObservableInt();

    public ReplyCommand mItemClickCommand = new ReplyCommand(() -> {
        //展示新闻详细页面
        Intent intent = new Intent(mContext, ZhiHuDetailActivity.class);
        intent.putExtra(ZhiHuDetailActivity.EXTRA_KEY_NEWS_ID, mNewsID);
        mContext.startActivity(intent);
    });


    public ListItemViewModel(Context context, DailyBeforeListBean.StoriesBean storiesBean) {
        mContext = context;
        mNewsID = storiesBean.getId();

        mTitleTextColor.set(context.getResources().getColor(android.R.color.black));
        mTitle.set(storiesBean.getTitle());
        mImageUrl.set(storiesBean.getImages().get(0));
    }
}
