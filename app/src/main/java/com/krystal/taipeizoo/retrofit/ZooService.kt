package com.krystal.taipeizoo.retrofit

import com.krystal.taipeizoo.model.CategoryData
import com.krystal.taipeizoo.model.PlantData
import com.krystal.taipeizoo.model.PlantInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ZooService {

    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    fun getCategory(): Observable<CategoryData>

    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getPlants(
        @Query("q") queryString: String
    ): Observable<PlantData>
}