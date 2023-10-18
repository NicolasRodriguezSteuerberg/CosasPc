package com.nsteuerberg.primerintento.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// extiende de ViewModel
class MyViewModel(): ViewModel() {
    // para hacer logcat
    private val LOG_TAG: String = "Mensaje ViewModel"

    //creanis variables privadas con el "observer" para que si cambian de valor se cambien directamente
    var _numbers = mutableStateOf(0)
    var _nameC = mutableStateOf("")
    val numList = mutableStateListOf<Int>()

    // metodo para iniciar?
    init {
        Log.d(LOG_TAG, "Inicializamos ViewModel")
    }

    fun getNombre(): String{
        return _nameC.value
    }

    fun crearRandom(){
        // que nos cambie el valor de numbers aleatoriamente y lo sacamos por el log
        _numbers.value = ((0..10).random())
        Log.d(LOG_TAG, "creamos random ${_numbers.value}")
    }

    fun crearListaRandom(){
        numList.add((0..3).random())
        Log.d(LOG_TAG, "creamos random ${numList}")
    }

    // metodo que returna el valor de numbers
    fun getNumero(): Int{
        return _numbers.value
    }

    fun getLista():List<Int>{
        return numList.toList()
    }
}