<?php
require 'konek.php';

$querySelectTitleArticel = "SELECT 
tb_konten.id_konten, 
tb_konten.judul_konten, 
tb_gambar.url_gambar,
tb_kategori.id_kategori
FROM tb_konten
JOIN tb_gambar
ON
tb_konten.gambar_konten=tb_gambar.id_gambar
JOIN tb_kategori
ON tb_konten.id_kategori=tb_kategori.id_kategori
WHERE tb_konten.id_kategori=". $_GET["id_kategori"];

$selectTitleArticel = $konek->query($querySelectTitleArticel);

if ($selectTitleArticel->num_rows > 0) {
	
	$arrayTitleArticel = array('hasil' => array());
	while ($rowTitleArticel = $selectTitleArticel->fetch_assoc()) {
		array_push($arrayTitleArticel['hasil'], $rowTitleArticel);
	}
echo json_encode($arrayTitleArticel);
	
}

?>
