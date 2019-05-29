package com.n1njac.cmovie.ui.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.n1njac.cmovie.databinding.ItemTopMovieBinding
import com.n1njac.cmovie.domain.usecase.LoadTopMovieDataUseCaseResult

/**
 * Created by N1njaC on 2019/5/29.
 */
class TopMovieAdapter : ListAdapter<LoadTopMovieDataUseCaseResult, TopMovieAdapter.TopMovieViewHolder>(topDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
        return TopMovieViewHolder(ItemTopMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopMovieViewHolder(private val mBinding: ItemTopMovieBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(mData: LoadTopMovieDataUseCaseResult) {
            mBinding.apply {
                data = mData
                executePendingBindings()
            }
        }
    }
}

val topDiff = object : DiffUtil.ItemCallback<LoadTopMovieDataUseCaseResult>() {
    override fun areItemsTheSame(oldItem: LoadTopMovieDataUseCaseResult, newItem: LoadTopMovieDataUseCaseResult): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LoadTopMovieDataUseCaseResult, newItem: LoadTopMovieDataUseCaseResult): Boolean {
        return oldItem.articleId == newItem.articleId
    }
}