package com.example.wangzhao.myapplicationforkotlin.net

import com.example.wangzhao.myapplicationforkotlin.model.WeatherInfoModel
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by wangzhao on 2017/11/20.
 */
interface ApiStores {
    companion object {
        val API_SERVER_URL = "http://www.weather.com.cn/"
    }

    @GET("adat/sk/{cityId}.html")
    fun loadData(@Path("cityId") cityId: String): Observable<WeatherInfoModel>
}