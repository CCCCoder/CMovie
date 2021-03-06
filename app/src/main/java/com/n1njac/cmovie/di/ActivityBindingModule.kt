package com.n1njac.cmovie.di

import com.n1njac.cmovie.ui.startup.MainActivity
import com.n1njac.cmovie.ui.dailysign.DailySignActivity
import com.n1njac.cmovie.ui.dailysign.DailySignModule
import com.n1njac.cmovie.ui.ticketing.TicketingModule
import com.n1njac.cmovie.ui.top.TopMovieModule
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
            modules = [
                TicketingModule::class,
                TopMovieModule::class,
                ViewPoolModule::class
            ]
    )
    internal abstract fun mainActivity(): MainActivity


    @ActivityScoped
    @ContributesAndroidInjector(modules = [DailySignModule::class])
    internal abstract fun dailySignActivity(): DailySignActivity
}