package com.n1njac.cmovie.net.scheduler

/*
 *    Created by N1njaC on 2019/2/17.
 *    email:aiai173cc@gmail.com 
 */
object SchedulerUtils {
    @JvmStatic
    fun <T> ioToMain() = IoMainScheduler<T>()

    @JvmStatic
    fun <T> newToMain() = NewThreadMainScheduler<T>()
}