package com.georgeren.designandroid;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by georgeRen on 2017/9/11.
 * 自定义字体初始化
 * assets／fonts／
 */

public class CodeUIApp extends Application{
    private final static String ROBOTO_SLAB = "fonts/RobotoSlab-Regular.ttf";
    @Override
    public void onCreate() {
        super.onCreate();
        configureDefaultFont(ROBOTO_SLAB);
    }

    private void configureDefaultFont(String robotoSlab) {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(robotoSlab)
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
