package com.nsteuerberg.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val user_name: String,
    @ColumnInfo(name="password") val password: String
)
