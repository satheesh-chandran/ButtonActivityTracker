package com.step.krm.logapp.data

interface LogRepository {
    fun addLog(buttonId: Int)
    fun getAllLogs(callback: (List<LogDTO>) -> Unit)
    fun removeAllLogs()
}