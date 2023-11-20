<?php
    // Ficheros
    // Abrimos para lectura_escritura
    $miarchivo = fopen("archivo.txt", "r+"); // r+ es lectura y escritura
    if ($miarchivo == false) { // si no se ha podido abrir el archivo
        echo "Error al abrir el archivo";
    } else {
        // Fread -> lectura de un fichero utilizando su tamaño (filesize)
        $contenido = fread($miarchivo, filesize("archivo.txt"));
        echo "<p>El contenido es: <br/> " . $contenido . "</p>";
    }
    echo "<p> </p>";

    // Abrimos en modo w un archivo que no existe y se crea
    $miarchivo2 = fopen("archivo3.txt", "w"); // w es escritura

    // Abrimos en modo w un archivo que existe y se sobreescribe
    $miarchivo3 = fopen("archivo3.txt", "w");

    // Lectura con file_get_contents, devuelve todo el contenido de un fichero en un string
    $todo = file_get_contents("archivo.txt");
    echo "<p>Todo el archivo: <br/> " . $todo . "</p>";
    echo "<p> </p>";

    // Lectura con file, devuelve un array con todas las lineas del fichero
    $arrayarchivo = file("archivo.txt");
    var_dump($arrayarchivo);

    // Lectura con fgets, devuelve una linea del fichero
    rewind($miarchivo); // rewind -> mueve el puntero al principio del fichero
    while (feof($miarchivo) == false) { // feof -> devuelve true si el puntero esta al final del fichero
        echo fgets($miarchivo) . "<br />"; // fgets -> devuelve una linea del fichero
    }
?>