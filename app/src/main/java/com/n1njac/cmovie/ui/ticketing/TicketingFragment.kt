package com.n1njac.cmovie.ui.ticketing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.n1njac.cmovie.databinding.FragmentTicketingBinding
import com.n1njac.cmovie.utils.activityViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/22 21:14.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TicketingFragment : DaggerFragment() {


    companion object {
        private const val TAG = "TicketingFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var ticketingViewModel: TicketingViewModel
    private lateinit var mBinding: FragmentTicketingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ticketingViewModel = activityViewModelProvider(viewModelFactory)
        mBinding = FragmentTicketingBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@TicketingFragment)
            viewModel = ticketingViewModel
        }

        return mBinding.root

    }
}