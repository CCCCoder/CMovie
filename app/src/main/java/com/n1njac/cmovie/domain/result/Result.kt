package com.n1njac.cmovie.domain.result

import java.lang.Exception

/**
 * Created by N1njaC on 2019/4/29 22:04.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

//返回true说明当前类型为Success并且data不为空
val Result<*>.succeed
    get() = this is Result.Success && data != null
