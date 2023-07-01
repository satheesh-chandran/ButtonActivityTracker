package com.step.krm.logapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface LogsDao {
    @Query("SELECT * FROM logs")
    fun getAll(): List<LogDTO>

    @Query("SELECT * FROM logs WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<LogDTO>

    @Query("INSERT INTO logs (button_id, timestamp) VALUES (:buttonId, :timestamp)")
    fun insertLog(buttonId: Int, timestamp: Long = System.currentTimeMillis())

    @Delete
    fun delete(logs: LogDTO)

    @Query("DELETE FROM logs")
    fun nukeTable()
}