package com.krystal.taipeizoo.ui.home

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.showTextIfNotBlank
import com.krystal.taipeizoo.model.Area
import kotlinx.android.synthetic.main.item_area.view.*

class HomeAdapter(
    private val onItemClickListener: (Area) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var areaList = listOf<Area>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun getItemCount(): Int = areaList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as ViewHolder
        viewHolder.bind(areaList[position], position, onItemClickListener)
    }

    fun updateData(areaList: List<Area>) {
        this.areaList = areaList
        notifyDataSetChanged()
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_area, parent, false)
    ) {
        fun bind(data: Area, position: Int, onItemClickListener: (Area) -> Unit) {
            with(itemView) {
                setOnClickListener { onItemClickListener(data) }

                image_category.setImageURI(data.imageUrl)
                text_title.text = context.getString(R.string.category_title, data.name, data.catrgory)
                text_description.showTextIfNotBlank(data.description)
                text_memo.showTextIfNotBlank(data.memo)
            }
        }
    }
}