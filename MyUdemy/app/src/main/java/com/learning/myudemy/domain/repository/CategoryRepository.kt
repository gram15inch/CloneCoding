package com.learning.myudemy.domain.repository

import com.learning.myudemy.domain.model.Category
import com.learning.myudemy.domain.model.test.Red
import com.learning.myudemy.domain.model.test.TestSealColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor() {
    suspend fun getCategoryList(): List<Category> {
        val list = mutableListOf<Category>()
        withContext(Dispatchers.IO) {
            list.addAll(createCategory())
        }
        return list
    }

    private fun createCategory(): List<Category> {
        return listOf(
            Category(
                1,
                "문화"
            ),
            Category(
                2,
                "문화2"
            ),
            Category(
                3,
                "기타"
            )
        )
    }
}