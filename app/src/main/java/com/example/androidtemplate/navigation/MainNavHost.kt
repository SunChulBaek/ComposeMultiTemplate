package com.example.androidtemplate.navigation

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    showToast: (String) -> Toast,
    onBack: () -> Unit,
    startDestination: String = homeNavigationRoute,
) {
    AnimatedNavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        // 홈
        homeScreen(
            enterTransition = defaultEnterTransition(),
            exitTransition = defaultExitTransition(),
            popEnterTransition = defaultPopEnterTransition(),
            popExitTransition = defaultPopExitTransition(),
            navigate = { dest, params -> navigate(navController, dest, params) },
            showToast = showToast,
            onBack = onBack,
        )
        // 포토
        photoDetailScreen(
            enterTransition = defaultEnterTransition(),
            exitTransition = defaultExitTransition(),
            popEnterTransition = defaultPopEnterTransition(),
            popExitTransition = defaultPopExitTransition(),
            navigate = { dest, params -> navigate(navController, dest, params) },
            showToast = showToast,
            onBack = onBack,
        )
    }
}

fun defaultEnterTransition(): EnterTransition = slideInHorizontally(
    initialOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultExitTransition(): ExitTransition = slideOutHorizontally(
    targetOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultPopEnterTransition(): EnterTransition = slideInHorizontally(
    initialOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultPopExitTransition(): ExitTransition = slideOutHorizontally(
    targetOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun navigate(
    navController: NavHostController,
    dest: String,
    params: Any? = null,
) {
    when (dest) {
        photoDetailNavigationRoute -> (params as? Pair<*, *>)?.let { (title, url) ->
            navController.navigateToPhotoDetail(title as String, url as String)
        }
        else -> TODO()
    }
}