package com.n1njac.cmovie.entity

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