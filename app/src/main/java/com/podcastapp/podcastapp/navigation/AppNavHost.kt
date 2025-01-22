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
            PodcastsHome(modifier, navController, mainViewModel)
        }
        composable(Screen.PodcastDetail.name) {
            PodcastDetails(modifier, navController, mainViewModel)
        }
    }
}