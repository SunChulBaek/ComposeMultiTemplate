package com.example.androidtemplate.ui

import android.widget.Toast
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
fun SsunApp(
    showToast: (String) -> Toast,
    onBack: () -> Unit,
) = SsunNavHost(
    modifier = Modifier.fillMaxSize(),
    navController = rememberAnimatedNavController(),
    showToast = showToast,
    onBack = onBack,
)