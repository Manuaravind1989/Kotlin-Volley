package com.recycler.kotlinvolley

import android.content.Context
import com.squareup.picasso.Picasso

/**
 * Created by Manu on 10/30/2017.
 */
public val Context.picasso: Picasso
    get() = Picasso.with(this)
