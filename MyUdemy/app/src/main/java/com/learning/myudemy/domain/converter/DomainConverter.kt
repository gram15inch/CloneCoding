package com.learning.myudemy.domain.converter

import com.learning.myudemy.data.remote.model.lecture.RemoteLecture
import com.learning.myudemy.domain.model.Lecture

object DomainConverter {
    var  id = 0
    fun toLecture(lecture:RemoteLecture)= Lecture(
        id++,
        lecture.name,
        lecture.teachers,
        lecture.number,
        lecture.classfyName,
        3.5f,
        50,
        100000,
        lecture.videoTime,
        0,
        lecture.media.image.raw,
        false
    )
}