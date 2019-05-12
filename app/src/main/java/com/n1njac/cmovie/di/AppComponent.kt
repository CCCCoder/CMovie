package com.n1njac.cmovie.di

import com.n1njac.cmovie.app.CMApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/4/18 21:42.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBindingModule::class,
        DataSourceModule::class
    ]
)
interface AppComponent : AndroidInjector<CMApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CMApplication>()
}