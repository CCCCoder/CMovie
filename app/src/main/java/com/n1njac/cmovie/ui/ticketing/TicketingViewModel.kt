package com.n1njac.cmovie.ui.ticketing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.domain.result.Event
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCase
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCaseParameters
import com.n1njac.cmovie.domain.ticketing.LoadTicketingDataUseCaseResult
import com.n1njac.cmovie.utils.map
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/28 20:46.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TicketingViewModel @Inject constructor(private val loadTicketingDataUseCase: LoadTicketingDataUseCase) :
        ViewModel() {

    val isLoading: LiveData<Boolean>

    private val loadTicketingDataResult: MediatorLiveData<Result<MutableList<LoadTicketingDataUseCaseResult>>>

    private val _sessions = MediatorLiveData<MutableList<LoadTicketingDataUseCaseResult>>()
    val session: LiveData<MutableList<LoadTicketingDataUseCaseResult>>
        get() = _sessions

    private val _errorMessage = MediatorLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage

    init {
        loadTicketingDataResult = loadTicketingDataUseCase.observe()
        _sessions.addSource(loadTicketingDataResult) {
            _sessions.value = (it as? Result.Success<MutableList<LoadTicketingDataUseCaseResult>>)?.data
        }

        isLoading = loadTicketingDataResult.map {
            it == Result.Loading
        }

        _errorMessage.addSource(loadTicketingDataResult) { result ->
            if (result is Result.Error) {
                _errorMessage.value = Event(result.exception.message ?: "Error")
            }
        }

    }

    fun setCityName(newCityName: String) {
        loadTicketingDataUseCase.execute(LoadTicketingDataUseCaseParameters(newCityName, count = 30))
    }

}