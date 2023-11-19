<?php
    // iniciar o recuperar la sesión
    // definir el identificador de la sesión
    session_id("22");
    echo session_id() . "<p></p>";

    // por defecto PHPSESSID
    echo session_name() . "<p></p>";
    session_start();

    // variables de sesión
    // session -> array asociativo
    $_SESSION['iniciada'] = true; // crea la variable iniciada y le asigna el valor true
    $_SESSION['nombre'] = "Luisja"; // crea la variable nombre y le asigna el valor Luisja
    var_dump($_SESSION);
    echo "Nombre: ".$_SESSION['nombre']."<br />";

    // borrar las variables de sesión
    unset($_SESSION['nombre']);

    if (isset($_SESSION['nombre']) == false) {
        echo "Nombre no definido.<br />";
    }

    // destruir la información de la sesión
    session_destroy();
    // no elimina ni variables ni cookies de sesión
    // las sesiones finalizan cuando se cierra el navegador
    echo $_SESSION["iniciada"];