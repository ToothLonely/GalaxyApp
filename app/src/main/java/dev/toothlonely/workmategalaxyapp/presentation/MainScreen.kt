package dev.toothlonely.workmategalaxyapp.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import dev.toothlonely.workmategalaxyapp.ui.theme.WorkmateGalaxyAppTheme

@Composable
fun MainScreen(modifier: Modifier) {
    ScrollingGrid(modifier)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollingGrid(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel()
) {
    val planets = viewModel.planetsFLow.collectAsLazyPagingItems()

    val itemModifier = Modifier
        .border(1.dp, Color.Blue)
        .height(350.dp)
        .wrapContentSize()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        items(planets.itemCount) { index ->
            val planet = planets[index]

            Column(
                modifier = itemModifier
            ) {
                if (planet != null) {
                    AsyncImage(
                        model = planet.imageUrl,
                        contentDescription = null,
                    )
                    Text(
                        text = planet.title
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScrollingGrid() {
    WorkmateGalaxyAppTheme {
        ScrollingGrid()
    }
}