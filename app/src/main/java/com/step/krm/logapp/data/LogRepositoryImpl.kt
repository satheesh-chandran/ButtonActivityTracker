package com.step.krm.logapp.data

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LogRepositoryImpl private constructor(private val logsDao: LogsDao) : LogRepository {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)

    override fun addLog(buttonId: Int) {
        executorService.execute {
            logsDao.insertLog(buttonId, System.currentTimeMillis())
        }
    }

    override fun getAllLogs(callback: (List<LogDTO>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
             callback(logsDao.getAll())
        }
    }

    override fun removeAllLogs() {
        executorService.execute {
            logsDao.nukeTable()
        }
    }

    companion object {
        private var utilProject: LogRepositoryImpl? = null

        fun instance(context: Context): LogRepositoryImpl {
            if (utilProject == null) {
                val logDatabase = Room.databaseBuilder(
                    context, LogDatabase::class.java, "log_app_data_store"
                ).build()
                utilProject = LogRepositoryImpl(logDatabase.logDao())
            }
            return utilProject!!
        }
    }
}