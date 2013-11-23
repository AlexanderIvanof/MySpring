-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: log
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
-- Table structure for table `log4j_tbl`
--

DROP TABLE IF EXISTS `log4j_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log4j_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `level` varchar(6) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `logger` varchar(50) NOT NULL,
  `message` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log4j_tbl`
--

LOCK TABLES `log4j_tbl` WRITE;
/*!40000 ALTER TABLE `log4j_tbl` DISABLE KEYS */;
INSERT INTO `log4j_tbl` VALUES (1,'?{x}','?{p}','2013-09-05 11:41:58','?{C}.?{M}:?{L}','?{m}'),(2,'','ERROR','2013-09-05 11:42:51','?{C}.?{M}:?{L}','?{m}'),(3,'','ERROR','2013-09-05 11:43:52','com.alex.spring.run.ASD.main:30','hello error'),(4,'','ERROR','2013-09-05 11:53:50','com.alex.spring.run.ASD.main:31','hello error'),(5,'','ERROR','2013-09-05 12:02:01','com.alex.spring.run.ASD.main:31','hello error'),(6,'','ERROR','2013-09-05 12:02:02','com.alex.spring.run.ASD.main:35','java.lang.RuntimeException: in exception'),(7,'','ERROR','2013-09-05 12:15:33','com.alex.spring.run.ASD.main:32','hello error'),(8,'','ERROR','2013-09-05 12:15:33','com.alex.spring.run.ASD.main:36','java.lang.RuntimeException: in exception'),(9,'','FATAL','2013-09-05 12:15:33','com.alex.spring.run.ASD.main:39','fatal level with exception'),(10,'','WARN','2013-09-05 12:20:33','com.alex.spring.run.ASD.main:33','This is warn'),(11,'','ERROR','2013-09-05 12:20:34','com.alex.spring.run.ASD.main:38','java.lang.RuntimeException: in exception'),(12,'','INFO','2013-09-05 12:20:34','com.alex.spring.run.ASD.main:40','Close sldld'),(13,'','FATAL','2013-09-05 12:20:34','com.alex.spring.run.ASD.main:41','fatal level with exception');
/*!40000 ALTER TABLE `log4j_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_table`
--

DROP TABLE IF EXISTS `log_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_table`
--

LOCK TABLES `log_table` WRITE;
/*!40000 ALTER TABLE `log_table` DISABLE KEYS */;
INSERT INTO `log_table` VALUES (1,'Change row in Employee id=3 in field \'salary\' from \"1500.0\" to \"1500.0\"'),(2,'Change row in Employee id=3 in field \'salary\' from \"1500.0\" to \"1500.0\"'),(3,'Change row in Employee id=3 in field \'salary\' from \"1500.0\" to \"1500.0\"'),(4,'Change row in Employee id=3 in field \'salary\' from \"1500.0\" to \"1500.0\"');
/*!40000 ALTER TABLE `log_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-06 15:58:35
