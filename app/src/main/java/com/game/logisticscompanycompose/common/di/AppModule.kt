package com.game.logisticscompanycompose.common.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.game.logisticscompanycompose.common.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.utils.ContractIssuingCompaniesList
import com.game.logisticscompanycompose.utils.resources.ResourceManager
import com.game.logisticscompanycompose.utils.resources.ResourceManagerInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


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
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideContractIssuingCompanies(context: Context) : ContractIssuingCompaniesList {
        return ContractIssuingCompaniesList(context)
    }

    @Provides
    @Singleton
    fun provideResourceManager(@ApplicationContext context: Context): ResourceManagerInterface {
        return ResourceManager(context)
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