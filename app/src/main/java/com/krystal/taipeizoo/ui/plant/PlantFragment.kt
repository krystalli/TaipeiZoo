package com.krystal.taipeizoo.ui.plant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.model.PlantInfo
import kotlinx.android.synthetic.main.fragment_home.*

class PlantFragment : Fragment(), PlantMvpView {

    private val plantPresenter by lazy { PlantPresenter(this) }
    private val plantAdapter by lazy { PlantAdapter(::onPlantItemClick) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(recycler_view_category) {
            layoutManager = LinearLayoutManager(context)
            adapter = plantAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        plantPresenter.viewReady()
    }

    private fun onPlantItemClick(plant: PlantInfo) {
        val bundle = Bundle().apply { putParcelable(KEY_PLANT, plant) }
        findNavController().navigate(R.id.action_nav_plant_to_nav_plant_detail, bundle)
    }

    companion object {
        const val KEY_PLANT = "KEY_PLANT"
    }

    /***** MVP View methods implementation *****/

    override fun updateData(plantList: List<PlantInfo>) {
        loading_progress.visibility = View.GONE
        plantAdapter.updateData(plantList)
    }
}
