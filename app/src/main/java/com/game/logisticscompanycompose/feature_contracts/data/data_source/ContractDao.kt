package com.game.logisticscompanycompose.feature_contracts.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import kotlinx.coroutines.flow.Flow

@Dao
interface ContractDao {

    @Query("SELECT * FROM Contract WHERE companyId = :companyId")
    fun getAllContractsByCompanyID(companyId: Int) : Flow<List<Contract>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContract(contract: Contract) : Long

    @Update
    suspend fun updateContract(contract: Contract)

    @Delete
    suspend fun delete(contract: Contract)

    @Query("DELETE FROM Contract WHERE id = :id")
    suspend fun deleteById(id: Int)
}
