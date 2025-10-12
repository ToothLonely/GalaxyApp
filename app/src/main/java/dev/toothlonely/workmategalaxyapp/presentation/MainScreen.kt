package dev.toothlonely.workmategalaxyapp.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.workmategalaxyapp.ui.theme.WorkmateGalaxyAppTheme

@Composable
fun MainScreen(modifier: Modifier) {
    ScrollingGrid(modifier)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollingGrid(modifier: Modifier = Modifier) {
    val itemsList = (0..25).toList()

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
        items(itemsList) {
            Text("Item is $it", itemModifier)
        }

        item {
            Text("Single item", itemModifier)
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