package com.n1njac.cmovie.ui.ticketing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.n1njac.cmovie.R
import com.n1njac.cmovie.databinding.FragmentTicketingBinding
import com.n1njac.cmovie.domain.result.EventObserver
import com.n1njac.cmovie.utils.activityViewModelProvider
import com.n1njac.cmovie.widget.SpaceDecoration
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.math.roundToInt

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
        val ticketingAdapter = TicketingAdapter(this, ticketingViewModel)
        mBinding.ticketingRv.apply {
            adapter = ticketingAdapter
            addItemDecoration(SpaceDecoration(0, 0, 0, resources.getDimensionPixelSize(R.dimen.spacing_normal)))
        }
        ticketingViewModel.session.observe(this, Observer {
            it ?: return@Observer
            ticketingAdapter.ticketingItems = it
        })

        ticketingViewModel.errorMessage.observe(this, EventObserver {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            Log.d(TAG, "error===>$it")
        })
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ticketingViewModel.setCityName(290)
    }
}