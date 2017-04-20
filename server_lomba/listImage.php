<?php
require 'konek.php';

$queySelectListImage = "SELECT id_gambar, nama_gambar FROM tb_gambar";

$selectListImage = $konek->query($queySelectListImage);

if ($selectListImage->num_rows > 0) {
	$arrayListImage = array('hasil' => array());
	while ($rowTListImage = $selectListImage->fetch_assoc()) {
		array_push($arrayListImage['hasil'], $rowTListImage);
	}

	echo json_encode($arrayListImage);
}
?>