package com.step.krm.logapp.data

import java.util.LinkedList

class LogRepositoryImpl private constructor(): LogRepository {
    private var lastLogId: Int = 0;
    private val logs = LinkedList<LogDTO>()

    override fun addLog(buttonId: Int): LogDTO {
        val log = LogDTO(++lastLogId, buttonId, System.currentTimeMillis())
        logs.add(log)
        return log
    }

    override fun getAllLogs(): LinkedList<LogDTO> = logs

    override fun removeAllLogs() {
        logs.clear()
    }

    companion object {
        private var utilProject: LogRepositoryImpl? = null

        val instance: LogRepositoryImpl
            get() {
                if (utilProject == null) utilProject = LogRepositoryImpl()
                return utilProject!!
            }
    }
}