package com.n1njac.cmovie.ui.moviedetail

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/6/16 18:21.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
interface MovieDetailRepository {
    fun fetchModvieDetailData()
}

@Singleton
open class DefaultMovieDetailRepository @Inject constructor() {}