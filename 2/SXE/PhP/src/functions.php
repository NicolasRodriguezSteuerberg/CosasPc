<?php
    $numero = 22;

    # funcion prueba
    function prueba($numero) {
        # para poder usar la variable de manera global
        # sin esto no podriamos usar la variable $numero en la funcion
        global $numero;
        echo "Hola $numero desde la funcion\n";
    }
