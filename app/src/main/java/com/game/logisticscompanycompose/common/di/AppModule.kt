package com.game.logisticscompanycompose.common.di

import android.content.Context
import com.game.logisticscompanycompose.utils.ContractIssuingCompaniesList
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
object AppModule {

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
}