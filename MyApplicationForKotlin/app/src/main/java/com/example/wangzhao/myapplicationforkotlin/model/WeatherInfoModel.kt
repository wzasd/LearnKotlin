package com.example.wangzhao.myapplicationforkotlin.model

/**
 * Created by wangzhao on 2017/11/20.
 */
data class WeatherInfoModel constructor(val weatherinfo: WeatherinfoBean){

    data class WeatherinfoBean(
        val city: String,
        val cityid: String
    )
}