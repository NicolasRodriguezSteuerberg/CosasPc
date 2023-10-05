package com.nsteuerberg.primerintento

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsteuerberg.primerintento.ui.theme.PrimerIntentoTheme

class View {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(name: String, modifier: Modifier = Modifier) {
    //var numbers = remember { mutableStateOf(0) }  // esto hace que siempre que cambie el valor de numbers se va a actualizar, remember es como un repintar
    //al ponerle el cero el compilador ya sabe que es un entero
    //var numbers by remember { mutableStateOf(0) } //lo mismo que lo de arriba

    var nameOut = remember { mutableStateOf("") }
    Column {
        Row {
            Text(
                text = "${stringResource(id = R.string.greetings)} $name!",
                modifier = modifier,
                fontSize = 25.sp,
                lineHeight = 90.sp,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }
        Row(modifier = Modifier.padding(0.dp,10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.dino),
                contentDescription = "icono de android",
                modifier = Modifier
                    .padding(30.dp,0.dp)
            )
        }
        Row {
            Text(
                text = "Numeros: ${numbers.value}" // recojo el valor de la variable
            )
        }
        Row (modifier = Modifier.padding(0.dp,10.dp)){
            Button(
                onClick = {
                    random()
                    Log.d(TAG, "Click!!!!!!!!!")
                },
                modifier = Modifier
                    .height(100.dp)
                    .width(230.dp)
                    .padding(30.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            ){
                Image(
                    painter = painterResource(id = R.drawable.chaplin),
                    contentDescription = "Icono boton"
                )
                Text(
                    text = "Click me!", textAlign = TextAlign.Center,
                    color = Color.Cyan
                )
            }
        }
        Row{
            OutlinedTextField(
                value = nameOut.value,
                onValueChange = {
                    nameOut.value = it
                },
                label = { Text(
                    text = "Introduzca un nombre",
                    color = Color.Red
                )
                }
            )
        }
        Row(modifier = Modifier.padding(15.dp,0.dp)){
            if(nameOut.value.length>3){
                Text(
                    text = "Hola: ${nameOut.value}!"
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() { //saludo
    PrimerIntentoTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) { //lo mismo
            InterfazUsuario(NOMBRE)
        }
    }
}