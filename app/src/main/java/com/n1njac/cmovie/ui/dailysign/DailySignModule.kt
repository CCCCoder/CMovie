package com.n1njac.cmovie.ui.dailysign

import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by N1njaC on 2019/5/20 22:21.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
internal abstract class DailySignModule {

    @Binds
    @IntoMap
    @ViewModelKey(DailySignViewModel::class)
    internal abstract fun bindDailySignViewModel(viewModel: DailySignViewModel): ViewModel
}