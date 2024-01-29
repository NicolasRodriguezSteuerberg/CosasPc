package com.nsteuerberg.room.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nsteuerberg.room.viewmodels.UserViewModel

@Composable
fun LoggedScreen(navController: NavController, viewModel: UserViewModel) {
    Box(
        Modifier
            .fillMaxSize()
    ){
        Logged(Modifier.align(Alignment.Center), viewModel)
    }
}

@Composable
fun Logged(modifier: Modifier, viewModel: UserViewModel) {
    val state = viewModel.state
    Column (modifier = modifier){
        LazyColumn{
            items(state.userlist){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column (
                        modifier = Modifier.padding(12.dp)
                    ){
                        Text(text = it.user_name)
                        Text(text = it.password)
                    }
                }
            }
        }
    }
}
