package com.game.logisticscompanycompose.feature_game_management.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow

@Dao
interface LogisticsCompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompany(company: LogisticsCompany) : Long


    @Query("DELETE FROM logisticscompany WHERE id = :companyId")
    suspend fun deleteCompanyById(companyId: Int)


    @Query("SELECT * FROM logisticscompany")
    fun getAllCompanies(): Flow<List<LogisticsCompany>>

    @Query("SELECT * FROM logisticscompany WHERE id = :companyID")
    suspend fun getCompany(companyID: Int): LogisticsCompany?

    @Query("SELECT * FROM logisticscompany WHERE id = :companyID")
    fun getCompanyFlow(companyID: Int): Flow<LogisticsCompany?>


    @Update
    suspend fun updateCompany(company: LogisticsCompany)

    @Query("UPDATE logisticscompany SET cash = :cash WHERE id = :id")
    suspend fun updateCash(cash : String, id : Int)
}