package com.krystal.taipeizoo.ui.home

import android.annotation.SuppressLint
import com.krystal.taipeizoo.retrofit.ZooApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val homeMvpView: HomeMvpView) {

    @SuppressLint("CheckResult")
    fun viewReady() {
        ZooApi.sharedInstance()
            .getHome()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { homeMvpView.updateData(it.result.results) },
                { homeMvpView.showOrHideError(true) }
        )
    }
}