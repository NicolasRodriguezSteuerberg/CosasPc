package com.nsteuerberg.room.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.nsteuerberg.room.models.User
import com.nsteuerberg.room.room.UserDao
import com.nsteuerberg.room.states.UserState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(private val dao: UserDao): ViewModel() {
    var state by mutableStateOf(UserState())
        private set
    init {
        viewModelScope.launch {
            dao.getUsers().collectLatest{
                state = state.copy(
                    userlist = it
                )
            }
        }
    }

    fun addUser(user: User) = viewModelScope.launch{
        dao.insert(user)
    }

    fun delete(user: User)= viewModelScope.launch {
        dao.delete(user)
    }
}