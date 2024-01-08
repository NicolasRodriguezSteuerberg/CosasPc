<?php
    //MYSQL
    // primero tendremos que hacer conexion con la base de datos
    $servidor = 'localhost:3306';
    $usuario = 'root';
    $password = '';
    $conexion = mysqli_connect($servidor, $usuario, $password);

    // comprobamos la conexion
    if (!$conexion) {
        echo("Falló la conexión:");
    } else{
        // creamos la base de datos
        $sql = "CREATE DATABASE IF NOT EXISTS usuarios";
        // hacemos la consulta, si no hay error, nos dirá que se ha creado correctamente
        if (mysqli_query($conexion, $sql)) {
            echo "Base de datos creada con éxito";
        } else {
            echo "Error: " . mysqli_error($conexion);
        }

        // seleccionamos la base de datos que hemos creado
        mysqli_select_db($conexion,"usuarios");

        // definimos una variable con la consulta
        $sql2 = "CREATE TABLE clientes(nombre VARCHAR(20))";
         // hacemos la consulta, si no hay error, nos dirá que se ha creado correctamente
         if(mysqli_query($conexion, $sql2)){
            echo "Table created successfully";
         } else {
            echo "Table is not created successfully ";
         }
    }