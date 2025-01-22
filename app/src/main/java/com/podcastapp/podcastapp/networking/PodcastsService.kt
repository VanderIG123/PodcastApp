package com.podcastapp.podcastapp.networking

import com.podcastapp.podcastapp.mods.PodcastsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface PodcastsService {

    @GET("/api/v2/best_podcasts")
    suspend fun fetchPodcasts(): PodcastsResponse
}