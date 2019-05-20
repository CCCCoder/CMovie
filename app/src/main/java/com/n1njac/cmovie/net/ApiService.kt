package com.n1njac.cmovie.net

import com.n1njac.cmovie.base.BaseResponse
import com.n1njac.cmovie.entity.DailySignData
import com.n1njac.cmovie.entity.LocationMovies
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

    @GET(URL_DAILY_SIGN)
    fun fetchDailySignData(): Observable<BaseResponse<DailySignData>>
}