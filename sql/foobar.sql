CREATE DATABASE  IF NOT EXISTS `foobar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `foobar`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: foobar
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleInitial` varchar(3) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `emailAdd` varchar(45) NOT NULL,
  `accounttype` varchar(45) NOT NULL,
  `failedLoginCount` int(11) DEFAULT NULL,
  `locked` int(1) NOT NULL,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (3,'Anton','De Joya','DJ','danini','NeSrwl7G5H1nPTtEeyKTZA==','yie@yahoo.com','Customer',1,0),(4,'Melody','Dominguez','Q','melody','melodymelody','melody@yahoo.com','DVD Manager',0,0),(5,'Danica','Corpuz','D','danica','P0jNhlYWp602tB74dqQ8qw==','dccorpuz1@yahoo.com','Customer',0,0),(6,'Ruth','Corpuz','D','ruth','y1nBTlbeU3PM24xe4m/lGw==','ruth@a.com','Customer',1,0),(7,'Rachel','Corpuz','D','rachel','y1nBTlbeU3PM24xe4m/lGw==','dccorpuz1@yahoo.com','Customer',0,0),(8,'Ako','ako','A','ako','y1nBTlbeU3PM24xe4m/lGw==','ako@yey.com','Admin',0,0),(9,'Jasmin','Magdaong','S','jasmin','matAc3pvH4ge6nwL/S2n1A==','jasmin@y.com','Customer',0,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audiocd`
--

DROP TABLE IF EXISTS `audiocd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audiocd` (
  `audiocdID` int(11) NOT NULL AUTO_INCREMENT,
  `audiocd_productID` int(11) NOT NULL,
  `artist` varchar(45) NOT NULL,
  `recordCompany` varchar(45) NOT NULL,
  PRIMARY KEY (`audiocdID`),
  KEY `audiocd_accountID_idx` (`audiocd_productID`),
  CONSTRAINT `audiocd_accountID` FOREIGN KEY (`audiocd_productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audiocd`
--

LOCK TABLES `audiocd` WRITE;
/*!40000 ALTER TABLE `audiocd` DISABLE KEYS */;
/*!40000 ALTER TABLE `audiocd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `book_productID` int(11) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `datePublished` date NOT NULL,
  PRIMARY KEY (`bookID`),
  KEY `productID_idx` (`book_productID`),
  CONSTRAINT `productID` FOREIGN KEY (`book_productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customer_accountID` int(11) NOT NULL,
  `apartmentnoBA` varchar(45) NOT NULL,
  `streetBA` varchar(45) NOT NULL,
  `subdivisionBA` varchar(45) NOT NULL,
  `cityBA` varchar(45) NOT NULL,
  `postalcodeBA` int(11) NOT NULL,
  `countryBA` varchar(45) NOT NULL,
  `apartmentnoDA` varchar(45) NOT NULL,
  `streetDA` varchar(45) NOT NULL,
  `subdivisionDA` varchar(45) NOT NULL,
  `cityDA` varchar(45) NOT NULL,
  `postalcodeDA` int(11) NOT NULL,
  `countryDA` varchar(45) NOT NULL,
  PRIMARY KEY (`customerID`),
  KEY `customer_accountID_idx` (`customer_accountID`),
  CONSTRAINT `customer_accountID` FOREIGN KEY (`customer_accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (3,0,'Yen','Villa Carolina 1','Laguna','2098',0,'B6 L21','Yen','Villa Carolina 1','Laguna','2098',0,'3'),(4,5,'407','Bacood','Sta. Mesa','Manila',1016,'Philippines','407','Bacood','Sta. Mesa','Manila',1016,'Philippines'),(5,6,'407','Bacood','Sta. Mesa','Manila',1016,'Philippines','407','Bacood','Sta. Mesa','Manila',1016,'Philippines');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dvd`
--

DROP TABLE IF EXISTS `dvd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dvd` (
  `dvdID` int(11) NOT NULL AUTO_INCREMENT,
  `dvd_productID` int(11) NOT NULL,
  `director` varchar(45) NOT NULL,
  `actor` varchar(45) NOT NULL,
  `productCompany` varchar(45) NOT NULL,
  PRIMARY KEY (`dvdID`),
  KEY `dvd_productID_idx` (`dvd_productID`),
  CONSTRAINT `dvd_productID` FOREIGN KEY (`dvd_productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dvd`
--

LOCK TABLES `dvd` WRITE;
/*!40000 ALTER TABLE `dvd` DISABLE KEYS */;
INSERT INTO `dvd` VALUES (1,1,'ok','ok','ok');
/*!40000 ALTER TABLE `dvd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error_logs`
--

DROP TABLE IF EXISTS `error_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `error_logs` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(45) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `error_logs`
--

LOCK TABLES `error_logs` WRITE;
/*!40000 ALTER TABLE `error_logs` DISABLE KEYS */;
INSERT INTO `error_logs` VALUES (1,'0:0:0:0:0:0:0:1','2014-12-09 06:30:01','melody failed to login. Attempt: 1'),(2,'0:0:0:0:0:0:0:1','2014-12-09 06:31:34','melody failed to login. Attempt: 1'),(3,'0:0:0:0:0:0:0:1','2014-12-11 05:19:55','Customer jasmin registration failed.');
/*!40000 ALTER TABLE `error_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lockreport`
--

DROP TABLE IF EXISTS `lockreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lockreport` (
  `lockreportID` int(11) NOT NULL AUTO_INCREMENT,
  `lockreport_accountID` int(11) NOT NULL,
  `reason` varchar(45) NOT NULL,
  `emailaddress` varchar(45) NOT NULL,
  `done` int(1) NOT NULL,
  PRIMARY KEY (`lockreportID`),
  KEY `lockreport_accountID_idx` (`lockreport_accountID`),
  CONSTRAINT `lockreport_accountID` FOREIGN KEY (`lockreport_accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lockreport`
--

LOCK TABLES `lockreport` WRITE;
/*!40000 ALTER TABLE `lockreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `lockreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logs` (
  `logsID` int(11) NOT NULL AUTO_INCREMENT,
  `log_accountID` int(11) NOT NULL,
  `activity` varchar(45) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
<<<<<<< HEAD
  `ip_address` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`logsID`),
  KEY `log_accountID_idx` (`log_accountID`),
  CONSTRAINT `log_accountID` FOREIGN KEY (`log_accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
=======
  `ip_address` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`logsID`),
  KEY `log_accountID_idx` (`log_accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
>>>>>>> b756bceb48fe6d5093997133125801cdee55341e
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (30,0,'login','2014-12-11 08:11:28','192.168.1.0','successful'),(31,0,'login','2014-12-11 08:14:49','0:0:0:0:0:0:0:1','successful');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazine`
--

DROP TABLE IF EXISTS `magazine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magazine` (
  `magazineID` int(11) NOT NULL AUTO_INCREMENT,
  `magazine_productID` int(11) NOT NULL,
  `volumeNo` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `datePublished` date NOT NULL,
  `issueNo` int(11) NOT NULL,
  PRIMARY KEY (`magazineID`),
  KEY `magazine_productID_idx` (`magazine_productID`),
  CONSTRAINT `magazine_accountID` FOREIGN KEY (`magazine_productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine`
--

LOCK TABLES `magazine` WRITE;
/*!40000 ALTER TABLE `magazine` DISABLE KEYS */;
/*!40000 ALTER TABLE `magazine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `summary` varchar(45) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `stocks` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'DVD','TFIOS',255,'ok','ok',2010,25);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productorder`
--

DROP TABLE IF EXISTS `productorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productorder` (
  `productorderID` int(11) NOT NULL AUTO_INCREMENT,
  `productorder_shoppingcartID` int(11) NOT NULL,
  `productorder_productID` int(11) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`productorderID`),
  KEY `productorder_shoppingcartID_idx` (`productorder_shoppingcartID`),
  CONSTRAINT `productorder_shoppingcartID` FOREIGN KEY (`productorder_shoppingcartID`) REFERENCES `shoppingcart` (`shoppingcartID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productorder`
--

LOCK TABLES `productorder` WRITE;
/*!40000 ALTER TABLE `productorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `productorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `reviewID` int(11) NOT NULL AUTO_INCREMENT,
  `reviewString` varchar(45) NOT NULL,
  `review_customerID` int(11) NOT NULL,
  `review_productID` int(11) NOT NULL,
  PRIMARY KEY (`reviewID`),
  KEY `review_customerID_idx` (`reviewID`,`review_customerID`),
  KEY `review_customerID` (`review_customerID`),
  CONSTRAINT `review_customerID` FOREIGN KEY (`review_customerID`) REFERENCES `customer` (`customerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'123',2,3),(2,'1',0,2),(3,'1',0,3),(4,'12312323132',0,1),(5,'qwe',3,1),(6,'1211111',5,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcart` (
  `shoppingcartID` int(11) NOT NULL AUTO_INCREMENT,
  `shoppingcart_customerID` int(11) NOT NULL,
  `total` double NOT NULL,
  `orderDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shoppingcartID`),
  KEY `shoppingcart_customerID_idx` (`shoppingcart_customerID`),
  CONSTRAINT `shoppingcart_customerID` FOREIGN KEY (`shoppingcart_customerID`) REFERENCES `
` (`customerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-11 16:16:07
