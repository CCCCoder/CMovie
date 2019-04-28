package com.n1njac.cmovie.POJO

/**
 * Created by N1njaC on 2019/4/28 21:00.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
data class DataPackaging<T>(val status: Int, val data: T?, val message: String?) {

    companion object {
        const val SUCCESS = 0
        const val ERROR = 1

        fun <T> success(data: T?) = DataPackaging(SUCCESS, data, null)

        fun <T> error(data: T?, errorMsg: String) = DataPackaging(ERROR, data, errorMsg)
    }
}