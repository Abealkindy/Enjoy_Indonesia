<?php 
	include 'konek.php';
	if(isset($_POST['simpan_kategori'])){
	$nama = $_POST['nama'];
	
		//mulai memproses upload file
			$catat =$konek->query('INSERT INTO tb_kategori_wisata(nama_kategori_wisata)
			values ("'.$nama.'")');
			if ($catat) {
			
				echo '<p>Data berhasil disimpan</p>';
				echo '<p><a href="upket.php">Kembali</a></p>';
			} else{
				echo '<p>Data gagal disimpan</p>';
				echo '<p><a href="form_upload.php">Kembali</a></p>';
			}
		}
	
 ?>