package com.yaroshevich.fishka.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import com.yaroshevich.fishka.R


class AppNavigator(val navController: NavController) {


    fun navigate(destination: Destination) {
        when (destination) {
            Destination.CREATE_ROD_SCREEN -> navigateToCreateRodScreen()
            Destination.EQUIPMENT_SCREEN -> navigateToRodScreen()
            Destination.CREATE_REEL_SCREEN -> navigateToReelScreen()
        }
    }


    private fun navigateToCreateRodScreen() {
        Log.e("AppNavigator", "Тут тоже работает")
        navController.navigate(R.id.createRodFragment)
    }

     fun navigateToCreateRodScreen(id: Int) {
        Log.e("AppNavigator", "Тут тоже работает")

        val bundle = Bundle()
        bundle.putInt("item_id", id)
        navController.navigate(R.id.createRodFragment, bundle)
    }

    private fun navigateToRodScreen(){
        navController.navigate(R.id.equipmentFragment2)
    }

    private fun navigateToReelScreen(){
        navController.navigate(R.id.createReelFragment)
    }

    fun navigateToMainScreen(){
        navController.navigate(R.id.appFunctionFragment)
    }
}


enum class Destination {
    CREATE_ROD_SCREEN,
    CREATE_REEL_SCREEN,
    CREATE_LINE_SCREEN,
    MAIN_SCREEN,
    EQUIPMENT_SCREEN
}