package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.di.module.RodModule
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.di.spore.ViewSpore
import com.yaroshevich.fishka.equipment.type.rods.RodsFragment
import dagger.Component
import dagger.Subcomponent

@ViewSpore
@Subcomponent(modules = [RodModule::class])
interface RodComponent {
    fun inject(fragment: RodsFragment)
}