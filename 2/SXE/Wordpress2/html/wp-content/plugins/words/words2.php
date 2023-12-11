<?php
/**
 * @package Conquer_with_Words
 * @version 1.0.0
 */
/*
Plugin Name: Conquer with Words
Plugin URI: http://wordpress.org/plugins/conquer_with_words/
Description: This is not just a plugin, it aims to help you conquer the world with words.
Author: Gabriel Pérez
Version: 1.0.1
Author URI: http://gabriel_dam2/
*/

/*
//Cambiar palabras malsonantes por otras más suaves en el contenido
function renym_wordpress_typo_fix( $text ) {
    global $swearingWords, $nonSwearingWords;
    return str_replace($swearingWords, $nonSwearingWords, $text);
}
 */

$swearingWords= array("Mierda",
    "Coño",
    "Joder",
    "Gilipollas",
    "Cabron",
    "Puta",
    "Puto"
);

$nonSwearingWords= array("Miercoles",
    "Caramba",
    "Jope",
    "Tonto",
    "Cabra",
    "Pumba",
    "Pancho"
);

//Cambiar palabras malsonantes por otras más suaves en el contenido usando la base de datos
function renym_wordpress_typo_fix( $text ) {
    $words = selectData();
    foreach ($words as $result){
        $swearingWords[] = $result->palabrotas;
        $nonSwearingWords[] = $result->eufemismo;
    }
    return str_replace($swearingWords, $nonSwearingWords, $text);
}

add_filter( 'the_content', 'renym_wordpress_typo_fix' );

/*
 * Añadir una tabla a la Base de Datos
 */

function createTable(){
    global $wpdb;
    //Nombre de la tabla
    $table_name = $wpdb->prefix . "words";
    //Charset de la tabla
    $charset_collate = $wpdb->get_charset_collate();
    //Sentencia SQL
    $sql = "CREATE TABLE IF NOT EXISTS $table_name (
        id mediumint(9) NOT NULL AUTO_INCREMENT,
        palabrotas varchar(255) NOT NULL,
        eufemismo varchar(255) NOT NULL,
        PRIMARY KEY  (id)
    ) $charset_collate;";
    //Incluir el fichero para poder ejecutar dbDelta
    require_once( ABSPATH . 'wp-admin/includes/upgrade.php' );
    dbDelta( $sql );
}

add_action("plugins_loaded", "createTable");

/*
 * Insertar datos en la tabla (si ya están añadidos no se añaden)
 */
function insertData(){
    global $wpdb, $swearingWords, $nonSwearingWords;
    $table_name = $wpdb->prefix . "words";
    $flag = $wpdb->get_results("SELECT * FROM $table_name");
    if (count($flag)==0){
        for ($i = 0; $i < count($swearingWords); $i++){
            $wpdb->insert(
                $table_name,
                array(
                    'palabrotas' => $swearingWords[$i],
                    'eufemismo' => $nonSwearingWords[$i]
                )
            );
        }
    }
}

add_action("plugins_loaded", "insertData");

/*
 * Seleccionar datos de la tabla
 */
function selectData(){
    global $wpdb;
    $table_name = $wpdb->prefix . "words";
    $results = $wpdb->get_results("SELECT * FROM $table_name");
    return $results;
}