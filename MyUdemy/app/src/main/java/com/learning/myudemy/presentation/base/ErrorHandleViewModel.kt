package com.learning.myudemy.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

abstract class ErrorHandleViewModel:ViewModel() {

/*
    protected val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()

        when(throwable){
            is SocketException -> {}
            is HttpException -> {}
            is UnknownHostException ->{}
            else -> {}
        }
    }*/
}