/*
Navicat MySQL Data Transfer

Source Server         : tapakkur
Source Server Version : 80014
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-03-25 11:54:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `productId` int(11) NOT NULL,
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('1', 'iphone 8 plus', '4399.99', 'brand：苹果；size：5.5英寸；color：黑色；storage capacity：32G；network：电信4G');
INSERT INTO `tb_product` VALUES ('2', 'iPhone XS', '9199.99', 'brand：苹果；size：5.8英寸；color：金色；storage capacity：64G；network：移动4G');
INSERT INTO `tb_product` VALUES ('3', '华为 Mate20 Pro', '6888.01', 'brand：华为；size：6.4英寸；color：极光色；storage capacity：128G；network：全网通4G');
INSERT INTO `tb_product` VALUES ('4', '华为 P20', '4500', 'brand：华为；size：5.8英寸；color：香槟金；storage capacity：4G+64G；network：联通/电信4G');
INSERT INTO `tb_product` VALUES ('5', '华为 Mate 10', '5000.08', 'brand：华为；size：5.9英寸；color：钻石黑；storage capacity：6G+256G；network：4G全网通');
INSERT INTO `tb_product` VALUES ('6', '三星 Galaxy S10', '11000.99', 'brand：三星；size：6.4英寸；color：陶瓷黑；storage capacity：12G+1TB；network：全网通4G+/移动4G+');
INSERT INTO `tb_product` VALUES ('7', '三星 GALAXY S9+plus', '4999.99', 'brand：三星；size：6.2英寸；color：黑黑；storage capacity：64G；network：3G全网通/4G全网通');
INSERT INTO `tb_product` VALUES ('8', '三星 GALAXY S9+plus', '5168', 'brand：三星；size：6.2英寸；color：黑黑；storage capacity：128G；network：3G全网通/4G全网通');
INSERT INTO `tb_product` VALUES ('9', '小米8', '3487.08', 'brand：小米；size：5.8英寸；color：亮蓝色；storage capacity：64G；network：4G+全网通');
INSERT INTO `tb_product` VALUES ('10', 'OPPO Find X', '4999.01', 'brand：OPPO；size：6.42英寸；color： 波尔多红；storage capacity：8G+256G；network：4G+全网通');
