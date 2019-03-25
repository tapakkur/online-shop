/*
Navicat MySQL Data Transfer

Source Server         : tapakkur
Source Server Version : 80014
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-03-25 11:54:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `orderId` int(11) NOT NULL,
  `orderNumber` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `total` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `tb_order_ibfk_1` (`userId`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '20190325112305NJ7E', '13599.98', '1');
INSERT INTO `tb_order` VALUES ('2', '20190325112345V1sM', '6888.01', '2');
INSERT INTO `tb_order` VALUES ('3', '20190325112402BCl9', '11388.01', '4');
INSERT INTO `tb_order` VALUES ('4', '20190325112414I0vo', '4999.99', '3');
INSERT INTO `tb_order` VALUES ('5', '20190325112436GrlL', '10000.07', '6');
INSERT INTO `tb_order` VALUES ('6', '201903251124548XcJ', '8655.08', '9');
INSERT INTO `tb_order` VALUES ('7', '20190325112509nBjk', '21168.98', '7');
INSERT INTO `tb_order` VALUES ('8', '20190325112529HBQC', '16000', '10');
INSERT INTO `tb_order` VALUES ('9', '20190325112554KXt5', '7987.08', '8');
INSERT INTO `tb_order` VALUES ('10', '20190325112618sX6C', '8899.99', '10');
INSERT INTO `tb_order` VALUES ('11', '20190325112711LRTH', '9399', '5');
INSERT INTO `tb_order` VALUES ('12', '20190325112732WZti', '17889', '5');
