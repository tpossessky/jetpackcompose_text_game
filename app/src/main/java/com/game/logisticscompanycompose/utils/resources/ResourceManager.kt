package com.game.logisticscompanycompose.utils.resources

import android.content.Context

class ResourceManager(private val context: Context) : ResourceManagerInterface {

    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

}