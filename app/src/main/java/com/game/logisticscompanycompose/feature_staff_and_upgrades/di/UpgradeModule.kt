package com.game.logisticscompanycompose.feature_staff_and_upgrades.di

import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.UpgradeDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.UpgradeRepositoryInterface
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.UpgradeInitUseCase
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.UpgradeUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UpgradeModule {


    @Provides
    @Singleton
    fun provideUpgradeDao(database: LogisticsCompanyDatabase): UpgradeDao {
        return database.upgradeDao
    }


    @Provides
    @Singleton
    fun provideUpgradeRepository(db: LogisticsCompanyDatabase)
            : UpgradeRepositoryInterface  {
        return UpgradeRepository(db.upgradeDao)
    }

    @Provides
    @Singleton
    fun provideUpgradeUseCases(repository: UpgradeRepository) : UpgradeUseCases{
        return UpgradeUseCases(
            upgradeInitUseCase = UpgradeInitUseCase(repository)
        )
    }


}