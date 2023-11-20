<?php
    // abrimos el fichero para lectura-escritura y situamos el puntero al final del archivo
    $miarchivo = fopen("archivo.txt", "a+"); // a+ es lectura y escritura, situando el puntero al final del archivo

    // Escritura con fwrite
    fwrite($miarchivo, "Escribiendo en el archivo"); // fwrite -> escribe en un fichero

    // Forzar a escribir los datos pendientes
    fflush($miarchivo); // fflush -> fuerza a escribir los datos pendientes

    // Tamaño del archivo en bytes
    echo filesize("archivo2.txt");
    echo "<br>";

    // Información del archivo
    $arrayinfo = stat("archivo2.txt"); // stat -> devuelve un array con la información del fichero
    var_dump($arrayinfo);
?>