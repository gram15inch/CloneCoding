package com.learning.myudemy

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.learning.myudemy.UdemyApplication.Companion.LECTURE_API_KEY
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

class TimberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        //return "${element.fileName}:${element.lineNumber}#${element.methodName}"
        return "#${element.methodName}"
    }
}
class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }
}

@HiltAndroidApp
class UdemyApplication:Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
        const val LECTURE_API_KEY = BuildConfig.LECTURE_API_KEY
        const val LECTURE_BASE_URL = "http://apis.data.go.kr/B552881/kmooc/"
        const val LECTURE_BASE_URL2 = "http://www.kmooc.kr/api/courses/"
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }
        prefs = PreferenceUtil(applicationContext)
    }

}