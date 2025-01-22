package com.podcastapp.podcastapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.podcastapp.podcastapp.mods.Podcast
import com.podcastapp.podcastapp.navigation.Screen


@Composable
fun PodcastsHome(
    modifier: Modifier = Modifier,
    navController: NavController,
    podcasts: List<Podcast>
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(top = 15.dp)) {
        Text(
            text = stringResource(R.string.podcasts),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
        )
        LazyColumn {
            items(podcasts) { podcast ->
                PodcastItem(podcast) {
                    navController.navigate(Screen.PodcastDetail.name)
                }
            }
        }
    }
}

@Composable
fun PodcastItem(podcast: Podcast, onPodcastClicked: () -> Unit) {
    Column(modifier = Modifier.clickable { onPodcastClicked() }) {
        Row {
            AsyncImage(
                model = podcast.iconUrl,
                modifier = Modifier.size(15.dp),
                contentDescription = null,
            )

            Column(modifier = Modifier.padding(top = 25.dp)) {
                Text(
                    text = podcast.name,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
                )
                Text(text = podcast.hostName, color = Color.Gray)
                Text(text = stringResource(R.string.favourited), color = Color.Red)
            }

        }
        Divider(modifier = Modifier.padding(horizontal = 15.dp))
    }

}


@Composable
@Preview(showBackground = true)
fun previewPodcastsHome() {

}