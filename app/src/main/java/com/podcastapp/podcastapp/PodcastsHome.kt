package com.podcastapp.podcastapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.podcastapp.podcastapp.mods.Podcast
import com.podcastapp.podcastapp.navigation.Screen


@Composable
fun PodcastsHome(
    modifier: Modifier = Modifier,
    navController: NavController,
    mainViewModel: MainViewModel

) {
    val podcasts = mainViewModel.podcasts.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.fetchMorePodcasts()
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.podcasts),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
        )

        val state = rememberLazyListState()
        LazyColumn(state = state) {
            items(podcasts.value) { podcast ->
                PodcastItem(podcast) {
                    mainViewModel.selectedPodcast = podcast
                    navController.navigate(Screen.PodcastDetail.name)
                }
            }
        }

        val isBottomOfListReached = !state.canScrollForward
        LaunchedEffect(isBottomOfListReached) {
            if (isBottomOfListReached) mainViewModel.fetchMorePodcasts()
        }
    }
}

@Composable
fun PodcastItem(podcast: Podcast, onPodcastClicked: () -> Unit) {
    Column(modifier = Modifier.clickable { onPodcastClicked() }) {
        Row(modifier = Modifier.padding(top = 25.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(podcast.thumbnail)
                    .build(),
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentDescription = null,
            )

            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = podcast.title ?: "",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
                )
                Text(
                    text = podcast.publisher ?: stringResource(R.string.unknown),
                    color = Color.Gray,style = TextStyle( fontSize = 15.sp)
                )
                if (FavouritesManager.isFavourite(podcast))
                    Text(text = stringResource(R.string.favourited), color = colorResource(R.color.pink))
            }


        }
        Divider(modifier = Modifier.padding(horizontal = 10.dp).padding(top = 15.dp))
    }

}


@Composable
@Preview(showBackground = true)
fun previewPodcastsHome() {

}