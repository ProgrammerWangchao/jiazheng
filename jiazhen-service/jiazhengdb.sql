/*
Navicat MySQL Data Transfer

Source Server         : jiazhengUser
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : jiazhengdb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-01-03 12:21:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fuwubook
-- ----------------------------
DROP TABLE IF EXISTS `fuwubook`;
CREATE TABLE `fuwubook` (
  `b_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '预约号',
  `userId` varchar(255) NOT NULL COMMENT '用户ID UUID',
  `p_Id` int(11) NOT NULL COMMENT '预约项目ID',
  `p_title` varchar(255) DEFAULT NULL COMMENT '预约项目名称',
  `b_price` double(10,2) DEFAULT NULL COMMENT '价格',
  `p_icon` varchar(255) DEFAULT NULL COMMENT '图片',
  `b_state` int(255) DEFAULT NULL COMMENT '预约状态 0 预约成功，1 商家已应答',
  `b_date` date DEFAULT NULL COMMENT '预约日期',
  `b_time` time DEFAULT NULL COMMENT '预约时间',
  `mid` varchar(11) DEFAULT NULL,
  `b_name` varchar(255) DEFAULT NULL COMMENT '预约人姓名',
  `b_phone` varchar(255) DEFAULT NULL COMMENT '预约人电话',
  `s_id` varchar(11) DEFAULT NULL COMMENT 'options.id',
  PRIMARY KEY (`b_id`,`userId`,`p_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fuwubook
-- ----------------------------
INSERT INTO `fuwubook` VALUES ('18', '5845635098719', '210', '保姆', '5469.00', '210bm.jpg', '1', '2020-01-04', '09:00:00', '100', '王超', '18892080887', null);
INSERT INTO `fuwubook` VALUES ('20', '5120638327788', '210', '保姆', '5469.00', '210bm.jpg', '1', '2020-01-04', '09:00:00', '100', '王超', '18892080887', null);
INSERT INTO `fuwubook` VALUES ('21', '5845635098719', '11', '公司搬家', '1899.00', '11gsbj.jpg', '1', '2020-01-04', '09:00:00', '100', '王超', '18892080887', null);
INSERT INTO `fuwubook` VALUES ('22', '5845635098719', '630', '干洗/洗衣/修鞋', '189.00', '630gx.jpg', '0', '2020-01-04', '14:19:00', '100', '王超', '18892080887', null);

-- ----------------------------
-- Table structure for fuwudetail
-- ----------------------------
DROP TABLE IF EXISTS `fuwudetail`;
CREATE TABLE `fuwudetail` (
  `fuwuDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `fuwuGroupId` int(11) NOT NULL,
  `fuwuDetailName` varchar(255) DEFAULT NULL,
  `fuwuDetailMiaoshu` text,
  `beizhu` varchar(255) DEFAULT NULL,
  `cratetime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`fuwuDetailId`,`fuwuGroupId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fuwudetail
-- ----------------------------
INSERT INTO `fuwudetail` VALUES ('1', '1', '公司搬家', '公司搬家明细', '公司搬家备注', '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('2', '1', '居民搬家', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('3', '1', '长途搬家', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('4', '1', '小型搬家', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('5', '1', '钢琴搬家', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('6', '1', '设备搬家', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('7', '1', '空调移机', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('8', '1', '起重吊装', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('9', '1', '家具拆装', null, null, '2019-12-31 00:00:00', '2019-12-31 00:00:00');
INSERT INTO `fuwudetail` VALUES ('10', '2', '保姆', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('11', '2', '钟点工', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('12', '2', '月嫂', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('13', '2', '育婴师', null, '育婴师/育儿嫂', null, null);
INSERT INTO `fuwudetail` VALUES ('14', '2', '催乳师', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('15', '2', '陪护', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('16', '2', '管家', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('17', '2', '月子中心', null, null, null, null);
INSERT INTO `fuwudetail` VALUES ('18', '3', '房屋维修', '     防水补漏 卫浴/洁具维修 灯具维修/安装 电路维修/安装 水管/水龙头维修 暖气水管维修/安装 门窗维修/安装 打孔 粉刷/防腐 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('19', '3', '家电维修', '     冰箱 洗衣机 空调 电视 厨房家电 热水器 小家电 影音家电 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('20', '3', '家具维修', '     沙发 桌椅柜 地板 办公家具 钟表 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('21', '3', '开锁', '开锁/换锁/修锁', null, null, null);
INSERT INTO `fuwudetail` VALUES ('22', '4', '电脑维修', '     笔记本电脑 台式电脑 ipad/平板电脑 服务器维修 数据恢复 网络维修 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('23', '4', '手机维修', '     苹果 三星 小米 华为 魅族 中兴 联想 HTC 诺基亚 摩托罗拉 酷派 天语 金立 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('24', '4', '数码维修', '     数码相机 摄像机 单反相机/单反配件 单电/微单相机 游戏机 数码相框 录音设备 导航仪 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('25', '5', '保洁清洗', '     物业保洁 开荒保洁 家庭保洁 空调清洗 冰箱清洗 洗衣机清洗 饮水机清洗 热水器清洗 灯具清洗 油烟机清洗 地毯清洗 地暖清洗 沙发清洗 玻璃清洗 壁纸清洗 除虫除蚁 空气净化 地板打蜡 瓷砖美缝 石材翻新/养护 高空清洗 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('26', '5', '管道疏通', '     马桶疏通 下水道疏通 化粪池清理 隔油池维修/清理 市政管道清淤 管道安装／改造 打捞 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('27', '6', '生活配送', '     液化气/煤气 煤炭 桶装水 蔬菜水果 粮油副食 跑腿服务 机场接送 专人专送 派发传单 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('28', '6', '鲜花绿植', '     鲜花 绿植盆栽 园林/园艺 仿真花 卡通花 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('29', '6', '二手回收', '     手机 电脑 家具 电器 金银 奢侈品 礼品 设备 办公用品 文体用品 金属 库存积压 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('30', '6', '干洗/洗衣/修鞋', '     干洗 改衣 修鞋 皮衣护理 皮鞋护理 皮包护理 箱包改制 家居用品清洗养护 汽车座椅清洗养护 ', null, null, null);
INSERT INTO `fuwudetail` VALUES ('31', '7', '养老院', '养老院', null, null, null);
INSERT INTO `fuwudetail` VALUES ('32', '7', '公共服务', '公共服务', null, null, null);
INSERT INTO `fuwudetail` VALUES ('33', '7', '白事服务', '     殡仪馆/殡葬服务 墓地陵园 殡葬用品 火葬 骨灰盒 寿衣 花圈/鲜花 ', null, null, null);

-- ----------------------------
-- Table structure for fuwugroup
-- ----------------------------
DROP TABLE IF EXISTS `fuwugroup`;
CREATE TABLE `fuwugroup` (
  `fuwuGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `fuwuGroupName` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fuwuGroupId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fuwugroup
-- ----------------------------
INSERT INTO `fuwugroup` VALUES ('1', '搬家', '空调移机|设备迁移');
INSERT INTO `fuwugroup` VALUES ('2', '放心阿姨', '保姆|月嫂|钟点工');
INSERT INTO `fuwugroup` VALUES ('3', '家庭维修', '房屋|家具|家电');
INSERT INTO `fuwugroup` VALUES ('4', '电子维修', '电脑|手机|数码');
INSERT INTO `fuwugroup` VALUES ('5', '清洗/疏通', '保洁|管道疏通');
INSERT INTO `fuwugroup` VALUES ('6', '日常生活', '配送|鲜花|回收');
INSERT INTO `fuwugroup` VALUES ('7', '其他', '其他');

-- ----------------------------
-- Table structure for fuwuproduct
-- ----------------------------
DROP TABLE IF EXISTS `fuwuproduct`;
CREATE TABLE `fuwuproduct` (
  `p_id` int(11) NOT NULL COMMENT '产品id',
  `p_icon` text COMMENT '产品图片url',
  `p_title` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `p_summary` text COMMENT '产品详情',
  `p_priceA` double DEFAULT NULL COMMENT '产品价格-线下价格',
  `p_priceB` double DEFAULT NULL COMMENT ' 产品价格-线上价格',
  `p_duration` double DEFAULT NULL COMMENT '服务时间（分钟）',
  `p_introduce` text COMMENT '项目介绍',
  `p_fit_people` varchar(255) DEFAULT NULL COMMENT '适用人群',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fuwuproduct
-- ----------------------------
INSERT INTO `fuwuproduct` VALUES ('11', '11gsbj.jpg', '公司搬家', '公司搬家明细', '2000', '1899', '300', '随着企业不断的发展进步，人员不断壮大，准备一个更大，更舒适的工作环境当然就必须提上议程了。可是，一想想搬家繁琐的程序，就觉得还能凑合下。然而，老板员工是不会答应的！', '公司，企业');
INSERT INTO `fuwuproduct` VALUES ('12', '12jmbj.jpg', '居民搬家', '居民搬家', '600', '566', '120', '居民搬家', '一般家庭');
INSERT INTO `fuwuproduct` VALUES ('13', '13ctbj.jpg', '长途搬家', '长途搬家', '1500', '1299', '360', '长途搬家', '移居家庭');
INSERT INTO `fuwuproduct` VALUES ('14', '14xxbj.jpg', '小型搬家', '小型搬家', '300', '269', '60', '小型搬家', '白领，学生');
INSERT INTO `fuwuproduct` VALUES ('15', '15gqbj.jpg', '钢琴搬家', '钢琴搬家', '200', '189', '60', '钢琴搬家', '音乐教室，学生');
INSERT INTO `fuwuproduct` VALUES ('16', '16sbbj.jpg', '设备搬家', '设备搬家', '100', '99', '30', '不同设备，价格不同，99元起', '公司，个人');
INSERT INTO `fuwuproduct` VALUES ('17', '17ktyj.jpg', '空调移机', '空调移机', '300', '259', '60', '空调移机', '家庭，企业');
INSERT INTO `fuwuproduct` VALUES ('18', '18qzdz.jpg', '起重吊装', '起重吊装', '500', '489', '60', '一小时500元', '工地');
INSERT INTO `fuwuproduct` VALUES ('19', '19jjcz.jpg', '家具拆装', '家具拆装', '400', '398', '30', '包时包件，价格不一。', '家庭，企业');
INSERT INTO `fuwuproduct` VALUES ('210', '210bm.jpg', '保姆', '保姆', '5500', '5469', '0', '包月', '家庭');
INSERT INTO `fuwuproduct` VALUES ('211', '211zdg.jpg', '钟点工', '钟点工', '30', '29', '60', '一小时30元', '家庭');
INSERT INTO `fuwuproduct` VALUES ('212', '212ys.jpg', '月嫂', '月嫂', '6000', '5899', '0', '包月', '家庭');
INSERT INTO `fuwuproduct` VALUES ('213', '213yys.jpg', '育婴师', '育婴师', '7000', '6899', '0', '包月', '家庭');
INSERT INTO `fuwuproduct` VALUES ('214', '214crs.jpg', '催乳师', '催乳师', '7000', '6899', '0', '包月', '家庭');
INSERT INTO `fuwuproduct` VALUES ('215', '215ph.jpg', '陪护', '陪护', '500', '489', '480', '包天', '病人');
INSERT INTO `fuwuproduct` VALUES ('216', '216gj.jpg', '管家', '管家', '10000', '9899', '0', '包月', '富贵家庭');
INSERT INTO `fuwuproduct` VALUES ('217', '217yzzx.jpg', '月子中心', '月子中心', '12000', '9999', '0', '包月', '孕妇');
INSERT INTO `fuwuproduct` VALUES ('318', '318fwwx.jpg', '房屋维修', '     防水补漏 卫浴/洁具维修 灯具维修/安装 电路维修/安装 水管/水龙头维修 暖气水管维修/安装 门窗维修/安装 打孔 粉刷/防腐 ', '500', '369', '240', '     防水补漏 卫浴/洁具维修 灯具维修/安装 电路维修/安装 水管/水龙头维修 暖气水管维修/安装 门窗维修/安装 打孔 粉刷/防腐 ', null);
INSERT INTO `fuwuproduct` VALUES ('319', '319jdwx.jpg', '家电维修', '     冰箱 洗衣机 空调 电视 厨房家电 热水器 小家电 影音家电 ', '300', '269', '60', '     冰箱 洗衣机 空调 电视 厨房家电 热水器 小家电 影音家电 ', null);
INSERT INTO `fuwuproduct` VALUES ('320', '320jjwx.jpg', '家具维修', '     沙发 桌椅柜 地板 办公家具 钟表 ', '600', '509', '60', '     沙发 桌椅柜 地板 办公家具 钟表 ', null);
INSERT INTO `fuwuproduct` VALUES ('321', '321ks.jpg', '开锁', '开锁/换锁/修锁', '100', '89', '30', '     开锁/换锁/修锁', null);
INSERT INTO `fuwuproduct` VALUES ('422', '422dnwx.jpg', '电脑维修', '     笔记本电脑 台式电脑 ipad/平板电脑 服务器维修 数据恢复 网络维修 ', '200', '189', '30', '     笔记本电脑 台式电脑 ipad/平板电脑 服务器维修 数据恢复 网络维修 ', null);
INSERT INTO `fuwuproduct` VALUES ('423', '423sjwx.jpg', '手机维修', '     苹果 三星 小米 华为 魅族 中兴 联想 HTC 诺基亚 摩托罗拉 酷派 天语 金立 ', '500', '469', '60', '     苹果 三星 小米 华为 魅族 中兴 联想 HTC 诺基亚 摩托罗拉 酷派 天语 金立 ', null);
INSERT INTO `fuwuproduct` VALUES ('424', '424smwx.jpg', '数码维修', '     数码相机 摄像机 单反相机/单反配件 单电/微单相机 游戏机 数码相框 录音设备 导航仪 ', '500', '469', '60', '     数码相机 摄像机 单反相机/单反配件 单电/微单相机 游戏机 数码相框 录音设备 导航仪 ', null);
INSERT INTO `fuwuproduct` VALUES ('525', '525bjqx.jpg', '保洁清洗', '     物业保洁 开荒保洁 家庭保洁 空调清洗 冰箱清洗 洗衣机清洗 饮水机清洗 热水器清洗 灯具清洗 油烟机清洗 地毯清洗 地暖清洗 沙发清洗 玻璃清洗 壁纸清洗 除虫除蚁 空气净化 地板打蜡 瓷砖美缝 石材翻新/养护 高空清洗 ', '600', '579', '60', '     物业保洁 开荒保洁 家庭保洁 空调清洗 冰箱清洗 洗衣机清洗 饮水机清洗 热水器清洗 灯具清洗 油烟机清洗 地毯清洗 地暖清洗 沙发清洗 玻璃清洗 壁纸清洗 除虫除蚁 空气净化 地板打蜡 瓷砖美缝 石材翻新/养护 高空清洗 ', null);
INSERT INTO `fuwuproduct` VALUES ('526', '526gdst.jpg', '管道疏通', '     马桶疏通 下水道疏通 化粪池清理 隔油池维修/清理 市政管道清淤 管道安装／改造 打捞 ', '300', '289', '60', '     马桶疏通 下水道疏通 化粪池清理 隔油池维修/清理 市政管道清淤 管道安装／改造 打捞 ', null);
INSERT INTO `fuwuproduct` VALUES ('627', '627shps.jpg', '生活配送', '     液化气/煤气 煤炭 桶装水 蔬菜水果 粮油副食 跑腿服务 机场接送 专人专送 派发传单 ', '50', '45', '30', '     液化气/煤气 煤炭 桶装水 蔬菜水果 粮油副食 跑腿服务 机场接送 专人专送 派发传单 ', null);
INSERT INTO `fuwuproduct` VALUES ('628', '628xhlz.jpg', '鲜花绿植', '     鲜花 绿植盆栽 园林/园艺 仿真花 卡通花 ', '50', '45', '30', '     鲜花 绿植盆栽 园林/园艺 仿真花 卡通花 ', null);
INSERT INTO `fuwuproduct` VALUES ('629', '629eshs.jpg', '二手回收', '     手机 电脑 家具 电器 金银 奢侈品 礼品 设备 办公用品 文体用品 金属 库存积压 ', '1000', '1200', '0', '     手机 电脑 家具 电器 金银 奢侈品 礼品 设备 办公用品 文体用品 金属 库存积压 ', null);
INSERT INTO `fuwuproduct` VALUES ('630', '630gx.jpg', '干洗/洗衣/修鞋', '     干洗 改衣 修鞋 皮衣护理 皮鞋护理 皮包护理 箱包改制 家居用品清洗养护 汽车座椅清洗养护 ', '200', '189', '30', '     干洗 改衣 修鞋 皮衣护理 皮鞋护理 皮包护理 箱包改制 家居用品清洗养护 汽车座椅清洗养护 ', null);
INSERT INTO `fuwuproduct` VALUES ('731', '731yly.jpg', '养老院', '养老院', '0', '0', '0', '养老院', null);
INSERT INTO `fuwuproduct` VALUES ('732', '732ggfw.jpg', '公共服务', '公共服务', '0', '0', '0', '公共服务', null);
INSERT INTO `fuwuproduct` VALUES ('733', '733bsfw.jpg', '白事服务', '     殡仪馆/殡葬服务 墓地陵园 殡葬用品 火葬 骨灰盒 寿衣 花圈/鲜花 ', '0', '0', '0', '     殡仪馆/殡葬服务 墓地陵园 殡葬用品 火葬 骨灰盒 寿衣 花圈/鲜花 ', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `UserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王超');
INSERT INTO `user` VALUES ('2', 'xhh');

-- ----------------------------
-- View structure for fuwuview
-- ----------------------------
DROP VIEW IF EXISTS `fuwuview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fuwuview` AS select `fuwugroup`.`fuwuGroupName` AS `fuwuGroupName`,`fuwudetail`.`fuwuGroupId` AS `fuwuGroupId`,`fuwudetail`.`fuwuDetailId` AS `fuwuDetailId`,`fuwudetail`.`fuwuDetailName` AS `fuwuDetailName`,`fuwudetail`.`fuwuDetailMiaoshu` AS `fuwuDetailMiaoshu`,`fuwudetail`.`beizhu` AS `beizhu`,`fuwudetail`.`cratetime` AS `cratetime`,`fuwudetail`.`updatetime` AS `updatetime` from (`fuwugroup` join `fuwudetail` on(((`fuwugroup`.`fuwuGroupId` = `fuwudetail`.`fuwuGroupId`) and (`fuwudetail`.`fuwuGroupId` = `fuwugroup`.`fuwuGroupId`)))) ;
DROP TRIGGER IF EXISTS `crate_productid_tt`;
DELIMITER ;;
CREATE TRIGGER `crate_productid_tt` AFTER INSERT ON `fuwudetail` FOR EACH ROW BEGIN
DECLARE s VARCHAR(20) DEFAULT '0000';

SELECT
	concat(
		fuwuGroupId,
		fuwuDetailId
	) INTO s
FROM
	fuwudetail
WHERE
	fuwuDetailId = NEW.fuwuDetailId;

INSERT INTO fuwuproduct(p_id) VALUES(s);

END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `delete_productid_tt`;
DELIMITER ;;
CREATE TRIGGER `delete_productid_tt` AFTER DELETE ON `fuwudetail` FOR EACH ROW BEGIN
	DELETE
FROM
	fuwuproduct
WHERE
	p_id = concat(
		OLD.fuwuGroupId,
		OLD.fuwuDetailId
	);


END
;;
DELIMITER ;
