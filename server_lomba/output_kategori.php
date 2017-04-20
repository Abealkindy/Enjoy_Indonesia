
<?php 

require 'konek.php';

$queryambilkategori = "SELECT * FROM tb_provinsi ORDER BY  tb_provinsi.id_provinsi DESC";

$selectKategori = $konek->query($queryambilkategori);
$response = array ();


if ($selectKategori->num_rows > 0) {
	
	$response['tb_provinsi']= array();
	
	while ($row = mysqli_fetch_array($selectKategori)) {
		
		$data= array();
		
	$data['id_provinsi']=$row['id_provinsi'];
	$data['nama_provinsi']=$row['nama_provinsi'];
	$data['gambar_provinsi']=$row['gambar_provinsi'];

		
		array_push($response['tb_provinsi'],$data);
	}
	//nampilin hasil req dari andro if 1 berhasil
	$response['result']=1;
	$response['msg']="semua data provinsi";
	//jadiin array response jadi json
	echo json_encode($response);
}else{
	$response['result']=0;
$response['msg']="tidak ada data artikel";
echo json_encode($response);
}



 ?>