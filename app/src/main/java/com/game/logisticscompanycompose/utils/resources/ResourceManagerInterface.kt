package com.game.logisticscompanycompose.utils.resources

import android.graphics.drawable.Drawable

interface ResourceManagerInterface {
    fun getString(resId: Int): String

    fun getDrawable(resId: Int): Drawable?
}