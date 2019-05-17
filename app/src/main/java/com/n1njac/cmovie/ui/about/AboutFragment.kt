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

        val linearLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val galleryAdapter = GalleryAdapter()
        mBinding.galleryRv.apply {
            layoutManager = linearLayoutManager
            adapter = galleryAdapter
            setHasFixedSize(true)
            addItemDecoration(SpaceDecoration(0, 0, resources.getDimensionPixelOffset(R.dimen.spacing_item), 0))
        }
        val linearSnapHelper = LinearSnapHelper()
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(mBinding.galleryRv)
        galleryAdapter.submitList(testData())
        return mBinding.root
    }

    private fun testData(): MutableList<GalleryData> {
        val list = mutableListOf<GalleryData>()
        for (i in 0..10) {
            val posterUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558112783164&di=8f174cbbb1dabb3ec12f7134ffc4a81f&imgtype=0&src=http%3A%2F%2Fimage2.sina.com.cn%2Fdy%2Fo%2F2006-01-12%2F7cb917ee802d54c8f3632cf95dc2b93b.jpg"
            val data = GalleryData(posterUrl, "0$i", "MAY 2019", "真诚")
            list.add(data)
        }
        return list
    }
}