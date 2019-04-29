package com.n1njac.cmovie.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.domain.result.Result

/**
 * Created by N1njaC on 2019/4/29 21:33.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

abstract class UseCase<in P, R> {
    operator fun invoke(parameters: P, result: MutableLiveData<Result<R>>) {
        try {
            //这里post出去的类型是：Result<R>
            execute(parameters).let { useCaseResult ->
                result.postValue(Result.Success(useCaseResult))
            }
        } catch (e: Exception) {
            result.postValue(Result.Error(e))
        }
    }

    operator fun invoke(parameters: P): LiveData<Result<R>> {
        val liveCallback: MutableLiveData<Result<R>> = MutableLiveData()
        this(parameters, liveCallback)
        return liveCallback
    }

    protected abstract fun execute(parameters: P): R
}

operator fun <R> UseCase<Unit, R>.invoke(): LiveData<Result<R>> = this(Unit)
operator fun <R> UseCase<Unit, R>.invoke(result: MutableLiveData<Result<R>>) = this(Unit, result)
