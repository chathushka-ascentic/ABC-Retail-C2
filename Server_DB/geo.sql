-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2017 at 05:15 PM
-- Server version: 5.6.25
-- PHP Version: 5.5.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `geo`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(5) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `uname`, `pwd`) VALUES
(1, 'test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `markers`
--

CREATE TABLE IF NOT EXISTS `markers` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `markers`
--

INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`, `type`) VALUES
(1, 'sri lanka', 'renuka,kanewala,pokunuwita', 37.427708, -122.167107, 'restaurant'),
(2, 'sri lanka', 'renuka,kanewala,pokunuwita', 37.421707, -122.158142, 'restaurant'),
(3, 'jehfjhjfhrj', 'renuka,kanewala,pokunuwita', 37.421501, -122.170158, 'restaurant');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int(5) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `t_id` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `qty` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `uname`, `name`, `t_id`, `price`, `qty`) VALUES
(1, 'rukshan', 'item 1', 'jehfhrjfhh', 0, 556),
(2, 'rukshan', 'item 2', 'jehfhrjfhh', 0, 557);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `contact` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `uname`, `contact`, `email`, `pwd`) VALUES
(2, 'Rukshan withanage', 'rukshankapi', '0765416033', 'rukshanwithanage@gmail.com', '1234'),
(3, '34g', 'erh', 'erh', 'erdh', 'erherh'),
(4, 'erjrtjt', 'j5trjrj', 'jrj4rtju', 'trtu6u', '6ru6u6u'),
(5, 'rtjurtu', '4uruj', 'urtu', 'rtur', 'y4y45y45y'),
(6, '354y5r35y', '353y5y', '5y544y', '4y45y', 'y45y45y'),
(7, 'erh', 'Eh', 'erh', 'erh', 'erhe'),
(8, 'ty,mt', 'y,', 'ty,', 'ty,', 'ty,'),
(9, '56k6', 'yk5ik', '6ky', 'iyk', 'i76i6i7i76ii7i7i6ii7'),
(10, 'a', 'a', 'a', 'a', 'sdd'),
(11, 'asfs', 'agsg', 'esghe', 'sgwh', 'erjhreh'),
(12, 'eg45435', 'wgwg', 'wgw', 'gwg', 'ewgewg'),
(13, '', '', '', 'w', 'wd'),
(14, '4h4rehr45', 'h5r4h4rh', '4u', 'y', 'u54u4'),
(15, 'efef', 'test', '2141424', 'wewe@fuck.com', 'test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `markers`
--
ALTER TABLE `markers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `markers`
--
ALTER TABLE `markers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
