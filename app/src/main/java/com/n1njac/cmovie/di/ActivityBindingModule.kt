package com.n1njac.cmovie.di

import com.n1njac.cmovie.ui.MainActivity
import com.n1njac.cmovie.ui.ticketing.TicketingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by N1njaC on 2019/4/24 22:54.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [TicketingModule::class]
    )
    internal abstract fun mainActivity(): MainActivity
}