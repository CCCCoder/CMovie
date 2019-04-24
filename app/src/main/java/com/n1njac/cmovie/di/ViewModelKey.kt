package com.n1njac.cmovie.di

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

/**
 * Created by N1njaC on 2019/4/24 23:12.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ViewModelKey(val value: KClass<out ViewModel>)