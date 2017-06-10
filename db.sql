CREATE DATABASE  IF NOT EXISTS `zy_crm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `zy_crm`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: zy_crm
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
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `receive_id` int(11) NOT NULL DEFAULT '0',
  `subject` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `text` text COLLATE utf8_unicode_ci NOT NULL,
  `pub_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `expire_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '2',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `creater` int(11) NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updater` int(11) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,0,'欢迎沙僧加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。 ','2017-06-10 04:33:52','2017-06-10 04:33:52',2,NULL,'2017-06-10 04:33:52',2,'2017-06-10 04:33:52',2),(2,0,'欢迎沙僧加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。','2017-06-10 04:33:52','2017-06-10 04:33:52',2,NULL,'2017-06-10 04:33:52',2,'2017-06-10 04:33:52',2),(3,0,'欢迎沙僧加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。','2017-06-10 04:33:52','2017-06-10 04:33:52',2,NULL,'2017-06-10 04:33:52',2,'2017-06-10 04:33:52',2),(4,0,'欢迎猪八戒加入取经团队','猪八戒是吴承恩所作《西游记》中的角色。又名猪刚鬣，法号悟能，浑名八戒，是唐僧的二徒弟，会三十六天罡变，所持武器为太上老君所造、玉皇大帝亲赐的上宝沁金钯（俗称九齿钉钯）。猪八戒前世为执掌天河八万水军的天蓬元帅。《 西游记》中各路神仙基本借鉴了正统道教神仙录，由高老庄一集猪八戒提及可见，猪八戒的前世天蓬元帅即是水神天河宪节。\r\n因调戏霓裳仙子并且惹来纠察灵官后，又拱倒斗牛宫被贬下凡尘，却又错投猪胎，后受观音点化，成为唐僧的弟子，与孙悟空一同保护唐僧去西天取经，最后被封为净坛使者。','2017-06-10 04:33:52','2017-06-10 04:33:52',2,NULL,'2017-06-10 04:33:52',2,'2017-06-10 04:33:52',2),(5,0,'欢迎猪八戒加入取经团队','猪八戒是吴承恩所作《西游记》中的角色。又名猪刚鬣，法号悟能，浑名八戒，是唐僧的二徒弟，会三十六天罡变，所持武器为太上老君所造、玉皇大帝亲赐的上宝沁金钯（俗称九齿钉钯）。猪八戒前世为执掌天河八万水军的天蓬元帅。《 西游记》中各路神仙基本借鉴了正统道教神仙录，由高老庄一集猪八戒提及可见，猪八戒的前世天蓬元帅即是水神天河宪节。','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-10 04:20:12',2,'2017-06-10 04:20:12',0),(6,0,'欢迎猪八戒加入取经团队','猪八戒是吴承恩所作《西游记》中的角色。又名猪刚鬣，法号悟能，浑名八戒，是唐僧的二徒弟，会三十六天罡变，所持武器为太上老君所造、玉皇大帝亲赐的上宝沁金钯（俗称九齿钉钯）。猪八戒前世为执掌天河八万水军的天蓬元帅。《 西游记》中各路神仙基本借鉴了正统道教神仙录，由高老庄一集猪八戒提及可见，猪八戒的前世天蓬元帅即是水神天河宪节。','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(7,0,'欢迎沙僧加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。 ','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(8,0,'欢迎猪八戒加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。 ','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(9,0,'欢迎沙僧加入取经团队','沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。 ','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(10,0,'欢迎猪八戒加入取经团队','猪八戒是吴承恩所作《西游记》中的角色。又名猪刚鬣，法号悟能，浑名八戒，是唐僧的二徒弟，会三十六天罡变，所持武器为太上老君所造、玉皇大帝亲赐的上宝沁金钯（俗称九齿钉钯）。猪八戒前世为执掌天河八万水军的天蓬元帅。《 西游记》中各路神仙基本借鉴了正统道教神仙录，由高老庄一集猪八戒提及可见，猪八戒的前世天蓬元帅即是水神天河宪节。','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(11,0,'欢迎猪八戒加入取经团队','猪八戒是吴承恩所作《西游记》中的角色。又名猪刚鬣，法号悟能，浑名八戒，是唐僧的二徒弟，会三十六天罡变，所持武器为太上老君所造、玉皇大帝亲赐的上宝沁金钯（俗称九齿钉钯）。猪八戒前世为执掌天河八万水军的天蓬元帅。《 西游记》中各路神仙基本借鉴了正统道教神仙录，由高老庄一集猪八戒提及可见，猪八戒的前世天蓬元帅即是水神天河宪节。','2017-06-08 10:47:39','2017-06-08 10:47:39',2,NULL,'2017-06-08 10:47:39',2,'2017-06-08 10:47:39',NULL),(12,0,'祝贺西天取经团队组建完成','经过领导和同志们的努力，西天取经团队终于组建完成，我们将日夜兼程更加努力，争取早日成功！感谢大家的支持！','2017-06-10 04:57:29','2017-06-10 04:57:29',-2,NULL,'2017-06-10 04:57:29',2,'2017-06-10 04:57:29',2);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `is_admin` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是管理员',
  `status` tinyint(4) NOT NULL DEFAULT '2' COMMENT '状态，2：正常，-2：删除',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注信息',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updater` int(11) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123456','',2,NULL,'2017-06-06 08:43:50',1,'2017-06-06 08:43:50',1),(2,'常伟','654321','',2,NULL,'2017-06-06 08:44:14',1,'2017-06-06 08:44:14',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-10 13:01:55
