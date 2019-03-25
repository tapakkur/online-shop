/*
Navicat MySQL Data Transfer

Source Server         : tapakkur
Source Server Version : 80014
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-03-25 11:54:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_item`;
CREATE TABLE `tb_item` (
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`,`productId`),
  KEY `tb_item_ibfk_2` (`productId`),
  CONSTRAINT `tb_item_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `tb_order` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_item_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `tb_product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_item
-- ----------------------------
INSERT INTO `tb_item` VALUES ('1', '1');
INSERT INTO `tb_item` VALUES ('10', '1');
INSERT INTO `tb_item` VALUES ('11', '1');
INSERT INTO `tb_item` VALUES ('1', '2');
INSERT INTO `tb_item` VALUES ('2', '3');
INSERT INTO `tb_item` VALUES ('3', '3');
INSERT INTO `tb_item` VALUES ('12', '3');
INSERT INTO `tb_item` VALUES ('3', '4');
INSERT INTO `tb_item` VALUES ('9', '4');
INSERT INTO `tb_item` VALUES ('10', '4');
INSERT INTO `tb_item` VALUES ('5', '5');
INSERT INTO `tb_item` VALUES ('7', '6');
INSERT INTO `tb_item` VALUES ('8', '6');
INSERT INTO `tb_item` VALUES ('12', '6');
INSERT INTO `tb_item` VALUES ('4', '7');
INSERT INTO `tb_item` VALUES ('5', '7');
INSERT INTO `tb_item` VALUES ('7', '7');
INSERT INTO `tb_item` VALUES ('6', '8');
INSERT INTO `tb_item` VALUES ('7', '8');
INSERT INTO `tb_item` VALUES ('6', '9');
INSERT INTO `tb_item` VALUES ('9', '9');
INSERT INTO `tb_item` VALUES ('8', '10');
INSERT INTO `tb_item` VALUES ('11', '10');
