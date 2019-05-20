package com.n1njac.cmovie.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.n1njac.cmovie.R
import com.n1njac.cmovie.databinding.FragmentAboutBinding
import com.n1njac.cmovie.entity.GalleryData
import com.n1njac.cmovie.ui.dailysign.DailySignActivity
import com.n1njac.cmovie.widget.SpaceDecoration

/**
 * Created by N1njaC on 2019/4/22 21:09.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class AboutFragment : Fragment() {

    companion object {
        private const val TAG = "AboutFragment"
    }

    private lateinit var mBinding: FragmentAboutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentAboutBinding.inflate(layoutInflater, container, false)

        mBinding.testBtn.setOnClickListener {
            DailySignActivity.startDailySignActivity(requireActivity())
        }
        return mBinding.root
    }


}