package com.n1njac.cmovie.ui.dailysign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.n1njac.cmovie.databinding.ActivityDailySignBinding
import com.n1njac.cmovie.domain.result.EventObserver
import com.n1njac.cmovie.utils.viewModelProvider
import com.n1njac.cmovie.widget.DepthPageTransformer
import com.n1njac.cmovie.widget.ZoomOutPageTransformer
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by N1njaC on 2019/5/19 21:27.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class DailySignActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mBinding: ActivityDailySignBinding
    private lateinit var mViewModel: DailySignViewModel

    companion object {
        fun startDailySignActivity(activity: Activity) {
            val intent = Intent(activity, DailySignActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDailySignBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initView()
    }

    private fun initView() {
        mViewModel = viewModelProvider(viewModelFactory)
        mViewModel.session.observe(this, Observer {
            it ?: return@Observer
            val pagerAdapter = DailySignAdapter(this, it)
            mBinding.dailyVp.adapter = pagerAdapter
            mBinding.dailyVp.apply {
                adapter = pagerAdapter
                offscreenPageLimit = 3
//                setPageTransformer(false, ZoomOutPageTransformer())
                setPageTransformer(false, DepthPageTransformer())
                pageMargin = 0
            }
        })

        mViewModel.errorMsg.observe(this, EventObserver {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }
}