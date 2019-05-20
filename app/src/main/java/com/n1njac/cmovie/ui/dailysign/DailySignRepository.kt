package com.n1njac.cmovie.ui.dailysign

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.n1njac.cmovie.base.NET_RESPONSE_SUCCESS
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.entity.DailySignData
import com.n1njac.cmovie.net.BASE_API_MTIME_V2_CONTENT
import com.n1njac.cmovie.net.RetrofitManager
import com.n1njac.cmovie.net.scheduler.SchedulerUtils
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by N1njaC on 2019/5/20 21:12.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
interface DailySignRepository {
    fun fetchDailySignData(): LiveData<Result<DailySignData>>
}

@Singleton
open class DefaultDailySignRepository @Inject constructor() : DailySignRepository {

    @SuppressLint("CheckResult")
    override fun fetchDailySignData(): LiveData<Result<DailySignData>> {
        val liveData = MutableLiveData<Result<DailySignData>>()
        RetrofitManager.service(BASE_API_MTIME_V2_CONTENT).fetchDailySignData()
                .compose(SchedulerUtils.ioToMain())
                .subscribe({ data ->
                    if (data.code == NET_RESPONSE_SUCCESS) {
                        liveData.postValue(Result.Success(data.data))
                    } else {
                        liveData.postValue(Result.Error(Exception(data.showMsg)))
                    }
                }, {
                    liveData.postValue(Result.Error(Exception(it.message)))
                })
        return liveData
    }
}
