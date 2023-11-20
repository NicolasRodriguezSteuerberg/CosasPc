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

$wordsList = [
    "hola",
    "adios",
    "no se",
    "maburro"
];

/**
 * Whenever the word WordPress appears in the content
 * of a post or a page,
 * it will be replaced by WordPressDAM.
 * @param $text string
 * @return string
 */
function renym_wordpress_typo_fix( $text ) {
    return str_replace( 'WordPress', 'WordPressDAM', $text );
}

add_filter( 'the_content', 'renym_wordpress_typo_fix' );
/*
function nico_words_get_lyric() {
    /** These are the lyrics to Nico Words
    global $wordsList;
    $lyrics = $wordsList[rand(0, count($wordsList) - 1)];

    return wptexturize( $lyrics );
}
*/
