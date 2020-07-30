package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_rv_equipment.*
import javax.inject.Inject

class EquipmentFragment() : BaseFragment() {

    @Inject
    lateinit var equipmentViewModel: EquipmentViewModel


    @Inject
    lateinit var onTabSelectedListener: TabLayout.OnTabSelectedListener

    var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

    override fun getLayout() = R.layout.fragment_rv_equipment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getInstance().initEquipmentComponent(this).inject(this)

        equipmentViewModel.init()
        tab_layout.addOnTabSelectedListener(onTabSelectedListener)


        equipmentViewModel.apply {
            equipmentAdapter.observe(viewLifecycleOwner, Observer {
                recycler_view.adapter = it
            })

            actionBarVisibility.observe(viewLifecycleOwner, Observer {
                add_floating_action_button.visibility = when (it) {
                    true -> View.VISIBLE
                    false -> View.GONE
                }

            })
        }



        recycler_view.layoutManager = layoutManager
        recycler_view.addItemDecoration(MarginItemDecorator())

    }

    override fun onPause() {
        super.onPause()
        recycler_view.layoutManager = null
    }
}