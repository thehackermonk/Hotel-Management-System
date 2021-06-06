-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 06, 2021 at 03:10 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
CREATE TABLE IF NOT EXISTS `auth` (
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`login`, `password`) VALUES
('admin', '0052ea847ea381e846227762e0093cba82bf5c6ce11f6fdc634cf3c183eba2f2');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `room_no` int(11) NOT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `payment` float NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `room_no` (`room_no`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `name`, `contact`, `room_no`, `from_date`, `to_date`, `payment`) VALUES
(1, 'John', '0123456789', 1006, '2021-05-08', '2021-05-10', 560),
(2, 'Maya', '123456789', 1006, '2021-05-12', '2021-05-20', 560);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE IF NOT EXISTS `food` (
  `ndb_no` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`ndb_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`ndb_no`, `name`, `description`, `price`) VALUES
(101, 'Tacos', 'Tacos is a mexican cousine.', 300),
(102, 'Som Tam', 'Som Tam is a thai cousine.', 275.5),
(103, 'Masala Dosa', 'Masala Dosa is an Indian cousine.', 147.61),
(104, 'Pautine', 'Pautine is a Canadian cousine.', 450),
(105, 'Brocolli Apple Salad', 'Brocolli Apple Salad is an Italian cousine.', 245),
(106, 'Himalayan Breakfast', 'Himalayan Breakfast is a North Indian cousine.', 220),
(107, 'Idli', 'Idli is a south indian cousine.', 123.81),
(108, 'Medu Vadai', 'Medu Vadai is a south indian cousine.', 119.05),
(109, 'Ghee Roast', 'Ghee Roast is a south indian cousine.', 204.76),
(110, 'Paneer Jugalbani', 'Paneer Jugalbani is a north indian cousine', 199),
(111, 'Hara Bara Kabab', 'Hara Bara Kabab is a north indian cousine.', 199),
(112, 'Paneer Tikka', 'Paneer Tikka is a north indian cousine.', 249.8),
(113, 'Fruit Lassi', 'Fruit Lassi is a drink', 70),
(114, 'Strawberry Smoothie', 'Strawberry Smoothie is a drink.', 70),
(115, 'Oreo Shake', 'Oreo Shake', 60),
(116, 'Fruits and Cream', 'Fruit ice cream', 90),
(117, 'Mexican Special Fruit Salad', 'Fruit Salad', 120),
(118, 'Apple Juice', 'Juice', 90),
(119, 'Pineapple Juice', 'Juice', 90),
(120, 'Chicken Burger', 'Burger', 90),
(121, 'Beef Burger', 'Burger', 100),
(122, 'Kerala Parotta', 'Breakfast', 15),
(123, 'Veg Meal', 'Lunch', 125),
(124, 'Beef Curry', 'Curry', 130),
(125, 'Beef Roast', 'Beef Roast', 160),
(126, 'Chicken Curry', 'Curry', 120),
(127, 'Chicken Fry', 'Fry with gravy', 150),
(128, 'Tomato Rice', 'Rice', 65),
(129, 'Lemon Rice', 'Rice', 65),
(130, 'Jeera Rice', 'Rice', 65),
(131, 'Masala Rice', 'Rice', 80),
(132, 'Veg Pulao', 'Pulao', 75),
(133, 'Gobi Fried Rice', 'Fried Rice', 80),
(134, 'Gobi Paratha', 'Paratha', 45),
(135, 'Plain Paratha', 'Paratha', 15),
(136, 'Aloo Baingan', 'Side dish', 90),
(137, 'Mushroom Masala', 'Curry', 110),
(138, 'Tomato Fry', 'Rice', 75),
(139, 'Gobi 65', 'Side dish', 110),
(140, 'Thali Meals', '4 roti, rice, dal, aloosabji, vegetable sabji, pickle, curd', 130),
(141, 'Veg Burger', 'Burger', 189),
(142, 'Royal Meal', '(4 Pcs) Chicken, Combo Fries, 2 Bun, 2 Garlic Paste', 399),
(143, 'French Fries', 'Snacks', 80),
(144, 'Bun', 'Snack', 12),
(145, 'Garlic Paste', 'Snack', 12),
(146, 'Al Faham', 'Arabic Food', 160),
(147, 'Tandoori', 'Chicken', 160),
(148, 'Shawarma', 'Arabic', 80),
(149, 'Egg Bhurji', 'Side dish', 80);

-- --------------------------------------------------------

--
-- Table structure for table `food_order`
--

DROP TABLE IF EXISTS `food_order`;
CREATE TABLE IF NOT EXISTS `food_order` (
  `order_no` int(11) NOT NULL,
  `room_no` int(11) DEFAULT NULL,
  `restaurant_no` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`order_no`),
  KEY `room_no` (`room_no`),
  KEY `restaurant_no` (`restaurant_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_order`
--

INSERT INTO `food_order` (`order_no`, `room_no`, `restaurant_no`, `status`, `date`) VALUES
(1, 1007, 3, 'Initiated', '2021-05-26'),
(2, 1008, 9, 'Completed', '2021-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `foreigner`
--

DROP TABLE IF EXISTS `foreigner`;
CREATE TABLE IF NOT EXISTS `foreigner` (
  `passport` varchar(10) NOT NULL,
  `guest_id` int(11) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  PRIMARY KEY (`passport`),
  KEY `guest_id` (`guest_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foreigner`
--

INSERT INTO `foreigner` (`passport`, `guest_id`, `nationality`, `issue_date`) VALUES
('817293h123', 2, 'India', '2018-06-04');

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `guest_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `foreigner` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`guest_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guest_id`, `name`, `address`, `telephone`, `foreigner`) VALUES
(1, 'Raj', 'Raj Bhavan\nKollam\nKerala', '9995770493', 0),
(2, 'John Mathew', 'John Villa\nAlabama\nNew York', '+516 666 823', 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `guest_in_room`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `guest_in_room`;
CREATE TABLE IF NOT EXISTS `guest_in_room` (
`room_no` int(11)
,`name` varchar(100)
);

-- --------------------------------------------------------

--
-- Table structure for table `guest_register`
--

DROP TABLE IF EXISTS `guest_register`;
CREATE TABLE IF NOT EXISTS `guest_register` (
  `register_no` int(11) NOT NULL AUTO_INCREMENT,
  `guest_id` int(11) DEFAULT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `room_no` int(11) DEFAULT NULL,
  `no_of_persons` int(11) DEFAULT NULL,
  `visiting_purpose` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`register_no`),
  KEY `guest_id` (`guest_id`),
  KEY `room_no` (`room_no`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guest_register`
--

INSERT INTO `guest_register` (`register_no`, `guest_id`, `check_in`, `check_out`, `room_no`, `no_of_persons`, `visiting_purpose`) VALUES
(1, 1, '2021-05-05', NULL, 1007, 2, 'Travel'),
(2, 2, '2021-05-05', NULL, 1008, 1, 'Business Visit');

-- --------------------------------------------------------

--
-- Table structure for table `identity`
--

DROP TABLE IF EXISTS `identity`;
CREATE TABLE IF NOT EXISTS `identity` (
  `adhaar_no` bigint(20) NOT NULL,
  `guest_id` int(11) DEFAULT NULL,
  `year_of_birth` int(11) DEFAULT NULL,
  PRIMARY KEY (`adhaar_no`),
  KEY `guest_id` (`guest_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `identity`
--

INSERT INTO `identity` (`adhaar_no`, `guest_id`, `year_of_birth`) VALUES
(12312341321, 1, 2015);

-- --------------------------------------------------------

--
-- Table structure for table `maintenance`
--

DROP TABLE IF EXISTS `maintenance`;
CREATE TABLE IF NOT EXISTS `maintenance` (
  `maintenance_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_no` int(11) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `date_of_maintenance` date NOT NULL,
  PRIMARY KEY (`maintenance_id`),
  KEY `room_no` (`room_no`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintenance`
--

INSERT INTO `maintenance` (`maintenance_id`, `room_no`, `type`, `status`, `comments`, `date_of_maintenance`) VALUES
(1, 1004, 'Routine Maintenance', 1, NULL, '2021-05-04'),
(2, 1005, 'Electricity Maintenance', 0, 'Changed bulb', '2021-05-04'),
(3, 1003, 'Plumbing Maintenance', 1, NULL, '2021-05-04');

-- --------------------------------------------------------

--
-- Table structure for table `ordered_food`
--

DROP TABLE IF EXISTS `ordered_food`;
CREATE TABLE IF NOT EXISTS `ordered_food` (
  `order_no` int(11) DEFAULT NULL,
  `food` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  KEY `order_no` (`order_no`),
  KEY `ndb_no` (`food`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordered_food`
--

INSERT INTO `ordered_food` (`order_no`, `food`, `quantity`) VALUES
(1, 103, 1),
(2, 131, 4),
(2, 125, 3);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE IF NOT EXISTS `restaurant` (
  `restaurant_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`restaurant_no`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`restaurant_no`, `name`, `type`) VALUES
(1, 'Fine Dine', 'Italian'),
(2, 'Dilli Dhaba', 'North Indian'),
(3, 'Thani Nadan', 'South Indian'),
(6, 'Desi Cuppa', 'Fast Food'),
(7, 'Arabic Resto', 'Fast Food'),
(8, 'Irani Alif House', 'Arabian'),
(9, 'Arabesque', 'Arabian'),
(10, 'Nila Restaurant', 'South Indian'),
(11, 'Kaffee House', 'Continental'),
(12, 'Changayees Taste Hub', 'South Indian');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_food`
--

DROP TABLE IF EXISTS `restaurant_food`;
CREATE TABLE IF NOT EXISTS `restaurant_food` (
  `restaurant_no` int(11) DEFAULT NULL,
  `food` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant_food`
--

INSERT INTO `restaurant_food` (`restaurant_no`, `food`) VALUES
(3, 108),
(3, 103),
(3, 107),
(3, 109),
(1, 104),
(1, 101),
(1, 102),
(9, 146),
(9, 121),
(9, 124),
(9, 125),
(9, 105),
(9, 126),
(9, 127),
(9, 149),
(9, 109),
(9, 111),
(9, 131),
(9, 137),
(9, 148),
(9, 101),
(12, 120),
(12, 126),
(12, 127),
(12, 149),
(12, 109),
(12, 107),
(12, 108),
(12, 123),
(12, 132),
(6, 118),
(6, 105),
(6, 144),
(6, 143),
(6, 113),
(6, 116),
(6, 117),
(6, 115),
(6, 119),
(2, 135),
(2, 128),
(2, 140),
(2, 138),
(2, 112),
(2, 110),
(2, 137),
(2, 131),
(2, 129),
(2, 130),
(2, 111),
(2, 106),
(2, 134),
(2, 133),
(2, 139),
(2, 109),
(2, 149),
(2, 127),
(2, 126),
(2, 136),
(3, 122),
(3, 131),
(3, 130),
(3, 129),
(3, 123),
(3, 132);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_type`
--

DROP TABLE IF EXISTS `restaurant_type`;
CREATE TABLE IF NOT EXISTS `restaurant_type` (
  `type_no` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`type_no`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant_type`
--

INSERT INTO `restaurant_type` (`type_no`, `type`, `description`) VALUES
(1, 'North Indian', 'North Indian Cousine'),
(2, 'South Indian', 'South Indian Cousine'),
(3, 'Italian', 'Italian Cousine'),
(5, 'Fast Food', 'Fast Food'),
(6, 'Arabian', 'Arabian cousine'),
(7, 'Continental', 'Continental cousine');

-- --------------------------------------------------------

--
-- Stand-in structure for view `restaurant_with_food`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `restaurant_with_food`;
CREATE TABLE IF NOT EXISTS `restaurant_with_food` (
`restaurant_no` int(11)
,`name` varchar(50)
,`type` varchar(50)
,`food` int(11)
,`date` date
,`quantity` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE IF NOT EXISTS `rooms` (
  `room_no` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `maintenance` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`room_no`),
  KEY `type` (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_no`, `type`, `status`, `maintenance`) VALUES
(1001, 'Studio', 'Vacant', 0),
(1002, 'Double', 'Vacant', 0),
(1003, 'King', 'Vacant', 1),
(1004, 'Studio', 'Vacant', 1),
(1005, 'Presidential', 'Vacant', 0),
(1006, 'King', 'Vacant', 0),
(1007, 'King', 'Occupied', 0),
(1008, 'Studio', 'Occupied', 0),
(1009, 'Suite', 'Vacant', 0),
(1010, 'Mini Suite', 'Vacant', 0);

-- --------------------------------------------------------

--
-- Table structure for table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE IF NOT EXISTS `roomtype` (
  `type` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roomtype`
--

INSERT INTO `roomtype` (`type`, `price`, `capacity`) VALUES
('Single', 700, 1),
('Double', 1000, 2),
('Triple', 1200, 3),
('Quad', 1350, 4),
('Queen', 1250, 2),
('King', 1400, 2),
('Studio', 400, 2),
('Suite', 2000, 3),
('Mini Suite', 1500, 2),
('Presidential', 5000, 4),
('Cabana', 3500, 2);

-- --------------------------------------------------------

--
-- Stand-in structure for view `room_under_maintenance`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `room_under_maintenance`;
CREATE TABLE IF NOT EXISTS `room_under_maintenance` (
`room_no` int(11)
,`room_type` varchar(20)
,`maintenance_type` varchar(30)
,`date_of_maintenance` date
,`comments` varchar(300)
);

-- --------------------------------------------------------

--
-- Table structure for table `todays_food`
--

DROP TABLE IF EXISTS `todays_food`;
CREATE TABLE IF NOT EXISTS `todays_food` (
  `restaurant_no` int(11) DEFAULT NULL,
  `food` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  KEY `restaurant_no` (`restaurant_no`),
  KEY `ndb_no` (`food`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todays_food`
--

INSERT INTO `todays_food` (`restaurant_no`, `food`, `date`, `quantity`) VALUES
(9, 146, '2021-06-06', 4),
(9, 125, '2021-06-06', 23),
(9, 126, '2021-06-06', 24),
(9, 127, '2021-06-06', 30),
(9, 137, '2021-06-06', 120),
(9, 148, '2021-06-06', 210),
(9, 131, '2021-06-06', 496),
(3, 109, '2021-06-06', 35),
(3, 103, '2021-06-06', 34),
(3, 131, '2021-06-06', 235),
(3, 123, '2021-06-06', 100),
(3, 108, '2021-06-06', 20),
(3, 122, '2021-06-06', 50);

-- --------------------------------------------------------

--
-- Structure for view `guest_in_room`
--
DROP TABLE IF EXISTS `guest_in_room`;

DROP VIEW IF EXISTS `guest_in_room`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `guest_in_room`  AS  select `r`.`room_no` AS `room_no`,`g`.`name` AS `name` from ((`guest` `g` join `guest_register` `gr`) join `rooms` `r`) where ((`g`.`guest_id` = `gr`.`guest_id`) and (`r`.`room_no` = `gr`.`room_no`)) ;

-- --------------------------------------------------------

--
-- Structure for view `restaurant_with_food`
--
DROP TABLE IF EXISTS `restaurant_with_food`;

DROP VIEW IF EXISTS `restaurant_with_food`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `restaurant_with_food`  AS  select `r`.`restaurant_no` AS `restaurant_no`,`r`.`name` AS `name`,`r`.`type` AS `type`,`t`.`food` AS `food`,`t`.`date` AS `date`,`t`.`quantity` AS `quantity` from (`restaurant` `r` join `todays_food` `t`) where (`r`.`restaurant_no` = `t`.`restaurant_no`) ;

-- --------------------------------------------------------

--
-- Structure for view `room_under_maintenance`
--
DROP TABLE IF EXISTS `room_under_maintenance`;

DROP VIEW IF EXISTS `room_under_maintenance`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `room_under_maintenance`  AS  select `r`.`room_no` AS `room_no`,`r`.`type` AS `room_type`,`m`.`type` AS `maintenance_type`,`m`.`date_of_maintenance` AS `date_of_maintenance`,`m`.`comments` AS `comments` from (`rooms` `r` join `maintenance` `m`) where ((`r`.`room_no` = `m`.`room_no`) and (`r`.`maintenance` = 1)) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
