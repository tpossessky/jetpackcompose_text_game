package com.game.logisticscompanycompose.feature_staff_and_upgrades.di

import android.app.Application
import androidx.room.Room
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.StaffMemberDatabase
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
    fun provideStaffDatabase(
        app: Application,
        callback: StaffMemberDatabase.Callback
    ): StaffMemberDatabase {
        return Room.databaseBuilder(
            app,
            StaffMemberDatabase::class.java,
            StaffMemberDatabase.DATABASE_NAME
        )
            .addCallback(callback).build()
    }

    @Provides
    @Singleton
    fun provideStaffMemberDao(database: LogisticsCompanyDatabase): LogisticsCompanyDao {
        return database.logCompDao
    }

    @Provides
    @Singleton
    fun provideStaffMemberRepository(db: StaffMemberDatabase)
            : StaffMemberRepositoryInterface {
        return StaffMemberRepository(db.staffMemberDao)
    }



}