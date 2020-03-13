package com.krystal.taipeizoo.ui.area

object ViewType {
    const val AREA = 0
    const val PLANT_TITLE = 1
    const val PLANT = 2
}

abstract class Item<out T>(val data: T?) {
    abstract fun getViewType(): Int
}