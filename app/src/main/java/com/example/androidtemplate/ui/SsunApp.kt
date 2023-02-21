package com.example.androidtemplate.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidtemplate.navigation.SsunNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun SsunApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        SsunNavHost(
            modifier = Modifier.fillMaxSize().padding(padding),
            navController = rememberAnimatedNavController(),
        )
    }
}