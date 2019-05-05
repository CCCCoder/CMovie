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
    MediatorUseCase<LoadTicketingDataUseCaseParameters, TicketingData>() {
    override fun execute(parameter: LoadTicketingDataUseCaseParameters) {
        result.postValue(Result.Loading)
        val (city, start, count) = parameter
        val ticketingObservable = repository.fetchTicketingData(city, start, count)

        result.removeSource(ticketingObservable)
        //拿到接口的原始数据，过滤一层后post给上层
        result.addSource(ticketingObservable) {
            
        }
    }
}

data class LoadTicketingDataUseCaseParameters(
    val city: String,
    val start: Int = 0,
    val count: Int = 10
)