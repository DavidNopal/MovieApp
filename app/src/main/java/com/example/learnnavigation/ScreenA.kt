package com.example.learnnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
fun ScreenA(navController: NavController, movieViewModel: MovieViewModel) {
    val movies = movieViewModel.movies

    // Background color
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            // Title
            item {
                Text(
                    text = "Movie List",
                    fontSize = 50.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(16.dp)
                )
            }

            // Movie list
            items(movies) { movie ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable { navController.navigate("${Routes.screenB}/${movie.id}") },
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = movie.posterRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                movie.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Button(
                                onClick = { navController.navigate("${Routes.screenB}/${movie.id}") },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                Text("More details", color = MaterialTheme.colorScheme.onPrimary)
                            }
                        }
                    }
                }
            }

            // Bottom button
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(Routes.screenC) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Go to Watchlist", color = MaterialTheme.colorScheme.onPrimary)
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
