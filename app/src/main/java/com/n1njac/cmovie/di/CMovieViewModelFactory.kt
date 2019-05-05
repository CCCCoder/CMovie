package com.n1njac.cmovie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by N1njaC on 2019/5/5 21:37.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Suppress("UNCHECKED_CAST")
class CMovieViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val found = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creators = found?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            return creators.get() as T
        } catch (e: Exception) {
            throw RuntimeException()
        }
    }
}