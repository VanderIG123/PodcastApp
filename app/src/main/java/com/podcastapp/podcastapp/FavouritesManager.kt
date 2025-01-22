package com.podcastapp.podcastapp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.provider.Contacts.SettingsColumns.KEY
import com.google.gson.Gson
import com.podcastapp.podcastapp.mods.Podcast


object FavouritesManager {
    private const val FAVOURITE_PODCASTS_PREFERENCES = "FAVOURITE_PODCASTS_PREFERENCES"
    private const val FAVOURITE_PODCASTS = "FAVOURITE_PODCASTS"
    private lateinit var podcastFavourites: PodcastFavourites

    init {
        podcastFavourites = fetchPodcastFavouritesList()
    }


    fun isFavourite(podcast: Podcast): Boolean {
        return podcastFavourites.isFavouritePodcast(podcast)
    }

    fun savePodcastFavourite(podcast: Podcast) {
        podcastFavourites.addNewFavourite(podcast)
        savePodcastFavouriteList()
    }

    fun deletePodcastFavourite(podcast: Podcast) {
        podcastFavourites.deletePodcastFavourite(podcast)
        savePodcastFavouriteList()

    }

    private fun savePodcastFavouriteList() {
        val sharedPreferences =
            PodcastApp.appContext?.getSharedPreferences(
                FAVOURITE_PODCASTS_PREFERENCES,
                MODE_PRIVATE
            )
        val editor = sharedPreferences?.edit()
        editor?.putString(FAVOURITE_PODCASTS, Gson().toJson(podcastFavourites))
        editor?.apply()
    }

    private fun fetchPodcastFavouritesList(): PodcastFavourites {
        val sharedPreferences =
            PodcastApp.appContext?.getSharedPreferences(
                FAVOURITE_PODCASTS_PREFERENCES,
                MODE_PRIVATE
            )

        val favouritesListJson = sharedPreferences?.getString(FAVOURITE_PODCASTS, "")
        val favouritesList = Gson().fromJson(favouritesListJson, PodcastFavourites::class.java)
        return favouritesList ?: PodcastFavourites(ArrayList())
    }
}


class PodcastFavourites(private val favouritePodcastIds: ArrayList<String>) {


    fun isFavouritePodcast(podcast: Podcast): Boolean {
        return favouritePodcastIds.count { it == podcast.id } > 0
    }

    fun addNewFavourite(podcast: Podcast) {
        favouritePodcastIds.add(podcast.id)
    }

    fun deletePodcastFavourite(podcast: Podcast) {
        favouritePodcastIds.removeIf { it == podcast.id }
    }

}