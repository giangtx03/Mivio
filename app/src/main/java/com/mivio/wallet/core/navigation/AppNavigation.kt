package com.mivio.wallet.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mivio.wallet.ui.components.BottomNavigationBar
import com.mivio.wallet.ui.feature.home.HomeScreen
import com.mivio.wallet.ui.feature.remider.ReminderScreen
import com.mivio.wallet.ui.feature.settings.SettingsScreen
import com.mivio.wallet.ui.feature.stats.StatsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Sử dụng Type-safe composable
            composable<HomeRoute> { HomeScreen() }
            composable<StatsRoute> { StatsScreen() }
            composable<ReminderRoute> { ReminderScreen() }
            composable<SettingsRoute> { SettingsScreen() }
        }
    }
}