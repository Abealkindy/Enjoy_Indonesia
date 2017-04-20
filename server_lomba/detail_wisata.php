<?
require 'konek.php';

if (isset($_GET['send_id_wisata'])) {
	$id_wisata = $_GET['send_id_wisata'];
	$querySelectDetailArticel = "SELECT * FROM tb_wisata JOIN tb_gambar ON tb_wisata.gambar_wisata=tb_gambar.id_gambar WHERE id_wisata='$id_wisata'";

	$selectDetailArticel = $konek->query($querySelectDetailArticel);
	if ($selectDetailArticel->num_rows > 0) {
		$rowDetailArticel['hasil'] = array();
		$rowDetailArticel['hasil'] = $selectDetailArticel->fetch_assoc();
			echo json_encode($rowDetailArticel);
	}
}