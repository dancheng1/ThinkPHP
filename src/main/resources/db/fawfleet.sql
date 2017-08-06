# Host: 127.0.0.1  (Version: 5.7.3-m13)
# Date: 2015-12-15 14:47:45
# Generator: MySQL-Front 5.3  (Build 4.263)

/*
!40101 SET NAMES utf8
*/;

#
# Structure for table "adver"
#

DROP TABLE IF EXISTS `adver`;
CREATE TABLE `adver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `IMG` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "adver"
#


#
# Structure for table "area_info"
#
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `ID` int(9) NOT NULL AUTO_INCREMENT,
  `AREA_CODE` varchar(12) DEFAULT NULL,
  `AREA_NAME` varchar(50) DEFAULT NULL,
  `PID` int(9) DEFAULT NULL,
  `SORT` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "area_info"
#

INSERT INTO `area_info` VALUES (1,'100000','中国',NULL,1);

#
# Structure for table "course_info"
#

DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "course_info"
#


#
# Structure for table "course_user_info"
#

DROP TABLE IF EXISTS `course_user_info`;
CREATE TABLE `course_user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "course_user_info"
#


#
# Structure for table "dict"
#

DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LABEL` varchar(255) DEFAULT NULL,
  `VALUE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `DEL_FLAG` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "dict"
#

INSERT INTO `dict` VALUES (1,'正常','0','user','用户状态',1,NULL,NULL),(2,'禁用','1','user','用户状态',2,NULL,NULL),(4,'普通用户','0','user','用户类型',NULL,NULL,NULL),(5,'会员用户','1','user','用户类型',NULL,NULL,NULL);


#
# Structure for table "log"
#

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OPERATION_CODE` varchar(50) NOT NULL COMMENT '操作编码',
  `CREATER` varchar(20) DEFAULT NULL COMMENT '操作用户名称',
  `CREATE_DATE` datetime NOT NULL COMMENT '日志生成时间',
  `TYPE` int(11) DEFAULT NULL COMMENT '日志类型: 1：安全日志 2：表示操作日志',
  `OS` varchar(20) DEFAULT NULL,
  `BROWSER` varchar(20) DEFAULT NULL COMMENT '浏览器类型',
  `IP` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `MAC` varchar(20) DEFAULT NULL COMMENT '物理地址',
  `EXECUTE_TIME` int(11) DEFAULT NULL COMMENT '执行时间',
  `DESCRIPTION` varchar(500) DEFAULT NULL COMMENT '详细描述',
  `REQUEST_PARAM` varchar(500) DEFAULT NULL COMMENT '请求参数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2296 DEFAULT CHARSET=utf8 COMMENT='日录资料表';

#
# Data for table "log"
#

INSERT INTO `log` VALUES (2259,'/system/user/update','admin','2014-12-04 10:25:40',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,22,NULL,'{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb1234\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}'),(2260,'/system/user/update','admin','2014-12-04 10:26:14',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,9,NULL,'{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb12346\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}'),(2261,'/system/user/update','admin','2014-12-04 10:37:01',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,7,NULL,'{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb123466\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}'),(2262,'/system/role/update','admin','2014-12-04 10:48:43',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,215,NULL,'{\"id\":[\"12\"],\"roleCode\":[\"guest212\"],\"sort\":[\"4\"],\"description\":[\"s\"],\"name\":[\"guest22\"]}'),(2263,'/system/user/create','admin','2014-12-05 11:55:03',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,305,NULL,'{\"id\":[\"\"],\"birthday\":[\"2014-12-05\"],\"confirmPassword\":[\"123456\"],\"phone\":[\"\"],\"email\":[\"\"],\"name\":[\"tyty\"],\"plainPassword\":[\"123456\"],\"gender\":[\"1\"],\"loginName\":[\"test\"]}'),(2264,'/system/permission/create','admin','2014-12-13 11:19:15',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,215,NULL,'{\"id\":[\"\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}'),(2265,'/system/permission/update','admin','2014-12-13 11:19:40',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,66,NULL,'{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}'),(2266,'/system/permission/update','admin','2014-12-13 11:22:17',NULL,'Windows 7','Firefox 3','127.0.0.1',NULL,186,NULL,'{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheduleJob\"]}'),(2267,'/system/role/create','admin','2015-12-10 16:51:36',NULL,'Windows','Firefox 4','127.0.0.1',NULL,290,NULL,'{\"id\":[\"\"],\"name\":[\"test\"],\"roleCode\":[\"test\"],\"sort\":[\"1\"],\"description\":[\"xxx\"]}'),(2268,'/system/role/create','admin','2015-12-10 16:56:37',NULL,'Windows','Firefox 4','127.0.0.1',NULL,154,NULL,'{\"id\":[\"\"],\"name\":[\"role1\"],\"roleCode\":[\"role1\"],\"sort\":[\"2\"],\"description\":[\"dddd\"]}'),(2269,'/system/permission/create','admin','2015-12-10 16:58:16',NULL,'Windows','Firefox 4','127.0.0.1',NULL,299,NULL,'{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"72\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}'),(2270,'/system/permission/update','admin','2015-12-10 16:58:25',NULL,'Windows','Firefox 4','127.0.0.1',NULL,86,NULL,'{\"id\":[\"78\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"71\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}'),(2271,'/system/role/delete/14','admin','2015-12-11 09:14:21',NULL,'Windows','Chrome','127.0.0.1',NULL,116,NULL,'{}'),(2272,'/system/role/create','admin','2015-12-11 09:21:52',NULL,'Windows','Firefox 4','127.0.0.1',NULL,269,NULL,'{\"id\":[\"\"],\"name\":[\"test1\"],\"roleCode\":[\"test1\"],\"sort\":[\"1\"],\"description\":[\"ddd\"]}'),(2273,'/system/role/delete/16','admin','2015-12-11 09:22:11',NULL,'Windows','Firefox 4','127.0.0.1',NULL,95,NULL,'{}'),(2274,'/system/user/create','admin','2015-12-11 10:12:37',NULL,'Windows','Firefox 4','127.0.0.1',NULL,196,NULL,'{\"id\":[\"\"],\"loginName\":[\"use1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"use1\"],\"birthday\":[\"2015-12-17\"],\"gender\":[\"1\"],\"email\":[\"332021448@qq.com\"],\"phone\":[\"133222233333\"],\"description\":[\"33333\"]}'),(2275,'/system/user/delete/7','admin','2015-12-11 10:19:53',NULL,'Windows','Firefox 4','127.0.0.1',NULL,700,NULL,'{}'),(2276,'/system/user/create','admin','2015-12-11 10:21:25',NULL,'Windows','Firefox 4','127.0.0.1',NULL,83,NULL,'{\"id\":[\"\"],\"loginName\":[\"u1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"幽尼幽尼\"],\"birthday\":[\"2015-12-09\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}'),(2277,'/system/user/update','admin','2015-12-11 10:22:28',NULL,'Windows','Firefox 4','127.0.0.1',NULL,124,NULL,'{\"id\":[\"8\"],\"loginName\":[\"u1\"],\"name\":[\"uuu\"],\"birthday\":[\"2015-12-9\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}'),(2278,'/system/user/update','uuu','2015-12-11 10:23:43',NULL,'Windows','Firefox 4','127.0.0.1',NULL,137,NULL,'{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"jjj\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}'),(2279,'/system/user/update','jjj','2015-12-11 10:38:43',NULL,'Windows','Firefox 4','127.0.0.1',NULL,184,NULL,'{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"admin\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}'),(2280,'/system/permission/create','admin','2015-12-11 10:41:03',NULL,'Windows','Firefox 4','127.0.0.1',NULL,113,NULL,'{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}'),(2281,'/system/permission/update','admin','2015-12-11 10:41:16',NULL,'Windows','Firefox 4','127.0.0.1',NULL,112,NULL,'{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}'),(2282,'/system/organization/create','admin','2015-12-11 10:42:26',NULL,'Windows','Firefox 4','127.0.0.1',NULL,107,NULL,'{\"id\":[\"\"],\"orgName\":[\"11\"],\"pid\":[\"2\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2283,'/system/organization/create','admin','2015-12-11 10:42:46',NULL,'Windows','Firefox 4','127.0.0.1',NULL,314,NULL,'{\"id\":[\"\"],\"orgName\":[\"22\"],\"pid\":[\"3\"],\"areaId\":[\"1\"],\"orgCode\":[\"222\"],\"orgType\":[\"222\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2284,'/system/organization/create','admin','2015-12-11 10:43:12',NULL,'Windows','Firefox 4','127.0.0.1',NULL,120,NULL,'{\"id\":[\"\"],\"orgName\":[\"国外总部\"],\"pid\":[\"\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2285,'/system/organization/update','admin','2015-12-11 10:43:36',NULL,'Windows','Firefox 4','127.0.0.1',NULL,248,NULL,'{\"id\":[\"5\"],\"orgName\":[\"111\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2286,'/system/organization/update','admin','2015-12-11 10:43:45',NULL,'Windows','Firefox 4','127.0.0.1',NULL,72,NULL,'{\"id\":[\"5\"],\"orgName\":[\"国外总部\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2287,'/system/organization/create','admin','2015-12-11 10:44:06',NULL,'Windows','Firefox 4','127.0.0.1',NULL,210,NULL,'{\"id\":[\"\"],\"orgName\":[\"总部办事处\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}'),(2288,'/system/permission/update','admin','2015-12-11 13:23:53',NULL,'Windows','Firefox 4','127.0.0.1',NULL,262,NULL,'{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"测试菜单一级标题\"]}'),(2289,'/system/permission/create','admin','2015-12-11 13:24:57',NULL,'Windows','Firefox 4','127.0.0.1',NULL,106,NULL,'{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试表单\"],\"url\":[\"menutest/tabletest\"],\"icon\":[\"icon-hamburg-lightbulb\"],\"pid\":[\"79\"],\"sort\":[\"1\"],\"description\":[\"测试表单菜单\"]}'),(2290,'/system/permission/delete/79','admin','2015-12-14 11:16:46',NULL,'Windows','Firefox 4','127.0.0.1',NULL,176,NULL,'{}'),(2291,'/system/permission/delete/71','admin','2015-12-14 11:16:51',NULL,'Windows','Firefox 4','127.0.0.1',NULL,81,NULL,'{}'),(2292,'/system/permission/delete/72','admin','2015-12-14 11:16:54',NULL,'Windows','Firefox 4','127.0.0.1',NULL,82,NULL,'{}'),(2293,'/system/permission/delete/73','admin','2015-12-14 11:16:56',NULL,'Windows','Firefox 4','127.0.0.1',NULL,98,NULL,'{}'),(2294,'/system/permission/delete/78','admin','2015-12-14 11:17:00',NULL,'Windows','Firefox 4','127.0.0.1',NULL,95,NULL,'{}'),(2295,'/system/permission/delete/80','admin','2015-12-14 11:17:03',NULL,'Windows','Firefox 4','127.0.0.1',NULL,116,NULL,'{}');

#
# Structure for table "organization"
#

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(255) NOT NULL,
  `pid` int(9) DEFAULT NULL,
  `org_type` varchar(255) DEFAULT NULL,
  `org_sort` int(3) DEFAULT '0',
  `org_level` int(3) DEFAULT NULL,
  `org_code` varchar(255) DEFAULT NULL,
  `area_id` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "organization"
#

INSERT INTO `organization` VALUES (1,'总部',NULL,'总部',1,1,'000000',NULL),(2,'12313',1,'13',31,131,'131313',1),(3,'11',2,'1',1,1,'111',1),(4,'22',3,'222',1,1,'222',1),(5,'国外总部',5,'1',1,1,'111',1),(6,'总部办事处',5,'1',1,1,'111',1);

#
# Structure for table "permission"
#

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL COMMENT '父节点名称',
  `NAME` varchar(50) NOT NULL COMMENT '名称',
  `TYPE` varchar(20) DEFAULT NULL COMMENT '类型:菜单or功能',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `URL` varchar(255) DEFAULT NULL,
  `PERM_CODE` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `ICON` varchar(255) DEFAULT NULL,
  `STATE` varchar(10) DEFAULT NULL,
  `DESCRIPTION` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

#
# Data for table "permission"
#

INSERT INTO `permission` VALUES (1,NULL,'系统管理','F',1,'','','icon-standard-cog','',''),(2,1,'角色管理','F',3,'system/role','','icon-hamburg-my-account','closed',''),(3,1,'用户管理','F',2,'system/user','','icon-hamburg-user','closed',''),(4,2,'添加','O',NULL,'','sys:role:add','','','角色添加'),(5,2,'删除','O',NULL,'','sys:role:delete','','','角色删除'),(6,2,'修改','O',NULL,'','sys:role:update','','','角色修改'),(7,3,'添加','O',NULL,'','sys:user:add','','','用户添加'),(8,3,'删除','O',NULL,'','sys:user:delete','','','用户删除'),(12,1,'权限管理','F',5,'system/permission','','icon-hamburg-login','closed',''),(14,15,'数据源监控','F',6,'druid','','icon-hamburg-database','',''),(15,NULL,'系统监控','F',5,'','','icon-hamburg-graphic','',''),(16,3,'修改','O',NULL,'','sys:user:update','','','用户修改'),(20,15,'日志管理','F',7,'system/log','','icon-hamburg-archives','',''),(25,12,'添加','O',NULL,'','sys:perm:add','','','菜单添加'),(26,12,'修改','O',NULL,'','sys:perm:update','','','菜单修改'),(27,12,'删除','O',NULL,'','sys:perm:delete','','','菜单删除'),(28,2,'查看','O',NULL,'','sys:role:view','','','角色查看'),(29,3,'查看','O',NULL,'','sys:user:view','',NULL,'用户查看'),(30,12,'查看','O',NULL,'','sys:perm:view','',NULL,'权限查看'),(31,20,'删除','O',NULL,'','sys:log:delete','',NULL,'删除日志'),(32,20,'导出excel','O',NULL,'','sys:log:exportExcel','',NULL,'导出日志excel'),(33,3,'查看用户角色','O',NULL,'','sys:user:roleView','',NULL,'查看用户角色'),(34,2,'保存授权','O',NULL,'','sys:role:permUpd','',NULL,'保存修改的角色权限'),(35,3,'修改用户角色','O',NULL,'','sys:user:roleUpd','',NULL,'修改用户拥有的角色'),(36,2,'查看角色权限','O',NULL,'','sys:role:permView','',NULL,'查看角色拥有的权限'),(37,15,'定时任务管理','F',NULL,'system/scheduleJob','','icon-hamburg-full-time',NULL,'定时任务管理，支持集群'),(38,15,'cron表达式生成','F',NULL,'system/scheduleJob/quartzCron','','icon-hamburg-future',NULL,''),(39,1,'菜单管理','F',4,'system/permission/menu','','icon-hamburg-old-versions',NULL,''),(40,1,'字典管理','F',6,'system/dict',NULL,'icon-hamburg-address',NULL,'数据字典管理'),(45,39,'修改','O',NULL,'','sys:perm:update',NULL,NULL,'菜单管理'),(58,39,'添加','O',NULL,'','sys:perm:add',NULL,NULL,'菜单管理'),(59,39,'删除','O',NULL,'','sys:perm:delte',NULL,NULL,'菜单管理'),(61,40,'添加','O',NULL,'','sys:dict:add',NULL,NULL,'字典管理'),(62,40,'删除','O',NULL,'','sys:dict:delete',NULL,NULL,'字典管理'),(63,40,'修改','O',NULL,'','sys:dict:update',NULL,NULL,'字典管理'),(68,20,'查看','O',NULL,'','sys:log:view',NULL,NULL,'查看日志'),(69,40,'查看','O',NULL,'','sys:dict:view',NULL,NULL,'字典管理'),(70,39,'查看','O',NULL,'','sys:perm:menu:view',NULL,NULL,'菜单管理'),(74,1,'区域信息','F',7,'system/area',NULL,'icon-hamburg-world',NULL,'管理行政区划'),(75,1,'机构管理','F',8,'system/organization',NULL,'icon-cologne-home',NULL,'组织机构管理'),(76,3,'查看用户机构','O',NULL,'','sys:user:orgView',NULL,NULL,'查看用户机构'),(77,3,'修改用户机构','O',NULL,'','sys:user:orgUpd',NULL,NULL,'修改用户所在的机构');

#
# Structure for table "qrtz_calendars"
#

DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_calendars"
#


#
# Structure for table "qrtz_fired_triggers"
#

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_fired_triggers"
#


#
# Structure for table "qrtz_job_details"
#

DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_job_details"
#

INSERT INTO `qrtz_job_details` VALUES ('scheduler','test1','testgroup',NULL,'com.qm.fawfleet.system.service.TaskA','0','1','0','0',X'ACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000B7363686564756C654A6F6273720028636F6D2E7469616E79752E6A74792E73797374656D2E656E746974792E5363686564756C654A6F6200000000000000010200064C0009636C6173734E616D657400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000B6465736372697074696F6E71007E00094C000567726F757071007E00094C00046E616D6571007E00094C000673746174757371007E00097870740023636F6D2E7469616E79752E6A74792E73797374656D2E736572766963652E5461736B4174000D302F35202A202A202A202A203F707400097465737467726F75707400057465737431740001317800');

#
# Structure for table "qrtz_locks"
#

DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_locks"
#

INSERT INTO `qrtz_locks` VALUES ('scheduler','STATE_ACCESS'),('scheduler','TRIGGER_ACCESS');

#
# Structure for table "qrtz_paused_trigger_grps"
#

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_paused_trigger_grps"
#


#
# Structure for table "qrtz_scheduler_state"
#

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_scheduler_state"
#

INSERT INTO `qrtz_scheduler_state` VALUES ('scheduler','DESKTOP-71DS4ST1450146920995',1450147191490,15000);

#
# Structure for table "qrtz_triggers"
#

DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_triggers"
#

INSERT INTO `qrtz_triggers` VALUES ('scheduler','test1','testgroup','test1','testgroup',NULL,1421206460000,1421206455000,5,'PAUSED','CRON',1421206412000,0,NULL,0,X'');

#
# Structure for table "qrtz_simprop_triggers"
#

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_simprop_triggers"
#


#
# Structure for table "qrtz_simple_triggers"
#

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_simple_triggers"
#


#
# Structure for table "qrtz_cron_triggers"
#

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_cron_triggers"
#

INSERT INTO `qrtz_cron_triggers` VALUES ('scheduler','test1','testgroup','0/5 * * * * ?','Asia/Shanghai');

#
# Structure for table "qrtz_blob_triggers"
#

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "qrtz_blob_triggers"
#


#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `ROLE_CODE` varchar(20) NOT NULL,
  `DESCRIPTION` text,
  `SORT` smallint(6) DEFAULT NULL,
  `DEL_FLAG` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'admin','admin','admin',2,NULL),(5,'guest','guest','guest',3,NULL),(13,'superadmin','superadmin','超级管理员',1,NULL),(15,'role1','role1','dddd',2,NULL);

#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) DEFAULT NULL,
  `PERMISSION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ROLE_PER_REFERENCE_PERMISSI` (`PERMISSION_ID`) USING BTREE,
  KEY `FK_ROLE_PER_REFERENCE_ROLE` (`ROLE_ID`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `permission` (`ID`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8;

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` VALUES (1,1,2),(2,1,1),(28,5,1),(61,13,1),(62,13,3),(63,13,16),(64,13,7),(65,13,2),(66,13,4),(67,13,5),(68,13,6),(69,13,12),(70,13,25),(71,13,26),(72,13,27),(74,13,15),(75,13,14),(76,13,20),(77,13,8),(81,1,3),(88,1,12),(93,1,15),(94,1,14),(95,1,20),(118,1,28),(120,1,30),(121,1,31),(125,1,33),(126,1,36),(127,1,35),(129,1,34),(130,1,32),(133,5,15),(135,1,37),(142,1,38),(145,1,40),(147,1,29),(151,1,61),(152,1,62),(153,1,63),(162,5,39),(164,5,58),(176,5,40),(177,1,39),(178,1,58),(179,1,59),(183,1,4),(184,1,6),(185,1,26),(186,1,27),(187,1,5),(189,1,25),(190,1,45),(191,1,7),(192,1,8),(193,1,16),(194,13,28),(195,13,34),(196,13,36),(197,13,29),(198,13,33),(199,13,35),(200,13,30),(201,13,39),(202,13,45),(203,13,58),(204,13,59),(205,13,40),(206,13,61),(207,13,62),(208,13,63),(209,13,31),(210,13,32),(211,13,37),(212,13,38),(213,1,69),(215,5,69),(216,5,20),(219,5,68),(220,5,38),(221,1,70),(222,5,70),(223,5,3),(227,5,29),(228,5,33),(229,5,35),(231,5,2),(234,5,28),(235,5,45),(236,5,59),(239,5,36),(240,1,68),(244,1,74),(245,1,75),(246,1,76),(247,1,77),(248,15,33),(249,15,3),(250,15,1),(251,15,29),(252,15,40),(253,15,61),(255,15,63),(256,15,69),(258,15,12),(259,15,26),(261,15,16),(262,15,35),(263,15,7),(264,15,76),(265,15,77),(266,15,58),(267,15,39),(268,15,45),(269,15,70),(270,15,25),(271,15,30);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `SALT` varchar(255) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `GENDER` smallint(6) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `ICON` varchar(500) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL,
  `DESCRIPTION` text,
  `LOGIN_COUNT` int(11) DEFAULT NULL,
  `PREVIOUS_VISIT` datetime DEFAULT NULL,
  `LAST_VISIT` datetime DEFAULT NULL,
  `DEL_FLAG` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'admin','admin','159ae5f48f14e89f3f9f54dc995f1f276d472b54','3d06a5c14d010804','2014-03-16 00:00:00',1,'779205344@qq.com','123456789','aaa','2014-03-20 14:38:57','0','',135,'2015-12-11 10:06:51','2015-12-11 13:23:53',NULL),(3,'tianyu','tiany','1e8df4b59b3a3ab452ed1707ad3cb1a8e63a0630','bb2aa40007ad1238','2014-04-02 00:00:00',0,'','300','','2014-04-02 11:49:13','0',NULL,NULL,NULL,NULL,NULL),(5,'test','tyty11','dc6d230074477c8d736bfe0205260e9320565aa6','94886d7223c80850','2014-12-05 00:00:00',1,'','',NULL,'2014-12-05 11:55:03','1','ss',1,NULL,'2014-12-14 00:09:27',NULL),(6,'superadmin','超级管理员','df894ac0dd60772f22b5d67fe5d8b04fb4c9188d','97efb48ee6adff63','2015-01-15 00:00:00',1,'779205344@qq.com','13721035120',NULL,'2015-01-15 15:55:37',NULL,'超级管理员',NULL,NULL,NULL,NULL),(8,'u1','uuu','be27d739373dfb9bada623c7fe8c53dd6d237c7b','5ca1169ba5ca1bea','2015-12-09 00:00:00',1,'','',NULL,'2015-12-11 10:21:25',NULL,'',NULL,NULL,NULL,NULL);

#
# Structure for table "user_info"
#

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `unumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "user_info"
#

INSERT INTO `user_info` VALUES (1,'xiaoming111','4'),(2,'xiaoming222','4');

#
# Structure for table "user_org"
#

DROP TABLE IF EXISTS `user_org`;
CREATE TABLE `user_org` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_id` int(9) NOT NULL,
  `org_id` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "user_org"
#

INSERT INTO `user_org` VALUES (9,1,2),(11,5,2),(12,8,2),(15,6,1),(16,3,4);

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USER_ROL_REFERENCE_ROLE` (`ROLE_ID`) USING BTREE,
  KEY `FK_USER_ROL_REFERENCE_USERS` (`USER_ID`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (1,1,1),(19,3,5),(35,6,13),(36,6,1),(37,5,15),(39,8,15);
