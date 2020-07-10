package com.yaroshevich.fishka.equipment.create

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.databinding.FragmentCreateRodBinding


class CreateRodFragment : BaseFragment() {


    override fun getLayout(): Int = R.layout.fragment_create_rod


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createRodViewModel: CreateRodViewModel =
            ViewModelProvider(this).get(CreateRodViewModel::class.java)

        val binding = DataBindingUtil.bind<FragmentCreateRodBinding>(view)
        binding?.lifecycleOwner = this
        binding?.rodViewModel = createRodViewModel
    }


}