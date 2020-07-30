package com.yaroshevich.fishka.di.module

import com.google.android.material.tabs.TabLayout
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.equipment.EquipmentFragment
import com.yaroshevich.fishka.equipment.EquipmentTypeDPFactory
import com.yaroshevich.fishka.equipment.EquipmentViewModel
import com.yaroshevich.fishka.equipment.TabSelectedListener
import dagger.Module
import dagger.Provides



@Module
class EquipmentModule(val fragment: EquipmentFragment) {

    @FragmentSpore
    @Provides
    fun provideEquipmentViewModel(eqFactory: EquipmentTypeDPFactory): EquipmentViewModel{
        return EquipmentViewModel(eqFactory)
    }


    @Provides
    fun provideEquipmentTypeFactory(): EquipmentTypeDPFactory{
        return  EquipmentTypeDPFactory()
    }

    @Provides
    fun provideOnTabSelectedListener(viewModel: EquipmentViewModel): TabLayout.OnTabSelectedListener{
        return TabSelectedListener(viewModel)
    }
}