package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.appFunction.AppFunctionFragment
import com.yaroshevich.fishka.di.module.AppFunctionModule
import com.yaroshevich.fishka.di.spore.FragmentSpore
import dagger.Subcomponent


@FragmentSpore
@Subcomponent(modules = [AppFunctionModule::class])
interface AppFunctionComponent {
    fun inject(fragment: AppFunctionFragment)
}