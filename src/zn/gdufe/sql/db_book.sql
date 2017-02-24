/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : db_book

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-09 15:49:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'zn', '123456');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `bookTypeId` int(11) DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bbt_idfk_1` (`bookTypeId`),
  CONSTRAINT `bbt_idfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', 'Java编程思想2', 'xx', '男', '20.00', '1', '');
INSERT INTO `t_book` VALUES ('2', '数据结构(第2版)', 'xxx', '男', '10.00', '1', '');
INSERT INTO `t_book` VALUES ('3', '数据库原理', 'xxx', '男', '33.60', '1', '');
INSERT INTO `t_book` VALUES ('4', '建筑学原理', 'xxx', '男', '23.30', '2', '');
INSERT INTO `t_book` VALUES ('5', '搬砖从入门到精通', 'xxx', '男', '20.00', '1', '人生必经之路');
INSERT INTO `t_book` VALUES ('20', '高等数学I', 'xxx', '男', '23.30', '3', '大学一年级必修课');
INSERT INTO `t_book` VALUES ('21', '高等数学II', 'xxx', '男', '33.30', '3', '');
INSERT INTO `t_book` VALUES ('22', '体育健康', 'xxx', '男', '34.30', '8', '');

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES ('1', '计算机类', '计算机相关图书');
INSERT INTO `t_booktype` VALUES ('2', '建筑类', null);
INSERT INTO `t_booktype` VALUES ('3', '数学', '高智商人群系列');
INSERT INTO `t_booktype` VALUES ('4', '音乐类', '歌曲改变人生');
INSERT INTO `t_booktype` VALUES ('5', '经济类', '');
INSERT INTO `t_booktype` VALUES ('6', '管理类', '');
INSERT INTO `t_booktype` VALUES ('8', '体育类', '');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '14251104201', '14251104201');
INSERT INTO `t_student` VALUES ('2', '14251104202', '14251104202');

-- ----------------------------
-- Table structure for t_studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_studentinfo`;
CREATE TABLE `t_studentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `bookNum` int(11) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_studentinfo
-- ----------------------------
INSERT INTO `t_studentinfo` VALUES ('1', '14251104201', '夏目', '0', '软件工程');
INSERT INTO `t_studentinfo` VALUES ('2', '14251104202', '小茗', '0', '软件工程');
