package com.n1njac.cmovie.domain.ticketing

import com.n1njac.cmovie.POJO.TicketingData
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
        val (city, start, count) = parameter
        val ticketingObservable = repository.fetchTicketingData(city, start, count)

        result.removeSource(ticketingObservable)
        //拿到接口的原始数据，如果需要 ，在这里过滤一层后post给上层
        result.addSource(ticketingObservable) {
            when (it) {
                is Result.Success -> {
                    val useCaseResultList = mutableListOf<LoadTicketingDataUseCaseResult>()
                    it.data.subjects.forEach { subjects ->
                        subjects.apply {
                            var starring = ""
                            directors.forEachIndexed { index, director ->
                                starring += if (index < directors.size - 1) "${director.name}," else director.name
                            }
                            var tags = ""
                            genres.forEachIndexed { index, tag ->
                                tags += if (index < genres.size - 1) "$tag/" else tag
                            }
                            val useCaseResult = LoadTicketingDataUseCaseResult(title, rating.average, starring, images.medium, tags)
                            useCaseResultList.add(useCaseResult)
                        }
                        result.postValue(Result.Success(useCaseResultList))
                    }
                }
                is Result.Error -> {
                    result.postValue(it)
                }
            }
        }
    }
}

data class LoadTicketingDataUseCaseParameters(
    val city: String,
    val start: Int = 0,
    val count: Int = 10
)

data class LoadTicketingDataUseCaseResult(
    private val movieTitle: String,
    private val movieRating: Double,
    private val starring: String,
    private val posterPic: String,
    private val tags: String
)