package com.n1njac.cmovie.domain.usecase

import com.n1njac.cmovie.domain.MediatorUseCase
import com.n1njac.cmovie.domain.UseCase
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.ui.dailysign.DailySignRepository
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/5/20 21:11.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

class LoadDailySignDataUseCase @Inject constructor(private val repository: DailySignRepository) :
        MediatorUseCase<Unit, MutableList<LoadDailySignDataUseCaseResult>>() {

    override fun execute(parameter: Unit) {
        result.postValue(Result.Loading)
        val dailySignObserver = repository.fetchDailySignData()
        result.removeSource(dailySignObserver)
        result.addSource(dailySignObserver) {
            when (it) {
                is Result.Success -> {
                    val list = mutableListOf<LoadDailySignDataUseCaseResult>()
                    it.data.rcmdList.forEach { rcmd ->
                        rcmd.apply {
                            list.add(LoadDailySignDataUseCaseResult(movieId, playStatus, desc, rcmdQuote, poster))
                        }
                    }
                    result.postValue(Result.Success(list))
                }
                is Result.Error -> {
                    result.postValue(it)
                }
            }
        }
    }
}


data class LoadDailySignDataUseCaseResult(
        val movieId: String,
        val playStatus: String,
        val description: String,
        val quote: String,
        val posterUrl: String
)