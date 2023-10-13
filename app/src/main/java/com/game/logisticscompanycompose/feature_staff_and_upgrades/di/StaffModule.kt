package com.game.logisticscompanycompose.feature_staff_and_upgrades.di

import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.StaffMemberDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.UpgradeDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.StaffMemberRepositoryInterface
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.UpgradeRepositoryInterface
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.FireStaff
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.GetAllStaff
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.HireStaff
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.StaffUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StaffModule {

    @Provides
    @Singleton
    fun provideStaffMemberDao(database: LogisticsCompanyDatabase): StaffMemberDao {
        return database.staffMemberDao
    }


    @Provides
    @Singleton
    fun provideStaffMemberRepository(db: LogisticsCompanyDatabase)
            : StaffMemberRepositoryInterface {
        return StaffMemberRepository(db.staffMemberDao)
    }


    @Provides
    @Singleton
    fun provideStaffUseCase(
        repository: StaffMemberRepository
    ) : StaffUseCases {

        return StaffUseCases(
            hireStaff = HireStaff(repository),
            fireStaff = FireStaff(repository),
            getAllStaff = GetAllStaff(repository)
        )
    }

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


}