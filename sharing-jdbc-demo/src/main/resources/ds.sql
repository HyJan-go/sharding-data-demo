/*
Navicat MySQL Data Transfer

Source Server         : seata
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : ds0

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-08-12 17:15:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` long NOT NULL AUTO_INCREMENT,
  `username` varchar(80) NOT NULL,
  `size` int(6) NOT NULL,
  `email` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from ds where id = 13;