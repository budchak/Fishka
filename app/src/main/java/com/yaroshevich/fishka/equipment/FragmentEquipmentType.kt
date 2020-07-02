package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.rods.RodsFragment

abstract class FragmentEquipmentType : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_equipment_type_container

   abstract fun getFragment(): Fragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction().replace(R.id.container, getFragment()).commit()
    }
}
