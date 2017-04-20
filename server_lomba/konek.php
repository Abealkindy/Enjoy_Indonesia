<?php
error_reporting(E_ALL); ini_set('display_errors', '1');

$servername = "localhost";
$username = "root";
$password = "toor";
$database = "db_lomba";

$konek = new mysqli($servername, $username, $password, $database);

if (mysqli_connect_error()) {
	die("database cannot connect : " . mysqli_connect_error());
}
?>