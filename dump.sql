-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `status` int(11) NOT NULL,
  `applicationscol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` VALUES (1,'mail@mail.ru',0,NULL),(2,'mail@mail.ru',0,NULL),(3,'mail@mail.ru',0,NULL),(4,'mmay83661@gmail.com',0,NULL),(5,'mmay83661@gmail.com',0,NULL),(6,'asdasdasd@hzgfhfsdjh.ru',0,NULL),(7,'mmay83661@gmail.com',0,NULL);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id_cars` int(11) NOT NULL AUTO_INCREMENT,
  `car_model` varchar(45) NOT NULL,
  `vin` varchar(17) NOT NULL,
  `lot_crashes` int(3) NOT NULL,
  `Cars_category_id_cat` int(11) DEFAULT NULL,
  `fk_id_sit_weather` int(11) DEFAULT NULL,
  `fk_id_sit_crash` int(11) DEFAULT NULL,
  `birthdate` date NOT NULL,
  `car_category` varchar(45) DEFAULT NULL,
  `capacity` varchar(45) DEFAULT NULL,
  `trailer` varchar(45) DEFAULT NULL,
  `danger_cargo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cars`),
  KEY `fk_Cars_Cars_category_idx` (`Cars_category_id_cat`),
  KEY `fk_Cars_Situations_weather1_idx` (`fk_id_sit_weather`),
  KEY `fk_Cars_Situations_car1_idx` (`fk_id_sit_crash`),
  CONSTRAINT `fk_Cars_Cars_category` FOREIGN KEY (`Cars_category_id_cat`) REFERENCES `cars_category` (`id_cat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cars_Situations_car1` FOREIGN KEY (`fk_id_sit_crash`) REFERENCES `situations_car` (`id_sit_crash`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cars_Situations_weather1` FOREIGN KEY (`fk_id_sit_weather`) REFERENCES `situations_weather` (`id_sit_weather`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'123','123',123,NULL,NULL,NULL,'0000-00-00',NULL,NULL,NULL,NULL),(2,'231','123',1,NULL,NULL,NULL,'0000-00-00',NULL,NULL,NULL,NULL),(3,'123','123',1,NULL,NULL,NULL,'2020-12-11','1','2','д','д'),(4,'123','123',1,NULL,NULL,NULL,'2012-12-11','12','12','н','н');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars_category`
--

DROP TABLE IF EXISTS `cars_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars_category` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `car_category` varchar(45) NOT NULL,
  `capacity` int(3) NOT NULL,
  `trailer` tinyint(1) NOT NULL,
  `danger_cargo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars_category`
--

LOCK TABLES `cars_category` WRITE;
/*!40000 ALTER TABLE `cars_category` DISABLE KEYS */;
INSERT INTO `cars_category` VALUES (1,'132',12,1,1);
/*!40000 ALTER TABLE `cars_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `situations_car`
--

DROP TABLE IF EXISTS `situations_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `situations_car` (
  `id_sit_crash` int(11) NOT NULL AUTO_INCREMENT,
  `number_crash` int(15) NOT NULL,
  `number_of_cars` varchar(45) NOT NULL,
  `service` tinyint(1) NOT NULL,
  `geolocation` varchar(45) NOT NULL,
  `tame_of_crash` datetime NOT NULL,
  `fk_id_type` int(11) NOT NULL,
  PRIMARY KEY (`id_sit_crash`),
  KEY `fk_Situations_car_Type_of_road1_idx` (`fk_id_type`),
  CONSTRAINT `fk_Situations_car_Type_of_road1` FOREIGN KEY (`fk_id_type`) REFERENCES `type_of_road` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `situations_car`
--

LOCK TABLES `situations_car` WRITE;
/*!40000 ALTER TABLE `situations_car` DISABLE KEYS */;
/*!40000 ALTER TABLE `situations_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `situations_weather`
--

DROP TABLE IF EXISTS `situations_weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `situations_weather` (
  `id_sit_weather` int(11) NOT NULL AUTO_INCREMENT,
  `number_situation` int(15) DEFAULT NULL,
  `service` tinytext NOT NULL,
  `area` varchar(200) NOT NULL,
  `area_radius` int(6) DEFAULT NULL,
  `time_of_detect` datetime NOT NULL,
  `Situations_weathercol` varchar(45) NOT NULL,
  `fk_id_type` int(11) DEFAULT NULL,
  `tip` varchar(45) NOT NULL,
  `count_cars` int(5) DEFAULT NULL,
  `road_quality` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_sit_weather`),
  KEY `fk_Situations_weather_Type_of_road1_idx` (`fk_id_type`),
  CONSTRAINT `fk_Situations_weather_Type_of_road1` FOREIGN KEY (`fk_id_type`) REFERENCES `type_of_road` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `situations_weather`
--

LOCK TABLES `situations_weather` WRITE;
/*!40000 ALTER TABLE `situations_weather` DISABLE KEYS */;
INSERT INTO `situations_weather` VALUES (1,NULL,'д','123',123,'2002-03-03 21:00:00','123',NULL,'ш',123,NULL),(2,NULL,'н','корд',5,'1212-11-30 21:00:00','что произашло',NULL,'ш',5555,'');
/*!40000 ALTER TABLE `situations_weather` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tip` varchar(45) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id_idx` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'',0),(2,'good',0),(3,'good',0),(4,'1',0),(5,'sda',0);
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_of_road`
--

DROP TABLE IF EXISTS `type_of_road`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_of_road` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `highway` tinyint(1) DEFAULT NULL,
  `dirt_road` tinyint(1) DEFAULT NULL,
  `road` tinyint(1) DEFAULT NULL,
  `city` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_of_road`
--

LOCK TABLES `type_of_road` WRITE;
/*!40000 ALTER TABLE `type_of_road` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_of_road` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-08 17:19:07
