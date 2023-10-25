@file:OptIn(ExperimentalMaterial3Api::class)

package com.nsteuerberg.primerintento.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsteuerberg.primerintento.R

@Composable
 fun InterfazUsuario(miViewModel: MyViewModel, name: String, modifier: Modifier = Modifier) {
    //var numbers = remember { mutableStateOf(0) }  // esto hace que siempre que cambie el valor de numbers se va a actualizar, remember es como un repintar
    //al ponerle el cero el compilador ya sabe que es un entero
    //var numbers by remember { mutableStateOf(0) } //lo mismo que lo de arriba

    var greetings = stringResource(R.string.greetings)

    Column {
        // están separado por filas
        //fInicio(greetings = greetings, name = name, modifier = modifier)

        //fButton(miViewModel = miViewModel)

        //fTextoRellenar(miViewModel = miViewModel)
        ronda(miViewModel)
        botonesSimon()
        startSumaRonda(miViewModel)
    }
}

@Composable
fun ronda(miViewModel: MyViewModel){
    Row (modifier = Modifier.padding(300.dp,0.dp,0.dp,0.dp)){
        Text(
            text = stringResource(id = R.string.round)
        )
    }
    Row (modifier = Modifier
        .padding(315.dp, 0.dp, 0.dp, 0.dp)
        .height(25.dp)
        ){
        Text(
            text = "${miViewModel.getRound()}",
            fontSize = miViewModel.getTamanhoLetra().sp
        )
    }
}


@Composable
fun botonesSimon(){
    Row (modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp)){
        columnButtonSimon(color = Color.Cyan)
        columnButtonSimon(color = Color.Green)
    }
    Row (){
        columnButtonSimon(color = Color.Red)
        columnButtonSimon(color = Color.Yellow)
    }
}

@Composable
fun columnButtonSimon(color: Color){
    Column {
        Button(onClick = {
            /*TODO*/
        },
            shape = RectangleShape,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(50.dp, 50.dp)
            ,
            colors = ButtonDefaults.buttonColors(color)
        ){

        }
    }
}

@Composable
fun startSumaRonda(miViewModel: MyViewModel){
    Row {
        Column {
            Button(
                onClick = {
                    miViewModel.changeEstado()
                },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .padding(50.dp, 50.dp)
            ){
                Text(
                    text = miViewModel.getEstadoRonda(), textAlign = TextAlign.Center
                )
            }
        }
        Column {
            Button(
                onClick = {
                    miViewModel.elevateRound()
                },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .padding(50.dp, 50.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.play_arrow),
                    contentDescription = stringResource(id = R.string.descripcionImagen)
                )
            }
        }
    }
}


@Composable
fun fInicio(greetings: String, name: String, modifier: Modifier){
    Row {
        Text(
            text = "$greetings, $name!",
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
                .padding(30.dp, 0.dp)
        )
    }
}
@Composable
fun fButton(miViewModel: MyViewModel){
    Row {
        Text(
            text = "Lista: ${miViewModel.getLista()}"
            //text = "Numeros: ${miViewModel.getNumero()}"
        )
    }
    Row (modifier = Modifier.padding(0.dp,10.dp)) {
        Button(
            onClick = {
                //miViewModel.crearRandom()
                miViewModel.crearListaRandom()
                Log.d("Funciones", "Click!!!!!!!!!")
            },
            modifier = Modifier
                .height(100.dp)
                .width(230.dp)
                .padding(30.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow)
        ) { // es un metodo que puede recibir el boton, al ser el último lo podemos poner fuera de los paréntesis
            Image(
                painter = painterResource(id = R.drawable.dino),
                contentDescription = "Icono boton"
            )
            Text(
                text = "Click me!", textAlign = TextAlign.Center,
                color = Color.Cyan
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fTextoRellenar(miViewModel: MyViewModel){
    Row{
        // campo de texto para rellenar
        OutlinedTextField(
            value = miViewModel.getNombre(),
            onValueChange = {
                // preguntar a gabriel por que se hace esto, ¿Esto no es privado?
                miViewModel._nameC.value = it //variable string
            },
            label = {
                Text(
                    text = "Introduzca un nombre",
                    color = Color.Red
                )
            }
        )
    }
    Row{
        if(miViewModel.getNombre().length>3){
            Text(
                text = "Hola: ${miViewModel.getNombre()}!"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerIntentoTheme {
        InterfazUsuario(miViewModel = MyViewModel(), "prueba")
    }
}
@Composable
fun chat(){
    TODO("Not yet implemented")
}
@Composable
fun login(){
    //texto y boton para loguear
    texto_descriptivo(texto = "Fallo de login")
}
@Composable
fun texto_descriptivo(texto:String){
    //texto descriptivo
    Text(text = texto)
}
@Composable
fun interfazUsuario(){
    login()
    texto_descriptivo(texto = "Hola texto")
    chat()
}