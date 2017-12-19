<?php
require("phpsqlinfo_dbinfo.php");

if ($_POST['re_pwd']!= $_POST['pwd'])
 {
    echo "<script>
alert('error');
window.location.href='index.html';
</script>";
 }else{
// Gets data from URL parameters.
$name = $_POST['user_name'];
$uname = $_POST['uname'];
$contact = $_POST['contact'];
$email = $_POST['email'];
$re_pwd = $_POST['re_pwd'];
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

// Inserts new row with place data.
$query = sprintf("INSERT INTO user " .
         " (name, uname, contact, email, pwd ) " .
         " VALUES ('%s', '%s', '%s', '%s', '%s');",
         mysql_real_escape_string($name),
         mysql_real_escape_string($uname),
         mysql_real_escape_string($contact),
         mysql_real_escape_string($email),
         mysql_real_escape_string($pwd));

$result = mysql_query($query);

if (!$result) {
  die('Invalid query: ' . mysql_error());
}else{
  $jsonstring = json_encode("success");
  echo $jsonstring;
}
}
?>