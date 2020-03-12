package com.krystal.taipeizoo.ui.area

import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.model.PlantInfo

interface AreaMvpView {
    fun updateData(area: Area, plantList: List<PlantInfo>)
}