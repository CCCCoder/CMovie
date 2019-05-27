package com.n1njac.cmovie.domain.usecase

import androidx.lifecycle.MediatorLiveData
import com.n1njac.cmovie.domain.MediatorUseCase
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.ui.top.TopMovieRepository
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/5/27 22:07.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

open class LoadTopMovieDataUseCase @Inject constructor(private val repository: TopMovieRepository) :
        MediatorUseCase<LoadTopMovieDataUseCaseParameters, MutableList<LoadTopMovieDataUseCaseResult>>() {
    override fun execute(parameter: LoadTopMovieDataUseCaseParameters) {
        result.postValue(Result.Loading)
        val (channelId, pageIndex, pageSize) = parameter
        val topMovieObservable = repository.fetchTopSummaryData(channelId, pageIndex, pageSize)
        result.removeSource(topMovieObservable)
        result.addSource(topMovieObservable) {
            when (it) {
                is Result.Success -> {
                    val list = mutableListOf<LoadTopMovieDataUseCaseResult>()
                    it.data.list.forEach { data ->
                        data.apply {
                            val result = LoadTopMovieDataUseCaseResult(articleId, movieCount, movieImg, title)
                            list.add(result)
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

data class LoadTopMovieDataUseCaseParameters(
        val channelId: Int,
        val pageIndex: Int,
        val pageSize: Int
)

data class LoadTopMovieDataUseCaseResult(
        val articleId: Long,
        val movieCount: Int,
        val coverUrl: String,
        val title: String
)