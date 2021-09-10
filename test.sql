/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 10/09/2021 10:06:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, 'one');
INSERT INTO `clazz` VALUES (2, 'two');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `clazz_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `clazz_id`(`clazz_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'jack', '男', 22, 1);
INSERT INTO `student` VALUES (2, 'rose', '女', 18, 1);
INSERT INTO `student` VALUES (3, 'tom', '男', 25, 2);
INSERT INTO `student` VALUES (4, 'mary', '女', 20, 2);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NULL DEFAULT NULL,
  `name` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (2, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (3, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (4, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (5, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (6, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (7, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (8, 'taoeer', '男', 25);
INSERT INTO `users` VALUES (10, 'taoeersss', '男', 25);

SET FOREIGN_KEY_CHECKS = 1;
