package com.example.testfirebase.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.testfirebase.viewmodel.UserViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.testfirebase.data.data
import com.example.testfirebase.model.User

@Composable
fun UserScreen(
    viewModel: UserViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTexts()
        Buttons(viewModel)
        UserList(viewModel = viewModel, users = data.users.value)
    }
}

// Composable que contiene los botones de añadir y actualizar usuario
@Composable
fun Buttons(viewModel: UserViewModel) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Button(
            onClick = {
                viewModel.addUser(
                    User(data.nombre.value, data.edad.value.toIntOrNull() ?: 0)
                )
            }
        ) {
            Text("Añadir Usuario")
        }

        Button(
            onClick = {
                // Actualizar usuario
                viewModel.updateUser(
                    User(data.nombre.value, data.edad.value.toIntOrNull() ?: 0)
                )
            }, modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Actualizar Usuario")
        }
    }
}

// Composable que contiene los campos de texto para el nombre y la edad
@Composable
fun OutlinedTexts(){
    OutlinedTextField(
        value = data.nombre.value,
        onValueChange = {
            data.nombre.value = it
        },
        label = {
            Text("Nombre")
        },
        modifier = Modifier.padding(16.dp)
    )
    OutlinedTextField(
        value = data.edad.value,
        onValueChange = {
            // Solo coge el valor si es un número
            data.edad.value = it.takeIf {
                    text -> text.all {
                it.isDigit()
            }
            } ?: data.edad.value
        },
        label = {
            Text("Edad")
        },
        modifier = Modifier.padding(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

// Composable que contiene la lista de usuarios
@Composable
fun UserList(viewModel: UserViewModel, users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(users) { user ->
            UserListItem(viewModel = viewModel, user = user)
        }
    }
}

// Composable que contiene un elemento de la lista de usuarios
@Composable
fun UserListItem(viewModel: UserViewModel, user: User) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                // Obtener el id del usuario
                viewModel.getIdUser(user)
                data.nombre.value = user.nombre
                data.edad.value = user.edad.toString()
            })
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nombre: ${user.nombre}")
            Text(text = "Edad: ${user.edad}")
        }
    }
}