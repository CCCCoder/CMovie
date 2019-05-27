package com.n1njac.cmovie.ui.top

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.base.NET_RESPONSE_SUCCESS
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.entity.TopSummaryData
import com.n1njac.cmovie.net.BASE_API_MTIME_V2_CONTENT
import com.n1njac.cmovie.net.RetrofitManager
import com.n1njac.cmovie.net.scheduler.SchedulerUtils
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/5/27 21:39.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

interface TopMovieRepository {
    fun fetchTopSummaryData(channelId: Int, pageIndex: Int, pageSize: Int): LiveData<Result<TopSummaryData>>
}

@Singleton
class DefaultTopMovieRepository @Inject constructor() : TopMovieRepository {

    @SuppressLint("CheckResult")
    override fun fetchTopSummaryData(channelId: Int, pageIndex: Int, pageSize: Int): LiveData<Result<TopSummaryData>> {
        val liveData = MutableLiveData<Result<TopSummaryData>>()
        RetrofitManager.service(BASE_API_MTIME_V2_CONTENT).fetchTopSummaryData(channelId, pageIndex, pageSize)
                .compose(SchedulerUtils.ioToMain())
                .subscribe({ data ->
                    if (data.code == NET_RESPONSE_SUCCESS) {
                        liveData.postValue(Result.Success(data.data))
                    } else {
                        liveData.postValue(Result.Error(Exception(data.showMsg)))
                    }
                }, { t ->
                    liveData.postValue(Result.Error(Exception(t.message)))
                })

        return liveData
    }
}