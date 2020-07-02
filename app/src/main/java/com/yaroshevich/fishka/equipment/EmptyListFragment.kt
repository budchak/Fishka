package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.View
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.rods.RodViewModel

class EmptyListFragment( val viewModel: RodViewModel): BaseFragment() {



    override fun getLayout(): Int {
        return R.layout.fragment_if_empty_equipment_recycler_view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.update()

    }
}