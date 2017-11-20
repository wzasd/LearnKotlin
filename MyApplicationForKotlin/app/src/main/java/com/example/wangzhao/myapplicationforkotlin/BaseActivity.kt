package com.example.wangzhao.myapplicationforkotlin

import android.support.v7.app.AppCompatActivity
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by wangzhao on 2017/11/20.
 */
open class BaseActivity : AppCompatActivity() {
    private val mCompositeSubscription: CompositeSubscription = CompositeSubscription()

    override fun onDestroy() {
        if(mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe()
        }
        super.onDestroy()
    }

    open fun <M> addSubscription(observable: Observable<M>,subscriber: Subscriber<M>) {
        mCompositeSubscription.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber)
        )
    }
}