package com.game.logisticscompanycompose.utils.resources

import android.content.Context
import android.graphics.drawable.Drawable
import javax.inject.Inject

class ResourceManager @Inject constructor(private val context: Context) : ResourceManagerInterface {

    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

    override fun getDrawable(resId: Int) : Drawable? {
        return context.getDrawable(resId)
    }

}