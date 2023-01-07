package com.learning.myudemy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.databinding.LayoutRecommendLectureBinding
import com.learning.myudemy.presentation.model.RecommendTag
import com.learning.myudemy.presentation.model.UiRecommend

class RecommendAdapter : ListAdapter<UiRecommend, RecommendAdapter.RecommendHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UiRecommend>() {
            override fun areItemsTheSame(oldItem: UiRecommend, newItem: UiRecommend): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UiRecommend, newItem: UiRecommend): Boolean {
                return oldItem == newItem
            }
        }

    }

    class RecommendHolder(var binding: LayoutRecommendLectureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(uiRmd: UiRecommend) {
            if (uiRmd.tag == RecommendTag.Lecture) binding.apply {
                lectureTitle = "${uiRmd.title} 추천강의"
                lectureList = uiRmd.lectures
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendHolder {
        return RecommendHolder(
            LayoutRecommendLectureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }
}