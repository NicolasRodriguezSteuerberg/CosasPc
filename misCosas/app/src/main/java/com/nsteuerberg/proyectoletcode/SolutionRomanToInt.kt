package com.nsteuerberg.proyectoletcode

import android.util.Log

class SolutionRomanToInt {
    fun romanToInt(s: String): Int {
        var result: Int = 0
        var preValue = 0
        val letters = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        for (i in s.length -1 downTo 0){
            val currentValue = letters[s[i]] ?: 0

            if (currentValue < preValue){
                result -= currentValue
            } else{
                result += currentValue
            }

            preValue = currentValue
        }
        return result
    }

    /*
    i -> index, c -> valor
    si el siguiente valor es mayor que el actual lo multiplica con -1
    y todos estos valores los suma
    s.getOrNull -> si no existe ese valor por que se salga de los limites
    
    fun romanToInt(s: String) = s.mapIndexed { i, c ->
        c.roman * if ((s.getOrNull(i + 1)?.roman ?: 0) <= c.roman) 1 else -1
    }.sum()
    private val Char.roman
        get() = when (this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }

     */

}