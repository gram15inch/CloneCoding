package com.learning.myudemy.domain.repository

import com.learning.myudemy.domain.model.Lecture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LectureRepository @Inject constructor() {

    suspend fun getLectureList(): List<Lecture>{
        val list  = mutableListOf<Lecture>()
       withContext(Dispatchers.IO){

       }
        return list
    }
}