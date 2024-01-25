package com.nsteuerberg.room.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.nsteuerberg.room.models.User
import kotlinx.coroutines.flow.Flow

interface UserDao {
    @Query("SELECT * FROM user ORDER BY user_name ASC")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * from user WHERE user_name in (:userName)")
    fun getUser(userName: String): Flow<User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
