-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table electrogridclient.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) CHARACTER SET latin1 NOT NULL,
  `customerEmail` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `customerType` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `customerContact` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table electrogridclient.customer: ~4 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerID`, `customerName`, `customerEmail`, `customerType`, `customerContact`) VALUES
	(1, 'Sachin Di', 'sachindi@gmail.com', 'New Customer', '763055154'),
	(5, 'Ashini', 'ashini@gmail.com', 'Old Customer', '788128354'),
	(6, 'Shashintha lakr', 'shashintha21@gmail.com', 'Old Customer', '987232462'),
	(7, 'anjalee Kap', 'anjalee@gmail.com', 'New Customer', '1234567897');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table electrogridclient.logins
CREATE TABLE IF NOT EXISTS `logins` (
  `log_uname` varchar(50) NOT NULL,
  `log_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table electrogridclient.logins: ~0 rows (approximately)
/*!40000 ALTER TABLE `logins` DISABLE KEYS */;
INSERT INTO `logins` (`log_uname`, `log_password`) VALUES
	('sachin', '123');
/*!40000 ALTER TABLE `logins` ENABLE KEYS */;

-- Dumping structure for table electrogridclient.payments
CREATE TABLE IF NOT EXISTS `payments` (
  `PaymentID` int(11) NOT NULL AUTO_INCREMENT,
  `PaymentDate` varchar(255) NOT NULL,
  `PaymentType` varchar(255) DEFAULT NULL,
  `Amount` varchar(255) DEFAULT NULL,
  `CardNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`PaymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table electrogridclient.payments: ~2 rows (approximately)
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`PaymentID`, `PaymentDate`, `PaymentType`, `Amount`, `CardNumber`) VALUES
	(1, '10.12.2022', 'Credit Card', '17500.00', 12345678),
	(3, '10.08.2022', 'Debit Card', '14500.00', 123456892);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;

-- Dumping structure for table electrogridclient.powerstation
CREATE TABLE IF NOT EXISTS `powerstation` (
  `PowerstationID` int(11) NOT NULL AUTO_INCREMENT,
  `Stationname` varchar(255) NOT NULL,
  `Province` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Powergenerated` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PowerstationID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table electrogridclient.powerstation: ~0 rows (approximately)
/*!40000 ALTER TABLE `powerstation` DISABLE KEYS */;
INSERT INTO `powerstation` (`PowerstationID`, `Stationname`, `Province`, `Location`, `Powergenerated`) VALUES
	(1, 'Colombo', 'western', 'awissawella', '240');
/*!40000 ALTER TABLE `powerstation` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
