package com.ahmad.aghazadeh.moviesta.screens.Home

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ahmad.aghazadeh.moviesta.data.getMovies
import com.ahmad.aghazadeh.moviesta.navigation.MovieScreens
import com.ahmad.aghazadeh.moviesta.widgets.MovieRow

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
        items(getMovies().size) {
            MovieRow(getMovies()[it]){ movieItem ->
                navController.navigate(route = MovieScreens.DetailsScreen.name+"/${movieItem.title}")
            }
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


