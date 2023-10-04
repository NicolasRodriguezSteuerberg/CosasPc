package com.nsteuerberg.activetime

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.nsteuerberg.activetime.ui.theme.ActiveTimeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var estado: Boolean = true
var time: Int = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActiveTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(time)
                }
            }
        }
        lifecycleScope.launch {
            timer()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estado", time.toString())
    }

    override fun onResume() {
        super.onResume()
        updateUI()
        time = 0
    }

    fun updateUI(){
        Toast.makeText(this,"Tiempo activo: $time",Toast.LENGTH_SHORT).show()
    }
}

suspend fun timer(){
    while (estado == true){
        delay(1000)
        time += 1
    }
}

@Composable
fun Greeting(time: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Tiempo activo $time!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActiveTimeTheme {
        Greeting(time)
    }
}