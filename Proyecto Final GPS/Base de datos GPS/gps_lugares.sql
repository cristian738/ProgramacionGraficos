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
-- Table structure for table `lugares`
--

DROP TABLE IF EXISTS `lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lugares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `imagen` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugares`
--

LOCK TABLES `lugares` WRITE;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
INSERT INTO `lugares` VALUES (1,'LENGUAS','EN ESTE EDIFICIO ENCONTRARAS LAS CLASES DE LOS DIVERSOS IDIOMAS','/Imagenes/lenguas.jpg'),(2,'ENTRADA(GLORIETA)','ENTRADA DE LA UNIVERSIDAD AUTONOMAS DE BAJA CALIFORNIA SUR.','/Imagenes/entrada(glorieta).jpg'),(3,'AREA DEPORTIVA','ENCONTRARAS LAS CANCHAS DE FUTBOL Y OTROS ACTIVIDADES DEPORTIVAS','/Imagenes/area deportiva.jpg'),(4,'POLIFORO','EL EDIFICIO DONDE HACEN DIFERENTES ACTIVIDADES CREATIVAS','/Imagenes/poliforo.jpg'),(5,'MACROCENTRO','EDIFICIO DONDE PRESTAMO DE COMPUTADORAS PARA TUS TAREAS','/Imagenes/macrocentro.jpg'),(6,'LIBRERIA','AQUI COMPRAR TUS LIBROS FAVORITOS','/Imagenes/Libreria.jpg'),(7,'BIBLIOTECA','AREA PARA HACER TUS TAREAS Y ACTIVIDADES ESCOLARES Y PRESTAMO DE LIBROS','/Imagenes/biblioteca.jpg'),(8,'RECTORIA','PODEMOS ENCONTRARA CAJA DE PAGOS ESCOLARES','/Imagenes/rectoria.jpg'),(9,'SERVICIOS MEDICOS ','AQUI TE PODRAN DAR SERVICIOS MEDICOS POR SI SUFRES ALGUN ACCIDENTE(GRATIS)','/Imagenes/servicios medicos.jpg'),(10,'RADIO Y DIFUSION','EDIFICIO DONDE SE TRASMITE RADIO UABCS','/Imagenes/radio.jpg'),(11,'PARADA1','TRASPORTE PUBLICO Y PRIVADO','/Imagenes/parada num 1.jpg'),(12,'SERVICIOS ESCOLARES','AQUI PODRAS CONSULTAR CUALQUIER DUDA SOBRE TU CARERA','/Imagenes/servicios escolares.jpg'),(13,'SISTEMAS(DAS)','DEPARTAMENTO DE SISTEMAS COMPUTACIONALES CARRERADE LICENCIATURA EN SISTEMAS Y INGENIERIA EN SISTEMAS','/imagenes/');
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
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
