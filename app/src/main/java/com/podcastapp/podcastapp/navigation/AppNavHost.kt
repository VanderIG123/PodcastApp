package com.podcastapp.podcastapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.podcastapp.podcastapp.MainViewModel
import com.podcastapp.podcastapp.PodcastDetails
import com.podcastapp.podcastapp.PodcastsHome
import com.podcastapp.podcastapp.mods.Podcast


@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel()
) {

    NavHost(
        navController = navController,
        startDestination = Screen.PodcastsHome.name
    ) {
        composable(Screen.PodcastsHome.name) {
            PodcastsHome(
                modifier, navController, listOf(
                    Podcast(
                        "",
                        "The Indicator from Planet Money",
                        "NPR",
                        "https://cdn-images-3.listennotes.com/podcasts/the-diary-of-a-ceo-with-steven-bartlett-doac-wSgVQrueZOJ-Gflmgre3zuU.800x800.jpg",
                        "A few years ago I was a broke, university dropout, at 18 I built an industry leading social media marketing company, and at 27 I resigned as CEO. At 28 I co-founded Flight Story – a marketing and communications company, and thirdweb - a software platform, making it easy to build web3 applications. I then launched private equity fund, Flight Fund, to accelerate the next generation of European unicorns. During this time I decided to launch 'The Diary Of A CEO' podcast with the simple mission of providing an unfiltered journey into the remarkable stories and untold dimensions of the world’s most influential people, experts and thinkers. Thank you for listening. My New Book: https://g2ul0.app.link/DOAC IG: https://www.instagram.com/steven LI: https://www.linkedin.com/in/stevenbartlett-123"
                    ),
                    Podcast(
                        "",
                        "The Indicator from Planet Money",
                        "NPR",
                        "https://cdn-images-3.listennotes.com/podcasts/the-diary-of-a-ceo-with-steven-bartlett-doac-wSgVQrueZOJ-Gflmgre3zuU.800x800.jpg",
                        "A few years ago I was a broke, university dropout, at 18 I built an industry leading social media marketing company, and at 27 I resigned as CEO. At 28 I co-founded Flight Story – a marketing and communications company, and thirdweb - a software platform, making it easy to build web3 applications. I then launched private equity fund, Flight Fund, to accelerate the next generation of European unicorns. During this time I decided to launch 'The Diary Of A CEO' podcast with the simple mission of providing an unfiltered journey into the remarkable stories and untold dimensions of the world’s most influential people, experts and thinkers. Thank you for listening. My New Book: https://g2ul0.app.link/DOAC IG: https://www.instagram.com/steven LI: https://www.linkedin.com/in/stevenbartlett-123"
                    )
                ),
                mainViewModel
            )
        }
        composable(Screen.PodcastDetail.name) {
            PodcastDetails(modifier, navController, mainViewModel)
        }
    }


}