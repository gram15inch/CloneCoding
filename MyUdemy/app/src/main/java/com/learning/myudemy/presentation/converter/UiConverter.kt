package com.learning.myudemy.presentation.converter

import com.learning.myudemy.domain.model.Lecture
import com.learning.myudemy.presentation.model.UiLecture

class UiConverter {
    companion object{
        fun toUiLecture(lecture:Lecture) = UiLecture(
            lecture.lectureId,
            lecture.lectureName,
            lecture.Instructor,
            lecture.gradeScore,
            lecture.gradeCount,
            lecture.lecturePrice,
            lecture.lectureThumbnail,
            lecture.isBestSeller
        )
    }
}