package com.yaroshevich.fishka.equipment.type.rods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.equipment.type.*
import com.yaroshevich.fishka.equipment.type.empty.fragment.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyRodViewModel

class RodsFragment: FragmentEquipmentType() {


    lateinit var emptyRodViewModel: EmptyRodViewModel
    lateinit var rodViewModel: RodViewModel
    lateinit var rodsAdapter: RodsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyRodViewModel = ViewModelProvider(this).get(EmptyRodViewModel::class.java)
        rodViewModel = ViewModelProvider(this).get(RodViewModel::class.java)
        rodsAdapter = RodsAdapter(BR.rod)
        equipmentFactory = RodFactory(emptyRodViewModel, rodsAdapter, rodViewModel)
        typeViewModel = rodViewModel
        emptyRodViewModel.typeViewModel = typeViewModel

        equipmentFactory  = RodFactory(emptyRodViewModel, rodsAdapter, rodViewModel)

        super.onViewCreated(view, savedInstanceState)

        rodViewModel.rodLiveList.observe(viewLifecycleOwner, Observer {
            rodsAdapter.items = it
            rodsAdapter.notifyDataSetChanged()
        })
    }


}

class RodFactory(val emptyRodViewModel: EmptyRodViewModel,
                 val rodsAdapter: RodsAdapter,
                 val rodViewModel: RodViewModel): EquipmentFactory() {
    override fun create(id: FragmentType): Fragment {
        return when(id){
            FragmentType.EMPTY -> EmptyEquipmentDataFragment(emptyRodViewModel

            )
            FragmentType.REGULAR -> RecyclerViewFragment(
                rodsAdapter, rodViewModel
            )

            FragmentType.LOADING -> LoadingFragment()
        }
    }
}