package dev.toothlonely.workmategalaxyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.toothlonely.workmategalaxyapp.presentation.Navigation
import dev.toothlonely.workmategalaxyapp.ui.theme.WorkmateGalaxyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkmateGalaxyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavigation(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainNavigation(modifier: Modifier) {
    Navigation(modifier)
}