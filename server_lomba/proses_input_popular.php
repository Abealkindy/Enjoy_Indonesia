<?php 
	include 'konek.php';
	if(isset($_POST['simpan_kategori'])){

	$nama = $_POST['nama'];

	// $idprovinsi = $_POST['idprovinsi'];

	$queryInsertKota = "INSERT INTO tb_popular(nama_popular)
	VALUES ('$nama')";
	
		//mulai memproses upload file
			$catat =$konek->query($queryInsertKota);
			if ($catat) {
			
				echo '<p>Data berhasil disimpan</p>';
				echo '<p><a href="upket.php">Kembali</a></p>';
			} else{
				echo '<p>Data gagal disimpan</p>';
				echo '<p><a href="form_upload.php">Kembali</a></p>';
			}
		}
	
 ?>