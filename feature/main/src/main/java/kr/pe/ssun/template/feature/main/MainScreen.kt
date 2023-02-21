package kr.pe.ssun.template.feature.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.pe.ssun.template.core.domain.model.DPhoto
import kr.pe.ssun.template.core.ui.photoItems
import kr.pe.ssun.template.feature.main.MainUiState.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val mainState by viewModel.mainUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getProduct()
    }

    MainScreen(
        mainState = mainState,
        onClickItem = viewModel::onClick,
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    mainState: MainUiState,
    onClickItem: (DPhoto) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyListState()
    Box(modifier = modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        when (mainState) {
            Loading -> { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) }
            Error -> {}
            is Success -> {
                LazyColumn(
                    state = state,
                ) {
                    MainBody(
                        mainState = mainState,
                        onClickItem = onClickItem,
                    )
                }
            }
        }
    }
}

private fun LazyListScope.MainBody(
    mainState: MainUiState,
    onClickItem: (DPhoto) -> Unit
) {
    photoItems(
        items = (mainState as Success).photos,
        onClickItem = onClickItem,
        itemModifier = Modifier.padding(top = 10.dp)
    )
}