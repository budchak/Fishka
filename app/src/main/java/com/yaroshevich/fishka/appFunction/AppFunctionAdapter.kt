package com.yaroshevich.fishka.appFunction

import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BindableAdapter

class AppFunctionAdapter(): BindableAdapter(BR.viewModel) {


    override fun getItemViewType(position: Int): Int {
        return R.layout.item_app_function
    }
}