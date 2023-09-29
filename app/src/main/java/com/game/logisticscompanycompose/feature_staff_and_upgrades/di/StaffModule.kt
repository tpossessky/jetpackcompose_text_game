package com.game.logisticscompanycompose.feature_staff_and_upgrades.di

import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.StaffMemberDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.StaffMemberRepositoryInterface
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



}