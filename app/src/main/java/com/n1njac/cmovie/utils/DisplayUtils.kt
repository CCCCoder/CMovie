package com.n1njac.cmovie.utils

import android.app.Activity
import android.graphics.Color
import android.view.View

/**
 * Created by N1njaC on 2019/5/24 21:21.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

fun hideStatusBar(activity: Activity) {
    val decorView = activity.window.decorView
    val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    decorView.systemUiVisibility = option
    activity.window.statusBarColor = Color.TRANSPARENT
}


fun getStatusBarHeight(): Int {
    var statusBarHeight = -1
    val resourceId = getContext().resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        statusBarHeight = getContext().resources.getDimensionPixelSize(resourceId)
    }
    return statusBarHeight
}