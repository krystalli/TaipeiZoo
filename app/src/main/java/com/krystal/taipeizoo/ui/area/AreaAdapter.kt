package com.krystal.taipeizoo.ui.area

import android.content.Context
import androidx.annotation.DrawableRes
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.krystal.taipeizoo.extension.plusIfValid
import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.area.delegate.AreaDelegate
import com.krystal.taipeizoo.ui.area.delegate.PlantDelegate
import com.krystal.taipeizoo.ui.area.delegate.PlantTitleDelegate

data class AnimalInfo(
    val id: Int,
    val imageUrl: String,
    val count: Int,
    val date: String,
    @DrawableRes val resourceId: Int
)

class AreaAdapter(private val context: Context) : ListDelegationAdapter<List<Item<*>>>() {

    private var area: Area = Area.defaultInstance
    private var plantList: List<PlantInfo> = listOf()

    init {
        delegatesManager
            .addDelegate(ViewType.AREA, AreaDelegate())
            .addDelegate(ViewType.PLANT_TITLE, PlantTitleDelegate())
            .addDelegate(ViewType.PLANT, PlantDelegate())

        setItems(items)
    }

    fun updateData(area: Area, plantList: List<PlantInfo>) {
        this.area = area
        this.plantList = plantList
        updateView()
    }

    private fun updateView() {
        val areaItem =
            object : Item<Area>(area) {
                override fun getViewType() = ViewType.AREA
            }

        val plantTitleItem =
            object : Item<Any>(null) {
                override fun getViewType() = ViewType.PLANT_TITLE
            }

        val plantItems = plantList.map {
            object : Item<PlantInfo>(it) {
                override fun getViewType() = ViewType.PLANT
            }
        }

        items = listOf<Item<*>>(areaItem)
            .plusIfValid(plantTitleItem, plantList.isNotEmpty())
            .plusIfValid(plantItems, plantList.isNotEmpty())

        setItems(items)
        notifyDataSetChanged()
    }
}