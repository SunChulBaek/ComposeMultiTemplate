package kr.pe.ssun.template.core.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import kr.pe.ssun.template.core.model.Photo

fun LazyListScope.photoItems(
    items: List<Photo>,
    onClickItem: (item: Photo) -> Unit,
    toggle: (Int) -> Unit,
    itemModifier: Modifier,
) = items(
    items = items,
    itemContent = { item ->
        PhotoItem(
            modifier = itemModifier,
            item = item,
            toggle = toggle
        ) {
            onClickItem(item)
        }
    }
)