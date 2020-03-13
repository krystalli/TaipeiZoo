package com.krystal.taipeizoo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.krystal.taipeizoo.R
import com.krystal.taipeizoo.extension.hide
import com.krystal.taipeizoo.extension.showOrHide
import com.krystal.taipeizoo.model.Area
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeMvpView {

    private val homePresenter by lazy { HomePresenter(this) }
    private val homeAdapter by lazy { HomeAdapter(::onAreaItemClick) }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(recycler_view_category) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        homePresenter.viewReady()
    }

    private fun onAreaItemClick(area: Area) {
        val bundle = Bundle().apply { putParcelable(KEY_AREA, area) }
        findNavController().navigate(R.id.action_nav_home_to_nav_area, bundle)
    }

    companion object {
        const val KEY_AREA = "KEY_AREA"
    }

    /***** MVP View methods implementation *****/

    override fun updateData(areaList: List<Area>) {
        loading_progress.hide()
        homeAdapter.updateData(areaList)
        showOrHideError(false)
    }

    override fun showOrHideError(isShowed: Boolean) {
        loading_progress.hide()
        text_error.showOrHide(isShowed)
    }
}
