package com.yaroshevich.fishka.equipment

import com.google.android.material.tabs.TabLayout

class TabSelectedListener(val equipmentViewModel: EquipmentViewModel) : TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        equipmentViewModel.onEquipmentTypeChange(tab?.position ?: 0)
    }

}