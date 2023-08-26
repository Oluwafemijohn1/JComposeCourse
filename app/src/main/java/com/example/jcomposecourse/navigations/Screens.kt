package com.example.jcomposecourse.navigations

sealed class Screens(val route: String){
    object Home: Screens("home_screen")
    object Detail: Screens("detail_screen")
}
