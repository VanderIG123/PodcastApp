package com.podcastapp.podcastapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.podcastapp.podcastapp.mods.Podcast
import com.podcastapp.podcastapp.ui.theme.PodcastAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PodcastAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PodcastDetails(
                        modifier = Modifier.padding(innerPadding),
                        Podcast(
                            1,
                            "The Indicator from Planet Money",
                            "NPR",
                            "https://cdn-images-3.listennotes.com/podcasts/the-diary-of-a-ceo-with-steven-bartlett-doac-wSgVQrueZOJ-Gflmgre3zuU.800x800.jpg",
                            "A few years ago I was a broke, university dropout, at 18 I built an industry leading social media marketing company, and at 27 I resigned as CEO. At 28 I co-founded Flight Story – a marketing and communications company, and thirdweb - a software platform, making it easy to build web3 applications. I then launched private equity fund, Flight Fund, to accelerate the next generation of European unicorns. During this time I decided to launch 'The Diary Of A CEO' podcast with the simple mission of providing an unfiltered journey into the remarkable stories and untold dimensions of the world’s most influential people, experts and thinkers. Thank you for listening. My New Book: https://g2ul0.app.link/DOAC IG: https://www.instagram.com/steven LI: https://www.linkedin.com/in/stevenbartlett-123"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PodcastAppTheme {
        Greeting("Android")
    }
}