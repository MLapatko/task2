-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: soundrecorder
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `solo_music`
--

DROP TABLE IF EXISTS `solo_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solo_music` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text NOT NULL,
  `COMPOSER` text NOT NULL,
  `TIME` int(11) NOT NULL,
  `WORDS_AUTHER` text NOT NULL,
  `SINGER` text NOT NULL,
  `VOCAL_TYPE` text NOT NULL,
  `ACCOMPANIMENT` text NOT NULL,
  `DISK` text NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solo_music`
--

LOCK TABLES `solo_music` WRITE;
/*!40000 ALTER TABLE `solo_music` DISABLE KEYS */;
INSERT INTO `solo_music` VALUES (1,'Куплеты Мефистофеля','Шарль Гуно',1520,'Шарль Гуно','Федор Шаляпин','бас','хор и оркестр Большого театра','off'),(2,'Блоха','М. П. Мусоргский',1050,'В. И. Гёте','Федор Шаляпин','бас','без сопровождения','on'),(3,'Маскарад','М. Магомаева',77,'И. Шаферан','М. Магомаева','баритон','эстрадно-симфонический оркестр Всесоюзного радио и Центрального телевидения','on');
/*!40000 ALTER TABLE `solo_music` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25 17:40:09
