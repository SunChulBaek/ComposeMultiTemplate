package kr.pe.ssun.template.feature.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.pe.ssun.template.core.model.Photo
import kr.pe.ssun.template.core.ui.ErrorScreen
import kr.pe.ssun.template.core.ui.LoadingScreen
import kr.pe.ssun.template.core.ui.photoItems
import kr.pe.ssun.template.feature.main.MainUiState.*

@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    navigate: (String, Any?) -> Unit,
) {
    val mainState by viewModel.uiState.collectAsStateWithLifecycle()

    MainScreen(
        mainState = mainState,
        onClickItem = { item -> navigate("photo_detail", Pair(item.title, item.url)) },
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    mainState: MainUiState,
    onClickItem: (Photo) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    Box(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)) {
        when (mainState) {
            Loading -> LoadingScreen()
            Error -> ErrorScreen()
            is Success -> {
                LazyColumn(
                    state = listState,
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
    onClickItem: (Photo) -> Unit
) {
    photoItems(
        items = (mainState as Success).photos,
        onClickItem = onClickItem,
        itemModifier = Modifier.padding(top = 10.dp)
    )
}