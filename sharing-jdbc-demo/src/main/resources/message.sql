/*
Navicat MySQL Data Transfer

Source Server         : 192.168.75.136_3306
Source Server Version : 50724
Source Host           : 192.168.75.136:3306
Source Database       : message

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-09-28 15:23:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment_user_1
-- ----------------------------
DROP TABLE IF EXISTS `comment_user_1`;
CREATE TABLE `comment_user_1` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '顺序id',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父评论id，0表示顶层,这里不做回复了，所以这个字段用来做点赞数',
  `user_id` int(11) NOT NULL COMMENT '评论者id',
  `notice_id` int(11) NOT NULL COMMENT '消息id',
  `content` text NOT NULL COMMENT '评论内容',
  `comment_time` datetime NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment_user_2
-- ----------------------------
DROP TABLE IF EXISTS `comment_user_2`;
CREATE TABLE `comment_user_2` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '顺序id',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父评论id，0表示顶层,这里不做回复了，所以这个字段用来做点赞数',
  `user_id` int(11) NOT NULL COMMENT '评论者id',
  `notice_id` int(11) NOT NULL COMMENT '消息id',
  `content` text NOT NULL COMMENT '评论内容',
  `comment_time` datetime NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顺序id',
  `admin_id` int(11) NOT NULL COMMENT '发布者id',
  `title` varchar(100) NOT NULL COMMENT '消息标题',
  `content` text NOT NULL COMMENT '消息内容',
  `send_time` datetime NOT NULL COMMENT '发布时间',
  `look_num` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `enclosure_name` varchar(1200) NOT NULL COMMENT '附件名称【附件可以多个，采用逗号进行分隔】',
  `enclosure_addr` varchar(1200) NOT NULL COMMENT '附件地址【附件可以多个，采用逗号进行分隔】',
  `picture_addr` varchar(1200) NOT NULL COMMENT '消息附带的图片地址【多个采用逗号分隔】',
  `heat` int(11) NOT NULL DEFAULT '0' COMMENT '消息热度',
  `notice_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态{0--发布，1--草稿箱}',
  `is_email` tinyint(4) NOT NULL DEFAULT '0',
  `category_id` int(11) DEFAULT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `college_id` int(11) NOT NULL DEFAULT '0',
  `college_name` varchar(255) NOT NULL,
  `content_text` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for online
-- ----------------------------
DROP TABLE IF EXISTS `online`;
CREATE TABLE `online` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顺序id',
  `user_id` int(11) NOT NULL COMMENT '留言用户id',
  `be_online_user_id` int(11) NOT NULL COMMENT '被留言用户id',
  `content` varchar(20000) NOT NULL COMMENT '留言内容',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '留言状态[0--匿名留言，1--实名留言]',
  `online_time` datetime NOT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顺序id',
  `name` varchar(15) NOT NULL COMMENT '登录名',
  `nick_name` varchar(15) NOT NULL COMMENT '昵称，默认是登录名，可以更改',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `come_time` datetime NOT NULL COMMENT '入学时间',
  `college_id` int(11) NOT NULL COMMENT '该学生用户所在的学院',
  `user_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态（1--正常，2--已毕业(非在职)，3--黑名单，4--删除）',
  `user_class` varchar(15) NOT NULL COMMENT '学生班级',
  `email` varchar(50) DEFAULT NULL COMMENT '学生邮箱',
  `phone` varchar(13) DEFAULT NULL COMMENT '学生联系方式',
  `avatar` varchar(100) DEFAULT NULL COMMENT '学生头像',
  `profile` varchar(50) DEFAULT NULL COMMENT '个人座右铭',
  `identify` tinyint(4) NOT NULL DEFAULT '0' COMMENT '身份',
  `is_first_login` tinyint(4) DEFAULT '1' COMMENT '第一次登录，1表示是，0表示登录过了',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
