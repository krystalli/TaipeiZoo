package com.krystal.taipeizoo.ui.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krystal.taipeizoo.util.Device

class SpaceDividerItemDecoration : RecyclerView.ItemDecoration {

    private var dpSpace = 0
    private var dpHeadSpace = 0
    private var dpFootSpace = 0
    private var isHorizontalLayout = false
    private var isReverseLayout = false

    private var dpMap: Map<Int, Int> = mapOf()

    constructor(
            dpMap: Map<Int, Int>,
            dpHeadSpace: Int = 0,
            dpFootSpace: Int = 0,
            isReverseLayout: Boolean = false
    ) {
        this.dpMap = dpMap
        this.dpHeadSpace = dpHeadSpace
        this.dpFootSpace = dpFootSpace
        this.isReverseLayout = isReverseLayout
    }

    constructor(dpMap: Map<Int, Int>, isHorizontalLayout: Boolean, isReverseLayout: Boolean = false) {
        this.dpMap = dpMap
        this.isHorizontalLayout = isHorizontalLayout
        this.isReverseLayout = isReverseLayout
    }

    override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val childPosition = parent.getChildAdapterPosition(view)
        val viewType = if (childPosition >= 0) {
            parent.adapter?.getItemViewType(parent.getChildAdapterPosition(view)) ?: -1
        } else {
            -1
        }
        val dpSpace = dpMap.getOrElse(viewType) { dpSpace }
        val space = Device.dpToPx(dpSpace / 2)
        val headSpace = Device.dpToPx(dpHeadSpace)
        val footSpace = Device.dpToPx(dpFootSpace)

        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if (isHorizontalLayout) {
            outRect.left = if (position == 0) headSpace else space
            outRect.right = if (position == itemCount - 1) footSpace else space
        } else {
            if (!isReverseLayout) {
                outRect.top = if (parent.getChildAdapterPosition(view) == 0) headSpace else space
                outRect.bottom = if (position == itemCount - 1) footSpace else space
            } else {
                outRect.top = if (position == itemCount - 1) headSpace else space
                outRect.bottom = if (parent.getChildAdapterPosition(view) == 0) footSpace else space
            }
        }
    }
}