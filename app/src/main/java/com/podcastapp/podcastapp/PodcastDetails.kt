package com.podcastapp.podcastapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
    var isFavouritted by remember { mutableStateOf(FavouritesManager.isFavourite(podcast!!)) }
    Box(modifier = modifier.fillMaxSize()) {
        BackBtn(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 5.dp)
        ) {
            navController.navigateUp()
        }
        LazyColumn(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 60.dp)
                .padding(horizontal = 15.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = podcast?.title ?: "",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
                )
                Text(text = podcast?.publisher ?: "", color = Color.Gray)
                AsyncImage(
                    model = podcast?.thumbnail,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(300.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentDescription = null,
                )

                Button(modifier = Modifier.padding(top = 15.dp), onClick = {
                    if (!isFavouritted) FavouritesManager.savePodcastFavourite(podcast!!)
                    else FavouritesManager.deletePodcastFavourite(podcast!!)

                    isFavouritted = FavouritesManager.isFavourite(podcast!!)
                }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.pink))) {
                    Text(text = stringResource(if (isFavouritted) R.string.favourited else R.string.favourite))
                }

                Text(
                    text = podcast?.description ?: "",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(15.dp)
                )
            }
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
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = stringResource(R.string.back),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun previewPodcastDetails() {

}