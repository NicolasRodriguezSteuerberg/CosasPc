<?php
/**
 * @package Cambianeitor
 * @version 1.0.0
 */
/*
Plugin Name: cambianeitor
Plugin URI: http://wordpress.org/plugins/cambianeitor/
Description: Plugin que cambia los nombres de los signos por sus respectivos signos por si tu teclado no llega a contener estas funciones
Author: NSteuerberg
Version: 1.0.0
Author URI: http://ma.tt/
*/


# lista de las palabras de los signos
$listaDeshechos = [
    "NH",
    "Nh",
    "AMPERSAND",
    "ARROBA",
    "ASTERISCO",
    "BARRA",
    "PORCIENTO",
    "DOLAR",
    "EURO"
];
$listaQueridos = [
    "Ñ",
    "ñ",
    "&",
    "@",
    "*",
    "/",
    "%",
    "$",
    "€"
];

/**
 * Whenever the word WordPress appears in the content
 * of a post or a page,
 * it will be replaced by WordPressDAM.
 * @param $text string
 * @return string
 */
function cambiar_signos($text){
    // coge las palabras de los signos y los signos de la base de datos
    $words = selectSignos();

    foreach ($words as $result){
        $listaDeshechos[] = $result->deshechos;
        $listaQueridos[] = $result->queridos;
    }
    return str_replace($listaDeshechos, $listaQueridos, $text);
}

add_filter('the_content', 'cambiar_signos');
add_filter('the_title', 'cambiar_signos');



/**
 * To do this but with databases,
 * First, we will create the table
 */
function createTable(){
    global $wpdb; // this is how you get access to the database
    $table_name = $wpdb->prefix . "cambianeitor";
    //Charset de la tabla
    $charset_collate = $wpdb->get_charset_collate();
    //Sentencia SQL
    $sql = "CREATE TABLE IF NOT EXISTS $table_name (
        id mediumint(9) NOT NULL AUTO_INCREMENT,
        deshechos varchar(255) NOT NULL,
        queridos varchar(255) NOT NULL,
        PRIMARY KEY  (id)
    ) $charset_collate;";
    //Incluir el fichero para poder ejecutar dbDelta
    require_once( ABSPATH . 'wp-admin/includes/upgrade.php' );
    dbDelta( $sql );
}
// when the plugin is activated, we create the table
add_action("plugins_loaded", "createTable");

// now we insert the words into the table
function insertData(){
    global $wpdb, $listaDeshechos, $listaQueridos;
    $table_name = $wpdb->prefix . "cambianeitor";
    $flag = $wpdb->get_results("SELECT * FROM $table_name");
    if (count($flag)==0){
        for ($i = 0; $i < count($listaDeshechos); $i++){
            $wpdb->insert(
                $table_name,
                array(
                    'deshechos' => $listaDeshechos[$i],
                    'queridos' => $listaQueridos[$i]
                )
            );
        }
    }
}
// when the plugin is activated, we insert the words
add_action("plugins_loaded", "insertData");

// selecting the words from the database
function selectSignos(){
    global $wpdb;
    $table_name = $wpdb->prefix . 'cambianeitor';
    $results = $wpdb->get_results( "SELECT * FROM $table_name" );
    return $results;
}