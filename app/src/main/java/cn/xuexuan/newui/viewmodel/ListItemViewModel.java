package cn.xuexuan.newui.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.xuexuan.newui.model.bean.DailyBeforeListBean;

/**
 * Created by Jant on 2017/4/18.
 */

public class ListItemViewModel {


    public Context mContext;
    public DailyBeforeListBean.StoriesBean mStoriesBean;

    public final ObservableField<String> mTitle = new ObservableField<>();
    public final ObservableField<String> mImageUrl = new ObservableField<>();
    public final ObservableField<String> mDate = new ObservableField<>();
    public final ObservableInt mTitleTextColor = new ObservableInt();

    public ReplyCommand mItemClickCommand = new ReplyCommand(() -> {

    });


    public ListItemViewModel(Context context, DailyBeforeListBean.StoriesBean storiesBean) {
        mContext = context;
        mStoriesBean = storiesBean;

        mTitleTextColor.set(context.getResources().getColor(android.R.color.black));
        mTitle.set(storiesBean.getTitle());
        mImageUrl.set(storiesBean.getImages().get(0));
    }
}
