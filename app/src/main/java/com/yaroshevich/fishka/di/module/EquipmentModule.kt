package com.yaroshevich.fishka.di.module

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.google.android.material.tabs.TabLayout
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.equipmentRV.EquipmentFragment
import com.yaroshevich.fishka.equipmentRV.EquipmentTypeDPFactory
import com.yaroshevich.fishka.equipmentRV.EquipmentViewModel
import com.yaroshevich.fishka.equipmentRV.TabSelectedListener
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