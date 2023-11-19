<?php
    // cogemos la variable nombre del formulario
    $minombre = $_GET["nombre"];

    // creo las variables de conexión a MySQL
    $servidor = "localhost";
    $usuario = "root";
    $pass = "";

    // establecer la conexión con MySQL
    $conexion = mysqli_connect($servidor,$usuario,$pass) or die("Error de conexión"); // si no se puede conectar, muestra el mensaje de error

    // seleccionamos la Base de Datos
    mysqli_select_db($conexion,"usuarios");

    // creamos la sentencia SQL de inserción
    $insertar = "INSERT clientes (nombre) VALUES ('$minombre')";

    // ejecutar la sentencia SQL
    mysqli_query($conexion,$insertar);
?>