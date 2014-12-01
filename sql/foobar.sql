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
  `locked` int(1) NOT NULL,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
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
  `artist` varchar(45) NOT NULL,
  `recordCompany` varchar(45) NOT NULL,
  `audiocd_productID` int(11) NOT NULL,
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
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `creditcardID` int(11) NOT NULL AUTO_INCREMENT,
  `cardName` varchar(45) NOT NULL,
  `cardNo` varchar(45) NOT NULL,
  `cardType` varchar(45) NOT NULL,
  `cardExpDate` varchar(45) NOT NULL,
  PRIMARY KEY (`creditcardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
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
  `customer_accountID` int(11) NOT NULL,
  PRIMARY KEY (`customerID`),
  KEY `customer_accountID_idx` (`customer_accountID`),
  CONSTRAINT `customer_accountID` FOREIGN KEY (`customer_accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercreditcard`
--

DROP TABLE IF EXISTS `customercreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customercreditcard` (
  `customercreditcardID` INT NOT NULL AUTO_INCREMENT,
  `customercreditcard_customerID` INT NOT NULL,
  `customercreditcard_creditcardID` INT NOT NULL,
  PRIMARY KEY (`customercreditcardID`),
  INDEX `customercreditcard_creditcardID_idx` (`customercreditcard_creditcardID` ASC),
  CONSTRAINT `customercreditcard_customerID`
    FOREIGN KEY (`customercreditcardID`)
    REFERENCES `foobar`.`customer` (`customerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customercreditcard_creditcardID`
    FOREIGN KEY (`customercreditcard_creditcardID`)
    REFERENCES `foobar`.`creditcard` (`creditcardID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE TABLE `customercreditcard` (
  `customercreditcardID` int(11) NOT NULL AUTO_INCREMENT,
  `customercreditcard_accountID` int(11) NOT NULL,
  `customercreditcard_creditcardID` int(11) NOT NULL,
  PRIMARY KEY (`customercreditcardID`),
  KEY `customercreditcard_creditcardID_idx` (`customercreditcard_creditcardID`),
  CONSTRAINT `customercreditcard_accountID` FOREIGN KEY (`customercreditcardID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customercreditcard_creditcardID` FOREIGN KEY (`customercreditcard_creditcardID`) REFERENCES `creditcard` (`creditcardID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercreditcard`
--

LOCK TABLES `customercreditcard` WRITE;
/*!40000 ALTER TABLE `customercreditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercreditcard` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dvd`
--

LOCK TABLES `dvd` WRITE;
/*!40000 ALTER TABLE `dvd` DISABLE KEYS */;
/*!40000 ALTER TABLE `dvd` ENABLE KEYS */;
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
  `time` time DEFAULT NULL,
  PRIMARY KEY (`logsID`),
  KEY `log_accountID_idx` (`log_accountID`),
  CONSTRAINT `log_accountID` FOREIGN KEY (`log_accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
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
  KEY `productorder_productID_idx` (`productorder_productID`),
  CONSTRAINT `productorder_productID` FOREIGN KEY (`productorder_productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcart` (
  `shoppingcartID` int(11) NOT NULL AUTO_INCREMENT,
  `shoppingcart_customerID` int(11) NOT NULL,
  `shoppingcart_creditcardID` int(11) NOT NULL,
  `total` double NOT NULL,
  `orderDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shoppingcartID`),
  KEY `shoppingcart_customerID_idx` (`shoppingcart_customerID`),
  KEY `shoppingcart_creditcardID_idx` (`shoppingcart_creditcardID`),
  CONSTRAINT `shoppingcart_creditcardID` FOREIGN KEY (`shoppingcart_creditcardID`) REFERENCES `creditcard` (`creditcardID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shoppingcart_customerID` FOREIGN KEY (`shoppingcart_customerID`) REFERENCES `customer` (`customerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2014-11-26 11:05:45
