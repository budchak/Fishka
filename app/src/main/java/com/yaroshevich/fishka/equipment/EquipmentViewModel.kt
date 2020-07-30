package com.yaroshevich.fishka.equipment

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.equipment.itemClickListener.ReelClickListener
import com.yaroshevich.fishka.equipment.itemClickListener.RodClickListener
import com.yaroshevich.fishka.repository.EquipmentRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EquipmentViewModel(val eqFactory: EquipmentTypeDPFactory) {


    var actionBarVisibility = MutableLiveData<Boolean>(true)

    var equipmentAdapter = MutableLiveData<EquipmentAdapter>()

    fun init() {
        onEquipmentTypeChange(0)
    }

    fun onEquipmentTypeChange(type: Int) {

        val eqDp = eqFactory.getD(type)

        GlobalScope.launch {
            val result = eqDp.equipmentRepository.getAll()
            if (result.isEmpty()) {
                showActionButton(false)
                val adapter = createEmptyListAdapter(type)
                equipmentAdapter.postValue(adapter)

            } else {
                showActionButton(true)
                eqDp.equipmentAdapter.items = result
                equipmentAdapter.postValue(eqDp.equipmentAdapter)
            }


        }
    }

    private fun showActionButton(visibility: Boolean) {
        actionBarVisibility.postValue(visibility)
    }


    private fun createEmptyListAdapter(type: Int): EquipmentAdapter {
        val adapter = when (type) {
            0 -> EquipmentAdapter(
                -1,
                R.layout.fragment_if_empty_equipment_recycler_view, RodClickListener()

            )
            1 -> EquipmentAdapter(
                -1,
                R.layout.fragment_if_empty_equipment_recycler_view, ReelClickListener()

            )
            else -> EquipmentAdapter(
                -
                1,
                R.layout.fragment_if_empty_equipment_recycler_view, ReelClickListener()

            )

        }
        val list = mutableListOf<Int>()
        list.add(1)
        adapter.items = list
        return adapter
    }


}


class EquipmentDP(
    val equipmentAdapter: EquipmentAdapter,
    val equipmentRepository: EquipmentRepository<out Any>
)


