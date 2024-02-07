package com.example.testfirebase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testfirebase.data.data
import com.example.testfirebase.model.User
import com.example.testfirebase.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserModel): ViewModel() {


    init {
        // Cargar datos del modelo al inicializar el ViewModel
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            val userList = userRepository.getUsers()
            // Actualiza la lista de usuarios
            data.users.value = userList
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user)
            // Actualiza la lista de usuarios después de agregar uno nuevo
            loadUsers()
        }
    }

    fun updateUser(documentId: String, user: User) {
        viewModelScope.launch {
            userRepository.updateUser(documentId, user)
            // Actualiza la lista de usuarios después de actualizar uno existente
            loadUsers()
        }
    }
}