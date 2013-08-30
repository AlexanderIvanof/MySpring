-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_db
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_Contact_1` (`first_name`,`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'Alex','Bay','1985-03-04'),
							 (2,'Mat','Groening','1960-11-13'),
							 (3,'Bill','Murrey','1970-12-22'),
							 (4,'Ann','McDee','1982-10-30'),
							 (5,'Jay','Getsby','1980-01-23');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_tel_detail`
--

DROP TABLE IF EXISTS `contact_tel_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_tel_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `tel_type` varchar(20) NOT NULL,
  `tel_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_CONTACT_TEL_TYPE` (`contact_id`,`tel_type`),
  KEY `FK_CONTACT_TEL_DETAIL_idx` (`contact_id`),
  CONSTRAINT `FK_CONTACT_TEL_DETAIL` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_tel_detail`
--

LOCK TABLES `contact_tel_detail` WRITE;
/*!40000 ALTER TABLE `contact_tel_detail` DISABLE KEYS */;
INSERT INTO `contact_tel_detail` VALUES (1,1,'Mobile','(067)109-02-02'),
										(2,2,'Home','(044)234-12-20'),
										(3,2,'Mobile','(063)422-34-65'),
										(4,3,'Home','(044)123-56-78'),
										(5,3,'Work','(054)230-26-64'),
										(6,1,'Work','(044)223-76-87'),
										(7,1,'Home','(0542)60-21-38');
/*!40000 ALTER TABLE `contact_tel_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-30 11:23:01
