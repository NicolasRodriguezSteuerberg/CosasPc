<?php
    $encontrado = FALSE;

    // recogemos el valor del campo de formulario
    $minombre = $_GET["nombre"];

    // creamos las variables de conexión a MySQL
    $host = "localhost";
    $usuario = "root";
    $pass = "";

    // establecemos la conexión con MySQL
    $conexion = mysqli_connect($host,$usuario,$pass) or die("Error de conexión");

    // seleccionamos la Base de Datos
    mysqli_select_db($conexion,"usuarios");

    // creamos la sentencia SQL de consulta
    $consultar = "SELECT nombre FROM clientes";

    // ejecutamos la sentencia SQL
    $registros = mysqli_query($conexion,$consultar);

    // recorremos los resultados y los mostramos por pantalla (solo para comprobar que se recogen todos los datos(aunque no solo el que buscamos))
    // mysqli_fetch_row() devuelve un array con los resultados de la consulta
    while($registro = mysqli_fetch_row($registros)){
        echo "Nombre: ".$registro[0]; // el índice 0 es el nombre
        echo "<p> </p>";
        if($registro[0] == $minombre){
            $encontrado = TRUE;
        }
    }

    if($encontrado){
        echo $minombre . " se encuentra en la base de datos";
    }
    else{
        echo $minombre . " no se encuentra en la base de datos";
    }

?>