package com.step.krm.logapp.module

import android.content.Context
import androidx.room.Room
import com.step.krm.logapp.data.LogDatabase
import com.step.krm.logapp.data.LogRepository
import com.step.krm.logapp.data.LogRepositoryImpl
import com.step.krm.logapp.data.LogsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LogDatabase {
        return Room.databaseBuilder(
            context, LogDatabase::class.java, "log_app_data_store"
        ).build()
    }

    @Provides
    fun provideLogDao(database: LogDatabase): LogsDao {
        return database.logDao()
    }

    @Provides
    @Singleton
    fun provideLogRepository(logsDao: LogsDao) : LogRepository {
        return LogRepositoryImpl(logsDao)
    }
}