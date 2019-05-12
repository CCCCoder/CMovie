package com.n1njac.cmovie.di

import com.n1njac.cmovie.ui.ticketing.DefaultTicketingRepository
import com.n1njac.cmovie.ui.ticketing.TicketingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
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

}