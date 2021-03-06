package com.n1njac.cmovie.ui.ticketing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.n1njac.cmovie.databinding.ItemTicketingBinding
import com.n1njac.cmovie.domain.usecase.LoadTicketingDataUseCaseResult

/**
 * Created by N1njaC on 2019/5/12 15:56.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class TicketingAdapter(private val lifecycleOwner: LifecycleOwner,
                       private val ticketingViewModel: TicketingViewModel) : RecyclerView.Adapter<TicketingAdapter.TicketingViewHolder>() {


    var ticketingItems: List<LoadTicketingDataUseCaseResult> = emptyList()
        set(value) {
            field = value
            differ.submitList(ticketingItems)
        }

    private val differ = AsyncListDiffer<LoadTicketingDataUseCaseResult>(this, DiffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketingViewHolder {
        return TicketingViewHolder(ItemTicketingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TicketingViewHolder, position: Int) {
        holder.binding.apply {
            data = differ.currentList[position]
            setLifecycleOwner(lifecycleOwner)
            executePendingBindings()
        }
    }

    override fun getItemCount() = differ.currentList.size

    class TicketingViewHolder(val binding: ItemTicketingBinding) : RecyclerView.ViewHolder(binding.root)
}


object DiffCallback : DiffUtil.ItemCallback<LoadTicketingDataUseCaseResult>() {
    override fun areItemsTheSame(oldItem: LoadTicketingDataUseCaseResult, newItem: LoadTicketingDataUseCaseResult): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LoadTicketingDataUseCaseResult, newItem: LoadTicketingDataUseCaseResult): Boolean {
        return oldItem.id == newItem.id
    }

}