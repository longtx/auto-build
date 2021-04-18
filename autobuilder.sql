/*
Navicat MySQL Data Transfer

Source Server         : 14-3307
Source Server Version : 50722
Source Host           : 192.168.10.14:3307
Source Database       : autobuilder

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-02-11 12:48:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jenkins_job
-- ----------------------------
DROP TABLE IF EXISTS `jenkins_job`;
CREATE TABLE `jenkins_job` (
  `id` varchar(255) NOT NULL,
  `jenkins_job_name` varchar(255) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jenkins_job
-- ----------------------------
INSERT INTO `jenkins_job` VALUES ('1', 'wuliao-mamager-frontend', '821', '测试-物料前端npm镜像打包', '{\"namespace\":\"testns\",\"userport\":\"30104\",\"wuliaoport\":\"30106\"}', '1', '3');
INSERT INTO `jenkins_job` VALUES ('2', 'wuliao-backend-maven', '821', '测试-物料maven编译', '', '2', '2');
INSERT INTO `jenkins_job` VALUES ('3', 'wuliao-arch-auth', '821-', '测试-物料鉴权模块', '{\"namespace\":\"testns\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('4', 'wuliao-arch-center', '821', '测试-物料注册中心', '{\"namespace\":\"testns\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('5', 'wuliao-arch-gateway', '821', '测试-物料网关', '{\"namespace\":\"testns\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('6', 'wuliao-authorise-manager', '821-', '测试-物料菜单权限', '{\"namespace\":\"testns\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('7', 'wuliao-common-service', '821', '测试-物料公共服务', '{\"namespace\":\"testns\",\"version\":\"\"}', '7', '1');
INSERT INTO `jenkins_job` VALUES ('8', 'wuliao-material-fundermental', '821', '测试-物料基础资料', '{\"namespace\":\"testns\",\"version\":\"\"}', '8', '1');
INSERT INTO `jenkins_job` VALUES ('9', 'wuliao-material-io', '821', '测试-物料出库入库', '{\"namespace\":\"testns\",\"version\":\"\"}', '9', '1');
INSERT INTO `jenkins_job` VALUES ('10', 'eln-backend-maven', '822', 'ELN-后台代码maven编译', '', '1', '3');
INSERT INTO `jenkins_job` VALUES ('11', 'eln-front-vue', '822', 'ELN-前端代码npm编译', '{\"namespace\":\"testns\",\"image_name\":\"eln-frontend-vue\",\"userport\":\"30104\",\"elnport\":\"31001\",\"version\":\"\"}', '2', '2');
INSERT INTO `jenkins_job` VALUES ('12', 'eln-arch-auth', '822', 'ELN-构建镜像-鉴权', '{\"namespace\":\"testns\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('13', 'eln-arch-center', '822', 'ELN-构建镜像-注册', '{\"namespace\":\"testns\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('14', 'eln-arch-gateway', '822', 'ELN-构建镜像-网关', '{\"namespace\":\"testns\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('15', 'eln-authorise-manager', '822', 'ELN-构建镜像-菜单', '{\"namespace\":\"testns\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('20', 'eln-template', '822', 'ELN-构建镜像-模板', '{\"namespace\":\"testns\",\"version\":\"\"}', '11', '1');
INSERT INTO `jenkins_job` VALUES ('16', 'eln-common-service', '822', 'ELN-构建镜像-公共', '{\"namespace\":\"testns\",\"version\":\"\"}', '7', '1');
INSERT INTO `jenkins_job` VALUES ('17', 'eln-fundermental', '822', 'ELN-构建镜像-基础', '{\"namespace\":\"testns\",\"version\":\"\"}', '8', '1');
INSERT INTO `jenkins_job` VALUES ('19', 'eln-myCheck', '822', 'ELN-构建镜像-待复', '{\"namespace\":\"testns\",\"version\":\"\"}', '10', '1');
INSERT INTO `jenkins_job` VALUES ('18', 'eln-manage', '822', 'ELN-构建镜像-核心', '{\"namespace\":\"testns\",\"version\":\"\"}', '9', '1');
INSERT INTO `jenkins_job` VALUES ('21', '------------------', '------------', '--------------------', '------------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('22', 'exam-admin-backend-maven', '823', '专业职称--后台代码maven编译', ' ', '1', '2');
INSERT INTO `jenkins_job` VALUES ('23', 'exam-arch-auth', '823', '专业职称--权限验证', '{\"namespace\":\"testns\",\"version\":\"\"}', '2', '1');
INSERT INTO `jenkins_job` VALUES ('24', 'exam-arch-center', '823', '专业职称--注册中心', '{\"namespace\":\"testns\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('25', 'exam-arch-gateway', '823', '专业职称--网关', '{\"namespace\":\"testns\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('26', 'exam-certificate-manager', '823', '专业职称--证书管理', '{\"namespace\":\"testns\",\"version\":\"\"}', '8', '1');
INSERT INTO `jenkins_job` VALUES ('27', 'exam-common-service', '823', '专业职称--公共服务', '{\"namespace\":\"testns\",\"version\":\"\"}', '10', '1');
INSERT INTO `jenkins_job` VALUES ('28', 'exam-customer-center', '823', '专业职称--客服中心', '{\"namespace\":\"testns\",\"version\":\"\"}', '12', '1');
INSERT INTO `jenkins_job` VALUES ('29', 'exam-front-management', '823', '专业职称--后台npm编译', '{\"namespace\":\"testns\",\"port\":\"31915\",\"version\":\"\"}', '14', '2');
INSERT INTO `jenkins_job` VALUES ('30', 'exam-manager', '823', '专业职称--考试管理', '{\"namespace\":\"testns\",\"version\":\"\"}', '16', '1');
INSERT INTO `jenkins_job` VALUES ('31', 'exam-person-center-back', '823', '专业职称--个人中心', '{\"namespace\":\"testns\",\"version\":\"\"}', '18', '1');
INSERT INTO `jenkins_job` VALUES ('32', 'exam-person-center-vue', '823', '专业职称--前台npm编译', '{\"namespace\":\"testns\",\"ver\":\"test\",\"port\":\"31359\",\"version\":\"\"}', '20', '2');
INSERT INTO `jenkins_job` VALUES ('33', 'exam-score-inquiry', '823', '专业职称--成绩查询', '{\"namespace\":\"testns\",\"version\":\"\"}', '22', '1');
INSERT INTO `jenkins_job` VALUES ('34', 'exam-sys-manager', '823', '专业职称--系统管理', '{\"namespace\":\"testns\",\"version\":\"\"}', '24', '1');
INSERT INTO `jenkins_job` VALUES ('35', 'exam-task', '823', '专业职称--任务', '{\"namespace\":\"testns\",\"version\":\"\"}', '26', '1');
INSERT INTO `jenkins_job` VALUES ('36', '------------------', '------------', '--------------------', '------------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('37', 'person-center-backend-maven', '824', '企业用户管理--maven编译', ' ', '1', '2');
INSERT INTO `jenkins_job` VALUES ('38', 'person-center-arch-center', '824', '企业用户管理--注册中心', '{\"namespace\":\"testns\",\"version\":\"\"}', '2', '1');
INSERT INTO `jenkins_job` VALUES ('39', 'person-center-auth-architecture', '824', '企业用户管理--JWT授权', '{\"namespace\":\"testns\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('40', 'person-center-gateway', '824', '企业用户管理--网关', '{\"namespace\":\"testns\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('41', 'person-center-http-service', '824', '企业用户管理--HTTP接口调用', '{\"namespace\":\"testns\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('42', 'person-center-manage-platform', '824', '企业用户管理--用户企业', '{\"namespace\":\"testns\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('43', '------------------', '------------', '--------------------', '------------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('44', 'common-backend-maven', '825', '平台公共---maven编译', null, '1', '2');
INSERT INTO `jenkins_job` VALUES ('45', 'html-to-pdf-server', '825', '平台公共---HTML转PDF', '{\"namespace\":\"testns\",\"version\":\"\"}', '2', '1');
INSERT INTO `jenkins_job` VALUES ('46', 'mail-and-pay-server', '825', '平台公共---邮件和支付', '{\"namespace\":\"testns\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('47', 'sms-log-server', '825', '平台公共---短信和日志', '{\"namespace\":\"testns\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('49', '--------------------------------------------------------------------', '--------------------------------------------------------------------', '--------------------------------------------------------------------', '--------------------------------------------------------------------', null, null);
INSERT INTO `jenkins_job` VALUES ('156966244166169', 'exam-admin-backend-maven', '888001', '专业职称--后台代码maven编译', ' ', '1', '2');
INSERT INTO `jenkins_job` VALUES ('156966244181123', 'exam-arch-auth', '888001', '专业职称--权限验证', '{\"namespace\":\"prons\",\"version\":\"\"}', '2', '1');
INSERT INTO `jenkins_job` VALUES ('156966244211689', 'exam-arch-center', '888001', '专业职称--注册中心', '{\"namespace\":\"prons\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('156966244234264', 'exam-arch-gateway', '888001', '专业职称--网关', '{\"namespace\":\"prons\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('156966244257597', 'exam-certificate-manager', '888001', '专业职称--证书管理', '{\"namespace\":\"prons\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('156966244279083', 'exam-common-service', '888001', '专业职称--公共服务', '{\"namespace\":\"prons\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('156966244300565', 'exam-customer-center', '888001', '专业职称--客服中心', '{\"namespace\":\"prons\",\"version\":\"\"}', '7', '1');
INSERT INTO `jenkins_job` VALUES ('156966244318310', 'exam-front-management', '888001', '专业职称--后台npm编译', '{\"namespace\":\"prons\",\"port\":\"31118\",\"version\":\"\"}', '8', '2');
INSERT INTO `jenkins_job` VALUES ('156966244341400', 'exam-manager', '888001', '专业职称--考试管理', '{\"namespace\":\"prons\",\"version\":\"\"}', '9', '1');
INSERT INTO `jenkins_job` VALUES ('156966244366253', 'exam-person-center-back', '888001', '专业职称--个人中心', '{\"namespace\":\"prons\",\"version\":\"\"}', '10', '1');
INSERT INTO `jenkins_job` VALUES ('156966244394646', 'exam-person-center-vue', '888001', '专业职称--前台npm编译', '{\"namespace\":\"prons\",\"ver\":\"prod\",\"port\":\"31365\",\"version\":\"\"}', '11', '2');
INSERT INTO `jenkins_job` VALUES ('156966244519735', 'exam-score-inquiry', '888001', '专业职称--成绩查询', '{\"namespace\":\"prons\",\"version\":\"\"}', '12', '1');
INSERT INTO `jenkins_job` VALUES ('156966244543100', 'exam-sys-manager', '888001', '专业职称--系统管理', '{\"namespace\":\"prons\",\"version\":\"\"}', '13', '1');
INSERT INTO `jenkins_job` VALUES ('156966244557762', 'exam-task', '888001', '专业职称--任务', '{\"namespace\":\"prons\",\"version\":\"\"}', '14', '1');
INSERT INTO `jenkins_job` VALUES ('156966244573376', '---------------------------', '---------------------------', '---------------------------', '---------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('156966244587712', '---------------------------', '---------------------------', '---------------------------', '---------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('123421322241', 'eln-backend-maven', '888002', 'ELN-后台代码maven编译', '', '1', '3');
INSERT INTO `jenkins_job` VALUES ('123421322242', 'eln-front-vue', '888002', 'ELN-构建镜像-前端', '{\"namespace\":\"elnprod\",\"image_name\":\"eln-frontend-vue\",\"userport\":\"32005\",\"elnport\":\"32011\",\"version\":\"\"}', '2', '2');
INSERT INTO `jenkins_job` VALUES ('123421322243', 'eln-arch-auth', '888002', 'ELN-构建镜像-鉴权', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('123421322244', 'eln-arch-center', '888002', 'ELN-构建镜像-注册', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('123421322245', 'eln-arch-gateway', '888002', 'ELN-构建镜像-网关', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('123421322246', 'eln-authorise-manager', '888002', 'ELN-构建镜像-菜单', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('123421322247', 'eln-template', '888002', 'ELN-构建镜像-模板', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '11', '1');
INSERT INTO `jenkins_job` VALUES ('123421322248', 'eln-common-service', '888002', 'ELN-构建镜像-公共', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '7', '1');
INSERT INTO `jenkins_job` VALUES ('123421322249', 'eln-fundermental', '888002', 'ELN-构建镜像-基础', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '8', '1');
INSERT INTO `jenkins_job` VALUES ('1234213222411', 'eln-myCheck', '888002', 'ELN-构建镜像-待复核', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '10', '1');
INSERT INTO `jenkins_job` VALUES ('1234213222412', 'eln-manage', '888002', 'ELN-构建镜像-核心', '{\"namespace\":\"elnprod\",\"version\":\"\"}', '9', '1');
INSERT INTO `jenkins_job` VALUES ('1569662473376', '---------------------------', '---------------------------', '---------------------------', '---------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('1569662445877', '---------------------------', '---------------------------', '---------------------------', '---------------------------', '0', '0');
INSERT INTO `jenkins_job` VALUES ('44111', 'common-backend-maven', '888003', '平台公共---maven编译', '', '1', '2');
INSERT INTO `jenkins_job` VALUES ('45222', 'html-to-pdf-server', '888003', '平台公共---HTML转PDF', '{\"namespace\":\"ggfwgl\",\"version\":\"\"}', '2', '1');
INSERT INTO `jenkins_job` VALUES ('46333', 'mail-and-pay-server', '888003', '平台公共---邮件和支付', '{\"namespace\":\"ggfwgl\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('47444', 'sms-log-server', '888003', '平台公共---短信和日志', '{\"namespace\":\"ggfwgl\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('1111111111111321312', '------------------------------', '------------------------------', '------------------------------', '------------------------------', null, null);
INSERT INTO `jenkins_job` VALUES ('666201', 'wuliao-mamager-frontend', '888004', '生产-物料前端npm镜像打包', '{\"namespace\":\"wlglxt\",\"userport\":\"32005\",\"wuliaoport\":\"32007\"}', '1', '3');
INSERT INTO `jenkins_job` VALUES ('666202', 'wuliao-backend-maven', '888004', '生产-物料maven编译', '', '2', '2');
INSERT INTO `jenkins_job` VALUES ('666203', 'wuliao-arch-auth', '888004', '生产-物料鉴权模块', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '3', '1');
INSERT INTO `jenkins_job` VALUES ('666204', 'wuliao-arch-center', '888004', '生产-物料注册中心', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '4', '1');
INSERT INTO `jenkins_job` VALUES ('666205', 'wuliao-arch-gateway', '888004', '生产-物料网关', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '5', '1');
INSERT INTO `jenkins_job` VALUES ('666206', 'wuliao-authorise-manager', '888004', '生产-物料菜单权限', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '6', '1');
INSERT INTO `jenkins_job` VALUES ('666207', 'wuliao-common-service', '888004', '生产-物料公共服务', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '7', '1');
INSERT INTO `jenkins_job` VALUES ('666208', 'wuliao-material-fundermental', '888004', '生产-物料基础资料', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '8', '1');
INSERT INTO `jenkins_job` VALUES ('666209', 'wuliao-material-io', '888004', '生产-物料出库入库', '{\"namespace\":\"wlglxt\",\"version\":\"\"}', '9', '1');

-- ----------------------------
-- Table structure for mission
-- ----------------------------
DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission` (
  `id` varchar(255) NOT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `modules` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `socket_name` varchar(255) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `strategy` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `zt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mission
-- ----------------------------
INSERT INTO `mission` VALUES ('821', '黄磊', '8', '物料管理系统测试环境', 'test-wuliao', '12', 'auto', '', '0');
INSERT INTO `mission` VALUES ('822', '黄磊', '10', 'ELN测试环境', 'test-eln', '7', 'auto', '', '0');
INSERT INTO `mission` VALUES ('823', '黄磊', '10', '专业职称认证测试环境', 'test-exam', '16', 'auto', '', '0');
INSERT INTO `mission` VALUES ('824', '黄磊', '5', '企业及用户管理测试环境', 'test-user-firm', '5', 'auto', null, '0');
INSERT INTO `mission` VALUES ('825', '黄磊', '3', '系统公共服务测试环境', 'test-common', '3', 'auto', '', '0');
INSERT INTO `mission` VALUES ('888001', '黄磊', '10', '专业职称认证生产环境', 'pro-exam', '16', 'auto', '', '0');
INSERT INTO `mission` VALUES ('888002', '黄磊', '10', 'ELN生产环境', 'pro-eln', '7', 'auto', null, '0');
INSERT INTO `mission` VALUES ('888003', '黄磊', '3', '系统公共服务生产环境', 'pro-system-common', '3', 'auto', '', '0');
INSERT INTO `mission` VALUES ('888004', '黄磊', '8', '物料管理系统生产环境', 'pro-system-material', '12', 'auto', '', '0');
INSERT INTO `mission` VALUES ('156966241304543', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241321195', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241334969', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241350385', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241367239', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241380698', 'string', '0', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `mission` VALUES ('156966241397923', 'string', '0', 'string', 'string', '0', 'string', null, '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `ipAddr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('156576007410107', '土兴宝宝', 'ltx123', '1111111111', 'ltx', 'asdfasfdasfewfxcz423423', '192.168.11.8');
INSERT INTO `user` VALUES ('199011051111', '炜妍宝宝', '123456', 'liangweiyuan', 'liangweiyuan', 'liangweiyuan', '192.168.11.10');
INSERT INTO `user` VALUES ('156576007479621', '运君宝宝', '123456', '123456', 'yangyunjun', 'bxcvbxfesfezzsdzs', '192.168.11.5');
INSERT INTO `user` VALUES ('156576007479622', '黄磊宝宝', 'huanglei', 'huanglei', 'huanglei', 'huanglei', '192.168.11.9');
INSERT INTO `user` VALUES ('13231234234234', '松钊宝宝', 'xiaosongzhao', 'xiaosongzhao', 'xiaosongzhao', 'xiaosongzhao', '192.168.11.21');
INSERT INTO `user` VALUES ('13231234234235', '振凯宝宝', 'chenzhenkai', 'chenzhenkai', 'chenzhenkai', 'chenzhenkai', null);
INSERT INTO `user` VALUES ('13231234234236', '华明宝宝', 'lianhuaming', 'lianhuaming', 'lianhuaming', 'lianhuaming', null);
INSERT INTO `user` VALUES ('13231234234237', '周飞宝宝', 'zhoufei', 'zhoufei', 'zhoufei', 'zhoufei', '192.168.11.26');
INSERT INTO `user` VALUES ('13231234234238', '刘文宝宝', 'liuwen', 'liuwen', 'liuwen', 'liuwen', '192.168.11.6');
INSERT INTO `user` VALUES ('1323123423423s', '常乐宝宝', '123456', 'machangle', 'machangle', 'machangle', null);

-- ----------------------------
-- Table structure for venus_job
-- ----------------------------
DROP TABLE IF EXISTS `venus_job`;
CREATE TABLE `venus_job` (
  `id` varchar(255) NOT NULL,
  `appid` varchar(255) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `venus_job_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of venus_job
-- ----------------------------
INSERT INTO `venus_job` VALUES ('156566937731181', 'd122529f7f1842a185ed04c9d0fa6438', '822', 'ELN-测试环境-更新-注册中心', null, '12', '1', 'eln-arch-center-test');
INSERT INTO `venus_job` VALUES ('156566937739675', 'e680970ba6b4404485517a9fbfa2046f', '822', 'ELN-测试环境-更新-鉴权', null, '13', '1', 'eln-arch-auth-test');
INSERT INTO `venus_job` VALUES ('156566937755441', 'b7f0273adb1b4c78a033439ac25e94ed', '822', 'ELN-测试环境-更新-网关', null, '14', '1', 'eln-arch-gateway-test');
INSERT INTO `venus_job` VALUES ('156566937940598', 'bb0902c4b9814d14b19675036f95e5a7', '822', 'ELN-测试环境-更新-菜单权限', null, '15', '1', 'eln-authorise-manager-test');
INSERT INTO `venus_job` VALUES ('156566937956333', '27855218e89a4244a86f07e6a11aa613', '822', 'ELN-测试环境-更新-基础资料', null, '16', '1', 'eln-fundermental-test');
INSERT INTO `venus_job` VALUES ('156566937970826', '4eae81ba894a4aef838ab23698037b8e', '822', 'ELN-测试环境-更新-公共服务', null, '17', '1', 'eln-common-service-test');
INSERT INTO `venus_job` VALUES ('156566937986032', '7aa7de6dabf04f998a4870d378da2153', '822', 'ELN-测试环境-更新-VUE页面', null, '18', '1', 'eln-frontend-vue-test');
INSERT INTO `venus_job` VALUES ('156566938001481', 'b2c4e62fba8744f2843af512115f64d6', '822', 'ELN-测试环境-更新-核心管理', null, '19', '1', 'eln-manage-test');
INSERT INTO `venus_job` VALUES ('156566938014626', '74931ef58fc24709b7470a5431a33c43', '822', 'ELN-测试环境-更新-待复核', null, '20', '1', 'eln-mycheck-test');
INSERT INTO `venus_job` VALUES ('156566938030864', '5459466683444cdd95e1ecfdc88480a2', '822', 'ELN-测试环境-更新-模板', null, '21', '1', 'eln-template-test');
INSERT INTO `venus_job` VALUES ('156583200273828', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('156583200297884', '011edbfad30c409893eb504a6a7b5b72', '823', '专业职称--注册中心', null, '5', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200324183', '779985a4506a4ce09924fbe5d8a4a5a1', '823', '专业职称--网关', null, '7', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200350931', 'ba2cc140e43e4da6b7a80f7efcfea53b', '823', '专业职称--权限验证', null, '3', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200375724', '8ed6f79c2dd4424ca6b67667a767e86d', '823', '专业职称--证书管理', null, '9', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200401437', '4bec8de5600244819019730f5871cfca', '823', '专业职称--公共服务', null, '11', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200425241', '5102b394d58448eab12b013ebb364b26', '823', '专业职称--客服中心', null, '13', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200453413', 'a35bff2075474f7b888319e9843f6b39', '823', '专业职称--后台页面', null, '15', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200479569', '44d7b3b8a49e42cb956b4d8a4e4edf41', '823', '专业职称--考试管理', null, '17', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200512498', '65b9cd3e8648413abf736c16da4f2953', '823', '专业职称--前台页面', null, '21', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200785874', '1fa2262613bb4ba3991a68ea0f15d889', '823', '专业职称--个人中心', null, '19', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200273333', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('232324234234234', '34348fd12dc4447586943542a453083c', '824', '用户及企业管理---注册中心-测试', '', '7', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200324145', '4ec4e56264c640f7b008c0b2123ed8f8', '824', '用户及企业管理---网关-测试', '', '8', '0', 'string');
INSERT INTO `venus_job` VALUES ('345345345345345', 'c4c8b20d2be04bb9987942dc134f1a9f', '824', '用户及企业管理---HTTP-测试', '', '9', '0', 'string');
INSERT INTO `venus_job` VALUES ('234654678678445', 'c61b53e6b6a9468ba187d672043a2e12', '824', '用户及企业管理---JWT授权-测试', '', '10', '0', 'string');
INSERT INTO `venus_job` VALUES ('345374784635242', 'ca961e74a11844e1a686a1e716ce747b', '824', '用户及企业管理---用户企业管理-测试', '', '11', '0', 'string');
INSERT INTO `venus_job` VALUES ('353456868532423', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('123122211112222', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('156626562240348', 'cdc29706622042a485d85f512965a2ff', '821', '物料管理---注册中心-测试', null, '10', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562256717', '883783ebc2d14dfda2110134640a548e', '821', '物料管理---网关-测试', null, '11', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562279959', '09f69f90333d46a1b37429cc10425785', '821', '物料管理---出库入库-测试', null, '12', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562309745', '23f745d393a84e64a0929caeff38c725', '821', '物料管理---VUE页面-测试', null, '13', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562341195', '2a02261517fa4aca8f46ffc914aba7a6', '821-', '物料管理---菜单权限模块-测试', null, '14', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562366658', '364341c522b34c9dbb7dcddfb063b2ba', '821', '物料管理---基础资料-测试', null, '15', '0', 'string');
INSERT INTO `venus_job` VALUES ('156626562395554', 'a7d08b7e6f2a4507b5448d92926c71dd', '821-', '物料管理---鉴权模块-测试', null, '16', '0', 'string');
INSERT INTO `venus_job` VALUES ('132432423423433', 'b0026e82325a4c07b1e636bef8707acb', '821', '物料管理---公共模块-测试', null, '17', '0', 'string');
INSERT INTO `venus_job` VALUES ('3534568685324231', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('12312221111222223', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('156583200512423', 'ffd48f80bf7e44c4b2aebaa058b25933', '823', '专业职称---系统管理后端', '', '25', '0', 'string');
INSERT INTO `venus_job` VALUES ('156583200785856', 'd7091b11d0e445498a29f4913d4c6655', '823', '专业职称---成绩管理', '', '23', '0', 'string');
INSERT INTO `venus_job` VALUES ('153234342342344', '1cffed30a7a54287b226cfd9ec3cf8c3', '823', '专业职称---任务', ' ', '27', '0', 'string');
INSERT INTO `venus_job` VALUES ('35345686853212312', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('1231222123213213', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('sfsfewrwerfwfwefew', '05a52e27ae8c42f4af54658594d08b33', '825', '平台公共服务---HTML转PDF', null, '5', '1', null);
INSERT INTO `venus_job` VALUES ('wefewfewafefawf', 'aa3fc45ed4d7437db72f1b864e8e4820', '825', '平台公共服务---邮箱和支付服务', null, '6', '1', null);
INSERT INTO `venus_job` VALUES ('awfawfawfawfwefaw', 'd194a04ccce64abaa6691ffb1c1215da', '825', '平台公共服务---日志短信服务-测试', null, '7', '1', null);
INSERT INTO `venus_job` VALUES ('awfawfawfeawfawe', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('156966264934173', '================================', '================================', '================================', '================================', '0', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966264947501', '================================', '================================', '================================', '================================', '0', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966264961645', '25ec51cca0ee418faa13e3ffa2039827', '888001', '专业职称--任务-生产', null, '15', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966264975578', '289d1a08cc12495ab3ff7d76cc6e2f3c', '888001', '专业职称--客服中心服务-生产', null, '16', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966264990919', '37d094a9a9b244e19d8e357fd99f480f', '888001', '专业职称--服务网关-生产', null, '17', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265005678', '39ab865651814186929a26636d14a788', '888001', '专业职称--考试管理服务-生产', null, '18', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265020430', '406a5a55e70b4b2c9bf38ca2028141dc', '888001', '专业职称--认证服务-生产', null, '19', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265034180', '4365712e8b8b41d8b6688b8534ed47ad', '888001', '专业职称--eureka注册中心-生产', null, '20', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265049786', '503b7cf3dd01467b8c916e61c8121444', '888001', '专业职称--系统管理前端-生产', null, '21', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265064114', '52f233c8c880448f8a522fe869e57586', '888001', '专业职称--成绩管理服务-生产', null, '22', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265082919', '57c87bbd2808461ab8a612bfcf1db3c9', '888001', '专业职称--个人中心后台服务-生产', null, '23', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265125317', '6a236228136541fb95033c9efb1dcb2c', '888001', '专业职称--公共服务-生产', null, '24', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265144510', '7ce41a6b95e7493da5b33575d038ceb9', '888001', '专业职称--证书管理服务-生产', null, '25', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966265244608', '8a3853825e8a4d4483db4fd0f0c05e30', '888001', '专业职称--系统管理后端服务-生产', null, '26', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966267179519', 'b4761b1ef527438babc63573aea51c6d', '888001', '专业职称--个人中心前端-生产', null, '27', '0', 'string');
INSERT INTO `venus_job` VALUES ('156966267207126', '------------------------------------------', '------------------------------------------', '------------------------------------------', '------------------------------------------', '0', '0', '--------------');
INSERT INTO `venus_job` VALUES ('156966267234226', '------------------------------------------', '------------------------------------------', '------------------------------------------', '------------------------------------------', '0', '0', '--------------');
INSERT INTO `venus_job` VALUES ('156966267337311', null, null, 'ELN-测试环境-更新-注册中心', '', '12', '1', 'eln-arch-center-test');
INSERT INTO `venus_job` VALUES ('156966267337312', null, null, 'ELN-测试环境-更新-鉴权', '', '13', '1', 'eln-arch-auth-test');
INSERT INTO `venus_job` VALUES ('156966267337313', null, null, 'ELN-测试环境-更新-网关', '', '14', '1', 'eln-arch-gateway-test');
INSERT INTO `venus_job` VALUES ('156966267337314', null, null, 'ELN-测试环境-更新-菜单权限', '', '15', '1', 'eln-authorise-manager-test');
INSERT INTO `venus_job` VALUES ('156966267337315', null, null, 'ELN-测试环境-更新-基础资料', '', '16', '1', 'eln-fundermental-test');
INSERT INTO `venus_job` VALUES ('156966267337316', null, null, 'ELN-测试环境-更新-公共服务', '', '17', '1', 'eln-common-service-test');
INSERT INTO `venus_job` VALUES ('156966267337317', null, null, 'ELN-测试环境-更新-VUE页面', '', '18', '1', 'eln-frontend-vue-test');
INSERT INTO `venus_job` VALUES ('156966267337318', null, null, 'ELN-测试环境-更新-核心管理', '', '19', '1', 'eln-manage-test');
INSERT INTO `venus_job` VALUES ('156966267337319', null, null, 'ELN-测试环境-更新-待复核', '', '20', '1', 'eln-mycheck-test');
INSERT INTO `venus_job` VALUES ('156966267337330', null, null, 'ELN-测试环境-更新-模板', '', '21', '1', 'eln-template-test');
INSERT INTO `venus_job` VALUES ('888004222', '----------------------------------------------------------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '-----------------------------------------------', '0', '0', '-----------------------------------------------');
INSERT INTO `venus_job` VALUES ('888004348', '5c99829d28294e2b90cd9415be255e9c', '888004', '生产-物料---物料公共', '', '10', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004717', '702e981deefe4725a836a0d6c76828cf', '888004', '生产-物料---鉴权', '', '11', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004959', '8889d45c576841248adfb35827191c14', '888004', '生产-物料---菜单权限管理', '', '12', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004745', '8b8b648cf748441c963a341395205247', '888004', '生产-物料---出入库', '', '13', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004195', 'b2e84bc1ab6245d492153fe3bb23d78a', '888004', '生产-物料---注册中心', '', '14', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004658', 'b842ead8d0e1462b95add6b2b88951d4', '888004', '生产-物料---基础资料', '', '15', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004554', 'ede0985ebb0741d7b9cebd05a635d1ee', '888004', '生产-物料---前端页面', '', '16', '0', 'string');
INSERT INTO `venus_job` VALUES ('888004433', 'feb2d6f4ac724007994e3ce755cfe5d1', '888004', '生产-物料---网关', '', '17', '0', 'string');
