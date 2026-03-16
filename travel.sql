-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: travel
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Current Database: `travel`
--

/*!40000 DROP DATABASE IF EXISTS `travel`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `travel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `travel`;

--
-- Table structure for table `baotuanxinxi`
--

DROP TABLE IF EXISTS `baotuanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baotuanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianlumingcheng` varchar(200) DEFAULT NULL COMMENT '线路名称',
  `xianlutupian` longtext COMMENT '线路图片',
  `chufariqi` date DEFAULT NULL COMMENT '出发日期',
  `xianlufeiyong` double NOT NULL COMMENT '线路费用',
  `xianluminge` int(11) NOT NULL COMMENT '报名人数',
  `baotuanjine` double NOT NULL COMMENT '报团金额',
  `daoyougonghao` varchar(200) DEFAULT NULL COMMENT '导游工号',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `baotuanshijian` date DEFAULT NULL COMMENT '报团时间',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 COMMENT='报团信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baotuanxinxi`
--

LOCK TABLES `baotuanxinxi` WRITE;
/*!40000 ALTER TABLE `baotuanxinxi` DISABLE KEYS */;
INSERT INTO `baotuanxinxi` VALUES (131,'2026-02-25 06:47:25','线路名称1','upload/baotuanxinxi_xianlutupian1.jpg,upload/baotuanxinxi_xianlutupian2.jpg,upload/baotuanxinxi_xianlutupian3.jpg','2026-02-25',1,1,1,'导游工号1','用户账号1','用户姓名1','13823888881','2026-02-25','未支付'),(132,'2026-02-25 06:47:25','线路名称2','upload/baotuanxinxi_xianlutupian2.jpg,upload/baotuanxinxi_xianlutupian3.jpg,upload/baotuanxinxi_xianlutupian4.jpg','2026-02-25',2,2,2,'导游工号2','用户账号2','用户姓名2','13823888882','2026-02-25','未支付'),(133,'2026-02-25 06:47:25','线路名称3','upload/baotuanxinxi_xianlutupian3.jpg,upload/baotuanxinxi_xianlutupian4.jpg,upload/baotuanxinxi_xianlutupian5.jpg','2026-02-25',3,3,3,'导游工号3','用户账号3','用户姓名3','13823888883','2026-02-25','未支付'),(134,'2026-02-25 06:47:25','线路名称4','upload/baotuanxinxi_xianlutupian4.jpg,upload/baotuanxinxi_xianlutupian5.jpg,upload/baotuanxinxi_xianlutupian6.jpg','2026-02-25',4,4,4,'导游工号4','用户账号4','用户姓名4','13823888884','2026-02-25','未支付'),(135,'2026-02-25 06:47:25','线路名称5','upload/baotuanxinxi_xianlutupian5.jpg,upload/baotuanxinxi_xianlutupian6.jpg,upload/baotuanxinxi_xianlutupian7.jpg','2026-02-25',5,5,5,'导游工号5','用户账号5','用户姓名5','13823888885','2026-02-25','未支付'),(136,'2026-02-25 06:47:25','线路名称6','upload/baotuanxinxi_xianlutupian6.jpg,upload/baotuanxinxi_xianlutupian7.jpg,upload/baotuanxinxi_xianlutupian8.jpg','2026-02-25',6,6,6,'导游工号6','用户账号6','用户姓名6','13823888886','2026-02-25','未支付'),(137,'2026-02-25 06:47:25','线路名称7','upload/baotuanxinxi_xianlutupian7.jpg,upload/baotuanxinxi_xianlutupian8.jpg,upload/baotuanxinxi_xianlutupian9.jpg','2026-02-25',7,7,7,'导游工号7','用户账号7','用户姓名7','13823888887','2026-02-25','未支付'),(138,'2026-02-25 06:47:25','线路名称8','upload/baotuanxinxi_xianlutupian8.jpg,upload/baotuanxinxi_xianlutupian9.jpg,upload/baotuanxinxi_xianlutupian10.jpg','2026-02-25',8,8,8,'导游工号8','用户账号8','用户姓名8','13823888888','2026-02-25','未支付');
/*!40000 ALTER TABLE `baotuanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cantingyuyue`
--

DROP TABLE IF EXISTS `cantingyuyue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cantingyuyue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cantingmingcheng` varchar(200) DEFAULT NULL COMMENT '餐厅名称',
  `cantingtupian` longtext COMMENT '餐厅图片',
  `cantingleixing` varchar(200) DEFAULT NULL COMMENT '餐厅类型',
  `yongcanrenshu` int(11) NOT NULL COMMENT '用餐人数',
  `yuyueshijian` datetime DEFAULT NULL COMMENT '预约时间',
  `yongcanbeizhu` longtext COMMENT '用餐备注',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='餐厅预约';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cantingyuyue`
--

LOCK TABLES `cantingyuyue` WRITE;
/*!40000 ALTER TABLE `cantingyuyue` DISABLE KEYS */;
INSERT INTO `cantingyuyue` VALUES (101,'2026-02-25 06:47:25','餐厅名称1','upload/cantingyuyue_cantingtupian1.jpg,upload/cantingyuyue_cantingtupian2.jpg,upload/cantingyuyue_cantingtupian3.jpg','餐厅类型1',1,'2026-02-25 14:47:25','用餐备注1','用户账号1','用户姓名1','联系方式1','是',''),(102,'2026-02-25 06:47:25','餐厅名称2','upload/cantingyuyue_cantingtupian2.jpg,upload/cantingyuyue_cantingtupian3.jpg,upload/cantingyuyue_cantingtupian4.jpg','餐厅类型2',2,'2026-02-25 14:47:25','用餐备注2','用户账号2','用户姓名2','联系方式2','是',''),(103,'2026-02-25 06:47:25','餐厅名称3','upload/cantingyuyue_cantingtupian3.jpg,upload/cantingyuyue_cantingtupian4.jpg,upload/cantingyuyue_cantingtupian5.jpg','餐厅类型3',3,'2026-02-25 14:47:25','用餐备注3','用户账号3','用户姓名3','联系方式3','是',''),(104,'2026-02-25 06:47:25','餐厅名称4','upload/cantingyuyue_cantingtupian4.jpg,upload/cantingyuyue_cantingtupian5.jpg,upload/cantingyuyue_cantingtupian6.jpg','餐厅类型4',4,'2026-02-25 14:47:25','用餐备注4','用户账号4','用户姓名4','联系方式4','是',''),(105,'2026-02-25 06:47:25','餐厅名称5','upload/cantingyuyue_cantingtupian5.jpg,upload/cantingyuyue_cantingtupian6.jpg,upload/cantingyuyue_cantingtupian7.jpg','餐厅类型5',5,'2026-02-25 14:47:25','用餐备注5','用户账号5','用户姓名5','联系方式5','是',''),(106,'2026-02-25 06:47:25','餐厅名称6','upload/cantingyuyue_cantingtupian6.jpg,upload/cantingyuyue_cantingtupian7.jpg,upload/cantingyuyue_cantingtupian8.jpg','餐厅类型6',6,'2026-02-25 14:47:25','用餐备注6','用户账号6','用户姓名6','联系方式6','是',''),(107,'2026-02-25 06:47:25','餐厅名称7','upload/cantingyuyue_cantingtupian7.jpg,upload/cantingyuyue_cantingtupian8.jpg,upload/cantingyuyue_cantingtupian9.jpg','餐厅类型7',7,'2026-02-25 14:47:25','用餐备注7','用户账号7','用户姓名7','联系方式7','是',''),(108,'2026-02-25 06:47:25','餐厅名称8','upload/cantingyuyue_cantingtupian8.jpg,upload/cantingyuyue_cantingtupian9.jpg,upload/cantingyuyue_cantingtupian10.jpg','餐厅类型8',8,'2026-02-25 14:47:25','用餐备注8','用户账号8','用户姓名8','联系方式8','是','');
/*!40000 ALTER TABLE `cantingyuyue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT '0' COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL),(2,'picture2','upload/picture2.jpg',NULL),(3,'picture3','upload/picture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daoyou`
--

DROP TABLE IF EXISTS `daoyou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daoyou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `daoyougonghao` varchar(200) NOT NULL COMMENT '导游工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `daoyouxingming` varchar(200) NOT NULL COMMENT '导游姓名',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `zhuanyelingyu` varchar(200) DEFAULT NULL COMMENT '专业领域',
  `yuyannengli` varchar(200) DEFAULT NULL COMMENT '语言能力',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `gerenlvli` longtext COMMENT '个人履历',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  `passwordwrongnum` int(11) DEFAULT '0' COMMENT '密码错误次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `daoyougonghao` (`daoyougonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='导游';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daoyou`
--

LOCK TABLES `daoyou` WRITE;
/*!40000 ALTER TABLE `daoyou` DISABLE KEYS */;
INSERT INTO `daoyou` VALUES (21,'2026-02-25 06:47:25','导游工号1','123456','导游姓名1','头像1','专业领域1','语言能力1','13823888881','个人履历1',0,0),(22,'2026-02-25 06:47:25','导游工号2','123456','导游姓名2','头像2','专业领域2','语言能力2','13823888882','个人履历2',0,0),(23,'2026-02-25 06:47:25','导游工号3','123456','导游姓名3','头像3','专业领域3','语言能力3','13823888883','个人履历3',0,0),(24,'2026-02-25 06:47:25','导游工号4','123456','导游姓名4','头像4','专业领域4','语言能力4','13823888884','个人履历4',0,0),(25,'2026-02-25 06:47:25','导游工号5','123456','导游姓名5','头像5','专业领域5','语言能力5','13823888885','个人履历5',0,0),(26,'2026-02-25 06:47:25','导游工号6','123456','导游姓名6','头像6','专业领域6','语言能力6','13823888886','个人履历6',0,0),(27,'2026-02-25 06:47:25','导游工号7','123456','导游姓名7','头像7','专业领域7','语言能力7','13823888887','个人履历7',0,0),(28,'2026-02-25 06:47:25','导游工号8','123456','导游姓名8','头像8','专业领域8','语言能力8','13823888888','个人履历8',0,0);
/*!40000 ALTER TABLE `daoyou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjiudianxinxi`
--

DROP TABLE IF EXISTS `discussjiudianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjiudianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `score` double DEFAULT NULL COMMENT '评分',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='酒店信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjiudianxinxi`
--

LOCK TABLES `discussjiudianxinxi` WRITE;
/*!40000 ALTER TABLE `discussjiudianxinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussjiudianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusslvyougonglve`
--

DROP TABLE IF EXISTS `discusslvyougonglve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusslvyougonglve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='旅游攻略评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusslvyougonglve`
--

LOCK TABLES `discusslvyougonglve` WRITE;
/*!40000 ALTER TABLE `discusslvyougonglve` DISABLE KEYS */;
/*!40000 ALTER TABLE `discusslvyougonglve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusslvyouxianlu`
--

DROP TABLE IF EXISTS `discusslvyouxianlu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusslvyouxianlu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='旅游线路评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusslvyouxianlu`
--

LOCK TABLES `discusslvyouxianlu` WRITE;
/*!40000 ALTER TABLE `discusslvyouxianlu` DISABLE KEYS */;
/*!40000 ALTER TABLE `discusslvyouxianlu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussmeishicanting`
--

DROP TABLE IF EXISTS `discussmeishicanting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussmeishicanting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `score` double DEFAULT NULL COMMENT '评分',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='美食餐厅评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussmeishicanting`
--

LOCK TABLES `discussmeishicanting` WRITE;
/*!40000 ALTER TABLE `discussmeishicanting` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussmeishicanting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussremenjingdian`
--

DROP TABLE IF EXISTS `discussremenjingdian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussremenjingdian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `score` double DEFAULT NULL COMMENT '评分',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热门景点评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussremenjingdian`
--

LOCK TABLES `discussremenjingdian` WRITE;
/*!40000 ALTER TABLE `discussremenjingdian` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussremenjingdian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `toptime` datetime DEFAULT NULL COMMENT '置顶时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='交流论坛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (171,'2026-02-25 06:47:25','帖子标题1','帖子内容1',0,1,'用户名1','upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg','开放',0,'2026-02-25 14:47:25'),(172,'2026-02-25 06:47:25','帖子标题2','帖子内容2',0,2,'用户名2','upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg','开放',0,'2026-02-25 14:47:25'),(173,'2026-02-25 06:47:25','帖子标题3','帖子内容3',0,3,'用户名3','upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg','开放',0,'2026-02-25 14:47:25'),(174,'2026-02-25 06:47:25','帖子标题4','帖子内容4',0,4,'用户名4','upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg','开放',0,'2026-02-25 14:47:25'),(175,'2026-02-25 06:47:25','帖子标题5','帖子内容5',0,5,'用户名5','upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg','开放',0,'2026-02-25 14:47:25'),(176,'2026-02-25 06:47:25','帖子标题6','帖子内容6',0,6,'用户名6','upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg','开放',0,'2026-02-25 14:47:25'),(177,'2026-02-25 06:47:25','帖子标题7','帖子内容7',0,7,'用户名7','upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg','开放',0,'2026-02-25 14:47:25'),(178,'2026-02-25 06:47:25','帖子标题8','帖子内容8',0,8,'用户名8','upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg,upload/forum_avatarurl10.jpg','开放',0,'2026-02-25 14:47:25');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendlink`
--

DROP TABLE IF EXISTS `friendlink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendlink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext COMMENT '图片',
  `url` longtext COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='友情链接';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendlink`
--

LOCK TABLES `friendlink` WRITE;
/*!40000 ALTER TABLE `friendlink` DISABLE KEYS */;
INSERT INTO `friendlink` VALUES (1,'2026-02-25 06:47:26','爱奇艺','upload/fl_aqy.png','https://www.iqiyi.com/'),(2,'2026-02-25 06:47:26','百度','upload/fl_bd.png','https://www.baidu.com/'),(3,'2026-02-25 06:47:26','京东','upload/fl_jd.png','https://www.jd.com/'),(4,'2026-02-25 06:47:26','搜狐','upload/fl_sh.png','https://www.sohu.com/'),(5,'2026-02-25 06:47:26','腾讯','upload/fl_tx.png','https://www.qq.com/'),(6,'2026-02-25 06:47:26','网易','upload/fl_wy.png','https://www.163.com/'),(7,'2026-02-25 06:47:26','新浪','upload/fl_xl.png','https://www.sina.com.cn/'),(8,'2026-02-25 06:47:26','知乎','upload/fl_zh.png','https://www.zhihu.com/');
/*!40000 ALTER TABLE `friendlink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingdianleixing`
--

DROP TABLE IF EXISTS `jingdianleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingdianleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingdianleixing` varchar(200) DEFAULT NULL COMMENT '景点类型',
  `image` longtext COMMENT '图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jingdianleixing` (`jingdianleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='景点类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingdianleixing`
--

LOCK TABLES `jingdianleixing` WRITE;
/*!40000 ALTER TABLE `jingdianleixing` DISABLE KEYS */;
INSERT INTO `jingdianleixing` VALUES (31,'2026-02-25 06:47:25','景点类型1','upload/jingdianleixing_image1.jpg,upload/jingdianleixing_image2.jpg,upload/jingdianleixing_image3.jpg'),(32,'2026-02-25 06:47:25','景点类型2','upload/jingdianleixing_image2.jpg,upload/jingdianleixing_image3.jpg,upload/jingdianleixing_image4.jpg'),(33,'2026-02-25 06:47:25','景点类型3','upload/jingdianleixing_image3.jpg,upload/jingdianleixing_image4.jpg,upload/jingdianleixing_image5.jpg'),(34,'2026-02-25 06:47:25','景点类型4','upload/jingdianleixing_image4.jpg,upload/jingdianleixing_image5.jpg,upload/jingdianleixing_image6.jpg'),(35,'2026-02-25 06:47:25','景点类型5','upload/jingdianleixing_image5.jpg,upload/jingdianleixing_image6.jpg,upload/jingdianleixing_image7.jpg'),(36,'2026-02-25 06:47:25','景点类型6','upload/jingdianleixing_image6.jpg,upload/jingdianleixing_image7.jpg,upload/jingdianleixing_image8.jpg'),(37,'2026-02-25 06:47:25','景点类型7','upload/jingdianleixing_image7.jpg,upload/jingdianleixing_image8.jpg,upload/jingdianleixing_image9.jpg'),(38,'2026-02-25 06:47:25','景点类型8','upload/jingdianleixing_image8.jpg,upload/jingdianleixing_image9.jpg,upload/jingdianleixing_image10.jpg');
/*!40000 ALTER TABLE `jingdianleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiudianxinxi`
--

DROP TABLE IF EXISTS `jiudianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiudianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kefangmingcheng` varchar(200) DEFAULT NULL COMMENT '客房名称',
  `kefangtupian` longtext COMMENT '客房图片',
  `kefangleixing` varchar(200) DEFAULT NULL COMMENT '客房类型',
  `kefangsheshi` varchar(200) DEFAULT NULL COMMENT '客房设施',
  `kefangjiage` int(11) DEFAULT NULL COMMENT '客房价格',
  `kefangshuliang` int(11) DEFAULT NULL COMMENT '客房数量',
  `kefangjieshao` longtext COMMENT '客房介绍',
  `jiudianmingcheng` varchar(200) DEFAULT NULL COMMENT '酒店名称',
  `jiudiandizhi` varchar(200) DEFAULT NULL COMMENT '酒店地址',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='酒店信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiudianxinxi`
--

LOCK TABLES `jiudianxinxi` WRITE;
/*!40000 ALTER TABLE `jiudianxinxi` DISABLE KEYS */;
INSERT INTO `jiudianxinxi` VALUES (71,'2026-02-25 06:47:25','客房名称1','upload/jiudianxinxi_kefangtupian1.jpg,upload/jiudianxinxi_kefangtupian2.jpg,upload/jiudianxinxi_kefangtupian3.jpg','客房类型1','客房设施1',1,1,'客房介绍1','酒店名称1','酒店地址1','2026-02-25 14:47:25',1,0,1),(72,'2026-02-25 06:47:25','客房名称2','upload/jiudianxinxi_kefangtupian2.jpg,upload/jiudianxinxi_kefangtupian3.jpg,upload/jiudianxinxi_kefangtupian4.jpg','客房类型2','客房设施2',2,2,'客房介绍2','酒店名称2','酒店地址2','2026-02-25 14:47:25',2,0,2),(73,'2026-02-25 06:47:25','客房名称3','upload/jiudianxinxi_kefangtupian3.jpg,upload/jiudianxinxi_kefangtupian4.jpg,upload/jiudianxinxi_kefangtupian5.jpg','客房类型3','客房设施3',3,3,'客房介绍3','酒店名称3','酒店地址3','2026-02-25 14:47:25',3,0,3),(74,'2026-02-25 06:47:25','客房名称4','upload/jiudianxinxi_kefangtupian4.jpg,upload/jiudianxinxi_kefangtupian5.jpg,upload/jiudianxinxi_kefangtupian6.jpg','客房类型4','客房设施4',4,4,'客房介绍4','酒店名称4','酒店地址4','2026-02-25 14:47:25',4,0,4),(75,'2026-02-25 06:47:25','客房名称5','upload/jiudianxinxi_kefangtupian5.jpg,upload/jiudianxinxi_kefangtupian6.jpg,upload/jiudianxinxi_kefangtupian7.jpg','客房类型5','客房设施5',5,5,'客房介绍5','酒店名称5','酒店地址5','2026-02-25 14:47:25',5,0,5),(76,'2026-02-25 06:47:25','客房名称6','upload/jiudianxinxi_kefangtupian6.jpg,upload/jiudianxinxi_kefangtupian7.jpg,upload/jiudianxinxi_kefangtupian8.jpg','客房类型6','客房设施6',6,6,'客房介绍6','酒店名称6','酒店地址6','2026-02-25 14:47:25',6,0,6),(77,'2026-02-25 06:47:25','客房名称7','upload/jiudianxinxi_kefangtupian7.jpg,upload/jiudianxinxi_kefangtupian8.jpg,upload/jiudianxinxi_kefangtupian9.jpg','客房类型7','客房设施7',7,7,'客房介绍7','酒店名称7','酒店地址7','2026-02-25 14:47:25',7,0,7),(78,'2026-02-25 06:47:25','客房名称8','upload/jiudianxinxi_kefangtupian8.jpg,upload/jiudianxinxi_kefangtupian9.jpg,upload/jiudianxinxi_kefangtupian10.jpg','客房类型8','客房设施8',8,8,'客房介绍8','酒店名称8','酒店地址8','2026-02-25 14:47:25',8,0,8);
/*!40000 ALTER TABLE `jiudianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiudianyuding`
--

DROP TABLE IF EXISTS `jiudianyuding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiudianyuding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yudingdanhao` varchar(200) DEFAULT NULL COMMENT '预订单号',
  `kefangmingcheng` varchar(200) DEFAULT NULL COMMENT '客房名称',
  `kefangtupian` longtext COMMENT '客房图片',
  `kefangjiage` int(11) DEFAULT NULL COMMENT '客房价格',
  `kefangshuliang` int(11) NOT NULL COMMENT '客房数量',
  `ruzhutianshu` int(11) NOT NULL COMMENT '入住天数',
  `zongjine` double DEFAULT NULL COMMENT '总金额',
  `jiudianmingcheng` varchar(200) DEFAULT NULL COMMENT '酒店名称',
  `yuyueshijian` datetime DEFAULT NULL COMMENT '预约时间',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yudingdanhao` (`yudingdanhao`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='酒店预订';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiudianyuding`
--

LOCK TABLES `jiudianyuding` WRITE;
/*!40000 ALTER TABLE `jiudianyuding` DISABLE KEYS */;
INSERT INTO `jiudianyuding` VALUES (81,'2026-02-25 06:47:25','1111111111','客房名称1','upload/jiudianyuding_kefangtupian1.jpg,upload/jiudianyuding_kefangtupian2.jpg,upload/jiudianyuding_kefangtupian3.jpg',1,1,1,1,'酒店名称1','2026-02-25 14:47:25','用户账号1','用户姓名1','13823888881','未支付'),(82,'2026-02-25 06:47:25','2222222222','客房名称2','upload/jiudianyuding_kefangtupian2.jpg,upload/jiudianyuding_kefangtupian3.jpg,upload/jiudianyuding_kefangtupian4.jpg',2,2,2,2,'酒店名称2','2026-02-25 14:47:25','用户账号2','用户姓名2','13823888882','未支付'),(83,'2026-02-25 06:47:25','3333333333','客房名称3','upload/jiudianyuding_kefangtupian3.jpg,upload/jiudianyuding_kefangtupian4.jpg,upload/jiudianyuding_kefangtupian5.jpg',3,3,3,3,'酒店名称3','2026-02-25 14:47:25','用户账号3','用户姓名3','13823888883','未支付'),(84,'2026-02-25 06:47:25','4444444444','客房名称4','upload/jiudianyuding_kefangtupian4.jpg,upload/jiudianyuding_kefangtupian5.jpg,upload/jiudianyuding_kefangtupian6.jpg',4,4,4,4,'酒店名称4','2026-02-25 14:47:25','用户账号4','用户姓名4','13823888884','未支付'),(85,'2026-02-25 06:47:25','5555555555','客房名称5','upload/jiudianyuding_kefangtupian5.jpg,upload/jiudianyuding_kefangtupian6.jpg,upload/jiudianyuding_kefangtupian7.jpg',5,5,5,5,'酒店名称5','2026-02-25 14:47:25','用户账号5','用户姓名5','13823888885','未支付'),(86,'2026-02-25 06:47:25','6666666666','客房名称6','upload/jiudianyuding_kefangtupian6.jpg,upload/jiudianyuding_kefangtupian7.jpg,upload/jiudianyuding_kefangtupian8.jpg',6,6,6,6,'酒店名称6','2026-02-25 14:47:25','用户账号6','用户姓名6','13823888886','未支付'),(87,'2026-02-25 06:47:25','7777777777','客房名称7','upload/jiudianyuding_kefangtupian7.jpg,upload/jiudianyuding_kefangtupian8.jpg,upload/jiudianyuding_kefangtupian9.jpg',7,7,7,7,'酒店名称7','2026-02-25 14:47:25','用户账号7','用户姓名7','13823888887','未支付'),(88,'2026-02-25 06:47:25','8888888888','客房名称8','upload/jiudianyuding_kefangtupian8.jpg,upload/jiudianyuding_kefangtupian9.jpg,upload/jiudianyuding_kefangtupian10.jpg',8,8,8,8,'酒店名称8','2026-02-25 14:47:25','用户账号8','用户姓名8','13823888888','未支付');
/*!40000 ALTER TABLE `jiudianyuding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kefangleixing`
--

DROP TABLE IF EXISTS `kefangleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kefangleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kefangleixing` varchar(200) DEFAULT NULL COMMENT '客房类型',
  `image` longtext COMMENT '图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kefangleixing` (`kefangleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='客房类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kefangleixing`
--

LOCK TABLES `kefangleixing` WRITE;
/*!40000 ALTER TABLE `kefangleixing` DISABLE KEYS */;
INSERT INTO `kefangleixing` VALUES (61,'2026-02-25 06:47:25','客房类型1','upload/kefangleixing_image1.jpg,upload/kefangleixing_image2.jpg,upload/kefangleixing_image3.jpg'),(62,'2026-02-25 06:47:25','客房类型2','upload/kefangleixing_image2.jpg,upload/kefangleixing_image3.jpg,upload/kefangleixing_image4.jpg'),(63,'2026-02-25 06:47:25','客房类型3','upload/kefangleixing_image3.jpg,upload/kefangleixing_image4.jpg,upload/kefangleixing_image5.jpg'),(64,'2026-02-25 06:47:25','客房类型4','upload/kefangleixing_image4.jpg,upload/kefangleixing_image5.jpg,upload/kefangleixing_image6.jpg'),(65,'2026-02-25 06:47:25','客房类型5','upload/kefangleixing_image5.jpg,upload/kefangleixing_image6.jpg,upload/kefangleixing_image7.jpg'),(66,'2026-02-25 06:47:25','客房类型6','upload/kefangleixing_image6.jpg,upload/kefangleixing_image7.jpg,upload/kefangleixing_image8.jpg'),(67,'2026-02-25 06:47:25','客房类型7','upload/kefangleixing_image7.jpg,upload/kefangleixing_image8.jpg,upload/kefangleixing_image9.jpg'),(68,'2026-02-25 06:47:25','客房类型8','upload/kefangleixing_image8.jpg,upload/kefangleixing_image9.jpg,upload/kefangleixing_image10.jpg');
/*!40000 ALTER TABLE `kefangleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lvyougonglve`
--

DROP TABLE IF EXISTS `lvyougonglve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lvyougonglve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonglvebiaoti` varchar(200) DEFAULT NULL COMMENT '攻略标题',
  `jingdianfengmian` longtext COMMENT '景点封面',
  `jingdianmingcheng` varchar(200) DEFAULT NULL COMMENT '包含景点',
  `chufachengshi` varchar(200) DEFAULT NULL COMMENT '出发城市',
  `xingchengtianshu` varchar(200) DEFAULT NULL COMMENT '行程天数',
  `xingchengjuli` varchar(200) DEFAULT NULL COMMENT '行程距离',
  `jiaotonggongju` varchar(200) DEFAULT NULL COMMENT '交通工具',
  `xingchengluxian` longtext COMMENT '行程路线',
  `gonglvexiangqing` longtext COMMENT '攻略详情',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COMMENT='旅游攻略';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lvyougonglve`
--

LOCK TABLES `lvyougonglve` WRITE;
/*!40000 ALTER TABLE `lvyougonglve` DISABLE KEYS */;
INSERT INTO `lvyougonglve` VALUES (141,'2026-02-25 06:47:25','攻略标题1','upload/lvyougonglve_jingdianfengmian1.jpg,upload/lvyougonglve_jingdianfengmian2.jpg,upload/lvyougonglve_jingdianfengmian3.jpg','包含景点1','出发城市1','行程天数1','行程距离1','汽车','行程路线1','攻略详情1','用户账号1',1,1,0,1),(142,'2026-02-25 06:47:25','攻略标题2','upload/lvyougonglve_jingdianfengmian2.jpg,upload/lvyougonglve_jingdianfengmian3.jpg,upload/lvyougonglve_jingdianfengmian4.jpg','包含景点2','出发城市2','行程天数2','行程距离2','汽车','行程路线2','攻略详情2','用户账号2',2,2,0,2),(143,'2026-02-25 06:47:25','攻略标题3','upload/lvyougonglve_jingdianfengmian3.jpg,upload/lvyougonglve_jingdianfengmian4.jpg,upload/lvyougonglve_jingdianfengmian5.jpg','包含景点3','出发城市3','行程天数3','行程距离3','汽车','行程路线3','攻略详情3','用户账号3',3,3,0,3),(144,'2026-02-25 06:47:25','攻略标题4','upload/lvyougonglve_jingdianfengmian4.jpg,upload/lvyougonglve_jingdianfengmian5.jpg,upload/lvyougonglve_jingdianfengmian6.jpg','包含景点4','出发城市4','行程天数4','行程距离4','汽车','行程路线4','攻略详情4','用户账号4',4,4,0,4),(145,'2026-02-25 06:47:25','攻略标题5','upload/lvyougonglve_jingdianfengmian5.jpg,upload/lvyougonglve_jingdianfengmian6.jpg,upload/lvyougonglve_jingdianfengmian7.jpg','包含景点5','出发城市5','行程天数5','行程距离5','汽车','行程路线5','攻略详情5','用户账号5',5,5,0,5),(146,'2026-02-25 06:47:25','攻略标题6','upload/lvyougonglve_jingdianfengmian6.jpg,upload/lvyougonglve_jingdianfengmian7.jpg,upload/lvyougonglve_jingdianfengmian8.jpg','包含景点6','出发城市6','行程天数6','行程距离6','汽车','行程路线6','攻略详情6','用户账号6',6,6,0,6),(147,'2026-02-25 06:47:25','攻略标题7','upload/lvyougonglve_jingdianfengmian7.jpg,upload/lvyougonglve_jingdianfengmian8.jpg,upload/lvyougonglve_jingdianfengmian9.jpg','包含景点7','出发城市7','行程天数7','行程距离7','汽车','行程路线7','攻略详情7','用户账号7',7,7,0,7),(148,'2026-02-25 06:47:25','攻略标题8','upload/lvyougonglve_jingdianfengmian8.jpg,upload/lvyougonglve_jingdianfengmian9.jpg,upload/lvyougonglve_jingdianfengmian10.jpg','包含景点8','出发城市8','行程天数8','行程距离8','汽车','行程路线8','攻略详情8','用户账号8',8,8,0,8);
/*!40000 ALTER TABLE `lvyougonglve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lvyouxianlu`
--

DROP TABLE IF EXISTS `lvyouxianlu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lvyouxianlu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianlumingcheng` varchar(200) NOT NULL COMMENT '线路名称',
  `xianlutupian` longtext COMMENT '线路图片',
  `jingdianmingcheng` varchar(200) NOT NULL COMMENT '景点名称',
  `jingdianleixing` varchar(200) DEFAULT NULL COMMENT '景点类型',
  `jingdianweizhi` varchar(200) NOT NULL COMMENT '景点位置',
  `qidian` varchar(200) DEFAULT NULL COMMENT '起点',
  `tujingluduan` varchar(200) DEFAULT NULL COMMENT '途径路段',
  `zhongdian` varchar(200) DEFAULT NULL COMMENT '终点',
  `xianlufeiyong` double NOT NULL COMMENT '线路费用',
  `baotuanminge` int(11) DEFAULT NULL COMMENT '报团名额',
  `chufariqi` datetime DEFAULT NULL COMMENT '出发日期',
  `jiaotongfangshi` varchar(200) DEFAULT NULL COMMENT '交通方式',
  `xianluxiangqing` longtext COMMENT '线路详情',
  `daoyougonghao` varchar(200) DEFAULT NULL COMMENT '导游工号',
  `daoyouxingming` varchar(200) DEFAULT NULL COMMENT '导游姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `gerenlvli` longtext COMMENT '导游介绍',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COMMENT='旅游线路';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lvyouxianlu`
--

LOCK TABLES `lvyouxianlu` WRITE;
/*!40000 ALTER TABLE `lvyouxianlu` DISABLE KEYS */;
INSERT INTO `lvyouxianlu` VALUES (121,'2026-02-25 06:47:25','线路名称1','upload/lvyouxianlu_xianlutupian1.jpg,upload/lvyouxianlu_xianlutupian2.jpg,upload/lvyouxianlu_xianlutupian3.jpg','景点名称1','景点类型1','景点位置1','起点1','途径路段1','终点1',1,1,'2026-02-25 14:47:25','交通方式1','线路详情1','导游工号1','导游姓名1','13823888881','导游介绍1',1,1,0,1),(122,'2026-02-25 06:47:25','线路名称2','upload/lvyouxianlu_xianlutupian2.jpg,upload/lvyouxianlu_xianlutupian3.jpg,upload/lvyouxianlu_xianlutupian4.jpg','景点名称2','景点类型2','景点位置2','起点2','途径路段2','终点2',2,2,'2026-02-25 14:47:25','交通方式2','线路详情2','导游工号2','导游姓名2','13823888882','导游介绍2',2,2,0,2),(123,'2026-02-25 06:47:25','线路名称3','upload/lvyouxianlu_xianlutupian3.jpg,upload/lvyouxianlu_xianlutupian4.jpg,upload/lvyouxianlu_xianlutupian5.jpg','景点名称3','景点类型3','景点位置3','起点3','途径路段3','终点3',3,3,'2026-02-25 14:47:25','交通方式3','线路详情3','导游工号3','导游姓名3','13823888883','导游介绍3',3,3,0,3),(124,'2026-02-25 06:47:25','线路名称4','upload/lvyouxianlu_xianlutupian4.jpg,upload/lvyouxianlu_xianlutupian5.jpg,upload/lvyouxianlu_xianlutupian6.jpg','景点名称4','景点类型4','景点位置4','起点4','途径路段4','终点4',4,4,'2026-02-25 14:47:25','交通方式4','线路详情4','导游工号4','导游姓名4','13823888884','导游介绍4',4,4,0,4),(125,'2026-02-25 06:47:25','线路名称5','upload/lvyouxianlu_xianlutupian5.jpg,upload/lvyouxianlu_xianlutupian6.jpg,upload/lvyouxianlu_xianlutupian7.jpg','景点名称5','景点类型5','景点位置5','起点5','途径路段5','终点5',5,5,'2026-02-25 14:47:25','交通方式5','线路详情5','导游工号5','导游姓名5','13823888885','导游介绍5',5,5,0,5),(126,'2026-02-25 06:47:25','线路名称6','upload/lvyouxianlu_xianlutupian6.jpg,upload/lvyouxianlu_xianlutupian7.jpg,upload/lvyouxianlu_xianlutupian8.jpg','景点名称6','景点类型6','景点位置6','起点6','途径路段6','终点6',6,6,'2026-02-25 14:47:25','交通方式6','线路详情6','导游工号6','导游姓名6','13823888886','导游介绍6',6,6,0,6),(127,'2026-02-25 06:47:25','线路名称7','upload/lvyouxianlu_xianlutupian7.jpg,upload/lvyouxianlu_xianlutupian8.jpg,upload/lvyouxianlu_xianlutupian9.jpg','景点名称7','景点类型7','景点位置7','起点7','途径路段7','终点7',7,7,'2026-02-25 14:47:25','交通方式7','线路详情7','导游工号7','导游姓名7','13823888887','导游介绍7',7,7,0,7),(128,'2026-02-25 06:47:25','线路名称8','upload/lvyouxianlu_xianlutupian8.jpg,upload/lvyouxianlu_xianlutupian9.jpg,upload/lvyouxianlu_xianlutupian10.jpg','景点名称8','景点类型8','景点位置8','起点8','途径路段8','终点8',8,8,'2026-02-25 14:47:25','交通方式8','线路详情8','导游工号8','导游姓名8','13823888888','导游介绍8',8,8,0,8);
/*!40000 ALTER TABLE `lvyouxianlu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meishicanting`
--

DROP TABLE IF EXISTS `meishicanting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meishicanting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cantingmingcheng` varchar(200) DEFAULT NULL COMMENT '餐厅名称',
  `cantingtupian` longtext COMMENT '餐厅图片',
  `tesecaipin` longtext COMMENT '特色菜品',
  `yingyeshijian` varchar(200) DEFAULT NULL COMMENT '营业时间',
  `renjunxiaofei` varchar(200) DEFAULT NULL COMMENT '人均消费',
  `cantingdizhi` varchar(200) DEFAULT NULL COMMENT '餐厅地址',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `cantingjianjie` longtext COMMENT '餐厅简介',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='美食餐厅';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meishicanting`
--

LOCK TABLES `meishicanting` WRITE;
/*!40000 ALTER TABLE `meishicanting` DISABLE KEYS */;
INSERT INTO `meishicanting` VALUES (91,'2026-02-25 06:47:25','餐厅名称1','upload/meishicanting_cantingtupian1.jpg,upload/meishicanting_cantingtupian2.jpg,upload/meishicanting_cantingtupian3.jpg','特色菜品1','9:00-22:00','人均消费1','餐厅地址1','020-89819991','餐厅简介1',1,1,'2026-02-25 14:47:25',1,0,1),(92,'2026-02-25 06:47:25','餐厅名称2','upload/meishicanting_cantingtupian2.jpg,upload/meishicanting_cantingtupian3.jpg,upload/meishicanting_cantingtupian4.jpg','特色菜品2','9:00-22:00','人均消费2','餐厅地址2','020-89819992','餐厅简介2',2,2,'2026-02-25 14:47:25',2,0,2),(93,'2026-02-25 06:47:25','餐厅名称3','upload/meishicanting_cantingtupian3.jpg,upload/meishicanting_cantingtupian4.jpg,upload/meishicanting_cantingtupian5.jpg','特色菜品3','9:00-22:00','人均消费3','餐厅地址3','020-89819993','餐厅简介3',3,3,'2026-02-25 14:47:25',3,0,3),(94,'2026-02-25 06:47:25','餐厅名称4','upload/meishicanting_cantingtupian4.jpg,upload/meishicanting_cantingtupian5.jpg,upload/meishicanting_cantingtupian6.jpg','特色菜品4','9:00-22:00','人均消费4','餐厅地址4','020-89819994','餐厅简介4',4,4,'2026-02-25 14:47:25',4,0,4),(95,'2026-02-25 06:47:25','餐厅名称5','upload/meishicanting_cantingtupian5.jpg,upload/meishicanting_cantingtupian6.jpg,upload/meishicanting_cantingtupian7.jpg','特色菜品5','9:00-22:00','人均消费5','餐厅地址5','020-89819995','餐厅简介5',5,5,'2026-02-25 14:47:25',5,0,5),(96,'2026-02-25 06:47:25','餐厅名称6','upload/meishicanting_cantingtupian6.jpg,upload/meishicanting_cantingtupian7.jpg,upload/meishicanting_cantingtupian8.jpg','特色菜品6','9:00-22:00','人均消费6','餐厅地址6','020-89819996','餐厅简介6',6,6,'2026-02-25 14:47:25',6,0,6),(97,'2026-02-25 06:47:25','餐厅名称7','upload/meishicanting_cantingtupian7.jpg,upload/meishicanting_cantingtupian8.jpg,upload/meishicanting_cantingtupian9.jpg','特色菜品7','9:00-22:00','人均消费7','餐厅地址7','020-89819997','餐厅简介7',7,7,'2026-02-25 14:47:25',7,0,7),(98,'2026-02-25 06:47:25','餐厅名称8','upload/meishicanting_cantingtupian8.jpg,upload/meishicanting_cantingtupian9.jpg,upload/meishicanting_cantingtupian10.jpg','特色菜品8','9:00-22:00','人均消费8','餐厅地址8','020-89819998','餐厅简介8',8,8,'2026-02-25 14:47:25',8,0,8);
/*!40000 ALTER TABLE `meishicanting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menpiaodingdan`
--

DROP TABLE IF EXISTS `menpiaodingdan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menpiaodingdan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `jingdianmingcheng` varchar(200) DEFAULT NULL COMMENT '景点名称',
  `tupian` longtext COMMENT '图片',
  `jingdianleixing` varchar(200) DEFAULT NULL COMMENT '景点类型',
  `menpiaojiage` double NOT NULL COMMENT '门票价格',
  `shuliang` int(11) NOT NULL COMMENT '购买数量',
  `zongjine` double NOT NULL COMMENT '总金额',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `goumaishijian` date DEFAULT NULL COMMENT '购买时间',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='门票订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menpiaodingdan`
--

LOCK TABLES `menpiaodingdan` WRITE;
/*!40000 ALTER TABLE `menpiaodingdan` DISABLE KEYS */;
INSERT INTO `menpiaodingdan` VALUES (51,'2026-02-25 06:47:25','1111111111','景点名称1','upload/menpiaodingdan_tupian1.jpg,upload/menpiaodingdan_tupian2.jpg,upload/menpiaodingdan_tupian3.jpg','景点类型1',1,1,1,'用户账号1','用户姓名1','13823888881','2026-02-25','未支付'),(52,'2026-02-25 06:47:25','2222222222','景点名称2','upload/menpiaodingdan_tupian2.jpg,upload/menpiaodingdan_tupian3.jpg,upload/menpiaodingdan_tupian4.jpg','景点类型2',2,2,2,'用户账号2','用户姓名2','13823888882','2026-02-25','未支付'),(53,'2026-02-25 06:47:25','3333333333','景点名称3','upload/menpiaodingdan_tupian3.jpg,upload/menpiaodingdan_tupian4.jpg,upload/menpiaodingdan_tupian5.jpg','景点类型3',3,3,3,'用户账号3','用户姓名3','13823888883','2026-02-25','未支付'),(54,'2026-02-25 06:47:25','4444444444','景点名称4','upload/menpiaodingdan_tupian4.jpg,upload/menpiaodingdan_tupian5.jpg,upload/menpiaodingdan_tupian6.jpg','景点类型4',4,4,4,'用户账号4','用户姓名4','13823888884','2026-02-25','未支付'),(55,'2026-02-25 06:47:25','5555555555','景点名称5','upload/menpiaodingdan_tupian5.jpg,upload/menpiaodingdan_tupian6.jpg,upload/menpiaodingdan_tupian7.jpg','景点类型5',5,5,5,'用户账号5','用户姓名5','13823888885','2026-02-25','未支付'),(56,'2026-02-25 06:47:25','6666666666','景点名称6','upload/menpiaodingdan_tupian6.jpg,upload/menpiaodingdan_tupian7.jpg,upload/menpiaodingdan_tupian8.jpg','景点类型6',6,6,6,'用户账号6','用户姓名6','13823888886','2026-02-25','未支付'),(57,'2026-02-25 06:47:25','7777777777','景点名称7','upload/menpiaodingdan_tupian7.jpg,upload/menpiaodingdan_tupian8.jpg,upload/menpiaodingdan_tupian9.jpg','景点类型7',7,7,7,'用户账号7','用户姓名7','13823888887','2026-02-25','未支付'),(58,'2026-02-25 06:47:25','8888888888','景点名称8','upload/menpiaodingdan_tupian8.jpg,upload/menpiaodingdan_tupian9.jpg,upload/menpiaodingdan_tupian10.jpg','景点类型8',8,8,8,'用户账号8','用户姓名8','13823888888','2026-02-25','未支付');
/*!40000 ALTER TABLE `menpiaodingdan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `typename` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `name` varchar(200) DEFAULT NULL COMMENT '发布人',
  `headportrait` longtext COMMENT '头像',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8 COMMENT='旅游资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (191,'2026-02-25 06:47:25','趁着年轻，输得起，看得开，去经历','我在大学一年级那一年，毫无悬念地把自己吃成了一个胖子。不是那种巨大的胖子，而是介于正规的肥胖和臃肿之间的尴尬体型，比标准体型重了15斤。于是，我的整个大学生活变成了电影《蝴蝶效应》系列，那只蝴蝶重达15斤','分类名称1','发布人1','upload/news_headportrait1.jpg',1,'2026-02-25 14:47:25',1,1,1,'upload/news_picture1.jpg','<p>我在大学一年级那一年，毫无悬念地把自己吃成了一个胖子。不是那种巨大的胖子，而是介于正规的肥胖和臃肿之间的尴尬体型，比标准体型重了15斤。于是，我的整个大学生活变成了电影《蝴蝶效应》系列，那只蝴蝶重达15斤。</p><p>  首先，我皈依了减肥。我可以整整一天滴水不进，然后第二天中午，一个小时之内连续去三个食堂吃午饭，每次都是两荤一素、一两米饭加一瓶大可乐，像是一个人孢子分裂出了三个暴食症患者。其次，因为要么饿得百爪挠心，要么撑得寝食难安，我变成了一个昼夜颠倒的人，再加上觉得自己邋遢难看，不愿见人，便逃掉了很多课。其三，逃课的空虚让我花了大量时间网购，击败了全国90%以上的电商消费者，和快递员结下了深厚的友谊。我买的大多数是衣服，衣服又穿不进，羞愤难当，继续皈依减肥。总之，那是我非常不快乐的几年。因为难以接受自己，所以蜷缩着，拒绝他人。</p><p>    我很久之后才知道，人用来自憎的大脑边缘系统，在童年时就已经形成。可是，用来开导自己、原谅自己、使自己变得强大的智慧，却往往在我们本该成熟的年纪依然不具备。每一世代的年轻人都是脆弱的、敏感的、容易受他人影响的。而对于正年轻的一代来说，这个挑战异乎寻常的艰难。</p><p> 电影《楚门的世界》中提出了一个假设以及相应的解答:当一个人活在所有人的窥探之下，他应该怎么办?答案是:他逃走，获得自由。然而，如果所有人活在所有人的窥探之下，那又该如何逃避?这不是假设，而是正在悄然发生的现实。我们无时无刻不在朋友圈、微博、贴吧、个人主页上展现自己的生活，同时，也在同样的平台上窥探他人的生活。我们无时无刻不在评估他人，同时，也在接受他人的评估。“个性张扬”只是狐假虎威的外衣，为的是掩饰自卑与自恋此起彼伏、相爱相杀的脆弱。我们羡慕嫉妒他人，也努力把自己的生活修饰得让他人羡慕嫉妒。我们对他人的意见过于敏感，无法忍受不被“点赞”的人生。</p><p>  社交网络的核心在于“社交”，社交的动力，是出于人们无法忍受孤独;人们之所以无法忍受孤独，是因为人们无法拷问自己。可是，总有一天，我们要站在镜子前，发现我们并不是自己创造出来的那个有趣、可爱、有吸引力、有能力的人。那么，你还喜欢镜子里的自己吗?或者，镜子里的你还喜欢自己吗?这个世界是否称赞你、羡慕你、爱你，在某种程度上是个不断膨胀的谎言。关键的问题在于，你是否对自己足够诚实，并且接受诚实之后的不完美。</p><p>   失去的痛苦、被拒绝的痛苦、被伤害的痛苦、分别的痛苦，它们如此显眼地横在前行的路上，让人想逃遁到那个充满着“赞”的虚幻世界里。然而，我们是人，走在一条从摇篮到坟墓的路上，年轻在途中，衰老在途中。必须和真实的世界发生联系，而不是兀自为尚未发生的事情恐惧;必须和真实的人发生各种关系，而不是如一座座只能遥远眺望的孤岛。</p><p>那些杀不死我们的，它们有时并不会让我们更加强大，而只是成为一段诗意或自嘲的记忆。趁着年轻，输得起，看得开，去经历。那些杀不死我们的，它们在混沌而无序的未来里，并不能成为我们手中的武器，却为我们的存活，增加了反抗脆弱与敏感的韧性。</p>'),(192,'2026-02-25 06:47:25','大学就该抓住青春，用汗水实现梦想','大学之青春，人生之春，人生之王，人生之华也，宝贵的时光我们理当去珍惜。然而，当我们在青春布满藤墓的围墙上缓慢的攀行时;依旧游离在青春摇摆不定的尾巴上时;奋力想抓却抓不住，用力一扯，却又是散落一地的音符时;我们是否该回头思考了。零零碎碎的记忆，偶尔会闪过寂寞的长空，飘然在无际的苍穹，仅仅留下几颗闪烁的残星让我们自己深思，青春易逝，好比东逝的水—去不复还','分类名称2','发布人2','upload/news_headportrait2.jpg',2,'2026-02-25 14:47:25',2,2,2,'upload/news_picture2.jpg','<p>  大学之青春，人生之春，人生之王，人生之华也，宝贵的时光我们理当去珍惜。然而，当我们在青春布满藤墓的围墙上缓慢的攀行时;依旧游离在青春摇摆不定的尾巴上时;奋力想抓却抓不住，用力一扯，却又是散落一地的音符时;我们是否该回头思考了。零零碎碎的记忆，偶尔会闪过寂寞的长空，飘然在无际的苍穹，仅仅留下几颗闪烁的残星让我们自己深思，青春易逝，好比东逝的水—去不复还。</p><p>  青春是属于我们的，是人生最最美好的时光。我们应该好好把握住现在象牙塔的点点滴滴。大学对于我们来说很重要，这里充满了好奇、机遇和挑战。当我懵懵懂懂的走过了两年才突然发现原来大学是这样的，每个人有不同的选择，有不同的理想，也有不同的人生。但是无论怎样都是一个博学的过程，学做人，学知识，学生活..…...春是疯狂的，是充满激情的，是奋斗的，最重要的是我们要坚定我们的梦想，为了梦想付出一切，为了梦想坚持到底，这才是真正的青春。青春的梦想就是黑夜里的灯塔在我们迷茫时给予我们方向，就是力量的源泉在我们身陷逆境时给予我们最大的动力，就是爱的港湾在我们屡次失败时给予我们受伤的心灵以安慰。因此无论何时何地，都不能忘却心里坚守的那份沉甸甸的梦想。</p><p>   青春的梦想很简单，可能是梦想成为学习的佼佼者让GPA无限趋于4.0，可能是梦想成为学生工作的杰出者当上主席为自己的从政事业奠定基础，也可能是梦想成为运动场上的超级明星拥有大量的球迷粉丝，也可能是梦想成为职场达人，面试无压力，就业有保障...….或许你觉得这些都算不上梦想，其实梦想并不分大小和轻重，不能说只有中国梦才算是梦想，梦想就是这样每个人有不同的定位，但都是值得去追逐的，去为之奋斗的。()拥有了梦想，就有了坚定的信念，海风再大海浪再大，也无法扼杀我们追逐胜利的信念。信念给我们坚持的勇气，勇气赐我们昂扬的斗志，斗志带我们摆脱厄运;拥有了梦想，就能化压力为动力，梦想会时刻在鞭策我们，鼓励我们，让我们审视自己，发现不足，奋力补救，让自己保持不懈的前进动力;拥有了梦想，我们就不会在迷茫的路上更加迷茫，我们就能在青春之歌复杂的五线谱中听到动人的旋律。</p><p>   我们是大学生，是祖国的未来，是民族复兴的脊梁，面对如此重任，怎么能不胸怀大志，坚定梦想，在青春的道路上奋斗。“恰同学少年，风华正茂，书生意气，挥斥方道。”青春是黄金时段，我们要以梦想为方向，扬帆起航，努力拼搏，给我们即将失去的青春以最好的结局。人因梦想而伟大，让我们一起奏响青春的梦想之歌，为各自的梦想努力进发吧!</p>'),(193,'2026-02-25 06:47:25','留退路就没有出路','公元前一世纪，凯撒大帝率领他的军队抵达了英格兰，他决心要赢得这场战争，不管遇到什么情况都不会退却。为了让士兵们明白自己必胜的决心和信心，也为了断绝士兵们逃跑退缩的念头，凯撒命令士兵将运载他们的所有船只都烧毁。这使得军队的士气受到了莫大的鼓舞。后来他们获胜了','分类名称3','发布人3','upload/news_headportrait3.jpg',3,'2026-02-25 14:47:25',3,3,3,'upload/news_picture3.jpg','<p>  公元前一世纪，凯撒大帝率领他的军队抵达了英格兰，他决心要赢得这场战争，不管遇到什么情况都不会退却。为了让士兵们明白自己必胜的决心和信心，也为了断绝士兵们逃跑退缩的念头，凯撒命令士兵将运载他们的所有船只都烧毁。这使得军队的士气受到了莫大的鼓舞。后来他们获胜了。</p><p>  很多人在处理重要问题的时候，总是喜欢把这些问题暂且搁置在一边，等以后再做。他们没有决定的勇气和魄力，总是在着手做事的时候想给自己留一条后路，以免没有出路。对于他们来说，退路就是出路。但是，事实证明，这样是不会有任何成就的。</p><p>背水一战、破釜沉舟的军队往往能获得胜利。同样，一个做事不留退路、一心向前的人，不管遇到什么困难和障碍，他都不会后退，因为他没有路可以退。而那些人在为自己准备退路的同时就是在后退，他们立志不坚，把精力和时间投入到退缩的准备上，这种人绝不会获得成功。</p><p>  一个人能否成功，关键在于他意志力的强弱。意志坚强的人不管遇到什么困难和障碍，都会百折不挠，想方设法地克服;意志薄弱的人一遇到麻烦，甚至在挫折还没有到来之前，他们就开始庸人自扰，彷徨失措，把精力都放在如何规避问题上，放在为自己铺设后路上。当困难一个接一个来时，他们就一步接一步后退，最后他们终将无路可退。</p><p>现实生活中，到处都充斥着这样的青年，他们富有上进心，希望有一番成就和作为，但是他们意志薄弱，没有必胜的决心，不敢破釜沉舟;他们始终左摇右摆，没有坚定的信念，一遇到挫折和困难，马上就缩回了进取的手和脚。这样的人，这样的心态，最后遭受失败也不足为奇。</p><p>   不给自己留后路，让自己没有回旋的余地，方能竭尽全力，锐意进取，就算遇到千万困难，也不会退缩，因为回头也没有路了，不如不顾一切地前进，还能找到一线希望。有了这样一种“拼命”和“豁出去”了的信念，才能彻彻底底地消除心中的恐惧、犹豫、胆怯。当一个人不给自己任何退路的时候，他就什么都不怕了，勇气、信心、热忱等从心底油然而生，到最后自然能“置之死地而后生”。</p><p>    面对严峻的问题和重要环节，周全而细致地考虑问题的各个方面也是应该的，但是过多地权衡，前怕狼后怕虎，一会儿这样一会儿那样，最终却还是原样，可以肯定地说，你不会有任何进展，甚至还会变得—塌糊涂。</p><p>出路和退路不是同义词，而是反义词，留退路就没有出路，因此，你应该只找出路，不留退路。大学生励志青春文章:培养积极的思维模式。</p>'),(194,'2026-02-25 06:47:25','在大学给自己定个目标','最近和几名大一的学生聊天，几名同学认为身边的人普遍都很迷茫，不知道该干什么，业余时间要么是对着电脑、要么是抱着手机刷微博。我问道:“为什么不找点事情做做，制定一个计划，哪怕是锻炼身体也好?4年也可以把身体锻炼得结实些。”当然，我也清楚，我的这些建议对他们来说，未必能有多大用。许多学生因为意志不坚定，没有老师的监督、逼迫，根本就无法做到','分类名称4','发布人4','upload/news_headportrait4.jpg',4,'2026-02-25 14:47:25',4,4,4,'upload/news_picture4.jpg','<p>  最近和几名大一的学生聊天，几名同学认为身边的人普遍都很迷茫，不知道该干什么，业余时间要么是对着电脑、要么是抱着手机刷微博。我问道:“为什么不找点事情做做，制定一个计划，哪怕是锻炼身体也好?4年也可以把身体锻炼得结实些。”当然，我也清楚，我的这些建议对他们来说，未必能有多大用。许多学生因为意志不坚定，没有老师的监督、逼迫，根本就无法做到。</p><p>   这让我想到前段时间蹿红网络的“悔过励志帖”——《同学，我大四了》，作者回首自己的大学4年，他感叹投入精力“充其量不过40%”︰每天上网时间少则4个小时，多则10个小时;考试永远是画画重点，在高呼“60分万岁”中与奖学金无缘。作者借自己求职受挫，写帖子以警醒后来人，不要等毕业时再后悔，就业难不仅仅是大学、社会的问题，也是自身的问题。</p><p>  也许，这样的大学生不是一个两个，而是一个群体。然而，我总是怀疑这样的励志帖，甚至教师在课堂上苦口婆心地劝说，能对现实中的大学和大学生起到多大的影响和作用，很多时候恐怕只有“三分钟热度”的效应。毕竟，现实的窘境不是一天积累起来的，从小学到高中，学生们的学习都是被动地接受应试，隐藏着功利性的目的，也许从没有为主动学习感到过快乐，而在高中时代，有的教师甚至打出这样的励志宣言:等你考上大学，你就可以想干什么干什么了..…..乎，高中时代的目标是很清晰的，就是为了考上大学，而在一些高中生的眼里，大学甚至就好比是天堂，进了大学的门就可以放轻松了。</p><p> 此前，有很多声音都认为大学越来越像培训机构，功利性学习正在整个大学蔓延，考证热、过早地职业化都是大学功利性学习最好的表现形式。在这种批判的声音中，“培训机构”总有被贬低的意味，难与大学之学术思想殿堂的高雅相媲美。但是，在这种批判的背后，还有一个现实问题被遮蔽，那就是很多大学生对自己的学习、对大学生活没有任何目标。</p><p>暨南大学舆情研究中心曾就“当代广州大学生生活与思想现状”作过详细的问卷调查，其中，接受调查的广州高校在读本科生共有191份有效样本，就“读大学的原因”、“大学第一印象”、“专业选择首要因素”等问题制作问卷调查并进行分析。结果显示，在未来规划方面，73.3%的同学表示只有粗略的想法，并无非常明确的目标。</p><p>  如果说功利化的学习毕竟还有一个前进的目标，至少能体现出一种为了目标而奋斗的精神和奔头，而没有任何目标，漫无目的地混日子则更可怕，它体现的是一种虚无、意义的缺失。说实话，没有引导学生树立明确的奋斗目标、进而指引学生为之努力的大学，学生很难找到努力的方向，也找不到努力的意义，这还不如“培训机构”来得实在、来得有效用，至少，培训机构的目标很清晰，它能够给学生们一个实实在在看得见的效果，而没有任何目标、浑浑噩噩的大学生活，也许只会给很多学生带来悔过。</p><p>无论如何，混日子的大学生活是不可取的。一方面，高校应该在新生入学的时候，作好目标和方向的引导，甚至贯穿大学4年的学习过程;另一方面，还在迷途的大学生，应尽早为自己找个前进的方向，作好自我规划，对自己的未来和前途负责。</p>'),(195,'2026-02-25 06:47:25','做个真正的学生','最坚强的人，是以宽容的态度面对自己缺点的人，而懦弱的人，则不敢面对自己的缺点，最终自暴自弃，葬送自己。只要有进取心，我们都能从失败的领域中，发现到达成功的途径;只要有自信心，我们身上的每一个缺陷，也都可以成为与众不同的优点','分类名称5','发布人5','upload/news_headportrait5.jpg',5,'2026-02-25 14:47:25',5,5,5,'upload/news_picture5.jpg','<p>  最坚强的人，是以宽容的态度面对自己缺点的人，而懦弱的人，则不敢面对自己的缺点，最终自暴自弃，葬送自己。只要有进取心，我们都能从失败的领域中，发现到达成功的途径;只要有自信心，我们身上的每一个缺陷，也都可以成为与众不同的优点。</p><p>曾经有人特地赶赴日本，向三宅一生服装设计大师请教如何设计出独具一格的服装款式。三宅一生大师提出两个很有意思的观点:一是，设计的衣服，其实都是没有全部完成的，其余的创作空间，则是留给穿衣服的人去完成的;二是，选择布料时，会请厂商提供纺织、印染失败的布料，从这些“残次”的作品中寻找泉涌般的创作灵感，设计出最具独创性的作品。</p><p>这样一来，顾客才能穿出自己的风格，并使得同一件衣服，在不同的人身上，能有不同的效果。而且，以这样的概念设计出来的衣服，也不容易失败。正是因为这两个观点，三宅一生所设计的服装总是独一无二地能够引领世界潮流。</p><p>  在艺术家的眼中，任何事物都是创作的最好材料，不管是枯木还是残破的布料，对他们而言，都是最具生命力的事物，在他们手中都能画腐朽为神奇。</p><p>朽木也能精雕，更何况我们自己。那些看起来弯曲、盘旋、似乎毫无用处的木料，往往最终能成为艺术品的原材料，因为这种不同，才特别珍贵。花点心思，身上的缺点也能变成独特的优点，就像艺术家们一般，顺着曲折的木头，创造出与众不同、完美无缺的惊世杰作。</p><p>励志文章3:一生学习，成就一生无知的人并不是没有学问的人，而是不明了自己的人。当一个有学问的人信赖书本、知识和权威，借着它们而了解自己，那么他便是愚蠢的。了解是由自我认识而来，而自我认识乃是一个人明白他自己的整个心理过程。因此，教育的真正意义是自我了解，因为整个生活是汇聚于我们每个人的身心的最高“机密”。</p><p>   目前我们所谓的教育，只是由书本聚集见闻、知识，这是任何懂得阅读的人都办得到的。这种教育提供了一条巧妙的逃避自我之途，如同其他所有的逃避方式一样，它无可避免地制造出有增无减的苦难。冲突和混乱是由于我们和他人、事物、概念之间差错的关系而产生，除非我们了解此项关系而改变它，否则，知识的学习和堆砌，各种技能的获取，都只会将我们导向更深的混乱和毁灭。</p><p> 我们将子女送入学校，学习一些技能，并希望借此来带动整个家庭的长久繁荣，至少在家长们年老的时候有养老保险，有稳定的照顾。我们对孩子最急切的渴望，就是将他塑造成一个能在一个领域中出类拔萃之人，希望给予他一个安全的经济地位。物质的获得有时候并不难，然而，技术的训练能使我们了解自己吗?</p><p>虽然，懂得念书写字、学习土木工程或其他某种职业，是必需的，然而技术能给予我们了解生活的能力吗?技术，无疑是次要的;如果技术是我们惟一奋力以求的东西，那么我们就摒弃了生活中最主要的东西了。</p><p>    生活，是痛苦、喜悦、美、丑、爱等多种感受的综合，一旦我们将它整体地加以了解，那么这项了解在各方面都会创出它应有的技术。不过，相反的说法就不是真的了∶技术永远无法产生创造性的了解。</p><p>如果过分强调技术，我们便毁灭了人。磨练技能和效率，然而对生活却不了解，对思想、欲望的行踪不能领悟，只会使我们变得日益残暴无情，以致于触发战争，危害了我们肉体上的安全。由于我们的教育过重于单单培养技术，已经制造出许多科学家、数学家、造桥工程师、征服太空的人，但这些人了解生活的整体过程吗?一个专家能把生活本身完整地体验感受表达出来吗?或者他真的体验到生活了吗?有时候，当他不是专家时，反而更能直指生活的本质。一颗能够给予人辉煌一生的企图心，首先应当是一颗敏感的善良的热情的心，让我们对周围的一切保持孩童一样旺盛的好奇心。我们应当渴望了解新奇的事物，渴望探索未知的领域。只有在这种理念的支配下，我们才能不断地、孜孜以求地、乐此不疲地提升自己的认知和理解能力，改善自我，从而更接近成功的巅峰。</p>'),(196,'2026-02-25 06:47:25','远大的目标是成功的磁石','上天对每个老实人都是公平的，每个人每一天都是二十四个小时，每个人的所有时间都是一生;同时上天对每个老实人又是不公平的，给每一个人的时间不都是二十四个小时，给每一个人的所有时间不都是一生。这之间的区别就在于有无远大目标','分类名称6','发布人6','upload/news_headportrait6.jpg',6,'2026-02-25 14:47:25',6,6,6,'upload/news_picture6.jpg','<p>  上天对每个老实人都是公平的，每个人每一天都是二十四个小时，每个人的所有时间都是一生;同时上天对每个老实人又是不公平的，给每一个人的时间不都是二十四个小时，给每一个人的所有时间不都是一生。这之间的区别就在于有无远大目标。</p><p>    有大目标的人，生活永远是积极的，他们会朝着自己的目标不断前进;没有大目标的老实人浑浑噩噩，不思进取，最后被生活淘汰。</p><p> 从前有个叫阿巴格的人生活在内蒙古草原上。有一次，年少的阿巴格和爸爸在草原上迷了路，阿巴格又累又怕，到最后快走不动了。爸爸就从兜里掏出五枚硬币，把一枚硬币埋在草地里，把其余四枚放在阿巴格的手上，说:“人生有五枚金币，童年、少年、青年、中年、老年各有一枚，你现在才用了一枚，就是埋在草地里的那一枚，你不能把五枚都扔在草原里，你要一点点地用，每一次都用出不同来，这样才不枉人生一世。今天我们一定要走出草原，你将来也一定要走出草原。世界很大，人活着，就要多走些地方，多看看，不要让你的金币没有用就扔掉。”在父亲的鼓励下，阿巴格走出了草原。长大后，阿巴格离开了家乡，成了一名十分优秀的船长。</p><p>  目标是与一个人的愿望相联系的，是对未来的一种设想，它往往和目前的行动不直接联系。但目标又不能脱离现实的生活，现实生活中的某些现象如果符合了个人的需要，与个人的世界观一致，这些现实的因素就会以个人目标的形式表现出来。目标总是对现实生活的重新加工，舍弃其中某些成分，又对某些因素给予强调的过程，但它必须以对客观规律的认识为基础，符合客观规律。</p><p> 能实现自己目标的老实人，对他个人而言，他是一个成功者，也是个幸福者。目标是成功的必要条件，虽然仅仅拥有目标，你不一定能取得成功;但是如果没有目标，成功对你而言就无从谈起。</p><p>远大的美好目标能吸引人努力为实现它而奋斗不止。</p>'),(197,'2026-02-25 06:47:25','做一个最好的自己','自信是成功的前提，你拥有自信，就拥有成功的一半机会。相信自己是最棒的就一定会成就一定的事业。拥有自信的人之所以会心想事成、走向成功，是因为他们都有着巨大无比的潜能等着去开发;消极失败的心态之所以会使人怯弱无能、走向失败，是因为它使人放弃潜能的开发，让潜能在那里沉睡、白白浪费','分类名称7','发布人7','upload/news_headportrait7.jpg',7,'2026-02-25 14:47:25',7,7,7,'upload/news_picture7.jpg','<p>自信是成功的前提，你拥有自信，就拥有成功的一半机会。相信自己是最棒的就一定会成就一定的事业。拥有自信的人之所以会心想事成、走向成功，是因为他们都有着巨大无比的潜能等着去开发;消极失败的心态之所以会使人怯弱无能、走向失败，是因为它使人放弃潜能的开发，让潜能在那里沉睡、白白浪费。</p><p>我们大家都知道的人大脑拥有140亿个脑细胞，但我们思维意识只利用了脑细胞的很少部分，如能将更多的脑细胞从睡眠中激活出来，人的思维意识将更加强大。如果我们都能充满自信，就能创造人间奇迹，亦能创造一个最好的自己。</p><p> 一个人相信自己是什么，就会是什么。一个人心里怎样想，就会成为怎样的人。这从心里学上讲是有一定的道理的。我们每一个人心里都有一幅心里蓝图，或是一幅自画像，有人称它为运作结果。如果你想象的是做最好的你，那么你就会在你内心的荧光屏上看到一个踌躇满志、不断进取、勇于开拓创新的自我。同时还会经常收到我做的很好，我以后还会做的更好之类的信息，这样你注定会成为一个最好的你。美国哲学家爱默生说:“人的一生正如他一天中所想的那样，你怎么想，怎么期待，就有怎样的人生。”美国有名的钢铁大王安德鲁·卡耐基就是一个充分发挥自己创造机会的楷模。他12岁时由英格兰移居美国，先是在一家纺织厂做工人，当时他的目标是“做全厂最出色的工人。”因为他经常这样想，以这样做，最终他实现了他的目标。后来命运有安排他当邮递员，他想的是怎样成为“全美最杰出的邮递员。”结果他的这一目标也实现了。他的一生总是根据自己所处的环境和地位塑造最佳的自己，他的座右铭就是“相信自己是最棒的。“</p><p>做一个最好的自己，不一定非要当什么“家”，也不一定非要出什么“名”，更不要与别人比高低、比大小。就像人的手指，有大有小，有长有短，他们各有所长，各有所短，你能说拇指比食指好吗?决定最好的你，既不是你拥有的物质财富的多少，也不是你身份的贵贱，关键是看你是否拥有实现自己理想的强烈愿望的程度，看你身上的潜力能否充分发挥。人们熟知的一些英雄模范，就是在平凡的工作岗位上充分发挥人的创新能力，做好自己身边的每一件小事，创造了做好的自己。</p><p>“塑造一个最好的自己”，这个目标人人都可以实现。你只意识到自己是大自然的一分子，坚信自己拥有“无限的能力”与“无限的可能”，这种坚定的信心能帮助你创造和谐的心理、生理韵律，建立起自己理想的自我形象，体现自己人格行为应该具有的魅力。</p>'),(198,'2026-02-25 06:47:25','有了梦想就不会感到疲惫','一段时间以前，一位在港的大陆学生，因为学业的压力、前途的渺茫等诸多原因，选择了自杀。在讨论和反思的潮流中，有一位毕业生在校内网匿名发表了自己的故事。他说，自己当年在学校也曾经面临绝境，一文不名。他选择了做“乞丐学生”，坚持着念完了课程。回忆的一些情节让我印象深刻，比如，平时偷偷住电梯间，蓬头垢面如乞丐;实在很饿，学校举办餐会的时候默默进场埋头大吃','分类名称8','发布人8','upload/news_headportrait8.jpg',8,'2026-02-25 14:47:25',8,8,8,'upload/news_picture8.jpg','<p>  一段时间以前，一位在港的大陆学生，因为学业的压力、前途的渺茫等诸多原因，选择了自杀。在讨论和反思的潮流中，有一位毕业生在校内网匿名发表了自己的故事。他说，自己当年在学校也曾经面临绝境，一文不名。他选择了做“乞丐学生”，坚持着念完了课程。回忆的一些情节让我印象深刻，比如，平时偷偷住电梯间，蓬头垢面如乞丐;实在很饿，学校举办餐会的时候默默进场埋头大吃。</p><p>“峣峣者易折，皎皎者易污。”能够从内地高校到香港读书的学子，都是一些很优秀的年轻人。不知道曾经高居象牙塔的书生，怎样狠下心，咬牙面对那一个天渊般的落差，以及旁人的目光和议论。</p><p>  说到这里，很像一个《读者》式的励志故事。但是这种励志故事从来就不缺乏感动人的力量，因为虽然光明的尾巴不是人人都能够拥有，但是人人都有梦想，面对实现过程中的困难，其奋斗或者说挣扎，却常常和平凡如你我的人们相遇。</p><p>    《当幸福来敲门/The Pursuit of Happyness》就是这样偶然被看到，又感动了我的电影。黑人克里斯是一名普普通通的医疗器械推销员，妻子忍受不了经济上的压力离开了他，留下5岁的儿子克里斯托夫和他相依为命。克里斯银行账户里只剩下21块钱，因为没钱付房租，他和儿子被撵出了公寓。费尽周折，克里斯赢得了在一家着名股票投资公司实习的机会，但是实习期间没有薪水，而且最终只有一人可以成功进入公司。</p><p>    学妹曾经告诉我一个故事，让我每次想到都觉得莫名恐怖。她说，她硕士毕业去广东求职，一个中学要招几个老师，结果南来北往的硕士博士挤了快有一个礼堂。可想而知，竞争有多么残酷。看来，中外求职者都面临着同样的挑战。但是克里斯和许多“80后”的大学毕业生不同，他更加坚韧:为了节省时间，上班时候不喝水，以避免上厕所。以疯狂的速度给客户打电话，打完一个，直接按挂机键就拨下一个电话。白天，克里斯忍受着一次又一次被拒绝的失望，带着微笑在公司和客户之间穿梭。回家，则要带着儿子穿过污秽的街道，忍受房东的咆哮。</p><p>    终于，交不起房租的父子俩流落街头。克里斯和儿子在午夜地铁里相对无言，儿子不能理解为什么不能回家住，爸爸却开始玩游戏:“我们通过时光机，到达古代了!”儿子立刻兴奋地配合起来，环顾左右。父子俩在“恐龙”的追杀下，逃到了一个“山洞”里，“山洞”是什么呢，其实是一间男厕所。克里斯搂着熟睡的儿子，坐靠在厕所的墙面。午夜的灯光很惨白，这个消瘦的、营养不良的父亲，默默地流下了泪水。</p><p>    父子俩依旧为了幸福到来而努力。他们开始住收容所，面对有限的床位，这个奔跑起来像猎豹一样的人，有时候得把草原上的爆发力运用到打架上面来。儿子在简陋的收容所床上睡着了，父亲还在埋头修理推销的医疗器械，或者翻那本厚厚的笔试全书。</p><p>   钱包磨损得厉害，而且，太瘪了，每张钱都很熟悉。老板要借5块钱，犹豫再三，摩挚着纸币，最终还是把钱送了出去。卖血。鲜血在塑料袋里面渗开，那是一个男人所能奉献的最后。拿着卖血的钱，克里斯仍然去买电子元件。一点点的希望，都要去坚持。</p><p>对于父母，最心酸的事儿是什么呢?就是子女的一点可怜的愿望得不到满足。克里斯托夫的惟一的玩偶“美国英雄”，在一次挤车的过程中掉到了地上。5岁的男孩悲伤欲绝，克里斯坚硬的表情下，读出的是面对困难的凶狠和惨痛。但是，无论多么深切的无望，都没有摧毁父子间的亲情与他们的信念，他们相信幸福总会落到自己的身上。“你是个好爸爸”，克里斯托夫跟着爸爸四处流浪，可是孩子的心灵，衡量的砝码和天使是—样的。</p><p>  克里斯最终成为了投资公司的员工，看似冷漠的白人老板们，此时显出他们的些微温情。他忍住了泪水，颤抖着拿起自己的物品，走入了茫茫人海。在熙熙攘攘的人群中间，克里斯举起手，为自己鼓掌，那无声的，一下下重重的掌声，是在为自己喝彩。其实，克里斯托夫的“美国英雄”并没有失落。</p><p>  这是一个非常典型的“美国梦”:一个人通过自己的努力，可以实现自己的梦想，幸福，会来敲门。很多人往往会关注对于梦想的树立，而往往忽略过程的艰辛。特别是，当面对一个看似无望的现实的时候，有多少人会坚持，多少人会放弃呢?生活总是在不断地修正，并且提醒我们，顺应大潮的人总是较有可能抵达成功的彼岸。可是，确实是有些人，愿意逆流而上。我相信，这是导演对于逆行者的一点鼓励。</p><p>那个香港的匿名毕业生后来博士毕业，找到了一份不错的工作，有了漂亮的妻子和可爱的孩子。这个强人在帖子里说，有什么坚持不下来的呢?只要有梦想</p>');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newstype`
--

DROP TABLE IF EXISTS `newstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newstype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8 COMMENT='旅游资讯分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newstype`
--

LOCK TABLES `newstype` WRITE;
/*!40000 ALTER TABLE `newstype` DISABLE KEYS */;
INSERT INTO `newstype` VALUES (181,'2026-02-25 06:47:25','分类名称1'),(182,'2026-02-25 06:47:25','分类名称2'),(183,'2026-02-25 06:47:25','分类名称3'),(184,'2026-02-25 06:47:25','分类名称4'),(185,'2026-02-25 06:47:25','分类名称5'),(186,'2026-02-25 06:47:25','分类名称6'),(187,'2026-02-25 06:47:25','分类名称7'),(188,'2026-02-25 06:47:25','分类名称8');
/*!40000 ALTER TABLE `newstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remenjingdian`
--

DROP TABLE IF EXISTS `remenjingdian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remenjingdian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingdianmingcheng` varchar(200) NOT NULL COMMENT '景点名称',
  `tupian` longtext COMMENT '图片',
  `jingdianleixing` varchar(200) DEFAULT NULL COMMENT '景点类型',
  `kaifangshijian` varchar(200) DEFAULT NULL COMMENT '开放时间',
  `menpiaojiage` double NOT NULL COMMENT '门票价格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `jingdianweizhi` varchar(200) DEFAULT NULL COMMENT '景点位置',
  `jingdianjieshao` longtext COMMENT '景点介绍',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='热门景点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remenjingdian`
--

LOCK TABLES `remenjingdian` WRITE;
/*!40000 ALTER TABLE `remenjingdian` DISABLE KEYS */;
INSERT INTO `remenjingdian` VALUES (41,'2026-02-25 06:47:25','景点名称1','upload/remenjingdian_tupian1.jpg,upload/remenjingdian_tupian2.jpg,upload/remenjingdian_tupian3.jpg','景点类型1','开放时间1',1,1,'景点位置1','景点介绍1',1,1,'2026-02-25 14:47:25',0,1),(42,'2026-02-25 06:47:25','景点名称2','upload/remenjingdian_tupian2.jpg,upload/remenjingdian_tupian3.jpg,upload/remenjingdian_tupian4.jpg','景点类型2','开放时间2',2,2,'景点位置2','景点介绍2',2,2,'2026-02-25 14:47:25',0,2),(43,'2026-02-25 06:47:25','景点名称3','upload/remenjingdian_tupian3.jpg,upload/remenjingdian_tupian4.jpg,upload/remenjingdian_tupian5.jpg','景点类型3','开放时间3',3,3,'景点位置3','景点介绍3',3,3,'2026-02-25 14:47:25',0,3),(44,'2026-02-25 06:47:25','景点名称4','upload/remenjingdian_tupian4.jpg,upload/remenjingdian_tupian5.jpg,upload/remenjingdian_tupian6.jpg','景点类型4','开放时间4',4,4,'景点位置4','景点介绍4',4,4,'2026-02-25 14:47:25',0,4),(45,'2026-02-25 06:47:25','景点名称5','upload/remenjingdian_tupian5.jpg,upload/remenjingdian_tupian6.jpg,upload/remenjingdian_tupian7.jpg','景点类型5','开放时间5',5,5,'景点位置5','景点介绍5',5,5,'2026-02-25 14:47:25',0,5),(46,'2026-02-25 06:47:25','景点名称6','upload/remenjingdian_tupian6.jpg,upload/remenjingdian_tupian7.jpg,upload/remenjingdian_tupian8.jpg','景点类型6','开放时间6',6,6,'景点位置6','景点介绍6',6,6,'2026-02-25 14:47:25',0,6),(47,'2026-02-25 06:47:25','景点名称7','upload/remenjingdian_tupian7.jpg,upload/remenjingdian_tupian8.jpg,upload/remenjingdian_tupian9.jpg','景点类型7','开放时间7',7,7,'景点位置7','景点介绍7',7,7,'2026-02-25 14:47:25',0,7),(48,'2026-02-25 06:47:25','景点名称8','upload/remenjingdian_tupian8.jpg,upload/remenjingdian_tupian9.jpg,upload/remenjingdian_tupian10.jpg','景点类型8','开放时间8',8,8,'景点位置8','景点介绍8',8,8,'2026-02-25 14:47:25',0,8);
/*!40000 ALTER TABLE `remenjingdian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','upload/image1.jpg','管理员','2026-02-25 06:47:26');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xianluleixing`
--

DROP TABLE IF EXISTS `xianluleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xianluleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianluleixing` varchar(200) DEFAULT NULL COMMENT '线路类型',
  `image` longtext COMMENT '图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xianluleixing` (`xianluleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COMMENT='线路类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xianluleixing`
--

LOCK TABLES `xianluleixing` WRITE;
/*!40000 ALTER TABLE `xianluleixing` DISABLE KEYS */;
INSERT INTO `xianluleixing` VALUES (111,'2026-02-25 06:47:25','线路类型1','upload/xianluleixing_image1.jpg,upload/xianluleixing_image2.jpg,upload/xianluleixing_image3.jpg'),(112,'2026-02-25 06:47:25','线路类型2','upload/xianluleixing_image2.jpg,upload/xianluleixing_image3.jpg,upload/xianluleixing_image4.jpg'),(113,'2026-02-25 06:47:25','线路类型3','upload/xianluleixing_image3.jpg,upload/xianluleixing_image4.jpg,upload/xianluleixing_image5.jpg'),(114,'2026-02-25 06:47:25','线路类型4','upload/xianluleixing_image4.jpg,upload/xianluleixing_image5.jpg,upload/xianluleixing_image6.jpg'),(115,'2026-02-25 06:47:25','线路类型5','upload/xianluleixing_image5.jpg,upload/xianluleixing_image6.jpg,upload/xianluleixing_image7.jpg'),(116,'2026-02-25 06:47:25','线路类型6','upload/xianluleixing_image6.jpg,upload/xianluleixing_image7.jpg,upload/xianluleixing_image8.jpg'),(117,'2026-02-25 06:47:25','线路类型7','upload/xianluleixing_image7.jpg,upload/xianluleixing_image8.jpg,upload/xianluleixing_image9.jpg'),(118,'2026-02-25 06:47:25','线路类型8','upload/xianluleixing_image8.jpg,upload/xianluleixing_image9.jpg,upload/xianluleixing_image10.jpg');
/*!40000 ALTER TABLE `xianluleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) NOT NULL COMMENT '用户账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  `passwordwrongnum` int(11) DEFAULT '0' COMMENT '密码错误次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2026-02-25 06:47:25','用户账号1','123456','用户姓名1','upload/yonghu_touxiang1.jpg','男','13823888881',0,0),(12,'2026-02-25 06:47:25','用户账号2','123456','用户姓名2','upload/yonghu_touxiang2.jpg','男','13823888882',0,0),(13,'2026-02-25 06:47:25','用户账号3','123456','用户姓名3','upload/yonghu_touxiang3.jpg','男','13823888883',0,0),(14,'2026-02-25 06:47:25','用户账号4','123456','用户姓名4','upload/yonghu_touxiang4.jpg','男','13823888884',0,0),(15,'2026-02-25 06:47:25','用户账号5','123456','用户姓名5','upload/yonghu_touxiang5.jpg','男','13823888885',0,0),(16,'2026-02-25 06:47:25','用户账号6','123456','用户姓名6','upload/yonghu_touxiang6.jpg','男','13823888886',0,0),(17,'2026-02-25 06:47:25','用户账号7','123456','用户姓名7','upload/yonghu_touxiang7.jpg','男','13823888887',0,0),(18,'2026-02-25 06:47:25','用户账号8','123456','用户姓名8','upload/yonghu_touxiang8.jpg','男','13823888888',0,0);
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-29 23:47:29
