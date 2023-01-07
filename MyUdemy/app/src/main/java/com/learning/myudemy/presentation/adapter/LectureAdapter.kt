package com.learning.myudemy.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.databinding.HolderLectureBinding
import com.learning.myudemy.presentation.model.UiLecture
import java.text.NumberFormat
import java.util.*


class LectureAdapter(private val onItemClicked: (UiLecture) -> Unit) :
    ListAdapter<UiLecture, LectureAdapter.LectureHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UiLecture>() {
            override fun areItemsTheSame(oldItem: UiLecture, newItem: UiLecture): Boolean {
                return oldItem.lectureId == newItem.lectureId
            }

            override fun areContentsTheSame(oldItem: UiLecture, newItem: UiLecture): Boolean {
                return (oldItem.lectureId == newItem.lectureId)
                        && (oldItem.lectureName == newItem.lectureName)
                        && (oldItem.Instructor == newItem.Instructor)
                        && (oldItem.gradeScore == newItem.gradeScore)
                        && (oldItem.gradeCount == newItem.gradeCount)
                        && (oldItem.lecturePrice == newItem.lecturePrice)
                        && (oldItem.isBestSeller == newItem.isBestSeller)
            }
        }

        @SuppressLint("ConstantLocale")
        val moneyFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    }

    class LectureHolder(var binding:HolderLectureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Lecture: UiLecture) {
            binding.apply {
                lectureImage.setImageResource(Lecture.lectureThumbnail)
                lectureName.text = Lecture.lectureName
                lecturePrice.text = moneyFormat.format(Lecture.lecturePrice)
                lectureInstructor.text = Lecture.Instructor
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureHolder {
        return LectureHolder(
             HolderLectureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LectureHolder, position: Int) {
        val current = getItem(position)
        if (position!=0)
        if(position>=this.currentList.size-1) {
            holder.binding.holderContainer.visibility = View.GONE
            holder.binding.holderLast.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }
}