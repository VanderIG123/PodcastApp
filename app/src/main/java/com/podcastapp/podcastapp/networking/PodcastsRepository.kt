package com.podcastapp.podcastapp.networking

import android.util.Log
import com.podcastapp.podcastapp.mods.Podcast
import com.podcastapp.podcastapp.mods.PodcastsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PodcastsRepository {
    private var podcastsService: PodcastsService? = null

    init {
        podcastsService = Retrofit.Builder()
            .baseUrl("https://listen-api-test.listennotes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PodcastsService::class.java)
    }


    suspend fun fetchAllPodcasts(): Flow<PodcastsResponse?> {
        val podcasts = podcastsService?.fetchPodcasts()
        return flow { emit(podcasts) }
    }
}