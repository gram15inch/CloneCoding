package com.learning.myudemy

import com.learning.myudemy.data.remote.LectureApiService
import com.learning.myudemy.data.remote.NullToEmptyStringAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
/*

@Module
@InstallIn(SingletonComponent::class)
object TestModule {

    @Provides
    @Named("testApi")
    fun provideRetrofitApiTest(retrofit: Retrofit): LectureApiService {
        return retrofit.create(LectureApiService::class.java)
    }
}


@HiltAndroidTest
class HiltTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("testApi")
    lateinit var apiService: LectureApiService

    @BeforeEach
    fun before(){
        hiltRule.inject()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun apiTest() = runTest {
        launch {
            val ex = apiService.getLectures(page = 1)
            assertEquals(10, ex.remoteLectures.size)
        }
        advanceUntilIdle()
    }

}*/
