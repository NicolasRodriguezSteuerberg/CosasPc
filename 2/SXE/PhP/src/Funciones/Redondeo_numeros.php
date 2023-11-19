<?php
    // Funciones matematicas
    
    // Redondeso sin parametros
    // redondea para arriba si es 0.5 o mas
    echo(round(0.60) . "<br/>");
    echo(round(0.50) . "<br/>");
    echo(round(0.40) . "<br/>");
    echo(round(-4.45) . "<br/>");
    echo(round(-4.55) . "<br/>");
    echo(round(4.97523, 2) . "<br/>"); // le pone 2 decuimales
    echo "<p> </p>";

    // Por defecto redondeo al valor superior
    // Redondeo al valor superior
    echo(round(1.5, 0, PHP_ROUND_HALF_UP) . "<br>"); // 0 -> numero de decimales
    // Redondeo al valor inferior
    echo(round(1.5, 0, PHP_ROUND_HALF_DOWN) . "<br>");
    // Redondeo al siguiente par
    echo(round(1.5, 0, PHP_ROUND_HALF_EVEN) . "<br>"); // si es impar, redondea al superior

    // Redondeo hacia arriba al siguiente entero
    echo (ceil(0.60) . "<br>"); // 1
    echo (ceil(0.40) . "<br>"); // 1
    echo (ceil(5) . "<br>"); // el unico que no redondea hacia arriba
    echo (ceil(5.1) . "<br>"); // 6

    //Redondeo hacia abajo al siguiente entero
    echo(floor(0.60) . "<br>"); // 0
    echo(floor(0.40) . "<br>"); // 0
    echo(floor(5) . "<br>"); // 5
    echo(floor(5.1) . "<br>"); // 5
    echo(floor(-5.1) . "<br>"); // -6
?>