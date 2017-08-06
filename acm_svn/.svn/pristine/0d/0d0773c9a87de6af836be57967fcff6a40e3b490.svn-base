/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.24 : Database - shop1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop1`;

/*Table structure for table `cz_admin` */

DROP TABLE IF EXISTS `cz_admin`;

CREATE TABLE `cz_admin` (
  `admin_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `username` varchar(30) NOT NULL DEFAULT '' COMMENT '管理员名称',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '管理员密码',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员邮箱',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `cz_admin` */

insert  into `cz_admin`(`admin_id`,`username`,`password`,`email`,`add_time`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3','admin@itcast.cn',0),(2,'admin','admin','',0);

/*Table structure for table `cz_attribute` */

DROP TABLE IF EXISTS `cz_attribute`;

CREATE TABLE `cz_attribute` (
  `attr_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品属性ID',
  `attr_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品属性名称',
  `type_id` smallint(6) NOT NULL DEFAULT '0' COMMENT '商品属性所属类型ID',
  `attr_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '属性是否可选 0 为唯一，1为单选，2为多选',
  `attr_input_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '属性录入方式 0为手工录入，1为从列表中选择，2为文本域',
  `attr_value` text COMMENT '属性的值',
  `sort_order` tinyint(4) NOT NULL DEFAULT '50' COMMENT '属性排序依据',
  PRIMARY KEY (`attr_id`),
  KEY `type_id` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `cz_attribute` */

insert  into `cz_attribute`(`attr_id`,`attr_name`,`type_id`,`attr_type`,`attr_input_type`,`attr_value`,`sort_order`) values (1,'哈哈',1,0,1,'哈\r\n黑\r\n！！',50),(2,'dasdasd',2,0,0,'',50),(3,'vvv',1,0,0,'',50),(4,'vvvvvvvv',1,0,0,'',50),(5,'fasfasdasd',1,1,0,'',50);

/*Table structure for table `cz_brand` */

DROP TABLE IF EXISTS `cz_brand`;

CREATE TABLE `cz_brand` (
  `brand_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品品牌ID',
  `brand_name` varchar(30) NOT NULL DEFAULT '' COMMENT '商品品牌名称',
  `brand_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '商品品牌描述',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '商品品牌网址',
  `logo` varchar(50) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '50' COMMENT '商品品牌排序依据',
  `is_show` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示，默认显示',
  PRIMARY KEY (`brand_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `cz_brand` */

insert  into `cz_brand`(`brand_id`,`brand_name`,`brand_desc`,`url`,`logo`,`sort_order`,`is_show`) values (1,'诺基亚','诺基亚','','',50,1),(2,'金立','金立','','',50,1);

/*Table structure for table `cz_category` */

DROP TABLE IF EXISTS `cz_category`;

CREATE TABLE `cz_category` (
  `cat_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品类别ID',
  `cat_name` varchar(30) NOT NULL DEFAULT '' COMMENT '商品类别名称',
  `parent_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品类别父ID',
  `cat_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '商品类别描述',
  `sort_order` tinyint(4) NOT NULL DEFAULT '50' COMMENT '排序依据',
  `unit` varchar(15) NOT NULL DEFAULT '' COMMENT '单位',
  `is_show` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示，默认显示',
  PRIMARY KEY (`cat_id`),
  KEY `pid` (`parent_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `cz_category` */

insert  into `cz_category`(`cat_id`,`cat_name`,`parent_id`,`cat_desc`,`sort_order`,`unit`,`is_show`) values (13,'鞋帽',0,'',20,'双/个',1),(12,'连衣裙',10,'',50,'件',1),(9,'服装',0,'',50,'件',1),(10,'女装',9,'',50,'件',1),(11,'男装',9,'',50,'件',1),(14,'男鞋aaa',13,'',30,'双',1),(15,'羽绒服',11,'',50,'件',1),(16,'七分裙',12,'',70,'条',0),(18,'网鞋',14,'&lt;/table&gt;',50,'456',1),(1,'图书、音像、数字商品',0,'',39,'',1),(21,'运动健康',0,'',47,'',1),(22,'汽车用品',0,'',48,'',1),(6,'家用电器',0,'',40,'',1),(20,'礼品箱包、钟表、珠宝',0,'',46,'',1),(19,'个护化妆',0,'',45,'',1);

/*Table structure for table `cz_goods` */

DROP TABLE IF EXISTS `cz_goods`;

CREATE TABLE `cz_goods` (
  `goods_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_sn` varchar(30) NOT NULL DEFAULT '' COMMENT '商品货号',
  `goods_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_brief` varchar(255) NOT NULL DEFAULT '' COMMENT '商品简单描述',
  `goods_desc` text COMMENT '商品详情',
  `cat_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品所属类别ID',
  `brand_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品所属品牌ID',
  `market_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '市场价',
  `shop_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '本店价格',
  `promote_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '促销价格',
  `promote_start_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '促销起始时间',
  `promote_end_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '促销截止时间',
  `goods_img` varchar(50) NOT NULL DEFAULT '' COMMENT '商品图片',
  `goods_thumb` varchar(50) NOT NULL DEFAULT '' COMMENT '商品缩略图',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品库存',
  `click_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '点击次数',
  `type_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品类型ID',
  `is_promote` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否促销，默认为0不促销',
  `is_best` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否精品,默认为0',
  `is_new` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否新品，默认为0',
  `is_hot` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否热卖,默认为0',
  `is_onsale` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否上架,默认为1',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`goods_id`),
  KEY `cat_id` (`cat_id`),
  KEY `brand_id` (`brand_id`),
  KEY `type_id` (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `cz_goods` */

/*Table structure for table `cz_goods_attr` */

DROP TABLE IF EXISTS `cz_goods_attr`;

CREATE TABLE `cz_goods_attr` (
  `goods_attr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号ID',
  `goods_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商品ID',
  `attr_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '属性ID',
  `attr_value` varchar(255) NOT NULL DEFAULT '' COMMENT '属性值',
  `attr_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '属性价格',
  PRIMARY KEY (`goods_attr_id`),
  KEY `goods_id` (`goods_id`),
  KEY `attr_id` (`attr_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `cz_goods_attr` */

/*Table structure for table `cz_goods_type` */

DROP TABLE IF EXISTS `cz_goods_type`;

CREATE TABLE `cz_goods_type` (
  `type_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
  `type_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品类型名称',
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cz_goods_type` */

insert  into `cz_goods_type`(`type_id`,`type_name`) values (1,'aaaaaa'),(2,'aaaa'),(3,'bbbbb');

/*Table structure for table `cz_role` */

DROP TABLE IF EXISTS `cz_role`;

CREATE TABLE `cz_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL COMMENT '角色名称',
  `flag` int(11) DEFAULT NULL COMMENT '数字级别',
  `content` varbinary(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `cz_role` */

insert  into `cz_role`(`id`,`name`,`flag`,`content`) values (1,'未审核',0,'未审核可以浏览页面，但没有个人中心'),(2,'会员',1,'会员可以浏览页面，有个人中心,但不可以修改信息，不可以下载东西'),(3,'会员',2,'会员可以浏览页面，有个人中心，可以修改信息，可以下载一些东西'),(4,'干事-校队',3,'干事-校队可以浏览页面，有个人中心，可以下载更多东西'),(5,'学长-学姐',4,'学长-学姐可以浏览页面，有个人中心，可以下载全部东西'),(6,'老师',5,'老师全部可以'),(7,'所有人',6,''),(8,NULL,NULL,'INSERT INTO cz_user(acm_name, acm_sex, acm_tel, acm_school, acm_college, acm_system, acm_position, acm_hobby, acm_self, acm_qq) VALUES(\'测试人员\', \'男\',\'1234567890\', \'吉林建筑大学\',\'电气与计算机学院\', \'软件工程\',\'未审核\',\'编程\'');

/*Table structure for table `cz_user` */

DROP TABLE IF EXISTS `cz_user`;

CREATE TABLE `cz_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `acm_username` varchar(50) DEFAULT NULL COMMENT '登录用户名',
  `acm_password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `acm_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `acm_sex` varchar(25) DEFAULT NULL COMMENT '性别',
  `acm_tel` varchar(25) DEFAULT NULL COMMENT '电话',
  `acm_school` varchar(50) DEFAULT NULL COMMENT '学校',
  `acm_college` varchar(50) DEFAULT NULL COMMENT '学院',
  `acm_system` varchar(50) DEFAULT NULL COMMENT '系',
  `acm_position` varchar(50) DEFAULT '未审核' COMMENT '职位',
  `acm_hobby` varchar(511) DEFAULT NULL COMMENT '兴趣爱好',
  `acm_self` varchar(511) DEFAULT NULL COMMENT '自我介绍',
  `createtime` int(11) DEFAULT NULL COMMENT '注册时间',
  `examinetime` int(11) DEFAULT NULL COMMENT '审核时间',
  `level` int(11) DEFAULT '0' COMMENT '前端权限，0未通过审核，1学员，2干事、校队，3老师、学长、学姐',
  `flag` int(11) DEFAULT '0' COMMENT '审核标记',
  `acm_class` varchar(255) DEFAULT NULL COMMENT '班级',
  `acm_qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `img_url` varchar(255) DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

/*Data for the table `cz_user` */

insert  into `cz_user`(`id`,`acm_username`,`acm_password`,`acm_name`,`acm_sex`,`acm_tel`,`acm_school`,`acm_college`,`acm_system`,`acm_position`,`acm_hobby`,`acm_self`,`createtime`,`examinetime`,`level`,`flag`,`acm_class`,`acm_qq`,`img_url`) values (9,'dancheng','3a02916fdfc07fd0e389cf2e701a7865','张丹成','男','15043646837','吉林建筑大学','电气与计算机学院','软件工程','超级会员','编程，我在说笑话','ACM协会会长，这个网站是我建的',1501387479,NULL,2,0,'软件152','596375775','public/uploads/20170731/20170731183912597f08d09386f.jpg'),(69,'sdasdasdsad','d41d8cd98f00b204e9800998ecf8427e','dasdas','sadasda','sadasd','吉林建筑大学','电气与计算机学院','软件工程','未审核','asdasd','asdasdas',1501487282,NULL,0,0,'dsadasd','dsadas','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(72,'3',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(75,'6',NULL,'测试人员11111','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,'','987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(76,'7',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(77,'8',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(78,'9',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(79,'10',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654','public/uploads/20170731/20170731155507597ee25bb4fbb.jpg'),(80,'11',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(81,'12',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(82,'13',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(83,'14',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(84,'15',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(85,'16',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(86,'17',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(87,'18',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(88,'19',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(89,'20',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(90,'21',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(91,'22',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(92,'23',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(93,'24',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(94,'25',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(95,'26',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(96,'27',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(97,'28',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,3,0,NULL,'987654',NULL),(98,'29',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(99,'30',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(100,'31',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(101,'32',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(102,'33',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(103,'34',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(104,'35',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(105,'36',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(106,'37',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(107,'38',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(108,'39',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(109,'40',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(110,'41',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(111,'42',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(112,'43',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(113,'44',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(114,'45',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(115,'46',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(116,'47',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(117,'48',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(118,'49',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(119,'50',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(120,'51',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(121,'52',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(122,'53',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(123,'54',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(124,'55',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(126,'67',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(127,'58',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(128,'59',NULL,'测试人员','男','1234567890','吉林建筑大学','电气与计算机学院','软件工程','未审核','编程','我想联系编程',1501487282,NULL,0,0,NULL,'987654',NULL),(129,'dancheng1','25d55ad283aa400af464c76d713c07ad','dancheng','nan','1245331','吉林建筑大学','电气与计算机学院','软件工程','未审核','asdasdasdasdas','dasdas',1501488092,NULL,2,0,'asdasdas','123456789','public/uploads/20170731/20170731162649597ee9c949c72.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
