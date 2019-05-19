package com.n1njac.cmovie.ui.dailysign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.n1njac.cmovie.databinding.ItemDaySignBinding
import com.n1njac.cmovie.entity.DailySignData

/**
 * Created by N1njaC on 2019/5/19 21:29.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class DailySignAdapter(private val context: Context, private val dataList: MutableList<DailySignData.Rcmd>) : PagerAdapter() {

    override fun getCount() = dataList.size
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemDaySignBinding.inflate(LayoutInflater.from(context))
        bind(binding, dataList[position])
        container.addView(binding.root)
        return binding.root
    }

    private fun bind(binding: ItemDaySignBinding, data: DailySignData.Rcmd) {
        binding.apply {
            dailySignData = data
            executePendingBindings()
        }
    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`
}