package com.yaroshevich.fishka.equipment.rods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.EmptyListFragment
import com.yaroshevich.fishka.equipment.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.RecyclerViewFragment
import kotlinx.android.synthetic.main.fragment_rods.view.*

class RodsFragment: FragmentEquipmentType() {


    override fun getFragment(): Fragment {
       return when(list.size){
           0 -> EmptyListFragment(rodViewModel)
           else -> RecyclerViewFragment(rodsAdapter)
       }
    }

    lateinit var rodViewModel: RodViewModel

    val rodsAdapter = RodsAdapter()

    val list = mutableListOf<Rod>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rodViewModel = ViewModelProvider(this).get(RodViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)

    }

}