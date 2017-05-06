package cn.xuexuan.newui.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;

import cn.xuexuan.newui.R;
import cn.xuexuan.newui.app.App;
import cn.xuexuan.newui.base.BaseActivity;
import cn.xuexuan.newui.databinding.ActivityMainBinding;
import cn.xuexuan.newui.ui.zhihu.ZhiHuFragment;
import cn.xuexuan.newui.viewmodel.MainViewModel;
import cn.xuexuan.newui.viewmodel.contract.MainContract;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity<MainViewModel> implements MainContract.View {


    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;

    private ZhiHuFragment mZhiHuFragment;
    private AboutFragment mAboutFragment;
    private int hideFragment ;
    private int showFragment ;
    private MenuItem mLastMenuItem;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }



    @Override
    public void initEventAndData() {

        ActivityMainBinding lActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mNavigationView = lActivityMainBinding.navigation;
        mDrawerLayout = lActivityMainBinding.drawer;
        mZhiHuFragment = new ZhiHuFragment();
        mAboutFragment = new AboutFragment();
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);


        loadMultipleRootFragment(R.id.fl_main_content, 0, mZhiHuFragment, mAboutFragment);

        mNavigationView.setNavigationItemSelectedListener(item -> {

            SupportFragment lSelectedSupportFragment = mZhiHuFragment;
            switch (item.getItemId()) {
                case R.id.drawer_zhihu:

                    lSelectedSupportFragment = mZhiHuFragment;
                    break;
                case R.id.drawer_about:

                    lSelectedSupportFragment = mAboutFragment;
                    break;


            }
            mLastMenuItem.setChecked(false);
            item.setChecked(true);
            mLastMenuItem = item;

            mDrawerLayout.closeDrawers();
            showHideFragment(lSelectedSupportFragment);
            return true;
        });
    }


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onBackPressedSupport(){
        showExitDialog();

    }


    private void showExitDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", (dialog, which) -> {
            App.getInstance().exitApp();
        });
    }


}
