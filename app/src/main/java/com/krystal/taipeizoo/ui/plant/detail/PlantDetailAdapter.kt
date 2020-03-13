package com.krystal.taipeizoo.ui.plant.detail

import android.content.Context
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.krystal.taipeizoo.extension.plusIfValid
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.plant.detail.PlantDetialViewInfoConverter.convertPlantInfoToDetailViewInfo
import com.krystal.taipeizoo.ui.plant.detail.delegate.DetailViewInfo
import com.krystal.taipeizoo.ui.plant.detail.delegate.ImageDelegate
import com.krystal.taipeizoo.ui.plant.detail.delegate.PlantInfoDelegate

class PlantDetailAdapter(private val context: Context) : ListDelegationAdapter<List<Item<*>>>() {

    private var plantInfo: PlantInfo = PlantInfo.defaultInstance

    init {
        delegatesManager
            .addDelegate(ViewType.IMAGE, ImageDelegate())
            .addDelegate(ViewType.PLANT_DETAIL, PlantInfoDelegate())

        setItems(items)
    }

    fun updateData(plantInfo: PlantInfo) {
        this.plantInfo = plantInfo
        updateView()
    }

    private fun updateView() {
        val imageItem =
            object : Item<String>(plantInfo.imageUrl) {
                override fun getViewType() = ViewType.IMAGE
            }

        val plantDetails = plantInfo.convertPlantInfoToDetailViewInfo(context)
        val plantDetailItems = plantDetails.map {
            object : Item<DetailViewInfo>(it) {
                override fun getViewType() = ViewType.PLANT_DETAIL
            }
        }

        items = listOf<Item<*>>(imageItem)
            .plusIfValid(plantDetailItems, plantDetails.isNotEmpty())

        setItems(items)
        notifyDataSetChanged()
    }
}