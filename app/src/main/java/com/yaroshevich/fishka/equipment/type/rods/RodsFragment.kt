package com.yaroshevich.fishka.equipment.type.rods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.*
import com.yaroshevich.fishka.repository.RodRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RodsFragment: FragmentEquipmentType() {


    lateinit var emptyRodViewModel: EmptyRodViewModel
    lateinit var rodViewModel: RodViewModel


    val rodsAdapter = RodsAdapter()


    override fun get(fragmentType: FragmentType): Fragment {
       return when(fragmentType){
           FragmentType.EMPTY -> EmptyEquipmentDataFragment(
               emptyRodViewModel
           )
           FragmentType.REGULAR -> RecyclerViewFragment(
               rodsAdapter, rodViewModel
           )

           FragmentType.LOADING -> LoadingFragment()
       }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyRodViewModel = ViewModelProvider(this).get(EmptyRodViewModel::class.java)
        rodViewModel = ViewModelProvider(this).get(RodViewModel::class.java)

        typeViewModel = rodViewModel
        emptyRodViewModel.typeViewModel = typeViewModel


        rodsAdapter.notifyDataSetChanged()

        super.onViewCreated(view, savedInstanceState)

        rodViewModel.rodLiveList.observe(viewLifecycleOwner, Observer {
            rodsAdapter.items = it
            rodsAdapter.notifyDataSetChanged()
        })
    }


}