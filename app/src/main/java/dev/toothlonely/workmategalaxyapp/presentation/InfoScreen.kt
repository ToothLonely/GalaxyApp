package dev.toothlonely.workmategalaxyapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun InfoScreen(
    url: String,
    description: String,
    title: String,
) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(50.dp))

        Text(text = title)

        Spacer(Modifier.height(35.dp))

        Text(text = description)
    }
}