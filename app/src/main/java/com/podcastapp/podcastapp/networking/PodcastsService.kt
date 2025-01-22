package com.podcastapp.podcastapp.networking

import com.podcastapp.podcastapp.mods.PodcastsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastsService {

    @GET("/api/v2/best_podcasts")
    suspend fun fetchPodcasts(@Query("page") page: Int) : PodcastsResponse
}