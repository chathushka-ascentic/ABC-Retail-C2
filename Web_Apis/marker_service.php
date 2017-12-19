<?php
require("phpsqlinfo_dbinfo.php");


// Gets data from URL parameters.



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

$sql= "select * from markers";
$result=mysql_query($sql);
$count=mysql_num_rows($result);
$json = array();


   while($arr = mysql_fetch_assoc($result)){
	// $cat = $arr['body'];

$json[]= array(
       'Name' => $arr['name'],
     'Address' => $arr ['address'],
	  'Lat' => $arr['lat'],
	   'Long' => $arr['lng'],
	    'Type' => $arr['type']
    );
 
  } 
  
   $jsonstring = json_encode($json);
 echo $jsonstring;



?>