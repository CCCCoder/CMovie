package com.n1njac.cmovie.net

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by N1njaC on 2019/4/17 20:06.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
object RetrofitManager {

    fun service(): ApiService = getRetrofit().create(ApiService::class.java)

    private fun getRetrofit(): Retrofit {

        val builder = OkHttpClient.Builder()
//        此处可以添加头部信息
//        builder.addInterceptor { chain ->
//            val request = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer $token")
//                .build()
//            chain.proceed(request)
//        }
        builder.addInterceptor(logInterceptor())

        return Retrofit.Builder()
            .baseUrl(BASE_API_MTIME)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    private fun logInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Log.i("HttpLog", "HTTP LOG:$message")
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}