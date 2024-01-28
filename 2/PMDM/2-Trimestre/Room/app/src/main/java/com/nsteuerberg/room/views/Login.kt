package com.nsteuerberg.room.views

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nsteuerberg.room.models.Data
import com.nsteuerberg.room.R
import com.nsteuerberg.room.viewmodels.UserViewModel


@Composable
fun LoginScreen(navController: NavController, viewModel: UserViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        ){
        Login(Modifier.align(Alignment.Center), viewModel,navController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: UserViewModel, navController: NavController) {
    Column(modifier = modifier) {
        UserField()
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(8.dp))
        LogingButton(Modifier.align(Alignment.CenterHorizontally), viewModel,navController)
        RegisterButton(navController)
    }
}

@Composable
fun LogingButton(modifier: Modifier, viewModel: UserViewModel, navController: NavController) {
    Button(
        onClick = {
            viewModel.loginAuthentication()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = "Logging"
        )
    }

    if (Data.authenticationResult.value != null){
        if(Data.authenticationResult.value == true){
            navController.navigate("logged")
        } else{
            Toast.makeText(LocalContext.current, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            Data.authenticationResult.value = null
        }
    }
}

@Composable
fun RegisterButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("register")
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF4303),
            disabledContainerColor = Color(0xFFF78058),
            contentColor = Color.White,
            disabledContentColor = Color.White,
        )
    ) {
        Text(
            text = "Register"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {
    OutlinedTextField(
        value = Data.passwordTxt.value,
        onValueChange = {
            Data.passwordTxt.value = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            containerColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        label = {
            Text(
                text = stringResource(id = R.string.password_txt)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        visualTransformation = if (Data.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                Data.passwordVisible.value = !Data.passwordVisible.value
            }) {
                Icon(
                        painter = painterResource(id = if (Data.passwordVisible.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off) ,
                        contentDescription = "wisibility icon"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField() {
    OutlinedTextField(
        value = Data.userTxt.value,
        onValueChange = {
            Data.userTxt.value = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(text= stringResource(id = R.string.user_name))
        },
        singleLine = true,
        maxLines = 1
    )
}
