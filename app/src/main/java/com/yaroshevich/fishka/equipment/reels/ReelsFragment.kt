package com.yaroshevich.fishka.equipment.reels

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.reels.model.Reel
import com.yaroshevich.fishka.equipment.rods.Rod
import com.yaroshevich.fishka.equipment.rods.RodsAdapter
import com.yaroshevich.fishka.equipment.rods.Test
import kotlinx.android.synthetic.main.fragment_reels.*
import kotlinx.android.synthetic.main.fragment_rods.view.*

class ReelsFragment: BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_reels


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = mutableListOf<Reel>()
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))

        val reeAdapter = ReelAdapter()
        reeAdapter.items = list
        view.apply {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(this@apply.context)
                adapter = reeAdapter
                addItemDecoration(DividerItemDecoration(this@apply.context, 1))
            }

        }
    }
}