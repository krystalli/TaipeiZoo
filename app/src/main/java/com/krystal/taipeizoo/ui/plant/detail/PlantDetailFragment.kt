package com.krystal.taipeizoo.ui.plant.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.plant.PlantFragment.Companion.KEY_PLANT
import com.krystal.taipeizoo.ui.util.SpaceDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_area.*

class PlantDetailFragment : Fragment() {

    private val plantDetailAdapter by lazy { PlantDetailAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_area, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(recycler_view_category) {
            adapter = plantDetailAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                SpaceDividerItemDecoration(
                    mapOf(
                        ViewType.IMAGE to 16,
                        ViewType.PLANT_DETAIL to 0
                    ),
                    0,
                    24
                )
            )
        }

        val plantInfo = arguments?.getParcelable<PlantInfo>(KEY_PLANT) ?: PlantInfo.defaultInstance
        (activity as AppCompatActivity).supportActionBar?.title = plantInfo.name

        plantDetailAdapter.updateData(plantInfo)
    }
}
