package com.game.logisticscompanycompose.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.repository.LogisticsCompanyRepositoryInterface
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.AddCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.DeleteCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetAllCompanies
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetCompany
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
class AppModule {

    @Provides
    @Singleton
    fun provideLogisticsCompanyDatabase(app : Application) : LogisticsCompanyDatabase {
        return Room.databaseBuilder(app,
            LogisticsCompanyDatabase::class.java,
            LogisticsCompanyDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideLogisticsCompanyRepository(db : LogisticsCompanyDatabase)
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
    fun provideGameManagementUseCase(repository: LogisticsCompanyRepository,
                                     resourceManager: ResourceManager) : GameManagementUseCases {

        return GameManagementUseCases(
            getCompany = GetCompany(repository),
            getAllCompanies = GetAllCompanies(repository),
            deleteCompany = DeleteCompany(repository),
            addCompany = AddCompany(repository, resourceManager)
        )
    }



}