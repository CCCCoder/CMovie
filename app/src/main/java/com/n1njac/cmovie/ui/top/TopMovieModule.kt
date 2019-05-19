package com.n1njac.cmovie.ui.top

import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.di.FragmentScoped
import com.n1njac.cmovie.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by N1njaC on 2019/5/17 20:58.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Module
internal abstract class TopMovieModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeTopMovieFragment(): TopMovieFragment

    @Binds
    @IntoMap
    @ViewModelKey(TopMovieViewModel::class)
    abstract fun bindTopMovieViewModel(viewModel: TopMovieViewModel): ViewModel

}