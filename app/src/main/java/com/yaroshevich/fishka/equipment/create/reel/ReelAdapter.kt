package com.yaroshevich.fishka.equipment.create.reel

import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.equipment.create.BindingItem
import com.yaroshevich.fishka.equipment.create.CreateEquipmentAdapter

class ReelAdapter(val viewModel: CreateReelViewModel) : CreateEquipmentAdapter() {

    init {
        items.add(
            BindingItem(
                R.layout.item_brand,
                BR.viewModel,
                viewModel
            )
        )
        items.add(
            BindingItem(
                R.layout.item_create_model,
                BR.viewModel,
                viewModel
            )
        )
        items.add(
            BindingItem(
                R.layout.item_size,
                BR.viewModel,
                viewModel
            )
        )

        items.add(
            BindingItem(
                R.layout.item_apply,
                BR.viewModel,
                viewModel
            )
        )

    }
}