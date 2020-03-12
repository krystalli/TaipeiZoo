package com.krystal.taipeizoo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.krystal.taipeizoo.retrofit.ZooApi

class ZooApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
        ZooApi.sharedInstance()
    }
}