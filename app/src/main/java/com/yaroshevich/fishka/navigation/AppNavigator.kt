package com.yaroshevich.fishka.navigation

import android.util.Log
import androidx.navigation.NavController
import com.yaroshevich.fishka.R

class AppNavigator(val navController: NavController) {


    fun navigate(destination: Destination) {
        when (destination) {
            Destination.CREATE_ROD_SCREEN -> navigateToCreateRodScreen()
            Destination.ROD_SCREEN -> navigateToRodScreen()
            Destination.CREATE_REEL_SCREEN -> navigateToReelScreen()
        }
    }


    private fun navigateToCreateRodScreen() {
        Log.e("AppNavigator", "Тут тоже работает")
        navController.navigate(R.id.createRodFragment)
    }

    private fun navigateToRodScreen(){
        navController.navigate(R.id.equipmentFragment)
    }

    private fun navigateToReelScreen(){
        navController.navigate(R.id.createReelFragment)
    }
}


enum class Destination {
    CREATE_ROD_SCREEN,
    CREATE_REEL_SCREEN,
    CREATE_LINE_SCREEN,
    ROD_SCREEN
}