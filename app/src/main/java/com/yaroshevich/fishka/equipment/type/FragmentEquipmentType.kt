package com.yaroshevich.fishka.equipment.type

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment

abstract class FragmentEquipmentType : BaseFragment() {

    lateinit var typeViewModel: EquipmentTypeViewModel


    override fun getLayout(): Int = R.layout.fragment_equipment_type_container

    abstract fun get(fragmentType: FragmentType): Fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        typeViewModel = ViewModelProvider(this).get(EquipmentTypeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        typeViewModel.fragmentType.observe(viewLifecycleOwner, Observer {
            childFragmentManager.beginTransaction().replace(R.id.container, get(it)).commit()
        })


    }
}

enum class FragmentType{
    LOADING,
    EMPTY,
    REGULAR
}


