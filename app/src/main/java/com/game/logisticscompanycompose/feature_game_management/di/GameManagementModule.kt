package com.game.logisticscompanycompose.feature_game_management.di

import android.app.Application
import androidx.room.Room
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.repository.LogisticsCompanyRepositoryInterface
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.AddCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.DeleteCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetAllCompanies
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GetCompany
import com.game.logisticscompanycompose.utils.resources.ResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameManagementModule {

    @Provides
    @Singleton
    fun provideLogisticsCompanyDatabase(
        app: Application,
        callback: LogisticsCompanyDatabase.Callback
    ): LogisticsCompanyDatabase {
        return Room.databaseBuilder(
            app,
            LogisticsCompanyDatabase::class.java,
            LogisticsCompanyDatabase.DATABASE_NAME
        )
            .addCallback(callback).build()
    }

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
    fun provideGameManagementUseCase(
        repository: LogisticsCompanyRepository,
        resourceManager: ResourceManager
    ): GameManagementUseCases {

        return GameManagementUseCases(
            getCompany = GetCompany(repository),
            getAllCompanies = GetAllCompanies(repository),
            deleteCompany = DeleteCompany(repository),
            addCompany = AddCompany(repository, resourceManager)
        )
    }


    //creates coroutine scope that lives as long as the application
    //makes sure if one task fails, children are not cancelled
    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    //can define multiple coroutine scopes
    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope


}