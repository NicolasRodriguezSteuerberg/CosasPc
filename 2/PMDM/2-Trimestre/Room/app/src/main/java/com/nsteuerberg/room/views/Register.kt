package com.nsteuerberg.room.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.nsteuerberg.room.models.Data
import com.nsteuerberg.room.R
import com.nsteuerberg.room.models.User
import com.nsteuerberg.room.viewmodels.UserViewModel

@Composable
fun RegisterScreen(navController: NavController, viewModel: UserViewModel) {
    Box(
        Modifier
            .fillMaxSize()
    ){
        Register(Modifier.align(Alignment.Center), viewModel, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(modifier: Modifier, viewModel: UserViewModel, navController: NavController) {
    Column(modifier = modifier) {
        UserTxt(Modifier.align(Alignment.CenterHorizontally))
        PasswordTxt(Modifier.align(Alignment.CenterHorizontally))
        AcceptButton(Modifier.align(Alignment.End), viewModel, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTxt(modifier: Modifier) {
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

@Composable
fun AcceptButton(modifier: Modifier, viewModel: UserViewModel, navController: NavController) {
    Button(
        onClick = {
            viewModel.addUser(User(Data.userTxt.value, Data.passwordTxt.value))
            navController.navigate("logged")
    }) {
        Text(
            text = "Register"
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UserTxt(align: Modifier) {
    OutlinedTextField(
        value = Data.userTxt.value,
        onValueChange = {
            Data.userTxt.value = it
        },
        label = {
            Text(text = "Nombre")
        }
    )
}
