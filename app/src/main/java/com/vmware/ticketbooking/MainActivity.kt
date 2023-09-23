package com.vmware.ticketbooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vmware.bookseat.ui.BookSeatFragment
import com.vmware.ticketbooking.ui.theme.JetpackComposeTheme
import com.vmware.ticketbooking.utils.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                JetpackComposeAppScreen()
            }
        }
    }
}

@Composable
fun JetpackComposeAppScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.BookSeat.route,
    ) {
        composable(route = Route.BookSeat.route) {
            BookSeatFragment()
        }
    }
}
