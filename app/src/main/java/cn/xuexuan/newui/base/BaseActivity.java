package cn.xuexuan.newui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.xuexuan.newui.R;

/**
 * Created by Jant on 2017/3/27.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu);
    }

}
