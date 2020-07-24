package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.Fish.CreatingTrophyFragment
import com.yaroshevich.fishka.di.module.AppModule
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
}