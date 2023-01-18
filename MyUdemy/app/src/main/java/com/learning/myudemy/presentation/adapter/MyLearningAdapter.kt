package com.learning.myudemy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learning.myudemy.databinding.LayoutListItemMyLearningBinding
import com.learning.myudemy.presentation.model.UiMyLeaningLecture


class MyLearningAdapter : ListAdapter<UiMyLeaningLecture, MyLearningAdapter.LectureDetailHolder>(DiffCallback) {


   inner class LectureDetailHolder(var binding: LayoutListItemMyLearningBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lecture: UiMyLeaningLecture,position: Int) {
            binding.apply {
                if (lecture.imgRes!=0)
                    lectureListImage.setImageResource(lecture.imgRes)
                else
                    Glide.with(binding.root)
                        .load(lecture.imgUrl)
                        .into(lectureListImage)
                lectureListTitle.text = lecture.title
                lectureListSubTitle.text = lecture.subTitle
                lectureCkBox.isChecked = lecture.isChecked
                lectureCkBox.setOnClickListener {
                    currentList[position].isChecked = (it as CheckBox).isChecked
                }
            }
        }
       fun deleteList(lecture: UiMyLeaningLecture){
           binding.lectureListItemStartTxt.setOnClickListener {
               val oldList= mutableListOf<UiMyLeaningLecture>()
               oldList.addAll(currentList)
               oldList.remove(lecture)
               this@MyLearningAdapter.submitList(oldList)
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
        holder.deleteList(current)
    }

    override fun getItemCount(): Int {
        return this.currentList.size
    }

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
}