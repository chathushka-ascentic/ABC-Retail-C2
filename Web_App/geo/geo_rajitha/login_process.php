<?php
require("phpsqlinfo_dbinfo.php");


// Gets data from URL parameters.
$uname = $_POST['uname'];
$pwd = $_POST['pwd'];

if($uname=="admin" && $pwd=="admin"){

 header("location: admin_index.html");
}

else{
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
if($count==1){
 $row = mysql_fetch_assoc($result);
 

        header("location: user_index.html");
		//echo "<script language='javascript' type='text/javascript'> location.href='index.html' </script>";   
        return true;
   
}else{
echo "<script>
alert('Wrong Username or Password')
window.location.href='index.html'
</script>";


   // echo "Wrong Username or Password";
	 
    return false;
}
if (!$result) {
  die('Invalid query: ' . mysql_error());
}else{
echo "<script>
alert('Data Saved');
window.location.href='index.html';
</script>";
}
}
?>