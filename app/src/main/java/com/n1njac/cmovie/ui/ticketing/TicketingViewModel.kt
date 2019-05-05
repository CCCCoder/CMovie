package com.n1njac.cmovie.ui.ticketing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCase
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCaseParameters
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCaseResult
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/28 20:46.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TicketingViewModel @Inject constructor(private val loadTicketingDataUseCase: LoadTicketingDataUseCase) :
    ViewModel() {

    private val loadTicketingDataResult: MediatorLiveData<Result<MutableList<LoadTicketingDataUseCaseResult>>>

    private val _sessions = MediatorLiveData<Result<MutableList<LoadTicketingDataUseCaseResult>>>()
    val session: LiveData<Result<MutableList<LoadTicketingDataUseCaseResult>>>
        get() = _sessions

    init {
        loadTicketingDataResult = loadTicketingDataUseCase.observe()
        _sessions.addSource(loadTicketingDataResult) {
            _sessions.value = it
        }
    }

    fun setCityName(newCityName: String) {
        loadTicketingDataUseCase.execute(LoadTicketingDataUseCaseParameters(newCityName))
    }

}