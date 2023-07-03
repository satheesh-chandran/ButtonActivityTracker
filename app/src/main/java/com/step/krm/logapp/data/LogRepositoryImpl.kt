package com.step.krm.logapp.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class LogRepositoryImpl @Inject constructor(private val logsDao: LogsDao) : LogRepository {
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
}