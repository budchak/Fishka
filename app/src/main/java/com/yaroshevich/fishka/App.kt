package com.yaroshevich.fishka

import android.app.Application
import com.yaroshevich.fishka.equipment.type.rods.Rod
import com.yaroshevich.fishka.navigation.AppNavigator

class App : Application() {

    lateinit var appNavigator: AppNavigator

    val rods = mutableListOf<Rod>()


    override fun onCreate() {
        super.onCreate()
        setInstance(this)
    }

    companion object {

        private lateinit var app: App
        private fun setInstance(app: App) {
            this.app = app
        }

            fun getInstance() = app
    }

}