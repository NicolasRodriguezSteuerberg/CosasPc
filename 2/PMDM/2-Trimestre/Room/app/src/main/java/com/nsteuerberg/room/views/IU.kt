package com.nsteuerberg.room.views

import androidx.compose.runtime.Composable
import com.nsteuerberg.room.Data
import com.nsteuerberg.room.ViewStates
import com.nsteuerberg.room.viewmodels.UserViewModel

@Composable
fun Inicio(){
    if (Data.state.value == ViewStates.LOGIN){
        LoginScreen()
    } else if (Data.state.value == ViewStates.LOGEADO){

    } else{

    }
}