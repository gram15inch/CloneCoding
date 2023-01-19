package com.learning.myudemy.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learning.myudemy.R
import com.learning.myudemy.databinding.HolderLectureBinding
import com.learning.myudemy.presentation.model.UiLecture
import timber.log.Timber
import java.text.NumberFormat
import java.util.*


class LectureAdapter(private val onItemClicked: (UiLecture) -> Unit) :
    ListAdapter<UiLecture, LectureAdapter.LectureHolder>(DiffCallback) {

    class LectureHolder(var binding: HolderLectureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lecture: UiLecture) {
            binding.apply {
                setImage(lecture)
                setName(lecture)
                lecturePrice.text = moneyFormat.format(lecture.lecturePrice)
                lectureInstructor.text = lecture.Instructor
            }
        }
        private fun setImage(lecture: UiLecture){
            binding.apply {
                if (lecture.lectureThumbnailRes != 0)
                    lectureImage.setImageResource(lecture.lectureThumbnailRes)
                else
                    Glide.with(lectureImage.context)
                        .load(lecture.lectureThumbnailUrl)
                        .into(lectureImage)
            }
        }
        private fun setName(lecture: UiLecture){
            binding.apply {
                lectureName.text =
                    if (lecture.lectureId%10 != 0)
                        "${lecture.lectureName} ${lecture.lectureId%10}"
                    else
                        lecture.lectureName
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

        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UiLecture>() {
            override fun areItemsTheSame(oldItem: UiLecture, newItem: UiLecture): Boolean {
                return oldItem.lectureId == newItem.lectureId
            }

            override fun areContentsTheSame(oldItem: UiLecture, newItem: UiLecture): Boolean {
                return oldItem == newItem

            }
        }

        @SuppressLint("ConstantLocale")
        val moneyFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    }

}