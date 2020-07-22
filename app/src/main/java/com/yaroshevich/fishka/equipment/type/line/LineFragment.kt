package com.yaroshevich.fishka.equipment.type.line

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.equipment.type.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.base.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.rods.RodsAdapter

class LineFragment : FragmentEquipmentType() {


    lateinit var emptyLineViewModel: EmptyLineViewModel
    lateinit var lineViewModel: LineViewModel

 fun get(fragmentType: FragmentType): Fragment {
        return when (fragmentType) {
            FragmentType.EMPTY -> EmptyEquipmentDataFragment(
                emptyLineViewModel
            )
            FragmentType.LOADING -> LoadingFragment()
            FragmentType.REGULAR -> RecyclerViewFragment(
                rvAdapter = RodsAdapter(BR.rod),
                typeViewModel = lineViewModel
            )
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyLineViewModel = ViewModelProvider(this).get(EmptyLineViewModel::class.java)
        lineViewModel = ViewModelProvider(this).get(LineViewModel::class.java)

        typeViewModel = lineViewModel

        super.onViewCreated(view, savedInstanceState)


    }
}