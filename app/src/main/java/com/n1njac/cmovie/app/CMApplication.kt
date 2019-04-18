package com.n1njac.cmovie.app

import android.app.Application
import com.n1njac.cmovie.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by N1njaC on 2019/4/15 22:11.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class CMApplication : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}