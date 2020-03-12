package com.krystal.taipeizoo.ui.area.delegate

import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import androidx.recyclerview.widget.RecyclerView
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.ui.area.Item
import com.krystal.taipeizoo.ui.area.ViewType

class PlantTitleDelegate : AbsListItemAdapterDelegate<Item<Any>, Item<*>, PlantTitleDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant_title, parent, false)

        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(item: Item<Any>, holder: ViewHolder, payloads: MutableList<Any>) {}

    override fun isForViewType(item: Item<*>, items: MutableList<Item<*>>, position: Int) =
        item.getViewType() == ViewType.PLANT_TITLE

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}