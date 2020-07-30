package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.di.module.EquipmentModule
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.equipment.EquipmentFragment
import dagger.Subcomponent


@FragmentSpore
@Subcomponent(modules = [EquipmentModule::class])
interface EquipmentComponent {
    fun inject(fragment: EquipmentFragment)
  }