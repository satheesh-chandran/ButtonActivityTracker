package com.step.krm.logapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class LogDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "button_id") val buttonId: Int,
    @ColumnInfo(name = "timestamp") val timestamp: Long
)