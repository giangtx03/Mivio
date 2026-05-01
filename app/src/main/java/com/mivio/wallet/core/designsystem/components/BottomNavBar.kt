package com.mivio.wallet.core.designsystem.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mivio.wallet.core.navigation.HomeRoute
import com.mivio.wallet.core.navigation.ReminderRoute
import com.mivio.wallet.core.navigation.SettingsRoute
import com.mivio.wallet.core.navigation.StatsRoute

data class TopLevelRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val topLevelRoutes = listOf(
        TopLevelRoute("Trang chủ", HomeRoute, Icons.Filled.Home),
        TopLevelRoute("Thống kê", StatsRoute, Icons.Filled.DateRange),
        TopLevelRoute("Đặt lịch", ReminderRoute, Icons.Filled.Notifications),
        TopLevelRoute("Cài đặt", SettingsRoute, Icons.Filled.Settings)
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        topLevelRoutes.forEach { topLevelRoute ->
            val isSelected = currentDestination?.hierarchy?.any {
                it.hasRoute(topLevelRoute.route::class)
            } == true

            NavigationBarItem(
                icon = { Icon(topLevelRoute.icon, contentDescription = topLevelRoute.name) },
                label = { Text(text = topLevelRoute.name) },
                selected = isSelected,
                onClick = {
                    navController.navigate(topLevelRoute.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}