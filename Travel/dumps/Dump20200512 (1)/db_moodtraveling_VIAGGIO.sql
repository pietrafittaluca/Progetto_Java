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
-- Table structure for table `VIAGGIO`
--

DROP TABLE IF EXISTS `VIAGGIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VIAGGIO` (
  `NOME_OFFERTA` varchar(40) NOT NULL,
  `LINK` varchar(500) NOT NULL,
  `CITTA` varchar(40) NOT NULL,
  `TIPO` varchar(40) NOT NULL,
  PRIMARY KEY (`LINK`),
  CONSTRAINT `CH_TIPO` CHECK ((`TIPO` in (_utf8mb4'Soggiorno',_utf8mb4'Giornata di Relax')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VIAGGIO`
--

LOCK TABLES `VIAGGIO` WRITE;
/*!40000 ALTER TABLE `VIAGGIO` DISABLE KEYS */;
INSERT INTO `VIAGGIO` VALUES ('nome_offerta_root','https://www.google.it','citta_root','Soggiorno'),('nome_offerta_luca','https://www.hdblog.it','citta_luca','Soggiorno'),('nome_offerta_luca','https://www.repubblica.it','citta_luca','Giornata di Relax'),('ben wyvis national nature reserve','https://www.tripadvisor.co.uk/attraction_review-g1234847-d12154110-reviews-ben_wyvis_national_nature_reserve-garve_ross_and_cromarty_scottish_highlands_sc.html','garve','Soggiorno'),('black water falls','https://www.tripadvisor.co.uk/attraction_review-g1234847-d13151465-reviews-black_water_falls-garve_ross_and_cromarty_scottish_highlands_scotland.html','garve','Soggiorno'),('corrieshalloch gorge national nature res','https://www.tripadvisor.co.uk/attraction_review-g1234847-d9882392-reviews-corrieshalloch_gorge_national_nature_reserve-garve_ross_and_cromarty_scottish_hi.html','garve','Soggiorno'),('elford walled garden','https://www.tripadvisor.co.uk/attraction_review-g3135848-d7244902-reviews-elford_walled_garden-elford_staffordshire_england.html','portmeirion','Giornata di relax'),('abbotsbury subtropical gardens','https://www.tripadvisor.co.uk/attraction_review-g551704-d1812924-reviews-abbotsbury_subtropical_gardens-abbotsbury_weymouth_dorset_england.html','portmeirion','Giornata di relax'),('abbotsbury playground','https://www.tripadvisor.co.uk/attraction_review-g551704-d3369346-reviews-abbotsbury_playground-abbotsbury_weymouth_dorset_england.html','portmeirion','Giornata di relax'),('victoria falls','https://www.tripadvisor.co.uk/attraction_review-g551963-d18919809-reviews-victoria_falls-achnasheen_ross_and_cromarty_scottish_highlands_scotland.html','achnaseen','Soggiorno'),('torridon national trust estate','https://www.tripadvisor.co.uk/attraction_review-g551963-d7286665-reviews-torridon_national_trust_estate-achnasheen_ross_and_cromarty_scottish_highlands_sc.html','achnaseen','Soggiorno'),('hebridean isles trading company -island ','https://www.tripadvisor.co.uk/attraction_review-g562823-d10487391-reviews-hebridean_isles_trading_company_island_at_the_edge-edinbane_isle_of_skye_the_heb.html','garve','Giornata di relax'),('cape wrath lighthouse','https://www.tripadvisor.co.uk/attraction_review-g635690-d12612736-reviews-cape_wrath_lighthouse-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('stoer lighthouse','https://www.tripadvisor.co.uk/attraction_review-g635690-d4737183-reviews-stoer_lighthouse-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('loch assynt','https://www.tripadvisor.co.uk/attraction_review-g635690-d589038-reviews-loch_assynt-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('north west highlands geopark','https://www.tripadvisor.co.uk/attraction_review-g635690-d8004886-reviews-north_west_highlands_geopark-lairg_caithness_and_sutherland_scottish_highlands_sc.html','lairg','Giornata di relax'),('ferrycroft visitor centre','https://www.tripadvisor.co.uk/attraction_review-g635690-d8318677-reviews-ferrycroft_visitor_centre-lairg_caithness_and_sutherland_scottish_highlands_scotl.html#reviews','lairg','Giornata di relax'),('things to do in lairg','https://www.tripadvisor.co.uk/attractions-g635690-activities-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('the plough hotel','https://www.tripadvisor.co.uk/hotel_review-g1062090-d1027338-reviews-the_plough_hotel-yetholm_scottish_borders_scotland.html','portmeirion','Soggiorno'),('the new inn','https://www.tripadvisor.co.uk/hotel_review-g1156446-d1549513-reviews-the_new_inn-appletreewick_yorkshire_dales_national_park_north_yorkshire_england.html','portmeirion','Soggiorno'),('aultguish bunkhouse ltd','https://www.tripadvisor.co.uk/hotel_review-g1234847-d12645951-reviews-aultguish_bunkhouse_ltd-garve_ross_and_cromarty_scottish_highlands_scotland.html','garve','Soggiorno'),('silverbridge lodge','https://www.tripadvisor.co.uk/hotel_review-g1234847-d15074446-reviews-silverbridge_lodge-garve_ross_and_cromarty_scottish_highlands_scotland.html','garve','Soggiorno'),('inchbae lodge inn','https://www.tripadvisor.co.uk/hotel_review-g1234847-d194956-reviews-inchbae_lodge_inn-garve_ross_and_cromarty_scottish_highlands_scotland.html','garve','Soggiorno'),('aultguish inn b&b','https://www.tripadvisor.co.uk/hotel_review-g1234847-d673390-reviews-aultguish_inn_b_b-garve_ross_and_cromarty_scottish_highlands_scotland.html','garve','Soggiorno'),('lauderdale hotel','https://www.tripadvisor.co.uk/hotel_review-g1479315-d4763233-reviews-lauderdale_hotel-lauder_scottish_borders_scotland.html','portmeirion','Soggiorno'),('the old mill highland lodge','https://www.tripadvisor.co.uk/hotel_review-g1489118-d306121-reviews-the_old_mill_highland_lodge-talladale_scottish_highlands_scotland.html','achnaseen','Soggiorno'),('lovat arms hotel','https://www.tripadvisor.co.uk/hotel_review-g186538-d251665-reviews-lovat_arms_hotel-beauly_scottish_highlands_scotland.html','achnaseen','Soggiorno'),('chirnside hall hotel','https://www.tripadvisor.co.uk/hotel_review-g319811-d314964-reviews-chirnside_hall_hotel-chirnside_scottish_borders_scotland.html','portmeirion','Soggiorno'),('achilty hotel','https://www.tripadvisor.co.uk/hotel_review-g551816-d313534-reviews-achilty_hotel-contin_ross_and_cromarty_scottish_highlands_scotland.html','achnaseen','Soggiorno'),('the white swan hotel','https://www.tripadvisor.co.uk/hotel_review-g551951-d664608-reviews-the_white_swan_hotel-duns_scottish_borders_scotland.html','portmeirion','Soggiorno'),('edinbane lodge','https://www.tripadvisor.co.uk/hotel_review-g562823-d279601-reviews-edinbane_lodge-edinbane_isle_of_skye_the_hebrides_scotland.html','garve','Soggiorno'),('overscaig house hotel','https://www.tripadvisor.co.uk/hotel_review-g635690-d1062089-reviews-overscaig_house_hotel-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Soggiorno'),('the castle hotel','https://www.tripadvisor.co.uk/hotel_review-g940866-d1167683-reviews-the_castle_hotel-coldstream_scottish_borders_scotland.html','portmeirion','Soggiorno'),('the struy inn','https://www.tripadvisor.co.uk/restaurant_review-g2208342-d2691483-reviews-the_struy_inn-struy_scottish_highlands_scotland.html','garve','Giornata di relax'),('the whale tale','https://www.tripadvisor.co.uk/restaurant_review-g635690-d12365935-reviews-the_whale_tale-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('mac and wild','https://www.tripadvisor.co.uk/restaurant_review-g635690-d13447969-reviews-mac_and_wild-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('shin fry fish and chip shop','https://www.tripadvisor.co.uk/restaurant_review-g635690-d18546168-reviews-shin_fry_fish_and_chip_shop-lairg_caithness_and_sutherland_scottish_highlands_sc.html','lairg','Giornata di relax'),('inver lodge restaurant','https://www.tripadvisor.co.uk/restaurant_review-g635690-d1993256-reviews-inver_lodge_restaurant-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('achness hotel restaurant and bar','https://www.tripadvisor.co.uk/restaurant_review-g635690-d2653656-reviews-achness_hotel_restaurant_and_bar-lairg_caithness_and_sutherland_scottish_highland.html','lairg','Giornata di relax'),('the crofters restaurant','https://www.tripadvisor.co.uk/restaurant_review-g635690-d752921-reviews-the_crofters_restaurant-lairg_caithness_and_sutherland_scottish_highlands_scotland.html','lairg','Giornata di relax'),('PR','www.it.it','Napoli','Soggiorno');
/*!40000 ALTER TABLE `VIAGGIO` ENABLE KEYS */;
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
