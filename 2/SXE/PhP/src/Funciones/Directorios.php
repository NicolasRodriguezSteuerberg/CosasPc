<?php
    // Directorios

    // Mostrar directorio actual
    echo getcwd();

    // Mostrar contenido de un directorio
    $directorio = scandir(getcwd()); // scandir -> devuelve un array con el contenido del directorio
    var_dump($directorio);

    // Cambiar de directorio
    chdir('../'); // chdir funciona como en linux, ../ es el directorio padre
    echo getcwd();

?>