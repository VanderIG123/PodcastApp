package com.podcastapp.podcastapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podcastapp.podcastapp.mods.Podcast
import com.podcastapp.podcastapp.networking.PodcastsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _podcasts = MutableStateFlow<List<Podcast>>(listOf())
    val podcasts: StateFlow<List<Podcast>> = _podcasts

    var selectedPodcast: Podcast? = null

    private var currentPodcastFetchingPage = 1


    fun fetchMorePodcasts() {
        viewModelScope.launch(Dispatchers.IO) {
            PodcastsRepository.fetchAllPodcasts(currentPodcastFetchingPage).collect { podcasts ->
                val currentPodcastsList = ArrayList(_podcasts.value)
                currentPodcastsList.addAll(podcasts?.podcasts ?: listOf())
                _podcasts.emit(currentPodcastsList)
                currentPodcastFetchingPage++
            }
        }
    }

}