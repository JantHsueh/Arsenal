package cn.xuexuan.newui.ui;

import android.databinding.DataBindingUtil;
import android.webkit.WebViewClient;

import cn.xuexuan.newui.BR;
import cn.xuexuan.newui.R;
import cn.xuexuan.newui.base.BaseActivity;
import cn.xuexuan.newui.viewmodel.ZhiHuDetailViewModel;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuDetailContract;

public class ZhiHuDetailActivity extends BaseActivity<ZhiHuDetailViewModel> implements ZhiHuDetailContract.View {

    public static final String EXTRA_KEY_NEWS_ID = "key_news_id";

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_zhi_hu_detail;
    }

    @Override
    public void initEventAndData() {

        long id = getIntent().getLongExtra(EXTRA_KEY_NEWS_ID,-1);
        ActivityZhiHuDetailBinding lViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_zhi_hu_detail);
        lViewDataBinding.setVariable(BR.viewModel,mViewModel);



        setSupportActionBar(lViewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lViewDataBinding.webView.getSettings().setJavaScriptEnabled(true);
        lViewDataBinding.webView.setWebViewClient(new WebViewClient());
        mViewModel.loadNews(id);

    }
}
