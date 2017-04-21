-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 18, 2017 at 01:10 PM
-- Server version: 5.5.38
-- PHP Version: 5.4.4-14+deb7u14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_lomba`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_gambar`
--

CREATE TABLE IF NOT EXISTS `tb_gambar` (
  `id_gambar` int(4) NOT NULL AUTO_INCREMENT,
  `nama_gambar` varchar(255) NOT NULL,
  `url_gambar` varchar(255) NOT NULL,
  PRIMARY KEY (`id_gambar`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `tb_gambar`
--

INSERT INTO `tb_gambar` (`id_gambar`, `nama_gambar`, `url_gambar`) VALUES
(1, '1-ZNV6AHuVveFjTtBOSXgjRg.png', 'http://192.168.100.15/server_lomba/uplod/1-ZNV6AHuVveFjTtBOSXgjRg.png'),
(7, 'unnamed.jpg', 'http://192.168.100.15//server_lomba/uplod/unnamed.jpg'),
(8, '1483268699516.jpg', 'http://192.168.100.15//server_lomba/uplod/1483268699516.jpg'),
(9, '1483268699516.jpg', 'http://192.168.100.15//server_lomba/uplod/1483268699516.jpg'),
(10, '1483268699516.jpg', 'http://192.168.100.15//server_lomba/uplod/1483268699516.jpg'),
(11, '1483268699516.jpg', 'http://192.168.100.15//server_lomba/uplod/1483268699516.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori_wisata`
--

CREATE TABLE IF NOT EXISTS `tb_kategori_wisata` (
  `id_kategori_wisata` int(2) NOT NULL AUTO_INCREMENT,
  `nama_kategori_wisata` varchar(255) NOT NULL,
  `gambar_kategori_wisata` varchar(255) NOT NULL,
  PRIMARY KEY (`id_kategori_wisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tb_kategori_wisata`
--

INSERT INTO `tb_kategori_wisata` (`id_kategori_wisata`, `nama_kategori_wisata`, `gambar_kategori_wisata`) VALUES
(1, 'Pantai', 'pantai.png'),
(2, 'Air Terjun', 'airterjun.png');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kota_kabupaten`
--

CREATE TABLE IF NOT EXISTS `tb_kota_kabupaten` (
  `id_kota_kabupaten` int(4) NOT NULL AUTO_INCREMENT,
  `id_provinsi` int(2) NOT NULL,
  `nama_kota_kabupaten` varchar(255) NOT NULL,
  `gambar_kota_kabupaten` varchar(255) NOT NULL,
  PRIMARY KEY (`id_kota_kabupaten`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tb_kota_kabupaten`
--

INSERT INTO `tb_kota_kabupaten` (`id_kota_kabupaten`, `id_provinsi`, `nama_kota_kabupaten`, `gambar_kota_kabupaten`) VALUES
(1, 1, 'Kota Bandung', 'kotabandung3.png'),
(2, 2, 'Kota Semarang', 'kotasemarang.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tb_popular`
--

CREATE TABLE IF NOT EXISTS `tb_popular` (
  `id_popular` int(1) NOT NULL AUTO_INCREMENT,
  `nama_popular` varchar(255) NOT NULL,
  PRIMARY KEY (`id_popular`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tb_popular`
--

INSERT INTO `tb_popular` (`id_popular`, `nama_popular`) VALUES
(1, 'Popular'),
(2, 'Bukan Populer');

-- --------------------------------------------------------

--
-- Table structure for table `tb_provinsi`
--

CREATE TABLE IF NOT EXISTS `tb_provinsi` (
  `id_provinsi` int(2) NOT NULL AUTO_INCREMENT,
  `nama_provinsi` varchar(255) NOT NULL,
  `gambar_provinsi` varchar(255) NOT NULL,
  PRIMARY KEY (`id_provinsi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tb_provinsi`
--

INSERT INTO `tb_provinsi` (`id_provinsi`, `nama_provinsi`, `gambar_provinsi`) VALUES
(1, 'Jawa Barat', 'jawabarat.png'),
(2, 'Jawa Tengah', 'jawatengah.png');

-- --------------------------------------------------------

--
-- Table structure for table `tb_wisata`
--

CREATE TABLE IF NOT EXISTS `tb_wisata` (
  `id_kota_kabupaten` int(4) NOT NULL,
  `popular_wisata` int(10) NOT NULL DEFAULT '0',
  `id_wisata` int(5) NOT NULL AUTO_INCREMENT,
  `id_kategori_wisata` int(2) NOT NULL,
  `judul_wisata` varchar(255) NOT NULL,
  `isi_wisata` longtext NOT NULL,
  `gambar_wisata` varchar(255) NOT NULL,
  PRIMARY KEY (`id_wisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `tb_wisata`
--

INSERT INTO `tb_wisata` (`id_kota_kabupaten`, `popular_wisata`, `id_wisata`, `id_kategori_wisata`, `judul_wisata`, `isi_wisata`, `gambar_wisata`) VALUES
(1, 101, 1, 1, 'Pantai Parangritis', '<p>ahgfhrhejrfubfjfbewa faef huwejfbejfb eJFBWE jffbjbhabahbghr g</p>\r\n', '1'),
(2, 300, 7, 1, 'Pantai Koek', '<p>dbawvhavfhevfves</p>\r\n', '7'),
(1, 200, 9, 2, 'Curug Bidadari Ngangkang', '<p>ygeqhwvhwefwehtvuwq4 thuw vtuwqhtvuabhwq uwuhgwhjwbtjwb</p>\r\n', '8');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
