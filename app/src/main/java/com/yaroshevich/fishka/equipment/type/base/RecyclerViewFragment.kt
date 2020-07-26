package com.yaroshevich.fishka.equipment.type.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.adapters.BindableAdapter
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class RecyclerViewFragment(val rvAdapter: BindableAdapter, val typeViewModel: EquipmentTypeViewModel): BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.fragment_recycler_view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = rvAdapter
            addItemDecoration(DividerItemDecoration(this@RecyclerViewFragment.context, 1))
        }


        typeViewModel.liveList.observe(viewLifecycleOwner, Observer {
            rvAdapter.items = it
        })

        floating_action_button.setOnClickListener {
            typeViewModel.onFloatingButtonClick()
        }

    }

    
}