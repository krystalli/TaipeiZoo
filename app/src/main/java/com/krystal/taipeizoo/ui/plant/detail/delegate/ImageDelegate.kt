package com.krystal.taipeizoo.ui.plant.detail.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.ui.plant.detail.Item
import com.krystal.taipeizoo.ui.plant.detail.ViewType
import kotlinx.android.synthetic.main.item_image.view.*

class ImageDelegate : AbsListItemAdapterDelegate<Item<String>, Item<*>, ImageDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(
        item: Item<String>, viewHolder: ViewHolder, payloads: List<Any>
    ) = viewHolder.bind(item)

    override fun isForViewType(item: Item<*>, items: List<Item<*>>, position: Int) =
        item.getViewType() == ViewType.IMAGE

    class ViewHolder(val parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
    ) {

        fun bind(item: Item<String>) {
            if (item.data == null) return

            itemView.image_view.setImageURI(item.data)
        }
    }
}