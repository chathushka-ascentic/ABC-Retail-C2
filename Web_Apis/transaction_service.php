<?php
require("phpsqlinfo_dbinfo.php");

// Gets data from URL parameters.
$json = file_get_contents("php://input");


// Opens a connection to a MySQL server.
$connection=mysql_connect ("localhost", $username, $password);
if (!$connection) {
  die('Not connected : ' . mysql_error());
}

// Sets the active MySQL database.
$db_selected = mysql_select_db($database, $connection);
if (!$db_selected) {
  die ('Can\'t use db : ' . mysql_error());
}

//$trans = array();



$trans = json_decode($json,true);
$uname ="test1";//$trans['user_name'];
$transaction_id = "test1";




foreach($trans['transacton'] as $item) {
    $name= $item['name'];
	$price=$item['price'];
	$quantity= $item['quantity'];
	
	
    $query = sprintf("INSERT INTO transaction " .
         " (uname, name, t_id, price, qty ) " .
         " VALUES ('%s', '%s', '%s', '%s', '%s');",
         mysql_real_escape_string($uname),
         mysql_real_escape_string($name),
         mysql_real_escape_string($transaction_id),
         mysql_real_escape_string($price),
         mysql_real_escape_string($quantity));

$result = mysql_query($query);
class myObj {
  public $result = "";
}
$myOb = new myObj();
$myOb->result="success";
if (!$result) {
  die('Invalid query: ' . mysql_error());
}else{
  $jsonstring = json_encode($myOb);
  echo $jsonstring;
}
    
}






?>