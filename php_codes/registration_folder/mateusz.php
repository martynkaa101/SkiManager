<?php 
$servername="localhost";
$mysql_user="root";
$mysql_pass="";
$dbname="registration";
$conn=mysqli_connect($servername, $mysql_user, $mysql_pass, $dbname);
$instructor="Mateusz";
$flag='t';
if($conn){
echo("connection success! ");
}else{
echo("connection not success ");
 
}
for ($year = 2019; $year <= 2021; $year++) {
    for ($month = 1; $month <= 12; $month++) {
        for ($day = 1; $day <= 31; $day++) {
            for ($hour = 8; $hour <= 19; $hour++) {
                $query="INSERT INTO `instructor_date`() VALUES ('$instructor', '$year', '$month', '$day', '$hour', '$flag')";
                if(mysqli_query($conn, $query)){
echo("registered successfully");
}else{
echo("error in registration");
}
            } 
        } 
    } 
}
?>