
<?php 

require 'konek.php';

$queryambilkategori = "SELECT * FROM tb_kategori_wisata ORDER BY  tb_kategori_wisata.id_kategori_wisata DESC";

$selectKategori = $konek->query($queryambilkategori);
$response = array ();


if ($selectKategori->num_rows > 0) {
	
	$response['tb_kategori_wisata']= array();
	
	while ($row = mysqli_fetch_array($selectKategori)) {
		
		$data= array();
		
	$data['id_kategori_wisata']=$row['id_kategori_wisata'];
	$data['nama_kategori_wisata']=$row['nama_kategori_wisata'];
	$data['gambar_kategori_wisata']=$row['gambar_kategori_wisata'];

		
		array_push($response['tb_kategori_wisata'],$data);
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