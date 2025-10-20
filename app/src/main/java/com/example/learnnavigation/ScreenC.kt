package com.example.learnnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenC(navController: NavController, movieViewModel: MovieViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Text(
                text = "My Watchlist",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        if (movieViewModel.watchlist.isEmpty()) {
            item {
                Text("No movies in watchlist")
            }
        } else {
            items(movieViewModel.watchlist) { movie ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = movie.posterRes),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(movie.title)
                            Button(onClick = {
                                movieViewModel.removeFromWatchlist(movie)
                            }) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Go Back")
            }
        }
    }
}
