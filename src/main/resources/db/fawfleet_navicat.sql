/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : fawfleet

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-12-16 13:53:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `adver`
-- ----------------------------
DROP TABLE IF EXISTS `adver`;
CREATE TABLE `adver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `IMG` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adver
-- ----------------------------

-- ----------------------------
-- Table structure for `area_info`
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `ID` int(9) NOT NULL AUTO_INCREMENT,
  `AREA_CODE` varchar(12) DEFAULT NULL,
  `AREA_NAME` varchar(50) DEFAULT NULL,
  `PID` int(9) DEFAULT NULL,
  `SORT` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area_info
-- ----------------------------
INSERT INTO area_info VALUES ('1', '100000', '中国', null, '1');

-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------

-- ----------------------------
-- Table structure for `course_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_user_info`;
CREATE TABLE `course_user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
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

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO dict VALUES ('1', '正常', '0', 'user', '用户状态', '1', null, null);
INSERT INTO dict VALUES ('2', '禁用', '1', 'user', '用户状态', '2', null, null);
INSERT INTO dict VALUES ('4', '普通用户', '0', 'user', '用户类型', null, null, null);
INSERT INTO dict VALUES ('5', '会员用户', '1', 'user', '用户类型', null, null, null);

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
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

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO log VALUES ('2259', '/system/user/update', 'admin', '2014-12-04 10:25:40', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '22', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb1234\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2260', '/system/user/update', 'admin', '2014-12-04 10:26:14', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '9', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb12346\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2261', '/system/user/update', 'admin', '2014-12-04 10:37:01', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '7', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb123466\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2262', '/system/role/update', 'admin', '2014-12-04 10:48:43', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '215', null, '{\"id\":[\"12\"],\"roleCode\":[\"guest212\"],\"sort\":[\"4\"],\"description\":[\"s\"],\"name\":[\"guest22\"]}');
INSERT INTO log VALUES ('2263', '/system/user/create', 'admin', '2014-12-05 11:55:03', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '305', null, '{\"id\":[\"\"],\"birthday\":[\"2014-12-05\"],\"confirmPassword\":[\"123456\"],\"phone\":[\"\"],\"email\":[\"\"],\"name\":[\"tyty\"],\"plainPassword\":[\"123456\"],\"gender\":[\"1\"],\"loginName\":[\"test\"]}');
INSERT INTO log VALUES ('2264', '/system/permission/create', 'admin', '2014-12-13 11:19:15', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '215', null, '{\"id\":[\"\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}');
INSERT INTO log VALUES ('2265', '/system/permission/update', 'admin', '2014-12-13 11:19:40', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '66', null, '{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}');
INSERT INTO log VALUES ('2266', '/system/permission/update', 'admin', '2014-12-13 11:22:17', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '186', null, '{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheduleJob\"]}');
INSERT INTO log VALUES ('2267', '/system/role/create', 'admin', '2015-12-10 16:51:36', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '290', null, '{\"id\":[\"\"],\"name\":[\"test\"],\"roleCode\":[\"test\"],\"sort\":[\"1\"],\"description\":[\"xxx\"]}');
INSERT INTO log VALUES ('2268', '/system/role/create', 'admin', '2015-12-10 16:56:37', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '154', null, '{\"id\":[\"\"],\"name\":[\"role1\"],\"roleCode\":[\"role1\"],\"sort\":[\"2\"],\"description\":[\"dddd\"]}');
INSERT INTO log VALUES ('2269', '/system/permission/create', 'admin', '2015-12-10 16:58:16', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '299', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"72\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}');
INSERT INTO log VALUES ('2270', '/system/permission/update', 'admin', '2015-12-10 16:58:25', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '86', null, '{\"id\":[\"78\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"71\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}');
INSERT INTO log VALUES ('2271', '/system/role/delete/14', 'admin', '2015-12-11 09:14:21', null, 'Windows', 'Chrome', '127.0.0.1', null, '116', null, '{}');
INSERT INTO log VALUES ('2272', '/system/role/create', 'admin', '2015-12-11 09:21:52', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '269', null, '{\"id\":[\"\"],\"name\":[\"test1\"],\"roleCode\":[\"test1\"],\"sort\":[\"1\"],\"description\":[\"ddd\"]}');
INSERT INTO log VALUES ('2273', '/system/role/delete/16', 'admin', '2015-12-11 09:22:11', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '95', null, '{}');
INSERT INTO log VALUES ('2274', '/system/user/create', 'admin', '2015-12-11 10:12:37', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '196', null, '{\"id\":[\"\"],\"loginName\":[\"use1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"use1\"],\"birthday\":[\"2015-12-17\"],\"gender\":[\"1\"],\"email\":[\"332021448@qq.com\"],\"phone\":[\"133222233333\"],\"description\":[\"33333\"]}');
INSERT INTO log VALUES ('2275', '/system/user/delete/7', 'admin', '2015-12-11 10:19:53', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '700', null, '{}');
INSERT INTO log VALUES ('2276', '/system/user/create', 'admin', '2015-12-11 10:21:25', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '83', null, '{\"id\":[\"\"],\"loginName\":[\"u1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"幽尼幽尼\"],\"birthday\":[\"2015-12-09\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2277', '/system/user/update', 'admin', '2015-12-11 10:22:28', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '124', null, '{\"id\":[\"8\"],\"loginName\":[\"u1\"],\"name\":[\"uuu\"],\"birthday\":[\"2015-12-9\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2278', '/system/user/update', 'uuu', '2015-12-11 10:23:43', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '137', null, '{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"jjj\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2279', '/system/user/update', 'jjj', '2015-12-11 10:38:43', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '184', null, '{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"admin\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2280', '/system/permission/create', 'admin', '2015-12-11 10:41:03', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '113', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2281', '/system/permission/update', 'admin', '2015-12-11 10:41:16', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '112', null, '{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2282', '/system/organization/create', 'admin', '2015-12-11 10:42:26', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '107', null, '{\"id\":[\"\"],\"orgName\":[\"11\"],\"pid\":[\"2\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2283', '/system/organization/create', 'admin', '2015-12-11 10:42:46', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '314', null, '{\"id\":[\"\"],\"orgName\":[\"22\"],\"pid\":[\"3\"],\"areaId\":[\"1\"],\"orgCode\":[\"222\"],\"orgType\":[\"222\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2284', '/system/organization/create', 'admin', '2015-12-11 10:43:12', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '120', null, '{\"id\":[\"\"],\"orgName\":[\"国外总部\"],\"pid\":[\"\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2285', '/system/organization/update', 'admin', '2015-12-11 10:43:36', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '248', null, '{\"id\":[\"5\"],\"orgName\":[\"111\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2286', '/system/organization/update', 'admin', '2015-12-11 10:43:45', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '72', null, '{\"id\":[\"5\"],\"orgName\":[\"国外总部\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2287', '/system/organization/create', 'admin', '2015-12-11 10:44:06', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '210', null, '{\"id\":[\"\"],\"orgName\":[\"总部办事处\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2288', '/system/permission/update', 'admin', '2015-12-11 13:23:53', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '262', null, '{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"测试菜单一级标题\"]}');
INSERT INTO log VALUES ('2289', '/system/permission/create', 'admin', '2015-12-11 13:24:57', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '106', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试表单\"],\"url\":[\"menutest/tabletest\"],\"icon\":[\"icon-hamburg-lightbulb\"],\"pid\":[\"79\"],\"sort\":[\"1\"],\"description\":[\"测试表单菜单\"]}');
INSERT INTO log VALUES ('2290', '/system/permission/delete/79', 'admin', '2015-12-14 11:16:46', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '176', null, '{}');
INSERT INTO log VALUES ('2291', '/system/permission/delete/71', 'admin', '2015-12-14 11:16:51', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '81', null, '{}');
INSERT INTO log VALUES ('2292', '/system/permission/delete/72', 'admin', '2015-12-14 11:16:54', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '82', null, '{}');
INSERT INTO log VALUES ('2293', '/system/permission/delete/73', 'admin', '2015-12-14 11:16:56', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '98', null, '{}');
INSERT INTO log VALUES ('2294', '/system/permission/delete/78', 'admin', '2015-12-14 11:17:00', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '95', null, '{}');
INSERT INTO log VALUES ('2295', '/system/permission/delete/80', 'admin', '2015-12-14 11:17:03', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '116', null, '{}');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
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

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO organization VALUES ('1', '总部', null, '总部', '1', '1', '000000', null);
INSERT INTO organization VALUES ('2', '12313', '1', '13', '31', '131', '131313', '1');
INSERT INTO organization VALUES ('3', '11', '2', '1', '1', '1', '111', '1');
INSERT INTO organization VALUES ('4', '22', '3', '222', '1', '1', '222', '1');
INSERT INTO organization VALUES ('5', '国外总部', '5', '1', '1', '1', '111', '1');
INSERT INTO organization VALUES ('6', '总部办事处', '5', '1', '1', '1', '111', '1');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
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

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission VALUES ('1', null, '系统管理', 'F', '1', '', '', 'icon-standard-cog', '', '');
INSERT INTO permission VALUES ('2', '1', '角色管理', 'F', '3', 'system/role', '', 'icon-hamburg-my-account', 'closed', '');
INSERT INTO permission VALUES ('3', '1', '用户管理', 'F', '2', 'system/user', '', 'icon-hamburg-user', 'closed', '');
INSERT INTO permission VALUES ('4', '2', '添加', 'O', null, '', 'sys:role:add', '', '', '角色添加');
INSERT INTO permission VALUES ('5', '2', '删除', 'O', null, '', 'sys:role:delete', '', '', '角色删除');
INSERT INTO permission VALUES ('6', '2', '修改', 'O', null, '', 'sys:role:update', '', '', '角色修改');
INSERT INTO permission VALUES ('7', '3', '添加', 'O', null, '', 'sys:user:add', '', '', '用户添加');
INSERT INTO permission VALUES ('8', '3', '删除', 'O', null, '', 'sys:user:delete', '', '', '用户删除');
INSERT INTO permission VALUES ('12', '1', '权限管理', 'F', '5', 'system/permission', '', 'icon-hamburg-login', 'closed', '');
INSERT INTO permission VALUES ('14', '15', '数据源监控', 'F', '6', 'druid', '', 'icon-hamburg-database', '', '');
INSERT INTO permission VALUES ('15', null, '系统监控', 'F', '5', '', '', 'icon-hamburg-graphic', '', '');
INSERT INTO permission VALUES ('16', '3', '修改', 'O', null, '', 'sys:user:update', '', '', '用户修改');
INSERT INTO permission VALUES ('20', '15', '日志管理', 'F', '7', 'system/log', '', 'icon-hamburg-archives', '', '');
INSERT INTO permission VALUES ('25', '12', '添加', 'O', null, '', 'sys:perm:add', '', '', '菜单添加');
INSERT INTO permission VALUES ('26', '12', '修改', 'O', null, '', 'sys:perm:update', '', '', '菜单修改');
INSERT INTO permission VALUES ('27', '12', '删除', 'O', null, '', 'sys:perm:delete', '', '', '菜单删除');
INSERT INTO permission VALUES ('28', '2', '查看', 'O', null, '', 'sys:role:view', '', '', '角色查看');
INSERT INTO permission VALUES ('29', '3', '查看', 'O', null, '', 'sys:user:view', '', null, '用户查看');
INSERT INTO permission VALUES ('30', '12', '查看', 'O', null, '', 'sys:perm:view', '', null, '权限查看');
INSERT INTO permission VALUES ('31', '20', '删除', 'O', null, '', 'sys:log:delete', '', null, '删除日志');
INSERT INTO permission VALUES ('32', '20', '导出excel', 'O', null, '', 'sys:log:exportExcel', '', null, '导出日志excel');
INSERT INTO permission VALUES ('33', '3', '查看用户角色', 'O', null, '', 'sys:user:roleView', '', null, '查看用户角色');
INSERT INTO permission VALUES ('34', '2', '保存授权', 'O', null, '', 'sys:role:permUpd', '', null, '保存修改的角色权限');
INSERT INTO permission VALUES ('35', '3', '修改用户角色', 'O', null, '', 'sys:user:roleUpd', '', null, '修改用户拥有的角色');
INSERT INTO permission VALUES ('36', '2', '查看角色权限', 'O', null, '', 'sys:role:permView', '', null, '查看角色拥有的权限');
INSERT INTO permission VALUES ('37', '15', '定时任务管理', 'F', null, 'system/scheduleJob', '', 'icon-hamburg-full-time', null, '定时任务管理，支持集群');
INSERT INTO permission VALUES ('38', '15', 'cron表达式生成', 'F', null, 'system/scheduleJob/quartzCron', '', 'icon-hamburg-future', null, '');
INSERT INTO permission VALUES ('39', '1', '菜单管理', 'F', '4', 'system/permission/menu', '', 'icon-hamburg-old-versions', null, '');
INSERT INTO permission VALUES ('40', '1', '字典管理', 'F', '6', 'system/dict', null, 'icon-hamburg-address', null, '数据字典管理');
INSERT INTO permission VALUES ('45', '39', '修改', 'O', null, '', 'sys:perm:update', null, null, '菜单管理');
INSERT INTO permission VALUES ('58', '39', '添加', 'O', null, '', 'sys:perm:add', null, null, '菜单管理');
INSERT INTO permission VALUES ('59', '39', '删除', 'O', null, '', 'sys:perm:delte', null, null, '菜单管理');
INSERT INTO permission VALUES ('61', '40', '添加', 'O', null, '', 'sys:dict:add', null, null, '字典管理');
INSERT INTO permission VALUES ('62', '40', '删除', 'O', null, '', 'sys:dict:delete', null, null, '字典管理');
INSERT INTO permission VALUES ('63', '40', '修改', 'O', null, '', 'sys:dict:update', null, null, '字典管理');
INSERT INTO permission VALUES ('68', '20', '查看', 'O', null, '', 'sys:log:view', null, null, '查看日志');
INSERT INTO permission VALUES ('69', '40', '查看', 'O', null, '', 'sys:dict:view', null, null, '字典管理');
INSERT INTO permission VALUES ('70', '39', '查看', 'O', null, '', 'sys:perm:menu:view', null, null, '菜单管理');
INSERT INTO permission VALUES ('74', '1', '区域信息', 'F', '7', 'system/area', null, 'icon-hamburg-world', null, '管理行政区划');
INSERT INTO permission VALUES ('75', '1', '机构管理', 'F', '8', 'system/organization', null, 'icon-cologne-home', null, '组织机构管理');
INSERT INTO permission VALUES ('76', '3', '查看用户机构', 'O', null, '', 'sys:user:orgView', null, null, '查看用户机构');
INSERT INTO permission VALUES ('77', '3', '修改用户机构', 'O', null, '', 'sys:user:orgUpd', null, null, '修改用户所在的机构');

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO qrtz_cron_triggers VALUES ('scheduler', 'test1', 'testgroup', '0/5 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO qrtz_job_details VALUES ('scheduler', 'test1', 'testgroup', null, 'com.tianyu.jty.system.service.TaskA', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000B7363686564756C654A6F6273720028636F6D2E7469616E79752E6A74792E73797374656D2E656E746974792E5363686564756C654A6F6200000000000000010200064C0009636C6173734E616D657400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000B6465736372697074696F6E71007E00094C000567726F757071007E00094C00046E616D6571007E00094C000673746174757371007E00097870740023636F6D2E7469616E79752E6A74792E73797374656D2E736572766963652E5461736B4174000D302F35202A202A202A202A203F707400097465737467726F75707400057465737431740001317800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO qrtz_locks VALUES ('scheduler', 'STATE_ACCESS');
INSERT INTO qrtz_locks VALUES ('scheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO qrtz_scheduler_state VALUES ('scheduler', 'DESKTOP-71DS4ST1450236247687', '1450240389221', '15000');

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO qrtz_triggers VALUES ('scheduler', 'test1', 'testgroup', 'test1', 'testgroup', null, '1421206460000', '1421206455000', '5', 'PAUSED', 'CRON', '1421206412000', '0', null, '0', '');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
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

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', 'admin', 'admin', 'admin', '2', null);
INSERT INTO role VALUES ('5', 'guest', 'guest', 'guest', '3', null);
INSERT INTO role VALUES ('13', 'superadmin', 'superadmin', '超级管理员', '1', null);
INSERT INTO role VALUES ('15', 'role1', 'role1', 'dddd', '2', null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
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

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO role_permission VALUES ('1', '1', '2');
INSERT INTO role_permission VALUES ('2', '1', '1');
INSERT INTO role_permission VALUES ('28', '5', '1');
INSERT INTO role_permission VALUES ('61', '13', '1');
INSERT INTO role_permission VALUES ('62', '13', '3');
INSERT INTO role_permission VALUES ('63', '13', '16');
INSERT INTO role_permission VALUES ('64', '13', '7');
INSERT INTO role_permission VALUES ('65', '13', '2');
INSERT INTO role_permission VALUES ('66', '13', '4');
INSERT INTO role_permission VALUES ('67', '13', '5');
INSERT INTO role_permission VALUES ('68', '13', '6');
INSERT INTO role_permission VALUES ('69', '13', '12');
INSERT INTO role_permission VALUES ('70', '13', '25');
INSERT INTO role_permission VALUES ('71', '13', '26');
INSERT INTO role_permission VALUES ('72', '13', '27');
INSERT INTO role_permission VALUES ('74', '13', '15');
INSERT INTO role_permission VALUES ('75', '13', '14');
INSERT INTO role_permission VALUES ('76', '13', '20');
INSERT INTO role_permission VALUES ('77', '13', '8');
INSERT INTO role_permission VALUES ('81', '1', '3');
INSERT INTO role_permission VALUES ('88', '1', '12');
INSERT INTO role_permission VALUES ('93', '1', '15');
INSERT INTO role_permission VALUES ('94', '1', '14');
INSERT INTO role_permission VALUES ('95', '1', '20');
INSERT INTO role_permission VALUES ('118', '1', '28');
INSERT INTO role_permission VALUES ('120', '1', '30');
INSERT INTO role_permission VALUES ('121', '1', '31');
INSERT INTO role_permission VALUES ('125', '1', '33');
INSERT INTO role_permission VALUES ('126', '1', '36');
INSERT INTO role_permission VALUES ('127', '1', '35');
INSERT INTO role_permission VALUES ('129', '1', '34');
INSERT INTO role_permission VALUES ('130', '1', '32');
INSERT INTO role_permission VALUES ('133', '5', '15');
INSERT INTO role_permission VALUES ('135', '1', '37');
INSERT INTO role_permission VALUES ('142', '1', '38');
INSERT INTO role_permission VALUES ('145', '1', '40');
INSERT INTO role_permission VALUES ('147', '1', '29');
INSERT INTO role_permission VALUES ('151', '1', '61');
INSERT INTO role_permission VALUES ('152', '1', '62');
INSERT INTO role_permission VALUES ('153', '1', '63');
INSERT INTO role_permission VALUES ('162', '5', '39');
INSERT INTO role_permission VALUES ('164', '5', '58');
INSERT INTO role_permission VALUES ('176', '5', '40');
INSERT INTO role_permission VALUES ('177', '1', '39');
INSERT INTO role_permission VALUES ('178', '1', '58');
INSERT INTO role_permission VALUES ('179', '1', '59');
INSERT INTO role_permission VALUES ('183', '1', '4');
INSERT INTO role_permission VALUES ('184', '1', '6');
INSERT INTO role_permission VALUES ('185', '1', '26');
INSERT INTO role_permission VALUES ('186', '1', '27');
INSERT INTO role_permission VALUES ('187', '1', '5');
INSERT INTO role_permission VALUES ('189', '1', '25');
INSERT INTO role_permission VALUES ('190', '1', '45');
INSERT INTO role_permission VALUES ('191', '1', '7');
INSERT INTO role_permission VALUES ('192', '1', '8');
INSERT INTO role_permission VALUES ('193', '1', '16');
INSERT INTO role_permission VALUES ('194', '13', '28');
INSERT INTO role_permission VALUES ('195', '13', '34');
INSERT INTO role_permission VALUES ('196', '13', '36');
INSERT INTO role_permission VALUES ('197', '13', '29');
INSERT INTO role_permission VALUES ('198', '13', '33');
INSERT INTO role_permission VALUES ('199', '13', '35');
INSERT INTO role_permission VALUES ('200', '13', '30');
INSERT INTO role_permission VALUES ('201', '13', '39');
INSERT INTO role_permission VALUES ('202', '13', '45');
INSERT INTO role_permission VALUES ('203', '13', '58');
INSERT INTO role_permission VALUES ('204', '13', '59');
INSERT INTO role_permission VALUES ('205', '13', '40');
INSERT INTO role_permission VALUES ('206', '13', '61');
INSERT INTO role_permission VALUES ('207', '13', '62');
INSERT INTO role_permission VALUES ('208', '13', '63');
INSERT INTO role_permission VALUES ('209', '13', '31');
INSERT INTO role_permission VALUES ('210', '13', '32');
INSERT INTO role_permission VALUES ('211', '13', '37');
INSERT INTO role_permission VALUES ('212', '13', '38');
INSERT INTO role_permission VALUES ('213', '1', '69');
INSERT INTO role_permission VALUES ('215', '5', '69');
INSERT INTO role_permission VALUES ('216', '5', '20');
INSERT INTO role_permission VALUES ('219', '5', '68');
INSERT INTO role_permission VALUES ('220', '5', '38');
INSERT INTO role_permission VALUES ('221', '1', '70');
INSERT INTO role_permission VALUES ('222', '5', '70');
INSERT INTO role_permission VALUES ('223', '5', '3');
INSERT INTO role_permission VALUES ('227', '5', '29');
INSERT INTO role_permission VALUES ('228', '5', '33');
INSERT INTO role_permission VALUES ('229', '5', '35');
INSERT INTO role_permission VALUES ('231', '5', '2');
INSERT INTO role_permission VALUES ('234', '5', '28');
INSERT INTO role_permission VALUES ('235', '5', '45');
INSERT INTO role_permission VALUES ('236', '5', '59');
INSERT INTO role_permission VALUES ('239', '5', '36');
INSERT INTO role_permission VALUES ('240', '1', '68');
INSERT INTO role_permission VALUES ('244', '1', '74');
INSERT INTO role_permission VALUES ('245', '1', '75');
INSERT INTO role_permission VALUES ('246', '1', '76');
INSERT INTO role_permission VALUES ('247', '1', '77');
INSERT INTO role_permission VALUES ('248', '15', '33');
INSERT INTO role_permission VALUES ('249', '15', '3');
INSERT INTO role_permission VALUES ('250', '15', '1');
INSERT INTO role_permission VALUES ('251', '15', '29');
INSERT INTO role_permission VALUES ('252', '15', '40');
INSERT INTO role_permission VALUES ('253', '15', '61');
INSERT INTO role_permission VALUES ('255', '15', '63');
INSERT INTO role_permission VALUES ('256', '15', '69');
INSERT INTO role_permission VALUES ('258', '15', '12');
INSERT INTO role_permission VALUES ('259', '15', '26');
INSERT INTO role_permission VALUES ('261', '15', '16');
INSERT INTO role_permission VALUES ('262', '15', '35');
INSERT INTO role_permission VALUES ('263', '15', '7');
INSERT INTO role_permission VALUES ('264', '15', '76');
INSERT INTO role_permission VALUES ('265', '15', '77');
INSERT INTO role_permission VALUES ('266', '15', '58');
INSERT INTO role_permission VALUES ('267', '15', '39');
INSERT INTO role_permission VALUES ('268', '15', '45');
INSERT INTO role_permission VALUES ('269', '15', '70');
INSERT INTO role_permission VALUES ('270', '15', '25');
INSERT INTO role_permission VALUES ('271', '15', '30');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', 'admin', '159ae5f48f14e89f3f9f54dc995f1f276d472b54', '3d06a5c14d010804', '2014-03-16 00:00:00', '1', '779205344@qq.com', '123456789', 'aaa', '2014-03-20 14:38:57', '0', '', '135', '2015-12-11 10:06:51', '2015-12-11 13:23:53', null);
INSERT INTO user VALUES ('3', 'tianyu', 'tiany', '1e8df4b59b3a3ab452ed1707ad3cb1a8e63a0630', 'bb2aa40007ad1238', '2014-04-02 00:00:00', '0', '', '300', '', '2014-04-02 11:49:13', '0', null, null, null, null, null);
INSERT INTO user VALUES ('5', 'test', 'tyty11', 'dc6d230074477c8d736bfe0205260e9320565aa6', '94886d7223c80850', '2014-12-05 00:00:00', '1', '', '', null, '2014-12-05 11:55:03', '1', 'ss', '1', null, '2014-12-14 00:09:27', null);
INSERT INTO user VALUES ('6', 'superadmin', '超级管理员', 'df894ac0dd60772f22b5d67fe5d8b04fb4c9188d', '97efb48ee6adff63', '2015-01-15 00:00:00', '1', '779205344@qq.com', '13721035120', null, '2015-01-15 15:55:37', null, '超级管理员', null, null, null, null);
INSERT INTO user VALUES ('8', 'u1', 'uuu', 'be27d739373dfb9bada623c7fe8c53dd6d237c7b', '5ca1169ba5ca1bea', '2015-12-09 00:00:00', '1', '', '', null, '2015-12-11 10:21:25', null, '', null, null, null, null);

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `unumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', 'xiaoming111', '4');
INSERT INTO user_info VALUES ('2', 'xiaoming222', '4');

-- ----------------------------
-- Table structure for `user_org`
-- ----------------------------
DROP TABLE IF EXISTS `user_org`;
CREATE TABLE `user_org` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_id` int(9) NOT NULL,
  `org_id` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_org
-- ----------------------------
INSERT INTO user_org VALUES ('9', '1', '2');
INSERT INTO user_org VALUES ('11', '5', '2');
INSERT INTO user_org VALUES ('12', '8', '2');
INSERT INTO user_org VALUES ('15', '6', '1');
INSERT INTO user_org VALUES ('16', '3', '4');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
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

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO user_role VALUES ('1', '1', '1');
INSERT INTO user_role VALUES ('19', '3', '5');
INSERT INTO user_role VALUES ('35', '6', '13');
INSERT INTO user_role VALUES ('36', '6', '1');
INSERT INTO user_role VALUES ('37', '5', '15');
INSERT INTO user_role VALUES ('39', '8', '15');

Source Database       : fawfleet

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-12-16 13:53:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `adver`
-- ----------------------------
DROP TABLE IF EXISTS `adver`;
CREATE TABLE `adver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `IMG` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adver
-- ----------------------------

-- ----------------------------
-- Table structure for `area_info`
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `ID` int(9) NOT NULL AUTO_INCREMENT,
  `AREA_CODE` varchar(12) DEFAULT NULL,
  `AREA_NAME` varchar(50) DEFAULT NULL,
  `PID` int(9) DEFAULT NULL,
  `SORT` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area_info
-- ----------------------------
INSERT INTO area_info VALUES ('1', '100000', '中国', null, '1');

-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------

-- ----------------------------
-- Table structure for `course_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_user_info`;
CREATE TABLE `course_user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
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

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO dict VALUES ('1', '正常', '0', 'user', '用户状态', '1', null, null);
INSERT INTO dict VALUES ('2', '禁用', '1', 'user', '用户状态', '2', null, null);
INSERT INTO dict VALUES ('4', '普通用户', '0', 'user', '用户类型', null, null, null);
INSERT INTO dict VALUES ('5', '会员用户', '1', 'user', '用户类型', null, null, null);

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
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

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO log VALUES ('2259', '/system/user/update', 'admin', '2014-12-04 10:25:40', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '22', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb1234\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2260', '/system/user/update', 'admin', '2014-12-04 10:26:14', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '9', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb12346\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2261', '/system/user/update', 'admin', '2014-12-04 10:37:01', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '7', null, '{\"id\":[\"4\"],\"birthday\":[\"2014-4-2\"],\"phone\":[\"400\"],\"email\":[\"11@11.bee\"],\"name\":[\"bbb123466\"],\"gender\":[\"0\"],\"loginName\":[\"bbb222\"]}');
INSERT INTO log VALUES ('2262', '/system/role/update', 'admin', '2014-12-04 10:48:43', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '215', null, '{\"id\":[\"12\"],\"roleCode\":[\"guest212\"],\"sort\":[\"4\"],\"description\":[\"s\"],\"name\":[\"guest22\"]}');
INSERT INTO log VALUES ('2263', '/system/user/create', 'admin', '2014-12-05 11:55:03', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '305', null, '{\"id\":[\"\"],\"birthday\":[\"2014-12-05\"],\"confirmPassword\":[\"123456\"],\"phone\":[\"\"],\"email\":[\"\"],\"name\":[\"tyty\"],\"plainPassword\":[\"123456\"],\"gender\":[\"1\"],\"loginName\":[\"test\"]}');
INSERT INTO log VALUES ('2264', '/system/permission/create', 'admin', '2014-12-13 11:19:15', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '215', null, '{\"id\":[\"\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}');
INSERT INTO log VALUES ('2265', '/system/permission/update', 'admin', '2014-12-13 11:19:40', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '66', null, '{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheuleJob\"]}');
INSERT INTO log VALUES ('2266', '/system/permission/update', 'admin', '2014-12-13 11:22:17', null, 'Windows 7', 'Firefox 3', '127.0.0.1', null, '186', null, '{\"id\":[\"37\"],\"icon\":[\"icon-hamburg-full-time\"],\"sort\":[\"\"],\"description\":[\"定时任务管理，支持集群\"],\"name\":[\"定时任务管理\"],\"permCode\":[\"\"],\"pid\":[\"15\"],\"type\":[\"F\"],\"url\":[\"system/scheduleJob\"]}');
INSERT INTO log VALUES ('2267', '/system/role/create', 'admin', '2015-12-10 16:51:36', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '290', null, '{\"id\":[\"\"],\"name\":[\"test\"],\"roleCode\":[\"test\"],\"sort\":[\"1\"],\"description\":[\"xxx\"]}');
INSERT INTO log VALUES ('2268', '/system/role/create', 'admin', '2015-12-10 16:56:37', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '154', null, '{\"id\":[\"\"],\"name\":[\"role1\"],\"roleCode\":[\"role1\"],\"sort\":[\"2\"],\"description\":[\"dddd\"]}');
INSERT INTO log VALUES ('2269', '/system/permission/create', 'admin', '2015-12-10 16:58:16', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '299', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"72\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}');
INSERT INTO log VALUES ('2270', '/system/permission/update', 'admin', '2015-12-10 16:58:25', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '86', null, '{\"id\":[\"78\"],\"type\":[\"F\"],\"name\":[\"商品查询\"],\"url\":[\"shop/search\"],\"icon\":[\"icon-hamburg-address\"],\"pid\":[\"71\"],\"sort\":[\"1\"],\"description\":[\"商品查询菜单\"]}');
INSERT INTO log VALUES ('2271', '/system/role/delete/14', 'admin', '2015-12-11 09:14:21', null, 'Windows', 'Chrome', '127.0.0.1', null, '116', null, '{}');
INSERT INTO log VALUES ('2272', '/system/role/create', 'admin', '2015-12-11 09:21:52', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '269', null, '{\"id\":[\"\"],\"name\":[\"test1\"],\"roleCode\":[\"test1\"],\"sort\":[\"1\"],\"description\":[\"ddd\"]}');
INSERT INTO log VALUES ('2273', '/system/role/delete/16', 'admin', '2015-12-11 09:22:11', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '95', null, '{}');
INSERT INTO log VALUES ('2274', '/system/user/create', 'admin', '2015-12-11 10:12:37', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '196', null, '{\"id\":[\"\"],\"loginName\":[\"use1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"use1\"],\"birthday\":[\"2015-12-17\"],\"gender\":[\"1\"],\"email\":[\"332021448@qq.com\"],\"phone\":[\"133222233333\"],\"description\":[\"33333\"]}');
INSERT INTO log VALUES ('2275', '/system/user/delete/7', 'admin', '2015-12-11 10:19:53', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '700', null, '{}');
INSERT INTO log VALUES ('2276', '/system/user/create', 'admin', '2015-12-11 10:21:25', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '83', null, '{\"id\":[\"\"],\"loginName\":[\"u1\"],\"plainPassword\":[\"123456\"],\"confirmPassword\":[\"123456\"],\"name\":[\"幽尼幽尼\"],\"birthday\":[\"2015-12-09\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2277', '/system/user/update', 'admin', '2015-12-11 10:22:28', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '124', null, '{\"id\":[\"8\"],\"loginName\":[\"u1\"],\"name\":[\"uuu\"],\"birthday\":[\"2015-12-9\"],\"gender\":[\"1\"],\"email\":[\"\"],\"phone\":[\"\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2278', '/system/user/update', 'uuu', '2015-12-11 10:23:43', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '137', null, '{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"jjj\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2279', '/system/user/update', 'jjj', '2015-12-11 10:38:43', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '184', null, '{\"id\":[\"1\"],\"loginName\":[\"admin\"],\"name\":[\"admin\"],\"birthday\":[\"2014-3-16\"],\"gender\":[\"1\"],\"email\":[\"779205344@qq.com\"],\"phone\":[\"123456789\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2280', '/system/permission/create', 'admin', '2015-12-11 10:41:03', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '113', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2281', '/system/permission/update', 'admin', '2015-12-11 10:41:16', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '112', null, '{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"menutest/menu1\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"\"]}');
INSERT INTO log VALUES ('2282', '/system/organization/create', 'admin', '2015-12-11 10:42:26', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '107', null, '{\"id\":[\"\"],\"orgName\":[\"11\"],\"pid\":[\"2\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2283', '/system/organization/create', 'admin', '2015-12-11 10:42:46', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '314', null, '{\"id\":[\"\"],\"orgName\":[\"22\"],\"pid\":[\"3\"],\"areaId\":[\"1\"],\"orgCode\":[\"222\"],\"orgType\":[\"222\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2284', '/system/organization/create', 'admin', '2015-12-11 10:43:12', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '120', null, '{\"id\":[\"\"],\"orgName\":[\"国外总部\"],\"pid\":[\"\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2285', '/system/organization/update', 'admin', '2015-12-11 10:43:36', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '248', null, '{\"id\":[\"5\"],\"orgName\":[\"111\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2286', '/system/organization/update', 'admin', '2015-12-11 10:43:45', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '72', null, '{\"id\":[\"5\"],\"orgName\":[\"国外总部\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2287', '/system/organization/create', 'admin', '2015-12-11 10:44:06', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '210', null, '{\"id\":[\"\"],\"orgName\":[\"总部办事处\"],\"pid\":[\"5\"],\"areaId\":[\"1\"],\"orgCode\":[\"111\"],\"orgType\":[\"1\"],\"orgLevel\":[\"1\"],\"orgSort\":[\"1\"]}');
INSERT INTO log VALUES ('2288', '/system/permission/update', 'admin', '2015-12-11 13:23:53', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '262', null, '{\"id\":[\"79\"],\"type\":[\"F\"],\"name\":[\"测试菜单\"],\"url\":[\"\"],\"icon\":[\"icon-hamburg-heart\"],\"pid\":[\"\"],\"sort\":[\"1\"],\"description\":[\"测试菜单一级标题\"]}');
INSERT INTO log VALUES ('2289', '/system/permission/create', 'admin', '2015-12-11 13:24:57', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '106', null, '{\"id\":[\"\"],\"type\":[\"F\"],\"name\":[\"测试表单\"],\"url\":[\"menutest/tabletest\"],\"icon\":[\"icon-hamburg-lightbulb\"],\"pid\":[\"79\"],\"sort\":[\"1\"],\"description\":[\"测试表单菜单\"]}');
INSERT INTO log VALUES ('2290', '/system/permission/delete/79', 'admin', '2015-12-14 11:16:46', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '176', null, '{}');
INSERT INTO log VALUES ('2291', '/system/permission/delete/71', 'admin', '2015-12-14 11:16:51', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '81', null, '{}');
INSERT INTO log VALUES ('2292', '/system/permission/delete/72', 'admin', '2015-12-14 11:16:54', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '82', null, '{}');
INSERT INTO log VALUES ('2293', '/system/permission/delete/73', 'admin', '2015-12-14 11:16:56', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '98', null, '{}');
INSERT INTO log VALUES ('2294', '/system/permission/delete/78', 'admin', '2015-12-14 11:17:00', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '95', null, '{}');
INSERT INTO log VALUES ('2295', '/system/permission/delete/80', 'admin', '2015-12-14 11:17:03', null, 'Windows', 'Firefox 4', '127.0.0.1', null, '116', null, '{}');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
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

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO organization VALUES ('1', '总部', null, '总部', '1', '1', '000000', null);
INSERT INTO organization VALUES ('2', '12313', '1', '13', '31', '131', '131313', '1');
INSERT INTO organization VALUES ('3', '11', '2', '1', '1', '1', '111', '1');
INSERT INTO organization VALUES ('4', '22', '3', '222', '1', '1', '222', '1');
INSERT INTO organization VALUES ('5', '国外总部', '5', '1', '1', '1', '111', '1');
INSERT INTO organization VALUES ('6', '总部办事处', '5', '1', '1', '1', '111', '1');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
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

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission VALUES ('1', null, '系统管理', 'F', '1', '', '', 'icon-standard-cog', '', '');
INSERT INTO permission VALUES ('2', '1', '角色管理', 'F', '3', 'system/role', '', 'icon-hamburg-my-account', 'closed', '');
INSERT INTO permission VALUES ('3', '1', '用户管理', 'F', '2', 'system/user', '', 'icon-hamburg-user', 'closed', '');
INSERT INTO permission VALUES ('4', '2', '添加', 'O', null, '', 'sys:role:add', '', '', '角色添加');
INSERT INTO permission VALUES ('5', '2', '删除', 'O', null, '', 'sys:role:delete', '', '', '角色删除');
INSERT INTO permission VALUES ('6', '2', '修改', 'O', null, '', 'sys:role:update', '', '', '角色修改');
INSERT INTO permission VALUES ('7', '3', '添加', 'O', null, '', 'sys:user:add', '', '', '用户添加');
INSERT INTO permission VALUES ('8', '3', '删除', 'O', null, '', 'sys:user:delete', '', '', '用户删除');
INSERT INTO permission VALUES ('12', '1', '权限管理', 'F', '5', 'system/permission', '', 'icon-hamburg-login', 'closed', '');
INSERT INTO permission VALUES ('14', '15', '数据源监控', 'F', '6', 'druid', '', 'icon-hamburg-database', '', '');
INSERT INTO permission VALUES ('15', null, '系统监控', 'F', '5', '', '', 'icon-hamburg-graphic', '', '');
INSERT INTO permission VALUES ('16', '3', '修改', 'O', null, '', 'sys:user:update', '', '', '用户修改');
INSERT INTO permission VALUES ('20', '15', '日志管理', 'F', '7', 'system/log', '', 'icon-hamburg-archives', '', '');
INSERT INTO permission VALUES ('25', '12', '添加', 'O', null, '', 'sys:perm:add', '', '', '菜单添加');
INSERT INTO permission VALUES ('26', '12', '修改', 'O', null, '', 'sys:perm:update', '', '', '菜单修改');
INSERT INTO permission VALUES ('27', '12', '删除', 'O', null, '', 'sys:perm:delete', '', '', '菜单删除');
INSERT INTO permission VALUES ('28', '2', '查看', 'O', null, '', 'sys:role:view', '', '', '角色查看');
INSERT INTO permission VALUES ('29', '3', '查看', 'O', null, '', 'sys:user:view', '', null, '用户查看');
INSERT INTO permission VALUES ('30', '12', '查看', 'O', null, '', 'sys:perm:view', '', null, '权限查看');
INSERT INTO permission VALUES ('31', '20', '删除', 'O', null, '', 'sys:log:delete', '', null, '删除日志');
INSERT INTO permission VALUES ('32', '20', '导出excel', 'O', null, '', 'sys:log:exportExcel', '', null, '导出日志excel');
INSERT INTO permission VALUES ('33', '3', '查看用户角色', 'O', null, '', 'sys:user:roleView', '', null, '查看用户角色');
INSERT INTO permission VALUES ('34', '2', '保存授权', 'O', null, '', 'sys:role:permUpd', '', null, '保存修改的角色权限');
INSERT INTO permission VALUES ('35', '3', '修改用户角色', 'O', null, '', 'sys:user:roleUpd', '', null, '修改用户拥有的角色');
INSERT INTO permission VALUES ('36', '2', '查看角色权限', 'O', null, '', 'sys:role:permView', '', null, '查看角色拥有的权限');
INSERT INTO permission VALUES ('37', '15', '定时任务管理', 'F', null, 'system/scheduleJob', '', 'icon-hamburg-full-time', null, '定时任务管理，支持集群');
INSERT INTO permission VALUES ('38', '15', 'cron表达式生成', 'F', null, 'system/scheduleJob/quartzCron', '', 'icon-hamburg-future', null, '');
INSERT INTO permission VALUES ('39', '1', '菜单管理', 'F', '4', 'system/permission/menu', '', 'icon-hamburg-old-versions', null, '');
INSERT INTO permission VALUES ('40', '1', '字典管理', 'F', '6', 'system/dict', null, 'icon-hamburg-address', null, '数据字典管理');
INSERT INTO permission VALUES ('45', '39', '修改', 'O', null, '', 'sys:perm:update', null, null, '菜单管理');
INSERT INTO permission VALUES ('58', '39', '添加', 'O', null, '', 'sys:perm:add', null, null, '菜单管理');
INSERT INTO permission VALUES ('59', '39', '删除', 'O', null, '', 'sys:perm:delte', null, null, '菜单管理');
INSERT INTO permission VALUES ('61', '40', '添加', 'O', null, '', 'sys:dict:add', null, null, '字典管理');
INSERT INTO permission VALUES ('62', '40', '删除', 'O', null, '', 'sys:dict:delete', null, null, '字典管理');
INSERT INTO permission VALUES ('63', '40', '修改', 'O', null, '', 'sys:dict:update', null, null, '字典管理');
INSERT INTO permission VALUES ('68', '20', '查看', 'O', null, '', 'sys:log:view', null, null, '查看日志');
INSERT INTO permission VALUES ('69', '40', '查看', 'O', null, '', 'sys:dict:view', null, null, '字典管理');
INSERT INTO permission VALUES ('70', '39', '查看', 'O', null, '', 'sys:perm:menu:view', null, null, '菜单管理');
INSERT INTO permission VALUES ('74', '1', '区域信息', 'F', '7', 'system/area', null, 'icon-hamburg-world', null, '管理行政区划');
INSERT INTO permission VALUES ('75', '1', '机构管理', 'F', '8', 'system/organization', null, 'icon-cologne-home', null, '组织机构管理');
INSERT INTO permission VALUES ('76', '3', '查看用户机构', 'O', null, '', 'sys:user:orgView', null, null, '查看用户机构');
INSERT INTO permission VALUES ('77', '3', '修改用户机构', 'O', null, '', 'sys:user:orgUpd', null, null, '修改用户所在的机构');

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO qrtz_cron_triggers VALUES ('scheduler', 'test1', 'testgroup', '0/5 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO qrtz_job_details VALUES ('scheduler', 'test1', 'testgroup', null, 'com.tianyu.jty.system.service.TaskA', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000B7363686564756C654A6F6273720028636F6D2E7469616E79752E6A74792E73797374656D2E656E746974792E5363686564756C654A6F6200000000000000010200064C0009636C6173734E616D657400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000B6465736372697074696F6E71007E00094C000567726F757071007E00094C00046E616D6571007E00094C000673746174757371007E00097870740023636F6D2E7469616E79752E6A74792E73797374656D2E736572766963652E5461736B4174000D302F35202A202A202A202A203F707400097465737467726F75707400057465737431740001317800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO qrtz_locks VALUES ('scheduler', 'STATE_ACCESS');
INSERT INTO qrtz_locks VALUES ('scheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO qrtz_scheduler_state VALUES ('scheduler', 'DESKTOP-71DS4ST1450236247687', '1450240389221', '15000');

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
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

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO qrtz_triggers VALUES ('scheduler', 'test1', 'testgroup', 'test1', 'testgroup', null, '1421206460000', '1421206455000', '5', 'PAUSED', 'CRON', '1421206412000', '0', null, '0', '');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
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

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', 'admin', 'admin', 'admin', '2', null);
INSERT INTO role VALUES ('5', 'guest', 'guest', 'guest', '3', null);
INSERT INTO role VALUES ('13', 'superadmin', 'superadmin', '超级管理员', '1', null);
INSERT INTO role VALUES ('15', 'role1', 'role1', 'dddd', '2', null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
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

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO role_permission VALUES ('1', '1', '2');
INSERT INTO role_permission VALUES ('2', '1', '1');
INSERT INTO role_permission VALUES ('28', '5', '1');
INSERT INTO role_permission VALUES ('61', '13', '1');
INSERT INTO role_permission VALUES ('62', '13', '3');
INSERT INTO role_permission VALUES ('63', '13', '16');
INSERT INTO role_permission VALUES ('64', '13', '7');
INSERT INTO role_permission VALUES ('65', '13', '2');
INSERT INTO role_permission VALUES ('66', '13', '4');
INSERT INTO role_permission VALUES ('67', '13', '5');
INSERT INTO role_permission VALUES ('68', '13', '6');
INSERT INTO role_permission VALUES ('69', '13', '12');
INSERT INTO role_permission VALUES ('70', '13', '25');
INSERT INTO role_permission VALUES ('71', '13', '26');
INSERT INTO role_permission VALUES ('72', '13', '27');
INSERT INTO role_permission VALUES ('74', '13', '15');
INSERT INTO role_permission VALUES ('75', '13', '14');
INSERT INTO role_permission VALUES ('76', '13', '20');
INSERT INTO role_permission VALUES ('77', '13', '8');
INSERT INTO role_permission VALUES ('81', '1', '3');
INSERT INTO role_permission VALUES ('88', '1', '12');
INSERT INTO role_permission VALUES ('93', '1', '15');
INSERT INTO role_permission VALUES ('94', '1', '14');
INSERT INTO role_permission VALUES ('95', '1', '20');
INSERT INTO role_permission VALUES ('118', '1', '28');
INSERT INTO role_permission VALUES ('120', '1', '30');
INSERT INTO role_permission VALUES ('121', '1', '31');
INSERT INTO role_permission VALUES ('125', '1', '33');
INSERT INTO role_permission VALUES ('126', '1', '36');
INSERT INTO role_permission VALUES ('127', '1', '35');
INSERT INTO role_permission VALUES ('129', '1', '34');
INSERT INTO role_permission VALUES ('130', '1', '32');
INSERT INTO role_permission VALUES ('133', '5', '15');
INSERT INTO role_permission VALUES ('135', '1', '37');
INSERT INTO role_permission VALUES ('142', '1', '38');
INSERT INTO role_permission VALUES ('145', '1', '40');
INSERT INTO role_permission VALUES ('147', '1', '29');
INSERT INTO role_permission VALUES ('151', '1', '61');
INSERT INTO role_permission VALUES ('152', '1', '62');
INSERT INTO role_permission VALUES ('153', '1', '63');
INSERT INTO role_permission VALUES ('162', '5', '39');
INSERT INTO role_permission VALUES ('164', '5', '58');
INSERT INTO role_permission VALUES ('176', '5', '40');
INSERT INTO role_permission VALUES ('177', '1', '39');
INSERT INTO role_permission VALUES ('178', '1', '58');
INSERT INTO role_permission VALUES ('179', '1', '59');
INSERT INTO role_permission VALUES ('183', '1', '4');
INSERT INTO role_permission VALUES ('184', '1', '6');
INSERT INTO role_permission VALUES ('185', '1', '26');
INSERT INTO role_permission VALUES ('186', '1', '27');
INSERT INTO role_permission VALUES ('187', '1', '5');
INSERT INTO role_permission VALUES ('189', '1', '25');
INSERT INTO role_permission VALUES ('190', '1', '45');
INSERT INTO role_permission VALUES ('191', '1', '7');
INSERT INTO role_permission VALUES ('192', '1', '8');
INSERT INTO role_permission VALUES ('193', '1', '16');
INSERT INTO role_permission VALUES ('194', '13', '28');
INSERT INTO role_permission VALUES ('195', '13', '34');
INSERT INTO role_permission VALUES ('196', '13', '36');
INSERT INTO role_permission VALUES ('197', '13', '29');
INSERT INTO role_permission VALUES ('198', '13', '33');
INSERT INTO role_permission VALUES ('199', '13', '35');
INSERT INTO role_permission VALUES ('200', '13', '30');
INSERT INTO role_permission VALUES ('201', '13', '39');
INSERT INTO role_permission VALUES ('202', '13', '45');
INSERT INTO role_permission VALUES ('203', '13', '58');
INSERT INTO role_permission VALUES ('204', '13', '59');
INSERT INTO role_permission VALUES ('205', '13', '40');
INSERT INTO role_permission VALUES ('206', '13', '61');
INSERT INTO role_permission VALUES ('207', '13', '62');
INSERT INTO role_permission VALUES ('208', '13', '63');
INSERT INTO role_permission VALUES ('209', '13', '31');
INSERT INTO role_permission VALUES ('210', '13', '32');
INSERT INTO role_permission VALUES ('211', '13', '37');
INSERT INTO role_permission VALUES ('212', '13', '38');
INSERT INTO role_permission VALUES ('213', '1', '69');
INSERT INTO role_permission VALUES ('215', '5', '69');
INSERT INTO role_permission VALUES ('216', '5', '20');
INSERT INTO role_permission VALUES ('219', '5', '68');
INSERT INTO role_permission VALUES ('220', '5', '38');
INSERT INTO role_permission VALUES ('221', '1', '70');
INSERT INTO role_permission VALUES ('222', '5', '70');
INSERT INTO role_permission VALUES ('223', '5', '3');
INSERT INTO role_permission VALUES ('227', '5', '29');
INSERT INTO role_permission VALUES ('228', '5', '33');
INSERT INTO role_permission VALUES ('229', '5', '35');
INSERT INTO role_permission VALUES ('231', '5', '2');
INSERT INTO role_permission VALUES ('234', '5', '28');
INSERT INTO role_permission VALUES ('235', '5', '45');
INSERT INTO role_permission VALUES ('236', '5', '59');
INSERT INTO role_permission VALUES ('239', '5', '36');
INSERT INTO role_permission VALUES ('240', '1', '68');
INSERT INTO role_permission VALUES ('244', '1', '74');
INSERT INTO role_permission VALUES ('245', '1', '75');
INSERT INTO role_permission VALUES ('246', '1', '76');
INSERT INTO role_permission VALUES ('247', '1', '77');
INSERT INTO role_permission VALUES ('248', '15', '33');
INSERT INTO role_permission VALUES ('249', '15', '3');
INSERT INTO role_permission VALUES ('250', '15', '1');
INSERT INTO role_permission VALUES ('251', '15', '29');
INSERT INTO role_permission VALUES ('252', '15', '40');
INSERT INTO role_permission VALUES ('253', '15', '61');
INSERT INTO role_permission VALUES ('255', '15', '63');
INSERT INTO role_permission VALUES ('256', '15', '69');
INSERT INTO role_permission VALUES ('258', '15', '12');
INSERT INTO role_permission VALUES ('259', '15', '26');
INSERT INTO role_permission VALUES ('261', '15', '16');
INSERT INTO role_permission VALUES ('262', '15', '35');
INSERT INTO role_permission VALUES ('263', '15', '7');
INSERT INTO role_permission VALUES ('264', '15', '76');
INSERT INTO role_permission VALUES ('265', '15', '77');
INSERT INTO role_permission VALUES ('266', '15', '58');
INSERT INTO role_permission VALUES ('267', '15', '39');
INSERT INTO role_permission VALUES ('268', '15', '45');
INSERT INTO role_permission VALUES ('269', '15', '70');
INSERT INTO role_permission VALUES ('270', '15', '25');
INSERT INTO role_permission VALUES ('271', '15', '30');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', 'admin', '159ae5f48f14e89f3f9f54dc995f1f276d472b54', '3d06a5c14d010804', '2014-03-16 00:00:00', '1', '779205344@qq.com', '123456789', 'aaa', '2014-03-20 14:38:57', '0', '', '135', '2015-12-11 10:06:51', '2015-12-11 13:23:53', null);
INSERT INTO user VALUES ('3', 'tianyu', 'tiany', '1e8df4b59b3a3ab452ed1707ad3cb1a8e63a0630', 'bb2aa40007ad1238', '2014-04-02 00:00:00', '0', '', '300', '', '2014-04-02 11:49:13', '0', null, null, null, null, null);
INSERT INTO user VALUES ('5', 'test', 'tyty11', 'dc6d230074477c8d736bfe0205260e9320565aa6', '94886d7223c80850', '2014-12-05 00:00:00', '1', '', '', null, '2014-12-05 11:55:03', '1', 'ss', '1', null, '2014-12-14 00:09:27', null);
INSERT INTO user VALUES ('6', 'superadmin', '超级管理员', 'df894ac0dd60772f22b5d67fe5d8b04fb4c9188d', '97efb48ee6adff63', '2015-01-15 00:00:00', '1', '779205344@qq.com', '13721035120', null, '2015-01-15 15:55:37', null, '超级管理员', null, null, null, null);
INSERT INTO user VALUES ('8', 'u1', 'uuu', 'be27d739373dfb9bada623c7fe8c53dd6d237c7b', '5ca1169ba5ca1bea', '2015-12-09 00:00:00', '1', '', '', null, '2015-12-11 10:21:25', null, '', null, null, null, null);

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `unumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', 'xiaoming111', '4');
INSERT INTO user_info VALUES ('2', 'xiaoming222', '4');

-- ----------------------------
-- Table structure for `user_org`
-- ----------------------------
DROP TABLE IF EXISTS `user_org`;
CREATE TABLE `user_org` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_id` int(9) NOT NULL,
  `org_id` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_org
-- ----------------------------
INSERT INTO user_org VALUES ('9', '1', '2');
INSERT INTO user_org VALUES ('11', '5', '2');
INSERT INTO user_org VALUES ('12', '8', '2');
INSERT INTO user_org VALUES ('15', '6', '1');
INSERT INTO user_org VALUES ('16', '3', '4');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
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

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO user_role VALUES ('1', '1', '1');
INSERT INTO user_role VALUES ('19', '3', '5');
INSERT INTO user_role VALUES ('35', '6', '13');
INSERT INTO user_role VALUES ('36', '6', '1');
INSERT INTO user_role VALUES ('37', '5', '15');
INSERT INTO user_role VALUES ('39', '8', '15');
