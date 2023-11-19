<?php
    $edad = 22;
    $nota = 7.34;

    // Funciones matematicas
    if (is_int($edad)){
        echo "Edad es un entero";
    }
    echo "<p> </p>";

    if(is_int($nota)){
        echo "nota es un entero";
    } elseif (is_float($nota)){
        echo "Nota es un float";
    }

    echo "<p> </p>";

    // Notacion inglesa por defecto
    echo number_format("1000000")."<br>";

    // Dos decimales
    echo number_format("1000000", 2)."<br>";

    // Definir la , oara decunakes y el . para los millares
    echo number_format("1000000", 2, ",", ".");
?>