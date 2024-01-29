package com.nsteuerberg.room.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nsteuerberg.room.models.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDAO():UserDao
}