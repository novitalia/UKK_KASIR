-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2024 at 10:14 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir_restoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang1`
--

CREATE TABLE `barang1` (
  `kode_barang` varchar(15) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `id_kategori` varchar(15) NOT NULL,
  `id_satuan` varchar(15) NOT NULL,
  `harga_beli` decimal(10,0) NOT NULL,
  `harga_jual` decimal(10,0) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang1`
--

INSERT INTO `barang1` (`kode_barang`, `nama_barang`, `id_kategori`, `id_satuan`, `harga_beli`, `harga_jual`, `stok`) VALUES
('BWFB', 'Fresh Breeze Body Wash', 'BW1', 'D1', '3000000', '45000', 19),
('ELSS', 'Starlight Sparkle Eyeliner', 'EL1', 'D1', '700000', '34000', 30),
('ESHCD', 'Champagne Dreams Eyeshadow ', 'ESH1', 'P1', '250000', '45000', 4),
('FWSR', 'facialwash sariayu', 'FW1', 'P1', '20000', '25000', 10),
('LCREAMOMG1', 'OMG Velvet Kiss 12', 'LCREAM', 'D1', '340000', '21000', 12),
('LTINTWK', 'Watermelon Kiss Tint', 'LTINT', 'B1', '36000', '15000', 6),
('SHWRDH1', 'Wardah Hair Renewal', 'SH1', 'P1', '350000', '52000', 7),
('SMASKEMINA', 'Emina Beauty Sleep Mask', 'SMASK1', 'P1', '200000', '25000', 7),
('SNSCNWRDH', 'Essential gel sunscreen spf 35PA++', 'EL1', 'D1', '600000', '35000', 25),
('TNRGE', 'Revitalizing Elixir Toner', 'TN1', 'P1', '467000', '47500', 9);

-- --------------------------------------------------------

--
-- Table structure for table `detailpesan`
--

CREATE TABLE `detailpesan` (
  `id_detail` int(11) NOT NULL,
  `kode_barang` varchar(15) NOT NULL,
  `qty` int(11) NOT NULL,
  `status` varchar(30) NOT NULL,
  `total` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailpesan`
--

INSERT INTO `detailpesan` (`id_detail`, `kode_barang`, `qty`, `status`, `total`) VALUES
(1, 'BWFB', 1, 'Belum Lunas', 45000);

--
-- Triggers `detailpesan`
--
DELIMITER $$
CREATE TRIGGER `tambah order` AFTER INSERT ON `detailpesan` FOR EACH ROW INSERT INTO 
log_detail(status,waktu, id_detail,kode_barang,qty,total)VALUES
('tambah order',now(),new.id_detail,new.kode_barang,new.qty,new.total)
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_stok_barang` AFTER INSERT ON `detailpesan` FOR EACH ROW UPDATE barang1 
SET stok = stok - new.qty
WHERE kode_barang = new.kode_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(15) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
('BW1', 'Bodywash'),
('EL1', 'eyeliner'),
('ESH1', 'eyeshadow'),
('ESS1', 'essence'),
('EX1', 'expoliator'),
('FW1', 'facialwash'),
('LB1', 'lipbalm'),
('LCREAM', 'lipcream'),
('LTINT', 'liptint'),
('MSKR1', 'maskara'),
('MWATTER', 'Micellar Water'),
('SH1', 'shampo'),
('SMASK1', 'sleepingmask'),
('SNSCN1', 'sunscreen'),
('SR1', 'Serum'),
('TN1', 'toner');

-- --------------------------------------------------------

--
-- Table structure for table `log_admin`
--

CREATE TABLE `log_admin` (
  `status` varchar(30) NOT NULL,
  `waktu` date NOT NULL,
  `id_peg` int(15) NOT NULL,
  `nama_peg` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `handphone` int(13) NOT NULL,
  `level` enum('admin','kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_admin`
--

INSERT INTO `log_admin` (`status`, `waktu`, `id_peg`, `nama_peg`, `username`, `password`, `handphone`, `level`) VALUES
('tambah data', '2024-01-25', 6, 'novita', 'novita@gmail.com', '1607', 306894696, 'admin'),
('tambah data', '2024-01-27', 7, 'yeni ', 'yeni@gmail.com', '222', 24835823, 'kasir'),
('tambah data', '2024-01-27', 8, 'winda siti nurazizah', 'winda@gmail.com', '111', 2147483647, 'kasir'),
('tambah data', '2024-01-27', 9, 'nayla salasabila', 'nayla@gmail.com', '1010', 745476994, 'admin'),
('tambah data', '2024-01-31', 10, 'sindy', 'sindy@gmail.com', '1127', 40908836, 'kasir'),
('tambah data', '2024-02-14', 11, 'putri kamilah', 'putri@gmail.com', '666', 588485754, 'admin'),
('tambah data', '2024-02-14', 12, 'alya calisa', 'alya', '333', 977665678, 'kasir'),
('tambah data', '2024-02-15', 15, 'nabila', 'nabila', '1234', 40867648, 'admin'),
('tambah data', '2024-02-25', 16, 'novita aulia', 'novita aulia', '1607', 2147483647, 'admin'),
('tambah data', '2024-02-27', 16, 'tania', 'tania', '999', 2147483647, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `log_barang`
--

CREATE TABLE `log_barang` (
  `status` varchar(50) NOT NULL,
  `waktu` date NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `id_satuan` int(11) NOT NULL,
  `harga_beli` decimal(10,0) NOT NULL,
  `harga_jual` decimal(10,0) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `log_detail`
--

CREATE TABLE `log_detail` (
  `status` varchar(30) NOT NULL,
  `waktu` date NOT NULL,
  `id_detail` int(11) NOT NULL,
  `kode_barang` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `total` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_detail`
--

INSERT INTO `log_detail` (`status`, `waktu`, `id_detail`, `kode_barang`, `qty`, `total`) VALUES
('tambah order', '2024-01-31', 13, 2, 1, 50000),
('tambah order', '2024-02-05', 14, 5, 2, 130000),
('tambah order', '2024-02-05', 15, 3, 1, 31000),
('tambah order', '2024-02-14', 16, 9, 4, 160000),
('tambah order', '2024-02-15', 17, 1, 1, 30000),
('tambah order', '2024-02-15', 18, 1, 2, 60000),
('tambah order', '2024-02-15', 19, 1, 2, 60000),
('tambah order', '2024-02-15', 20, 3, 2, 62000),
('tambah order', '2024-02-21', 21, 1, 1, 30000),
('tambah order', '2024-02-22', 22, 9, 1, 40000),
('tambah order', '2024-02-22', 23, 5, 1, 65000),
('tambah order', '2024-02-22', 24, 9, 1, 40000),
('tambah order', '2024-02-22', 25, 5, 1, 65000),
('tambah order', '2024-02-22', 26, 7, 4, 240000),
('tambah order', '2024-02-22', 27, 3, 1, 31000),
('tambah order', '2024-02-25', 28, 5, 1, 65000),
('tambah order', '2024-02-26', 29, 3, 1, 31000),
('tambah order', '2024-02-26', 30, 3, 1, 31000),
('tambah order', '2024-02-27', 31, 2, 4, 200000),
('tambah order', '2024-02-27', 32, 4, 5, 375000),
('tambah order', '2024-02-27', 1, 0, 1, 45000);

-- --------------------------------------------------------

--
-- Table structure for table `log_master`
--

CREATE TABLE `log_master` (
  `status` varchar(30) NOT NULL,
  `waktu` date NOT NULL,
  `id_master` int(11) NOT NULL,
  `id_detail` int(11) NOT NULL,
  `id_peg` int(11) NOT NULL,
  `tgl_byr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_master`
--

INSERT INTO `log_master` (`status`, `waktu`, `id_master`, `id_detail`, `id_peg`, `tgl_byr`) VALUES
('transaksi', '2024-01-31', 12, 13, 7, 20240131),
('transaksi', '2024-01-31', 13, 13, 7, 20240131),
('transaksi', '2024-02-01', 14, 1, 7, 20240201),
('transaksi', '2024-02-01', 15, 1, 7, 20240201),
('transaksi', '2024-02-01', 16, 1, 7, 20240201),
('transaksi', '2024-02-01', 17, 1, 7, 20240201),
('transaksi', '2024-02-01', 18, 1, 7, 20240201),
('transaksi', '2024-02-05', 19, 10, 10, 20240205),
('transaksi', '2024-02-05', 20, 10, 10, 20240205),
('transaksi', '2024-02-05', 21, 10, 10, 20240205),
('transaksi', '2024-02-14', 22, 16, 12, 20240214),
('transaksi', '2024-02-15', 23, 17, 7, 20240215),
('transaksi', '2024-02-15', 24, 20, 8, 20240215),
('transaksi', '2024-02-15', 25, 20, 8, 20240215),
('transaksi', '2024-02-21', 26, 21, 7, 20240201),
('transaksi', '2024-02-21', 27, 21, 7, 20240201),
('transaksi', '2024-02-21', 28, 21, 7, 20240201),
('transaksi', '2024-02-21', 29, 21, 7, 20240201),
('transaksi', '2024-02-21', 30, 21, 7, 20240201),
('transaksi', '2024-02-21', 31, 21, 7, 20240201),
('transaksi', '2024-02-21', 32, 21, 7, 20240201),
('transaksi', '2024-02-21', 33, 21, 7, 20240201),
('transaksi', '2024-02-21', 34, 21, 7, 20240201),
('transaksi', '2024-02-21', 35, 21, 7, 20240201),
('transaksi', '2024-02-21', 36, 21, 7, 20240201),
('transaksi', '2024-02-21', 37, 21, 7, 20240201),
('transaksi', '2024-02-21', 38, 21, 7, 20240201),
('transaksi', '2024-02-21', 39, 3, 7, 20240221),
('transaksi', '2024-02-21', 40, 3, 7, 20240221),
('transaksi', '2024-02-22', 41, 26, 12, 20240222),
('transaksi', '2024-02-22', 42, 26, 12, 20240222),
('transaksi', '2024-02-22', 43, 26, 12, 20240222),
('transaksi', '2024-02-25', 44, 28, 12, 20240225),
('transaksi', '2024-02-25', 45, 28, 7, 20240225),
('transaksi', '2024-02-26', 46, 15, 12, 20240226),
('transaksi', '2024-02-26', 47, 15, 12, 20240226),
('transaksi', '2024-02-27', 48, 31, 12, 20240227),
('transaksi', '2024-02-27', 49, 32, 7, 20240227),
('transaksi', '2024-02-27', 50, 1, 12, 20240227);

-- --------------------------------------------------------

--
-- Table structure for table `masterpesan`
--

CREATE TABLE `masterpesan` (
  `id_master` int(11) NOT NULL,
  `id_detail` int(11) NOT NULL,
  `id_peg` int(11) NOT NULL,
  `tgl_byr` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `masterpesan`
--

INSERT INTO `masterpesan` (`id_master`, `id_detail`, `id_peg`, `tgl_byr`) VALUES
(1, 2, 7, '2024-01-28'),
(2, 1, 7, '2024-01-05'),
(3, 1, 7, '2024-01-05'),
(4, 1, 7, '2024-01-05'),
(5, 1, 7, '2024-01-05'),
(6, 6, 8, '2024-01-30'),
(7, 8, 7, '2024-01-31'),
(8, 8, 7, '2024-01-31'),
(9, 11, 6, '2024-01-31'),
(10, 11, 6, '2024-01-31'),
(11, 13, 6, '2024-01-31'),
(12, 13, 7, '2024-01-31'),
(13, 13, 7, '2024-01-31'),
(14, 1, 7, '2024-02-01'),
(15, 1, 7, '2024-02-01'),
(16, 1, 7, '2024-02-01'),
(17, 1, 7, '2024-02-01'),
(18, 1, 7, '2024-02-01'),
(19, 10, 10, '2024-02-05'),
(20, 10, 10, '2024-02-05'),
(21, 10, 10, '2024-02-05'),
(22, 16, 12, '2024-02-14'),
(23, 17, 7, '2024-02-15'),
(24, 20, 8, '2024-02-15'),
(25, 20, 8, '2024-02-15'),
(26, 21, 7, '2024-02-01'),
(27, 21, 7, '2024-02-01'),
(28, 21, 7, '2024-02-01'),
(29, 21, 7, '2024-02-01'),
(30, 21, 7, '2024-02-01'),
(31, 21, 7, '2024-02-01'),
(32, 21, 7, '2024-02-01'),
(33, 21, 7, '2024-02-01'),
(34, 21, 7, '2024-02-01'),
(35, 21, 7, '2024-02-01'),
(36, 21, 7, '2024-02-01'),
(37, 21, 7, '2024-02-01'),
(38, 21, 7, '2024-02-01'),
(39, 3, 7, '2024-02-21'),
(40, 3, 7, '2024-02-21'),
(41, 26, 12, '2024-02-22'),
(42, 26, 12, '2024-02-22'),
(43, 26, 12, '2024-02-22'),
(44, 28, 12, '2024-02-25'),
(45, 28, 7, '2024-02-25'),
(46, 15, 12, '2024-02-26'),
(47, 15, 12, '2024-02-26'),
(48, 31, 12, '2024-02-27'),
(49, 32, 7, '2024-02-27'),
(50, 1, 12, '2024-02-27');

--
-- Triggers `masterpesan`
--
DELIMITER $$
CREATE TRIGGER `sudah bayar` AFTER INSERT ON `masterpesan` FOR EACH ROW INSERT INTO 
log_master(status,waktu,id_master,id_detail,id_peg,tgl_byr)
VALUES ('transaksi',now(),new.id_master,new.id_detail,new.id_peg,new.tgl_byr)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_peg` int(11) NOT NULL,
  `nama_peg` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `handphone` varchar(13) NOT NULL,
  `level` enum('ADMIN','MANAGER','KASIR','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_peg`, `nama_peg`, `username`, `password`, `handphone`, `level`) VALUES
(6, 'novita aulia', 'novita ', '1607', '306894696', 'ADMIN'),
(7, 'yeni nurjannah', 'yeni', '222', '024835823', 'KASIR'),
(8, 'winda siti nurazizah', 'winda', '111', '04959086477', 'KASIR'),
(9, 'nayla salasabila', 'nayla', '1010', '0745476994', 'ADMIN'),
(11, 'putri kamilah', 'putri', '666', '0588485754', 'ADMIN'),
(12, 'alya calisa', 'alya', '333', '0977665678', 'KASIR'),
(15, 'nabila', 'nabila', '1234', '040867648', 'ADMIN'),
(16, 'tania', 'iftania', '999', '04698097879', 'ADMIN');

--
-- Triggers `pegawai`
--
DELIMITER $$
CREATE TRIGGER `tambah data` AFTER INSERT ON `pegawai` FOR EACH ROW INSERT INTO log_admin(status,waktu,id_peg,nama_peg,username,password,handphone,level)VALUES('tambah data',now(),new.id_peg,new.nama_peg,new.username,new.password,new.handphone,new.level)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `satuan`
--

CREATE TABLE `satuan` (
  `id_satuan` varchar(15) NOT NULL,
  `nama_satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `satuan`
--

INSERT INTO `satuan` (`id_satuan`, `nama_satuan`) VALUES
('B1', 'box'),
('D1', 'DUS'),
('P1', 'pcs');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang1`
--
ALTER TABLE `barang1`
  ADD PRIMARY KEY (`kode_barang`),
  ADD KEY `nama_barang` (`nama_barang`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `detailpesan`
--
ALTER TABLE `detailpesan`
  ADD PRIMARY KEY (`id_detail`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `masterpesan`
--
ALTER TABLE `masterpesan`
  ADD KEY `id_detail` (`id_detail`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_peg`);

--
-- Indexes for table `satuan`
--
ALTER TABLE `satuan`
  ADD PRIMARY KEY (`id_satuan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detailpesan`
--
ALTER TABLE `detailpesan`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
