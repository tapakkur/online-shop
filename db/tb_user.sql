/*
Navicat MySQL Data Transfer

Source Server         : tapakkur
Source Server Version : 80014
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-03-25 11:55:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `passwd` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'jack', 'horse', '123456', '181406804xa', '湖北·武汉市');
INSERT INTO `tb_user` VALUES ('2', 'tony', 'rabbit', '123456', '181406804xb', '新疆·喀什市');
INSERT INTO `tb_user` VALUES ('3', 'mary', 'rose', '654321', '181406804xc', '广东·广州市');
INSERT INTO `tb_user` VALUES ('4', 'james', 'flyman', '654342', '181406804xd', '上海市·浦东区');
INSERT INTO `tb_user` VALUES ('5', 'tom', 'cat', '234565', '181406804xe', '北京市·朝阳区');
INSERT INTO `tb_user` VALUES ('6', 'tapakkur', 'smart', '123456', '18140680***', '新疆·乌鲁木齐市');
INSERT INTO `tb_user` VALUES ('7', 'Jerry', 'mouse', '123439', '181406804xf', '湖北·武汉市');
INSERT INTO `tb_user` VALUES ('8', 'nick', 'king', '678909', '181406804xg', '浙江·杭州市');
INSERT INTO `tb_user` VALUES ('9', 'rosa', 'princess', '563298', '181406804xh', '浙江·杭州市');
INSERT INTO `tb_user` VALUES ('10', 'abu', 'prince', '234659', '181406804xl', '新疆·阿勒泰');
