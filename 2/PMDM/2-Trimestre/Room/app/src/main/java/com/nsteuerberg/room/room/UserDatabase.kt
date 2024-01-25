package com.nsteuerberg.room.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nsteuerberg.room.models.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDAO():UserDao
}