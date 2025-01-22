package com.podcastapp.podcastapp.navigation

sealed class Screen(val name: String) {
    object PodcastsHome : Screen("Home")
    object PodcastDetail : Screen("PodcastDetail")
}