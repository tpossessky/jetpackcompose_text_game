package com.game.logisticscompanycompose.feature_contracts.di

import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_contracts.data.data_source.ContractDao
import com.game.logisticscompanycompose.feature_contracts.data.repository.ContractRepository
import com.game.logisticscompanycompose.feature_contracts.domain.repository.ContractRepositoryInterface
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.AddContract
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.ContractUseCases
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.DeleteContract
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.DeleteContractById
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.GenerateContracts
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.GetContractsByCompanyId
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.UpdateContract
import com.game.logisticscompanycompose.utils.ContractIssuingCompaniesList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContractsModule {


    @Provides
    @Singleton
    fun provideContractDao(database: LogisticsCompanyDatabase) : ContractDao = database.contractDao


    @Provides
    @Singleton
    fun provideContractRepository(db: LogisticsCompanyDatabase)
            : ContractRepositoryInterface {
        return ContractRepository(db.contractDao)
    }


    @Provides
    @Singleton
    fun provideContractUseCases(
        list : ContractIssuingCompaniesList,
        repository: ContractRepository) : ContractUseCases =

        ContractUseCases(
            addContract = AddContract(repository),
            deleteContract = DeleteContract(repository),
            deleteContractById = DeleteContractById(repository),
            generateContracts = GenerateContracts(list),
            getContractsByCompanyId = GetContractsByCompanyId(repository),
            updateContract = UpdateContract(repository)
        )



}