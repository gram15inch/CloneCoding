package com.learning.myudemy.presentation.recommendation

import androidx.lifecycle.ViewModel
import com.learning.myudemy.R
import com.learning.myudemy.domain.Lecture
import com.learning.myudemy.presentation.adapter.LectureAdapter
import javax.inject.Inject


class RecommendationViewModel @Inject constructor() : ViewModel() {

    val webLectures = getWebList()
    val reactLectures = getReactList()
    val pythonLectures = getPythonList()

    private fun getWebList():List<Lecture>{
        return listOf(
            Lecture(0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                4.8F,
                360,
                109000,
                R.drawable.tn_web1,
                true
                ),
            Lecture(1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                4.7F,
                181,
                109000,
                R.drawable.tn_web2,
                false
            ),
            Lecture(2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                4.5F,
                871,
                129000,
                R.drawable.tn_web3,
                false
            ),
            Lecture(3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                4.5F,
                360,
                129000,
                R.drawable.tn_web4,
                false
            ),
            Lecture(4,
                "The Complete 2020 Fullstack Web Developer CourseLearn HTML5, CSS3, JavaScript, Python, Wagtail CMS, PHP",
                "Kalob Taulien",
                4.8F,
                360,
                129000,
                R.drawable.tn_web5,
                false
            ),


            )
    }
    private fun getReactList():List<Lecture>{
        return listOf(
            Lecture(0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                4.8F,
                360,
                109000,
                R.drawable.tn_react1,
                true
            ),
            Lecture(1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                4.7F,
                181,
                109000,
                R.drawable.tn_react2,
                false
            ),
            Lecture(2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                4.5F,
                871,
                129000,
                R.drawable.tn_react3,
                false
            ),
            Lecture(3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                4.5F,
                360,
                129000,
                R.drawable.tn_react4,
                false
            ),
            Lecture(4,
                "The Complete 2020 Fullstack Web Developer CourseLearn HTML5, CSS3, JavaScript, Python, Wagtail CMS, PHP",
                "Kalob Taulien",
                4.8F,
                360,
                129000,
                R.drawable.tn_react5,
                false
            ),


            )
    }
    private fun getPythonList():List<Lecture>{
        return listOf(
            Lecture(0,
                "☕ 블랙커피 Vanilla JS Lv1. 문벅스 카페 메뉴 앱 만들기Vanilla Javascript로 만들어보는 상태관리가 가능한 카페 메뉴",
                "Maker Jun",
                4.8F,
                360,
                109000,
                R.drawable.tn_python1,
                true
                ),
            Lecture(1,
                "【한글자막】 100일 코딩 챌린지 - Web Development 부트캠프100일 안에 여러분을 웹 개발자로 만들어 드리겠습니다.",
                "Academind by Maximilian Schwarzmüller, Maximilian Schwarzmüller, Manuel Lorenz",
                4.7F,
                181,
                109000,
                R.drawable.tn_python2,
                false
            ),
            Lecture(2,
                "Become a Certified HTML, CSS, JavaScript Web DeveloperComplete coverage of HTML, CSS",
                "Kalob Taulien",
                4.5F,
                871,
                129000,
                R.drawable.tn_python3,
                false
            ),
            Lecture(3,
                "【한글자막】 The Web Developer 부트캠프 2023전세계 25만명이 선택한 유데미 베스트셀러! ",
                "Maker Jun",
                4.5F,
                360,
                129000,
                R.drawable.tn_python4,
                false
            )


            )
    }
}