package com.learning.myudemy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.databinding.LayoutListItemMyLearningBinding
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyLearningAdapter @Inject constructor() : ListAdapter<UiMyLeaningLecture, MyLearningAdapter.LectureDetailHolder>(DiffCallback) {
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UiMyLeaningLecture>() {
            override fun areItemsTheSame(oldItem: UiMyLeaningLecture, newItem: UiMyLeaningLecture): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: UiMyLeaningLecture, newItem: UiMyLeaningLecture): Boolean {
                return oldItem == newItem
            }
        }
    }
   inner class LectureDetailHolder(var binding: LayoutListItemMyLearningBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(UiMyLeaningLecture: UiMyLeaningLecture,position: Int) {
            binding.apply {
                lectureListImage.setImageResource(UiMyLeaningLecture.imgUrl)
                lectureListTitle.text = UiMyLeaningLecture.title
                lectureListSubTitle.text = UiMyLeaningLecture.subTitle
                lectureCkBox.isChecked = UiMyLeaningLecture.isChecked
                lectureCkBox.setOnClickListener {
                    currentList[position].isChecked= (it as CheckBox).isChecked
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyLearningAdapter.LectureDetailHolder {
        return LectureDetailHolder(
            LayoutListItemMyLearningBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LectureDetailHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current,position)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }
}