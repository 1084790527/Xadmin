/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : x_admin

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 24/07/2020 20:08:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agency
-- ----------------------------
DROP TABLE IF EXISTS `agency`;
CREATE TABLE `agency`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `mobile_no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '注册日期',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `cre_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员id',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态 2删除 1启用 0停用',
  `city_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of agency
-- ----------------------------
INSERT INTO `agency` VALUES ('1282597741723549696', '顶级服务平台', '1111', '2020-07-13 16:30:47', NULL, '', '1282597893129535488', '2020-07-16 12:46:56', '1', '');
INSERT INTO `agency` VALUES ('1283746283458863104', '测试商户2', '13633333333', '2020-07-16 12:52:19', NULL, '1282597893129535488', '1282597893129535488', '2020-07-16 13:14:36', '1', NULL);
INSERT INTO `agency` VALUES ('1283746416518963200', '测试商户3', '13633333334', '2020-07-16 12:52:51', NULL, '1282597893129535488', '1282597893129535488', '2020-07-16 13:14:35', '1', NULL);

-- ----------------------------
-- Table structure for privileges
-- ----------------------------
DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '父id',
  `menu_level` int(0) NULL DEFAULT 0 COMMENT '菜单层级',
  `permission_type` int(0) NULL DEFAULT 0 COMMENT '1按钮 0页面',
  `permission` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'url请求地址',
  `method_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'url请求方式',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '1启用 0停用',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `cre_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员id',
  `cre_date` datetime(0) NULL DEFAULT NULL COMMENT '添加日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of privileges
-- ----------------------------
INSERT INTO `privileges` VALUES ('1', '平台管理', '平台管理', '', 0, 0, 'sys', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('11', '商户管理', '商户管理', '1', 1, 0, 'sys:merchant', '/merchant/index', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('111', '新增', '新增商户', '11', 2, 0, 'sys:merchant:add', '/merchant/add', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('112', '修改', '修改商户', '11', 2, 0, 'sys:merchant:modify', '/merchant/modify', '', '0', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('113', '重置密码', '重置商户密码', '11', 2, 0, 'sys:merchant:password', '/merchant/password', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('114', '停用', '停用商户', '11', 2, 0, 'sys:merchant:disable', '/merchant/disable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('115', '启用', '启用商户', '11', 2, 0, 'sys:merchant:enable', '/merchant/enable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('116', '删除', '删除商户', '11', 2, 0, 'sys:merchant:delete', '/merchant/delete', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('12', '角色管理', '角色管理', '1', 1, 0, 'sys:role', '/role/index', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('121', '新增', '新增角色', '12', 2, 0, 'sys:role:add', '/role/add', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('122', '修改', '修改角色', '12', 2, 0, 'sys:role:modify', '/role/modify', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('123', '停用', '停用角色', '12', 2, 0, 'sys:role:disable', '/role/disable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('124', '启用', '启用角色', '12', 2, 0, 'sys:role:enable', '/role/enable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('125', '删除', '删除角色', '12', 2, 0, 'sys:role:delete', '/role/delete', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('13', '管理员管理', '管理员管理', '1', 1, 0, 'sys:manager', '/manager/index', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('131', '新增', '新增管理员', '13', 2, 0, 'sys:manager:add', '/manager/add', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('132', '修改', '修改管理员', '13', 2, 0, 'sys:manager:modify', '/manager/modify', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('133', '修改密码', '修改管理员密码', '13', 2, 0, 'sys:manager:password', '/manager/password', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('134', '停用', '停用管理员', '13', 2, 0, 'sys:manager:disable', '/manager/disable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('135', '启用', '启用管理员', '13', 2, 0, 'sys:manager:enable', '/manager/enable', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('136', '删除', '删除管理员', '13', 2, 0, 'sys:manager:delete', '/manager/delete', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('2', '第二个菜单', '第二个菜单', '', 0, 0, 'text', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('21', '测试的菜单1', '测试的菜单1', '2', 1, 0, 'text:one', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('22', '测试的菜单2', '测试的菜单2', '2', 1, 0, 'text:two', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('3', '第三个菜单', '第三个菜单', '', 0, 0, 'text1', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('31', '测试的菜单3', '测试的菜单3', '3', 1, 0, 'text1:one', '', '', '1', NULL, NULL, NULL, NULL);
INSERT INTO `privileges` VALUES ('32', '测试的菜单4', '测试的菜单4', '3', 1, 0, 'text1:two', '', '', '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '1启用 0停用 2删除',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `cre_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员id',
  `cre_date` datetime(0) NULL DEFAULT NULL COMMENT '添加日期',
  `agency_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '超级管理员', '1', NULL, NULL, NULL, NULL, '1282597741723549696');
INSERT INTO `role` VALUES ('1283592707956682752', '测试角色01', '测试角色01测试角色01', '1', '1282597893129535488', '2020-07-16 07:43:33', '1282597893129535488', '2020-07-16 02:42:04', '1282597741723549696');
INSERT INTO `role` VALUES ('1286557989201072128', '测试管理员', '测试管理员测试管理员', '1', '1282597893129535488', '2020-07-24 07:39:29', '1282597893129535488', '2020-07-24 07:05:02', '1282597741723549696');

-- ----------------------------
-- Table structure for role_privileges
-- ----------------------------
DROP TABLE IF EXISTS `role_privileges`;
CREATE TABLE `role_privileges`  (
  `privilege_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限id',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色id',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '1启用 0停用',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `cre_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员id',
  `cre_date` datetime(0) NULL DEFAULT NULL COMMENT '添加日期',
  PRIMARY KEY (`privilege_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_privileges
-- ----------------------------
INSERT INTO `role_privileges` VALUES ('1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('11', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('111', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('112', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('113', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('114', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('115', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('116', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('12', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('121', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('122', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('123', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('124', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('125', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('13', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('131', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('132', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('133', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('134', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('135', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('136', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('2', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('2', '1283592707956682752', '1', '1282597893129535488', '2020-07-16 07:43:33', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('21', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('21', '1283592707956682752', '1', '1282597893129535488', '2020-07-16 07:43:33', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('22', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('3', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('3', '1283592707956682752', '1', '1282597893129535488', '2020-07-16 07:43:33', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('3', '1286557989201072128', '1', '1282597893129535488', '2020-07-24 07:39:29', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('31', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('31', '1283592707956682752', '1', '1282597893129535488', '2020-07-16 07:43:33', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('32', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_privileges` VALUES ('32', '1283592707956682752', '1', '1282597893129535488', '2020-07-16 07:43:33', NULL, NULL);
INSERT INTO `role_privileges` VALUES ('32', '1286557989201072128', '1', '1282597893129535488', '2020-07-24 07:39:29', NULL, NULL);

-- ----------------------------
-- Table structure for sys
-- ----------------------------
DROP TABLE IF EXISTS `sys`;
CREATE TABLE `sys`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `mobile_no` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号 登入账号',
  `real_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `profile_pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '性别 0未知 1男 2女',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '注册日期',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '用户修改日期',
  `last_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录日期',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `last_audit_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后审核操作员id',
  `last_audit_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后审核时间',
  `last_login_ip` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录ip',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '用户状态 2删除 1启用 0停用',
  `agency_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前的所属机构id',
  `defaults` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1 机构默认操作员  0由机构操作员创建的操作员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys
-- ----------------------------
INSERT INTO `sys` VALUES ('1282597893129535488', '系统管理员', '1111', '真实姓名', NULL, '0', 'e10adc3949ba59abbe56e057f20f883e', NULL, '2020-07-13 16:52:17', NULL, '2020-07-24 12:07:12', NULL, NULL, NULL, NULL, '127.0.0.1', '1', '1282597741723549696', '1');
INSERT INTO `sys` VALUES ('1283746283458863105', '昵称', '13633333333', '真实姓名', NULL, '1', '34f85ca80ec353d3052b8a2d3973a0c5', NULL, '2020-07-16 12:52:19', NULL, NULL, '1282597893129535488', '2020-07-17 01:49:05', NULL, NULL, NULL, '1', '1283746283458863104', '1');
INSERT INTO `sys` VALUES ('1283746416518963201', '昵称', '13633333334', '真实姓名', NULL, '2', '34f85ca80ec353d3052b8a2d3973a0c5', NULL, '2020-07-16 12:52:51', NULL, NULL, '1282597893129535488', '2020-07-17 01:49:03', NULL, NULL, NULL, '1', '1283746416518963200', '1');
INSERT INTO `sys` VALUES ('1286567697903378432', '*昵称测试管理员1', '13611111111', '真实姓名', NULL, '2', '96e79218965eb72c92a549dd5a330112', '2020-06-28 16:00:00', '2020-07-24 07:43:37', NULL, NULL, '1282597893129535488', '2020-07-24 08:42:39', NULL, NULL, NULL, '1', '1282597741723549696', '0');
INSERT INTO `sys` VALUES ('1286568900049526784', '测试管理员2', '13611111112', '姓名xx', NULL, '1', '34f85ca80ec353d3052b8a2d3973a0c5', '1969-07-09 16:00:00', '2020-07-24 07:48:24', NULL, NULL, '1282597893129535488', '2020-07-24 08:06:56', NULL, NULL, NULL, '1', '1282597741723549696', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户id',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色id',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '1启用 0停用',
  `last_mod_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改操作员id',
  `last_mod_oper_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改操作员时间',
  `cre_oper_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员id',
  `cre_date` datetime(0) NULL DEFAULT NULL COMMENT '添加日期',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1282597893129535488', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES ('1283746283458863105', '1283592707956682752', '1', NULL, NULL, '1282597893129535488', '2020-07-16 12:52:19');
INSERT INTO `sys_role` VALUES ('1283746416518963201', '1283592707956682752', '1', NULL, NULL, '1282597893129535488', '2020-07-16 12:52:51');
INSERT INTO `sys_role` VALUES ('1286562995841134593', '1286557989201072128', '1', NULL, NULL, '1282597893129535488', '2020-07-24 07:24:56');
INSERT INTO `sys_role` VALUES ('1286567697903378432', '1283592707956682752', '1', '1282597893129535488', '2020-07-24 12:00:05', NULL, NULL);
INSERT INTO `sys_role` VALUES ('1286568900049526784', '1286557989201072128', '1', NULL, NULL, '1282597893129535488', '2020-07-24 07:48:24');

SET FOREIGN_KEY_CHECKS = 1;
