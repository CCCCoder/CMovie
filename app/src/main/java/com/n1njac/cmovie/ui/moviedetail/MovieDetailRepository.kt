package com.n1njac.cmovie.ui.moviedetail

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.base.NET_RESPONSE_SUCCESS
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.entity.MovieDetailData
import com.n1njac.cmovie.net.BASE_API_MTIME_V2_TICKET
import com.n1njac.cmovie.net.RetrofitManager
import com.n1njac.cmovie.net.scheduler.SchedulerUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/6/16 18:21.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
interface MovieDetailRepository {
    fun fetchMovieDetailData(locationId: Int, movieId: Int): LiveData<Result<MovieDetailData>>
}

@Singleton
open class DefaultMovieDetailRepository @Inject constructor() : MovieDetailRepository {

    @SuppressLint("CheckResult")
    override fun fetchMovieDetailData(locationId: Int, movieId: Int): LiveData<Result<MovieDetailData>> {
        val liveData = MutableLiveData<Result<MovieDetailData>>()
        RetrofitManager.service(BASE_API_MTIME_V2_TICKET).fetchMovieDetailData(locationId, movieId)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ data ->
                if (data.code == NET_RESPONSE_SUCCESS) {
                    liveData.postValue(Result.Success(data.data))
                } else {
                    liveData.postValue(Result.Error(java.lang.Exception(data.showMsg)))
                }

            }, {
                liveData.postValue(Result.Error(Exception(it.message)))
            })

        return liveData
    }
}