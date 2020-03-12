package com.krystal.taipeizoo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CategoryData(
    val result: Category
)

data class Category(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<Area>
)

@Parcelize
data class Area(
    @SerializedName("E_no") val id: String,
    @SerializedName("E_Category") val catrgory: String,
    @SerializedName("E_Name") val name: String,
    @SerializedName("E_Pic_URL") val imageUrl: String,
    @SerializedName("E_Info") val description: String,
    @SerializedName("E_Memo") val memo: String,
    @SerializedName("E_Geo") val location: String,
    @SerializedName("E_URL") val url: String
) : Parcelable {

    companion object {
        val defaultInstance = Area("", "", "", "", "", "", "", "")
    }
}