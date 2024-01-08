<?php
    //Cookies, si no se indica expira a la hora de cerrar el navegador

    //Crear una cookie que no expira
    setcookie("noexpira", 1 );

    //Crear una cookie que caduca a los 2 minutos
    setcookie("micookie", 2, time() + (60*2) );

    //COMPROBAR que la Cookie se ha creado en Chrome en Configuración-Privacidad y Seguridad-Cookies-Ver
    //PONER UN TIEMPO DE 10 SEGUNDOS Y COMPROBAR QUE SE BORRA
    // IMPORTANTE

    // muestra el contenido de la cookie
    var_dump($_COOKIE);
    // _COOKIE es un array asociativo que contiene todas las cookies, se actualiza despues de refrescar la pagina

    // crea una cookie con el nombre idioma y el valor esp
    setcookie("idioma","esp");

    // si existe la cookie idioma y su valor es esp
    if( isset( $_COOKIE['idioma']) && $_COOKIE['idioma'] == "esp" ) {
        // muestra el mensaje
        echo "<p>La cookie noexpira ha sido creada. Web en español</p>";
    }

    // unset elimina una variable, en este caso elimina la cookie noexpira
    unset($_COOKIE['noexpira']);
    // setcookie -1 elimina la cookie noexpira
    // setcookie("noexpira", "", time() - 1 ); // esta linea hace lo mismo que la anterior
    // es mejor usar setcookie -1 porque la otra vuelve al refrescar la pagina
    // muestra el contenido de la cookie
    var_dump($_COOKIE);
?>