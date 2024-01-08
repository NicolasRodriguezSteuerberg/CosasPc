<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Paso de variables</title>
</head>
<body>

    <?php
        // para coger variables dadas por url se usa $_GET
        echo "Nombre " . $_GET['nombre'] . "\n";
        echo "Cargo " . $_GET['cargo'] . "\n";
    ?>
</body>
</html>
