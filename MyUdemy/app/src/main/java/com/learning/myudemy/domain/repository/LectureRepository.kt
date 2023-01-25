package com.learning.myudemy.domain.repository

import com.learning.myudemy.R
import com.learning.myudemy.data.remote.LectureApiService
import com.learning.myudemy.data.remote.model.lecture.LectureResponse
import com.learning.myudemy.domain.converter.DomainConverter
import com.learning.myudemy.domain.model.Lecture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class LectureRepository @Inject constructor(
    private val lectureInterface: LectureApiService
) {
    // todo 로컬 데이터로 캐시

    suspend fun getLectureListWithApi(id: Int): List<Lecture> {
        return lectureInterface.getLectures(page = id)
            .remoteLectures
            .map {
                DomainConverter.toLecture(it)
            }
    }

    suspend fun getLectureListWithApiErrorHandle(id: Int): List<Lecture> {
        return lectureInterface.getLecturesWithResponse(page = id).run {
            if (this.isSuccessful) {
                Timber.tag("errorHandle").d("is successful true")
                Timber.tag("errorHandle").d("code: ${this.code()}")
                Timber.tag("errorHandle").d("errorBody: ${this.errorBody()}")
                Timber.tag("errorHandle").d("message: ${this.message()}")
                Timber.tag("errorHandle").d("headers: ${this.headers()}")
                this.body()?.remoteLectures?.map {
                    DomainConverter.toLecture(it)
                } ?: emptyList()
            } else {
                Timber.tag("errorHandle").d("is successful false")
                Timber.tag("errorHandle").d("errorBody: ${this.errorBody()}")
                Timber.tag("errorHandle").d("code: ${this.code()}")
                Timber.tag("errorHandle").d("message: ${this.message()}")
                Timber.tag("errorHandle").d("headers: ${this.headers()}")
                emptyList()
            }
        }


    }


    suspend fun getLectureListWithRes(id: Int): List<Lecture> {
        val list = mutableListOf<Lecture>()
        withContext(Dispatchers.IO) {
            when (id) {
                1 -> list.addAll(getWebList())
                2 -> list.addAll(getReactList())
                3 -> list.addAll(getPythonList())
                4 -> list.addAll(getMyLearningList())
                else -> {}
            }
        }
        return list
    }

    private fun getWebList(): List<Lecture> {
        return listOf(
            Lecture(
                0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                "",
                "",
                4.8F,
                360,
                109000,
                "",
                R.drawable.tn_web1,
                "",
                true
            ),
            Lecture(
                1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_web2,
                "",
                false
            ),
            Lecture(
                2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_web3,
                "",
                false
            ),
            Lecture(
                3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_web4,
                "",
                false
            ),
            Lecture(
                4,
                "The Complete 2020 Fullstack Web Developer CourseLearn HTML5, CSS3, JavaScript, Python, Wagtail CMS, PHP",
                "Kalob Taulien",
                "",
                "",
                4.8F,
                360,
                129000,
                "",
                R.drawable.tn_web5,
                "",
                false
            ),


            )
    }

    private fun getReactList(): List<Lecture> {
        return listOf(
            Lecture(
                0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                "",
                "",
                4.8F,
                360,
                109000,
                "",
                R.drawable.tn_react1,
                "",
                true
            ),
            Lecture(
                1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_react2,
                "",
                false
            ),
            Lecture(
                2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_react3,
                "",
                false
            ),
            Lecture(
                3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_react4,
                "",
                false
            ),
            Lecture(
                4,
                "The Complete 2020 Fullstack Web Developer CourseLearn HTML5, CSS3, JavaScript, Python, Wagtail CMS, PHP",
                "Kalob Taulien",
                "",
                "",
                4.8F,
                360,
                129000,
                "",
                R.drawable.tn_react5,
                "",
                false
            ),


            )
    }

    private fun getPythonList(): List<Lecture> {
        return listOf(
            Lecture(
                0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                "",
                "",
                4.8F,
                360,
                109000,
                "",
                R.drawable.tn_python1,
                "",
                true
            ),
            Lecture(
                1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_python2,
                "",
                false
            ),
            Lecture(
                2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_python3,
                "",
                false
            ),
            Lecture(
                3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_python4,
                "",
                false
            )


        )
    }

    private fun getMyLearningList(): List<Lecture> {
        return listOf(
            Lecture(
                0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                "",
                "",
                4.8F,
                360,
                109000,
                "",
                R.drawable.tn_python1,
                "",
                true
            ),
            Lecture(
                1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_python2,
                "",
                false
            ),
            Lecture(
                2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_python3,
                "",
                false
            ),
            Lecture(
                3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_python4,
                "",
                false
            ),
            Lecture(
                4,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                "",
                "",
                4.8F,
                360,
                109000,
                "",
                R.drawable.tn_react1,
                "",
                true
            ),
            Lecture(
                5,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_react2,
                "",
                false
            ),
            Lecture(
                6,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_react3,
                "",
                false
            ),
            Lecture(
                7,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_react4,
                "",
                false
            ),
            Lecture(
                8,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                "",
                "",
                4.7F,
                181,
                109000,
                "",
                R.drawable.tn_web1,
                "",
                false
            ),
            Lecture(
                9,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_web2,
                "",
                false
            ),
            Lecture(
                10,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_web3,
                "",
                false
            ),
            Lecture(
                11,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                "",
                "",
                4.5F,
                871,
                129000,
                "",
                R.drawable.tn_web4,
                "",
                false
            ),
            Lecture(
                12,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                "",
                "",
                4.5F,
                360,
                129000,
                "",
                R.drawable.tn_web5,
                "",
                false
            )


        )
    }
}