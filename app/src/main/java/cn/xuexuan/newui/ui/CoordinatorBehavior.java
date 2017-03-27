package cn.xuexuan.newui.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jant on 2017/3/20.
 */

public class CoordinatorBehavior extends CoordinatorLayout.Behavior<Button> {

    private int mWidth;

    public CoordinatorBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        mWidth = display.widthPixels;
    }



    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return dependency instanceof MoveView;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {

        //根据dependency的位置，设置Button的位置

        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = mWidth - left - child.getWidth();
        int y = top;

        setPosition(child, x, y);
        return true;


    }


    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        v.setLayoutParams(layoutParams);
    }

}
