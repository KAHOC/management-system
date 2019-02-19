/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : studb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-23 12:22:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_lesson`
-- ----------------------------
DROP TABLE IF EXISTS `tb_lesson`;
CREATE TABLE `tb_lesson` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `joinTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_lesson
-- ----------------------------
INSERT INTO `tb_lesson` VALUES ('1', '英语（二）', '2007-01-21 06:26:06');
INSERT INTO `tb_lesson` VALUES ('2', '计算机文化基础', '2007-01-22 19:04:05');
INSERT INTO `tb_lesson` VALUES ('3', '计算机专业英语', '2007-01-24 08:12:45');
INSERT INTO `tb_lesson` VALUES ('4', '电子商务', '2007-04-07 10:19:45');
INSERT INTO `tb_lesson` VALUES ('5', '数学', '2007-12-29 14:03:46');

-- ----------------------------
-- Table structure for `tb_manager`
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manName` varchar(30) NOT NULL,
  `pwd` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70');
INSERT INTO `tb_manager` VALUES ('2', 'ning', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO `tb_manager` VALUES ('14', 'mmmm', '333');

-- ----------------------------
-- Table structure for `tb_questions`
-- ----------------------------
DROP TABLE IF EXISTS `tb_questions`;
CREATE TABLE `tb_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `joinTime` datetime NOT NULL,
  `lessonId` int(11) NOT NULL,
  `taoTiId` int(11) NOT NULL,
  `optionA` varchar(255) NOT NULL,
  `optionB` varchar(255) NOT NULL,
  `optionC` varchar(255) NOT NULL,
  `optionD` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonId` (`lessonId`),
  KEY `taoTiId` (`taoTiId`),
  CONSTRAINT `lessonId` FOREIGN KEY (`lessonId`) REFERENCES `tb_lesson` (`id`),
  CONSTRAINT `taoTiId` FOREIGN KEY (`taoTiId`) REFERENCES `tb_taoti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_questions
-- ----------------------------
INSERT INTO `tb_questions` VALUES ('37', 'Windows 2000是什么？', '单选题', '2007-02-25 12:46:40', '2', '10', '应用软件', '操作系统', '应用程序', '以上都不是', 'B', '空');
INSERT INTO `tb_questions` VALUES ('39', '网络营销的发展经历几个阶段？', '单选题', '2007-04-07 10:28:51', '4', '17', '2个', '3个', '5个', '6个', 'C', '无');
INSERT INTO `tb_questions` VALUES ('40', 'Internet提供的基本服务有哪些？', '多选题', '2007-04-07 10:31:48', '4', '17', 'E-mail', 'FTP', 'Telnet', 'WWW', 'A,B,C,D', '无');
INSERT INTO `tb_questions` VALUES ('48', 'EPROM代表什么？', '单选题', '2007-12-24 10:20:03', '3', '19', '可编程存储器', '可擦可编程存储器', '只读存储器', '可擦可编程只读存储器', 'D', '');
INSERT INTO `tb_questions` VALUES ('49', '对于WWW的正确解释有哪些？', '多选题', '2007-12-24 10:36:52', '3', '19', '全球网', '万维网', '局域网', 'World Wide Web的缩写', 'A,B,D', '无');
INSERT INTO `tb_questions` VALUES ('50', '5*5', '单选题', '2007-12-29 14:06:09', '5', '20', '20', '30', '25', '50', 'C', '无');
INSERT INTO `tb_questions` VALUES ('51', '下列数据属于整数的是？', '多选题', '2007-12-29 14:08:14', '5', '20', '1', '2', '3', '4', 'A,B,C,D', '无');

-- ----------------------------
-- Table structure for `tb_student`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `joinTime` datetime NOT NULL,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `proferrsion` varchar(255) NOT NULL,
  `cardNo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '王*晶', '111', '女', '2007-12-13 13:21:11', 'birthday', '717', '广告学', '220198302********');
INSERT INTO `tb_student` VALUES ('2', '无语', '111', '女', '2007-12-01 17:01:08', 'birthday', '1', '计算机应用软件', '220198007********');
INSERT INTO `tb_student` VALUES ('3', '无语*', '111111', '女', '2007-12-25 14:50:49', '我最喜欢的颜色', '蓝灰色', '计算机应用软件', '220104************');
INSERT INTO `tb_student` VALUES ('4', '明明', '000', '女', '2007-12-29 14:09:09', '你好', '你好', '公司管理', '20020');
INSERT INTO `tb_student` VALUES ('5', '丽丽', '111111', '女', '2007-12-29 14:17:37', '你好', '你好', '编程', '52200');

-- ----------------------------
-- Table structure for `tb_sturesult`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sturesult`;
CREATE TABLE `tb_sturesult` (
  `id` int(11) NOT NULL,
  `stuId` varchar(30) NOT NULL,
  `whichLesson` int(11) NOT NULL,
  `resSingle` int(11) NOT NULL,
  `resMore` int(11) NOT NULL,
  `resTotal` int(11) NOT NULL,
  `joinTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `whichLesson` (`whichLesson`),
  CONSTRAINT `whichLesson` FOREIGN KEY (`whichLesson`) REFERENCES `tb_lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sturesult
-- ----------------------------
INSERT INTO `tb_sturesult` VALUES ('1', 'CN20071201000002', '3', '50', '30', '80', '2007-12-17 14:39:41');
INSERT INTO `tb_sturesult` VALUES ('2', 'CN20071201000001', '2', '0', '20', '20', '2007-12-22 12:50:13');
INSERT INTO `tb_sturesult` VALUES ('4', 'CN20071201000001', '4', '20', '30', '50', '2007-12-22 20:58:39');
INSERT INTO `tb_sturesult` VALUES ('12', 'CN20071201000001', '3', '40', '60', '100', '2007-12-24 10:57:51');
INSERT INTO `tb_sturesult` VALUES ('14', 'CN20071225000005', '2', '40', '0', '40', '2007-12-26 16:42:33');
INSERT INTO `tb_sturesult` VALUES ('29', 'CN20071201000002', '2', '40', '60', '100', '2007-12-28 18:54:43');
INSERT INTO `tb_sturesult` VALUES ('30', 'CN20071229000006', '5', '40', '60', '100', '2007-12-29 14:11:34');
INSERT INTO `tb_sturesult` VALUES ('37', 'CN20071229000007', '3', '0', '0', '0', '2007-12-30 09:06:07');
INSERT INTO `tb_sturesult` VALUES ('38', 'CN20071229000007', '5', '40', '60', '100', '2007-12-30 09:07:28');
INSERT INTO `tb_sturesult` VALUES ('39', 'CN20071229000006', '4', '0', '0', '0', '2008-01-11 13:18:56');

-- ----------------------------
-- Table structure for `tb_taoti`
-- ----------------------------
DROP TABLE IF EXISTS `tb_taoti`;
CREATE TABLE `tb_taoti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `lessonId` int(11) NOT NULL,
  `joinTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonId11` (`lessonId`),
  CONSTRAINT `lessonId11` FOREIGN KEY (`lessonId`) REFERENCES `tb_lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_taoti
-- ----------------------------
INSERT INTO `tb_taoti` VALUES ('10', '2007年期末考试', '2', '2007-02-01 14:46:27');
INSERT INTO `tb_taoti` VALUES ('17', '2007年上半年期中考试题', '4', '2007-04-07 10:23:13');
INSERT INTO `tb_taoti` VALUES ('19', '2007年期末考试题A', '3', '2007-12-24 10:17:10');
INSERT INTO `tb_taoti` VALUES ('20', '大学数学', '5', '2007-12-29 14:04:36');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `tid` int(11) NOT NULL,
  `lessonId` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `lessonId` (`lessonId`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`lessonId`) REFERENCES `tb_lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
