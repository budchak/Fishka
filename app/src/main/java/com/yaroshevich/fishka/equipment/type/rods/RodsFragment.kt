package com.yaroshevich.fishka.equipment.type.rods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.type.RecyclerViewFragment

class RodsFragment: FragmentEquipmentType() {


    lateinit var emptyRodViewModel: EmptyRodViewModel
    lateinit var rodViewModel: RodViewModel


    val rodsAdapter = RodsAdapter()


    override fun get(fragmentType: Int): Fragment {
       return when(fragmentType){
           0 -> EmptyEquipmentDataFragment(
               emptyRodViewModel
           )
           else -> RecyclerViewFragment(
               rodsAdapter, rodViewModel
           )
       }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyRodViewModel = ViewModelProvider(this).get(EmptyRodViewModel::class.java)
        rodViewModel = ViewModelProvider(this).get(RodViewModel::class.java)

        typeViewModel = rodViewModel

        emptyRodViewModel.typeViewModel = typeViewModel

        rodsAdapter.items = App.getInstance().rods
        rodsAdapter.notifyDataSetChanged()

        super.onViewCreated(view, savedInstanceState)

        emptyRodViewModel.liveRods.observe(viewLifecycleOwner, Observer {
            rodsAdapter.items = it
            rodsAdapter.notifyDataSetChanged()
        })
    }

}