<?php
require("phpsqlinfo_dbinfo.php");


// Gets data from URL parameters.
$uname = $_POST['uname'];
$pwd = $_POST['pwd'];



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

$sql= "select * from user WHERE uname ='$uname' AND pwd ='$pwd'";
$result=mysql_query($sql);
$count=mysql_num_rows($result);
$json = array();

class myObj {
      public $name = "";
      public $email  = "";
   }
    $stat="20";
   $myOb = new myObj();
   
   while($arr = mysql_fetch_assoc($result)){
	// $cat = $arr['body'];

	
	$stat ="10";
	
$myOb->name = $arr['name'];
$myOb->email =$arr ['email'];

 
  } 
   if($stat=="20"){

     $myOb->name = "-1";
     $myOb->email ="-1";
  }
   $jsonstring = json_encode($myOb);
 echo $jsonstring;



?>