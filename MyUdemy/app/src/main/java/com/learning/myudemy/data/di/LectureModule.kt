package com.learning.myudemy.data.di

import com.learning.myudemy.UdemyApplication
import com.learning.myudemy.data.remote.LectureApiService
import com.learning.myudemy.data.remote.NullToEmptyStringAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LectureModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(NullToEmptyStringAdapter())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )
            .baseUrl(UdemyApplication.LECTURE_BASE_URL2)
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): LectureApiService {
        return retrofit.create(LectureApiService::class.java)
    }
}