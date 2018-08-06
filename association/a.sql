/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : a

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-12-29 08:51:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appli`
-- ----------------------------
DROP TABLE IF EXISTS `appli`;
CREATE TABLE `appli` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `a_id` varchar(255) NOT NULL DEFAULT '',
  `part` varchar(255) NOT NULL,
  PRIMARY KEY (`s_id`,`a_id`),
  KEY `a_id` (`a_id`),
  CONSTRAINT `appli_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `appli_ibfk_2` FOREIGN KEY (`a_id`) REFERENCES `shetuan` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appli
-- ----------------------------
INSERT INTO `appli` VALUES ('1435', '3', '秘书部');

-- ----------------------------
-- Table structure for `attend`
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `e_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`s_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `attend_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attend_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `event` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attend
-- ----------------------------
INSERT INTO `attend` VALUES ('1', '10');
INSERT INTO `attend` VALUES ('11', '10');
INSERT INTO `attend` VALUES ('2', '10');
INSERT INTO `attend` VALUES ('3', '10');
INSERT INTO `attend` VALUES ('11', '7');

-- ----------------------------
-- Table structure for `choose`
-- ----------------------------
DROP TABLE IF EXISTS `choose`;
CREATE TABLE `choose` (
  `s_id` varchar(11) NOT NULL,
  `a_id` varchar(11) NOT NULL,
  `job` varchar(255) NOT NULL,
  `part` varchar(255) NOT NULL,
  PRIMARY KEY (`s_id`,`a_id`),
  KEY `a_id` (`a_id`),
  CONSTRAINT `choose_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `choose_ibfk_2` FOREIGN KEY (`a_id`) REFERENCES `shetuan` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choose
-- ----------------------------
INSERT INTO `choose` VALUES ('1435', '5', '团员', '秘书部');

-- ----------------------------
-- Table structure for `event`
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `e_id` varchar(11) NOT NULL DEFAULT '0',
  `e_name` varchar(255) NOT NULL,
  `e_hold_time` varchar(255) NOT NULL,
  `e_hold_place` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `e_state` int(11) NOT NULL,
  `hope` int(11) DEFAULT NULL,
  `jian` varchar(255) NOT NULL,
  `a_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`e_id`),
  KEY `a_id` (`a_id`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`a_id`) REFERENCES `shetuan` (`a_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('1', '活动1', '活动1时间', '活动1地点', '1', '1', '143', '活动1简介', '社团1');
INSERT INTO `event` VALUES ('10', '活动10', '活动10时间', '活动10地点', '1', '1', '183', '活动10简介', '社团4');
INSERT INTO `event` VALUES ('11', '活动11', '活动11时间', '活动11地点', '0', '0', '147', '活动11简介', '社团4');
INSERT INTO `event` VALUES ('12', '活动12', '活动12时间', '活动12地点', '0', '1', '147', '活动12简介', '社团4');
INSERT INTO `event` VALUES ('13', '活动13', '活动13时间', '活动13地点', '1', '1', '168', '活动13简介', '社团5');
INSERT INTO `event` VALUES ('14', '活动14', '活动14时间', '活动14地点', '0', '1', '179', '活动14简介', '社团5');
INSERT INTO `event` VALUES ('15', '活动15', '活动15时间', '活动15地点', '0', '1', '192', '活动15简介', '社团5');
INSERT INTO `event` VALUES ('2', '活动2', '活动2时间', '活动2地点', '0', '0', '147', '社团2简介', '社团1');
INSERT INTO `event` VALUES ('3', '活动3', '活动3时间', '活动3地点', '0', '1', '147', '活动3简介', '社团1');
INSERT INTO `event` VALUES ('4', '活动4', '活动4时间', '活动4地点', '1', '0', '124', '活动4简介', '社团2');
INSERT INTO `event` VALUES ('5', '活动5', '活动5时间', '活动5地点', '0', '1', '124', '活动5简介', '社团2');
INSERT INTO `event` VALUES ('6', '活动6', '活动6时间', '活动6地点', '0', '0', '147', '活动6简介', '社团2');
INSERT INTO `event` VALUES ('7', '活动7', '活动7时间', '活动7地点', '1', '1', '169', '活动7简介', '社团3');
INSERT INTO `event` VALUES ('8', '活动8', '活动8时间', '活动8地点', '0', '0', '168', '活动8简介', '社团3');
INSERT INTO `event` VALUES ('9', '活动9', '活动9时间', '活动9地点', '0', '1', '180', '活动9简介', '社团3');

-- ----------------------------
-- Table structure for `follow`
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `a_id` varchar(255) NOT NULL DEFAULT '',
  `follow_time` datetime DEFAULT NULL,
  PRIMARY KEY (`s_id`,`a_id`),
  KEY `a_id` (`a_id`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`a_id`) REFERENCES `shetuan` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('12', '3', '2017-12-15 16:03:29');
INSERT INTO `follow` VALUES ('12', '5', '2017-12-15 16:02:54');
INSERT INTO `follow` VALUES ('3', '0', '2017-12-25 09:57:26');
INSERT INTO `follow` VALUES ('3', '5', '2017-12-25 09:57:11');

-- ----------------------------
-- Table structure for `hold`
-- ----------------------------
DROP TABLE IF EXISTS `hold`;
CREATE TABLE `hold` (
  `a_id` varchar(11) NOT NULL DEFAULT '0',
  `e_id` varchar(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`a_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `hold_ibfk_1` FOREIGN KEY (`a_id`) REFERENCES `shetuan` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hold_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `event` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hold
-- ----------------------------
INSERT INTO `hold` VALUES ('4', '10');
INSERT INTO `hold` VALUES ('4', '11');
INSERT INTO `hold` VALUES ('4', '12');
INSERT INTO `hold` VALUES ('5', '13');
INSERT INTO `hold` VALUES ('5', '14');
INSERT INTO `hold` VALUES ('5', '15');
INSERT INTO `hold` VALUES ('1', '2');
INSERT INTO `hold` VALUES ('1', '3');
INSERT INTO `hold` VALUES ('2', '4');
INSERT INTO `hold` VALUES ('2', '5');
INSERT INTO `hold` VALUES ('2', '6');
INSERT INTO `hold` VALUES ('3', '7');
INSERT INTO `hold` VALUES ('3', '8');
INSERT INTO `hold` VALUES ('3', '9');

-- ----------------------------
-- Table structure for `shetuan`
-- ----------------------------
DROP TABLE IF EXISTS `shetuan`;
CREATE TABLE `shetuan` (
  `a_id` varchar(11) NOT NULL DEFAULT '0',
  `a_name` varchar(255) DEFAULT NULL,
  `a_charge` varchar(11) NOT NULL,
  `a_head` varchar(255) NOT NULL,
  `a_time` varchar(255) NOT NULL,
  `a_jian` text NOT NULL,
  `a_follow` int(11) DEFAULT NULL,
  `a_new` int(11) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_name` (`a_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shetuan
-- ----------------------------
INSERT INTO `shetuan` VALUES ('0', '社团0', '0', '团长0', 'time0', '简介0', '129', '1');
INSERT INTO `shetuan` VALUES ('1', '社团1', '1', '团长1', 'time1', '简介1', '274', '0');
INSERT INTO `shetuan` VALUES ('2', '社团2', '2', '团长2', 'time2', '简介2', '262', '0');
INSERT INTO `shetuan` VALUES ('3', '社团3', '3', '团长3', 'time3', '简介3', '373', '0');
INSERT INTO `shetuan` VALUES ('4', '社团4', '4', '团长4', 'time4', '简介4', '173', '0');
INSERT INTO `shetuan` VALUES ('5', '社团5', '5', '团长5', 'time5', '简介5', '488', '0');
INSERT INTO `shetuan` VALUES ('6', '社团6', '6', '团长6', 'time6', '简介6', '162', '1');
INSERT INTO `shetuan` VALUES ('8', '社团8', '8', '团长8', 'time8', '简介8', '149', '1');
INSERT INTO `shetuan` VALUES ('9', '社团9', '9', '团长9', 'time9', '简介9', '240', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` varchar(11) NOT NULL DEFAULT '0',
  `s_name` varchar(255) NOT NULL,
  `s_sex` char(255) NOT NULL,
  `s_academy` varchar(255) NOT NULL,
  `s_phone` varchar(255) NOT NULL,
  `s_password` varchar(255) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0', '0000', 'man', '软件工程', '1231', '0');
INSERT INTO `student` VALUES ('1', '1111', 'man', '软件工程', '222222222222', '1');
INSERT INTO `student` VALUES ('10', 'xxx', 'man', '软件工程', '10', '10');
INSERT INTO `student` VALUES ('11', 'xxxx', 'man', '软件工程', '1241235325', '11');
INSERT INTO `student` VALUES ('11111', '1111', 'man', '111', '111', '111');
INSERT INTO `student` VALUES ('12', 'xxxxxxxx', 'man', '软件工程', '222222222222', '12');
INSERT INTO `student` VALUES ('13', 'xxx', 'man', '软件工程', '12312145214', '13');
INSERT INTO `student` VALUES ('1435', 'ibayoo', 'man', '软件学院', '15373607207', '1435');
INSERT INTO `student` VALUES ('2', '2222', 'man', '软件工程', '331212', '2');
INSERT INTO `student` VALUES ('3', '3333', 'man', '软件工程', '12414', '3');
INSERT INTO `student` VALUES ('33332', '213', 'man', '3333', '333', '333');
INSERT INTO `student` VALUES ('4', '4444', 'man', '软件工程', '326478457', '4');
INSERT INTO `student` VALUES ('4444', 'werq', 'man', 'asfd', '123214', 'zzzz');
INSERT INTO `student` VALUES ('5', '5555', 'man', '软件工程', '427457', '5');
INSERT INTO `student` VALUES ('6', '6666', 'man', '软件工程', '45738', '6');
INSERT INTO `student` VALUES ('7', '7777', 'man', '软件工程', '4528685', '7');
INSERT INTO `student` VALUES ('8', '8888', 'man', '软件工程', '654386943', '8');
INSERT INTO `student` VALUES ('9', '9999', 'man', '软件工程', '341764357', '9');
INSERT INTO `student` VALUES ('admin', '管理员', 'man', '软件工程', '1234567', '123');

-- ----------------------------
-- Table structure for `top`
-- ----------------------------
DROP TABLE IF EXISTS `top`;
CREATE TABLE `top` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_title` varbinary(255) DEFAULT NULL,
  `t_text` text,
  `t_time` datetime DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of top
-- ----------------------------

-- ----------------------------
-- Table structure for `zan`
-- ----------------------------
DROP TABLE IF EXISTS `zan`;
CREATE TABLE `zan` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `e_id` varchar(255) NOT NULL DEFAULT '',
  `zan_time` datetime DEFAULT NULL,
  PRIMARY KEY (`s_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `zan_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zan_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `event` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zan
-- ----------------------------
INSERT INTO `zan` VALUES ('1', '10', '2017-12-23 13:20:42');
INSERT INTO `zan` VALUES ('1', '15', '2017-12-28 10:06:32');
INSERT INTO `zan` VALUES ('1', '7', '2017-12-16 19:08:28');
INSERT INTO `zan` VALUES ('1', '9', '2017-12-28 10:06:26');
INSERT INTO `zan` VALUES ('11', '10', '2017-12-24 16:50:22');
INSERT INTO `zan` VALUES ('11', '15', '2017-12-16 08:42:51');
INSERT INTO `zan` VALUES ('12', '14', '2017-12-15 15:58:02');
INSERT INTO `zan` VALUES ('12', '15', '2017-12-15 16:00:43');
INSERT INTO `zan` VALUES ('12', '9', '2017-12-15 16:00:47');
INSERT INTO `zan` VALUES ('1435', '15', '2017-12-24 16:11:26');
INSERT INTO `zan` VALUES ('2', '10', '2017-12-28 16:19:25');
INSERT INTO `zan` VALUES ('2', '14', '2017-12-16 19:07:26');
INSERT INTO `zan` VALUES ('3', '10', '2017-12-21 16:00:01');
INSERT INTO `zan` VALUES ('3', '15', '2017-12-23 15:42:18');
INSERT INTO `zan` VALUES ('3', '9', '2017-12-23 15:42:07');
INSERT INTO `zan` VALUES ('4', '10', '2017-12-16 21:16:57');
INSERT INTO `zan` VALUES ('admin', '10', '2017-12-28 13:14:09');
