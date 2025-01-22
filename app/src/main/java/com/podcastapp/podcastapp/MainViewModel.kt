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


    fun fetchAllPodcasts() {
        viewModelScope.launch(Dispatchers.IO) {
            PodcastsRepository.fetchAllPodcasts().collect { podcasts ->
                _podcasts.emit(podcasts?.podcasts ?: listOf())
            }
        }
    }

}