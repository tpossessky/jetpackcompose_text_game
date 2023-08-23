package com.game.logisticscompanycompose.feature_profile.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.game.logisticscompanycompose.utils.GameConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepository @Inject constructor(private val dataStore : DataStore<Preferences>) {

    suspend fun setTheme(id: Int) =
        dataStore.edit { it[GameConstants.DATASTORE_THEME_KEY] = id }

    suspend fun setNotificationPreference(enabled : Boolean) =
        dataStore.edit { it[GameConstants.DATASTORE_NOTIF_KEY] = enabled }

    //TODO: CHANGE TO RETURN TYPE THAT MAKES SENSE
    fun getTheme() : Flow<Int> =
        dataStore.data.map { it[GameConstants.DATASTORE_THEME_KEY] ?: 0 }

    fun getNotificationPreference() : Flow<Boolean> =
        dataStore.data.map { it[GameConstants.DATASTORE_NOTIF_KEY] ?: true }

}