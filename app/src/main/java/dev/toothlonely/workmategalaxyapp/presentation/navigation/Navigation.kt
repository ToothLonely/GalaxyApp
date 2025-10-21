package dev.toothlonely.workmategalaxyapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.toothlonely.workmategalaxyapp.domain.Planet
import dev.toothlonely.workmategalaxyapp.presentation.info.InfoScreen
import dev.toothlonely.workmategalaxyapp.presentation.main.MainScreen
import kotlinx.serialization.Serializable


@Serializable
data object PlanetsList

@Composable
fun Navigation(modifier: Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlanetsList
    ) {
        composable<PlanetsList> {
            MainScreen(modifier) { planet ->
                navController.navigate(route = planet)
            }
        }

        composable<Planet> { backStackEntry ->
            val planet: Planet = backStackEntry.toRoute()
            InfoScreen(
                url = planet.imageUrl,
                description = planet.explanation,
                title = planet.title
            )
        }
    }
}