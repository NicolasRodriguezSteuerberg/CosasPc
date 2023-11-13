<?php
    $numero = 22;
    # el nombre del servidor
    echo $_SERVER['SERVER_NAME'] . "\n";
    # software que esta usando el servidor
    echo $_SERVER['SERVER_SOFTWARE'] . "\n";
    # puerto que esta usando el servidor
    echo $_SERVER['SERVER_PORT'] . "\n";
    function prueba() {
        # otra manera de coger variables globales
        echo "La variable numero vale " . $GLOBALS['numero'] . "\n";
    }