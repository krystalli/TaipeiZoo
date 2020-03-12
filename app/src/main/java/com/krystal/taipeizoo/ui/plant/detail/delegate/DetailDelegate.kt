package com.krystal.taipeizoo.ui.plant.detail.delegate

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.showTextIfNotBlank
import com.krystal.taipeizoo.ui.plant.detail.Item
import com.krystal.taipeizoo.ui.plant.detail.ViewType
import kotlinx.android.synthetic.main.item_plant_info.view.*

data class DetailViewInfo(
    val title: String,
    val detail: String,
    val isTitleBold: Boolean = false,
    @ColorRes val titleColorInt: Int = R.color.grey_ff_88
)

class PlantInfoDelegate : AbsListItemAdapterDelegate<Item<DetailViewInfo>, Item<*>, PlantInfoDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(
        item: Item<DetailViewInfo>, viewHolder: ViewHolder, payloads: List<Any>
    ) = viewHolder.bind(item)

    override fun isForViewType(item: Item<*>, items: List<Item<*>>, position: Int) =
        item.getViewType() == ViewType.PLANT_DETAIL

    class ViewHolder(val parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_plant_info, parent, false)
    ) {

        fun bind(item: Item<DetailViewInfo>) {
            if (item.data == null) return

            val data = item.data
            with(itemView) {
                text_title.apply {
                    showTextIfNotBlank(data.title)

                    setTextColor(ContextCompat.getColor(context, data.titleColorInt))

                    if (data.isTitleBold) setTypeface(null, Typeface.BOLD)
                    else setTypeface(null, Typeface.NORMAL)
                }
                text_description.showTextIfNotBlank(data.detail)
            }
        }
    }
}