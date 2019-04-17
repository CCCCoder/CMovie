package com.n1njac.cmovie.net.scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/*    
 *    Created by N1njaC on 2019/2/17.
 *    email:aiai173cc@gmail.com 
 */
class IoMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())