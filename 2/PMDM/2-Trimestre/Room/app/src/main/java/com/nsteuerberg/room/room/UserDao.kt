package com.nsteuerberg.room.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nsteuerberg.room.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY user_name ASC")
    fun getUsers(): Flow<List<User>>

    // puedo recuperar solo un campo
    @Query("SELECT password from user WHERE user_name in (:userName)")
    fun getUser(userName: String): Flow<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}
