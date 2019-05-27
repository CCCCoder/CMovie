package com.n1njac.cmovie.net

import com.n1njac.cmovie.base.BaseResponse
import com.n1njac.cmovie.entity.DailySignData
import com.n1njac.cmovie.entity.LocationMovies
import com.n1njac.cmovie.entity.TopSummaryData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by N1njaC on 2019/4/16 22:48.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
interface ApiService {

    //正在售票
    @GET(URL_MOVIE_SHOWING)
    fun fetchTicketingInfo(@Query("locationId") locationId: Int)
            : Observable<LocationMovies>

    //日签
    @GET(URL_DAILY_SIGN)
    fun fetchDailySignData(): Observable<BaseResponse<DailySignData>>

    //top榜单汇总
    @GET(URL_TOP_SUMMARY)
    fun fetchTopSummaryData(
            @Query("channelId") channelId: Int,
            @Query("pageIndex") pageIndex: Int,
            @Query("pageSize") pageSize: Int
    ): Observable<BaseResponse<TopSummaryData>>
}