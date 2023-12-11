<?php
/**
 * @package Nico Words
 * @version 0.0.1
 */
/*
Plugin Name: Nico Words
Plugin URI: http://wordpress.org/plugins/nico-words/
Description: This plugin is a test for the WordPress plugin development course.
Author: NSteuerberg
Version: 0.0.1
Author URI: http://ma.tt/
*/


# list of offensive words
$offensiveWordsList = [
    "mierda",
    "puta",
    "puto",
    "coño",
    " polla ",
    "gilipollas",
    "cabron",
    "cabrona",
    "joder"
];
$nonOffensiveWordsList = [
    "caca",
    "fruta",
    "fruto",
    "vagina",
    " pito ",
    "estolido",
    "cabro",
    "cabra",
    "recorcholis"
];

/**
 * Whenever the word WordPress appears in the content
 * of a post or a page,
 * it will be replaced by WordPressDAM.
 * @param $text string
 * @return string

function renym_wordpress_typo_fix( $text ) {
    global $offensiveWordsList, $nonOffensiveWordsList;
    return str_replace( $offensiveWordsList, $nonOffensiveWordsList, $text );
}
*/

/**
 * Whenever the word WordPress appears in the content
 * of a post or a page,
 * it will be replaced by WordPressDAM.
 * This time using the database
 * @param $text string
 * @return string
 */
function renym_wordpress_typo_fix($text){
    // take the words from the table
    $words = selectData();
    foreach ($words as $result){
        $offensiveWordsList[] = $result->offensiveWords; // -> para seleccionar que columna escoger
        $nonOffensiveWordsList[] = $result->nonOffensiveWords;
    }
    return str_replace($offensiveWordsList, $nonOffensiveWordsList, $text);
}


add_filter('the_content', 'renym_wordpress_typo_fix');
/*
function nico_words_get_lyric() {
    /** These are the lyrics to Nico Words
    global $wordsList;
    $lyrics = $wordsList[rand(0, count($wordsList) - 1)];

    return wptexturize( $lyrics );
}
*/

/**
 * To do this but with databases,
 * First, we will create the table
 */
function createTable(){
    global $wpdb; // this is how you get access to the database
    $table_name = $wpdb->prefix . "nicoWords";
    //Charset de la tabla
    $charset_collate = $wpdb->get_charset_collate();
    //Sentencia SQL
    $sql = "CREATE TABLE IF NOT EXISTS $table_name (
        id mediumint(9) NOT NULL AUTO_INCREMENT,
        offensiveWords varchar(255) NOT NULL,
        nonOffensiveWords varchar(255) NOT NULL,
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
    global $wpdb, $offensiveWordsList, $nonOffensiveWordsList;
    $table_name = $wpdb->prefix . "nicoWords";
    $flag = $wpdb->get_results("SELECT * FROM $table_name");
    if (count($flag)==0){
        for ($i = 0; $i < count($offensiveWordsList); $i++){
            $wpdb->insert(
                $table_name,
                array(
                    'offensiveWords' => $offensiveWordsList[$i],
                    'nonOffensiveWords' => $nonOffensiveWordsList[$i]
                )
            );
        }
    }
}
// when the plugin is activated, we insert the words
add_action("plugins_loaded", "insertData");

// selecting the words from the database
function selectData(){
    global $wpdb;
    $table_name = $wpdb->prefix . 'nicoWords';
    $results = $wpdb->get_results( "SELECT * FROM $table_name" );
    return $results;
}