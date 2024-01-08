<?php
    // operandores aritmeticos
    $a = 5;
    $b = 2;
    echo $a + $b;
    echo "<br>";
    echo $a - $b;
    echo "<br>";
    echo $a * $b;
    echo "<br>";
    echo $a / $b;
    echo "<br>";
    echo $a % $b;
    echo "<br>";
    echo $a ** $b;
    echo "<br>";

    // operadores de asignacion
    echo $a += $b;
    echo "<br>";
    echo $a -= $b;
    echo "<br>";
    echo $a *= $b;
    echo "<br>";
    echo $a /= $b;
    echo "<br>";
    echo $a %= $b;
    echo "<br>";
    echo $a **= $b;
    echo "<br>";

    // operadores de comparacion
    echo $a == $b; // puede comparar valores de distinto tipo String y int por ejemplo
    echo "<br>";
    echo $a === $b; // return false o true, valor y tipo identico
    echo "<br>";
    echo $a != $b; // <> es lo mismo
    echo "<br>";
    echo $a !== $b; // return false o true, valor y tipo no identico
    echo "<br>";
    echo $a == $b ? "true" : "false"; // operador ternario --> if else
    echo "<br>";

    // operadores de incremento y decremento
    echo $a++; // primero muestra y luego incrementa
    echo "<br>";
    echo ++$a; // primero incrementa y luego muestra
    echo "<br>";
    echo $a--; // primero muestra y luego decrementa
    echo "<br>";
    echo --$a; // primero decrementa y luego muestra
    echo "<br>";

    // operadores logicos
    echo $a && $b; // and
    echo "<br>";
    echo $a and $b; // and
    echo "<br>";
    echo $a || $b; // or
    echo "<br>";
    echo $a or $b; // or
    echo "<br>";
    echo $a xor $b; // or exclusivo, solo es true si uno es true y el otro false
    echo "<br>";
    echo !$a; // not -> lo contrario de lo que es
    echo "<br>";
?>