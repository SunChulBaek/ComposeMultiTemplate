package kr.pe.ssun.template.core.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import kr.pe.ssun.template.core.domain.model.DPhoto

fun LazyListScope.photoItems(
    items: List<DPhoto>,
    onClickItem: (item: DPhoto) -> Unit,
    itemModifier: Modifier,
) = items(
    items = items,
    itemContent = { item ->
        PhotoResourcedCard(
            mainResource = item,
            onClick = { onClickItem(item) },
            modifier = itemModifier
        )
    }
)