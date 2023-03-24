-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: empdb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `billid` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `date` date DEFAULT NULL,
  `servicetype` varchar(255) DEFAULT NULL,
  `tax` int NOT NULL,
  `totalamount` int NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`billid`),
  KEY `FKowmv0xm2q2a32wkjrcqr27oon` (`userid`),
  CONSTRAINT `FKowmv0xm2q2a32wkjrcqr27oon` FOREIGN KEY (`userid`) REFERENCES `registration` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caterer`
--

DROP TABLE IF EXISTS `caterer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caterer` (
  `catererid` int NOT NULL AUTO_INCREMENT,
  `capacity` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `item` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `rate` double NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`catererid`),
  KEY `FK9s7752fwv3865ldiktf8h367o` (`serviceid`),
  CONSTRAINT `FK9s7752fwv3865ldiktf8h367o` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caterer`
--

LOCK TABLES `caterer` WRITE;
/*!40000 ALTER TABLE `caterer` DISABLE KEYS */;
INSERT INTO `caterer` VALUES (1,'1000','pure veg food',' ','annapoorna',10000,2);
/*!40000 ALTER TABLE `caterer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dateandtime`
--

DROP TABLE IF EXISTS `dateandtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dateandtime` (
  `dateandtimeid` int NOT NULL AUTO_INCREMENT,
  `enddate` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `startdate` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dateandtimeid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dateandtime`
--

LOCK TABLES `dateandtime` WRITE;
/*!40000 ALTER TABLE `dateandtime` DISABLE KEYS */;
INSERT INTO `dateandtime` VALUES (1,'2023-03-09','13:23','2023-03-16','15:22'),(2,NULL,NULL,NULL,NULL),(3,'2023-03-04','22:40','2023-03-01','06:41'),(4,NULL,NULL,NULL,NULL),(5,'2023-03-09','23:50','2023-03-08','20:50'),(6,NULL,NULL,NULL,NULL),(7,'2023-03-09','20:03','2023-03-08','07:03'),(8,NULL,NULL,NULL,NULL),(9,'2023-03-05','22:30','2023-03-05','19:22'),(10,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `dateandtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decoration`
--

DROP TABLE IF EXISTS `decoration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decoration` (
  `decorationid` int NOT NULL AUTO_INCREMENT,
  `categorytype` varchar(255) NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`decorationid`),
  KEY `FKcldil03h9l36bu4mmgxsp566r` (`serviceid`),
  CONSTRAINT `FKcldil03h9l36bu4mmgxsp566r` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decoration`
--

LOCK TABLES `decoration` WRITE;
/*!40000 ALTER TABLE `decoration` DISABLE KEYS */;
INSERT INTO `decoration` VALUES (1,'Light',3),(2,'Flower',3),(3,'Makeup',3);
/*!40000 ALTER TABLE `decoration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `eventid` int NOT NULL AUTO_INCREMENT,
  `eventtype` varchar(255) NOT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Wedding'),(2,'Birthday'),(3,'Party'),(4,'Consert'),(5,'Business'),(6,'Festival'),(7,'Exhibition'),(8,'Convention'),(9,'Seminar'),(10,'Family Function'),(11,'Hybrid Event');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventservicelist`
--

DROP TABLE IF EXISTS `eventservicelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventservicelist` (
  `eventid` int NOT NULL,
  `serviceid` int NOT NULL,
  KEY `FKsyygc74e1n81bhuk1j6gw6lha` (`serviceid`),
  KEY `FKon694h6hqmtoc5rse2myyuqsv` (`eventid`),
  CONSTRAINT `FKon694h6hqmtoc5rse2myyuqsv` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`),
  CONSTRAINT `FKsyygc74e1n81bhuk1j6gw6lha` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventservicelist`
--

LOCK TABLES `eventservicelist` WRITE;
/*!40000 ALTER TABLE `eventservicelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventservicelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedbackid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`feedbackid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firecrackers`
--

DROP TABLE IF EXISTS `firecrackers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firecrackers` (
  `firecrackersid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`firecrackersid`),
  KEY `FKeap9wgktr5v2tgom75png2pk4` (`serviceid`),
  CONSTRAINT `FKeap9wgktr5v2tgom75png2pk4` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firecrackers`
--

LOCK TABLES `firecrackers` WRITE;
/*!40000 ALTER TABLE `firecrackers` DISABLE KEYS */;
INSERT INTO `firecrackers` VALUES (1,'firecrackers services','karan firecrackers',1000,'all',9);
/*!40000 ALTER TABLE `firecrackers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flower`
--

DROP TABLE IF EXISTS `flower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flower` (
  `flowerid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) NOT NULL,
  `decorationid` int DEFAULT NULL,
  PRIMARY KEY (`flowerid`),
  KEY `FKemxlsic6m5qhig9rsp751ses` (`decorationid`),
  CONSTRAINT `FKemxlsic6m5qhig9rsp751ses` FOREIGN KEY (`decorationid`) REFERENCES `decoration` (`decorationid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flower`
--

LOCK TABLES `flower` WRITE;
/*!40000 ALTER TABLE `flower` DISABLE KEYS */;
INSERT INTO `flower` VALUES (1,'flower services for wedding','bramha flowers ',5000,'wedding',2);
/*!40000 ALTER TABLE `flower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hall` (
  `hallid` int NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`hallid`),
  KEY `FKl7ywfxjsfud06fr59jj5ygr51` (`serviceid`),
  CONSTRAINT `FKl7ywfxjsfud06fr59jj5ygr51` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,800,'wedding hall','krishna lawns',50000,1),(2,1000,'hall for all type of event on rent','vr hall',40000,11);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horse`
--

DROP TABLE IF EXISTS `horse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horse` (
  `horseid` int NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`horseid`),
  KEY `FK1ai9tq0ys6veyogq7luvvlc6` (`serviceid`),
  CONSTRAINT `FK1ai9tq0ys6veyogq7luvvlc6` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horse`
--

LOCK TABLES `horse` WRITE;
/*!40000 ALTER TABLE `horse` DISABLE KEYS */;
INSERT INTO `horse` VALUES (1,'black','best horse services in pune','Dikesh horse services ',10000,6);
/*!40000 ALTER TABLE `horse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `light` (
  `lightid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `decorationid` int DEFAULT NULL,
  PRIMARY KEY (`lightid`),
  KEY `FK8mm8b1so2q5142wneykuqhbkm` (`decorationid`),
  CONSTRAINT `FK8mm8b1so2q5142wneykuqhbkm` FOREIGN KEY (`decorationid`) REFERENCES `decoration` (`decorationid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
INSERT INTO `light` VALUES (1,'light services for wedding ','bramha lights ',10000,'wedding',1);
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makeup`
--

DROP TABLE IF EXISTS `makeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `makeup` (
  `makeupid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `decorationid` int DEFAULT NULL,
  PRIMARY KEY (`makeupid`),
  KEY `FK30880b8rvi1pgw63pfub3owf8` (`decorationid`),
  CONSTRAINT `FK30880b8rvi1pgw63pfub3owf8` FOREIGN KEY (`decorationid`) REFERENCES `decoration` (`decorationid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makeup`
--

LOCK TABLES `makeup` WRITE;
/*!40000 ALTER TABLE `makeup` DISABLE KEYS */;
INSERT INTO `makeup` VALUES (1,'wedding makeup services ','bramha makup',2000,'wedding',3);
/*!40000 ALTER TABLE `makeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicsystem`
--

DROP TABLE IF EXISTS `musicsystem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicsystem` (
  `musicsystemid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `musicsystemname` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`musicsystemid`),
  KEY `FKrfieepgepmi0rbg6ti1omwu70` (`serviceid`),
  CONSTRAINT `FKrfieepgepmi0rbg6ti1omwu70` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicsystem`
--

LOCK TABLES `musicsystem` WRITE;
/*!40000 ALTER TABLE `musicsystem` DISABLE KEYS */;
INSERT INTO `musicsystem` VALUES (1,'best Dj services for events','akshay DJ services',50000,5);
/*!40000 ALTER TABLE `musicsystem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `count` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `ordernumber` varchar(255) DEFAULT NULL,
  `servicetype` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `datetimeid` int DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FKm8ldgnd1qc65dwqueob28958w` (`datetimeid`),
  CONSTRAINT `FKm8ldgnd1qc65dwqueob28958w` FOREIGN KEY (`datetimeid`) REFERENCES `dateandtime` (`dateandtimeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,2,'bp@gmail.com','EMP001','caterer','pending',2),(2,2,'suraj.wable13@gmail.com','EMP001','photography','pending',4),(3,2,'suraj.wable13@gmail.com','EMP001','musicsystem','pending',6),(4,2,'suraj.wable13@gmail.com','EMP001','photography','pending',8),(5,2,'sw@gmail.com','EMP001','caterer','pending',10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentid` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `paidamount` double NOT NULL,
  `paymentdate` datetime(6) DEFAULT NULL,
  `totalamount` double NOT NULL,
  `billid` int DEFAULT NULL,
  PRIMARY KEY (`paymentid`),
  KEY `FK11qy73js2eheuoa5wlgm9jblw` (`billid`),
  CONSTRAINT `FK11qy73js2eheuoa5wlgm9jblw` FOREIGN KEY (`billid`) REFERENCES `bill` (`billid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photography`
--

DROP TABLE IF EXISTS `photography`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photography` (
  `photographyid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`photographyid`),
  KEY `FKot45eguccdl2fkm8f2a29oy1` (`serviceid`),
  CONSTRAINT `FKot45eguccdl2fkm8f2a29oy1` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photography`
--

LOCK TABLES `photography` WRITE;
/*!40000 ALTER TABLE `photography` DISABLE KEYS */;
INSERT INTO `photography` VALUES (1,'photography services for all types of events','beauty photography services',12000,'all',10);
/*!40000 ALTER TABLE `photography` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poojavidhi`
--

DROP TABLE IF EXISTS `poojavidhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poojavidhi` (
  `poojavidhiid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`poojavidhiid`),
  KEY `FK7nnywjhsv00qoblgwygd2fdcu` (`serviceid`),
  CONSTRAINT `FK7nnywjhsv00qoblgwygd2fdcu` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poojavidhi`
--

LOCK TABLES `poojavidhi` WRITE;
/*!40000 ALTER TABLE `poojavidhi` DISABLE KEYS */;
INSERT INTO `poojavidhi` VALUES (1,'poojavidhi services for all type of rituals','Shirish poojavidhi services ',1000,'all',8);
/*!40000 ALTER TABLE `poojavidhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contactnumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `pincode` int NOT NULL,
  `reenterpassword` varchar(255) NOT NULL,
  `registerdate` date DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `UK_pqp6404l2ndskpsr1xx8eaa68` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'sangli','sangli','9866553323','pp@gmail.com','pritam','patil','pp@123',413703,'pp@123','2023-03-09','vendor','maharashtra'),(2,'miraj','sangli','7878787878','sp@gmail.com','sourabh','patil','sp@123',413703,'sp@123','2023-03-09','vendor','maharashtra'),(3,'karmala','karmala','7366553323','bb@gmail.com','baba','bhise','bb@123',413703,'bb@123','2023-03-09','vendor','maharashtra'),(4,'suregaon','nagar','9090909090','as@gmail.com','akashay','shinede','as@123',413703,'as@123','2023-03-09','vendor','maharastra'),(5,'janwadi','pune','9898989898','dd@gmail.com','dikesh','ekka','dd@123',422001,'dd@123','2023-03-09','vendor','maharashtra'),(6,'Madhya Pradesh','Bhopal','8956214535','aa@gmail.com','arvind','singh','aa@123',456213,'aa@123','2023-03-09','vendor','MP'),(7,'Madhya Pradhesh','Bhopal','8954547412','ss@gmail.com','Shirish','shrivastava','ss@123',456213,'ss@123','2023-03-09','vendor','MP'),(8,'akola','Nagar','9595856545','kk@gmail.com','karan','nikam','kk@123',422608,'kk@123','2023-03-09','vendor','maharashtra'),(13,'pune','pune','9898585865','sw@gmail.com','suraj','wakure','sw@123',455589,'sw@123','2023-03-09','user','maharashtra'),(14,'padali','satara','8830626297','kn@gmail.com','kshitij','nanaware','kn@123',415521,'kn@123','2023-03-09','vendor','maharastra'),(15,'dhule','dhule','9898789878','bp@gmail.com','bhagyesh ','patil','bp@123',456856,'bp@123','2023-03-09','user','maharashtra'),(16,'pune','pune','8598987858','pn@gmail.com','parag','nukulwar','pn@123',455877,'pn@123','2023-03-09','vendor','maharashtra'),(17,'pune','pune','9762570972','suraj.wable13@gmail.com','suraj','wable','1234',422009,'1234','2023-03-09','user','maharashtra');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `serviceid` int NOT NULL AUTO_INCREMENT,
  `image` longblob,
  `location` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `servicename` varchar(255) DEFAULT NULL,
  `servicetype` varchar(255) NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`serviceid`),
  KEY `FK9vlshd210kysn1l8xja2nb38q` (`userid`),
  CONSTRAINT `FK9vlshd210kysn1l8xja2nb38q` FOREIGN KEY (`userid`) REFERENCES `registration` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'','pune','parag Nukulwar','krishna hall','Hall',16),(2,'','pune','pritam patil','annpoorna catering services','Caterer',1),(3,'','pune','saurabh patil','bramha decoration services','Decoration',2),(4,'','pune','baba bhise','life water services','WaterSupply',3),(5,'','pune','Akshay Shinde','akshay Dj services','MusicSystem',4),(6,'','pune','Dikesh Ekka ','Dikesh Horse Services','Horse',5),(7,'','Pune','Arvind Singh','Arvind Transportation services','Transportation',6),(8,'','pune','Shirish Shrivastava','shirish poojavidhi services ','Poojavidhi',7),(9,'','pune','Karan nikam','Karan firecrackers services ','Firecrackers',8),(10,'','pune','kshitij nanavare','beauty photography services','Photography',14),(11,'','nagar','vaibhav rode','rodeservice','Hall',1);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transportation` (
  `transportationid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`transportationid`),
  KEY `FKperxmfwsu920il90p5ydhydg4` (`serviceid`),
  CONSTRAINT `FKperxmfwsu920il90p5ydhydg4` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportation`
--

LOCK TABLES `transportation` WRITE;
/*!40000 ALTER TABLE `transportation` DISABLE KEYS */;
INSERT INTO `transportation` VALUES (1,'transportation services for wedding ','Arvind Transportation services',1200,'wedding',7);
/*!40000 ALTER TABLE `transportation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watersupply`
--

DROP TABLE IF EXISTS `watersupply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watersupply` (
  `watersupplyid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int NOT NULL,
  `rate` double NOT NULL,
  `serviceid` int DEFAULT NULL,
  PRIMARY KEY (`watersupplyid`),
  KEY `FKjef75kx1g80sh2u8t0xv2pnay` (`serviceid`),
  CONSTRAINT `FKjef75kx1g80sh2u8t0xv2pnay` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watersupply`
--

LOCK TABLES `watersupply` WRITE;
/*!40000 ALTER TABLE `watersupply` DISABLE KEYS */;
INSERT INTO `watersupply` VALUES (1,'water supplier services ','life water suppliers services ',100,500,4);
/*!40000 ALTER TABLE `watersupply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-10 19:44:32
