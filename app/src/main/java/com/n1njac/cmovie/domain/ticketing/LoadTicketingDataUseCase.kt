package com.n1njac.cmovie.domain.ticketing

import com.n1njac.cmovie.domain.MediatorUseCase
import com.n1njac.cmovie.domain.UseCase
import com.n1njac.cmovie.domain.result.Result
import com.n1njac.cmovie.ui.ticketing.TicketingRepository
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/29 21:33.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
open class LoadTicketingDataUseCase @Inject constructor(private val repository: TicketingRepository) :
    MediatorUseCase<LoadTicketingDataUseCaseParameters, MutableList<LoadTicketingDataUseCaseResult>>() {

    override fun execute(parameter: LoadTicketingDataUseCaseParameters) {
        result.postValue(Result.Loading)
        val (locationId) = parameter
        val ticketingObservable = repository.fetchTicketingData(locationId)

        result.removeSource(ticketingObservable)
        //拿到接口的原始数据，如果需要 ，在这里过滤一层后post给上层
        result.addSource(ticketingObservable) {
            when (it) {
                is Result.Success -> {
                    val useCaseResultList = mutableListOf<LoadTicketingDataUseCaseResult>()
                    it.data.ms.forEach { ms ->
                        val actors = ms.actors
                        val tags = ms.movieType
                        val id = ms.movieId.toString()
                        val rating = ms.r.toString()
                        val movieTitle = ms.tCn
                        val poster = ms.img
                        val introduction = ms.commonSpecial
                        val useCaseResult = LoadTicketingDataUseCaseResult(
                            id,
                            movieTitle,
                            rating,
                            actors,
                            poster,
                            tags,
                            introduction
                        )
                        useCaseResultList.add(useCaseResult)
                    }
                    result.postValue(Result.Success(useCaseResultList))
                }
                is Result.Error -> {
                    result.postValue(it)
                }
            }
        }
    }
}

data class LoadTicketingDataUseCaseParameters(
    val locationId: Int
)

data class LoadTicketingDataUseCaseResult(
    val id: String,
    val movieTitle: String,
    val movieRating: String,
    val starring: String,
    val posterPic: String,
    val tags: String,
    val introduction: String
)