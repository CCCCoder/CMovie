package com.n1njac.cmovie.domain.usecase

import com.n1njac.cmovie.domain.MediatorUseCase
import com.n1njac.cmovie.domain.result.Result

import com.n1njac.cmovie.ui.moviedetail.MovieDetailRepository
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/6/19 19:23.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

open class LoadMovieDetailDataUseCase @Inject constructor(private val repository: MovieDetailRepository) :
    MediatorUseCase<LoadMovieDetailDataUseCaseParameters, LoadMovieDetailDataUseCaseResult>() {
    override fun execute(parameter: LoadMovieDetailDataUseCaseParameters) {
        result.postValue(Result.Loading)
        val (locationId, movieId) = parameter
        val movieDetailObservable = repository.fetchMovieDetailData(locationId, movieId)

        result.removeSource(movieDetailObservable)
        result.addSource(movieDetailObservable) {
            when (it) {
                is Result.Success -> {

                }
                is Result.Error -> {
                    result.postValue(it)
                }
            }
        }
    }
}


data class LoadMovieDetailDataUseCaseResult(
    val movieNameCN: String,
    val movieNameEN: String
)


data class LoadMovieDetailDataUseCaseParameters(
    val locationId: Int,
    val movieId: Int
)