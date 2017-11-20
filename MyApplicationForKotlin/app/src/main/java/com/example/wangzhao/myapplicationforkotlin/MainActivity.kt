package com.example.wangzhao.myapplicationforkotlin

import android.os.Bundle
import android.util.Log
import com.example.wangzhao.myapplicationforkotlin.model.WeatherInfoModel
import com.example.wangzhao.myapplicationforkotlin.net.ApiCallback
import com.example.wangzhao.myapplicationforkotlin.net.ApiClient

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //object为对象表达式
        addSubscription(ApiClient.retrofit().loadData("101190201"),object : ApiCallback<WeatherInfoModel>() {
            override fun onSuccess(model: WeatherInfoModel) {
                Log.d("wxl", "city=" + model.weatherinfo.city + ",cityid=" + model.weatherinfo.cityid)//输出“city=无锡,cityid=101190201”
            }

            override fun onFailure(msg: String?) {
                Log.d("wxl", "onFailure=" + msg)
            }

            override fun onFinish() {
                Log.d("wxl", "onFinish")
            }

        })
    }
}
