package com.n1njac.cmovie.di

import androidx.recyclerview.widget.RecyclerView
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by N1njaC on 2019/5/12 14:17.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
internal class ViewPoolModule {

    @FragmentScoped
    @Provides
    @Named("commonViewModel")
    fun providesCommonViewModel(): RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
}