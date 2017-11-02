package com.recycler.kotlinvolley.network

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Created by Manu on 10/30/2017.
 */


object  VolleySingletion{

    private lateinit  var context: Context

    val  requestQueque : RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }

    val  imageLoader : ImageLoader by lazy {
        ImageLoader(requestQueque,LruBtimapCache() )
    }

    fun  initConfi(context:Context){
        this.context =context.applicationContext
    }


}