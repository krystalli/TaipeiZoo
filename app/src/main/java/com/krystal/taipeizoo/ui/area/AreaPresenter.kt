package com.krystal.taipeizoo.ui.area

import android.util.Log
import com.krystal.taipeizoo.model.Area
import com.krystal.taipeizoo.retrofit.ZooApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AreaPresenter(private val areaMvpView: AreaMvpView) {

    private var area = Area.defaultInstance

    fun viewReady(area: Area) {
        this.area = area

        ZooApi.sharedInstance().getPlants(area.name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("krystalli", "krystallli success: $it")
                    areaMvpView.updateData(area, it.result.results)
                },
                { e->
                    Log.d("krystalli", "krystallli error: $e")
                }
            )
    }
}