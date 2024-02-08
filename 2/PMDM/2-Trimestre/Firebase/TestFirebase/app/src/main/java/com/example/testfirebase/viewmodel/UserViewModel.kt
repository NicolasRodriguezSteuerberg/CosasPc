package com.example.testfirebase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testfirebase.data.data
import com.example.testfirebase.model.User
import com.example.testfirebase.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserModel): ViewModel() {

    init {
        // Escuchar cambios en la colección de usuarios
        listenForUserChanges()
    }

    private fun listenForUserChanges() {
        viewModelScope.launch {
            // Escucha cambios en la colección de usuarios
            userRepository.listenForUserChanges().collect { userList ->
                // Actualiza la lista de usuarios
                data.users.value = userList
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user)
            data.nombre.value = ""
            data.edad.value = ""
        }
    }

    fun getIdUser(user: User){
        viewModelScope.launch {
            userRepository.getIdUser(user)
        }
    }

    // Actualiza un usuario existente
    fun updateUser(user: User) {
        viewModelScope.launch {
            if (!data.documentId.value.isEmpty()) {
                userRepository.updateUser(data.documentId.value,user)
                data.nombre.value = ""
                data.edad.value = ""
                data.documentId.value = ""
            }
        }
    }
}