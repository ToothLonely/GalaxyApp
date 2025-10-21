package dev.toothlonely.workmategalaxyapp.presentation.main

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder
import coil3.request.ImageRequest
import coil3.request.placeholder
import dev.toothlonely.workmategalaxyapp.R
import dev.toothlonely.workmategalaxyapp.domain.Planet
import dev.toothlonely.workmategalaxyapp.presentation.ui.theme.WorkmateGalaxyAppTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNavigateToInfoScreen: (Planet) -> Unit
) {
    ScrollingGrid(
        modifier,
        onNavigateToInfoScreen = onNavigateToInfoScreen
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollingGrid(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel(),
    onNavigateToInfoScreen: (Planet) -> Unit
) {
    val planets = viewModel.planetsFLow.collectAsLazyPagingItems()

    val itemModifier = Modifier
        .height(350.dp)
        .wrapContentSize()

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(AnimatedImageDecoder.Factory())
        }
        .build()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        items(planets.itemCount) { index ->
            val planet = planets[index]

            Card(
                modifier = itemModifier,
                onClick = {
                    planet?.let { onNavigateToInfoScreen(it) }
                }
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    if (planet != null) {

                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier
                                .height(250.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(planet.imageUrl)
                                    .placeholder(R.drawable.ic_loading_placeholder)
                                    .build(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                imageLoader = imageLoader,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Spacer(Modifier.height(10.dp))

                        Text(
                            textAlign = TextAlign.Center,
                            text = planet.title,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScrollingGrid() {
    WorkmateGalaxyAppTheme {
        ScrollingGrid {}
    }
}