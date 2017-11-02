package com.recycler.kotlinvolley.network

import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.toolbox.ImageLoader

/**
 * Created by Manu on 10/30/2017.
 */
class LruBtimapCache (size: Int= defaultSize ): LruCache<String, Bitmap>(size) , ImageLoader.ImageCache{

    override fun getBitmap(url: String): Bitmap ?{
        return get(url)
    }
    override fun putBitmap(url: String?, bitmap: Bitmap?) {
        put(url,bitmap)
    }
    override fun sizeOf(key: String, value: Bitmap): Int {
        return   value.rowBytes*value.height/1024
    }

    companion object{

        val  defaultSize: Int get() {
            val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
            val cacheSize = maxMemory / 8
            return cacheSize
        }
    }
}