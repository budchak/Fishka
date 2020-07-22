package com.yaroshevich.fishka.equipment.type

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.type.base.EquipmentTypeViewModel

abstract class FragmentEquipmentType() : BaseFragment() {

    lateinit var typeViewModel: EquipmentTypeViewModel

    var equipmentFactory: EquipmentFactory? = null

    override fun getLayout(): Int = R.layout.fragment_equipment_type_container


    override fun onAttach(context: Context) {
        super.onAttach(context)
        typeViewModel = ViewModelProvider(this).get(EquipmentTypeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        typeViewModel.fragmentType.observe(viewLifecycleOwner, Observer {
            val fragment = equipmentFactory?.create(it)
            if (fragment!= null){

                childFragmentManager.
                beginTransaction().
                replace(R.id.container, fragment).
                commit()

            }

        })


    }
}


abstract class EquipmentFactory {
    abstract fun create(id: FragmentType): Fragment
}

enum class FragmentType {
    LOADING,
    EMPTY,
    REGULAR
}


