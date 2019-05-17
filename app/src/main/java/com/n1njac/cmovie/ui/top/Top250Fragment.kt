package com.n1njac.cmovie.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.n1njac.cmovie.databinding.FragmentTop250Binding
import com.n1njac.cmovie.utils.activityViewModelProvider
import com.n1njac.cmovie.utils.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/22 21:14.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class Top250Fragment : DaggerFragment() {

    companion object {
        private const val TAG = "Top250Fragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var top250ViewModel: Top250ViewModel
    private lateinit var mBinding: FragmentTop250Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentTop250Binding.inflate(layoutInflater, container, false)
        top250ViewModel = activityViewModelProvider(viewModelFactory)
        return mBinding.root
    }
}