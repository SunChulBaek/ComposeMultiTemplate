package kr.pe.ssun.template.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import kr.pe.ssun.template.core.model.Photo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoItem(
    modifier: Modifier = Modifier,
    item: Photo,
    toggle: (Int) -> Unit,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.size(80.dp)) {
                SubcomposeAsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = item.thumbnailUrl,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.padding(20.dp),
                            color = MaterialTheme.colorScheme.primary,
                        )
                    },
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.align(Alignment.TopEnd).clickable { toggle(item.id) },
                    painter = painterResource(id = if (item.bookmarked) R.drawable.ic_btn_heart_on else R.drawable.ic_btn_heart_off),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxSize(),
                text = item.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}