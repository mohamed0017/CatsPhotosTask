package com.personal.myapplication.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel : HomeViewModel = viewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getPhotos()
    }

    Column(modifier.fillMaxSize()) {

        if (state.errorMessage.isNotEmpty())
            Text(state.errorMessage)


        Button(onClick ={
            viewModel.getPhotos()
        }) {

            Text("Refresh")
        }

        LazyColumn {
            items(state.photos, key = { it }){
                AsyncImage(
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    model = it,
                    contentDescription = ""
                )
                Spacer(Modifier.height(20.dp))
            }
        }

    }
}