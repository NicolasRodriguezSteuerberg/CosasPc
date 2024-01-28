package com.nsteuerberg.room.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object Data{
    var userTxt = mutableStateOf("")
    var passwordTxt = mutableStateOf("")
    var authenticationResult = mutableStateOf<Boolean?>(null)
    var passwordVisible = mutableStateOf(false)
}
