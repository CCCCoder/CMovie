package com.n1njac.cmovie.net

import com.n1njac.cmovie.POJO.TicketingData
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
    fun fetchTicketingInfo(@Query("locationId") locationId: Int): Observable<TicketingData>
}