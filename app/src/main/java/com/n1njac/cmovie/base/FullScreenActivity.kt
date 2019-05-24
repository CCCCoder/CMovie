package com.n1njac.cmovie.base

import android.annotation.SuppressLint
import android.os.Bundle
import com.n1njac.cmovie.utils.hideStatusBar
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by N1njaC on 2019/5/24 21:35.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@SuppressLint("Registered")
open class FullScreenActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar(this)
    }
}