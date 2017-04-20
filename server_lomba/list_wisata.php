<?php
require 'konek.php';


	# code...
// if (
// 	isset($_POST['id_popular'])
// 	&& isset($_POST['id_kota_kabupaten'])
// 	&& isset($_POST['id_kategori_wisata'])
// 	) {
	# code...

// $id_kota_kabupaten = $_POST["id_kota_kabupaten"];
// $id_kategori_wisata = $_POST["id_kategori_wisata"];
// $id_popular = $_POST['id_popular'];

  $id_kota_kabupaten = $_GET["id_kota_kabupaten"];
  $id_kategori_wisata = $_GET["id_kategori_wisata"];
// $id_popular = $_GET["id_popular"]; 

$querySelectTitleArticel = "SELECT 
tb_wisata.id_wisata, 
tb_wisata.judul_wisata, 
tb_gambar.url_gambar,
tb_wisata.popular_wisata,
tb_kota_kabupaten.nama_kota_kabupaten,
tb_kategori_wisata.nama_kategori_wisata

FROM tb_wisata
JOIN tb_gambar
ON tb_wisata.gambar_wisata=
tb_gambar.id_gambar
-- JOIN tb_popular
-- ON tb_wisata.id_popular=tb_popular.id_popular
JOIN tb_kota_kabupaten
ON tb_wisata.id_kota_kabupaten=tb_kota_kabupaten.id_kota_kabupaten
JOIN tb_kategori_wisata
ON tb_wisata.id_kategori_wisata=
tb_kategori_wisata.id_kategori_wisata
WHERE tb_wisata.id_kota_kabupaten= '$id_kota_kabupaten' && tb_wisata.id_kategori_wisata= '$id_kategori_wisata' ";
// && tb_wisata.id_popular= '$id_popular'
$selectTitleArticel = $konek->query($querySelectTitleArticel);

if ($selectTitleArticel->num_rows > 0) {
	
	$arrayTitleArticel = array('hasil' => array());
	while ($rowTitleArticel = $selectTitleArticel->fetch_assoc()) {
		array_push($arrayTitleArticel['hasil'], $rowTitleArticel);
	}
echo json_encode($arrayTitleArticel);
	
}

// }
?>
