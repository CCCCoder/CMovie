package com.n1njac.cmovie.ui.ticketing

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.entity.LocationMovies
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.net.BASE_API_MTIME_V1
import com.n1njac.cmovie.net.RetrofitManager
import com.n1njac.cmovie.net.scheduler.SchedulerUtils
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/4/28 20:47.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

interface TicketingRepository {
    fun fetchTicketingData(locationId: Int): LiveData<Result<LocationMovies>>
}

@Singleton
open class DefaultTicketingRepository @Inject constructor() : TicketingRepository {
    @SuppressLint("CheckResult")
    override fun fetchTicketingData(locationId: Int): LiveData<Result<LocationMovies>> {
        val liveData = MutableLiveData<Result<LocationMovies>>()
        RetrofitManager.service(BASE_API_MTIME_V1).fetchTicketingInfo(locationId)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ data: LocationMovies? ->
                if (data != null) {
                    liveData.postValue(Result.Success(data))
                } else {
                    liveData.postValue(Result.Error(Exception("data null")))
                }
            }, {
                liveData.postValue(Result.Error(Exception(it.message)))
            })

        return liveData
    }
}
