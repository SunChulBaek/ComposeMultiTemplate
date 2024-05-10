package kr.pe.ssun.template.feature.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.pe.ssun.template.core.event.NavItemReselectEvent
import kr.pe.ssun.template.core.model.Photo
import kr.pe.ssun.template.core.ui.ErrorScreen
import kr.pe.ssun.template.core.ui.LoadingScreen
import kr.pe.ssun.template.core.ui.MainUiState
import kr.pe.ssun.template.core.ui.photoItems
import kr.pe.ssun.template.core.util.EventBus

@Composable
fun MainRoute(
    route: String,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    navigate: (String, Any?) -> Unit,
) {
    val mainState by viewModel.uiState.collectAsStateWithLifecycle()
    val reselectEvent by EventBus.subscribe<NavItemReselectEvent>().collectAsStateWithLifecycle(
        initialValue = NavItemReselectEvent()
    )

    MainScreen(
        route = route,
        reselectEvent = reselectEvent,
        mainState = mainState,
        onClickItem = { item -> navigate("photo_detail", Pair(item.title, item.url)) },
        toggle = viewModel::toggle,
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    route: String,
    reselectEvent: NavItemReselectEvent,
    mainState: MainUiState,
    onClickItem: (Photo) -> Unit,
    toggle: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    LaunchedEffect(reselectEvent) {
        if (reselectEvent.route == route) {
            // TODO : 탭 재선택 시 동작 (ex. 최상단 스크롤)
            listState.animateScrollToItem(0)
        }
    }

    Box(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)) {
        when (mainState) {
            MainUiState.Loading -> LoadingScreen()
            MainUiState.Error -> ErrorScreen()
            is MainUiState.Success -> {
                LazyColumn(
                    state = listState,
                ) {
                    MainBody(
                        mainState = mainState,
                        onClickItem = onClickItem,
                        toggle = toggle,
                    )
                }
            }
        }
    }
}

private fun LazyListScope.MainBody(
    mainState: MainUiState,
    onClickItem: (Photo) -> Unit,
    toggle: (Int) -> Unit,
) {
    photoItems(
        items = (mainState as MainUiState.Success).photos,
        onClickItem = onClickItem,
        toggle = toggle,
        itemModifier = Modifier.padding(top = 10.dp)
    )
}