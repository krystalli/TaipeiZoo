package com.krystal.taipeizoo.ui.plant

import android.annotation.SuppressLint
import com.krystal.taipeizoo.retrofit.ZooApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlantPresenter(private val plantMvpView: PlantMvpView) {

    @SuppressLint("CheckResult")
    fun viewReady() {
        ZooApi.sharedInstance()
            .getPlants("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { plantMvpView.updateData(it.result.results) },
                { plantMvpView.showOrHideError(true) }
        )
    }
}