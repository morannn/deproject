/*
 Navicat Premium Data Transfer

 Source Server         : mypetstore
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : kanbanse

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 27/11/2024 17:09:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(0) NULL DEFAULT NULL,
  `mattercontent` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (1, '测试看板数据：使用junit测试看板数据');
INSERT INTO `content` VALUES (2, '开发看板两周数据汇总：新增映射及交互接口');
INSERT INTO `content` VALUES (3, '测试UI稳定：使用LoadRunner等性能测试工具');
INSERT INTO `content` VALUES (4, '测试后端返回数据：控制台输出后端返回数据进行核对');
INSERT INTO `content` VALUES (5, '开发登录界面：与数据库交互判断登录逻辑');
INSERT INTO `content` VALUES (6, '开发注册界面：与数据库交互判断注册逻辑');
INSERT INTO `content` VALUES (7, '测试登录界面：使用junit测试登录模块');
INSERT INTO `content` VALUES (8, '测试注册界面：使用junit测试注册模块');
INSERT INTO `content` VALUES (9, '开发看板界面：开发看板模块的前后端');
INSERT INTO `content` VALUES (10, '前端接口交互更正：前后端接口交互的类型有问题，需要更正');
INSERT INTO `content` VALUES (11, '需求设计');
INSERT INTO `content` VALUES (54, '1');
INSERT INTO `content` VALUES (55, 'test事件');
INSERT INTO `content` VALUES (56, 'test1');
INSERT INTO `content` VALUES (57, 'test');
INSERT INTO `content` VALUES (58, 'test');
INSERT INTO `content` VALUES (59, 'test');
INSERT INTO `content` VALUES (60, 'test1');
INSERT INTO `content` VALUES (61, 'test');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('ceshi', 'ceshi');
INSERT INTO `login` VALUES ('test', 'test');
INSERT INTO `login` VALUES ('kaifa', 'kaifa');
INSERT INTO `login` VALUES ('admin', 'admin');
INSERT INTO `login` VALUES ('xvqiu', 'xvqiu');

-- ----------------------------
-- Table structure for matter
-- ----------------------------
DROP TABLE IF EXISTS `matter`;
CREATE TABLE `matter`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `mattername` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `matterstatus` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `begintime` date NULL DEFAULT NULL,
  `yujitime` date NULL DEFAULT NULL,
  `endtime` date NULL DEFAULT NULL,
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of matter
-- ----------------------------
INSERT INTO `matter` VALUES (1, '测试看板数据', 'ing', '2022-12-29', '2024-11-02', '2024-11-08', 'test', 'ceshi');
INSERT INTO `matter` VALUES (2, '开发看板两周数据汇总', 'nob', '2024-11-21', '2024-11-06', '2024-11-20', 'li', 'kaifa');
INSERT INTO `matter` VALUES (3, '测试UI稳定', 'ing', '2024-10-30', '2024-11-06', '2024-11-13', 'test', 'ceshi');
INSERT INTO `matter` VALUES (4, '测试后端返回数据', 'nob', '2023-01-11', '2024-11-15', '2024-11-21', 'wang', 'ceshi');
INSERT INTO `matter` VALUES (5, '开发登录界面', 'end', '2024-11-21', '2024-11-06', '2024-11-20', 'li', 'kaifa');
INSERT INTO `matter` VALUES (6, '开发注册界面', 'end', '2024-11-18', '2024-11-18', '2024-11-18', 'test', 'kaifa');
INSERT INTO `matter` VALUES (7, '测试登录界面', 'end', '2024-11-18', '2024-11-18', '2024-11-18', 'test', 'ceshi');
INSERT INTO `matter` VALUES (8, '测试注册界面', 'ing', '2024-11-18', '2024-11-18', '2024-11-18', 'test', 'ceshi');
INSERT INTO `matter` VALUES (9, '开发看板界面', 'ing', '2024-11-18', '2024-11-18', '2024-11-18', 'wang', 'kaifa');
INSERT INTO `matter` VALUES (10, '前端接口交互更正', 'ing', '2024-11-18', '2024-11-18', '2024-11-18', 'test', 'kaifa');
INSERT INTO `matter` VALUES (11, '需求设计', 'end', '2024-11-18', '2024-11-18', '2024-11-18', 'xvqiu', 'xvqiu');
INSERT INTO `matter` VALUES (61, 'test', 'ing', '2024-11-26', '2024-11-26', '2024-11-26', 'test', 'ceshi');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('test', 'ceshi', 0);
INSERT INTO `user` VALUES ('kaifa', 'kaifa', 0);
INSERT INTO `user` VALUES ('ceshi', 'ceshi', 0);
INSERT INTO `user` VALUES ('admin', 'admin', 1);
INSERT INTO `user` VALUES ('xvqiu', 'xvqiu', 0);

SET FOREIGN_KEY_CHECKS = 1;
