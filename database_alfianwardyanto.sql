-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jul 2021 pada 11.59
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_alfianwardyanto`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_siswa`
--

CREATE TABLE `tb_siswa` (
  `nis` int(12) NOT NULL,
  `nama` varchar(12) NOT NULL,
  `jkelamin` varchar(11) NOT NULL,
  `ket` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_siswa`
--

INSERT INTO `tb_siswa` (`nis`, `nama`, `jkelamin`, `ket`) VALUES
(1011, 'ucup', 'Pria', 'sudah'),
(1012, 'udin', 'Pria', 'belum'),
(1013, 'mawar', 'Wanita', 'belum'),
(1014, 'alfian', 'Pria', 'sudah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_uangkas`
--

CREATE TABLE `tb_uangkas` (
  `nis` int(12) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `membayar` int(12) NOT NULL,
  `kembalian` int(12) NOT NULL,
  `tgl` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_uangkas`
--

INSERT INTO `tb_uangkas` (`nis`, `nama`, `membayar`, `kembalian`, `tgl`) VALUES
(1014, 'alfian', 5000, 4000, '02-07-2021'),
(1011, 'ucup', 2000, 1000, '02-07-2021');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_siswa`
--
ALTER TABLE `tb_siswa`
  ADD PRIMARY KEY (`nis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
