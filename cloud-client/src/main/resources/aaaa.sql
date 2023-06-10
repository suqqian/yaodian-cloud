/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : aaaa

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `descripion` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '授权链接',
  `is_blank` int(255) DEFAULT '0' COMMENT '是否跳转 0 不跳转 1跳转',
  `pid` varchar(255) DEFAULT NULL COMMENT '父节点id',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `visible` int(255) DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_permission` VALUES ('0a70dd1e-73cb-4117-ac3f-e4dc0d93d5da', '测试列表', '测试列表', '/tbCeShi/view', 0, '19bd8e79-40de-47bd-99a0-2fa03bfcb09e', '#', 1, NULL, 3, 0);
INSERT INTO `t_sys_permission` VALUES ('1', '首页', '首页', '#', 0, '0', '#', 0, '', 1, 0);
INSERT INTO `t_sys_permission` VALUES ('14', '权限展示', '权限展示', '/PermissionController/view', 0, '411522822607867904', 'system:permission:view', 1, '', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('19bd8e79-40de-47bd-99a0-2fa03bfcb09e', '测试管理', '测试管理', '#', 0, 'c9e64c08-5065-4952-86fe-bea461ef975d', '#', 1, NULL, 3, 0);
INSERT INTO `t_sys_permission` VALUES ('26b4a851-d474-47aa-b5a8-a2df42e49ad1', '新闻管理', '', '/tbNews/view', 0, 'c46f2931-494e-4edc-b080-e2f015a9406b', '12', 1, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('4', '用户管理', '用户展示', '/tSysUser/view', 0, '411522822607867904', 'system:user:view', 1, '', 1, 0);
INSERT INTO `t_sys_permission` VALUES ('411522822607867904', '权限管理', '用户管理', '#', 0, '496782496638173184', '#', 1, '', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('46d40e79-74fa-4929-80a0-424015c42ee1', '新闻管理', '', NULL, 0, '1', NULL, 0, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('496782496638173184', '系统设置', '后台设置', NULL, NULL, '1', NULL, 0, '', 3, 0);
INSERT INTO `t_sys_permission` VALUES ('9', '角色管理', '角色展示', '/RoleController/view', 0, '411522822607867904', 'system:role:view', 1, '', 2, 0);
INSERT INTO `t_sys_permission` VALUES ('c46f2931-494e-4edc-b080-e2f015a9406b', '新闻管理', '', '#', 0, '46d40e79-74fa-4929-80a0-424015c42ee1', '12', 1, '', NULL, 0);
INSERT INTO `t_sys_permission` VALUES ('c9e64c08-5065-4952-86fe-bea461ef975d', '测试管理', '测试管理', NULL, NULL, '1', NULL, 0, NULL, 3, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission_role`;
CREATE TABLE `t_sys_permission_role` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色权限中间表';

-- ----------------------------
-- Records of t_sys_permission_role
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_permission_role` VALUES ('1e87c542-9fc7-485e-bdb5-3d378528f11d', '1', 'c9e64c08-5065-4952-86fe-bea461ef975d');
INSERT INTO `t_sys_permission_role` VALUES ('2965c04d-1d59-4c19-bd0b-dad3ba9daaa9', '1', '14');
INSERT INTO `t_sys_permission_role` VALUES ('4ab9c7d7-704c-4363-a7f6-79bdd9f60626', '1', '1');
INSERT INTO `t_sys_permission_role` VALUES ('5b7cf5a4-9b0a-4a0d-ba01-2b4102480bc5', '1', '46d40e79-74fa-4929-80a0-424015c42ee1');
INSERT INTO `t_sys_permission_role` VALUES ('89b0da3d-638b-43c0-8ae6-606cc7294224', '1', '4');
INSERT INTO `t_sys_permission_role` VALUES ('a0b4540c-c4a7-498e-b1c4-c98f3c57d8d4', '1', '0a70dd1e-73cb-4117-ac3f-e4dc0d93d5da');
INSERT INTO `t_sys_permission_role` VALUES ('a273c5e4-86ab-4be9-864e-b5ea060bfa51', '1', '496782496638173184');
INSERT INTO `t_sys_permission_role` VALUES ('a7bb5ac3-45f0-4914-857b-f79ddcc625fe', '1', '411522822607867904');
INSERT INTO `t_sys_permission_role` VALUES ('c0877b06-0176-41cc-8479-0bd77ca79cf2', '1', '9');
INSERT INTO `t_sys_permission_role` VALUES ('c35f4810-926c-466f-b84d-38bae2c16102', '1', 'c46f2931-494e-4edc-b080-e2f015a9406b');
INSERT INTO `t_sys_permission_role` VALUES ('c451079b-09d7-4a2d-b4cd-b583d1c9ab7b', '1', '26b4a851-d474-47aa-b5a8-a2df42e49ad1');
INSERT INTO `t_sys_permission_role` VALUES ('f26cb402-04b5-4d1d-b997-4550f403ceaa', '1', '19bd8e79-40de-47bd-99a0-2fa03bfcb09e');
COMMIT;

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员');
COMMIT;

-- ----------------------------
-- Table structure for t_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_user`;
CREATE TABLE `t_sys_role_user` (
  `id` varchar(255) NOT NULL,
  `sys_user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `sys_role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色中间表';

-- ----------------------------
-- Records of t_sys_role_user
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_role_user` VALUES ('487529260689526785', '487529260689526784', '1');
INSERT INTO `t_sys_role_user` VALUES ('594342089710370816', '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  `userrelname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户真实姓名',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `rel_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '关联用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '123456', '管理员', '0', NULL);
INSERT INTO `t_sys_user` VALUES ('487529260689526784', 'user1', '123456', '用户1', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_ce_shi
-- ----------------------------
DROP TABLE IF EXISTS `tb_ce_shi`;
CREATE TABLE `tb_ce_shi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ce_shi` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '测试',
  `wen_jian` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件',
  `tu_pian` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `bei_zhu` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `wen_ben` text COLLATE utf8mb4_bin COMMENT '文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='测试';

-- ----------------------------
-- Records of tb_ce_shi
-- ----------------------------
BEGIN;
INSERT INTO `tb_ce_shi` VALUES (1, '1', 'https://study-test-dd.oss-accelerate.aliyuncs.com/5fa727cd-1b4d-4cbf-8715-617f0d347a3711111111jpeg.jpeg', 'https://study-test-dd.oss-accelerate.aliyuncs.com/5fa727cd-1b4d-4cbf-8715-617f0d347a3711111111jpeg.jpeg', '1', NULL);
INSERT INTO `tb_ce_shi` VALUES (2, '', '', '', '', '<p><img src=\"https://study-test-dd.oss-accelerate.aliyuncs.com/5fa727cd-1b4d-4cbf-8715-617f0d347a3711111111jpeg.jpeg\" alt=\"https://study-test-dd.oss-accelerate.aliyuncs.com/5fa727cd-1b4d-4cbf-8715-617f0d347a3711111111jpeg.jpeg\" data-href=\"https%3A%2F%2Fstudy-test-dd.oss-accelerate.aliyuncs.com%2F5fa727cd-1b4d-4cbf-8715-617f0d347a3711111111jpeg.jpeg\" style=\"max-width:100%;\" contenteditable=\"false\"/></p>');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
