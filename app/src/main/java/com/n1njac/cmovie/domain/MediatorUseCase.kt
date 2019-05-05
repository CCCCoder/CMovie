package com.n1njac.cmovie.domain

import androidx.lifecycle.MediatorLiveData
import com.n1njac.cmovie.domain.result.Result

/**
 * Created by N1njaC on 2019/5/2.
 */
abstract class MediatorUseCase<in P, R> {
    protected val result = MediatorLiveData<Result<R>>()

    open fun observe(): MediatorLiveData<Result<R>> {
        return result
    }

    abstract fun execute(parameter: P)
}