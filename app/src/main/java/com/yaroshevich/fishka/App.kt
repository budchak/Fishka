package com.yaroshevich.fishka

import android.app.Application
import androidx.room.Room
import com.yaroshevich.fishka.appFunction.AppFunctionFragment
import com.yaroshevich.fishka.di.component.AppComponent
import com.yaroshevich.fishka.di.component.AppFunctionComponent
import com.yaroshevich.fishka.di.component.DaggerAppComponent
import com.yaroshevich.fishka.di.component.EquipmentComponent
import com.yaroshevich.fishka.di.module.AppFunctionModule
import com.yaroshevich.fishka.di.module.EquipmentModule
import com.yaroshevich.fishka.equipment.EquipmentFragment
import com.yaroshevich.fishka.navigation.AppNavigator
import com.yaroshevich.fishka.room.EquipmentDatabase

class App : Application() {

    lateinit var appNavigator: AppNavigator

    lateinit var database: EquipmentDatabase

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }

    var position = 3

    lateinit var appFunctionComponent: AppFunctionComponent

    lateinit var equipmentComponent: EquipmentComponent

    override fun onCreate() {
        super.onCreate()

        database =
            Room.databaseBuilder(applicationContext, EquipmentDatabase::class.java, "database")
                .build()

        setInstance(this)


    }


    fun initFunctionComponent(fragment: AppFunctionFragment) {
        appFunctionComponent = appComponent.plus(AppFunctionModule(fragment))
    }

    fun initEquipmentComponent(fragment: EquipmentFragment): EquipmentComponent {

        equipmentComponent = appComponent.plus(EquipmentModule(fragment))
        return equipmentComponent
    }

    companion object {

        private lateinit var app: App
        private fun setInstance(app: App) {
            this.app = app
        }

        fun getInstance() = app
    }

}