<?php
    $con = mysqli_connect("mysql.hostinger.in", "u183970127_udk", "9999106014", "u183970127_cycle");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $email = $_POST["email"];
    $statement = mysqli_prepare($con, "INSERT INTO user (name,username,password, email) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssss", $name, $username, $password,  $email);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
