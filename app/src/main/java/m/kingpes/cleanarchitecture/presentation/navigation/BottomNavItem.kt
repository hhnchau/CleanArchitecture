package m.kingpes.cleanarchitecture.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomNavItem("home", "Home", Icons.Default.Home)
    object Search: BottomNavItem("search", "Search", Icons.Default.Search)
    object Add: BottomNavItem("add", "Add", Icons.Default.Add)
    object Notifications: BottomNavItem("notifications", "Notifications", Icons.Default.Notifications)
    object Profile: BottomNavItem("profile", "Profile", Icons.Default.Person)
}