package com.learning.myudemy.presentation.viewModel

import androidx.lifecycle.*
import com.learning.myudemy.R
import com.learning.myudemy.domain.model.Lecture
import com.learning.myudemy.domain.repository.CategoryRepository
import com.learning.myudemy.domain.repository.LectureRepository
import com.learning.myudemy.presentation.converter.UiConverter
import com.learning.myudemy.presentation.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val lectureRepository: LectureRepository,
    private val categoryRepository: CategoryRepository
) :
    ViewModel() {
    private val _recommendList = MutableStateFlow<List<UiRecommend>>(emptyList())
    val recommendList: LiveData<List<UiRecommend>> get() = _recommendList.asLiveData()

    private var uiRecommendIdx = 0

    init {
        refreshUiRecommendWithCategory()
    }

    private fun refreshUiRecommendWithCategory() {
        viewModelScope.launch {
            categoryRepository
                .getCategoryList()
                .map { category ->
                    UiRecommend(
                        RecommendTag.Lecture,
                        uiRecommendIdx++,
                        title = category.name,
                        lectures = lectureRepository
                            .getLectureListWithApi(category.id)
                            .map { UiConverter.toUiLecture(it) }
                    )
                }.also {
                    _recommendList.emit(it)
                }
        }
    }



    /* 안씀 */
    private fun refreshRecommendListForMultiView() {
        viewModelScope.launch {
            val list = mutableListOf<UiRecommend>()
            list.add(
                UiRecommend(
                    RecommendTag.Banner,
                    uiRecommendIdx++,
                    banner = UiBanner(BannerTag.Image, "url")
                )
            )
            list.add(
                UiRecommend(
                    RecommendTag.Banner,
                    uiRecommendIdx++,
                    banner = UiBanner(BannerTag.Intro)
                )
            )
            list.add(
                UiRecommend(RecommendTag.Lecture,
                    uiRecommendIdx++,
                    lectures = getWebList().map { UiConverter.toUiLecture(it) })
            )
            /*  list.addAll(getUiRecommendWithLectures())
              Timber.tag("getLecture").d("viewModel list: ${list.size}")*/
            _recommendList.value = list

        }
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
}