package com.step.krm.logapp.data

interface LogRepository {
    fun addLog(buttonId: Int): LogDTO
    fun getAllLogs(): List<LogDTO>
    fun removeAllLogs()
}