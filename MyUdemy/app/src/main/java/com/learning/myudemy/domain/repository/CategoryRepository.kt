package com.learning.myudemy.domain.repository

import com.learning.myudemy.domain.model.Category
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
                "웹"
            ),
            Category(
                2,
                "파이썬"
            ),
            Category(
                3,
                "리엑트"
            )
        )
    }
}