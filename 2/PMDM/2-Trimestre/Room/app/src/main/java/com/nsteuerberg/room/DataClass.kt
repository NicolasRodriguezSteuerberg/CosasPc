package com.nsteuerberg.room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object Data{
    var userTxt = mutableStateOf("")
    var passwordTxt = mutableStateOf("")
    var state: MutableState<ViewStates> = mutableStateOf(ViewStates.LOGIN)
}

enum class ViewStates{
    LOGIN,
    CREATE,
    LOGEADO
}