package cn.xuexuan.newui.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import cn.xuexuan.newui.R;
import cn.xuexuan.newui.base.BaseActivity;
import cn.xuexuan.newui.viewmodel.ZhiHuViewModel;
import cn.xuexuan.newui.viewmodel.contract.ZhiHuContract;

/**
 * Created by Jant on 2017/3/17.
 */

public class ZhiHuActivity extends BaseActivity<ZhiHuViewModel> implements ZhiHuContract.View {


    public void startCoordinatorActivity(View view){
        Intent lIntent = new Intent(this,CoordinatorActivity.class);
        startActivity(lIntent);
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_zhi_hu;
    }

    @Override
    public void initEventAndData() {
        Button lButton = (Button) findViewById(R.id.coordinator_activity_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        CollapsingToolbarLayout lCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        lCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        lCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lIntent = new Intent(ZhiHuActivity.this,CoordinatorActivity.class);
                startActivity(lIntent);
            }
        });
    }
}
