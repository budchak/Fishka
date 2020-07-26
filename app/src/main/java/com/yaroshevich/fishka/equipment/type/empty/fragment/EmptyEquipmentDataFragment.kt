package com.yaroshevich.fishka.equipment.type.empty.fragment

import android.os.Bundle
import android.view.View
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyEquipmentViewModel
import kotlinx.android.synthetic.main.fragment_if_empty_equipment_recycler_view.*

class EmptyEquipmentDataFragment(var viewModel: EmptyEquipmentViewModel): BaseFragment() {


    override fun getLayout(): Int {
        return R.layout.fragment_if_empty_equipment_recycler_view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_button.setOnClickListener {
            viewModel.onClick()
        }

    }

}