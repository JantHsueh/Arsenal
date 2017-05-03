package cn.xuexuan.newui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Jant on 2017/5/3.
 */

public abstract class SimpleActivity extends SupportActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());



    }

    protected void setToolBar(Toolbar toolBar, String title) {

        toolBar.setTitle(title);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    protected abstract int getLayout();

    protected abstract void initEventAndData();

}
