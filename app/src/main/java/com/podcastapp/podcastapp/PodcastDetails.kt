package com.podcastapp.podcastapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage


@Composable
fun PodcastDetails(
    modifier: Modifier = Modifier,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    val podcast = mainViewModel.selectedPodcast
    Box(modifier = modifier.fillMaxSize()) {
        BackBtn(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 5.dp)
        ) {
            navController.navigateUp()
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 60.dp)
                .padding(horizontal = 15.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = podcast?.title ?: "",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
            )
            Text(text = podcast?.publisher ?: "", color = Color.Gray)
            AsyncImage(
                model = podcast?.thumbnail,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
            )

            Button(onClick = {}) {
                Text(text = stringResource(R.string.favourite))
            }

            Text(
                text = podcast?.description ?: "",
                color = Color.Gray,
                textAlign = TextAlign.Center
            )


        }

    }
}

@Composable
fun BackBtn(modifier: Modifier, onBackBtnClicked: () -> Unit) {
    Row(
        modifier = modifier.clickable { onBackBtnClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.back_icn),
            stringResource(R.string.back_btn),
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = stringResource(R.string.back),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun previewPodcastDetails() {

}