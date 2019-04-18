package com.n1njac.cmovie.di

import android.content.Context
import com.n1njac.cmovie.app.CMApplication
import dagger.Module
import dagger.Provides

/**
 * Created by N1njaC on 2019/4/18 21:21.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
class AppModule {
    @Provides
    fun provideContext(application: CMApplication): Context {
        return application.applicationContext
    }
}