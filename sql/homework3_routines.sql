CREATE DATABASE  IF NOT EXISTS `homework3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `homework3`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: homework3
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Temporary view structure for view `report`
--

DROP TABLE IF EXISTS `report`;
/*!50001 DROP VIEW IF EXISTS `report`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `report` AS SELECT 
 1 AS `userid`,
 1 AS `player`,
 1 AS `clockBeginnerPlayed`,
 1 AS `clockAdvancedPlayed`,
 1 AS `shoppingBeginnerPlayed`,
 1 AS `shoppingIntermediatePlayed`,
 1 AS `shoppingAdvancedPlayed`,
 1 AS `totalPlayTime`,
 1 AS `achievements`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_record`
--

DROP TABLE IF EXISTS `vw_record`;
/*!50001 DROP VIEW IF EXISTS `vw_record`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_record` AS SELECT 
 1 AS `id`,
 1 AS `player`,
 1 AS `game`,
 1 AS `level`,
 1 AS `star`,
 1 AS `startTime`,
 1 AS `endTime`,
 1 AS `duration`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `gamelevel_name`
--

DROP TABLE IF EXISTS `gamelevel_name`;
/*!50001 DROP VIEW IF EXISTS `gamelevel_name`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `gamelevel_name` AS SELECT 
 1 AS `id`,
 1 AS `gamename`,
 1 AS `level`,
 1 AS `description`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `achievement_record_detail`
--

DROP TABLE IF EXISTS `achievement_record_detail`;
/*!50001 DROP VIEW IF EXISTS `achievement_record_detail`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `achievement_record_detail` AS SELECT 
 1 AS `id`,
 1 AS `playername`,
 1 AS `achievementname`,
 1 AS `unlockDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `report`
--

/*!50001 DROP VIEW IF EXISTS `report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `report` AS select `p`.`id` AS `userid`,`p`.`username` AS `player`,sum((case when ((`gc`.`game` = '時間管理大師') and (`gl`.`level` = '初級')) then 1 else 0 end)) AS `clockBeginnerPlayed`,sum((case when ((`gc`.`game` = '時間管理大師') and (`gl`.`level` = '高級')) then 1 else 0 end)) AS `clockAdvancedPlayed`,sum((case when ((`gc`.`game` = '購物小能手') and (`gl`.`level` = '初級')) then 1 else 0 end)) AS `shoppingBeginnerPlayed`,sum((case when ((`gc`.`game` = '購物小能手') and (`gl`.`level` = '中級')) then 1 else 0 end)) AS `shoppingIntermediatePlayed`,sum((case when ((`gc`.`game` = '購物小能手') and (`gl`.`level` = '高級')) then 1 else 0 end)) AS `shoppingAdvancedPlayed`,coalesce(sum(`r`.`duration`),0) AS `totalPlayTime`,count(distinct `ar`.`id`) AS `achievements` from ((((`player` `p` left join `record` `r` on((`p`.`id` = `r`.`userid`))) left join `gamecategory` `gc` on((`r`.`gameid` = `gc`.`id`))) left join `gamelevel` `gl` on((`r`.`levelid` = `gl`.`id`))) left join `achievementrecord` `ar` on((`p`.`id` = `ar`.`userid`))) group by `p`.`id`,`p`.`username` order by `p`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_record`
--

/*!50001 DROP VIEW IF EXISTS `vw_record`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_record` AS select `record`.`id` AS `id`,`player`.`username` AS `player`,`gamecategory`.`game` AS `game`,`gamelevel`.`level` AS `level`,`record`.`star` AS `star`,`record`.`startTime` AS `startTime`,`record`.`endTime` AS `endTime`,`record`.`duration` AS `duration` from (((`record` join `player` on((`record`.`userid` = `player`.`id`))) join `gamecategory` on((`record`.`gameid` = `gamecategory`.`id`))) join `gamelevel` on((`record`.`levelid` = `gamelevel`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gamelevel_name`
--

/*!50001 DROP VIEW IF EXISTS `gamelevel_name`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gamelevel_name` AS select `gamelevel`.`id` AS `id`,`gamecategory`.`game` AS `gamename`,`gamelevel`.`level` AS `level`,`gamelevel`.`description` AS `description` from (`gamelevel` join `gamecategory` on((`gamelevel`.`game` = `gamecategory`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `achievement_record_detail`
--

/*!50001 DROP VIEW IF EXISTS `achievement_record_detail`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `achievement_record_detail` AS select `achievementrecord`.`id` AS `id`,`player`.`username` AS `playername`,`achievement`.`title` AS `achievementname`,`achievementrecord`.`unlockDate` AS `unlockDate` from ((`achievementrecord` join `achievement` on((`achievementrecord`.`achievement` = `achievement`.`id`))) join `player` on((`achievementrecord`.`userid` = `player`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-21  6:36:14
