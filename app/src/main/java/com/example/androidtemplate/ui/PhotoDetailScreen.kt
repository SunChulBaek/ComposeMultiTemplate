package com.example.androidtemplate.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage

@Composable
fun PhotoDetailRoute(
    title: String?,
    url: String,
    navigate: (String, Any?) -> Unit,
) {
    PhotoDetailScreen(
        title = title ?: "",
        url = url,
        navigate = navigate,
    )
}

@Composable
fun PhotoDetailScreen(
    title: String,
    url: String,
    navigate: (String, Any?) -> Unit,
) = Column(modifier = Modifier.fillMaxSize()) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        model = url,
        loading = {
            CircularProgressIndicator(
                modifier = Modifier.padding(24.dp),
                color = MaterialTheme.colorScheme.primary
            )
        },
        contentDescription = null
    )
    Text(text = title)
}