<?
require 'konek.php';
$server_ip = gethostbyname(gethostname());
$target_path = "/server_lomba/uplod/";
$response = array();
$file_upload_url = 'http://' . $server_ip . '/' . $target_path;
if (
    isset($_POST['send_judul_wisata']) 
    && isset($_POST['send_isi_wisata']) 
    && isset($_FILES['send_gambar_wisata'])
    && isset($_POST['send_id_kategori_wisata'])
    && isset($_POST['send_id_kota_kabupaten'])
    
    ) {
    // && isset($_POST['send_id_popular'])
    $title_blog = $_POST['send_judul_wisata'];
    $content_blog = $_POST['send_isi_wisata'];
    $id_kategori_wisata = $_POST['send_id_kategori_wisata'];
    $id_kota_kabupaten = $_POST['send_id_kota_kabupaten'];
    // $id_popular = $_POST['send_id_popular'];

$target_file = "http://" . $server_ip . "/" . $target_path . basename($_FILES['send_gambar_wisata']['name']);
    $imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
    $check = getimagesize($_FILES['send_gambar_wisata']['tmp_name']);
    $mime = $check['mime'];
    $uploadOk = 0;

    if($check !== false) {
        $uploadOk = 1;
    } elseif($check === true) {
        $response['message'] =  "File is not an image.";
        $response['success'] = 0;
        $uploadOk = 0;
    } elseif (file_exists($target_file)) {
        // Check if file already exists
        $response['message'] = "Sorry, file already exists.";
        $response['success'] = 0;
        $uploadOk = 0;
    } elseif ($_FILES['send_gambar_wisata']['size'] > 5000000) {
        // Check file size lessthan 5Mb
        $response['message'] =  "Sorry, your file is too large.";
        $response['success'] = 0;
        $uploadOk = 0;
    } elseif ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif") {
        // Allow certain file formats
        $response['message'] = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
        $response['success'] = 0;
        $uploadOk = 0;
    }

    if ($uploadOk != 0) {
        $target_path = "/var/www" . $target_path . basename($_FILES['send_gambar_wisata']['name']);
        try {
            move_uploaded_file($_FILES['send_gambar_wisata']['tmp_name'], $target_path);
            //file_put_contents($path,base64_decode($image))
            $response['success'] = 1;
            $response['mime'] = $mime;
            $file_path = $file_upload_url . basename($_FILES['send_gambar_wisata']['name']);
            $fileName = basename($_FILES['send_gambar_wisata']['name']);
            $id_image= 0;
            $queryInsertNewImage = 
                "INSERT INTO tb_gambar(
                nama_gambar, 
                url_gambar
                ) VALUES (
                '$fileName',
                '$file_path'
                )";
            if ($konek->query($queryInsertNewImage) === TRUE) {
                $response['success'] =  1;
                $response['message'] = "The file ". basename( $_FILES['send_gambar_wisata']['name']). " has been uploaded.";

                $querygetIdImage = 
                "SELECT id_gambar FROM tb_gambar WHERE nama_gambar='$fileName'";
                $selectIdImage = $konek->query($querygetIdImage);

                if ($selectIdImage->num_rows > 0) {
                    $rowIdImage = $selectIdImage->fetch_assoc();
                    $id_image = $rowIdImage['id_gambar'];

                    $queryInsertNewArticel = 
                    "INSERT INTO tb_wisata(
                    judul_wisata, 
                    isi_wisata, 
                    gambar_wisata,
                    id_kategori_wisata,
                    id_kota_kabupaten
                    
                    ) VALUES (
                    '$title_blog',
                    '$content_blog',
                    '$id_image',
                    '$id_kategori_wisata',
                    '$id_kota_kabupaten'
                    )";

                    if ($konek->query($queryInsertNewArticel) === TRUE) {
                        $InsertNewArticel['success'] =  1;
                        $InsertNewArticel['message'] =  "New record created successfully";
                    }
                }
            } else {
                $response['success'] =  0;
                $response['message'] =  "error: " . $queryInsertNewImage . "<br>" . $konek->success;
            }
        } catch (Exception $e) {
            // Exception occurred. Make success flag true
            $response['success'] = 0;
            $response['message'] = $e->getMessage();
        }
    } else {
        $response['message'] =  "File is not an image.";
        $response['success'] = 0;
        $uploadOk = 0;
    }

    $result['result'] = $response;
    echo json_encode($result);
}