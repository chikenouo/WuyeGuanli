-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: wuyeguanli
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `car_fee`
--

DROP TABLE IF EXISTS `car_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_fee` (
  `parking` varchar(45) NOT NULL COMMENT '需自行輸入',
  `parking_fee` int DEFAULT NULL COMMENT '停車費',
  `owner` varchar(45) DEFAULT NULL COMMENT '需自行輸入',
  `paid` tinyint DEFAULT '0' COMMENT '0=否  1=是',
  PRIMARY KEY (`parking`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='停車費用';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_fee`
--

LOCK TABLES `car_fee` WRITE;
/*!40000 ALTER TABLE `car_fee` DISABLE KEYS */;
INSERT INTO `car_fee` VALUES ('機車位101號',1200,'555',0),('機車位102號',1200,'222',0),('機車位103號',1200,'444',1),('機車位104號',1200,'444',1),('汽車位201號',2000,'222',0),('汽車位202號',2400,'111',1),('汽車位203號',3000,'555',0),('汽車位204號',2600,'111',1),('汽車位205號',2000,'666',1);
/*!40000 ALTER TABLE `car_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard`
--

DROP TABLE IF EXISTS `dashboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dashboard` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `content` text NOT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard`
--

LOCK TABLES `dashboard` WRITE;
/*!40000 ALTER TABLE `dashboard` DISABLE KEYS */;
INSERT INTO `dashboard` VALUES (12,'2024-06-20','水電相關','B 棟電梯即將進行維護','B 棟電梯將於 2025 年 6 月 22 日上午 9 點至下午 5 點進行維修，請住戶改搭其他電梯。','http://localhost:8585/api/upload/images/65258376-d469-4662-b21d-a0285bd44850.jpg'),(14,'2024-06-25','水電相關','社區夏日園遊會即將舉辦','本年度社區夏日園遊會將於 7 月 1 日上午 10 點至下午 5 點舉辦，歡迎住戶參與！','http://localhost:8585/api/upload/images/b70e8a24-ce60-4329-8d17-03080c52d53e.jpg'),(15,'2024-06-28','水電相關','地下停車場清潔作業通知','7 月 2 日上午 8 點至下午 3 點，地下停車場將進行清潔，請住戶暫時移車。',''),(16,'2024-06-30','住戶相關','近期發生陌生人闖入事件，請住戶提高警覺','近期社區內發生陌生人闖入案件，請住戶進出時關閉大門，並注意可疑人士。','http://localhost:8585/api/upload/images/b968b1ba-fc62-4752-9202-986ae7b5c091.jpg'),(17,'2024-07-02','其他','資源回收日改為每週二、四','社區資源回收日調整為每週二、四，請住戶按照新規則進行垃圾分類與回收。','http://localhost:8585/api/upload/images/c13c3457-dfb3-4a0b-bc62-e37f2e5ecdf2.jpg'),(18,'2024-07-05','水電相關','健身房設備維修公告','健身房部分器材將於 7 月 8 日維修，施工期間暫停使用，請住戶留意。','http://localhost:8585/api/upload/images/f6596d64-5a74-4709-a03d-7b3cbbd2ef6d.png'),(19,'2024-07-08','其他','社區住戶意見調查開始','為提升社區管理，將於 7 月 10 日起進行住戶滿意度調查，請踴躍參與。','http://localhost:8585/api/upload/images/dff1d773-3c6c-4ff5-872c-1d418433f7d7.jpg'),(20,'2024-07-10','水電相關','電費調整通知','因應電費上調，7 月起社區公設用電費用將略有調整，請住戶留意帳單變動。','http://localhost:8585/api/upload/images/98cefc53-fc68-43b0-8941-e9673e377de2.jpg'),(31,'2024-03-21','其他','社區緊急聯絡方式更新','為提升緊急應變能力，管委會已更新社區的緊急聯絡人名單，包括保全主管、社區總幹事及社區醫療合作單位。如需查閱完整聯絡方式，請登入系統至『聯絡我們』頁面查看。','http://localhost:8585/api/upload/images/bfbf0795-9618-4d7a-b80a-96d439f5aead.jpg'),(32,'2024-03-21','住戶相關','住戶門禁卡補發與管理規範','近期發現部分住戶門禁卡遺失或損壞，請有需要補發的住戶至管理中心辦理，每張補發費用為 500 元，需提供身份證明。請勿將門禁卡借予非住戶，違規將取消門禁權限。','http://localhost:8585/api/upload/images/b3882410-5db7-42fe-a9b9-22763d5d0e5f.jpg'),(35,'2025-03-28','水電相關','供水與供電維護公告','為確保供水與供電系統的正常運作，B 棟將於 2025 年 6 月 22 日（星期日）上午 9 點至下午 5 點 進行設備維護。期間可能會有 短暫的停水或停電，請提前做好準備，並注意用水用電安全。\n\n','http://localhost:8585/api/upload/images/e8091601-d80a-4b98-ace0-378bfb68f4c2.jpg');
/*!40000 ALTER TABLE `dashboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directory`
--

DROP TABLE IF EXISTS `directory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job` varchar(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `opening_hours` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通訊錄';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directory`
--

LOCK TABLES `directory` WRITE;
/*!40000 ALTER TABLE `directory` DISABLE KEYS */;
INSERT INTO `directory` VALUES (1,'水電工','08-7519443','9:30~18:00'),(2,'鎖匠','07-6321457','10:00~20:00'),(3,'清潔公司','02-8945632','8:00~17:00'),(4,'搬家回收','03-5678321','10:00~18:00'),(5,'網路IT','06-9854123','9:00~19:00'),(6,'洗衣店','09-8745632','8:30~17:30'),(7,'計程車服務','02-5566778','24 小時營業'),(8,'快遞公司','07-4488221','9:00~18:00');
/*!40000 ALTER TABLE `directory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_info`
--

DROP TABLE IF EXISTS `fee_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fee_info` (
  `address` varchar(255) NOT NULL,
  `other` varchar(255) DEFAULT NULL,
  `modifying_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新一次刷新一次',
  PRIMARY KEY (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理費';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_info`
--

LOCK TABLES `fee_info` WRITE;
/*!40000 ALTER TABLE `fee_info` DISABLE KEYS */;
INSERT INTO `fee_info` VALUES ('A01','[\"1142否\"]','2025-03-28 10:29:08'),('A04','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('A05','[\"1142是\",\"1141是\",\"1134是一半房東繳一半租客繳\"]','2025-03-28 10:27:58'),('A85','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('A87','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('A89','[\"1142是\",\"1141否新來的租客忘記付錢 \",\"1134是\"]','2025-03-28 10:27:58'),('B05','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('B06','[\"1142是\",\"1141否人在國外無法繳費\",\"1134是\"]','2025-03-28 10:27:58'),('B85','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('B87','[\"1142是\",\"1141是\",\"1143是\"]','2025-03-28 10:27:58'),('B89','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('C01','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('C02','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58'),('D01','[\"1142是t\"]','2025-03-28 10:29:35'),('H85','[\"1142是\",\"1141是\",\"1134是\"]','2025-03-28 10:27:58');
/*!40000 ALTER TABLE `fee_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_names`
--

DROP TABLE IF EXISTS `file_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_names` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_name` (`file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_names`
--

LOCK TABLES `file_names` WRITE;
/*!40000 ALTER TABLE `file_names` DISABLE KEYS */;
INSERT INTO `file_names` VALUES (36,'0e82ee01-8931-41ee-a107-4f30c92c53c4.png'),(33,'10924a6f-1807-4718-8c85-93e092144eba.jpg'),(22,'1a94811d-00fe-4a72-a1c8-31a3733fe905.jpg'),(9,'1bc3ff18-81e0-4d0d-801d-7f20ae32bce0.jpg'),(6,'1d2f7279-588e-4685-953e-7a67e9093f77.png'),(40,'254b0d5f-9708-4ddc-ad1e-f4d08f3ec9fe.jpeg'),(19,'2c5dc842-78e1-4e5f-b6e9-d866b7854fee.jpg'),(7,'2e3382fc-9df0-40c0-b8e7-8a8151be5c1b.jpg'),(10,'3079dbd9-2330-4835-968a-6852fccbe150.jpg'),(20,'362c14c2-8864-4d7a-b673-19b2563c9418.jpg'),(32,'3908aaa7-238c-4d73-a43f-da851478d3eb.jpg'),(3,'40f46bb6-fb82-4730-89e1-ebaa5b7ca7fd.jpg'),(25,'5315c7ad-7077-456c-85f0-55ce1efdf815.jpg'),(37,'54a81cb6-9e94-46c8-9dd4-e4493f180e43.jpg'),(39,'5a26e8a2-93e2-4a2b-b0fb-56f59dda35da.jpg'),(24,'6266d967-1de7-4aec-b17d-f19b2b60b384.jpg'),(2,'65258376-d469-4662-b21d-a0285bd44850.jpg'),(41,'6daf09cf-cadb-4379-b693-7cf175e362e8.jpg'),(21,'7486b7ec-fd16-4fdb-8959-41bb7e2f82b1.jpg'),(38,'7aac2aac-ec68-45f0-a0bc-1a4f072be615.png'),(18,'8639ee48-5a16-4563-885c-2ae3ef93004e.jpg'),(1,'895649ab-155c-472f-b64e-33d6d177be1e.jpg'),(13,'931760c6-a020-4019-a750-78186d491ef4.jpg'),(12,'93ee3ccd-99fe-4906-9e8a-1aac6ba0b199.jpg'),(26,'98cefc53-fc68-43b0-8941-e9673e377de2.jpg'),(11,'9bd9bc6f-dcb7-4b70-b332-48351f7b59cc.jpg'),(42,'adac6400-47ff-4fbe-89a6-a3fbef32c4a4.jpg'),(17,'b3882410-5db7-42fe-a9b9-22763d5d0e5f.jpg'),(8,'b70e8a24-ce60-4329-8d17-03080c52d53e.jpg'),(23,'b7c9b89e-410c-4e6c-a6cc-49f59a84d34f.jpg'),(35,'b968b1ba-fc62-4752-9202-986ae7b5c091.jpg'),(14,'bfbf0795-9618-4d7a-b80a-96d439f5aead.jpg'),(29,'c13c3457-dfb3-4a0b-bc62-e37f2e5ecdf2.jpg'),(31,'c605b082-93b5-4780-99e0-6153fc4b3821.jpg'),(43,'cdec7b6f-3959-4a62-acf0-ab374ee08184.webp'),(46,'d85f60f1-6323-47d4-bd1b-1ca40d1f8bc1.webp'),(15,'de8d0985-79f9-4707-ad7b-42bd8a11dc21.jpg'),(27,'dff1d773-3c6c-4ff5-872c-1d418433f7d7.jpg'),(34,'e1fd3bf1-c542-4884-b280-5b923d8eb06d.jpg'),(30,'e3904564-fa38-47d8-b2bf-1e0fd43c5ea7.jpg'),(44,'e8091601-d80a-4b98-ace0-378bfb68f4c2.jpg'),(5,'e89ddb1a-b129-4c11-bd31-a33bcb6708e9.jpg'),(45,'edfc508e-10b8-48ef-a081-bc2d345cef3f.png'),(16,'ef7fdeb0-706b-4a11-a854-b08432a1bca0.jpg'),(4,'f2a9eb7d-8806-4eab-ad8c-5fb0b2ccf811.png'),(28,'f6596d64-5a74-4709-a03d-7b3cbbd2ef6d.png');
/*!40000 ALTER TABLE `file_names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial`
--

DROP TABLE IF EXISTS `financial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project` varchar(255) DEFAULT NULL,
  `income` int DEFAULT '0',
  `expenditure` int DEFAULT '0',
  `date` date DEFAULT NULL,
  `balance` int DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `receipt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial`
--

LOCK TABLES `financial` WRITE;
/*!40000 ALTER TABLE `financial` DISABLE KEYS */;
/*!40000 ALTER TABLE `financial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `get_money`
--

DROP TABLE IF EXISTS `get_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `get_money` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receive_money_account` varchar(45) NOT NULL,
  `receive` int DEFAULT '0' COMMENT '收到多少錢\n',
  `remark` varchar(245) DEFAULT NULL COMMENT '顯示換款人帳號與其他備註資訊',
  `time_of_receiving_money` datetime DEFAULT CURRENT_TIMESTAMP,
  `send_money_account` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `get_money`
--

LOCK TABLES `get_money` WRITE;
/*!40000 ALTER TABLE `get_money` DISABLE KEYS */;
INSERT INTO `get_money` VALUES (27,'222',22,' #A01#-----^車位費^,sdfsd-----222轉錢22$給222','2023-03-13 10:42:29','222'),(28,'333',33,' #A01#-----^車位費^,asdas-----222轉錢33$給333','2025-03-13 10:43:38','222'),(29,'111',1,' #S01#-----^rty-----222轉錢1$給111','2025-03-13 10:44:09','222'),(30,'102420484096',500,' #W01#-----^車位費^,-----111轉錢585$給102420484096','2023-01-13 15:52:23','111'),(31,'222',25,'222轉錢25$給222','2025-03-13 16:31:02','222'),(33,'102420484096',585,' #D02#-----^車位費^,3/140931-----222轉錢585$給102420484096','2025-03-14 09:31:38','222'),(34,'102420484096',455,' #S01#-----^車位費^,-----333轉錢455$給102420484096','2025-03-14 13:31:36','333'),(36,'102420484096',300,' #A01#-----^車位費^,-----111轉錢555$給102420484096','2025-03-14 15:29:36','111'),(37,'102420484096',3000,' #A01#-----^車位費^,-----111轉錢3333$給102420484096','2025-03-14 15:30:39','111'),(38,'102420484096',200,' ^車位費^,-----111轉錢200$給102420484096','2025-03-14 15:48:44','111'),(39,'102420484096',500,' #A02#-----^車位費^,-----111轉錢500$給102420484096','2025-03-14 17:06:37','111'),(40,'111',7777,' ^車位費^,-----102420484096轉錢7777$給111','2025-03-14 17:07:35','102420484096'),(41,'102420484096',1200,' ^車位費^,-----444轉錢1200$給102420484096','2025-03-17 14:07:45','444'),(42,'102420484096',1000,' #A85#-----^車位費^,補繳1000-----111轉錢1000$給102420484096','2025-03-17 14:30:42','111'),(43,'102420484096',5000,' ^車位費^,-----222轉錢5000$給102420484096','2023-03-17 14:32:41','222'),(44,'102420484096',3000,' #A85#-----^管理費^,-----102420484096轉錢3000$給102420484096','2025-03-17 14:51:00','102420484096'),(45,'102420484096',100,' #A01#-----222轉錢100$給102420484096','2025-03-17 15:09:30','222'),(46,'102420484096',2000,' #A85#-----^車位費^,-----666轉錢2000$給102420484096','2025-03-17 15:15:59','666'),(47,'102420484096',200,' ^車位費^,-----222轉錢200$給102420484096','2025-03-19 11:09:50','222'),(48,'102420484096',115,' ^車位費^,-----222轉錢115$給102420484096','2025-03-19 11:10:32','222'),(49,'222',500,' ^轉帳測試-----102420484096轉錢500$給222','2025-03-19 11:11:20','102420484096'),(50,'111',2000,' ^房租-----222轉錢2000$給111','2025-03-19 11:13:19','222'),(51,'102420484096',1200,' ^車位費^,-----444轉錢1200$給102420484096','2025-03-28 10:32:37','444');
/*!40000 ALTER TABLE `get_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` int NOT NULL COMMENT '哪一年',
  `title` varchar(10) NOT NULL COMMENT '每年的標題',
  `description` varchar(100) NOT NULL COMMENT '每年的介紹',
  `celebrity` varchar(10) NOT NULL COMMENT '名人',
  `feature` varchar(45) NOT NULL COMMENT '名人的介紹',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenance`
--

DROP TABLE IF EXISTS `maintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maintenance` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL,
  `floor` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo1` varchar(255) DEFAULT NULL,
  `photo2` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `process_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `is_repaired` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenance`
--

LOCK TABLES `maintenance` WRITE;
/*!40000 ALTER TABLE `maintenance` DISABLE KEYS */;
INSERT INTO `maintenance` VALUES (1,'電梯',3,'不會運作',NULL,NULL,'2025-03-15 14:09:45',NULL,'已修繕',NULL,1),(2,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-08 14:09:45',NULL,'已修繕',NULL,1),(3,'走廊',2,'燈管不亮',NULL,NULL,'2025-03-13 14:09:45',NULL,'已修繕',NULL,1),(4,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-11 14:09:45',NULL,'已修繕',NULL,1),(5,'電梯',3,'不會運作',NULL,NULL,'2025-03-17 14:09:45',NULL,'已修繕',NULL,1),(6,'走廊',2,'燈管不亮',NULL,NULL,'2025-03-10 14:09:45',NULL,'已修繕',NULL,1),(7,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-16 14:09:45',NULL,'未處理',NULL,0),(8,'電梯',3,'不會運作',NULL,NULL,'2025-03-12 14:09:45',NULL,'未處理',NULL,0),(9,'走廊',2,'燈管不亮',NULL,NULL,'2025-03-06 14:09:45',NULL,'未處理',NULL,0),(10,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-09 14:09:45',NULL,'已修繕',NULL,1),(11,'電梯',3,'不會運作',NULL,NULL,'2025-03-14 14:09:45',NULL,'已修繕',NULL,1),(12,'走廊',2,'燈管不亮',NULL,NULL,'2025-03-07 14:09:45',NULL,'已修繕',NULL,1),(13,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-15 14:09:45',NULL,'已修繕',NULL,1),(14,'電梯',3,'不會運作',NULL,NULL,'2025-03-04 14:09:45',NULL,'已修繕',NULL,1),(15,'大廳',1,'大門鑰匙孔壞了',NULL,NULL,'2025-03-05 14:09:45',NULL,'已修繕',NULL,1),(16,'會議室',3,'投影機無法開機',NULL,NULL,'2025-03-03 14:09:45',NULL,'未處理',NULL,0),(17,'停車場',2,'地板積水',NULL,NULL,'2025-03-01 14:09:45',NULL,'已修繕',NULL,1),(18,'樓梯間',5,'滅火器失效',NULL,NULL,'2025-02-28 14:09:45',NULL,'已修繕',NULL,1),(19,'大廳',2,'冷氣不冷',NULL,NULL,'2025-02-26 14:09:45',NULL,'已修繕',NULL,1),(20,'樓梯間',5,'樓梯扶手鬆動',NULL,NULL,'2025-02-25 14:09:45',NULL,'未處理',NULL,0),(21,'會議室',4,'電燈壞了',NULL,NULL,'2025-02-24 14:09:45',NULL,'未處理',NULL,0),(22,'走廊',4,'牆壁裂縫',NULL,NULL,'2025-02-23 14:09:45',NULL,'未處理',NULL,0),(23,'停車場',1,'停車場照明燈故障',NULL,NULL,'2025-02-22 14:09:45',NULL,'未處理',NULL,0),(24,'大廳',1,'門把壞了',NULL,NULL,'2025-02-21 14:09:45',NULL,'未處理',NULL,0);
/*!40000 ALTER TABLE `maintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental`
--

DROP TABLE IF EXISTS `rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental` (
  `idrental` int NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `total` int DEFAULT NULL,
  PRIMARY KEY (`idrental`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental`
--

LOCK TABLES `rental` WRITE;
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
INSERT INTO `rental` VALUES (1,'籃球','若沒氣找管理員打氣',10),(3,'撞球組','1組=2球桿 借用時請確認有拿取2隻，歸還時也須返還兩隻',4),(4,'腳踏車(大)','大人用，小孩或青少年請租:腳踏車(小)',10),(5,'腳踏車(小)','',6);
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `sort` varchar(255) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo1` varchar(255) DEFAULT NULL,
  `photo2` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `process_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `isRepaired` tinyint unsigned NOT NULL DEFAULT '0',
  `cost` int DEFAULT NULL,
  `is_repaired` int DEFAULT NULL,
  `where` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (3,'水電相關','2F 員工廁所','水龍頭壞掉','/api/img/WS/edff213a-d739-4b79-b1d5-b7fc54c780b3.jpg','/api/img/WS/031d4bc7-84ba-4ad7-a6d2-be564158e2e9.jpg','2025-03-02 14:30:00',NULL,'處理中',0,0,0,NULL),(6,'結構相關','1F 大廳廁所','其他','http://localhost:8585/api/upload/images/aea73a15-65b9-4087-a158-d2aa66b6bcd0.jpg','','2025-03-05 08:40:00','2025-03-19 19:51:23','已完成',1,0,1,NULL),(8,'設備相關','B1 倉庫','馬桶堵塞','http://localhost:8585/api/upload/images/16f975f4-7ded-41eb-bf61-c48e610d7e33.jpg','http://localhost:8585/api/upload/images/51244e1f-18a1-4826-affc-93c249a4eae1.jpg','2025-03-06 15:10:00','2025-03-21 15:28:49','已完成',0,0,1,NULL),(9,'水電相關','1F 大廳走廊','燈不亮','http://localhost:8585/api/upload/images/200594b8-6f1e-49ad-92b5-dae1d1fd380b.jpg','','2025-03-02 16:25:00',NULL,'待處理',0,0,0,NULL),(11,'設備相關','4F 樓梯間','玻璃破裂','/api/repairs/images/handrail1.jpg','/api/repairs/images/default.jpg','2025-03-04 09:45:00',NULL,'待處理',0,0,0,NULL),(32,'設備相關','1F 大廳廁所','馬桶堵塞','http://localhost:8585/api/upload/images/4eff69e7-fa3e-41c9-a4c1-b9c05f6ccfad.jpg','','2025-03-19 17:54:50','2025-03-24 14:33:54','已完成',0,NULL,1,NULL),(33,'水電相關','1F 大廳走廊','電梯故障','http://localhost:8585/api/upload/images/37b85a9b-d6b1-4af2-93e8-99baaad7f715.jpg','','2025-03-19 17:55:06',NULL,'待處理',0,NULL,0,NULL),(34,'水電相關','1F 大廳廁所','馬桶堵塞','','','2025-03-19 20:27:08',NULL,'已完成',1,NULL,1,NULL),(35,'設備相關','1F 大廳廁所','馬桶堵塞','http://localhost:8585/api/upload/images/buding.jpg','http://localhost:8585/api/upload/images/buding.jpg','2025-03-20 20:27:08','2025-03-24 14:31:48','已完成',0,NULL,1,NULL),(36,'水電相關','B1 倉庫','燈不亮','http://localhost:8585/api/upload/images/de8d0985-79f9-4707-ad7b-42bd8a11dc21.jpg','http://localhost:8585/api/upload/images/ef7fdeb0-706b-4a11-a854-b08432a1bca0.jpg','2025-03-21 14:49:22',NULL,'待處理',0,NULL,0,NULL),(37,'結構相關','B1 倉庫','牆壁剝落','http://localhost:8585/api/upload/images/8639ee48-5a16-4563-885c-2ae3ef93004e.jpg','','2025-03-21 15:29:21',NULL,'待處理',0,NULL,0,NULL),(38,'設備相關','2F 會議室','燈不亮','http://localhost:8585/api/upload/images/2c5dc842-78e1-4e5f-b6e9-d866b7854fee.jpg','','2025-03-24 09:16:03',NULL,'待處理',0,0,0,NULL),(39,'設備相關','1F 大廳廁所','地板破損','http://localhost:8585/api/upload/images/362c14c2-8864-4d7a-b673-19b2563c9418.jpg','http://localhost:8585/api/upload/images/7486b7ec-fd16-4fdb-8959-41bb7e2f82b1.jpg','2025-03-24 09:20:35',NULL,'待處理',0,0,0,NULL),(41,'水電相關','3F 走廊','門窗問題','','','2025-03-24 09:22:39',NULL,'待處理',0,0,0,NULL),(42,'設備相關','1F 大廳走廊','電路故障','http://localhost:8585/api/upload/images/b7c9b89e-410c-4e6c-a6cc-49f59a84d34f.jpg','','2025-03-24 09:39:27',NULL,'待處理',0,0,0,NULL),(43,'水電相關','1F 大廳廁所','馬桶堵塞','http://localhost:8585/api/upload/images/10924a6f-1807-4718-8c85-93e092144eba.jpg','http://localhost:8585/api/upload/images/e1fd3bf1-c542-4884-b280-5b923d8eb06d.jpg','2025-03-24 09:51:49','2025-03-24 14:32:56','已完成',0,NULL,1,NULL),(44,'設備相關','1F 大廳走廊','燈不亮','http://localhost:8585/api/upload/images/c605b082-93b5-4780-99e0-6153fc4b3821.jpg','http://localhost:8585/api/upload/images/3908aaa7-238c-4d73-a43f-da851478d3eb.jpg','2025-03-24 09:54:33',NULL,'處理中',0,0,0,NULL),(45,'設備相關','1F 大廳廁所','馬桶堵塞','http://localhost:8585/api/upload/images/e3904564-fa38-47d8-b2bf-1e0fd43c5ea7.jpg','','2025-03-24 14:32:49',NULL,'待處理',0,NULL,0,NULL),(53,'設備相關','B1 倉庫','馬桶堵塞','http://localhost:8585/api/upload/images/edfc508e-10b8-48ef-a081-bc2d345cef3f.png','','2025-03-28 10:18:13',NULL,'待處理',0,NULL,0,NULL),(54,'設備相關','2F 員工廁所','電路故障','http://localhost:8585/api/upload/images/d85f60f1-6323-47d4-bd1b-1ca40d1f8bc1.webp','','2025-03-28 10:21:08',NULL,'待處理',0,0,0,NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident_information`
--

DROP TABLE IF EXISTS `resident_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resident_information` (
  `partitionhousenumber` varchar(255) NOT NULL,
  `owner_name` varchar(255) DEFAULT NULL,
  `owner_phone` varchar(255) DEFAULT NULL,
  `lease` bit(1) DEFAULT NULL,
  `residentname` varchar(255) DEFAULT NULL,
  `residentphonenumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`partitionhousenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident_information`
--

LOCK TABLES `resident_information` WRITE;
/*!40000 ALTER TABLE `resident_information` DISABLE KEYS */;
INSERT INTO `resident_information` VALUES ('A15','王小名','12345678',_binary '','小迷','12345679'),('A16','王小名','12345678',_binary '\0',NULL,''),('A18','王阿偉','12345672',_binary '\0','',''),('B16','小小','12345679',_binary '','小美','88888888'),('C55','小李','78945612',_binary '\0',NULL,''),('C60','小窩','12345670',_binary '','小心','45678912'),('C99','新卡','56487321',_binary '\0',NULL,'');
/*!40000 ALTER TABLE `resident_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `header` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,'飼主應妥善管理寵物，避免影響鄰居安寧。寵物應拴繩或放置於安全空間，不得讓寵物在公共區域隨意奔跑。寵物排泄物需由飼主即時清理，違規者將依社區規定處罰。若寵物對他人造成影響或傷害，飼主需負全部責任。','2025-01-14','寵物飼養規範','住戶行為'),(2,'為確保住戶安寧，社區規定每日 22:00 至次日 07:00 禁止大聲喧嘩、播放高音量音樂、裝修施工或進行影響鄰居的活動。若有特殊情況需例外處理，請事先向管理委員會申請，經批准後方可進行，違者將依社區規定處理。','2025-02-03','噪音管制規則','環境管理'),(3,'停車場內車輛應遵守標示停放，禁止長時間占用訪客車位或影響緊急通道通行。若發現違規停車，管理員將拍照存證並通知車主移車，屢次違規者將面臨罰款或車輛拖吊處理。','2025-01-25','違規停車處理規範','公共秩序'),(4,'住戶車輛應停放於分配的車位內，不得佔用他人車位或隨意停放影響交通。訪客車輛需事先向管理員登記，並停放於訪客專用區。違規停車將視情況予以警告，屢犯者將可能面臨罰款或車輛被拖吊。','2025-02-11','停車場使用規範','安全管理'),(5,'所有住戶需遵守社區垃圾分類規定，分為一般垃圾、資源回收及廚餘，並投入相應垃圾桶。垃圾丟棄時間為每日 18:00 至 20:00，逾時不得亂丟。若違反規定，經勸導無效者，將依社區規範處罰，並可通報環保單位處理。','2025-02-08','垃圾分類與丟棄規範','環境管理'),(6,'社區健身房僅限住戶使用，禁止外借或擅自帶外來人士進入。使用器材時應遵守使用說明，並愛惜設備。使用後請歸位並清潔，避免影響他人使用體驗。違規者將視情節輕重，處以警告或暫停使用權利。','2025-01-31','健身房使用規範','社區設施'),(7,'社區實行嚴格的門禁制度，住戶應隨手關門，避免閒雜人員進入。訪客進入社區須先至管理室登記，確認住戶許可後方可進入。快遞與外送人員僅能停留於指定區域，不得隨意進入住戶樓層。任何違規者將由管理員記錄並回報管理委員會。','2025-02-01','門禁管理與訪客登記','安全管理'),(8,'住戶不得在陽台外掛晾衣架或擺放過多雜物，避免影響社區外觀或存在安全隱患。不得向窗外或陽台拋棄垃圾或物品，避免影響樓下住戶及公共區域整潔。違規行為將受到警告，屢次違反者將依社區管理辦法處理。','2025-01-18','陽台與窗戶管理','住戶行為'),(9,'社區住戶應共同維護環境清潔，禁止在走廊、樓梯間或其他公共區域堆放雜物。所有垃圾應依規定分類，並於指定時間內丟棄至垃圾收集處。若發現有人隨意丟棄垃圾或造成環境污染，管理委員會有權對其進行勸導，屢勸不聽者將酌情處罰，以維護整潔的居住環境。','2025-02-06','公共區域保持清潔','環境管理'),(10,'游泳池使用時間為 07:00 至 22:00，進入前請先沖洗，並禁止在池邊奔跑、跳水或嬉鬧，以確保安全。12 歲以下孩童需有成人陪同，違規者將被管理員勸離，並可能面臨處罰。','2025-01-22','游泳池管理規則','社區設施'),(11,'住戶若發生糾紛，應先友善協商解決，若無法達成共識，可向管理委員會申訴，由管理員協助調解。禁止發生爭執或暴力行為，違者將報警處理，並依社區規範懲處。','2025-02-14','住戶糾紛處理','公共秩序'),(12,'住戶應確保自家用電安全，避免私拉電線或過度使用插座，易燃物品應妥善存放，禁止在公共區域焚燒物品或使用明火。樓梯間及消防通道應保持暢通，若有違規行為，經管理員勸導無效者，將報請相關單位處理。','2025-02-07','防火安全管理','安全管理'),(13,'住戶若需進行裝修，施工時間限制為每日 08:30 至 17:30，週末及國定假日禁止施工。施工前須向管理處申報，並告知鄰居避免影響他人作息。裝修期間產生的建築垃圾應自行清理，不得隨意棄置於社區內。','2025-01-27','裝修施工時間規定','住戶行為'),(14,'兒童遊戲區僅限 12 歲以下孩童使用，並需家長或監護人陪同。請勿破壞遊樂設施，並注意安全。禁止攜帶寵物進入遊戲區，以確保兒童衛生與安全。違反規定者將由管理員警告或限制使用。','2025-01-09','兒童遊樂區規範','社區設施'),(15,'社區公告須經管理委員會批准後張貼，禁止私自張貼廣告或傳單。違規者將由管理員拆除，屢犯者將依規定處理。','2025-02-05','社區公告張貼管理','公共秩序');
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_money`
--

DROP TABLE IF EXISTS `transfer_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_money` (
  `account` varchar(45) NOT NULL DEFAULT '對應users的identity_numbe' COMMENT '錢包APP',
  `transfer` int DEFAULT '0',
  `balance` int DEFAULT '0',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='這表格只能看到 對應帳號的魚兒  要統計請去`get_money`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_money`
--

LOCK TABLES `transfer_money` WRITE;
/*!40000 ALTER TABLE `transfer_money` DISABLE KEYS */;
INSERT INTO `transfer_money` VALUES ('1',1111,5222,'2025-03-17 10:55:20'),('102420484096',1200,1005800,'2025-03-28 10:32:36'),('111',666,666,'2025-03-21 10:31:13'),('222',878,878,'2025-03-21 10:31:30'),('333',333,333,'2025-03-21 10:31:49'),('444',1200,544,'2025-03-28 10:32:36'),('555',555,555,'2025-03-21 10:32:23'),('666',666,666,'2025-03-21 10:32:41'),('T123456789',1000,3999000,'2025-03-18 17:12:12');
/*!40000 ALTER TABLE `transfer_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `identity_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','landlord','tenant') NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `landlord_id` bigint DEFAULT NULL,
  `is_currently_residing` tinyint(1) NOT NULL DEFAULT '1',
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_landlord` (`landlord_id`),
  CONSTRAINT `FK3eywxgg0qfx2w05xgvhqgdhrc` FOREIGN KEY (`landlord_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'吉娃娃',NULL,'1','123456','admin','2025-02-28 00:52:13','2025-03-24 09:52:49',NULL,1,'1_58de2532-c70a-4aa0-a322-c5ad4da444bd.jpg'),(2,'悅來富管理員',NULL,'111111','111111','admin','2025-02-28 18:20:54','2025-03-28 10:18:53',NULL,1,'2_e695b324-3c0b-4050-83f1-8745f6d5d24f.png'),(3,'Jensen','A87','T123456789','666','landlord','2025-02-28 18:20:54','2025-04-25 07:43:48',NULL,1,NULL),(4,'好野人','A88','T987654321','666666','landlord','2025-02-28 18:20:54','2025-03-26 11:13:58',NULL,1,NULL),(5,'房客1',NULL,'C000000001','C000000001','tenant','2025-02-28 18:20:54','2025-02-28 18:22:39',3,1,NULL),(6,'房客2',NULL,'C000000002','C000000002','tenant','2025-02-28 18:20:54','2025-02-28 18:22:39',3,1,NULL),(7,'房客3',NULL,'C000000003','C000000003','tenant','2025-02-28 18:20:54','2025-02-28 18:20:54',3,1,NULL),(8,'房客4',NULL,'C000000004','C000000004','tenant','2025-02-28 18:20:54','2025-02-28 18:20:54',3,1,NULL),(9,'系統管理員',NULL,'111','123456','admin','2025-02-28 18:20:54','2025-03-27 11:13:42',4,1,'9_4332c776-22f9-40c7-8228-551bdf82fb6e.png'),(10,'粥餅倫','B85','222','ABC222','tenant','2025-02-28 18:20:54','2025-03-26 15:30:01',3,1,NULL),(57,'劉德華',NULL,'333','333333','admin','2025-03-07 10:15:17','2025-03-26 14:53:17',NULL,1,NULL),(58,'麥可喬丹',NULL,'444','444','landlord','2025-03-07 10:15:17','2025-03-28 09:09:13',NULL,1,'https://example.com/avatar1.jpg'),(59,'成振宇','A04','555','555555','tenant','2025-03-07 10:15:17','2025-03-26 14:53:17',2,1,'https://example.com/avatar2.jpg'),(60,'伍佰','B05','666','666666','tenant','2025-03-07 10:15:17','2025-03-26 09:54:48',2,0,NULL),(61,'Bob Lin',NULL,'D789123456','hashed_password_5','landlord','2025-03-07 10:15:17','2025-03-07 10:15:17',NULL,1,'https://example.com/avatar3.jpg'),(62,'Charlie Wang',NULL,'E321654987','hashed_password_6','tenant','2025-03-07 10:15:17','2025-03-07 10:15:17',5,1,NULL),(63,'系統管理員25',NULL,'2','123456','admin','2025-03-13 23:20:38','2025-03-13 23:49:18',NULL,1,'63_67273740-1f2f-497a-a46f-20b6d5f566c8.png'),(64,'王小明',NULL,'A123456789','tenantpassword','tenant','2025-03-15 06:24:50','2025-03-15 06:24:50',NULL,1,NULL),(65,'王小明',NULL,'A123456789','tenantpassword','tenant','2025-03-15 06:26:58','2025-03-15 06:26:58',3,1,NULL),(66,'李大方',NULL,'B987654321','landlordpassword','landlord','2025-03-15 06:29:06','2025-03-15 06:29:06',NULL,1,NULL),(67,'專收匯款帳戶(財務委員專用)666',NULL,'102420484096','1','admin','2025-03-15 06:29:06','2025-03-18 16:19:38',NULL,1,'67_7fa7ccb8-1bd3-4015-b9b7-6537dcc01ae0.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor_records`
--

DROP TABLE IF EXISTS `visitor_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor_records` (
  `visitor_id` int NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(255) DEFAULT NULL,
  `visitor_phone` varchar(255) DEFAULT NULL,
  `visitor_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `out_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `visitor_reason` varchar(255) DEFAULT NULL,
  `visitors` varchar(255) DEFAULT NULL,
  `is_out_visitors` bit(1) DEFAULT b'0',
  PRIMARY KEY (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor_records`
--

LOCK TABLES `visitor_records` WRITE;
/*!40000 ALTER TABLE `visitor_records` DISABLE KEYS */;
INSERT INTO `visitor_records` VALUES (27,'殷殷','0979227058','2025-03-23 17:46:29','2025-03-23 21:56:32','遊戲','A16王小名',_binary ''),(28,'小名','0979227059','2025-03-23 21:15:04','2025-03-23 22:59:37','拜訪','A16王小名',_binary ''),(29,'校小','0979227058','2025-03-23 21:58:41','2025-03-23 21:58:41','玩遊戲','A16王小名',_binary '\0'),(30,'小名','0979227050','2025-03-23 22:58:08','2025-03-23 22:58:57','玩捉由','A15王小名',_binary ''),(31,'小迷','0975227058','2025-03-24 10:01:30','2025-03-24 10:01:30','王遊戲','A15王小名',_binary '\0'),(32,'小英','0983939768','2025-03-24 10:02:49','2025-03-24 10:02:49','game','A16王小名',_binary '\0'),(33,'小英','0979227059','2025-03-24 10:03:37','2025-03-24 10:03:37','玩','A16王小名',_binary '\0'),(34,'小名','0979227080','2025-03-24 10:49:23','2025-03-24 10:49:23','拜訪','C55小李',_binary '\0'),(35,'曉鈴','0987654321','2025-03-24 10:50:16','2025-03-27 10:47:50','做功課','B16小小',_binary ''),(37,'小雯','0979227052','2025-03-28 10:24:01','2025-03-28 10:24:21','GAME','A18王阿偉',_binary '');
/*!40000 ALTER TABLE `visitor_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `who_rental`
--

DROP TABLE IF EXISTS `who_rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `who_rental` (
  `idwho_rental` int NOT NULL AUTO_INCREMENT,
  `account_rental` varchar(255) DEFAULT NULL,
  `change_time` datetime(6) DEFAULT NULL,
  `rental_what` varchar(255) DEFAULT NULL,
  `returnyorn` bit(1) DEFAULT NULL,
  `verify` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idwho_rental`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `who_rental`
--

LOCK TABLES `who_rental` WRITE;
/*!40000 ALTER TABLE `who_rental` DISABLE KEYS */;
INSERT INTO `who_rental` VALUES (1,'222','2025-03-21 15:10:30.831141','籃球',_binary '\0',_binary '\0'),(2,'333','2025-03-21 15:10:33.748919','撞球組',_binary '\0',_binary '\0'),(3,'444','2025-03-21 15:11:55.493639','撞球組',_binary '',_binary ''),(4,'444','2025-03-24 10:15:41.490983','撞球組',_binary '',_binary ''),(5,'555','2025-03-24 14:51:54.489870','籃球',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `who_rental` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-25  8:02:21
