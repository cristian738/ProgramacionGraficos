CREATE DATABASE  IF NOT EXISTS `gps` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gps`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: gps
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `nodo`
--

DROP TABLE IF EXISTS `nodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nodo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dato` varchar(100) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodo`
--

LOCK TABLES `nodo` WRITE;
/*!40000 ALTER TABLE `nodo` DISABLE KEYS */;
INSERT INTO `nodo` VALUES (1,'poliforo',196,37),(2,'aux1',187,80),(3,'macrocentro',158,78),(4,'aux2',187,111),(5,'dsc',142,106),(6,'servicios escolares',117,101),(7,'aux3',187,141),(8,'aux4',187,125),(9,'radio',209,128),(10,'aux5',187,137),(11,'servicios medicos',191,164),(12,'aux6',187,180),(13,'biblioteca',126,164),(14,'libreria',138,107),(15,'rectoria',116,236),(16,'lenguas',112,313),(17,'aux7',145,284),(18,'aux8',164,289),(19,'aux9',249,303),(20,'aux10',236,339),(21,'cafeteria',342,355),(22,'aux11',343,338),(23,'aux12',307,342),(24,'agropecuaria',312,313),(25,'sociales V',413,321),(26,'aux13',254,253),(27,'ciencias del mar',290,254),(28,'sociales B',306,123),(29,'aux14',263,224),(30,'aux15',224,195),(31,'aux17',303,250),(32,'aux16',338,337),(33,'gym',413,132),(34,'aux18',413,157),(35,'aux20',459,167),(36,'aux19',442,252),(37,'ciencias politicas',477,259),(38,'humanidades',497,173),(39,'aux21',480,149),(40,'aux22',461,150),(41,'aux23',425,110),(42,'derecho',558,122);
/*!40000 ALTER TABLE `nodo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-22  3:01:25
