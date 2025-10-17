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
fun InfoScreen() {

    val url = "https://masterpiecer-images.s3.yandex.net/5fcb1cda5223d2d:upscaled"
    val description =
        "The explosion is over but the consequences continue. About eleven thousand years ago a star in the constellation of Vela could be seen to explode, creating a strange point of light briefly visible to humans living near the beginning of recorded history. The outer layers of the star crashed into the  interstellar medium, driving a shock wave that is still visible today. A roughly spherical, expanding shock wave is visible in X-rays. The above image captures some of that filamentary and gigantic shock in visible light. As gas flies away from the detonated star, it decays and reacts with the interstellar medium, producing light in many different colors and energy bands. Remaining at the center of the Vela Supernova Remnant is a pulsar, a star as dense as nuclear matter that rotat an ten times in a single second."
    val title = "Filaments of the Vela Supernova Remnant"

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