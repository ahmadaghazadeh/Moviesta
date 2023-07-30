package com.ahmad.aghazadeh.moviesta.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.ahmad.aghazadeh.moviesta.R
import com.ahmad.aghazadeh.moviesta.data.MovieItem
import com.ahmad.aghazadeh.moviesta.data.getMovies

@Preview
@Composable
public fun MovieRow(movie: MovieItem= getMovies()[0], onItemClick: (MovieItem) -> Unit = {}) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .height(150.dp)
        .clickable {
            onItemClick(movie)
        },
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )) {
        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Start)  {
            AsyncImage(
                model = movie.poster,
                contentDescription = stringResource(R.string.movie_image_description),
                modifier = Modifier.clip(CircleShape).size(100.dp),
                )
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = "${movie.title}", style = MaterialTheme.typography.headlineLarge)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.labelLarge)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.labelLarge)
            }

        }

    }
}
