package cn.xuexuan.newui.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.xuexuan.newui.model.bean.DailyListBean;

/**
 * Created by Jant on 2017/4/15.
 */

public class TopItemViewModel {


    public final ObservableField<String> mTitle = new ObservableField<>();
    public final ObservableField<String> mImageUrl = new ObservableField<>();

    public final ReplyCommand mTopItemClickCommand = new ReplyCommand(() -> {
        //展示新闻详细页面
    });

    public TopItemViewModel(Context context, DailyListBean.TopStoriesBean topStoriesBean){

        mTitle.set(topStoriesBean.getTitle());
        mImageUrl.set(topStoriesBean.getImage());
    }

}
