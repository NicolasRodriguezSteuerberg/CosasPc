<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Documento sin título</title>
</head>

<body>
<?php
/*
 * Subida de archivos al servidor
 * fichero php.ini
 *  file_uploads = On -> para habilitar la subida de archivos
 *  upload_tmp_dir = carpeta de destino
 *  upload_max_filesize = tamaño máximo de subida
 */

/*
 * $_FILES
 * name -> nombre del archivo
 * type -> tipo de archivo
 * error -> codigo de error
 * size -> tamaño del archivo
 * tmp_name -> nombre temporal del archivo
 */
    //Subida de archivos al servidor
    // ver el contenido de $_FILES (archivo subido)
    var_dump($_FILES);
    
    //Configuración de php.ini
    $directorio = ini_get("upload_tmp_dir"); // obtiene el directorio de destino
    echo $directorio;

    // 'imagen' es el nombre del campo del formulario
    $directorioTemp = $_FILES['imagen']['tmp_name']; // nombre temporal del archivo
    move_uploaded_file($directorioTemp, $_FILES['imagen']['name']); // mueve el archivo a la carpeta de destino
?>
</body>
</html>