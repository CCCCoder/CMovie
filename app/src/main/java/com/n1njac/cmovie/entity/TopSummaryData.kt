package com.n1njac.cmovie.entity

/**
 * Created by N1njaC on 2019/6/19 19:11.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

data class TopSummaryData(
    var hasMore: Boolean,
    var list: List<X>
) {
    data class X(
        var articleId: Long,
        var hasCollected: Boolean,
        var movieCount: Int,
        var movieImg: String,
        var personImg: String,
        var title: String
    )
}