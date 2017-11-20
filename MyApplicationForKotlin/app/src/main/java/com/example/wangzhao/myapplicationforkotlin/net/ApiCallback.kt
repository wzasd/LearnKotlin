package com.example.wangzhao.myapplicationforkotlin.net

import android.util.Log
import retrofit2.HttpException
import rx.Subscriber


/**
 * Created by wangzhao on 2017/11/20.
 */
abstract class ApiCallback<M> : Subscriber<M>() {
    abstract fun onSuccess(model: M)
    abstract fun onFailure(msg: String?)
    abstract fun onFinish()

    override fun onCompleted() {
        onFinish()
    }

    override fun onNext(t: M) {
        onSuccess(t)
    }

    override fun onError(e: Throwable?) {
        if (e is HttpException) {
            val httpException = e
            val code = httpException.code()
            var msg = httpException.message
            Log.d("error", "code" + code)
            if (code == 504) {
                msg = "net error"
            }

            if (code == 502 || code == 404) {
                msg = "respons error"
            }

            onFailure(msg)
        } else {
            onFailure(e.toString())
        }

        onFinish();
    }
}