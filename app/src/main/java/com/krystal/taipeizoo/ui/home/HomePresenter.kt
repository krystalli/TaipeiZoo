package com.krystal.taipeizoo.ui.home

import android.util.Log
import com.krystal.taipeizoo.retrofit.ZooApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class HomePresenter(private val homeMvpView: HomeMvpView) {

    fun viewReady() {
        ZooApi.sharedInstance()
            .getHome()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("krystalli", "krystallli success: $it")
                    homeMvpView.updateData(it.result.results)
                },
                { e->
                    Log.d("krystalli", "krystallli error: $e")
                }
        )
    }
}