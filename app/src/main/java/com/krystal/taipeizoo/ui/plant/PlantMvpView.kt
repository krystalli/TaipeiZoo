package com.krystal.taipeizoo.ui.plant

import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.model.PlantInfo

interface PlantMvpView {
    fun updateData(areaList: List<PlantInfo>)
}