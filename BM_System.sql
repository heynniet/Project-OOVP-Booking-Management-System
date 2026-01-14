-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 26, 2025 at 05:18 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `BM_System`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `billid` int(11) NOT NULL,
  `name` varchar(35) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `nationality` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `roomnumber` varchar(30) DEFAULT NULL,
  `bed` varchar(30) DEFAULT NULL,
  `roomtype` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `outdate` varchar(35) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `priceperday` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`billid`, `name`, `mobile`, `email`, `date`, `nationality`, `gender`, `id`, `address`, `roomnumber`, `bed`, `roomtype`, `price`, `status`, `outdate`, `days`, `amount`, `priceperday`) VALUES
(1, 'tentin', '088888888888', 'tentin@gmail.com', '2025/05/25', 'Indonesia', 'Female', NULL, 'Jababeka Cikarang', '201', 'Single', 'AC', NULL, 'check out', '2025/05/25 ', 1, 160000, 160000),
(2, 'daniel', '099999999999', 'daniel@gmail.com', '2025/05/25', 'Indonesia', 'Male', NULL, 'Jababeka Cikarang', '101', 'Double', 'AC', NULL, NULL, NULL, NULL, NULL, 150000),
(7, 'pusri', '08123456789', 'pusri@gmail.com', '2025/05/26', 'Malaysia', 'Female', NULL, 'Bukit Tinggi', '102', 'Single', 'AC', NULL, NULL, NULL, NULL, NULL, 200000),
(8, 'nabil', '081295221412', 'nabil1@gmail.com', '2025/05/26', 'Indonesia', 'Male', NULL, 'Jababeka Cikarang', '103', 'Single', 'NON AC', NULL, 'check out', '2025/05/26 ', 1, 100000, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomnumber` varchar(11) DEFAULT NULL,
  `roomtype` varchar(34) DEFAULT NULL,
  `bed` varchar(35) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomnumber`, `roomtype`, `bed`, `price`, `status`) VALUES
('102', 'AC', 'Single', 200000, 'Booked'),
('103', 'NON AC', 'Single', 100000, 'Not Booked'),
('104', 'NON AC', 'Double', 130000, 'Not Booked'),
('201', 'AC', 'Single', 160000, 'Not Booked'),
('202', 'AC', 'Double', 210000, 'Not Booked'),
('109', 'AC', 'Single', 1800000, 'Not Booked'),
('200', 'AC', 'Double', 17777777, 'Not Booked'),
('900', 'AC', 'Double', 99999999999, 'Not Booked');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` enum('Male','Female') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `gender`) VALUES
(1, 'nabil', 'nabil@gmail.com', 'nabil123', 'Male'),
(2, 'niet', 'niet@gmail.com', 'niet123', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`billid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `billid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
