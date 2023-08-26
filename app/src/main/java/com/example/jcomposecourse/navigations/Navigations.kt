package com.example.jcomposecourse.navigations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jcomposecourse.ui.screens.FoodDetails
import com.example.jcomposecourse.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigations() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.route){
        composable(Screens.Home.route){
             HomeScreen {
                 navController.navigate(Screens.Detail.route + "/${it}")
             }
        }
        composable(
            Screens.Detail.route + "/{index}",
            arguments = listOf(
                navArgument(
                    name = "index"
                ){
                    defaultValue = "0"
                    type = NavType.StringType
                }
            )
        ){
            val index = it.arguments?.getString("index")?.toInt()  ?: 0
            FoodDetails(index)
        }
    }
}