<?php
    // array de la manera larga
    $dias = array("Lunes", "Martes", "Miercoles", "Jueves", "Viernes");
    // array de la manera corta
    $temperaturas = [20, 21, 22, 23, 24];
    // array con 15 espacios vacios
    $empty = array(15);
    // array vacia
    $empty2 = array();

    // array asociativo
    $usuario = [
        "nombre" => "Nico",
        "edad" => 20,
        "alumno" => true
    ];

    $datos = [
        "nombre" => "Nico",
        2 => 20,
        "alumno" => true
    ];

    echo "$dias[1]";
    echo "<br>";

    // var_dump te muestra el tipo de variable y su contenido
    var_dump($dias);
    echo "<br>";


    // funciones array
    $arrayN1 = array(3, 5, 4, 1, 2);
    $arrayN2 = array(1,3,5,7,9);
    $arrayColores1 = array(
        "color1" => "rojo",
        "color2" => "verde",
        "color3" => "azul",
        "color4" => "naranja"
    );
    $arrayColores2 = array(
        "color1" => "verde",
        "color2" => "azul",
        "color3" => "amarillo",
        "color4" => "morado"
    );
    // array_diff -> devuelve los elementos del primer array que no esten en los otros
    $diferencias_numeros = array_diff($arrayN1, $arrayN2);
    var_dump($diferencias_numeros);
    echo "<br>";
    $diferencias_colores = array_diff($arrayColores1, $arrayColores2);
    var_dump($diferencias_colores);
    echo "<br>";

    // array_merge -> une arrays, da igual si se repiten los valores
    $array_merge = array_merge($arrayN1, $arrayN2);
    var_dump($array_merge);
    echo "<br>";

    // ordenar arrays
    // sort -> ordena arrays de menor a mayor (con arrays asociativos)
    sort($arrayN1);
    var_dump($arrayN1);
    echo "<br>";

    // asort -> ordena arrays asociativos de menor a mayor (los valores)
    var_dump($arrayColores1);
    echo "<br>";
    asort($arrayColores1);
    var_dump($arrayColores1);
    echo "<br>";

    // si usas asort con arrays normales, te los ordena pero te cambia las claves, mantiene las originales de los valores

    // ksort -> ordena arrays asociativos por la clave
    $array_nombres = array(
        "Javier" => 22,
        "Nico" => 20,
        "Juan" => 21
    );
    var_dump($array_nombres);
    echo "<br>";
    ksort($array_nombres);
    var_dump($array_nombres);
    echo "<br>";

    // suffle -> desordena arrays aleatoriamente (funciona con ambos tipos de arrays)
    // con array asociativos cambia las claves, poniendo posiciones normales de un array
    shuffle($array_nombres);
    var_dump($array_nombres);
    echo "<br>";

    // array_shift -> elimina el primer elemento de un array y lo devuelve
    $primer_elemento = array_shift($array_nombres);
    var_dump($array_nombres);
    echo "<br>$primer_elemento<br>";

    // array_unshift -> añade un elemento al principio de un array, devuelve el numero de elementos del array
    array_unshift($array_nombres, $primer_elemento);
    var_dump($array_nombres);
    echo "<br>";

    // array_pop -> elimina el ultimo elemento de un array y lo devuelve
    $ultimo_elemento = array_pop($array_nombres);
    var_dump($array_nombres);
    echo "<br>$ultimo_elemento<br>";

    // array_push -> añade un elemento al final de un array, devuelve el numero de elementos del array
    array_push($array_nombres, $ultimo_elemento);
    var_dump($array_nombres);

    // count -> devuelve el numero de elementos de un array
    echo "<br>" . count($array_nombres) . "<br>";

    //end -> mueve el puntero al ultimo elemento del array, devuelve el ultimo elemento
    end($array_nombres);

    //current -> devuelve el elemento actual del array
    $actual = current($array_nombres);
    echo "$actual<br>";

    // reset -> resetea el puntero del array al primer elemento, devuelve el primer elemento(el actual),array_shift y array_pop hacen un reset despues de su ejecucion
    reset($array_nombres);
    $actual = current($array_nombres);
    echo "$actual<br>";

    // array_search -> busca un elemento en un array y devuelve su clave, si no lo encuentra devuelve false
    $clave = array_search(22, $array_nombres);
    if ($clave){
        echo "La clave es " .$clave . ", el elemento es: " . $array_nombres[$clave] . "<br>";
    } else {
        echo "No se ha encontrado el elemento<br>";
    }
?>