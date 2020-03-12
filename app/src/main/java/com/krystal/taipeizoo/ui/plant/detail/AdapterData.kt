package com.krystal.taipeizoo.ui.plant.detail

object ViewType {
    const val IMAGE = 0
    const val PLANT_DETAIL = 1
}

abstract class Item<out T>(val data: T?) {
    abstract fun getViewType(): Int

    companion object {
        fun <T> createItem(data: T, viewType: Int) =
            object : Item<T>(data) {
                override fun getViewType() = viewType
            }
    }
}