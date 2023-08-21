CREATE DATABASE  IF NOT EXISTS `admindb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `admindb`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: admindb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `sID` varchar(10) NOT NULL,
  `sName` varchar(4) DEFAULT NULL,
  `sPassword` varchar(10) DEFAULT NULL,
  `gender` enum('B','W') NOT NULL,
  `eMail` varchar(30) DEFAULT NULL,
  `sPhone` int DEFAULT NULL,
  `sMemo` varchar(100) DEFAULT NULL,
  `sRoom` varchar(4) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  `sTmpRoom` int DEFAULT NULL,
  `sContactP` varchar(10) DEFAULT NULL,
  `sCPPhone` int DEFAULT NULL,
  PRIMARY KEY (`sID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('2222','王寶強','2222','B','yukion614@gmail.com',981724670,'ffe','101','2022-06-06 22:15:55',105,NULL,NULL),('3333','3333','3333','W','helllo@gmail',981724670,'ffffffffffffffffffffffffff','103','2022-06-06 22:06:21',103,NULL,NULL),('aaaa','賴永宏','1111','B','yukion614@gmail.com',981724670,'dewee','101','2022-05-25 16:20:20',101,NULL,NULL),('dddd','賴永宏','1111','B','yukion614@gmail.com',981724670,'ee','101','2022-05-25 16:22:08',101,NULL,NULL),('dsds','fff','ddd','B','yukion614@gmail.com',981724670,'ee','105','2022-06-06 22:07:00',105,NULL,NULL),('komami','蔡小英','12345678','W','bba@yahoo.com.yw',987654,'iam a presant',NULL,NULL,NULL,NULL,NULL),('lloi90','賴永宏','1234','W','helllo@gmail',981724670,'',NULL,'2022-06-06 23:00:44',105,NULL,NULL),('namiki00','王大天','0223670939','B','yukion614@gmail.com',981724670,'天天星期天',NULL,NULL,NULL,NULL,NULL),('zzzz','阿寶強','zzzz','B','yukion614@gmail.com',981724670,'','101','2022-05-25 16:48:04',101,NULL,NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22 22:50:44
