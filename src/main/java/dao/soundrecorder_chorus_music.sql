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
-- Table structure for table `chorus_music`
--

DROP TABLE IF EXISTS `chorus_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chorus_music` (
  `ID` int(11) NOT NULL,
  `NAME` text NOT NULL,
  `COMPOSER` text NOT NULL,
  `TIME` int(11) NOT NULL,
  `WORDS_AUTHER` text NOT NULL,
  `SINGER` text NOT NULL,
  `ACCOMPANIMENT` text NOT NULL,
  `CHORUS_TYPE` text NOT NULL,
  `DISK` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chorus_music`
--

LOCK TABLES `chorus_music` WRITE;
/*!40000 ALTER TABLE `chorus_music` DISABLE KEYS */;
INSERT INTO `chorus_music` VALUES (1111,'Выйду ночью в поле с конём\r\n','Игорь Матвиенко',272,'Александр Шаганов','Хор Сретенского монастыря','нет','народный хор ','on'),(1112,'Казачий край','А. Заволокина',206,'А. Заволокина','Кубанский казачий хор','Кубанский казачий хор','народный хор','off'),(1113,'Баллада о солдате','Соловьев-Седой В.',372,'Матусовский М.','Академический ансамбль песни и пляски Российской Армии имени А. В. Александрова','Академический ансамбль песни и пляски Российской Армии имени А. В. Александрова','академический хор','on');
/*!40000 ALTER TABLE `chorus_music` ENABLE KEYS */;
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
