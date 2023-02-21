package kr.pe.ssun.template.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import kr.pe.ssun.template.core.domain.model.DPhoto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoResourcedCard(
    mainResource: DPhoto,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)) {
            SubcomposeAsyncImage(
                modifier = Modifier.size(80.dp),
                model = mainResource.thumbnailUrl,
                loading = {
                      CircularProgressIndicator(
                          modifier = Modifier.padding(20.dp),
                          color = MaterialTheme.colorScheme.primary,
                      )
                },
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxSize(),
                text = mainResource.title
            )
        }
    }
}