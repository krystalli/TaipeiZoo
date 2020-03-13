package com.krystal.taipeizoo.ui.area.delegate

import android.view.ViewGroup
import android.view.LayoutInflater
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import androidx.recyclerview.widget.RecyclerView
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.launchUrl
import com.krystal.taipeizoo.extension.showTextIfNotBlank
import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.ui.area.Item
import com.krystal.taipeizoo.ui.area.ViewType
import kotlinx.android.synthetic.main.item_area_detail.view.*

class AreaDelegate : AbsListItemAdapterDelegate<Item<Area>, Item<*>, AreaDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(
        item: Item<Area>, viewHolder: ViewHolder, payloads: List<Any>
    ) = viewHolder.bind(item)

    override fun isForViewType(item: Item<*>, items: List<Item<*>>, position: Int) =
        item.getViewType() == ViewType.AREA

    class ViewHolder(val parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_area_detail, parent, false)
    ) {

        fun bind(item: Item<Area>) {
            if (item.data == null) return

            val data = item.data
            with(itemView) {
                image_category.setImageURI(data.imageUrl)
                text_description.showTextIfNotBlank(data.description)
                text_memo.showTextIfNotBlank(data.memo)
                text_area.showTextIfNotBlank(data.category)
                text_link.setOnClickListener { context.launchUrl(data.url) }
            }
        }
    }
}