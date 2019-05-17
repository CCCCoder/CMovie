package com.n1njac.cmovie.entity

data class LocationMovies(
    val bImg: String,
    val date: String,
    val hasPromo: Boolean,
    val lid: Int,
    val ms: List<M>,
    val newActivitiesTime: Int,
    val promo: Promo,
    val totalComingMovie: Int,
    val voucherMsg: String
) {
    data class M(
        val NearestCinemaCount: Int,
        val NearestDay: Long,
        val NearestShowtimeCount: Int,
        val aN1: String,
        val aN2: String,
        val actors: String,
        val cC: Int,
        val commonSpecial: String,
        val d: String,
        val dN: String,
        val def: String,
        val id: Int,
        val img: String,
        val is3D: Boolean,
        val isDMAX: Boolean,
        val isFilter: Boolean,
        val isHasTrailer: Boolean,
        val isHot: Boolean,
        val isIMAX: Boolean,
        val isIMAX3D: Boolean,
        val isNew: Boolean,
        val isTicket: Boolean,
        val m: String,
        val movieId: Int,
        val movieType: String,
        val p: List<String>,
        val preferentialFlag: Boolean,
        val r: Double,
        val rc: Double,
        val rd: String,
        val rsC: Double,
        val sC: Double,
        val t: String,
        val tCn: String,
        val tEn: String,
        val ua: Double,
        val versions: List<Version>,
        val wantedCount: Int,
        val year: String
    ) {
        data class Version(
            val `enum`: Int,
            val version: String
        )
    }

    class Promo(
    )
}