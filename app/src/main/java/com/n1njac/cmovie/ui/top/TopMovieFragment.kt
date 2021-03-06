package com.n1njac.cmovie.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.n1njac.cmovie.R
import com.n1njac.cmovie.databinding.FragmentTop250Binding
import com.n1njac.cmovie.utils.activityViewModelProvider
import com.n1njac.cmovie.widget.GrideSpaceDecoration
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/4/22 21:14.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TopMovieFragment : DaggerFragment() {

    companion object {
        private const val TAG = "TopMovieFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var topMovieViewModel: TopMovieViewModel
    private lateinit var mBinding: FragmentTop250Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentTop250Binding.inflate(layoutInflater, container, false)
        topMovieViewModel = activityViewModelProvider(viewModelFactory)

        val topMovieAdapter = TopMovieAdapter()
        mBinding.topRv.apply {
            adapter = topMovieAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
            addItemDecoration(GrideSpaceDecoration(resources.getDimensionPixelSize(R.dimen.spacing_normal)))

        }

        topMovieViewModel.session.observe(this, Observer {
            topMovieAdapter.submitList(it)
        })

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //后期增加分页
        topMovieViewModel.fetchTopMovieData(4, 1, 30)
    }
}