package com.krystal.taipeizoo.retrofit

import com.google.gson.*
import com.google.gson.internal.bind.DateTypeAdapter
import com.krystal.taipeizoo.model.Category
import com.krystal.taipeizoo.model.CategoryData
import com.krystal.taipeizoo.model.PlantData
import com.krystal.taipeizoo.model.PlantInfo
import com.krystal.taipeizoo.retrofit.ServerParam.API_URL
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ZooApi {

    val gson = GsonBuilder().apply {
        registerTypeAdapter(Array<String>::class.java, DateTypeAdapter())
    }.create()

    private val zooService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(RetrofitUtil.genericClient())
            .baseUrl(API_URL)
            .build()
            .create(ZooService::class.java)
    }

    fun getHome(): Observable<CategoryData> {
        return zooService.getCategory()
    }

    fun getPlants(queryString: String): Observable<PlantData> {
        return zooService.getPlants(queryString)
    }

    companion object {

//        @SuppressLint("StaticFieldLeak")
        private val instance = ZooApi()

//        @JvmStatic
        fun sharedInstance(): ZooApi = instance
    }

}