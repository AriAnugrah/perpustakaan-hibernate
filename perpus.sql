-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2021 at 02:34 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `modified_data` date DEFAULT NULL,
  `fee` int(11) NOT NULL,
  `sendbackdate` date DEFAULT NULL,
  `status_active` bit(1) NOT NULL,
  `id_book` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`id`, `created_date`, `modified_data`, `fee`, `sendbackdate`, `status_active`, `id_book`, `id_user`) VALUES
(1, '2021-01-03', '2021-01-03', 16500, '2021-01-10', b'0', 4, 1),
(2, '2021-01-03', '2021-01-03', 16500, '2021-01-10', b'0', 4, 1),
(3, '2021-01-03', '2021-01-03', 2200, '2021-01-01', b'0', 2, 2),
(5, '2021-01-06', '2021-01-06', 2200, '2021-01-09', b'0', 1, 1),
(6, '2021-01-06', '2021-01-06', 2200, '2021-01-09', b'0', 1, 1),
(7, '2021-01-06', '2021-01-06', 2200, '2021-01-09', b'0', 2, 1),
(8, '2021-01-06', '2021-01-06', 16500, '2021-01-13', b'0', 5, 2),
(9, '2021-01-06', '2021-01-06', 2200, '2021-01-09', b'0', 2, 1),
(10, '2021-01-06', '2021-01-07', 5500, '2021-01-09', b'0', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `bukukita`
--

CREATE TABLE `bukukita` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `modified_data` date DEFAULT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `shelf` varchar(100) NOT NULL,
  `status` bit(1) NOT NULL,
  `tax` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `id_cat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bukukita`
--

INSERT INTO `bukukita` (`id`, `created_date`, `modified_data`, `author`, `publisher`, `shelf`, `status`, `tax`, `title`, `id_cat`) VALUES
(1, '2021-01-03', '2021-01-06', 'Fujiko Fujio', 'Gramedia', 'RK01', b'1', 200, 'Doraemon', 2),
(2, '2021-01-03', '2021-01-06', 'Aoyama Gosho', 'Gramedia', 'RK02', b'1', 200, 'Connan', 2),
(3, '2021-01-03', '2021-01-07', 'Rick Riordan', 'Gramedia', 'RK03', b'1', 500, 'Percy Jackson', 1),
(4, '2021-01-03', '2021-01-03', 'Jk Rowling', 'Gramedia', 'RK04', b'1', 1500, 'Harru Potter Half Blood Prince', 3),
(5, '2021-01-03', '2021-01-06', 'Tolkien', 'Gramedia', 'RK05', b'1', 1500, 'The Lord Of The Ring', 3),
(6, '2021-01-03', NULL, 'Suzzane Collin', 'Gramedia', 'RK06', b'1', 1500, 'The Hunger Games', 3);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `modified_data` date DEFAULT NULL,
  `name_cat` varchar(100) NOT NULL,
  `rent_duration` int(11) NOT NULL,
  `rent_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `created_date`, `modified_data`, `name_cat`, `rent_duration`, `rent_price`) VALUES
(1, '2021-01-03', NULL, 'Novel', 3, 5000),
(2, '2021-01-03', NULL, 'Comic', 3, 2000),
(3, '2021-01-03', '2021-01-03', 'Import Books', 7, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `sendback`
--

CREATE TABLE `sendback` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `modified_data` date DEFAULT NULL,
  `exceed_dur` int(11) DEFAULT NULL,
  `fine` int(11) DEFAULT NULL,
  `fineNeedPay` int(11) DEFAULT NULL,
  `tax` int(11) DEFAULT NULL,
  `id_borrow` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sendback`
--

INSERT INTO `sendback` (`id`, `created_date`, `modified_data`, `exceed_dur`, `fine`, `fineNeedPay`, `tax`, `id_borrow`) VALUES
(1, '2021-01-03', '2021-01-03', NULL, 0, 0, 1500, 1),
(2, '2021-01-03', '2021-01-03', NULL, 0, 0, 1500, 2),
(3, '2021-01-03', '2021-01-03', 2, 10, 220, 200, 3),
(4, '2021-01-06', '2021-01-06', NULL, 0, 0, 200, 6),
(5, '2021-01-06', '2021-01-06', NULL, 0, 0, 200, 7),
(6, '2021-01-06', '2021-01-06', NULL, 0, 0, 200, 9),
(7, '2021-01-06', '2021-01-06', NULL, 0, 0, 1500, 8),
(8, '2021-01-07', '2021-01-07', NULL, 0, 0, 500, 10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `modified_data` date DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone_num` varchar(100) NOT NULL,
  `status_delete` bit(1) NOT NULL,
  `status_loan` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `created_date`, `modified_data`, `address`, `gender`, `name`, `phone_num`, `status_delete`, `status_loan`) VALUES
(1, '2021-01-03', '2021-01-06', 'Jakarta', 'Laki Laki', 'Ari Anugrah', '081292928383', b'1', b'1'),
(2, '2021-01-03', '2021-01-06', 'Bekasi', 'Laki Laki', 'Salvator Leon', '0812929292', b'1', b'1'),
(3, '2021-01-06', '2021-01-07', 'coba', 'coba', 'coba', 'coba', b'1', b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7scw9eqtvthobxvfapv1429vo` (`id_book`),
  ADD KEY `FK266h7evg2faqw37s4dv7lhmrm` (`id_user`);

--
-- Indexes for table `bukukita`
--
ALTER TABLE `bukukita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKss7jw6cvmjmv8mdyp89iy149d` (`id_cat`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sendback`
--
ALTER TABLE `sendback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkjuax3vkw5wsgvjy8lg9dtg96` (`id_borrow`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `bukukita`
--
ALTER TABLE `bukukita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sendback`
--
ALTER TABLE `sendback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `FK266h7evg2faqw37s4dv7lhmrm` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK7scw9eqtvthobxvfapv1429vo` FOREIGN KEY (`id_book`) REFERENCES `bukukita` (`id`);

--
-- Constraints for table `bukukita`
--
ALTER TABLE `bukukita`
  ADD CONSTRAINT `FKss7jw6cvmjmv8mdyp89iy149d` FOREIGN KEY (`id_cat`) REFERENCES `category` (`id`);

--
-- Constraints for table `sendback`
--
ALTER TABLE `sendback`
  ADD CONSTRAINT `FKkjuax3vkw5wsgvjy8lg9dtg96` FOREIGN KEY (`id_borrow`) REFERENCES `borrow` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
