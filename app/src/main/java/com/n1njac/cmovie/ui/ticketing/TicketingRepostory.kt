package com.n1njac.cmovie.ui.ticketing

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.POJO.DataPackaging
import com.n1njac.cmovie.POJO.TicketingData
import com.n1njac.cmovie.net.RetrofitManager
import com.n1njac.cmovie.net.scheduler.SchedulerUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/4/28 20:47.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
@Singleton
class TicketingRepository @Inject constructor() {

    @SuppressLint("CheckResult")
    fun fetchTicketingData(city: String, start: Int, count: Int): LiveData<DataPackaging<TicketingData>> {
        val liveData = MutableLiveData<DataPackaging<TicketingData>>()
        RetrofitManager.service().fetchTicketingInfo(city, start, count)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ data: TicketingData? ->
                if (data != null) {
                    liveData.postValue(DataPackaging.success(data))
                } else {
                    liveData.postValue(DataPackaging.error(null, "Empty data!"))
                }
            }, {
                liveData.postValue(DataPackaging.error(null, it.message.toString()))
            })

        return liveData
    }
}