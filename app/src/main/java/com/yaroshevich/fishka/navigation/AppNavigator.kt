package com.yaroshevich.fishka.navigation

import android.util.Log
import androidx.navigation.NavController
import com.yaroshevich.fishka.R

class AppNavigator(val navController: NavController) {


    fun navigate(destination: Destination) {
        when (destination) {
            Destination.CREATE_ROD_SCREEN -> navigateToCreateRodScreen()
            Destination.ROD_SCREEN -> navigateToRodScreen()
        }
    }


    private fun navigateToCreateRodScreen() {
        Log.e("AppNavigator", "Тут тоже работает")
        navController.navigate(R.id.createRodFragment)
    }

    private fun navigateToRodScreen(){
        navController.navigate(R.id.equipmentFragment)
    }
}


enum class Destination {
    CREATE_ROD_SCREEN,
    ROD_SCREEN
}