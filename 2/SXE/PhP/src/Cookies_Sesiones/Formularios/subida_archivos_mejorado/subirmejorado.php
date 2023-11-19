<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Documento sin título</title>
</head>

<body>
<?php
    $directoriosubida = "uploads/";
    $max_file_size = "51200"; // en bytes
    $extensionesValidas = array("jpg", "jpeg", "gif", "png"); // extensiones válidas

    // si le ha dado al botón de enviar
    // y se ha seleccionado un archivo
    if(isset($_POST["submit"]) && isset($_FILES['imagen'])){
        $errores = 0;

        // obtenemos los datos del archivo
        $nombreArchivo = $_FILES['imagen']['name'];

        // obtenemos el tamaño del archivo
        $filesize = $_FILES['imagen']['size'];

        // obtenemos el nombre temporal del archivo
        $directorioTemp = $_FILES['imagen']['tmp_name'];

        // obtenemos el tipo de archivo
        $tipoArchivo = $_FILES['imagen']['type'];

        // obtenemos un array con mas datos del archivo
        $arrayArchivo = pathinfo($nombreArchivo);
        // obtenemos la extensión del archivo
        $extension = $arrayArchivo['extension'];

        // Comprobamos si la extensión está entre las permitidas
        if(!in_array($extension, $extensionesValidas)){
            echo "La extensión del archivo no es válida";
            $errores = 1;
        }

        // Comprobamos si el tamaño del archivo supera el máximo permitido
        if($filesize > $max_file_size){
            echo "La imagen debe de tener un tamaño inferior a 50 kb";
            $errores = 1;
        }

        // Movemos el archivo si no hay errores
        if($errores == 0){
            // movemos el archivo temporal a la carpeta indicada
            $nombreCompleto = $directoriosubida.$nombreArchivo;
            // movemos el archivo
            move_uploaded_file($directorioTemp, $nombreCompleto);
            echo("El archivo se ha subido correctamente");
        }
    }
?>
</body>
</html>