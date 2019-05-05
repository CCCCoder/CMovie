package com.n1njac.cmovie.ui.ticketing

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.POJO.DataPackaging
import com.n1njac.cmovie.POJO.TicketingData
import com.n1njac.cmovie.domain.result.Result
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
    fun fetchTicketingData(city: String, start: Int, count: Int): LiveData<Result<TicketingData>>
}

@Singleton
class DefaultTicketingRepository @Inject constructor() : TicketingRepository {
    @SuppressLint("CheckResult")
    override fun fetchTicketingData(city: String, start: Int, count: Int): LiveData<Result<TicketingData>> {
        val liveData = MutableLiveData<Result<TicketingData>>()
        RetrofitManager.service().fetchTicketingInfo(city, start, count)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ data: TicketingData? ->
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
