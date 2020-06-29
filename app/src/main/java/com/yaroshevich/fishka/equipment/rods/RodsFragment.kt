package com.yaroshevich.fishka.equipment.rods

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_rods.view.*

class RodsFragment: BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_rods


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<Rod>()
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))
        list.add(Rod("tosiba", "5000", 210, Test(5,20)))

        val rodsAdapter = RodsAdapter()
        rodsAdapter.items = list
        view.apply {
            rod_recycler_view.apply {
                layoutManager = LinearLayoutManager(this@RodsFragment.context)
                adapter = rodsAdapter
                addItemDecoration(DividerItemDecoration(this@RodsFragment.context, 1))
            }

        }
    }
}