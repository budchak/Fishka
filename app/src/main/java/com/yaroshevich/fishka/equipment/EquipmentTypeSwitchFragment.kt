package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.viewPagerAdapter.EquipmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlinx.android.synthetic.main.fragment_equipment.view.*

class EquipmentTypeSwitchFragment : BaseFragment() {

    lateinit var equipmentSwitchViewModel:  EquipmentSwitchViewModel

    override fun getLayout() = R.layout.fragment_equipment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EquipmentPagerAdapter(childFragmentManager, tab_layout.tabCount)

        equipmentSwitchViewModel = ViewModelProvider(this).get(EquipmentSwitchViewModel::class.java)

        view.apply {
            tab_layout.setupWithViewPager(equipment_view_pager)
            equipment_view_pager.adapter = adapter
            equipment_view_pager.currentItem = equipmentSwitchViewModel.equipmentPosition
        }
    }
}