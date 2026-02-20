package com.horob1.vocagolite.presentation.screen.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.horob1.vocagolite.R

/**
 * Sealed class representing OnBoarding page data
 */
sealed class OnBoardingPageData(
    @param:StringRes val title: Int,
    @param:StringRes val description: Int,
    @param:DrawableRes val image: Int
) {
    data object Welcome : OnBoardingPageData(
        title = R.string.onboarding_title_1,
        description = R.string.onboarding_desc_1,
        image = R.drawable.onboarding_2
    )

    data object LearnVocabulary : OnBoardingPageData(
        title = R.string.onboarding_title_2,
        description = R.string.onboarding_desc_2,
        image = R.drawable.onboarding_3
    )

    data object ExploreWithFriends : OnBoardingPageData(
        title = R.string.onboarding_title_3,
        description = R.string.onboarding_desc_3,
        image = R.drawable.onboarding_1
    )

    companion object {
        val pages = listOf(Welcome, LearnVocabulary, ExploreWithFriends)
        const val TOTAL_PAGES = 5 // 3 intro + language + theme
    }
}
