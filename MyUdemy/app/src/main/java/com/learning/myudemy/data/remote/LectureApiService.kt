package com.learning.myudemy.data.remote

import com.learning.myudemy.BuildConfig
import com.learning.myudemy.UdemyApplication
import com.learning.myudemy.data.remote.model.lecture.LectureResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface LectureApiService {
    /* @GET("courseList")
     suspend fun getLectures(
         @Query("ServiceKey") key: String = UdemyApplication.LECTURE_API_KEY,
         @Query("Page") page: Int=1,
     ): LectureResponse
*/
    @GET("v1/course/list")
    suspend fun getLectures(
        @Query("SG_APIM") sg: String = BuildConfig.LECTURE_SG_API_KEY,
        @Query("ServiceKey") key: String = UdemyApplication.LECTURE_API_KEY,
        @Query("page") page: Int = 1,
    ): LectureResponse
}