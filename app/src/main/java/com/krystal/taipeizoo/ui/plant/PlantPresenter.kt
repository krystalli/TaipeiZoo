package com.krystal.taipeizoo.ui.plant

import android.util.Log
import com.krystal.taipeizoo.retrofit.ZooApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class PlantPresenter(private val plantMvpView: PlantMvpView) {

    fun viewReady() {
        ZooApi.sharedInstance()
            .getPlants("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("krystalli", "krystallli success: $it")
                    plantMvpView.updateData(it.result.results)
                },
                { e->
                    Log.d("krystalli", "krystallli error: $e")
                }
        )
    }
}