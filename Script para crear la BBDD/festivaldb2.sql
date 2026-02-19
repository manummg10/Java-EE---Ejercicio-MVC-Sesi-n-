CREATE DATABASE  IF NOT EXISTS `festivaldb2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `festivaldb2`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: festivaldb2
-- ------------------------------------------------------
-- Server version	5.6.39-log

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
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `eventoId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `lugar` varchar(45) NOT NULL,
  `duracion` varchar(45) NOT NULL,
  `tipoEvento` varchar(45) NOT NULL,
  `asientosDisp` int(10) unsigned NOT NULL,
  PRIMARY KEY (`eventoId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,'Concierto Metalica','World Tour 2024','Madrid','3 horas','Música',67),
(2,'Concierto ACDC','Hellfest 2024','Francia','3 horas','Música',130),
(3,'Concierto Iron Maiden','World Tour 2024','Australia','2 horas','Música',310),
(4,'Concierto Guns N Roses','Concierto Gira 2023','Denver','2 horas','Música',400),
(5,'Concierto WarCry','Daimon Tour 2023','Madrid','3 horas','Música',20),
(6,'Concierto Tierra Santa','Presentación nuevo album','Madrid','2 horas','Música',40),
(7,'Concierto Baron Rojo','XI Zombie Jaialdia Fest C.C.','Donostia','2 horas','Música',200),
(8,'Concierto Mago de Oz','Tour 35 Aniversario','Los Angeles','2 horas','Música',500),
(9,'Concierto Medina Azahara','Gira LLego el día','Cadiz','3 horas','Música',10);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroEventos`
--

DROP TABLE IF EXISTS `registroEventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registroEventos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `eventoId` int(10) unsigned NOT NULL,
  `usuarioId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eregistroEventos_1` (`eventoId`),
  KEY `FK_registroEventosp_2` (`usuarioId`),
  CONSTRAINT `FK_registroEventos_1` FOREIGN KEY (`eventoId`) REFERENCES `eventos` (`eventoId`),
  CONSTRAINT `FK_registroEventos_2` FOREIGN KEY (`usuarioId`) REFERENCES `usuarios` (`usuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroEventos`
--

LOCK TABLES `registroEventos` WRITE;
/*!40000 ALTER TABLE `registroEventos` DISABLE KEYS */;
INSERT INTO `registroEventos` VALUES (19,1,1),(21,3,1),(25,3,6),(26,2,6);
/*!40000 ALTER TABLE `registroEventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `usuarioId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `usuario` varchar(12) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Ana','Lozano','00.000.000-T','alozano@accenture.com','1122334455','La Finca 2','alozano','qwerty'),
(2,'Fumi','De Morata','11.111.111-H','fmorata@accenture.com','112233445566','La Cama','fmorata','cubata'),
(6,'Emilio','Robles','11.111.111-H','erobles@accenture.com','+3456712312312','La Finca Formación','erobles','qwerty'),
(7,'Rebeca','Velasco','22.222.222-J','rvelasco@accenture.com','341122334455','La Finca Training','rvelasco','qwerty');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-10 16:58:53
