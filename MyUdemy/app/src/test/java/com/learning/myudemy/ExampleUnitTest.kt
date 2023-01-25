package com.learning.myudemy

import com.learning.myudemy.data.remote.LectureApiService
import com.learning.myudemy.domain.model.Category
import com.learning.myudemy.domain.model.test.Orange
import com.learning.myudemy.domain.model.test.Red
import com.learning.myudemy.domain.model.test.TestSealColor
import com.learning.myudemy.domain.model.test.Yellow
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.*


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list1 = listOf(Category(1,"hi11"),Category(1,"hi12"))
        val list11 = listOf(Category(1,"hi11"),Category(1,"hi12"))
        val list2 = listOf(Category(1,"hi21"),Category(1,"hi22"))
        assertEquals(true,list1==list11)
        assertEquals(false,list1==list2)
    }

    @Test
    fun extractNumberInString(){
        val str = "ABAA01"
        val num = str.replace("[^0-9]".toRegex(), "")
        assertEquals("01",num)
    }

    @Test
    fun sealTest(){
        val r : TestSealColor = Red(0,0,0)
        when(r){
           is Red ->  { assertEquals(r,Red(0,0,0)) }
           is Orange  -> {assertEquals(r,Orange(0,0,0)) }
           is Yellow -> { assertEquals(r,Yellow(0,0,0))}
        }
    }


}