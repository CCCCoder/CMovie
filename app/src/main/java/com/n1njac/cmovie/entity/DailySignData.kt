package com.n1njac.cmovie.entity

data class DailySignData(
        val rcmdList: List<Rcmd>
) {
    data class Rcmd(
            val dailyMovieTime: String,
            val desc: String,
            val movieId: String,
            val playStatus: String,
            val poster: String,
            val rcmdId: Int,
            val rcmdQuote: String
    )
}