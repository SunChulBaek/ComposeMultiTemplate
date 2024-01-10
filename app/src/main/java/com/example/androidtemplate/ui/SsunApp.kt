package com.example.androidtemplate.ui

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.androidtemplate.navigation.MainNavHost

@Composable
fun SsunApp(
    showToast: (String) -> Toast,
    onBack: () -> Unit,
) = MainNavHost(
    modifier = Modifier.fillMaxSize(),
    navController = rememberNavController(),
    showToast = showToast,
    onBack = onBack,
)