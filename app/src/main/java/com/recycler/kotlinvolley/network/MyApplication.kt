package com.recycler.kotlinvolley.network

import android.app.Application

/**
 * Created by Manu on 10/30/2017.
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        VolleySingletion.initConfi(this)
    }
}