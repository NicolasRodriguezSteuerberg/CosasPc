<?php
    // fichero básico de envío de emails -> php.ini
    // Emails
    $to = nicostiwi@gmail.com // Email address of the recipient
    $subject = "email de confirmación";
    $message ="Hola confirma haciendo click en el siguiente enlace";
    $from = "cuentaRandom@dominio.com"; // Email address of the sender
    $headers = "From: $from";

    mail($to,$subject,$message,$headers);
    // esto no funciona porque no tengo un servidor de correo configurado
?>