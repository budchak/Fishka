package com.yaroshevich.fishka.equipment.type.line

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.equipment.type.EquipmentFactory
import com.yaroshevich.fishka.equipment.type.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.empty.fragment.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyLineViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodFactory
import com.yaroshevich.fishka.equipment.type.rods.RodsAdapter

class LineFragment : FragmentEquipmentType() {


    lateinit var emptyLineViewModel: EmptyLineViewModel
    lateinit var lineViewModel: LineViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyLineViewModel = ViewModelProvider(this).get(EmptyLineViewModel::class.java)
        lineViewModel = ViewModelProvider(this).get(LineViewModel::class.java)

        typeViewModel = lineViewModel
        equipmentFactory = LineEquipmentFactory()
        super.onViewCreated(view, savedInstanceState)


    }
}

class LineEquipmentFactory(): EquipmentFactory() {
    override fun create(fragmentType: FragmentType): Fragment {
        return LoadingFragment()
    }

}