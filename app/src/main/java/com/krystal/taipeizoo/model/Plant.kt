package com.krystal.taipeizoo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PlantData(
    val result: Plant
)

data class Plant(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<PlantInfo>
)

@Parcelize
data class PlantInfo(
    @SerializedName("F_Name_Ch") val name: String,
    @SerializedName("F_Name_En") private val _englishName: String?,
    @SerializedName("F_AlsoKnown") private val _otherNames: String?,
    @SerializedName("F_Brief") private val _description: String?,
    @SerializedName("F_Feature") private val _feature: String?,
    @SerializedName("F_Function&Application") private val _functionality: String?,
    @SerializedName("F_Update") private val _updateDate: String?,
    @SerializedName("F_Pic01_URL") val imageUrl: String?
) : Parcelable {

    val englishName: String
        get() = _englishName ?: ""

    val otherNames: String
        get() = _otherNames ?: ""

    val description: String
        get() = _description ?: ""

    val feature: String
        get() = _feature ?: ""

    val functionality: String
        get() = _functionality ?: ""

    val updateDate: String
        get() = _updateDate ?: ""

    companion object {
        val defaultInstance = PlantInfo("", "", "", "", "", "", "", "")
    }
}