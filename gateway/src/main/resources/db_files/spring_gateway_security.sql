/*
Navicat MySQL Data Transfer

Source Server         : 家里服务器21
Source Server Version : 80016
Source Host           : tiancao333.ticp.net:21306
Source Database       : spring_gateway_security

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-07-24 16:15:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `USER_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `USER_PASS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `USER_ROLE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('admin', '123456', 'ADMIN');
INSERT INTO `user_info` VALUES ('user1', '111', 'USER');
INSERT INTO `user_info` VALUES ('user2', '111', 'USER');
INSERT INTO `user_info` VALUES ('user3', '333', 'USER');
