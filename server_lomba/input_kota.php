<!DOCTYPE html>
<?php 
	include 'konek.php';
 ?>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Upload Kota</title>
</head>
<body>
<form action="proses_input_kota.php" method="post" enctype="multipart/form-data">
	<table class="table" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td width="100">Nama Kota</td>
		<td><input type="text" name="nama" /></td>
	</tr>
	<tr>
		<td width="100">Id Provinsi</td>
		<td><input type="text" name="idprovinsi" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="simpan_kategori" value="Simpan" /></td>
	</tr>
</table>
	
</form>
	  
</body>
</html>