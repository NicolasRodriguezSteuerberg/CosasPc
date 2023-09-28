package com.nsteuerberg.primerintento

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsteuerberg.primerintento.ui.theme.PrimerIntentoTheme
import com.nsteuerberg.primerintento.ui.theme.PrimerIntentoTheme

val NOMBRE = "mii"
class MainActivity : ComponentActivity() {
    val TAG : String = "Estado" //val=value -> es una constante :)
    //var numero : Int = 3 -> es lo mismo que val, excepto que no es constante -> las variables empiezan todas en mayúsculas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //entorno gráfico -> necesario siempre en el onCreate
        setContent { //recibe una función como parámetros
            PrimerIntentoTheme { //lo mismo que antes
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(255,100,150)) { //lo mismo
                    Saludo(NOMBRE)
                }
            }
        }

        //mensaje de estado (solo lo puedo mirar el Logcat de la terminal de android)
        Log.d(TAG,"Estoy en onCreate")

        calcular(a=1,b=2,
            fun(x:Int, y:Int){
                val suma = x+y
                Log.d("Calcular", suma.toString())
            }
        )

        calcular(4,5,
            fun(x, y){
                val resta = x - y
                Log.d("Calcular", resta.toString())
            }
        )

        calcular2(4,1,
            fun(){
                Log.d("Calcular","No hago nada")
            }
        )

        //Simploficación del anterior
        calcular2(4, 1) { //No hace falta poner el fun()
            Log.d("Calcular", "No hago nada")
        }



        //Simplificación al máximo ya que utiliza los valores por defecto
        calcular2{
            Log.d("Calcular", "No hago nada")
        }
    }
    fun calcular (a: Int = 0, b: Int, operacion: (x:Int, y:Int) -> Unit){
        operacion(a,b)
    }

    fun calcular2 (a:Int = 0, b: Int = 0, operacion:() -> Unit){
        operacion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"He llegado al start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "He llegado al resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"He llegado al pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "He llegado al stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "He llegado al restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "He llegado al destroy")
    }

    fun cambioString(){

    }

    /*
    var suma: Int = fun (a: Int,b: Int){
        a + b
    }
    */
}
@Composable
fun Saludo(name: String, modifier: Modifier = Modifier) {
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
            Text(
                text = "Hola mi $name!",
                modifier = modifier,
                fontSize = 50.sp,
                lineHeight = 100.sp,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }
        Row {
            Button(
                onClick = {Log.d("calcular", "CLick!!!!")},
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            )
            {
                Text(text = "Click me!", textAlign = TextAlign.Center, color = Color.Cyan)

            }
            Image(
                painter = painterResource(id = R.drawable.dino),
                contentDescription = "icono de android"
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() { //saludo
    PrimerIntentoTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) { //lo mismo
            Saludo(NOMBRE)
        }
    }
}
@Composable
fun InterfazUsuario(){
    login()
    texto_descriptivo("Hola texto")
    chat()
}

@Composable
fun login(){
    // texto y boton para loguear
}

@Composable
fun texto_descriptivo(texto: String){
    // texto descriptivo
    Text(text = texto)
}

@Composable
fun chat(){
    // chat
}