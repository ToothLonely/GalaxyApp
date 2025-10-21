package dev.toothlonely.workmategalaxyapp.presentation.info

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.gif.AnimatedImageDecoder
import coil3.request.ImageRequest
import coil3.request.placeholder
import dev.toothlonely.workmategalaxyapp.R

@Composable
fun InfoScreen(
    url: String,
    description: String,
    title: String,
) {

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(AnimatedImageDecoder.Factory())
        }
        .build()

    fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int) =
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            val height = if (rate > 0) scrollState.value / rate else scrollState.value
            layout(placeable.width, placeable.height) {
                placeable.place(0, height)
            }
        }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState)
            .background(CardDefaults.cardColors().containerColor)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .placeholder(R.drawable.ic_loading_placeholder)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            imageLoader = imageLoader,
            modifier = Modifier
                .fillMaxWidth()
                .parallaxLayoutModifier(scrollState, 3)
        )

        Card(Modifier.fillMaxHeight()) {
            Spacer(Modifier.height(25.dp))

            Text(
                text = title,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(15.dp))

            Text(
                text = description,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}