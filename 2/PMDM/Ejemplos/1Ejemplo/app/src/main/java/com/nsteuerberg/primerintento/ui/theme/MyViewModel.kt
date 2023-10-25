package com.nsteuerberg.primerintento.ui.theme

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

// creo la data class datos
data class MyData(
    val number: Int,
    val name: String,
    val numList: List<Int>
)

// extiende de ViewModel
class MyViewModel(): ViewModel() {
    // creo una varible mutable de la data class
    private var data = mutableStateOf(MyData(0, "", emptyList()))

    // para hacer logcat
    private val LOG_TAG: String = "Mensaje ViewModel"

    // metodo para iniciar?
    init {
        Log.d(LOG_TAG, "Inicializamos ViewModel")
    }
    /*
    //creanis variables privadas con el "observer" para que si cambian de valor se cambien directamente
    var _numbers = mutableStateOf(0)
    var _nameC = mutableStateOf("")
    val numList = mutableStateListOf<Int>()
*/


    fun getNombre(): String{
        return data.value.name
    }

    // cambia el nombre del data
    fun actualizarNombre(nuevoNombre: String) {
        // esta linea se utiliza para actualizar una propiedad en específico
        //data.value.copy(name = nuevoNombre) crea una copia del objeto data cambiando solo el nombre
        data.value = data.value.copy(name = nuevoNombre)
    }

    fun crearRandom(){
        // que nos cambie el valor de numbers aleatoriamente y lo sacamos por el log
        data.value = data.value.copy(number = (0..10).random())
        Log.d(LOG_TAG, "creamos random ${data.value.number}")
    }
    fun crearListaRandom(){
        // creo una copia de la lista añadiendole otro valor y actualizo el objeto data
        data.value = data.value.copy(numList = data.value.numList + ((0..3).random()))
        Log.d(LOG_TAG, "creamos random ${data.value.numList.get(data.value.numList.size-1)}")
    }
    // metodo que returna el valor de numbers
    fun getNumero(): Int{
        return data.value.number
    }
    fun getLista():List<Int>{
        return data.value.numList
    }
}