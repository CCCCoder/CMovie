package com.n1njac.cmovie.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.n1njac.cmovie.entity.GalleryData
import com.n1njac.cmovie.databinding.ItemGalleryBinding

/**
 * Created by N1njaC on 2019/5/17 21:54.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class GalleryAdapter : ListAdapter<GalleryData, GalleryAdapter.GalleryViewHolder>(GalleryDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class GalleryViewHolder(private val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryData: GalleryData) {
            binding.apply {
                data = galleryData
                executePendingBindings()
            }
        }
    }
}

object GalleryDiff : DiffUtil.ItemCallback<GalleryData>() {
    override fun areItemsTheSame(oldItem: GalleryData, newItem: GalleryData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GalleryData, newItem: GalleryData): Boolean {
        return oldItem.posterUrl == newItem.posterUrl
    }
}