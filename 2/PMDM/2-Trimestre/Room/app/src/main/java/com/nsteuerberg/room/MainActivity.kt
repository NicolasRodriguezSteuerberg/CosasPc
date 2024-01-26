package com.nsteuerberg.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.nsteuerberg.room.room.UserDao
import com.nsteuerberg.room.room.UserDatabase
import com.nsteuerberg.room.ui.theme.RoomTheme
import com.nsteuerberg.room.viewmodels.UserViewModel
import com.nsteuerberg.room.views.Inicio

class MainActivity : ComponentActivity() {
    private lateinit var db: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    /*
        db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user"
        ).build()
        */
        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // call inicio from iu
                    Inicio()
                }
            }
        }
    }

    // para cerrar la base de datos
    override fun onDestroy() {
        db.close()
        super.onDestroy()
    }
}