<?php
    //constantes 2 maneras de hacerlo
    const PI = 3.14;
    echo PI . "\n";
    define("PI2", 3.1416);


    // las variables cogen el tipo de a lo que lo igualas
    $nombre = "Nico";
    $edad = 20;

    $alumno = true;
    echo "Hola " . $nombre . " desde el php\n";
    echo "Hola $nombre desde el php\n";
    // si no pones el json_encode, si fuera true te saldria 1, si no, no saldria nada
    // de esta manera te lo muestra como un objeto (true o false)
    echo json_encode($alumno);
?>