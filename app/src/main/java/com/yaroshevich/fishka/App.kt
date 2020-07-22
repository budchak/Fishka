package com.yaroshevich.fishka

import android.app.Application
import androidx.room.Room
import com.yaroshevich.fishka.navigation.AppNavigator
import com.yaroshevich.fishka.room.EquipmentDatabase

class App : Application() {

    lateinit var appNavigator: AppNavigator

    lateinit var database: EquipmentDatabase

    override fun onCreate() {
        super.onCreate()

        database =
            Room.databaseBuilder(applicationContext, EquipmentDatabase::class.java, "database")
                .build()

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