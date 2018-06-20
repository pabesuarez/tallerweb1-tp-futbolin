-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: futbolin
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `cupos`
--

DROP TABLE IF EXISTS `cupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `posicion` varchar(255) DEFAULT NULL,
  `partido_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo8byi2s26wkhv09qo0lm6j5rf` (`partido_id`),
  KEY `FK9xmts2dch9gno7l2uj55tlyxl` (`usuario_id`),
  CONSTRAINT `FK9xmts2dch9gno7l2uj55tlyxl` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKo8byi2s26wkhv09qo0lm6j5rf` FOREIGN KEY (`partido_id`) REFERENCES `partido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupos`
--

LOCK TABLES `cupos` WRITE;
/*!40000 ALTER TABLE `cupos` DISABLE KEYS */;
INSERT INTO `cupos` VALUES (1,'delantero',1,NULL,0),(2,'defensor',1,NULL,0),(3,'medio',2,NULL,0),(4,'delantero',2,NULL,0),(5,'defensor',3,NULL,0),(6,'medio',3,NULL,0),(7,'delantero',4,NULL,0),(8,'defensor',4,NULL,0);
/*!40000 ALTER TABLE `cupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `geolocalizacion` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,'arieta','San Justo',1111,'Buenos Aires','              -34.664508,-58.579484','argentina'),(2,'san martin','Lomas del Mirador',3500,'Buenos Aires','              -34.669794,-58.532591','argentina'),(3,'almafuerte','Villa Luzuriaga',324,'Buenos Aires','              -34.658316,-58.585631','argentina'),(4,'mosconi','Lomas Del Mirador',980,'Buenos Aires','              -34.663163,-58.5377','argentina'),(5,'arieta','San Justo',2222,'Buenos Aires','              -34.671064,-58.570492','argentina');
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nombreCancha` varchar(255) DEFAULT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `organizador_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbi4kjwt8ehbh90c6edrol2nj2` (`direccion_id`),
  KEY `FKonrphkgn152gueiu5okxodlls` (`organizador_id`),
  CONSTRAINT `FKbi4kjwt8ehbh90c6edrol2nj2` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`),
  CONSTRAINT `FKonrphkgn152gueiu5okxodlls` FOREIGN KEY (`organizador_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,'descripcion del partido','2018-06-15','canchita1',1,3),(2,'descripcion del partido','2018-06-15','canchita2',2,4),(3,'descripcion del partido','2018-06-15','canchita3',3,3),(4,'descripcion del partido','2018-06-15','canchita4',4,2);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'fulanito','usuario1@usuario.com','cosme','1234','rol1'),(2,'thompson','usuario2@usuario.com','homero','1234','rol1'),(3,'landa','usuario3@usuario.com','lalo','1234','rol1'),(4,'barreda','usuario4@usuario.com','armando','1234','rol1');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 17:36:47
