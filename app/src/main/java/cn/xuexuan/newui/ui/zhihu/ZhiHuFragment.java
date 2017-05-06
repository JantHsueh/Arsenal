package cn.xuexuan.newui.ui.zhihu;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.xuexuan.newui.BR;
import cn.xuexuan.newui.R;
import cn.xuexuan.newui.base.BaseFragment;
import cn.xuexuan.newui.databinding.ActivityZhiHuBinding;
import cn.xuexuan.newui.viewmodel.ZhiHuViewModel;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuContract;

/**
 * Created by Jant on 2017/3/17.
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuViewModel> implements ZhiHuContract.View {

    private ActivityZhiHuBinding mActivityZhiHuBinding;

    @Override
    public void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_zhi_hu;
    }

    @Override
    public void initEventAndData() {

        mActivityZhiHuBinding = DataBindingUtil.setContentView(mActivity, R.layout.activity_zhi_hu);
        mActivityZhiHuBinding.setVariable(BR.viewModel, mViewModel);
        mActivityZhiHuBinding.recyclerView.addItemDecoration(new DividerItemDecoration(mActivity));
        setTools(mActivityZhiHuBinding.toolbar);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, mActivityZhiHuBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        mActivityZhiHuBinding.CollapsingToolbarLayout.setExpandedTitleColor(Color.argb(0, 255, 255, 255));//设置还没收缩时状态下字体颜色
        mActivityZhiHuBinding.CollapsingToolbarLayout.setCollapsedTitleTextColor(Color.argb(255, 255, 255, 255));//设置收缩后Toolbar上字体的颜色

    }

    @Override
    public void setViewPager() {
        mActivityZhiHuBinding.indicator.setViewPager(mActivityZhiHuBinding.viewpager);
    }


    public static class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public DividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

}
