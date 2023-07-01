package com.step.krm.logapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LogDTO::class], version = 1)
abstract class LogDatabase : RoomDatabase() {
    abstract fun logDao(): LogsDao
}