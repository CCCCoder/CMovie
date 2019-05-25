package com.n1njac.cmovie.ui.dailysign

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.domain.result.Event
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.domain.usecase.LoadDailySignDataUseCase
import com.n1njac.cmovie.domain.usecase.LoadDailySignDataUseCaseResult
import com.n1njac.cmovie.utils.map
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/5/20 21:07.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class DailySignViewModel @Inject constructor(private val loadDailySignDataUseCase: LoadDailySignDataUseCase) :
    ViewModel(), OnPageClickEvent {

    val isLoading: LiveData<Boolean>
    private val loadDailySignDataResult: MediatorLiveData<Result<MutableList<LoadDailySignDataUseCaseResult>>>

    private val _quitAction = MutableLiveData<Event<Unit>>()
    val quitAction: LiveData<Event<Unit>>
        get() = _quitAction

    private val _shareAction = MutableLiveData<Event<Unit>>()
    val shareAction: LiveData<Event<Unit>>
        get() = _shareAction

    private val _sessions = MediatorLiveData<MutableList<LoadDailySignDataUseCaseResult>>()
    val session: LiveData<MutableList<LoadDailySignDataUseCaseResult>>
        get() = _sessions

    private val _errorMsg = MediatorLiveData<Event<String>>()
    val errorMsg: LiveData<Event<String>>
        get() = _errorMsg

    init {
        loadDailySignDataResult = loadDailySignDataUseCase.observe()
        isLoading = loadDailySignDataResult.map {
            it == Result.Loading
        }
        _sessions.addSource(loadDailySignDataResult) {
            _sessions.value = (it as? Result.Success<MutableList<LoadDailySignDataUseCaseResult>>)?.data
        }

        _errorMsg.addSource(loadDailySignDataResult) {
            if (it is Result.Error) {
                _errorMsg.value = Event(it.exception.message ?: "Unknown Error")
            }
        }
        loadDailySignDataUseCase.execute(Unit)
    }

    override fun onReturnClick() {
        _quitAction.value = Event(Unit)
    }

    override fun onShareClick() {
        _shareAction.value = Event(Unit)
    }
}

interface OnPageClickEvent {
    fun onReturnClick()

    fun onShareClick()
}