package com.game.logisticscompanycompose.feature_game_management.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow

@Dao
interface LogisticsCompanyDao {

    @Insert
    suspend fun insertCompany(company: LogisticsCompany)

    @Update
    suspend fun updateCompany(company: LogisticsCompany)

    @Delete
    suspend fun deleteCompany(company: LogisticsCompany)

    @Query("SELECT * FROM logisticscompany")
    fun getAllCompanies() : Flow<List<LogisticsCompany>>

    @Query("SELECT * FROM logisticscompany WHERE id = :companyID")
    fun getCompany(companyID : Int) : LogisticsCompany

}