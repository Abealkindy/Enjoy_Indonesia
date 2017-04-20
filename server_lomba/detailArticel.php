<?
require 'connectDB.php';

if (isset($_GET['send_id_articel'])) {
	$idArticel = $_GET['send_id_articel'];
	$querySelectDetailArticel = "SELECT * FROM tb_blog JOIN tb_image ON tb_blog.image_blog=tb_image.id_image WHERE id_blog='$idArticel'";

	$selectDetailArticel = $connectDB->query($querySelectDetailArticel);
	if ($selectDetailArticel->num_rows > 0) {
		$rowDetailArticel['hasil'] = array();
		$rowDetailArticel['hasil'] = $selectDetailArticel->fetch_assoc();
			echo json_encode($rowDetailArticel);
	}
}