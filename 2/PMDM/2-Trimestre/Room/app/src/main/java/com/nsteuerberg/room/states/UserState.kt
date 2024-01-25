package com.nsteuerberg.room.states

import com.nsteuerberg.room.models.User

data class UserState(
    val userlist: List<User> = emptyList()
)
