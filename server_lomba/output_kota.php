<?php
require 'konek.php';

$querySelectTitleArticel = "SELECT 
tb_kota_kabupaten.id_kota_kabupaten, 
tb_kota_kabupaten.nama_kota_kabupaten, 
tb_kota_kabupaten.gambar_kota_kabupaten,
tb_provinsi.id_provinsi
FROM tb_kota_kabupaten
JOIN tb_provinsi
ON tb_kota_kabupaten.id_provinsi=tb_provinsi.id_provinsi
WHERE tb_kota_kabupaten.id_provinsi=". $_GET["id_provinsi"];

$selectTitleArticel = $konek->query($querySelectTitleArticel);

if ($selectTitleArticel->num_rows > 0) {
	
	$arrayTitleArticel = array('hasil' => array());
	while ($rowTitleArticel = $selectTitleArticel->fetch_assoc()) {
		array_push($arrayTitleArticel['hasil'], $rowTitleArticel);
	}
echo json_encode($arrayTitleArticel);
	
}

?>
