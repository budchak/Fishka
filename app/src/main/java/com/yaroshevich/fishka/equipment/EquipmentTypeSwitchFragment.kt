package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.viewPagerAdapter.EquipmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlinx.android.synthetic.main.fragment_equipment.view.*
import javax.inject.Inject

class EquipmentTypeSwitchFragment : BaseFragment() {

    lateinit var equipmentSwitchViewModel: EquipmentSwitchViewModel

    @Inject
    lateinit var adapter: EquipmentPagerAdapter

    val equipmentComponent =  App.getInstance().initEquipmentComponent(this)

    override fun getLayout() = R.layout.fragment_equipment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        equipmentComponent.inject(this)

        equipmentSwitchViewModel = ViewModelProvider(this).get(EquipmentSwitchViewModel::class.java)

        view.apply {
            tab_layout.setupWithViewPager(equipment_view_pager)
            equipment_view_pager.adapter = adapter
            equipment_view_pager.currentItem = equipmentSwitchViewModel.equipmentPosition
        }
    }
}