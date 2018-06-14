/*
Navicat MySQL Data Transfer

Source Server         : Linking
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : shoppingmall

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-06-14 10:49:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `userId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `content` varchar(800) NOT NULL,
  PRIMARY KEY (`goodsId`,`userId`),
  KEY `fk_comment_userId` (`userId`),
  CONSTRAINT `fk_comment_goodsId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('110010', '1', '&lt;script&gt;$(\"body\").remove();&lt;/script&gt;\n');
INSERT INTO `comment` VALUES ('110010', '2', '<script>alert(\"XSS atack\");</script>');
INSERT INTO `comment` VALUES ('110014', '5', '\n京东送货很快手机很快收到了 这个手机的指纹和人脸识别给我印象很深 手碰下立马打开屏幕 真的特别快 这个是我见过指纹最快的手机了 特别是全面屏还能做到正面指纹人脸识别的速度也是相当的快 一抬手就打开了 还有一个我要重点说 这个手机是可以双卡同时4G的 这个可以让两个卡信号都好 毕竟很多地方2g信号不如4g 对比我的华为p9可以看得到华为这几年的进步还是非常巨大的 体验有了非常明显的提升');
INSERT INTO `comment` VALUES ('110010', '7', '&lt;script&gt;$(\"body\").remove();&lt;/script&gt;\n');
INSERT INTO `comment` VALUES ('110010', '11', '华为,,......很不错');
INSERT INTO `comment` VALUES ('110010', '13', '&lt;script&gt;$(\"body\").remove();&lt;/script&gt;\n');
INSERT INTO `comment` VALUES ('110010', '30', '好用极了，下次买手机依旧买华为！');
INSERT INTO `comment` VALUES ('110014', '30', '用了一周了，当时准备买V9的，可这款手机，真的，太吸引人了，我痛下心买了它，没让我失望，很好，外观真的很很好看，手感就不说了，超级赞的，支持京东自营');
INSERT INTO `comment` VALUES ('110010', '31', '安卓机最爱华为');
INSERT INTO `comment` VALUES ('110014', '31', '\n先去实体店看了下这款手机，红色的确实挺惊艳的！但是店里面128G的比京东要贵点，吓得我掉头就走了，回来在京东上看了看，然后才决定买4+64的，个人感觉够用了，手机到手后手感真的好，也很顺手，完全OK，用段时间再来追评吧。对了，我是男的，用红色贼骚！?');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `batteryCapacity` varchar(20) NOT NULL,
  `frontFacingCamera` varchar(20) NOT NULL,
  `rearCamera` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '华为P20', '3000mAh-3999mAh', '2400万像素', '2000+1200万像素');
INSERT INTO `goods` VALUES ('2', '华为P10', '3000mAh-3999mAh', '800-1599万像素', '1200-1999万像素');
INSERT INTO `goods` VALUES ('3', '华为荣耀10', '3000mAh-3999mAh', '2400万像素', '2400+1600万像素');
INSERT INTO `goods` VALUES ('4', '华为荣耀9', '3000mAh-3999mAh', '800万像素', '2000+1200万像素');
INSERT INTO `goods` VALUES ('5', '华为Mate10', '4000mAh-5999mAh', '800万像素', '2000+1200万像素');
INSERT INTO `goods` VALUES ('6', '华为麦芒6', '3000mAh-3999mAh', '1300+200万像素', '1600+200万像素');
INSERT INTO `goods` VALUES ('7', '华为麦芒5', '3000mAh-3999mAh', '800万像素', '1600万像素');
INSERT INTO `goods` VALUES ('8', '华为nova 3e', '3000mAh-3999mAh', '2400万像素', '1600+200万像素');
INSERT INTO `goods` VALUES ('9', '华为荣耀畅玩7X', '3000mAh-3999mAh', '800万像素', '1600+200万像素');
INSERT INTO `goods` VALUES ('10', '华为Mate RS', '4000mAh-5999mAh', '2400万像素', '2000+4000+800万像素');
INSERT INTO `goods` VALUES ('11', '华为荣耀V10', '3000mAh-3999mAh', '1300万像素', '1600+200万像素');
INSERT INTO `goods` VALUES ('12', '华为荣耀8青春版', '3000mAh-3999mAh', '1300+200万像素', '1300+200万像素');
INSERT INTO `goods` VALUES ('13', '华为P20 Pro', '4000mAh-5999mAh', '2400万像素', '2000+4000+800万像素');
INSERT INTO `goods` VALUES ('27', '荣耀畅玩7C', '3000mAh-3999mAh', '800万-1599万', '1200万-1999万');
INSERT INTO `goods` VALUES ('28', '畅玩7', '3000mAh-3999mAh', '500万-799万', '1200万-1999万');
INSERT INTO `goods` VALUES ('29', '畅玩7A', '3000mAh-3999mAh', '800万', '1300万');
INSERT INTO `goods` VALUES ('30', '畅玩6X', '3000mAh-3999mAh', '800万', '200万像素；1200万像');
INSERT INTO `goods` VALUES ('31', '畅玩5A', '3000mAh-3999mAh', '800万', '200万像素；1200万像');
INSERT INTO `goods` VALUES ('32', '畅玩6A', '3000mAh-3999mAh', '500万-799万', '1200万-1999万');
INSERT INTO `goods` VALUES ('33', '荣耀9i', '3000mAh-3999mAh', '1600万-1999万', '1200万-1999万');

-- ----------------------------
-- Table structure for goodsimg
-- ----------------------------
DROP TABLE IF EXISTS `goodsimg`;
CREATE TABLE `goodsimg` (
  `goodsId` int(11) NOT NULL,
  `color` varchar(25) NOT NULL,
  `imgSrc` varchar(255) NOT NULL,
  PRIMARY KEY (`goodsId`,`color`),
  CONSTRAINT `fk_goodsImg_goodsId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsimg
-- ----------------------------
INSERT INTO `goodsimg` VALUES ('1', '亮黑色', 'img-1/P20/亮黑色.png');
INSERT INTO `goodsimg` VALUES ('1', '宝石蓝', 'img-1/P20/宝石蓝.png');
INSERT INTO `goodsimg` VALUES ('1', '香槟金', 'img-1/P20/香槟金.png');
INSERT INTO `goodsimg` VALUES ('2', '曜石黑', 'img-1/p10/曜石黑.png');
INSERT INTO `goodsimg` VALUES ('2', '钻雕蓝', 'img-1/p10/钻雕蓝.png');
INSERT INTO `goodsimg` VALUES ('3', '幻夜黑', 'img-1/honor_10/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('3', '幻影紫', 'img-1/honor_10/幻影紫.png');
INSERT INTO `goodsimg` VALUES ('3', '海鸥灰', 'img-1/honor_10/海鸥灰.png');
INSERT INTO `goodsimg` VALUES ('4', '海鸥灰', 'img-1/honor_9/海鸥灰.png');
INSERT INTO `goodsimg` VALUES ('4', '珠光白', 'img-1/honor_9/珠光白.png');
INSERT INTO `goodsimg` VALUES ('4', '魅海蓝', 'img-1/honor_9/魅海蓝.png');
INSERT INTO `goodsimg` VALUES ('5', '亮黑色', 'img-1/Mate_10/亮黑色.png');
INSERT INTO `goodsimg` VALUES ('5', '摩卡金', 'img-1/Mate_10/摩卡金.png');
INSERT INTO `goodsimg` VALUES ('5', '香槟金', 'img-1/Mate_10/香槟金.png');
INSERT INTO `goodsimg` VALUES ('6', '曜石黑', 'img-1/麦芒6/曜石黑.png');
INSERT INTO `goodsimg` VALUES ('6', '极光蓝', 'img-1/麦芒6/极光蓝.png');
INSERT INTO `goodsimg` VALUES ('6', '流光金', 'img-1/麦芒6/流光金.png');
INSERT INTO `goodsimg` VALUES ('7', '香槟金', 'img-1/麦芒5/香槟金.png');
INSERT INTO `goodsimg` VALUES ('8', '克莱因蓝', 'img-1/nova_3e/克莱因蓝.png');
INSERT INTO `goodsimg` VALUES ('8', '幻夜黑', 'img-1/nova_3e/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('8', '铂光金', 'img-1/nova_3e/铂光金.png');
INSERT INTO `goodsimg` VALUES ('9', '幻夜黑', 'img-1/畅玩_7X/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('10', '玄黑色', 'img-1/Mate_RS/玄黑色.png');
INSERT INTO `goodsimg` VALUES ('11', '幻夜黑', 'img-1/v10/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('11', '极光蓝', 'img-1/v10/极光蓝.png');
INSERT INTO `goodsimg` VALUES ('11', '沙滩金', 'img-1/v10/沙滩金.png');
INSERT INTO `goodsimg` VALUES ('12', '幻夜黑', 'img-1/荣耀8青春版/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('12', '流光金', 'img-1/荣耀8青春版/流光金.png');
INSERT INTO `goodsimg` VALUES ('12', '蓝色', 'img-1/荣耀8青春版/蓝色.png');
INSERT INTO `goodsimg` VALUES ('13', '亮黑色', 'img-1/P20_Pro/亮黑色.png');
INSERT INTO `goodsimg` VALUES ('13', '宝石蓝', 'img-1/P20_Pro/宝石蓝.png');
INSERT INTO `goodsimg` VALUES ('13', '极光色', 'img-1/P20_Pro/极光色.png');
INSERT INTO `goodsimg` VALUES ('27', '极光蓝', 'img-1/荣耀畅玩7C/极光蓝.png');
INSERT INTO `goodsimg` VALUES ('27', '铂光金', 'img-1/荣耀畅玩7C/铂光金.png');
INSERT INTO `goodsimg` VALUES ('28', '蓝色', 'img-1/畅玩7/蓝色.png');
INSERT INTO `goodsimg` VALUES ('28', '金色', 'img-1/畅玩7/金色.png');
INSERT INTO `goodsimg` VALUES ('28', '黑色', 'img-1/畅玩7/黑色.png');
INSERT INTO `goodsimg` VALUES ('29', '幻夜黑', 'img-1/畅玩7A/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('29', '极光蓝', 'img-1/畅玩7A/极光蓝.png');
INSERT INTO `goodsimg` VALUES ('29', '铂光金', 'img-1/畅玩7A/铂光金.png');
INSERT INTO `goodsimg` VALUES ('30', '白色', 'img-1/畅玩6X/白色.png');
INSERT INTO `goodsimg` VALUES ('31', '白色', 'img-1/畅玩5A/白色.png');
INSERT INTO `goodsimg` VALUES ('31', '金色', 'img-1/畅玩5A/金色.png');
INSERT INTO `goodsimg` VALUES ('31', '黑色', 'img-1/畅玩5A/黑色.png');
INSERT INTO `goodsimg` VALUES ('32', '玫瑰金', 'img-1/畅玩6A/玫瑰金.png');
INSERT INTO `goodsimg` VALUES ('32', '金色', 'img-1/畅玩6A/金色.png');
INSERT INTO `goodsimg` VALUES ('32', '银色', 'img-1/畅玩6A/银色.png');
INSERT INTO `goodsimg` VALUES ('33', '幻夜黑', 'img-1/荣耀9i/幻夜黑.png');
INSERT INTO `goodsimg` VALUES ('33', '魅海蓝', 'img-1/荣耀9i/魅海蓝.png');

-- ----------------------------
-- Table structure for goodsinorder
-- ----------------------------
DROP TABLE IF EXISTS `goodsinorder`;
CREATE TABLE `goodsinorder` (
  `orderId` int(20) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` double NOT NULL,
  `batteryCapacity` varchar(20) DEFAULT NULL,
  `frontFacingCamera` varchar(20) DEFAULT NULL,
  `rearCamera` varchar(20) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`goodsId`,`orderId`),
  KEY `fk_goodsInOrderform_orderformId` (`orderId`),
  CONSTRAINT `fk_goodsInOrderform_goodsId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_goodsInOrderform_orderformId` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsinorder
-- ----------------------------
INSERT INTO `goodsinorder` VALUES ('174310', '2', '1', '2388', '3000mAh-3999mAh', '800-1599万像素', '1200-1999万像素', '4G+64G');
INSERT INTO `goodsinorder` VALUES ('524910', '3', '16', '41584', '3000mAh-3999mAh', '2400万像素', '2400+1600万像素', '6G+64G');
INSERT INTO `goodsinorder` VALUES ('565410', '3', '1', '2999', '3000mAh-3999mAh', '2400万像素', '2400+1600万像素', '6G+128G');
INSERT INTO `goodsinorder` VALUES ('284715', '6', '4', '7196', '3000mAh-3999mAh', '1300+200万像素', '1600+200万像素', '4G+64G');
INSERT INTO `goodsinorder` VALUES ('103810', '31', '1', '699', '3000mAh-3999mAh', '800万', '200万像素；1200万像', '2G+16G');
INSERT INTO `goodsinorder` VALUES ('222810', '31', '3', '2097', '3000mAh-3999mAh', '800万', '200万像素；1200万像', '2G+16G');
INSERT INTO `goodsinorder` VALUES ('271015', '31', '2', '1398', '3000mAh-3999mAh', '800万', '200万像素；1200万像', '2G+16G');

-- ----------------------------
-- Table structure for goodsinshoppingtrolley
-- ----------------------------
DROP TABLE IF EXISTS `goodsinshoppingtrolley`;
CREATE TABLE `goodsinshoppingtrolley` (
  `shoppingTrolleyId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `quantity` int(11) DEFAULT '1',
  `amount` double NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `batteryCapacity` varchar(20) DEFAULT NULL,
  `frontFacingCamera` varchar(20) DEFAULT NULL,
  `rearCamera` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`shoppingTrolleyId`,`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsinshoppingtrolley
-- ----------------------------
INSERT INTO `goodsinshoppingtrolley` VALUES ('2208', '3', '12', '33988', '6G+128G', '3000mAh-3999mAh', '2400万像素', '2400+1600万像素');
INSERT INTO `goodsinshoppingtrolley` VALUES ('2208', '30', '6', '5394', '3G+32G', '3000mAh-3999mAh', '800万', '200万像素；1200万像');
INSERT INTO `goodsinshoppingtrolley` VALUES ('2212', '13', '5', '26440', '6G+64G', '4000mAh-5999mAh', '2400万像素', '2000+4000+800万像素');
INSERT INTO `goodsinshoppingtrolley` VALUES ('2212', '28', '5', '2995', '2G+16G', '3000mAh-3999mAh', '500万-799万', '1200万-1999万');
INSERT INTO `goodsinshoppingtrolley` VALUES ('2212', '31', '4', '2796', '2G+16G', '3000mAh-3999mAh', '800万', '200万像素；1200万像');
INSERT INTO `goodsinshoppingtrolley` VALUES ('2213', '31', '2', '1398', '2G+16G', '3000mAh-3999mAh', '800万', '200万像素；1200万像');

-- ----------------------------
-- Table structure for goodsprice
-- ----------------------------
DROP TABLE IF EXISTS `goodsprice`;
CREATE TABLE `goodsprice` (
  `goodsId` int(11) NOT NULL,
  `type` varchar(15) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `salesVolume` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`goodsId`,`type`),
  CONSTRAINT `fk_goodsPrice_goodsId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsprice
-- ----------------------------
INSERT INTO `goodsprice` VALUES ('1', '6+128', '4288', '8', '35000', '1');
INSERT INTO `goodsprice` VALUES ('1', '6+64', '3788', '9', '50000', '1');
INSERT INTO `goodsprice` VALUES ('2', '4+128', '2888', '15', '36000', '1');
INSERT INTO `goodsprice` VALUES ('2', '4+64', '2388', '20', '60000', '1');
INSERT INTO `goodsprice` VALUES ('3', '6+128', '2999', '18', '25000', '1');
INSERT INTO `goodsprice` VALUES ('3', '6+64', '2599', '16', '55000', '1');
INSERT INTO `goodsprice` VALUES ('4', '4+64', '1899', '10000', '40000', '1');
INSERT INTO `goodsprice` VALUES ('5', '6+128', '4199', '9000', '55000', '1');
INSERT INTO `goodsprice` VALUES ('5', '6+64', '3599', '3600', '25000', '1');
INSERT INTO `goodsprice` VALUES ('6', '4+64', '1799', '4600', '36000', '1');
INSERT INTO `goodsprice` VALUES ('7', '3+32', '1299', '1000', '12000', '1');
INSERT INTO `goodsprice` VALUES ('7', '4+64', '1399', '500', '22000', '1');
INSERT INTO `goodsprice` VALUES ('8', '4+128', '2199', '200', '30000', '1');
INSERT INTO `goodsprice` VALUES ('8', '4+64', '1999', '5000', '20000', '1');
INSERT INTO `goodsprice` VALUES ('9', '4+128', '1799', '300', '20000', '1');
INSERT INTO `goodsprice` VALUES ('9', '4+32', '1099', '660', '16000', '1');
INSERT INTO `goodsprice` VALUES ('9', '4+64', '1599', '600', '26000', '1');
INSERT INTO `goodsprice` VALUES ('10', '6+256', '9999', '100', '1200', '1');
INSERT INTO `goodsprice` VALUES ('11', '4+64', '2299', '2000', '23000', '1');
INSERT INTO `goodsprice` VALUES ('11', '6+128', '3299', '520', '9000', '1');
INSERT INTO `goodsprice` VALUES ('11', '6+64', '2799', '1000', '16000', '1');
INSERT INTO `goodsprice` VALUES ('12', '3+32', '999', '100', '10000', '1');
INSERT INTO `goodsprice` VALUES ('12', '4+32', '1399', '400', '15000', '1');
INSERT INTO `goodsprice` VALUES ('12', '4+64', '1599', '600', '40000', '1');
INSERT INTO `goodsprice` VALUES ('13', '6+128', '5788', '300', '12000', '1');
INSERT INTO `goodsprice` VALUES ('13', '6+64', '5288', '200', '10000', '1');
INSERT INTO `goodsprice` VALUES ('27', '3+32', '899', '12500', '15000', '1');
INSERT INTO `goodsprice` VALUES ('27', '4+64', '1299', '12600', '16000', '1');
INSERT INTO `goodsprice` VALUES ('28', '2+16', '599', '3500', '5000', '1');
INSERT INTO `goodsprice` VALUES ('29', '2+32', '749', '3200', '6800', '1');
INSERT INTO `goodsprice` VALUES ('29', '3+32', '999', '4600', '15000', '1');
INSERT INTO `goodsprice` VALUES ('30', '3+32', '899', '4600', '12200', '1');
INSERT INTO `goodsprice` VALUES ('31', '2+16', '699', '2598', '11200', '1');
INSERT INTO `goodsprice` VALUES ('32', '2+16', '666', '2630', '10200', '1');
INSERT INTO `goodsprice` VALUES ('32', '3+32', '829', '2830', '13200', '1');
INSERT INTO `goodsprice` VALUES ('33', '4+128', '1799', '6250', '23200', '1');
INSERT INTO `goodsprice` VALUES ('33', '4+64', '1499', '5850', '19200', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `address` varchar(100) NOT NULL,
  `name` varchar(18) NOT NULL,
  `amount` double NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_order_userId` (`userId`),
  CONSTRAINT `fk_order_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('103810', '2018-06-12 09:10:39', '京城', '李白', '699', '110010');
INSERT INTO `order` VALUES ('174310', '2018-06-12 09:17:43', '京城', '李白', '2388', '110010');
INSERT INTO `order` VALUES ('222810', '2018-06-11 21:22:29', '京城', '李白', '2097', '110010');
INSERT INTO `order` VALUES ('271015', '2018-06-14 10:27:10', '湖南省长沙市麓谷企业广场A4', 'rm-rf', '1398', '110015');
INSERT INTO `order` VALUES ('284715', '2018-06-14 10:28:47', '湖南省长沙市麓谷企业广场A4', 'rm-rf', '7196', '110015');
INSERT INTO `order` VALUES ('524910', '2018-06-13 20:52:49', '京城', '李白', '41584', '110010');
INSERT INTO `order` VALUES ('565410', '2018-06-13 20:56:54', '京城', '李白', '2999', '110010');

-- ----------------------------
-- Table structure for sensitiveword
-- ----------------------------
DROP TABLE IF EXISTS `sensitiveword`;
CREATE TABLE `sensitiveword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sensitiveword
-- ----------------------------
INSERT INTO `sensitiveword` VALUES ('1', '习近平');
INSERT INTO `sensitiveword` VALUES ('2', '习近平');
INSERT INTO `sensitiveword` VALUES ('3', 'xjp');
INSERT INTO `sensitiveword` VALUES ('4', 'xjp');
INSERT INTO `sensitiveword` VALUES ('5', '习明泽');
INSERT INTO `sensitiveword` VALUES ('6', '老习');
INSERT INTO `sensitiveword` VALUES ('7', '温宝宝');
INSERT INTO `sensitiveword` VALUES ('8', 'hujintao');
INSERT INTO `sensitiveword` VALUES ('9', '温家宝');
INSERT INTO `sensitiveword` VALUES ('10', '张培莉');
INSERT INTO `sensitiveword` VALUES ('11', '张培莉');
INSERT INTO `sensitiveword` VALUES ('12', '胡boss');
INSERT INTO `sensitiveword` VALUES ('13', '朱容基');
INSERT INTO `sensitiveword` VALUES ('14', '李洪志');
INSERT INTO `sensitiveword` VALUES ('15', '新疆骚乱');
INSERT INTO `sensitiveword` VALUES ('16', '新疆骚乱');
INSERT INTO `sensitiveword` VALUES ('17', '法轮功');
INSERT INTO `sensitiveword` VALUES ('18', '法轮功');
INSERT INTO `sensitiveword` VALUES ('19', '大陆当局');
INSERT INTO `sensitiveword` VALUES ('20', '北京当局');
INSERT INTO `sensitiveword` VALUES ('21', '共贪党');
INSERT INTO `sensitiveword` VALUES ('22', '公产党');
INSERT INTO `sensitiveword` VALUES ('23', '产党共');
INSERT INTO `sensitiveword` VALUES ('24', '阿共');
INSERT INTO `sensitiveword` VALUES ('25', '阿共');
INSERT INTO `sensitiveword` VALUES ('26', '供铲党');
INSERT INTO `sensitiveword` VALUES ('27', '共x党');
INSERT INTO `sensitiveword` VALUES ('28', '工产党');
INSERT INTO `sensitiveword` VALUES ('29', '共c党');
INSERT INTO `sensitiveword` VALUES ('30', '共产主义的幽灵');

-- ----------------------------
-- Table structure for shoppingtrolley
-- ----------------------------
DROP TABLE IF EXISTS `shoppingtrolley`;
CREATE TABLE `shoppingtrolley` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shoppingTrolley_userId` (`userId`),
  CONSTRAINT `fk_shoppingTrolley_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingtrolley
-- ----------------------------
INSERT INTO `shoppingtrolley` VALUES ('2208', '110010');
INSERT INTO `shoppingtrolley` VALUES ('2210', '110012');
INSERT INTO `shoppingtrolley` VALUES ('2211', '110013');
INSERT INTO `shoppingtrolley` VALUES ('2212', '110014');
INSERT INTO `shoppingtrolley` VALUES ('2213', '110015');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(11) NOT NULL,
  `userName` varchar(18) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(100) NOT NULL,
  `name` varchar(18) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_unique` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=110016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('110010', '19675253815', 'Jeckie', '$2a$10$JK1tFS.4jZ99.c.yY82xxumhdPqxqlMDQC7UouMGYWi70aOwh1Dre', '京城', '李白');
INSERT INTO `user` VALUES ('110012', '15580759612', 'William', '$2a$10$l02NbHSNxgG4NF6Ny5ujR..BwlD/5739gzBXkGHWREu3sx4xxELni', '大不列颠日不落帝国白金汉宫', '威廉王子');
INSERT INTO `user` VALUES ('110013', '15296035874', 'Marvin', '$2a$10$loyunixQgQmQYU3XzYql/eKFG0pD2Lieymp8n8i0NVIp7AJzdSUo2', '重庆市渣滓洞', '白驹');
INSERT INTO `user` VALUES ('110014', '15896250374', 'Jack', '$2a$10$1FKn4yP1PZAMC2dkeOoTdOBZgA0F2tj7Q8mQu43/Pxc8Uahr3d3.W', '河北雄安新区', 'Jack');
INSERT INTO `user` VALUES ('110015', '15583697215', 'rm-rf', '$2a$10$v0ydJ2LST04jcFe.mZ0Eouzgx0qyMdwjoya2VGKa0PW0wqr8lpSim', '湖南省长沙市麓谷企业广场A4', 'rm-rf');
