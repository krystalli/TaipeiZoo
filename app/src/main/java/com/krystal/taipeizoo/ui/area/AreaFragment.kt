package com.krystal.taipeizoo.ui.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.ui.home.HomeFragment.Companion.KEY_AREA
import com.krystal.taipeizoo.ui.plant.PlantFragment.Companion.KEY_PLANT
import com.krystal.taipeizoo.ui.util.SpaceDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_area.*

class AreaFragment : Fragment(), AreaMvpView {

    private val areaPresenter by lazy { AreaPresenter(this) }
    private val areaAdapter by lazy { AreaAdapter(requireContext(), ::onPlantItemClickListener) }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_area, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(recycler_view_category) {
            adapter = areaAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                SpaceDividerItemDecoration(
                    mapOf(
                        ViewType.AREA to 24,
                        ViewType.PLANT_TITLE to 0,
                        ViewType.PLANT to 2
                    ),
                    0,
                    24
                )
            )
        }

        val area = arguments?.getParcelable<Area>(KEY_AREA) ?: Area.defaultInstance
        (activity as AppCompatActivity).supportActionBar?.title = area.name

        areaPresenter.viewReady(area)
    }

    private fun onPlantItemClickListener(plant: PlantInfo) {
        val bundle = Bundle().apply { putParcelable(KEY_PLANT, plant) }
        findNavController().navigate(R.id.action_nav_area_to_nav_plant_detail, bundle)
    }

    /***** MVP View methods implementation *****/

    override fun updateData(area: Area, plantList: List<PlantInfo>) {
        areaAdapter.updateData(area, plantList)
    }
}
