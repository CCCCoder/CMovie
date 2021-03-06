package com.n1njac.cmovie.base

/**
 * Created by N1njaC on 2019/5/19 21:35.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */


const val NET_RESPONSE_SUCCESS = "1"

data class BaseResponse<T>(val code: String,
                           val data: T,
                           val msg: String,
                           val showMsg: String)