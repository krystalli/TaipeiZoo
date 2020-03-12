package com.krystal.taipeizoo.ui.plant.detail

import android.content.Context
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.plusIfValid
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.plant.detail.delegate.DetailViewInfo

object PlantDetialViewInfoConverter {

    fun PlantInfo.convertPlantInfoToDetailViewInfo(context: Context): List<DetailViewInfo> {
        return listOf<DetailViewInfo>()
            .plusIfValid(
                DetailViewInfo(name, englishName, true, R.color.grey_ff_22),
                name.isNotBlank()
            )
            .plusIfValid(
                DetailViewInfo(
                    context.getString(R.string.plant_text_other_name),
                    otherNames
                ),
                otherNames.isNotBlank()
            )
            .plusIfValid(
                DetailViewInfo(
                    context.getString(R.string.plant_text_description),
                    description
                ),
                description.isNotBlank()
            )
            .plusIfValid(
                DetailViewInfo(
                    context.getString(R.string.plant_text_feature),
                    feature
                ),
                feature.isNotBlank()
            )
            .plusIfValid(
                DetailViewInfo(
                    context.getString(R.string.plant_text_functionality),
                    functionality
                ),
                functionality.isNotBlank()
            )
            .plusIfValid(
                DetailViewInfo(
                    "",
                    context.getString(R.string.plant_text_update_date, updateDate)
                ),
                updateDate.isNotBlank()
            )
    }
}