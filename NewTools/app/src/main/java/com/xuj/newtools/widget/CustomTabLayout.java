package com.xuj.newtools.widget;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2016/11/16.
 * 自定义的TabLayout，主要实现2个功能
 * 1.设置选择时候的字体大小
 * 2.可以设置指示器的长度
 *
 */

public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
