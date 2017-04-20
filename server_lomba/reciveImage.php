<?php
require 'konek.php';
    class emp{}
    if (!isset($_POST["image"]) || !isset($_POST["name"])) {
        $response = new emp();
        $response->success = 0;
        $response->message = "Please dont empty request."; 
        die(json_encode($response));
    } else {       
    	$image  = $_POST['image'];
	    $name   = $_POST['name'];
	    $server_ip = gethostbyname(gethostname()); 
        $path = "uploads/".$name.".png";
        // sesuiakan ip address laptop/pc atau URL server
        $target_file = "http://$server_ip/$path";
        $urlsavingimage = "/var/www/$path";
        if (file_exists($urlsavingimage)) {
        	$response = new emp();
            $response->message = "Sorry, file already exists.";
        	$response->success = 0;
        } elseif(file_put_contents($urlsavingimage,base64_decode($image))){
        	$queryInsertNewImage = 
                "INSERT INTO tb_gambar(
                nama_gambar, 
                url_gambar
                ) VALUES (
                '$name',
                '$target_file'
                )";
            if ($konek->query($queryInsertNewImage) === TRUE) {
            	$response = new emp();
                $response->success = 1;
            	$response->message = "The file ". $name . " has been uploaded.";
            } else {
            	$response = new emp();
                $response['success'] =  0;
                $response['message'] =  "error: while record to database";
            }
        } else { 
            $response = new emp();
            $response->success = 0;
            $response->message = "Error Upload image";
        }
        echo json_encode($response);
    }   
?>
