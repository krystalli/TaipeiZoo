package com.krystal.taipeizoo.ui.home

import com.krystal.taipeizoo.model.Area

interface HomeMvpView {
    fun updateData(areaList: List<Area>)
    fun showOrHideError(isShowed: Boolean)
}