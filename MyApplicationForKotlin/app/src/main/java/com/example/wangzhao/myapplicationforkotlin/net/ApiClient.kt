package com.example.wangzhao.myapplicationforkotlin.net

import com.example.wangzhao.myapplicationforkotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wangzhao on 2017/11/20.
 */
object ApiClient {
    fun retrofit(): ApiStores {
        val builder = OkHttpClient.Builder()

        if(BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        val okHttpClient = builder.build();

        val retrofit = Retrofit.Builder()
                .baseUrl(ApiStores.API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        //ApiStores::class.java取得对象的 Java 类
        return retrofit.create(ApiStores::class.java)
    }
}