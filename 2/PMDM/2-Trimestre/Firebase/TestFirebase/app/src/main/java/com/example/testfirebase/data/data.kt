package com.example.testfirebase.data

import androidx.compose.runtime.mutableStateOf
import com.example.testfirebase.model.User

object data {
    val users  = mutableStateOf<List<User>>(emptyList())
    val nombre = mutableStateOf("")
    val edad = mutableStateOf("")
    val documentId = mutableStateOf("")
}