<?php
    $a = 5;
    $b = 2;
    // seleccion de estructuras de control de flujo
    // if ternario
    echo $a == $b ? "true" : "false"; // operador ternario --> if else
    // if
    if ($a > $b) {
        echo "a es mayor que b\n";
    } elseif ($a < $b) {
        echo "a es menor que b\n";
    } else {
        echo "a es igual que b\n";
    }

    // switch
    switch ($a) {
        case 1:
            echo "a es 1\n";
            break;
        case 2:
            echo "a es 2\n";
            break;
        case 3:
            echo "a es 3\n";
            break;
        default:
            echo "a no es ni 1 ni 2 ni 3\n";
            break;
    }

    // estructuras de repeticion
    // for
    for ($i = 0; $i < 10; $i++) { // $i-- $i += 2 $i -= 2...
        echo $i . "\n";
        if ($i == 5) {
            break; // sale del for
        }
    }
    // for each
    $array = array(1 => "Lunes", 2 => "Martes", 3 => "Miercoles");
    $array2 = array("Lunes", "Martes", "Miercoles");
    foreach ($array2 as $value) {
        echo $value . "\n";
    }
    foreach ($array as $key => $value) {
        if ($key == 2) {
            continue; // salta a la siguiente iteracion, no ejecuta lo que hay debajo
        }
        echo $key . "->" . $value . "<br>";
    }

    // while
    $i = 0;
    while ($i < 10) {
        echo $i . "\n";
        $i++;
    }

    // do while
    $i = 0;
    do {
        echo $i . "\n";
        $i++;
    } while ($i < 10);

    // include y require
    // include --> si no encuentra el archivo, sigue ejecutando el codigo
    // require --> si no encuentra el archivo, para la ejecucion del codigo
    // include_once --> si ya se ha incluido el archivo, no lo vuelve a incluir
    // require_once --> si ya se ha requerido el archivo, no lo vuelve a requerir
    echo "Hola desde el control de flujo antes del include<br>";
    include "include2.php";
    include_once "include2.php"; // no se va a mostrar
    require "include2.php";




?>