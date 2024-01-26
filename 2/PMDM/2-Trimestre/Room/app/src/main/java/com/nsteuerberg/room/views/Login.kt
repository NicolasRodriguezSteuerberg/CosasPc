package com.nsteuerberg.room.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.nsteuerberg.room.Data
import com.nsteuerberg.room.R

@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
        ){
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column(modifier = modifier) {
        UserField(Modifier.align(Alignment.CenterHorizontally))
        PasswordField(Modifier.align(Alignment.CenterHorizontally))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(modifier: Modifier) {
    OutlinedTextField(
        value = Data.passwordTxt.value,
        onValueChange = {
            Data.passwordTxt.value = it
        },
        label = {
            Text(text= stringResource(id = R.string.password_txt))
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(modifier: Modifier) {
    OutlinedTextField(
        value = Data.userTxt.value,
        onValueChange = {
            Data.userTxt.value = it
        },
        label = {
            Text(text= stringResource(id = R.string.user_name))
        },
        singleLine = true,
        maxLines = 1,
        modifier = modifier
    )
}
