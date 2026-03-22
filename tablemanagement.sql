-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2024 at 11:39 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tablemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `customermanager`
--

CREATE TABLE `customermanager` (
  `id` int(30) NOT NULL,
  `username` varchar(50) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date` varchar(10) NOT NULL,
  `timeSlotNo` int(2) NOT NULL,
  `tableA` varchar(1) NOT NULL,
  `tableB` varchar(1) NOT NULL,
  `tableC` varchar(1) NOT NULL,
  `tableD` varchar(1) NOT NULL,
  `tableE` varchar(1) NOT NULL,
  `tableF` varchar(1) NOT NULL,
  `price` int(30) NOT NULL,
  `submitday` varchar(20) NOT NULL,
  `submittime` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customermanager`
--

INSERT INTO `customermanager` (`id`, `username`, `contact`, `address`, `email`, `date`, `timeSlotNo`, `tableA`, `tableB`, `tableC`, `tableD`, `tableE`, `tableF`, `price`, `submitday`, `submittime`) VALUES
(1395, 'Ganga Liyanage', '0786543120', 'No,171/5,Beach rd,Panadura', 'ganga12@gmail.com', '2024-08-22', 2, '', '', 'Y', '', '', '', 1500, '2024-May-26', '03:23:25 AM'),
(1396, 'Ganga Liyanage', '0786543120', 'No,171/5,Beach rd,Panadura', 'ganga12@gmail.com', '2024-08-22', 2, '', '', '', '', '', 'Y', 1500, '2024-May-26', '03:23:25 AM'),
(1397, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 1, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1398, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 1, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1399, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 2, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1400, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 2, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1401, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 3, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1402, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 3, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1403, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 4, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1404, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 4, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1405, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 5, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1406, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 5, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1407, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 6, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1408, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 6, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1409, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 7, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1410, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 7, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1411, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 8, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1412, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 8, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1413, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 9, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1414, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 9, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1415, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 10, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1416, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 10, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1417, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 11, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1418, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 11, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1419, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 12, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1420, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-09', 12, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1421, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 1, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1422, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 1, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1423, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 2, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1424, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 2, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1425, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 3, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1426, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 3, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1427, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 4, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1428, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 4, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1429, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 5, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1430, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 5, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1431, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 6, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1432, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 6, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1433, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 7, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1434, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 7, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1435, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 8, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1436, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 8, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1437, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 9, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1438, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 9, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1439, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 10, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1440, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 10, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1441, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 11, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1442, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 11, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1443, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 12, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1444, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-10', 12, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1445, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 1, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1446, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 1, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1447, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 2, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1448, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 2, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1449, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 3, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1450, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 3, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1451, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 4, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1452, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 4, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1453, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 5, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1454, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 5, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1455, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 6, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1456, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 6, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1457, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 7, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1458, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 7, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1459, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 8, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1460, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 8, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1461, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 9, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1462, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 9, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1463, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 10, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1464, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 10, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1465, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 11, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1466, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 11, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1467, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 12, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1468, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-11', 12, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1469, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 1, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1470, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 1, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1471, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 2, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1472, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 2, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1473, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 3, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1474, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 3, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1475, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 4, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1476, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 4, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1477, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 5, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1478, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 5, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1479, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 6, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1480, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 6, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1481, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 7, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1482, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 7, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1483, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 8, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1484, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 8, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1485, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 9, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1486, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 9, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1487, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 10, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1488, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 10, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1489, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 11, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1490, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 11, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1491, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 12, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1492, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-12', 12, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1493, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 1, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1494, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 1, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1495, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 2, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1496, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 2, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1497, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 3, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1498, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 3, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1499, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 4, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1500, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 4, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1501, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 5, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1502, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 5, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1503, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 6, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1504, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 6, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1505, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 7, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1506, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 7, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1507, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 8, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1508, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 8, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1509, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 9, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1510, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 9, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1511, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 10, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1512, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 10, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1513, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 11, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1514, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 11, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1515, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 12, '', '', '', '', 'Y', '', 60000, '2024-May-26', '03:27:04 AM'),
(1516, 'Saman Perera', '0771006904', 'No.12,Udayana Rd,Colombo 07', 'saman23@gmail.com', '2024-07-13', 12, '', '', '', '', '', 'Y', 60000, '2024-May-26', '03:27:04 AM'),
(1517, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-06', 3, 'Y', '', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1518, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-06', 3, '', 'Y', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1519, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-07', 3, 'Y', '', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1520, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-07', 3, '', 'Y', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1521, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-08', 3, 'Y', '', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1522, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-08', 3, '', 'Y', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1523, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-09', 3, 'Y', '', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM'),
(1524, 'Sarasi Disanayaka', '0712396501', 'No.12B,Flower rd,Borelesgamuva', 'sarasidisanayaka@gmail.com', '2024-06-09', 3, '', 'Y', '', '', '', '', 4200, '2024-May-26', '03:33:12 AM');

-- --------------------------------------------------------

--
-- Table structure for table `tablemanager`
--

CREATE TABLE `tablemanager` (
  `vipNormalTableCount` int(3) NOT NULL,
  `vipSpecialTableCount` int(3) NOT NULL,
  `vipNormalSeatCount` int(2) NOT NULL,
  `vipSpecialSeatCount` int(2) NOT NULL,
  `vipNormalTablePrice` int(10) NOT NULL,
  `vipSpecialTablePrice` int(10) NOT NULL,
  `outdoorNormalTableCount` int(3) NOT NULL,
  `outdoorSpecialTableCount` int(3) NOT NULL,
  `outdoorNormalSeatCount` int(2) NOT NULL,
  `outdoorSpecialSeatCount` int(2) NOT NULL,
  `outdoorNormalTablePrice` int(10) NOT NULL,
  `outdoorSpecialTablePrice` int(10) NOT NULL,
  `firstFloorNormalTableCount` int(3) NOT NULL,
  `firstFloorSpecialTableCount` int(3) NOT NULL,
  `firstFloorNormalSeatCount` int(2) NOT NULL,
  `firstFloorSpecialSeatCount` int(2) NOT NULL,
  `firstFloorNormalTablePrice` int(10) NOT NULL,
  `firstFloorSpecialTablePrice` int(10) NOT NULL,
  `no` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tablemanager`
--

INSERT INTO `tablemanager` (`vipNormalTableCount`, `vipSpecialTableCount`, `vipNormalSeatCount`, `vipSpecialSeatCount`, `vipNormalTablePrice`, `vipSpecialTablePrice`, `outdoorNormalTableCount`, `outdoorSpecialTableCount`, `outdoorNormalSeatCount`, `outdoorSpecialSeatCount`, `outdoorNormalTablePrice`, `outdoorSpecialTablePrice`, `firstFloorNormalTableCount`, `firstFloorSpecialTableCount`, `firstFloorNormalSeatCount`, `firstFloorSpecialSeatCount`, `firstFloorNormalTablePrice`, `firstFloorSpecialTablePrice`, `no`) VALUES
(5, 5, 4, 6, 800, 1000, 8, 2, 3, 6, 500, 600, 16, 4, 4, 6, 450, 600, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contact` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `email`, `contact`) VALUES
('Amara 12', 'tr76ty', '', '0725689765'),
('anura', '578', 'anura23@yahoo.com', '0734091200'),
('anushka', 'anu23', 'anu23@gmail.com', '0776002143'),
('chintaka12', '6782er', 'bethmal@gmail.com', '0714567909'),
('deshan34', '@deshan', '', '0702359889'),
('ganga145', 'gh5690', 'ganga12i@gmail.com', '0798349009'),
('JohnSilva', '<>/?', 'john@yahoo,com', '0782345712'),
('kamal1', 'kp12', 'kamal17@gmail.com', '0772178748'),
('kamal123', '123', 'kamal@gmail.com', '0702348746'),
('Kamal78', 'kamal', 'kamal78@gmail.com', '0754509861'),
('kusal29', 'kusal29', 'pereral78@gmail.com', '0738509254'),
('kusalkurruppu', '345#234', '', '0721006604'),
('nayana kumari56', 'njn67899', 'naykumari@gmail.com', '0712349009'),
('nethmi', '#ty*ui', '', '0768123123'),
('nishanthaPerera', '6890', 'nis23@yahoo,com', '0715518976'),
('pasan', '68904', '', '0771008748'),
('pasindu10', '7890', 'pasindurathnayaka3@yahoo.com', '0771006745'),
('priyankara', '098', '', '0723458909'),
('roshan', 'dj123', 'roshan90@yahoo.com', '0762309786'),
('saman345', 'kl098', 'saman23@gmail.com', '0771006904'),
('samantha12', '123', '', '0718138516'),
('saranga45', '6905', 'saran345@gmail.com', '0718167900'),
('sarasi', '#76weu', 'sarasidisanayaka@gmail.com', '0712396501'),
('sayuri34', '4423', 'sayuripriyangi5@gmail.com', '0759796009'),
('siripala23', '2456', 'siri23@yahoo.com', '0781000213'),
('somasiri23', 'sri%#', '', '0775623908');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customermanager`
--
ALTER TABLE `customermanager`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customermanager`
--
ALTER TABLE `customermanager`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1525;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
