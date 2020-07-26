package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.Fish.CreatingTrophyFragment
import com.yaroshevich.fishka.di.module.AppFunctionModule
import com.yaroshevich.fishka.di.module.AppModule
import com.yaroshevich.fishka.di.module.EquipmentModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }


    fun inject(fragment: CreatingTrophyFragment)
    fun plus(appFunctionModule: AppFunctionModule): AppFunctionComponent
    fun plus(equipmentModule: EquipmentModule): EquipmentComponent
}