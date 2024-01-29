package com.nsteuerberg.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.nsteuerberg.room.room.UserDatabase
import com.nsteuerberg.room.ui.theme.RoomTheme
import com.nsteuerberg.room.viewmodels.UserViewModel
import com.nsteuerberg.room.views.Inicio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(
                        this,
                        UserDatabase::class.java,
                        "db_user" // nombre de la base de datos
                    ).build()
                    val dao = database.userDAO()

                    val viewModel = UserViewModel(dao)
                    // call inicio from iu
                    Inicio(viewModel)
                }
            }
        }
    }

    // para cerrar la base de datos
    override fun onDestroy() {
        super.onDestroy()
    }
}