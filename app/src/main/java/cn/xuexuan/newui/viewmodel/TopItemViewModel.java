package cn.xuexuan.newui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.xuexuan.newui.model.bean.DailyListBean;
import cn.xuexuan.newui.ui.ZhiHuDetailActivity;

/**
 * Created by Jant on 2017/4/15.
 */

public class TopItemViewModel {


    private Context mContext;
    private long mNewsID;

    public final ObservableField<String> mTitle = new ObservableField<>();
    public final ObservableField<String> mImageUrl = new ObservableField<>();

    public final ReplyCommand mTopItemClickCommand = new ReplyCommand(() -> {
        //展示新闻详细页面
        Intent intent = new Intent(mContext, ZhiHuDetailActivity.class);
        intent.putExtra(ZhiHuDetailActivity.EXTRA_KEY_NEWS_ID, mNewsID);
        mContext.startActivity(intent);
    });

    public TopItemViewModel(Context context, DailyListBean.TopStoriesBean topStoriesBean){
        mContext = context;
        mNewsID = topStoriesBean.getId();
        mTitle.set(topStoriesBean.getTitle());
        mImageUrl.set(topStoriesBean.getImage());
    }

}
