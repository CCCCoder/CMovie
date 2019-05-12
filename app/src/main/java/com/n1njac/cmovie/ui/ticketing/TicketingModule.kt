package com.n1njac.cmovie.ui.ticketing

import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.di.FragmentScoped
import com.n1njac.cmovie.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by N1njaC on 2019/4/24 23:17.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
internal abstract class TicketingModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeTicketingFragment(): TicketingFragment

    @Binds
    @IntoMap
    @ViewModelKey(TicketingViewModel::class)
    abstract fun bindTicketingViewModel(viewModel: TicketingViewModel): ViewModel
}