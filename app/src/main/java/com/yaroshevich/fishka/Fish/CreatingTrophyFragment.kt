package com.yaroshevich.fishka.Fish

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import javax.inject.Inject

class CreatingTrophyFragment: BaseFragment() {

    @Inject lateinit var creatingTrophyViewModel: CreatingTrophyViewModel


    override fun getLayout(): Int {
        return R.layout.fragment_add_fish
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getInstance().appComponent.inject(this)
        Toast.makeText(context, creatingTrophyViewModel.test, Toast.LENGTH_LONG).show()

    }
}