package com.game.logisticscompanycompose.feature_game_management.di

import android.content.Context
import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.repository.LogisticsCompanyRepositoryInterface
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.AddCash
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.AddCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.DeleteCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetAllCompanies
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.ObserveCompanyUseCase
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.SubtractCash
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.UpdateCompany
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.utils.resources.ResourceManager
import com.game.logisticscompanycompose.utils.resources.ResourceManagerInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameManagementModule {


    @Provides
    @Singleton
    fun provideLogisticsCompanyDao(database: LogisticsCompanyDatabase): LogisticsCompanyDao {
        return database.logCompDao
    }

    @Provides
    @Singleton
    fun provideLogisticsCompanyRepository(db: LogisticsCompanyDatabase)
            : LogisticsCompanyRepositoryInterface {
        return LogisticsCompanyRepository(db.logCompDao)
    }

    @Provides
    @Singleton
    fun provideResourceManager(@ApplicationContext context: Context): ResourceManagerInterface {
        return ResourceManager(context)
    }


    @Provides
    @Singleton
    fun provideGameManagementUseCase(
        repository: LogisticsCompanyRepository,
        upgradeRep : UpgradeRepository,
        resourceManager: ResourceManager
    ): GameManagementUseCases {

        return GameManagementUseCases(
            getCompany = GetCompany(repository),
            getAllCompanies = GetAllCompanies(repository),
            deleteCompany = DeleteCompany(repository),
            addCompany = AddCompany(repository = repository, resourceManager = resourceManager, upgradeRepo = upgradeRep),
            updateCompany = UpdateCompany(repository),
            subtractCash = SubtractCash(repository),
            addCash = AddCash(repository),
            observeCompanyUseCase = ObserveCompanyUseCase(repository)
        )
    }

}