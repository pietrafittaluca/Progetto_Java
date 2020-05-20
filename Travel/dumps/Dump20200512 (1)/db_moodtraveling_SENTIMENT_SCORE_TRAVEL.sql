-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: db_moodtraveling
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.19.10.1

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
-- Table structure for table `SENTIMENT_SCORE_TRAVEL`
--

DROP TABLE IF EXISTS `SENTIMENT_SCORE_TRAVEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SENTIMENT_SCORE_TRAVEL` (
  `ID_SENTIMENT` int NOT NULL,
  `LINK` varchar(500) NOT NULL,
  PRIMARY KEY (`LINK`),
  KEY `FK_ID_SENTIMENT` (`ID_SENTIMENT`),
  CONSTRAINT `FK_ID_SENTIMENT` FOREIGN KEY (`ID_SENTIMENT`) REFERENCES `SENTIMENT_SCORE` (`ID_SENTIMENT`) ON DELETE CASCADE,
  CONSTRAINT `FK_LINK_SENTIMENT` FOREIGN KEY (`LINK`) REFERENCES `VIAGGIO` (`LINK`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SENTIMENT_SCORE_TRAVEL`
--

LOCK TABLES `SENTIMENT_SCORE_TRAVEL` WRITE;
/*!40000 ALTER TABLE `SENTIMENT_SCORE_TRAVEL` DISABLE KEYS */;
INSERT INTO `SENTIMENT_SCORE_TRAVEL` VALUES (1,'https://www.google.it'),(2,'https://www.hdblog.it'),(3,'https://www.repubblica.it'),(64,'https://www.tripadvisor.co.uk/Attraction_Review-g3135848-d7244902-Reviews-Elford_Walled_Garden-Elford_Staffordshire_England.html'),(92,'https://www.tripadvisor.co.uk/Hotel_Review-g319811-d314964-Reviews-Chirnside_Hall_Hotel-Chirnside_Scottish_Borders_Scotland.html'),(146,'https://www.tripadvisor.co.uk/Hotel_Review-g1156446-d1549513-Reviews-The_New_Inn-Appletreewick_Yorkshire_Dales_National_Park_North_Yorkshire_England.html'),(364,'https://www.tripadvisor.co.uk/Hotel_Review-g551951-d664608-Reviews-The_White_Swan_Hotel-Duns_Scottish_Borders_Scotland.html'),(447,'https://www.tripadvisor.co.uk/Hotel_Review-g940866-d1167683-Reviews-The_Castle_Hotel-Coldstream_Scottish_Borders_Scotland.html'),(559,'https://www.tripadvisor.co.uk/Hotel_Review-g1062090-d1027338-Reviews-The_Plough_Hotel-Yetholm_Scottish_Borders_Scotland.html'),(688,'https://www.tripadvisor.co.uk/Hotel_Review-g1479315-d4763233-Reviews-Lauderdale_Hotel-Lauder_Scottish_Borders_Scotland.html'),(898,'https://www.tripadvisor.co.uk/Hotel_Review-g635690-d1062089-Reviews-Overscaig_House_Hotel-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1041,'https://www.tripadvisor.co.uk/Attractions-g635690-Activities-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1047,'https://www.tripadvisor.co.uk/Attraction_Review-g635690-d4737183-Reviews-Stoer_Lighthouse-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1110,'https://www.tripadvisor.co.uk/Attraction_Review-g635690-d589038-Reviews-Loch_Assynt-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1169,'https://www.tripadvisor.co.uk/Attraction_Review-g635690-d8318677-Reviews-Ferrycroft_Visitor_Centre-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotl.html#REVIEWS'),(1222,'https://www.tripadvisor.co.uk/Attraction_Review-g635690-d12612736-Reviews-Cape_Wrath_Lighthouse-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1236,'https://www.tripadvisor.co.uk/Attraction_Review-g635690-d8004886-Reviews-North_West_Highlands_Geopark-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Sc.html'),(1289,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d12365935-Reviews-The_Whale_Tale-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1309,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d2653656-Reviews-Achness_Hotel_Restaurant_and_Bar-Lairg_Caithness_and_Sutherland_Scottish_Highland.html'),(1321,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d13447969-Reviews-Mac_and_Wild-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1333,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d1993256-Reviews-Inver_Lodge_Restaurant-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1467,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d752921-Reviews-The_Crofters_Restaurant-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Scotland.html'),(1485,'https://www.tripadvisor.co.uk/Restaurant_Review-g635690-d18546168-Reviews-Shin_Fry_Fish_and_Chip_Shop-Lairg_Caithness_and_Sutherland_Scottish_Highlands_Sc.html'),(1490,'https://www.tripadvisor.co.uk/Hotel_Review-g1234847-d15074446-Reviews-Silverbridge_Lodge-Garve_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(1496,'https://www.tripadvisor.co.uk/Hotel_Review-g1234847-d194956-Reviews-Inchbae_Lodge_Inn-Garve_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(1624,'https://www.tripadvisor.co.uk/Hotel_Review-g1234847-d12645951-Reviews-Aultguish_Bunkhouse_Ltd-Garve_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(1640,'https://www.tripadvisor.co.uk/Hotel_Review-g1234847-d673390-Reviews-Aultguish_Inn_B_B-Garve_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(1907,'https://www.tripadvisor.co.uk/Attraction_Review-g1234847-d13151465-Reviews-Black_Water_Falls-Garve_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(1922,'https://www.tripadvisor.co.uk/Attraction_Review-g1234847-d9882392-Reviews-Corrieshalloch_Gorge_National_Nature_Reserve-Garve_Ross_and_Cromarty_Scottish_Hi.html'),(1952,'https://www.tripadvisor.co.uk/Attraction_Review-g1234847-d12154110-Reviews-Ben_Wyvis_National_Nature_Reserve-Garve_Ross_and_Cromarty_Scottish_Highlands_Sc.html'),(1961,'https://www.tripadvisor.co.uk/Hotel_Review-g562823-d279601-Reviews-Edinbane_Lodge-Edinbane_Isle_of_Skye_The_Hebrides_Scotland.html'),(2000,'https://www.tripadvisor.co.uk/Attraction_Review-g562823-d10487391-Reviews-Hebridean_Isles_Trading_Company_Island_at_the_Edge-Edinbane_Isle_of_Skye_The_Heb.html'),(2021,'https://www.tripadvisor.co.uk/Restaurant_Review-g2208342-d2691483-Reviews-The_Struy_Inn-Struy_Scottish_Highlands_Scotland.html'),(2146,'https://www.tripadvisor.co.uk/Hotel_Review-g1489118-d306121-Reviews-The_Old_Mill_Highland_Lodge-Talladale_Scottish_Highlands_Scotland.html'),(2202,'https://www.tripadvisor.co.uk/Hotel_Review-g551816-d313534-Reviews-Achilty_Hotel-Contin_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(2268,'https://www.tripadvisor.co.uk/Hotel_Review-g186538-d251665-Reviews-Lovat_Arms_Hotel-Beauly_Scottish_Highlands_Scotland.html'),(2483,'https://www.tripadvisor.co.uk/Attraction_Review-g551963-d18919809-Reviews-Victoria_Falls-Achnasheen_Ross_and_Cromarty_Scottish_Highlands_Scotland.html'),(2486,'https://www.tripadvisor.co.uk/Attraction_Review-g551963-d7286665-Reviews-Torridon_National_Trust_Estate-Achnasheen_Ross_and_Cromarty_Scottish_Highlands_Sc.html');
/*!40000 ALTER TABLE `SENTIMENT_SCORE_TRAVEL` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-12  4:42:34
