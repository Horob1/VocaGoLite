package com.horob1.vocagolite.presentation.screen.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.horob1.vocagolite.presentation.common.UiState
import com.horob1.vocagolite.presentation.common.components.ErrorBox
import com.horob1.vocagolite.presentation.common.components.LoadingBox
import com.horob1.vocagolite.presentation.screen.onboarding.components.ChangeLanguageDialog
import com.horob1.vocagolite.presentation.screen.onboarding.components.ChooseLanguagePage
import com.horob1.vocagolite.presentation.screen.onboarding.components.ChooseThemePage
import com.horob1.vocagolite.presentation.screen.onboarding.components.OnBoardingContentPage
import com.horob1.vocagolite.presentation.screen.onboarding.components.PageController
import com.horob1.vocagolite.presentation.screen.onboarding.components.PagerIndicator
import com.horob1.vocagolite.presentation.ui.theme.dimens
import com.horob1.vocagolite.util.LocalizeUtil
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

/**
 * OnBoarding Screen - Main entry point
 *
 * Contains 5 pages:
 * 1-3: Introduction pages
 * 4: Language selection
 * 5: Theme selection
 */
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = koinViewModel(),
    onCompleteOnBoarding: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val dimens = MaterialTheme.dimens
    val context = LocalContext.current

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { OnBoardingPageData.TOTAL_PAGES }
    )
    val scope = rememberCoroutineScope()

    // Dialog state
    var dialogState by remember { mutableStateOf(LanguageDialogState()) }

    when (uiState) {
        is UiState.Loading, is UiState.Idle -> {
            LoadingBox(showBlurBackground = false)
        }

        is UiState.Error -> {
            ErrorBox(
                message = (uiState as UiState.Error).message,
                title = "Oops!",
                showRetryButton = false,
                showBackground = false
            )
        }

        is UiState.Success -> {
            val settings = (uiState as UiState.Success<OnBoardingUiState>).data
            Scaffold { innerPadding ->

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    // Pager
                    HorizontalPager(
                        modifier = Modifier.weight(1f),
                        state = pagerState,
                        verticalAlignment = Alignment.Top,
                        beyondViewportPageCount = 1
                    ) { page ->
                        val pageOffset =
                            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                        val isCurrentPage = pagerState.currentPage == page

                        when (page) {
                            in 0..2 -> {
                                OnBoardingContentPage(
                                    pageData = OnBoardingPageData.pages[page],
                                    pageOffset = pageOffset,
                                    isCurrentPage = isCurrentPage
                                )
                            }

                            3 -> {
                                ChooseLanguagePage(
                                    currentLanguage = settings.appLanguage,
                                    onLanguageSelected = { language ->
                                        if (language != settings.appLanguage) {
                                            dialogState = LanguageDialogState(
                                                isVisible = true,
                                                pendingLanguage = language
                                            )
                                        }
                                    },
                                    pageOffset = pageOffset,
                                    isCurrentPage = isCurrentPage
                                )
                            }

                            4 -> {
                                ChooseThemePage(
                                    currentTheme = settings.appTheme,
                                    onThemeSelected = { viewModel.setAppTheme(it) },
                                    pageOffset = pageOffset,
                                    isCurrentPage = isCurrentPage
                                )
                            }
                        }
                    }

                    // Pager Indicator
                    PagerIndicator(
                        pageCount = OnBoardingPageData.TOTAL_PAGES,
                        currentPage = pagerState.currentPage,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = dimens.spaceSM)
                    )

                    // Navigation Controller
                    PageController(
                        currentPage = pagerState.currentPage,
                        pageCount = OnBoardingPageData.TOTAL_PAGES,
                        onPrevious = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        },
                        onNext = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                        onComplete = {
                            viewModel.completeOnBoarding()
                            onCompleteOnBoarding()
                        },
                        modifier = Modifier.padding(
                            horizontal = dimens.paddingScreen,
                            vertical = dimens.spaceSM
                        )
                    )
                }
            }

            // Language Change Dialog
            if (dialogState.isVisible && dialogState.pendingLanguage != null) {
                ChangeLanguageDialog(
                    onDismiss = {
                        dialogState = LanguageDialogState()
                    },
                    onConfirm = {
                        dialogState.pendingLanguage?.let { language ->
                            viewModel.setAppLanguage(language)
                            LocalizeUtil.changeLanguage(context, language.languageCode)
                        }
                        dialogState = LanguageDialogState()
                    }
                )
            }
        }
    }
}
