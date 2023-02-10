-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hassware
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `idorder` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `customer` varchar(45) NOT NULL,
  `product` varchar(45) NOT NULL,
  `quantity` int NOT NULL,
  `total` int NOT NULL,
  `createdby` varchar(45) NOT NULL,
  PRIMARY KEY (`idorder`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2022-01-03','Jumbo SAS','Aguacate Hass Calibre 32',1200,120000000,'Administrador'),(2,'2022-01-03','Mercacentro','Aguacate Hass Calibre 32',900,80000000,'Andres Gomez'),(3,'2022-01-03','Almacenes Exito','Aguacate Hass Calibre 34',2000,52000000,'Andres Gomez'),(4,'2022-01-03','Alkosto','Aguacate Hass Calibre 32',1800,94600000,'Administrador'),(5,'2022-01-03','Metro','Aguacate Hass Calibre 32',1300,73000000,'Andres Gomez'),(6,'2022-01-03','Carulla','Aguacate Hass Calibre 36',800,68000000,'Andres Gomez'),(7,'2023-01-04','Cooratiendas','Aguacate Hass Calibre 32',1000,78900000,'Administrador'),(8,'2022-01-03','Canasta Campesina','Aguacate Hass Calibre 32',500,45890000,'Administrador'),(9,'2022-01-03','Surtimax','Aguacate Hass Calibre 40',950,64900000,'Andres Gomez'),(10,'2022-01-03','Makro','Aguacate Hass Calibre 32',480,45000000,'Andres Gomez'),(11,'2022-01-03','Olimpica','Aguacate Hass Calibre 30',650,60000000,'Administrador'),(12,'2022-03-06','Jumbo SAS','Aguacate Hass Calibre 34',1500,135000000,'Andres Gomez'),(13,'2022-03-06','Mercacentro','Aguacate Hass Calibre 36',560,54000000,'Andres Gomez'),(14,'2022-03-06','Almacenes Exito','Aguacate Hass Calibre 30',1650,169000000,'Administrador'),(15,'2022-03-06','Alkosto','Aguacate Hass Calibre 32',900,48000000,'Andres Gomez'),(16,'2022-03-06','Metro','Aguacate Hass Calibre 30',1000,93000000,'Administrador'),(17,'2022-03-06','Carulla','Aguacate Hass Calibre 36',750,62000000,'Andres Gomez'),(18,'2022-03-06','Coratiendas','Aguacate Hass Calibre 32',550,47800000,'Andres Gomez'),(19,'2022-03-06','Canasta Campesina','Aguacate Hass Calibre 32',650,57000000,'Administrador'),(20,'2022-03-06','Surtimax','Aguacate Hass Calibre 40',1100,136000000,'Andres Gomez'),(21,'2022-03-06','Makro','Aguacate Hass Calibre 32',300,48000000,'Andres Gomez'),(22,'2022-03-06','Olimpica','Aguacate Hass Calibre 30',500,49800000,'Administrador'),(23,'2022-05-16','Coratiendas','Aguacate Hass Calibre 32',300,48000000,'Administrador'),(24,'2022-05-16','Canasta Campesina','Aguacate Hass Calibre 32',120,78900000,'Administrador'),(25,'2022-05-16','Surtimax','Aguacate Hass Calibre 40',180,81600000,'Andres Gomez'),(26,'2022-05-16','Makro','Aguacate Hass Calibre 32',340,15700000,'Administrador'),(27,'2022-05-16','Olimpica','Aguacate Hass Calibre 30',420,26700000,'Andres Gomez'),(28,'2022-05-16','Jumbo SAS','Aguacate Hass Calibre 32',910,98000000,'Andres Gomez'),(29,'2022-05-16','Mercacentro','Aguacate Hass Calibre 32',690,78590000,'Administrador'),(30,'2022-05-16','Almacenes Exito','Aguacate Hass Calibre 34',478,41700000,'Andres Gomez'),(31,'2022-05-16','Alkosto','Aguacate Hass Calibre 32',480,67009900,'Andres Gomez'),(32,'2022-05-16','Metro','Aguacate Hass Calibre 32',420,65090000,'Administrador'),(33,'2022-05-16','Carulla','Aguacate Hass Calibre 36',380,37900000,'Andres Gomez'),(34,'2022-07-08','Olimpica','Aguacate Hass Calibre 30',130,23400000,'Andres Gomez'),(35,'2022-07-08','Jumbo SAS','Aguacate Hass Calibre 32',400,67000000,'Andres Gomez'),(36,'2022-07-08','Mercacentro','Aguacate Hass Calibre 32',460,85980000,'Administrador'),(37,'2022-07-08','Coratiendas','Aguacate Hass Calibre 32',420,83560000,'Administrador'),(38,'2022-07-08','Canasta Campesina','Aguacate Hass Calibre 32',200,13667890,'Administrador'),(39,'2022-07-08','Surtimax','Aguacate Hass Calibre 40',120,70977000,'Andres Gomez'),(40,'2022-07-08','Makro','Aguacate Hass Calibre 32',500,63600000,'Andres Gomez'),(41,'2022-07-08','Olimpica','Aguacate Hass Calibre 30',390,27800000,'Administrador');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_has_user`
--

DROP TABLE IF EXISTS `orders_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_has_user` (
  `orders_idorder` int NOT NULL,
  `user_iduser` int NOT NULL,
  PRIMARY KEY (`orders_idorder`,`user_iduser`),
  KEY `fk_orders_has_user_user1_idx` (`user_iduser`),
  KEY `fk_orders_has_user_orders_idx` (`orders_idorder`),
  CONSTRAINT `fk_orders_has_user_orders` FOREIGN KEY (`orders_idorder`) REFERENCES `orders` (`idorder`),
  CONSTRAINT `fk_orders_has_user_user1` FOREIGN KEY (`user_iduser`) REFERENCES `users` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_has_user`
--

LOCK TABLES `orders_has_user` WRITE;
/*!40000 ALTER TABLE `orders_has_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `idproduct` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL,
  `managedby` varchar(45) NOT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Aguacate Hass Calibre 32',30,155000,'Administrador'),(2,'Aguacate Hass Calibre 34',30,160000,'Juan Rojas'),(3,'Aguacate Hass Calibre 36',30,164000,'Administrador'),(4,'Aguacate Hass Calibre 40',30,170000,'Administrador'),(5,'Aguacate Variedad Lorena',30,168000,'Administrador'),(6,'Aguacare Variedad Trinidad',30,160000,'Administrador'),(7,'Aguacarte Variedad Fuerte',30,140000,'Juan Rojas'),(8,'Aguacate Variedad Santana',30,180000,'Juan Rojas'),(9,'Aguacate Variedad Booth-8',30,180000,'Juan Rojas');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_has_user`
--

DROP TABLE IF EXISTS `products_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_has_user` (
  `products_idproduct` int NOT NULL,
  `user_iduser` int NOT NULL,
  PRIMARY KEY (`products_idproduct`,`user_iduser`),
  KEY `fk_products_has_user_user1_idx` (`user_iduser`),
  KEY `fk_products_has_user_products1_idx` (`products_idproduct`),
  CONSTRAINT `fk_products_has_user_products1` FOREIGN KEY (`products_idproduct`) REFERENCES `products` (`idproduct`),
  CONSTRAINT `fk_products_has_user_user1` FOREIGN KEY (`user_iduser`) REFERENCES `users` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_has_user`
--

LOCK TABLES `products_has_user` WRITE;
/*!40000 ALTER TABLE `products_has_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `iduser` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Administrador','Administrador'),(2,'Andres Gomez','Ventas'),(3,'Juan Rojas','Almacen');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-29 16:50:03
