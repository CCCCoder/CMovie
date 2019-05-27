package com.n1njac.cmovie.di

import com.n1njac.cmovie.ui.dailysign.DailySignRepository
import com.n1njac.cmovie.ui.dailysign.DefaultDailySignRepository
import com.n1njac.cmovie.ui.ticketing.DefaultTicketingRepository
import com.n1njac.cmovie.ui.ticketing.TicketingRepository
import com.n1njac.cmovie.ui.top.DefaultTopMovieRepository
import com.n1njac.cmovie.ui.top.TopMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/5/12 14:55.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideTicketingDataSource(): TicketingRepository {
        return DefaultTicketingRepository()
    }

    @Singleton
    @Provides
    fun provideDailySignDataSource(): DailySignRepository {
        return DefaultDailySignRepository()
    }

    @Singleton
    @Provides
    fun provideTopSummaryDataSource(): TopMovieRepository {
        return DefaultTopMovieRepository()
    }
}