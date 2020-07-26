package com.yaroshevich.fishka.di.module

import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.equipment.EquipmentTypeSwitchFragment
import com.yaroshevich.fishka.equipment.viewPagerAdapter.EquipmentPagerAdapter
import dagger.Module
import dagger.Provides



@Module
class EquipmentModule(val fragment: EquipmentTypeSwitchFragment) {

    @FragmentSpore
    @Provides
    fun provideEquipmentPageAdapter(): EquipmentPagerAdapter{
        return EquipmentPagerAdapter(fragment.childFragmentManager, 4)
    }
}