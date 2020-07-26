package com.yaroshevich.fishka.equipment.create.rod

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.databinding.FragmentCreateRodBinding


class CreateRodFragment : BaseFragment() {

    lateinit var createRodViewModel: CreateRodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createRodViewModel = ViewModelProvider(this).get(CreateRodViewModel::class.java)
        val arg = arguments
        if (arg != null) {
            createRodViewModel.load(arg.getInt("item_id"))
        } else {
            Toast.makeText(context, "arg  $arg", Toast.LENGTH_SHORT).show()
        }


    }

    override fun getLayout(): Int = R.layout.fragment_create_rod


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val binding = DataBindingUtil.bind<FragmentCreateRodBinding>(view)
        binding?.lifecycleOwner = this
        createRodViewModel.brand.observe(viewLifecycleOwner, Observer {
            binding?.rodViewModel = createRodViewModel
        })

    }

}