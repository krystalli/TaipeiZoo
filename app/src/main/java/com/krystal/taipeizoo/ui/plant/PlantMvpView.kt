package com.krystal.taipeizoo.ui.plant

import com.krystal.taipeizoo.model.PlantInfo

interface PlantMvpView {
    fun updateData(plantList: List<PlantInfo>)
    fun showOrHideError(isShowed: Boolean)
}