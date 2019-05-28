package com.n1njac.cmovie.ui.top

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.n1njac.cmovie.domain.result.Event
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.domain.usecase.LoadTopMovieDataUseCase
import com.n1njac.cmovie.domain.usecase.LoadTopMovieDataUseCaseParameters
import com.n1njac.cmovie.domain.usecase.LoadTopMovieDataUseCaseResult
import com.n1njac.cmovie.utils.map
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/5/17 20:52.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TopMovieViewModel @Inject constructor(private val loadTopMovieDataUseCase: LoadTopMovieDataUseCase) :
        ViewModel() {

    val isLoading: LiveData<Boolean>

    private val loadTopMovieResult: MediatorLiveData<Result<MutableList<LoadTopMovieDataUseCaseResult>>>

    private val _session = MediatorLiveData<MutableList<LoadTopMovieDataUseCaseResult>>()
    val session: LiveData<MutableList<LoadTopMovieDataUseCaseResult>>
        get() = _session

    private val _errorMessage = MediatorLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage

    init {
        loadTopMovieResult = loadTopMovieDataUseCase.observe()
        isLoading = loadTopMovieResult.map {
            it == Result.Loading
        }
        _session.addSource(loadTopMovieResult) {
            _session.value = (it as? Result.Success<MutableList<LoadTopMovieDataUseCaseResult>>)?.data
        }

        _errorMessage.addSource(loadTopMovieResult) {
            if (it is Result.Error) {
                _errorMessage.value = Event(it.exception.message ?: "Unknown Error")
            }
        }
    }

    fun fetchTopMovieData(channelId: Int, pageIndex: Int, pageSize: Int) {
        loadTopMovieDataUseCase.execute(LoadTopMovieDataUseCaseParameters(channelId, pageIndex, pageSize))
    }
}