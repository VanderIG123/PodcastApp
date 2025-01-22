package com.podcastapp.podcastapp.mods

data class PodcastsResponse(val name:String,val page_number:Int,val podcasts: List<Podcast>)