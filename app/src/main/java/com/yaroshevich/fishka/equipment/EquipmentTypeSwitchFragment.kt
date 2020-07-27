package com.yaroshevich.fishka.equipment


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseFragment
import com.yaroshevich.fishka.equipment.viewPagerAdapter.EquipmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlinx.android.synthetic.main.fragment_equipment.view.*
import javax.inject.Inject

class EquipmentTypeSwitchFragment : BaseFragment() {

    lateinit var equipmentSwitchViewModel: EquipmentSwitchViewModel

    @Inject
    lateinit var position: MutableLiveData<Int>

    @Inject
    lateinit var adapter: EquipmentPagerAdapter

    val equipmentComponent = App.getInstance().initEquipmentComponent(this)

    override fun getLayout() = R.layout.fragment_equipment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        equipmentComponent.inject(this)

        equipmentSwitchViewModel = ViewModelProvider(this).get(EquipmentSwitchViewModel::class.java)
        initToolbar(toolbar)
        view.apply {
            tab_layout.setupWithViewPager(equipment_view_pager)

            equipment_view_pager.adapter = adapter
            equipment_view_pager.currentItem = position.value ?: 0
            tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                    position.value = tab?.position
                }

            })
        }
    }


    private fun initToolbar(toolbar: Toolbar) {
        toolbar.title = "Снаряжение"
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
    }


}