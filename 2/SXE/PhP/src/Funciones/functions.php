<?php
    $numero = 22;

    # funcion prueba
    function prueba($numero) {
        # para poder usar la variable de manera global
        # sin esto no podriamos usar la variable $numero en la funcion
        global $numero;
        echo "Hola $numero desde la funcion<br>";
    }

    // funcion con return
    function suma($a, $b) {
        return $a + $b;
    }

    // llamada a la funcion suma
    $resultado = suma(2, 3);
    echo $resultado . "<br>";


    // funciones parámetros
    // por valor -> no se modifica el valor de la variable
    // por referencia -> se modifica el valor de la variable

    // funcion por valor
    function incrementa($valor) {
        $valor++;
        echo "incrementa por valor " . $valor . "<br>";
    }

    // funcion por referencia
    function incrementaReferencia(&$valor) { // & -> por referencia
        $valor++;
        echo "incrementa Referencia " . $valor . "<br>";
    }

    // llamada a las funciones
    $valor = 5;
    incrementa($valor);
    echo "Despues de incrementa valor " . $valor . "<br>";
    incrementaReferencia($valor);
    echo "Despues de incrementa Referencia " . $valor . "<br>";

    // funciones recursivas
    function factorial($numero) {
        if ($numero > 1) {
            echo $numero . " x ";
            return $numero * factorial($numero - 1);
        }else{
            echo $numero . " = ";
            return 1;
        }
    }
    $resultado = factorial(5);
    echo $resultado . "<br>";

    // conseguir la fecha y hora actual (del servidor)
    // date -> devuelve la fecha y hora actual con el formato que le indiques
    // buscar en php.net para ver los formatos
    echo date("Y") . "<br>"; // año
    echo date("d m Y") . "<br>"; // dia mes año --> m minuscula es el mes en numero
    echo date("d/M/Y") . "<br>"; // dia/mes/año --> M mayuscula es el mes en letras
    echo date("d/M/Y h:i:s") . "<br>"; // dia/mes/año hora:minutos:segundos
    echo date("H:i:s") . "<br>"; // hora:minutos:segundos
    echo date("l js \of F Y h:i:s A") . "<br>"; // dia de la semana dia del mes, el mes, el año hora:minutos:segundos AM/PM

    // getdate -> devuelve un array asociativo con la fecha y hora actual
    $fecha = getdate();
    echo "<br>getdate: <br>";
    foreach ($fecha as $clave => $valor) {
        echo "$clave -> $valor <br>";
    }
    echo "<br>Mes: " . $fecha['month'] . "<br>";

    // date_default_timezone_get -> devuelve la zona horaria del servidor
    // date_default_timezone_set -> establece la zona horaria del servidor

    echo "Zona horaria: " . date_default_timezone_get() . "<br>";
    date_default_timezone_set("America/Argentina/Buenos_Aires");
    echo "Zona horaria: " . date_default_timezone_get() . "<br>";

?>