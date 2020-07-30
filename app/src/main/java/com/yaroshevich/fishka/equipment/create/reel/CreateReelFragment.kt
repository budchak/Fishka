package com.yaroshevich.fishka.equipment.create.reel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_create_equipment.*

class CreateReelFragment: BaseFragment() {
    override fun getLayout(): Int {
        return R.layout.fragment_create_equipment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(CreateReelViewModel::class.java)
        equipment_recycler_view.layoutManager = LinearLayoutManager(this.context)
        equipment_recycler_view.adapter = ReelAdapter(viewModel)
    }
}