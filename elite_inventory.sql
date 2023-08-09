CREATE DATABASE  IF NOT EXISTS `elite_inventory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `elite_inventory`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: elite_inventory
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `id` int DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` double(45,2) DEFAULT NULL,
  `sale_price` double(45,2) DEFAULT NULL,
  `gross_price` double(40,2) DEFAULT NULL,
  `vendorId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES (6,'Bread/Bakery','sandwich loaves','2022-09-03',12,12.00,12.00,122.00,NULL),(7,'Canned/Jarred Goods','baby corn','2022-09-03',23,323.00,3232.00,32.00,NULL),(16,'Dry/Baking Goods','pasta','2022-09-04',232,32.00,32.00,32.00,NULL),(4,'Frozen Foods',' waffles,','2023-07-05',32,67.00,44.00,324.00,157);
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issued_good`
--

DROP TABLE IF EXISTS `issued_good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issued_good` (
  `id` int NOT NULL AUTO_INCREMENT,
  `productId` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` double(50,2) DEFAULT NULL,
  `total_price` double(50,2) DEFAULT NULL,
  `date_issued` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`productId`),
  CONSTRAINT `issued_good_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issued_good`
--

LOCK TABLES `issued_good` WRITE;
/*!40000 ALTER TABLE `issued_good` DISABLE KEYS */;
INSERT INTO `issued_good` VALUES (1,2,12,1.50,60.00,'2022-03-11');
/*!40000 ALTER TABLE `issued_good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` double(45,2) DEFAULT NULL,
  `sale_price` double(45,2) DEFAULT NULL,
  `gross_price` double(40,2) DEFAULT NULL,
  `gross_sales` double(40,2) DEFAULT NULL,
  `vendorId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Frozen Foods','ice cream','2022-08-31',12,12.00,12.00,12.00,12.00,1),(5,'Bread/Bakery',' banana bread','2022-08-29',564,54.00,4654.00,546.00,46.00,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(40) DEFAULT NULL,
  `product` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` double(40,2) DEFAULT NULL,
  `sale_price` double(40,2) DEFAULT NULL,
  `gross_price` double(40,2) DEFAULT NULL,
  `gross_sales` double(40,2) DEFAULT NULL,
  `vendorId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vendorId` (`vendorId`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`vendorId`) REFERENCES `vendors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (2,'frozen foods','pizza','2022-02-11',40,10.00,13.00,500.00,630.00,1),(3,'Dry/Baking Goods','pasta','2022-08-30',21,12.00,1212.00,12.00,12.00,1),(7,'Bread/Bakery',' banana bread','2022-08-29',564,54.00,4654.00,546.00,46.00,1),(15,'Produce','strawberries','2022-08-30',12,12.00,12.00,12.00,121.00,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `u_price` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `customer` varchar(40) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prodid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prodid` (`prodid`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`prodid`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'strawberries','Produce',12,12,144,'ghf','2022-08-30 23:03:05',15),(2,'strawberries','Produce',12,12,144,'ghf','2022-08-30 23:03:14',15),(3,'pizza','frozen foods',3,13,650,'ddsdfsfds','2022-08-30 23:17:17',2),(4,'pizza','frozen foods',34,13,650,'DFGDGF','2022-08-30 23:22:05',2),(5,'pasta','Dry/Baking Goods',14,1212,25452,'JKJK','2022-08-30 23:42:08',3),(6,'pizza','frozen foods',5,13,650,'GHJGJHGJH','2022-08-30 23:43:39',2),(7,'pizza','frozen foods',5,13,650,'','2022-08-30 23:46:47',2),(8,'pizza','frozen foods',5,12,60,'fgdrfgdfgdg','2022-08-31 06:47:40',2),(13,' lunch meat','Meat',12,12,144,'hnhg','2022-08-31 14:14:02',2),(14,'ketchup','Canned/Jarred Goods',23,21,403,'','2022-09-01 05:44:07',3),(17,'sugar','Dry/Baking Goods',12,12,144,'','2022-09-02 08:59:29',3);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `firm` varchar(50) DEFAULT NULL,
  `contact_number` int DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (1,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(2,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(3,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(4,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(5,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(6,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(7,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(8,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(9,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(10,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(11,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(12,'james','maness','ghffh',767,'ghfhgf','kumasi'),(13,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(14,'james','maness','ghffh',767,'ghfhgf','kumasi'),(15,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(16,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(17,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(18,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(19,'james','maness','ghffh',767,'ghfhgf','kumasi'),(20,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(21,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(22,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(23,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(24,'james','maness','ghffh',767,'ghfhgf','kumasi'),(25,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(26,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(27,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(28,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(29,'james','maness','ghffh',767,'ghfhgf','kumasi'),(30,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(31,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(32,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(33,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(34,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(35,'james','maness','ghffh',767,'ghfhgf','kumasi'),(36,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(37,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(38,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(39,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(40,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(41,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(42,'james','maness','ghffh',767,'ghfhgf','kumasi'),(43,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(44,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(45,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(46,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(47,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(48,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(49,'james','maness','ghffh',767,'ghfhgf','kumasi'),(50,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(51,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(52,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(53,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(54,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(55,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(56,'james','maness','ghffh',767,'ghfhgf','kumasi'),(57,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(58,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(59,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(60,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(61,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(62,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(63,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(64,'james','maness','ghffh',767,'ghfhgf','kumasi'),(65,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(66,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(67,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(68,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(69,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(70,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(71,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(72,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(73,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(74,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(75,'james','maness','ghffh',767,'ghfhgf','kumasi'),(76,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(77,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(78,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(79,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(80,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(81,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(82,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(83,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(84,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(85,'james','maness','ghffh',767,'ghfhgf','kumasi'),(86,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(87,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(88,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(89,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(90,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(91,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(92,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(93,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(94,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(95,'JAMES','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(96,'james','maness','ghffh',767,'ghfhgf','kumasi'),(97,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(98,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(99,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(100,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(101,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(102,'JAMES','MENSAH','FGHF',7896,'','FGD'),(103,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(104,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(105,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(106,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(107,'JAMES','MENSAH','FGHF',7896,'','FGD'),(108,'james','maness','ghffh',767,'ghfhgf','kumasi'),(109,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(110,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(111,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(112,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(113,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(114,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(115,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(116,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(117,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(118,'JAMES','MENSAH','FGHF',7896,'','FGD'),(119,'james','maness','ghffh',767,'ghfhgf','kumasi'),(120,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(121,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(122,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(123,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(124,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(125,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(126,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(127,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(128,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(129,'JAMES','MENSAH','FGHF',7896,'','FGD'),(130,'james','maness','ghffh',767,'ghfhgf','kumasi'),(131,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(132,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(133,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(134,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(135,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(136,'KKJAMESHGHGH','MENSAH','JGJJHJJFGHF',7896,'','FGDHGGHG'),(137,'uyui','uiyuiyi','uiyuiyiyi',3123,'yi','uiyiyiu'),(138,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(139,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(140,'james','maness','ghffh',767,'ghfhgf','kumasi'),(141,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(142,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(143,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(144,'KKJAMESHGHGH','MENSAH','JGJJHJJFGHF',7896,'','FGDHGGHG'),(145,'uyui','uiyuiyi','uiyuiyiyi',3123,'yi','uiyiyiu'),(146,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(147,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(148,'JAMES','MENSAH','FGHF',7896,'','FGD'),(149,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(150,'john','wasa','fingo',55747175,'Ghana','accra'),(151,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi'),(152,'james','wasa gom','Elite comnpany',557471572,'Ghana','accra'),(153,'rert','fdfdd','sdfsdfs',45,'sdfsdfsf','kumasi'),(154,'sas','cxvcfv','dsfdf',3454545,'dsfdf','kumasi'),(155,'james','wasa ako','Elite comnpany',557471572,'Ghana','accra'),(156,'dfdg','refgd','dddfg',5465,'fdfdg','kumasi'),(157,'james mensah','legon city','ELITEHUB',55747255,'ghana','accra'),(158,'him','gcgf','ghdfdfgh',5765765,'fghfh','gfgh'),(159,'KKJAMESHGHGH','MENSAH','JGJJHJJFGHF',7896,'','FGDHGGHG'),(160,'uyui','uiyuiyi','uiyuiyiyi',3123,'yi','uiyiyiu'),(161,'ffhg','gfghf','fhhgf',67557,'ghf','kumasi'),(162,'dfdgj','refgd','dddfghg',5465,'fdfdg','kumasi'),(163,'JAMES','MENSAH','FGHF',7896,'','FGD'),(164,'JAMES GHGH','WASA AKROPONG','PPP',76656567,'DFSDFSFDSDF','kumasi'),(165,'john','wasa','fingo',55747175,'Ghana','accra'),(166,'FDFGD','DFASDFS','EWERWES',787878,'DFSDF','kumasi');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-06  7:05:50
