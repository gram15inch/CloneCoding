package com.learning.myudemy.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.databinding.LayoutListVideoLectureBinding
import com.learning.myudemy.presentation.model.UiLecture
import timber.log.Timber


class VideoPlayAdapter(private val onItemClicked: (UiLecture) -> Unit) :
    ListAdapter<UiLecture, VideoPlayAdapter.LectureDetailHolder>(DiffCallback) {

    inner class LectureDetailHolder(var binding: LayoutListVideoLectureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lecture: UiLecture) {
            binding.apply {
                videoLectureTextNumberMargin.text = (absoluteAdapterPosition+1).toString()
                videoLectureTextTitle.text= lecture.lectureName
                videoLectureTextDuration.text = lecture.videoTime
            }
        }

        fun getNumber(code:String):String{
            return code.replace("[^0-9]".toRegex(), "")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoPlayAdapter.LectureDetailHolder {
        return LectureDetailHolder(
            LayoutListVideoLectureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LectureDetailHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UiLecture>() {
            override fun areItemsTheSame(
                oldItem: UiLecture,
                newItem: UiLecture
            ): Boolean {
                return oldItem.lectureId == newItem.lectureId
            }

            override fun areContentsTheSame(
                oldItem: UiLecture,
                newItem: UiLecture
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}