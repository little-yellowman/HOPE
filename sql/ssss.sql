/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 47.93.87.136:3307
 Source Schema         : ssss

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/09/2020 10:45:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `number` bigint NOT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (4048115, '12345');

-- ----------------------------
-- Table structure for banjiClass
-- ----------------------------
DROP TABLE IF EXISTS `banjiClass`;
CREATE TABLE `banjiClass`  (
  `class_id` bigint NOT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_amount` int NULL DEFAULT NULL,
  `majorID_class` int NULL DEFAULT NULL COMMENT '外键',
  `monitorID_class` bigint NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `fk_banjiClass_major_1`(`majorID_class`) USING BTREE,
  INDEX `fk_banjiClass_monitor_1`(`monitorID_class`) USING BTREE,
  CONSTRAINT `banjiClass_ibfk_1` FOREIGN KEY (`majorID_class`) REFERENCES `major` (`majorCode`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `banjiClass_ibfk_2` FOREIGN KEY (`monitorID_class`) REFERENCES `monitor` (`mnt_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banjiClass
-- ----------------------------
INSERT INTO `banjiClass` VALUES (201710101, '2017计算机科学与技术班', 60, 10101, 201713453131);
INSERT INTO `banjiClass` VALUES (201710102, '2017软件工程班', 45, 10102, 201713453133);
INSERT INTO `banjiClass` VALUES (201710103, '2017物联网班', 45, 10103, 201713453134);
INSERT INTO `banjiClass` VALUES (201810101, '2018计算机科学与技术班', 60, 10101, 201814566755);
INSERT INTO `banjiClass` VALUES (201810102, '2018软件工程班', 50, 10102, 201834423456);
INSERT INTO `banjiClass` VALUES (201810201, '2018电子信息工程班', 50, 10201, 201845755769);
INSERT INTO `banjiClass` VALUES (201910301, '2019音乐表演班', 20, 10301, 201934253233);

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `college_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college_amount` int NOT NULL,
  PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('数学与计算机科学学院', 500);
INSERT INTO `college` VALUES ('电信学院', 600);
INSERT INTO `college` VALUES ('艺术学院', 300);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `majorCode` int NOT NULL,
  `mjr_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `collegeName_mjr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`majorCode`) USING BTREE,
  INDEX `fk_major_college_1`(`collegeName_mjr`) USING BTREE,
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`collegeName_mjr`) REFERENCES `college` (`college_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (10101, '计算机科学与技术', '数学与计算机科学学院');
INSERT INTO `major` VALUES (10102, '软件工程', '数学与计算机科学学院');
INSERT INTO `major` VALUES (10103, '物联网', '数学与计算机科学学院');
INSERT INTO `major` VALUES (10201, '电子信息工程', '电信学院');
INSERT INTO `major` VALUES (10301, '音乐表演', '艺术学院');

-- ----------------------------
-- Table structure for monitor
-- ----------------------------
DROP TABLE IF EXISTS `monitor`;
CREATE TABLE `monitor`  (
  `mnt_id` bigint NOT NULL,
  `mnt_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mnt_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monitor
-- ----------------------------
INSERT INTO `monitor` VALUES (201713453131, 'yyl');
INSERT INTO `monitor` VALUES (201713453133, '何');
INSERT INTO `monitor` VALUES (201713453134, '查');
INSERT INTO `monitor` VALUES (201814566755, '华盛顿');
INSERT INTO `monitor` VALUES (201834423456, '赫尔');
INSERT INTO `monitor` VALUES (201845755769, '郭晶晶');
INSERT INTO `monitor` VALUES (201889457848, '费尔法');
INSERT INTO `monitor` VALUES (201934253233, '放大发');

-- ----------------------------
-- Table structure for screenshots
-- ----------------------------
DROP TABLE IF EXISTS `screenshots`;
CREATE TABLE `screenshots`  (
  `scrnsht_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `submitted` bit(1) NOT NULL DEFAULT b'0',
  `taskID_scrnsht` bigint NULL DEFAULT NULL COMMENT '外键',
  `studentID_scrnsht` bigint NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`scrnsht_ID`) USING BTREE,
  INDEX `fk_screenshots_student_1`(`studentID_scrnsht`) USING BTREE,
  INDEX `fk_screenshots_ss_task_1`(`taskID_scrnsht`) USING BTREE,
  CONSTRAINT `screenshots_ibfk_1` FOREIGN KEY (`taskID_scrnsht`) REFERENCES `ss_task` (`sst_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `screenshots_ibfk_2` FOREIGN KEY (`studentID_scrnsht`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of screenshots
-- ----------------------------
INSERT INTO `screenshots` VALUES ('2017134531311598844631995', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598841614348\\201713453131袁宇林.png', b'1', 1598841614348, 201713453131);
INSERT INTO `screenshots` VALUES ('2017134531311598872336272', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598872208555\\201713453131袁宇林.png', b'1', 1598872208555, 201713453131);
INSERT INTO `screenshots` VALUES ('2017134531321598949461471', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598872208555\\201713453132肥肥.png', b'1', 1598872208555, 201713453132);
INSERT INTO `screenshots` VALUES ('2017134531321598949497453', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598841614348\\201713453132肥肥.png', b'1', 1598841614348, 201713453132);
INSERT INTO `screenshots` VALUES ('2017134531331598953516659', '数学与计算机科学学院\\软件工程-2017软件工程班\\1598953464070\\201713453133何.png', b'1', 1598953464070, 201713453133);
INSERT INTO `screenshots` VALUES ('2017134531411598950176812', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598872208555\\201713453141肥肥2.png', b'1', 1598872208555, 201713453141);
INSERT INTO `screenshots` VALUES ('2017134531411598950186118', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598841614348\\201713453141肥肥2.png', b'1', 1598841614348, 201713453141);
INSERT INTO `screenshots` VALUES ('2017134531421598950226853', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598872208555\\201713453142肥肥3.png', b'1', 1598872208555, 201713453142);
INSERT INTO `screenshots` VALUES ('2017134531421598950246678', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598841614348\\201713453142肥肥3.png', b'1', 1598841614348, 201713453142);
INSERT INTO `screenshots` VALUES ('2017134531521598950382513', '数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术班\\1598872208555\\201713453152肥肥444.png', b'1', 1598872208555, 201713453152);

-- ----------------------------
-- Table structure for ss_task
-- ----------------------------
DROP TABLE IF EXISTS `ss_task`;
CREATE TABLE `ss_task`  (
  `sst_ID` bigint NOT NULL,
  `info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `submitNum` int NULL DEFAULT NULL COMMENT '提交人数',
  `moniterID_sst` bigint NULL DEFAULT NULL COMMENT '外键',
  `deadline` datetime(6) NULL DEFAULT NULL,
  `precautions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sst_ID`) USING BTREE,
  INDEX `fk_ss_task_monitor_1`(`moniterID_sst`) USING BTREE,
  CONSTRAINT `ss_task_ibfk_1` FOREIGN KEY (`moniterID_sst`) REFERENCES `monitor` (`mnt_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_task
-- ----------------------------
INSERT INTO `ss_task` VALUES (1598841614348, '青年大学习第二期', NULL, 201713453131, '2020-09-02 04:40:05.000000', '更新测试', '');
INSERT INTO `ss_task` VALUES (1598872208555, '青年大学习第一期', NULL, 201713453131, '2020-09-01 11:09:54.000000', '测试fjiw就无法顺利哦手机', '');
INSERT INTO `ss_task` VALUES (1598953464070, '第一期', NULL, 201713453133, '2020-09-03 09:44:15.000000', '飞机送风机沃尔夫就是的肤色的', '');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` bigint NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int NOT NULL,
  `monitorID_stu` bigint NULL DEFAULT NULL COMMENT '外键',
  `collegeName_stu` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键',
  `majorName_stu` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `fk_student_monitor_1`(`monitorID_stu`) USING BTREE,
  INDEX `fk_student_college_1`(`collegeName_stu`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`collegeName_stu`) REFERENCES `college` (`college_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`monitorID_stu`) REFERENCES `monitor` (`mnt_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (201713453131, '袁宇林', '12345', 2017, 201713453131, '数学与计算机科学学院', '计算机科学与技术');
INSERT INTO `student` VALUES (201713453132, '肥肥', '222222', 2017, 201713453131, '数学与计算机科学学院', '计算机科学与技术');
INSERT INTO `student` VALUES (201713453133, '何', '11111', 2017, 201713453133, '数学与计算机科学学院', '软件工程');
INSERT INTO `student` VALUES (201713453134, '查酷酷', '434343', 2017, 201713453134, '数学与计算机科学学院', '物联网');
INSERT INTO `student` VALUES (201713453141, '肥肥2', '222222', 2017, 201713453131, '数学与计算机科学学院', '计算机科学与技术');
INSERT INTO `student` VALUES (201713453142, '肥肥3', '222222', 2017, 201713453131, '数学与计算机科学学院', '计算机科学与技术');
INSERT INTO `student` VALUES (201713453152, '肥肥444', '222222', 2017, 201713453131, '数学与计算机科学学院', '计算机科学与技术');
INSERT INTO `student` VALUES (201814566755, '华盛顿', '33322', 2018, 201814566755, '电信学院', '电子信息工程');
INSERT INTO `student` VALUES (201825345353, '给人的', '343544', 2018, 201814566755, '电信学院', '电子信息工程');
INSERT INTO `student` VALUES (201934253233, '放大发', '97888', 2019, 201934253233, '艺术学院', '音乐表演');
INSERT INTO `student` VALUES (201934345345, '热热我', '54544', 2019, 201934253233, '艺术学院', '音乐表演');

SET FOREIGN_KEY_CHECKS = 1;
