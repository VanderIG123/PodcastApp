package com.podcastapp.podcastapp

import android.app.Application
import android.content.Context


class PodcastApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}