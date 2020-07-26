package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.di.module.EquipmentModule
import com.yaroshevich.fishka.di.module.ReelModule
import com.yaroshevich.fishka.di.module.RodModule
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.equipment.EquipmentTypeSwitchFragment
import dagger.Subcomponent


@FragmentSpore
@Subcomponent(modules = [EquipmentModule::class])
interface EquipmentComponent {
    fun inject(fragment: EquipmentTypeSwitchFragment)
    fun plus(rodModule: RodModule): RodComponent
    fun plus(reelModule: ReelModule): ReelComponent
}