package com.krystal.taipeizoo.ui.area.delegate

import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.AdapterView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import androidx.recyclerview.widget.RecyclerView
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.launchUrl
import com.krystal.taipeizoo.extension.showTextIfNotBlank
import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.area.Item
import com.krystal.taipeizoo.ui.area.ViewType
import kotlinx.android.synthetic.main.item_plant.view.*

data class PlantInfoViewInfo(
    val plantInfo: PlantInfo,
    val onItemClickListener: (PlantInfo) -> Unit
)

class PlantDelegate : AbsListItemAdapterDelegate<Item<PlantInfo>, Item<*>, PlantDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(
        item: Item<PlantInfo>, viewHolder: ViewHolder, payloads: List<Any>
    ) = viewHolder.bind(item)

    override fun isForViewType(item: Item<*>, items: List<Item<*>>, position: Int) =
        item.getViewType() == ViewType.PLANT

    class ViewHolder(val parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
    ) {

        fun bind(item: Item<PlantInfo>) {
            if (item.data == null) return

            val data = item.data
            with(itemView) {
                image_category.setImageURI(data.imageUrl)
                text_title.showTextIfNotBlank(data.name)
                text_description.showTextIfNotBlank(data.otherNames)
            }
        }
    }
}