package com.krystal.taipeizoo.ui.plant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.showTextIfNotBlank
import com.krystal.taipeizoo.model.PlantInfo
import kotlinx.android.synthetic.main.item_area.view.*

class PlantAdapter(
    private val onItemClickListener: (PlantInfo) -> Unit
) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    private var plantList = listOf<PlantInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun getItemCount(): Int = plantList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(plantList[position], onItemClickListener)
    }

    fun updateData(plantList: List<PlantInfo>) {
        this.plantList = plantList
        notifyDataSetChanged()
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_area, parent, false)
    ) {
        fun bind(data: PlantInfo, onItemClickListener: (PlantInfo) -> Unit) {
            with(itemView) {
                setOnClickListener { onItemClickListener(data) }

                image_category.setImageURI(data.imageUrl)
                text_title.text = data.name
                text_description.showTextIfNotBlank(data.description)
                text_memo.showTextIfNotBlank(data.otherNames)
            }
        }
    }
}