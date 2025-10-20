package com.example.learnnavigation

import android.R.attr.name
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenB(navController: NavController, movieViewModel: MovieViewModel, movieId: Int) {
    val movie = movieViewModel.movies.find { it.id == movieId } ?: return

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(movie.title, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text(movie.summary, fontSize = 16.sp)
        Spacer(Modifier.height(8.dp))

        Image(
            painter = painterResource(id = movie.posterRes),
            contentDescription = movie.title,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(24.dp))


        Button(onClick = {movieViewModel.addToWatchlist(movie) }) {
            Text("Add to Watchlist")
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Home")
        }
    }
}
