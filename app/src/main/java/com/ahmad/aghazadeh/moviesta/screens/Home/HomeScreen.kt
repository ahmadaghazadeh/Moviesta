package com.ahmad.aghazadeh.moviesta.screens.Home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahmad.aghazadeh.moviesta.R
import com.ahmad.aghazadeh.moviesta.data.MovieItem
import com.ahmad.aghazadeh.moviesta.navigation.MovieNavigation
import com.ahmad.aghazadeh.moviesta.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    MainContent(navController)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MainContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarContent()
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* fab click handler */ }
            ) {
                Text("Inc")
            }
        },
        content = { innerPadding ->
            MainContent(innerPadding,navController)
        }
    )
}


@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun MainContent(
    innerPadding: PaddingValues,
    navController: NavController
) {
    LazyColumn(
        // consume insets as scaffold doesn't do it by default
        modifier = Modifier.consumeWindowInsets(innerPadding),
        contentPadding = innerPadding
    ) {
        items(getMovieList().size) {
            MovieItem(getMovieList()[it]){movieItem ->
                navController.navigate(route = MovieScreens.DetailsScreen.name+"/${movieItem.name}")
            }
        }
    }
}

@Composable
private fun MovieItem(movie: MovieItem, onItemClick: (MovieItem) -> Unit = {}) {
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
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape= RectangleShape
            ) {
                Icon(Icons.Default.Face, contentDescription = stringResource(R.string.movie_image_description))
            }
            Text(text = "${movie.name}")
        }

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBarContent() {
    TopAppBar(
        title = { Text("Simple Scaffold Screen") },
        navigationIcon = {
            IconButton(
                onClick = { /* "Open nav drawer" */ }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Localized description")
            }
        }
    )
}

fun getMovieList(): List<MovieItem> {
    return listOf(
        MovieItem("Avatar","http://avatar.png"),
        MovieItem("300","http://avatar.png"),
        MovieItem("Harry Patter","http://avatar.png"),
        MovieItem("Rambo","http://avatar.png"),
    )
}

