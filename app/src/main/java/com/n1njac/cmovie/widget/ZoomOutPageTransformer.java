package com.n1njac.cmovie.widget;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by N1njaC on 2019/5/20 22:44.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    public static final String TAG = "ZoomOutTransformer";
    //自由控制缩放比例
    private static final float MAX_SCALE = 1f;
    private static final float MIN_SCALE = 0.88f;

    @Override
    public void transformPage(View page, float position) {
        if (position <= 1) {
            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
            page.setScaleX(scaleFactor);
            if (position > 0) {
                page.setTranslationX(-scaleFactor * 2);
            } else if (position < 0) {
                page.setTranslationX(scaleFactor * 2);
            }
            page.setScaleY(scaleFactor);
        } else {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }
    }
}
