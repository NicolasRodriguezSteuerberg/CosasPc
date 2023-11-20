<?php
    //Funciones matematicas

    // abs -> valor absoluto
    echo(abs(-6.7) . "<br>");

    // max -> el valor maximo de un conjunto de valores
    echo(max(2,4,6,8,10) . "<br/>");
    
    // min -> valor minimo
    echo(min(2,4,6,8,10) . "<br/>");
    echo "<p> </p>";
    
    // rand -> random
    echo(rand() . "<br/>"); // entre cualquier numero
    echo(rand(10,100). "<br/>"); // entre estos numeros
    echo "<p> </p>";

    // raiz cuadrada
    echo(sqrt(9) . "<br/>");
    echo "<p> </p>";

    // decimal
    echo decbin("3") . "<br/>";
    echo decbin("1587") . "<br/>";
    // hexadecimal
    echo dechex("10") . "<br/>";
    //binario
    echo bindec("1011") . "<br/>";
?>