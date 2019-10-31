-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 28, 2019 at 10:14 PM
-- Server version: 10.1.41-MariaDB-0ubuntu0.18.04.1
-- PHP Version: 7.2.19-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `starwars`
--

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `id` int(11) NOT NULL,
  `machete_id` int(11) DEFAULT NULL,
  `release_date` bigint(20) NOT NULL,
  `title_number` int(11) DEFAULT NULL,
  `imdb_id` varchar(12) NOT NULL,
  `title` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id`, `machete_id`, `release_date`, `title_number`, `imdb_id`, `title`) VALUES
(1, 0, 233366400, 6, 'tt0076759', 'Star Wars: Episode IV - A New Hope (1977)'),
(2, 1, 330307200, 5, 'tt0080684', 'Star Wars: Episode V - The Empire Strikes Back (1980)'),
(3, NULL, 927072000, 1, 'tt0120915', 'Star Wars: Episode I - The Phantom Menace (1999)'),
(4, 2, 1021507200, 2, 'tt0121765', 'Star Wars: Episode II - Attack of the Clones (2002)'),
(5, NULL, 1222992000, NULL, 'tt0458290', 'Star Wars: The Clone Wars Movie & TV Series (2008)'),
(6, 3, 1116460800, 3, 'tt0121766', 'Star Wars: Episode III - Revenge of the Sith (2005)'),
(7, NULL, 1527206400, NULL, 'tt3778644', 'Solo: A Star Wars Story (2018)'),
(8, NULL, 1411689600, NULL, 'tt2930604', 'Star Wars: Rebels TV Series (2014)'),
(9, 4, 422668800, 6, 'tt0086190', 'Star Wars: Episode VI - Return of the Jedi (1983)'),
(10, NULL, 1450396800, 7, 'tt2488496', 'Star Wars: Episode VII - The Force Awakens (2015)'),
(11, NULL, 1513296000, 8, 'tt2527336', 'Star Wars: Episode VIII - The Last Jedi (2017)'),
(12, NULL, 1576627200, 9, 'tt10234874', 'Star Wars: Episode IX - The Rise of Skywalker (2019)'),
(13, NULL, 1481846400, NULL, 'tt3748528', 'Rogue One: A Star Wars Story (2016)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
