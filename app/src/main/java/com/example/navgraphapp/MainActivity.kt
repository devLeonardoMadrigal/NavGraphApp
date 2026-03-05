package com.example.navgraphapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.navgraphapp.composable.Routes
import com.example.navgraphapp.ui.theme.NavGraphAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navgraphapp.composable.DetailsScreen
import com.example.navgraphapp.composable.HomeScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavGraphAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()
    AppNavHost(
        navHostController = navHostController
    )
}

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.HOME
    ){
        composable(Routes.HOME){
            HomeScreen(
                onNavigateToDetail = {
                    navHostController.navigate("detail/Leo") //Lazycolumn
                }
            )
        }

        composable(
            Routes.DETAIL,
            listOf(
                navArgument("id"){
                    type = NavType.StringType
                }
            )
            ){ backStackEntry ->
            val userId = backStackEntry.arguments?.getString("id") ?: "Unknown"
            DetailsScreen(
                userId = userId,
                onGoBack = {
                    navHostController.popBackStack()
                }
            )
        }
    }

}