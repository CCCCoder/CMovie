package com.n1njac.cmovie.widget;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by N1njaC on 2019/5/21 21:54.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {

    float MIN_ALPHA = 0.1f;
    float MIN_SCALE = 0.5f;

    @Override
    public void transformPage(@NonNull View page, float position) {

        if (position < -1 || position > 1) {
            page.setAlpha(0f);
            page.setScaleX(1);
            page.setScaleY(1);

        } else {
            if (-1 <= position && position < 0) {
                page.setAlpha(1 + position - MIN_ALPHA * position);

                float scaleFactor = 1 + position - MIN_SCALE * position;
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);


            } else if (position > 0 && position <= 1) {
                page.setAlpha(1 - position + MIN_ALPHA * position);
                float scaleFactor = 1 - position + MIN_SCALE * position;
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            } else {
                page.setAlpha(1);
                page.setScaleX(1);
                page.setScaleY(1);
            }
        }

    }
}
