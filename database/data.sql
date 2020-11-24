/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-03-21 15:44:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_help
-- ----------------------------
DROP TABLE IF EXISTS `cms_help`;
CREATE TABLE `cms_help` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `read_count` int(1) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='help';

-- ----------------------------
-- Records of cms_help
-- ----------------------------

-- ----------------------------
-- Table structure for cms_help_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_help_category`;
CREATE TABLE `cms_help_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'catagory icon',
  `help_count` int(11) DEFAULT NULL COMMENT 'category count',
  `show_status` int(2) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='category table';

-- ----------------------------
-- Records of cms_help_category
-- ----------------------------

-- ----------------------------
-- Table structure for cms_member_report
-- ----------------------------
DROP TABLE IF EXISTS `cms_member_report`;
CREATE TABLE `cms_member_report` (
  `id` bigint(20) DEFAULT NULL,
  `report_type` int(1) DEFAULT NULL COMMENT 'report type：0->product comment；1->topic；2->user comment',
  `report_member_name` varchar(100) DEFAULT NULL COMMENT 'reporter',
  `create_time` datetime DEFAULT NULL,
  `report_object` varchar(100) DEFAULT NULL,
  `report_status` int(1) DEFAULT NULL COMMENT 'report status：0->unsolved；1->solved',
  `handle_status` int(1) DEFAULT NULL COMMENT 'solve result：0->invalid；1->valid；2->malicious',
  `note` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user report table';

-- ----------------------------
-- Records of cms_member_report
-- ----------------------------

-- ----------------------------
-- Table structure for cms_prefrence_area
-- ----------------------------
DROP TABLE IF EXISTS `cms_preference_area`;
CREATE TABLE `cms_preference_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `pic` varbinary(500) DEFAULT NULL COMMENT 'display picture',
  `sort` int(11) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='preference area';

-- ----------------------------
-- Records of cms_prefrence_area
-- ----------------------------
INSERT INTO `cms_preference_area` VALUES ('1', 'Better Sound Quality', 'Better Sound Quality', null, null, '1');
INSERT INTO `cms_preference_area` VALUES ('2', 'Better Sound Quality2', 'Better Sound Quality2', null, null, null);
INSERT INTO `cms_preference_area` VALUES ('3', 'Better Sound Quality3', null, null, null, null);
INSERT INTO `cms_preference_area` VALUES ('4', 'Better Sound Quality4', null, null, null, null);

-- ----------------------------
-- Table structure for cms_prefrence_area_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `cms_preference_area_product_relation`;
CREATE TABLE `cms_preference_area_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `preference_area_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='preference area relation with product';

-- ----------------------------
-- Records of cms_prefrence_area_product_relation
-- ----------------------------
INSERT INTO `cms_preference_area_product_relation` VALUES ('1', '1', '12');
INSERT INTO `cms_preference_area_product_relation` VALUES ('2', '1', '13');
INSERT INTO `cms_preference_area_product_relation` VALUES ('3', '1', '14');
INSERT INTO `cms_preference_area_product_relation` VALUES ('4', '1', '18');
INSERT INTO `cms_preference_area_product_relation` VALUES ('5', '1', '7');
INSERT INTO `cms_preference_area_product_relation` VALUES ('6', '2', '7');
INSERT INTO `cms_preference_area_product_relation` VALUES ('7', '1', '22');
INSERT INTO `cms_preference_area_product_relation` VALUES ('24', '1', '23');

-- ----------------------------
-- Table structure for cms_subject
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject`;
CREATE TABLE `cms_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL COMMENT 'subject picture',
  `product_count` int(11) DEFAULT NULL COMMENT 'product count',
  `recommend_status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `collect_count` int(11) DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `album_pics` varchar(1000) DEFAULT NULL COMMENT 'album pics separete with comma',
  `description` varchar(1000) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL COMMENT 'display status：0->no；1->yes',
  `content` text,
  `forward_count` int(11) DEFAULT NULL COMMENT 'foward count',
  `category_name` varchar(200) DEFAULT NULL COMMENT 'subject category name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='subject table';

-- ----------------------------
-- Records of cms_subject
-- ----------------------------
INSERT INTO `cms_subject` VALUES ('1', '1', 'Phone', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t26434/217/1381240043/254214/290f9d5b/5bc6c11cN54567a27.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'Making communication easier.', '1', null, null, 'feature topic');
INSERT INTO `cms_subject` VALUES ('2', '1', 'MotorCycle', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t14224/229/529700229/74868/a1cc7364/5a314f85N5bfd22c7.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'The best rides happen on two wheels.', '1', null, null, 'feature topics');
INSERT INTO `cms_subject` VALUES ('3', '1', 'Wine', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t1/881/4/12265/114011/5bd1446fEc71114bf/68925bfb4a2adc44.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'A Moments of True enjoy.', '1', null, null, 'feature topics');
INSERT INTO `cms_subject` VALUES ('4', '2', 'Cleaner', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t15205/35/2539924281/429185/72fa7857/5aab2c4bN6a32a6c5.png', null, '1', Now(), '100', '1000', '100', null, 'Lose the mop and we will clean the slop.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('5', '2', 'Water', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t11428/340/1504074828/20474/1e8cab1e/5a0305d3Nb1e7a762.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'Conserve water, conserve life.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('6', '2', 'Refridge', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t13015/356/2397552584/605232/46c88e6e/5a5321bcN6a8866f0.png', null, '1', Now(), '100', '1000', '100', null, 'Keep your foods nice and chill without a big electricity bill.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('7', '2', 'Water Boiler', 'https://img13.360buyimg.com/mobilecms/s1500x600_jfs/t12541/90/443985343/33603/65d6e884/5a0bb77aNff08550a.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'A drop of water is worth more than a sack of gold to a thirsty man.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('8', '2', 'Cooker', 'https://img14.360buyimg.com/mobilecms/s1500x600_jfs/t15949/363/1450937723/89513/7d8c1219/5a531d28N2aaec2a6.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'Cook it with care, well finished not rare. ', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('9', '2', 'Microwave', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t1/8774/21/11460/38908/5c2cbfcfEdab1ef03/d5800f0f7cf05b38.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'Sweet lovins directly from our ovens.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('10', '2', 'Blender', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t13708/126/308291722/542847/26ee6edd/5a07dc72N3252a9e0.png', null, '1', Now(), '100', '1000', '100', null, 'A juice a day keeps the body in play.', '1', null, null, 'home topic');
INSERT INTO `cms_subject` VALUES ('11', '3', 'Cracker', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t13240/79/443357432/38567/94792c4c/5a0ba054N89388654.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'For a good life, have a good bite.', '1', null, null, 'food topic');
INSERT INTO `cms_subject` VALUES ('12', '3', 'Wheat bread', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t9775/33/1197239610/38547/34899011/59ddbd01N0bd693bb.jpg!q70.jpg', null, '1', Now(),'100', '1000', '100', null, 'A Moments to Eat and Enjoy.', '1', null, null, 'food topic');
INSERT INTO `cms_subject` VALUES ('13', '3', 'Cookie', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t18877/139/652452758/27262/36e6ed6e/5a9d5b6dN327150e8.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'It is crazy with chips.', '1', null, null, 'food topic');
INSERT INTO `cms_subject` VALUES ('14', '4', 'Speaker', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t17125/265/644948348/42066/6f2dc610/5a9c9da1N9a95ee2c.jpg!q70.jpg', null, '1', Now(), '100', '1000', '100', null, 'Affordable audio.', '1', null, null, 'electronic topic');
INSERT INTO `cms_subject` VALUES ('15', '5', 'Handbag', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t8365/191/1901440450/575969/c71560c9/59c3144dNe6d8dd2f.png', null, '1', Now(), '100', '1000', '100', null, 'Adding Moments of Styles.', '1', null, null, 'clothes topic');

-- ----------------------------
-- Table structure for cms_subject_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_category`;
CREATE TABLE `cms_subject_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'category icon',
  `subject_count` int(11) DEFAULT NULL COMMENT 'subject count',
  `show_status` int(2) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='subject category table';

-- ----------------------------
-- Records of cms_subject_category
-- ----------------------------
INSERT INTO `cms_subject_category` VALUES ('1', 'feature topic', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_jingxuan.png', '3', '1', '100');
INSERT INTO `cms_subject_category` VALUES ('2', 'home topic', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_jiadian.png', '7', '1', '0');
INSERT INTO `cms_subject_category` VALUES ('3', 'food topic', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_meishi.png', '3', '1', '0');
INSERT INTO `cms_subject_category` VALUES ('4', 'electronic topic', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_shouji.png', '1', '1', '0');
INSERT INTO `cms_subject_category` VALUES ('5', 'clothes topic', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_waitao.png', '1', '1', '0');

-- ----------------------------
-- Table structure for cms_subject_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_comment`;
CREATE TABLE `cms_subject_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='subject comment table';


-- ----------------------------
-- Table structure for cms_subject_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_product_relation`;
CREATE TABLE `cms_subject_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='subject product relation table';

-- ----------------------------
-- Records of cms_subject_product_relation
-- ----------------------------
INSERT INTO `cms_subject_product_relation` VALUES ('1', '1', '26');
INSERT INTO `cms_subject_product_relation` VALUES ('2', '1', '27');
INSERT INTO `cms_subject_product_relation` VALUES ('3', '1', '28');
INSERT INTO `cms_subject_product_relation` VALUES ('4', '1', '29');
INSERT INTO `cms_subject_product_relation` VALUES ('5', '2', '30');
INSERT INTO `cms_subject_product_relation` VALUES ('6', '2', '31');
INSERT INTO `cms_subject_product_relation` VALUES ('7', '2', '35');
INSERT INTO `cms_subject_product_relation` VALUES ('29', '2', '36');
INSERT INTO `cms_subject_product_relation` VALUES ('30', '2', '32');
INSERT INTO `cms_subject_product_relation` VALUES ('31', '3', '33');
INSERT INTO `cms_subject_product_relation` VALUES ('38', '3', '34');

-- ----------------------------
-- Table structure for cms_topic
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic`;
CREATE TABLE `cms_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `attend_count` int(11) DEFAULT NULL COMMENT 'attend count',
  `attention_count` int(11) DEFAULT NULL COMMENT 'attention count',
  `read_count` int(11) DEFAULT NULL,
  `award_name` varchar(100) DEFAULT NULL COMMENT 'award name',
  `attend_type` varchar(100) DEFAULT NULL COMMENT 'attend type',
  `content` text COMMENT 'topic',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='topic table';

-- ----------------------------
-- Records of cms_topic
-- ----------------------------

-- ----------------------------
-- Table structure for cms_topic_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic_category`;
CREATE TABLE `cms_topic_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'category icon',
  `subject_count` int(11) DEFAULT NULL COMMENT 'subject count',
  `show_status` int(2) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='topic category table';

-- ----------------------------
-- Records of cms_topic_category
-- ----------------------------

-- ----------------------------
-- Table structure for cms_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic_comment`;
CREATE TABLE `cms_topic_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='subject comment table';

-- ----------------------------
-- Records of cms_topic_comment
-- ----------------------------

-- ----------------------------
-- Table structure for oms_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart_item`;
CREATE TABLE `oms_cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_sku_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL COMMENT 'quantity',
  `price` decimal(10,2) DEFAULT NULL COMMENT 'price added to shopping cart',
  `sp1` varchar(200) DEFAULT NULL COMMENT 'sale properties1',
  `sp2` varchar(200) DEFAULT NULL COMMENT 'sale properties2',
  `sp3` varchar(200) DEFAULT NULL COMMENT 'sale properties3',
  `product_pic` varchar(1000) DEFAULT NULL COMMENT 'product pictures',
  `product_name` varchar(500) DEFAULT NULL COMMENT 'product names',
  `product_sub_title` varchar(500) DEFAULT NULL COMMENT 'product subtitle',
  `product_sku_code` varchar(200) DEFAULT NULL COMMENT 'product sku code',
  `member_nickname` varchar(500) DEFAULT NULL COMMENT 'member nickname',
  `create_date` datetime DEFAULT NULL COMMENT 'create date',
  `modify_date` datetime DEFAULT NULL COMMENT 'modify date',
  `delete_status` int(1) DEFAULT '0' COMMENT 'delete status',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT 'product category',
  `product_brand` varchar(200) DEFAULT NULL,
  `product_sn` varchar(200) DEFAULT NULL,
  `product_attr` varchar(500) DEFAULT NULL COMMENT 'product sale properties:[{"key":"color","value":"color"},{"key":"capacity","value":"4G"}]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='shopping cart table';

-- ----------------------------
-- Records of oms_cart_item
-- ----------------------------
INSERT INTO `oms_cart_item` VALUES ('12', '26', '90', '1', '1', '699.00', 'Golden', '16G', null, null, 'Huawei P20', 'Huawei', '201806070026001', 'windir', '2018-08-27 16:53:44', null, '0', '19', null, null, null);
INSERT INTO `oms_cart_item` VALUES ('13', '27', '98', '1', '3', '499.00', 'Black', '32G', null, null, 'Mi 8', 'Mi', '201808270027001', 'windir', '2018-08-27 17:11:53', null, '0', '19', null, null, null);
INSERT INTO `oms_cart_item` VALUES ('14', '28', '102', '1', '1', '649.00', 'Golden', '16G', null, null, '5A Phone', 'Sale', '201808270028001', 'windir', '2018-08-27 17:18:02', null, '0', '19', null, null, null);
INSERT INTO `oms_cart_item` VALUES ('15', '28', '103', '1', '1', '699.00', 'Golden', '32G', null, null, '5A Phone', 'Sale', '201808270028001', 'windir', '2018-08-28 10:22:45', null, '0', '19', null, null, null);
INSERT INTO `oms_cart_item` VALUES ('16', '29', '106', '1', '1', '899.00', 'Golden', '32G', null, null, 'Apple iPhone 8 Plus', 'Iphone', '201808270029001', 'windir', '2018-08-28 10:50:50', null, '0', '19', null, null, null);

-- ----------------------------
-- Table structure for oms_company_address
-- ----------------------------
DROP TABLE IF EXISTS `oms_company_address`;
CREATE TABLE `oms_company_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(200) DEFAULT NULL COMMENT 'address',
  `send_status` int(1) DEFAULT NULL COMMENT 'default address：0->no；1->yes',
  `receive_status` int(1) DEFAULT NULL COMMENT 'whether default address：0->no；1->yes',
  `name` varchar(64) DEFAULT NULL COMMENT 'receiver name',
  `phone` varchar(64) DEFAULT NULL COMMENT 'receiver phone',
  `state` varchar(64) DEFAULT NULL COMMENT ' state',
  `city` varchar(64) DEFAULT NULL COMMENT 'city',
  `zip_code` varchar(5) DEFAULT NULL COMMENT 'zip code',
  `detail_address` varchar(200) DEFAULT NULL COMMENT 'detail address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='company address table';

-- ----------------------------
-- Records of oms_company_address
-- ----------------------------
INSERT INTO `oms_company_address` VALUES ('1', 'Tingting', '1', '1', 'Ting', '18000000000', 'NY', 'Brooklyn','11222',  '111 Ben st');
INSERT INTO `oms_company_address` VALUES ('2', 'Shawn Zheng', '0', '0', 'Shawn', '18000000000', 'CT', 'TK','11222' , '120 Fortune Ave');
INSERT INTO `oms_company_address` VALUES ('3', 'Jane', '0', '0', 'June', '18000000000', 'NY', 'Queen','11321', '333 Fort Pl');

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'order id',
  `member_id` bigint(20) NOT NULL,
  `coupon_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL COMMENT 'order number',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `member_username` varchar(64) DEFAULT NULL COMMENT 'member username',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT 'order total amount',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT 'pay amount',
  `freight_amount` decimal(10,2) DEFAULT NULL COMMENT 'shipment amount',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT 'promotion amount',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT 'integration amount',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT 'coupon amount',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT 'admin backend adjust discount amount',
  `pay_type` int(1) DEFAULT NULL COMMENT 'payment method：0->unpaid；1->card；2->paypal',
  `card_number` varchar(255) DEFAULT NULL,
  `card_expiration` varchar(255) DEFAULT NULL,
  `paypal_id` varchar(255) DEFAULT NULL,
  `source_type` int(1) DEFAULT NULL COMMENT 'order type：0->pc order；1->app order',
  `status` int(1) DEFAULT NULL COMMENT 'order status：0->unpaid；1->unshipped；2->shipped；3->finished；4->closed；5->invalid order',
  `order_type` int(1) DEFAULT NULL COMMENT 'order type：0->normal order；1->spike order',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT 'logistics company',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT 'tracking number',
  `auto_confirm_day` int(11) DEFAULT NULL COMMENT 'auto confirm day',
  `integration` int(11) DEFAULT NULL COMMENT 'integration',
  `growth` int(11) DEFAULT NULL COMMENT 'growth',
  `promotion_info` varchar(100) DEFAULT NULL COMMENT 'promotion info',
  `bill_type` int(1) DEFAULT NULL COMMENT 'receipt type：0->no；1->electronic；2->paper',
  `bill_header` varchar(200) DEFAULT NULL COMMENT 'receipt header',
  `bill_content` varchar(200) DEFAULT NULL COMMENT 'receiptcontent',
  `bill_receiver_phone` varchar(32) DEFAULT NULL COMMENT 'recipient phone',
  `bill_receiver_email` varchar(64) DEFAULT NULL COMMENT 'recipient email',
  `receiver_name` varchar(100) NOT NULL COMMENT 'receiver name',
  `receiver_phone` varchar(32) NOT NULL COMMENT 'receiver phone',
  `receiver_zip_code` varchar(32) DEFAULT NULL COMMENT 'receiver zip code',
  `receiver_state` varchar(32) DEFAULT NULL COMMENT 'state',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT 'city',
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT 'detail address',
  `note` varchar(500) DEFAULT NULL COMMENT 'order note',
  `confirm_status` int(1) DEFAULT NULL COMMENT 'confirm received status：0->no；1->yes',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT 'delete status：0->no；1->yes',
  `use_integration` int(11) DEFAULT NULL COMMENT 'used integration',
  `payment_time` datetime DEFAULT NULL COMMENT 'payment time',
  `delivery_time` datetime DEFAULT NULL COMMENT 'received time',
  `receive_time` datetime DEFAULT NULL COMMENT 'confirm received time',
  `comment_time` datetime DEFAULT NULL COMMENT 'comment time',
  `modify_time` datetime DEFAULT NULL COMMENT 'modify date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='order table';

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES ('12', '1', '2', '201809150101000001', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '20.00', '2344.25', '0.00', '10.00', '10.00', '0',null,null,null, '1', '4', '0', '', '', '15', '13284', '13284', 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', 'xxx', '0', '0', null, null, null, null, null, '2018-10-30 14:43:49');
INSERT INTO `oms_order` VALUES ('13', '1', '2', '201809150102000002', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1','222222222222','1/2/2020',null, '1', '1', '0', '', '', '15', '13284', '13284', 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn', '269 Ben st', null, '0', '0', '1000', '2018-10-11 14:04:19', null, null, null, null);
INSERT INTO `oms_order` VALUES ('14', '1', '2', '201809130101000001', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2',null,null,'23333', '1', '2', '0', 'UPS', '201707196398345', '15', '13284', '13284', 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn', '269 Ben st', null, '0', '0', null, '2018-10-13 13:44:04', '2018-10-16 13:43:41', null, null, null);
INSERT INTO `oms_order` VALUES ('15', '1', '2', '201809130102000002', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1','222222222222','1/2/2020',null, '1', '3', '0', 'UPS', '201707196398346', '15', '13284', '13284', 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', null, '1', '0', null, '2018-10-13 13:44:54', '2018-10-16 13:45:01', '2018-10-18 14:05:31', null, null);
INSERT INTO `oms_order` VALUES ('16', '1', '2', '201809140101000001', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2',null,null,'23333', '1', '4', '0', null, null, '15', '13284', '13284', 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn', '269 Ben st', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `oms_order` VALUES ('17', '1', '2', '201809150101000003', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '0',null,null,null, '1', '4', '0', 'UPS', '201707196398345', '15', null, null, 'SALE', null, null, null, null, null, 'Ting', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', null, '0', '0', null, null, '2018-10-12 14:01:28', null, null, null);
INSERT INTO `oms_order` VALUES ('18', '1', '2', '201809150102000004', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1','222222222222','1/2/2020',null, '1', '1', '0', 'UPS', 'xx', '15', null, null, 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', null, '0', '0', '1000', null, '2018-10-16 14:42:17', null, null, null);
INSERT INTO `oms_order` VALUES ('19', '1', '2', '201809130101000003', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2',null,null,'23333', '1', '2', '0', null, null, '15', null, null, 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn', '269 Ben st', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `oms_order` VALUES ('20', '1', '2', '201809130102000004', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1','222222222222','1/2/2020',null, '1', '3', '0', null, null, '15', null, null, 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn','269 Ben st', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `oms_order` VALUES ('21', '1', '2', '201809140101000002', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2',null,null,'23333', '1', '4', '0', null, null, '15', '18682', '18682', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn','269 Ben st', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `oms_order` VALUES ('22', '1', '2', '201809150101000005', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '0',null,null,null, '1', '4', '0', 'FEDEX', '201707196398345', '15', '0', '0', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', null, '0', '0', null, null, '2018-10-12 14:01:28', null, null, null);
INSERT INTO `oms_order` VALUES ('23', '1', '2', '201809150102000006', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1','222222222222','1/2/2020',null, '1', '1', '0', 'FEDEX', 'xxx', '15', '0', '0', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY','Brooklyn', '269 Ben st', null, '0', '0', '1000', null, '2018-10-16 14:41:28', null, null, null);
INSERT INTO `oms_order` VALUES ('24', '1', '2', '201809130101000005', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2',null,null,'23333','1', '2', '0', null, null, '15', '18682', '18682', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `oms_order` VALUES ('25', '1', '2', '201809130102000006', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '10.00', '2344.25', '0.00', '10.00', '5.00', '1','222222222222','1/2/2020',null, '1', '4', '0', null, null, '15', '18682', '18682', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn',  '269 Ben st', 'xxx', '0', '0', null, null, null, null, null, '2018-10-30 15:08:31');
INSERT INTO `oms_order` VALUES ('26', '1', '2', '201809140101000003', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '0',null,null,null, '1', '4', '0', null, null, '15', '18682', '18682', 'SALE', null, null, null, null, null, 'Shawn', '18033441849', '11222', 'NY', 'Brooklyn', '269 Ben st', null, '0', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT 'order id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT 'order number',
  `product_id` bigint(20) DEFAULT NULL,
  `product_pic` varchar(500) DEFAULT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `product_brand` varchar(200) DEFAULT NULL,
  `product_sn` varchar(64) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL COMMENT 'sale price',
  `product_quantity` int(11) DEFAULT NULL COMMENT 'sale quantity',
  `product_sku_id` bigint(20) DEFAULT NULL COMMENT 'sku id',
  `product_sku_code` varchar(50) DEFAULT NULL COMMENT 'sku code',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT 'product catogory id',
  `sp1` varchar(100) DEFAULT NULL COMMENT 'product sale properties',
  `sp2` varchar(100) DEFAULT NULL,
  `sp3` varchar(100) DEFAULT NULL,
  `promotion_name` varchar(200) DEFAULT NULL COMMENT 'product promotion name',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT 'product promotion price',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT 'coupon price',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT 'integration price',
  `real_amount` decimal(10,2) DEFAULT NULL COMMENT 'after all price',
  `gift_integration` int(11) DEFAULT '0',
  `gift_growth` int(11) DEFAULT '0',
  `product_attr` varchar(500) DEFAULT NULL COMMENT 'product attributes:[{"key":"color","value":"blue/green/etc"},{"key":"capacity","value":"4G"}]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='order items';

-- ----------------------------
-- Records of oms_order_item
-- ----------------------------
INSERT INTO `oms_order_item` VALUES ('21', '12', '201809150101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', '6946605', '3788.00', '1', '90', '201806070026001', '19', 'Sale', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('22', '12', '201809150101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', '7437788', '2699.00', '3', '98', '201808270027001', '19',  'Buy three,10% off', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"color\",\"value\":\"black\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('23', '12', '201809150101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '649.00', '1', '102', '201808270028001', '19',  '1000 and 120 off', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('24', '12', '201809150101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '699.00', '1', '103', '201808270028001', '19',  '1000 and 120 off', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('25', '12', '201809150101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', 'Huawei', '7437799', '5499.00', '1', '106', '201808270029001', '19', 'No', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('26', '13', '201809150102000002', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', '6946605', '3788.00', '1', '90', '201806070026001', '19',  'Sale', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('27', '13', '201809150102000002', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', '7437788', '2699.00', '3', '98', '201808270027001', '19', 'Buy three,10% off', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"color\",\"color\":\"black\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('28', '13', '201809150102000002', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '649.00', '1', '102', '201808270028001', '19', '1000 and 120 off', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('29', '13', '201809150102000002', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '699.00', '1', '103', '201808270028001', '19',  '1000 and 120 off', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('30', '13', '201809150102000002', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', 'APPLE', '7437799', '5499.00', '1', '106', '201808270029001', '19',  'No', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('31', '14', '201809130101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', '6946605', '3788.00', '1', '90', '201806070026001', '19',  'Sale', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('32', '14', '201809130101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', '7437788', '2699.00', '3', '98', '201808270027001', '19',  'Buy three,10% off', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"color\",\"value\":\"black\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('33', '14', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '649.00', '1', '102', '201808270028001', '19',  '1000 and 120 off', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('34', '14', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '699.00', '1', '103', '201808270028001', '19',  '1000 and 120 off', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('35', '14', '201809130101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', 'APPLE', '7437799', '5499.00', '1', '106', '201808270029001', '19',  'No', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('36', '15', '201809130101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', '6946605', '3788.00', '1', '90', '201806070026001', '19',  'Sale', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('37', '15', '201809130101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', '7437788', '2699.00', '3', '98', '201808270027001', '19',  'Buy three,10% off', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"color\",\"value\":\"black\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('38', '15', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '649.00', '1', '102', '201808270028001', '19',  '1000 and 120 off', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('39', '15', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '699.00', '1', '103', '201808270028001', '19',  '1000 and 120 off', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('40', '15', '201809130101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', 'APPLE', '7437799', '5499.00', '1', '106', '201808270029001', '19',  'No', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('41', '16', '201809140101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', '6946605', '3788.00', '1', '90', '201806070026001', '19',  'Sale', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('42', '16', '201809140101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', '7437788', '699.00', '3', '98', '201808270027001', '19',  'Buy three,10% off', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"color\",\"value\":\"black\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('43', '16', '201809140101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '649.00', '1', '102', '201808270028001', '19',  '1000 and 120 off', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"16G\"}]');
INSERT INTO `oms_order_item` VALUES ('44', '16', '201809140101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', '7437789', '699.00', '1', '103', '201808270028001', '19',  '1000 and 120 off', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');
INSERT INTO `oms_order_item` VALUES ('45', '16', '201809140101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', 'APPLE', '7437799', '5499.00', '1', '106', '201808270029001', '19',  'No', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"color\",\"value\":\"golden\"},{\"key\":\"capacity\",\"value\":\"32G\"}]');

-- ----------------------------
-- Table structure for oms_order_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_operate_history`;
CREATE TABLE `oms_order_operate_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT 'order id',
  `operate_man` varchar(100) DEFAULT NULL COMMENT 'operator：user/system/admin',
  `create_time` datetime DEFAULT NULL COMMENT 'operating time',
  `order_status` int(1) DEFAULT NULL COMMENT 'order status：0->wait to pay；1->wait to ship；2->ship already；3->finished；4->closed；5->invalid order',
  `note` varchar(500) DEFAULT NULL COMMENT 'note',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='order operate history';

-- ----------------------------
-- Records of oms_order_operate_history
-- ----------------------------
INSERT INTO `oms_order_operate_history` VALUES ('5', '12', 'admin', '2018-10-12 14:01:29', '2', 'shipped');
INSERT INTO `oms_order_operate_history` VALUES ('6', '13', 'admin', '2018-10-12 14:01:29', '2', 'shipped');
INSERT INTO `oms_order_operate_history` VALUES ('7', '12', 'admin', '2018-10-12 14:13:10', '4', 'order close:buyer return');
INSERT INTO `oms_order_operate_history` VALUES ('8', '13', 'admin', '2018-10-12 14:13:10', '4', 'order close:buyer return');
INSERT INTO `oms_order_operate_history` VALUES ('9', '22', 'admin', '2018-10-15 16:31:48', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('10', '22', 'admin', '2018-10-15 16:35:08', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('11', '22', 'admin', '2018-10-15 16:35:59', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('12', '17', 'admin', '2018-10-15 16:43:40', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('13', '25', 'admin', '2018-10-15 16:52:14', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('14', '26', 'admin', '2018-10-15 16:52:14', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('15', '23', 'admin', '2018-10-16 14:41:28', '2', 'shipped');
INSERT INTO `oms_order_operate_history` VALUES ('16', '13', 'admin', '2018-10-16 14:42:17', '2', 'shipped');
INSERT INTO `oms_order_operate_history` VALUES ('17', '18', 'admin', '2018-10-16 14:42:17', '2', 'shipped');
INSERT INTO `oms_order_operate_history` VALUES ('18', '26', 'admin', '2018-10-30 14:37:44', '4', 'order close:close order');
INSERT INTO `oms_order_operate_history` VALUES ('19', '25', 'admin', '2018-10-30 15:07:01', '0', 'change receiver info');
INSERT INTO `oms_order_operate_history` VALUES ('20', '25', 'admin', '2018-10-30 15:08:13', '0', 'Change price');
INSERT INTO `oms_order_operate_history` VALUES ('21', '25', 'admin', '2018-10-30 15:08:31', '0', 'Change message：xxx');
INSERT INTO `oms_order_operate_history` VALUES ('22', '25', 'admin', '2018-10-30 15:08:39', '4', 'order close:close order');

-- ----------------------------
-- Table structure for oms_order_return_apply
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_apply`;
CREATE TABLE `oms_order_return_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT 'order id',
  `company_address_id` bigint(20) DEFAULT NULL COMMENT 'company address id',
  `product_id` bigint(20) DEFAULT NULL COMMENT 'return product id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT 'order number',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `member_username` varchar(64) DEFAULT NULL COMMENT 'member username',
  `return_amount` decimal(10,2) DEFAULT NULL COMMENT 'return amount',
  `return_name` varchar(100) DEFAULT NULL COMMENT 'return name',
  `return_phone` varchar(100) DEFAULT NULL COMMENT 'return phone',
   `return_email` varchar(100) DEFAULT NULL COMMENT 'return email',
  `status` int(1) DEFAULT NULL COMMENT 'application status：0->unsolved；1->returning；2->finished；3->denied',
  `handle_time` datetime DEFAULT NULL COMMENT 'handle time',
  `product_pic` varchar(500) DEFAULT NULL COMMENT 'product picture',
  `product_name` varchar(200) DEFAULT NULL COMMENT 'product names',
  `product_brand` varchar(200) DEFAULT NULL COMMENT 'product brand',
  `product_attr` varchar(500) DEFAULT NULL COMMENT 'product sale properties：color：red；size：xl;',
  `product_count` int(11) DEFAULT NULL COMMENT 'return count',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT 'product price',
  `product_real_price` decimal(10,2) DEFAULT NULL COMMENT 'product final price',
  `reason` varchar(200) DEFAULT NULL COMMENT 'reason',
  `description` varchar(500) DEFAULT NULL COMMENT 'description',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT 'picture evident, separate with comma',
  `handle_note` varchar(500) DEFAULT NULL COMMENT 'handle note',
  `handle_man` varchar(100) DEFAULT NULL COMMENT 'handle staff',
  `receive_man` varchar(100) DEFAULT NULL COMMENT 'receiver',
  `receive_time` datetime DEFAULT NULL COMMENT 'receive time',
  `receive_note` varchar(500) DEFAULT NULL COMMENT 'receive note',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='order return application';

-- ----------------------------
-- Records of oms_order_return_apply
-- ----------------------------
INSERT INTO `oms_order_return_apply` VALUES ('3', '12', null, '26', '201809150101000001', '2018-10-17 14:34:57', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'lag', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('4', '12', '2', '27', '201809150101000001', '2018-10-17 14:40:21', 'test', '3585.98', 'Ting', '18000000000','406980674@qq.com', '1', '2018-10-18 13:54:10', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', 'solved', 'admin', null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('5', '12', '3', '28', '201809150101000001', '2018-10-17 14:44:18', 'test', '3585.98', 'Ting', '18000000000','406980674@qq.com', '2', '2018-10-18 13:55:28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', 'solved', 'admin', 'admin', '2018-10-18 13:55:58', 'solved');
INSERT INTO `oms_order_return_apply` VALUES ('8', '13', null, '28', '201809150102000002', '2018-10-17 14:44:18', 'test', null, 'Ting', '18000000000','406980674@qq.com', '3', '2018-10-18 13:57:12', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', 'not enough reason', 'admin', null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('9', '14', '2', '26', '201809130101000001', '2018-10-17 14:34:57', 'test', '3500.00', 'Ting', '18000000000','406980674@qq.com', '2', '2018-10-24 15:44:56', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'lag', '', '1', 'admin', 'admin', '2018-10-24 15:46:35', 'delivered');
INSERT INTO `oms_order_return_apply` VALUES ('10', '14', null, '27', '201809130101000001', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '3', '2018-10-24 15:46:57', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', 'no', 'admin', null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('11', '14', '2', '28', '201809130101000001', '2018-10-17 14:44:18', 'test', '591.05', 'Ting', '18000000000','406980674@qq.com', '1', '2018-10-24 17:09:04', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', 'refundable', 'admin', null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('12', '15', '3', '26', '201809130102000002', '2018-10-17 14:34:57', 'test', '3500.00', 'Ting', '18000000000','406980674@qq.com', '2', '2018-10-24 17:22:54', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'lag', '', 'return', 'admin', 'admin', '2018-10-24 17:23:06', 'delivered');
INSERT INTO `oms_order_return_apply` VALUES ('13', '15', null, '27', '201809130102000002', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '3', '2018-10-24 17:23:30', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', 'noreturn', 'admin', null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('15', '16', null, '26', '201809140101000001', '2018-10-17 14:34:57', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('16', '16', null, '27', '201809140101000001', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('17', '16', null, '28', '201809140101000001', '2018-10-17 14:44:18', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('18', '17', null, '26', '201809150101000003', '2018-10-17 14:34:57', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('19', '17', null, '27', '201809150101000003', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('20', '17', null, '28', '201809150101000003', '2018-10-17 14:44:18', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('21', '18', null, '26', '201809150102000004', '2018-10-17 14:34:57', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('22', '18', null, '27', '201809150102000004', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('23', '18', null, '28', '201809150102000004', '2018-10-17 14:44:18', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('24', '19', null, '26', '201809130101000003', '2018-10-17 14:34:57', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'Huawei P20', 'Huawei', 'color：golden;capacity：16G', '1', '3788.00', '3585.98', 'quality', 'lag', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('25', '19', null, '27', '201809130101000003', '2018-10-17 14:40:21', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 'Mi 8', 'Mi', 'color：black;capacity：32G', '1', '2699.00', '2022.81', 'quality', 'low', '', null, null, null, null, null);
INSERT INTO `oms_order_return_apply` VALUES ('26', '19', null, '28', '201809130101000003', '2018-10-17 14:44:18', 'test', null, 'Ting', '18000000000','406980674@qq.com', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 'Red Mi 5A', 'Mi', 'color：golden;capacity：16G', '1', '649.00', '591.05', 'quality', 'old', '', null, null, null, null, null);

-- ----------------------------
-- Table structure for oms_order_return_reason
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_reason`;
CREATE TABLE `oms_order_return_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT 'return type',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT 'status：0->no；1->yes',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='return resson table';

-- ----------------------------
-- Records of oms_order_return_reason
-- ----------------------------
INSERT INTO `oms_order_return_reason` VALUES ('1', 'quality', '1', '0', '2018-10-17 10:00:45');
INSERT INTO `oms_order_return_reason` VALUES ('2', 'size', '1', '1', '2018-10-17 10:01:03');
INSERT INTO `oms_order_return_reason` VALUES ('3', 'color', '1', '1', '2018-10-17 10:01:13');
INSERT INTO `oms_order_return_reason` VALUES ('4', '14 days', '1', '1', '2018-10-17 10:01:47');
INSERT INTO `oms_order_return_reason` VALUES ('5', 'price', '1', '0', '2018-10-17 10:01:57');
INSERT INTO `oms_order_return_reason` VALUES ('12', 'receipt', '0', '1', '2018-10-19 16:28:36');
INSERT INTO `oms_order_return_reason` VALUES ('13', 'other', '0', '1', '2018-10-19 16:28:51');
INSERT INTO `oms_order_return_reason` VALUES ('14', 'mail', '0', '1', '2018-10-19 16:29:01');
INSERT INTO `oms_order_return_reason` VALUES ('15', 'customer service', '0', '1', '2018-10-19 16:29:11');

-- ----------------------------
-- Table structure for oms_order_setting
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_setting`;
CREATE TABLE `oms_order_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flash_order_overtime` int(11) DEFAULT NULL COMMENT 'spike order overtime ',
  `normal_order_overtime` int(11) DEFAULT NULL COMMENT 'normal order overtime',
  `confirm_overtime` int(11) DEFAULT NULL COMMENT 'shipped auto confirm received time',
  `finish_overtime` int(11) DEFAULT NULL COMMENT 'auto finish transaction, time before customer service',
  `comment_overtime` int(11) DEFAULT NULL COMMENT 'transaction done, time before auto good comment',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='order setting table';

-- ----------------------------
-- Records of oms_order_setting
-- ----------------------------
INSERT INTO `oms_order_setting` VALUES ('1', '60', '120', '15', '7', '7');

-- ----------------------------
-- Table structure for pms_album
-- ----------------------------
DROP TABLE IF EXISTS `pms_album`;
CREATE TABLE `pms_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `cover_pic` varchar(1000) DEFAULT NULL,
  `pic_count` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='album table';

-- ----------------------------
-- Records of pms_album
-- ----------------------------

-- ----------------------------
-- Table structure for pms_album_pic
-- ----------------------------
DROP TABLE IF EXISTS `pms_album_pic`;
CREATE TABLE `pms_album_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `album_id` bigint(20) DEFAULT NULL,
  `pic` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='album picture table';

-- ----------------------------
-- Records of pms_album_pic
-- ----------------------------

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT 'first leter',
  `sort` int(11) DEFAULT NULL,
  `factory_status` int(1) DEFAULT NULL COMMENT 'whether factory brand：0->no；1->yes',
  `show_status` int(1) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL COMMENT 'product count',
  `product_comment_count` int(11) DEFAULT NULL COMMENT 'product comment count',
  `logo` varchar(255) DEFAULT NULL COMMENT 'brand logo',
  `big_pic` varchar(255) DEFAULT NULL COMMENT 'brand big picture',
  `brand_story` text COMMENT 'brand story',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='brand table';

-- ----------------------------
-- Records of pms_brand
-- ----------------------------
INSERT INTO `pms_brand` VALUES ('1', 'Wang', 'W', '0', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(5).jpg', '', 'Victoria\'s Secret');
INSERT INTO `pms_brand` VALUES ('2', 'Samsung', 'S', '100', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (1).jpg', null, 'Samsung');
INSERT INTO `pms_brand` VALUES ('3', 'Huawei', 'H', '100', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/17f2dd9756d9d333bee8e60ce8c03e4c_222_222.jpg', null, 'Victoria\'s Secret');
INSERT INTO `pms_brand` VALUES ('4', 'Li', 'G', '30', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/dc794e7e74121272bbe3ce9bc41ec8c3_222_222.jpg', null, 'Victoria\'s Secret');
INSERT INTO `pms_brand` VALUES ('5', 'Tai', 'F', '20', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (4).jpg', null, 'Victoria\'s Secret');
INSERT INTO `pms_brand` VALUES ('6', 'Mi', 'M', '500', '1', '1', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/1e34aef2a409119018a4c6258e39ecfb_222_222.png', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180518/5afd7778Nf7800b75.jpg', 'Mi');
INSERT INTO `pms_brand` VALUES ('21', 'OPPO', 'O', '0', '1', '1', '88', '500', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(6).jpg', '', 'string');
INSERT INTO `pms_brand` VALUES ('49', 'BOOB', 'S', '200', '1', '1', '77', '400', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/18d8bc3eb13533fab466d702a0d3fd1f40345bcd.jpg', null, 'BOOB');
INSERT INTO `pms_brand` VALUES ('50', 'Hai', 'H', '200', '1', '1', '66', '300', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/99d3279f1029d32b929343b09d3c72de_222_222.jpg', '', 'BOOB');
INSERT INTO `pms_brand` VALUES ('51', 'Apple', 'A', '200', '1', '1', '55', '200', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, 'apple');
INSERT INTO `pms_brand` VALUES ('58', 'NIKE', 'N', '0', '1', '1', '33', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/timg (51).jpg', '', 'NIKE');

-- ----------------------------
-- Table structure for pms_comment
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment`;
CREATE TABLE `pms_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `star` int(3) DEFAULT NULL COMMENT 'comment star：0->5',
  `member_ip` varchar(64) DEFAULT NULL COMMENT 'comment ip',
  `create_time` datetime DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `product_attribute` varchar(255) DEFAULT NULL COMMENT 'product attribute',
  `collect_couont` int(11) DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `content` text,
  `pics` varchar(1000) DEFAULT NULL COMMENT 'upload pictures, separate with comma',
  `member_icon` varchar(255) DEFAULT NULL COMMENT 'comment member icon',
  `reply_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product comment table';

-- ----------------------------
-- Records of pms_comment
-- ----------------------------

-- ----------------------------
-- Table structure for pms_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment_reply`;
CREATE TABLE `pms_comment_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT 'comment user type；0->member；1->admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product comment reply table';

-- ----------------------------
-- Records of pms_comment_reply
-- ----------------------------

-- ----------------------------
-- Table structure for pms_freight_template
-- ----------------------------
DROP TABLE IF EXISTS `pms_freight_template`;
CREATE TABLE `pms_freight_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `charge_type` int(1) DEFAULT NULL COMMENT 'charge type:0->weight；1->quantity',
  `first_weight` decimal(10,2) DEFAULT NULL COMMENT 'first weight',
  `first_fee` decimal(10,2) DEFAULT NULL COMMENT 'first fee',
  `continue_weight` decimal(10,2) DEFAULT NULL,
  `continme_fee` decimal(10,2) DEFAULT NULL,
  `dest` varchar(255) DEFAULT NULL COMMENT 'destination',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='freight template';

-- ----------------------------
-- Records of pms_freight_template
-- ----------------------------

-- ----------------------------
-- Table structure for pms_member_price
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_price`;
CREATE TABLE `pms_member_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `member_level_id` bigint(20) DEFAULT NULL,
  `member_price` decimal(10,2) DEFAULT NULL COMMENT 'member price',
  `member_level_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COMMENT='product member price table';

-- ----------------------------
-- Records of pms_member_price
-- ----------------------------
INSERT INTO `pms_member_price` VALUES ('26', '7', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('27', '8', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('28', '9', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('29', '10', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('30', '11', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('31', '12', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('32', '13', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('33', '14', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('37', '18', '1', '500.00', null);
INSERT INTO `pms_member_price` VALUES ('44', '7', '2', '480.00', null);
INSERT INTO `pms_member_price` VALUES ('45', '7', '3', '450.00', null);
INSERT INTO `pms_member_price` VALUES ('52', '22', '1', null, null);
INSERT INTO `pms_member_price` VALUES ('53', '22', '2', null, null);
INSERT INTO `pms_member_price` VALUES ('54', '22', '3', null, null);
INSERT INTO `pms_member_price` VALUES ('58', '24', '1', null, null);
INSERT INTO `pms_member_price` VALUES ('59', '24', '2', null, null);
INSERT INTO `pms_member_price` VALUES ('60', '24', '3', null, null);
INSERT INTO `pms_member_price` VALUES ('112', '23', '1', '88.00', 'Gold');
INSERT INTO `pms_member_price` VALUES ('113', '23', '2', '88.00', 'Platimum');
INSERT INTO `pms_member_price` VALUES ('114', '23', '3', '66.00', 'Diamond');
INSERT INTO `pms_member_price` VALUES ('142', '31', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('143', '31', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('144', '31', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('148', '32', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('149', '32', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('150', '32', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('154', '33', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('155', '33', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('156', '33', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('169', '36', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('170', '36', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('171', '36', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('172', '35', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('173', '35', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('174', '35', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('175', '34', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('176', '34', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('177', '34', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('178', '30', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('179', '30', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('180', '30', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('186', '26', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('187', '26', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('188', '26', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('192', '27', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('193', '27', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('194', '27', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('195', '28', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('196', '28', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('197', '28', '3', null, 'Diamond');
INSERT INTO `pms_member_price` VALUES ('198', '29', '1', null, 'Gold');
INSERT INTO `pms_member_price` VALUES ('199', '29', '2', null, 'Platimum');
INSERT INTO `pms_member_price` VALUES ('200', '29', '3', null, 'Diamond');

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  `freight_template_id` bigint(20) DEFAULT NULL,
  `product_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT 'product number',
  `delete_status` int(1) DEFAULT NULL COMMENT 'delete status：0->no；1->yes',
  `publish_status` int(1) DEFAULT NULL COMMENT 'publish status：0->down；1->up',
  `new_status` int(1) DEFAULT NULL COMMENT 'new status:0->no；1->yes',
  `recommend_status` int(1) DEFAULT NULL COMMENT 'recommend status；0->no；1->yes',
  `verify_status` int(1) DEFAULT NULL COMMENT 'verify status：0->unverified；1->verified',
  `sort` int(11) DEFAULT NULL COMMENT 'sort',
  `sale` int(11) DEFAULT NULL COMMENT 'sale',
  `price` decimal(10,2) DEFAULT NULL,
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT 'promotion price',
  `gift_growth` int(11) DEFAULT '0' COMMENT 'gift growth',
  `gift_point` int(11) DEFAULT '0' COMMENT 'gift integration',
  `use_point_limit` int(11) DEFAULT NULL COMMENT 'integration use limit',
  `sub_title` varchar(255) DEFAULT NULL COMMENT 'subtitle',
  `description` text COMMENT 'productdescription',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT 'original price',
  `stock` int(11) DEFAULT NULL COMMENT 'stock',
  `low_stock` int(11) DEFAULT NULL COMMENT 'low stock',
  `unit` varchar(16) DEFAULT NULL COMMENT 'unit',
  `weight` decimal(10,2) DEFAULT NULL COMMENT 'product weight, default pound',
  `preview_status` int(1) DEFAULT NULL COMMENT 'whether pcomment product：0->no；1->yes',
  `service_ids` varchar(64) DEFAULT NULL COMMENT 'product service id, separate with comma：1->free return；2->refund；3->free shipping',
  `keywords` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `album_pics` varchar(255) DEFAULT NULL COMMENT 'album pictures, limit 5, separate with comma',
  `detail_title` varchar(255) DEFAULT NULL,
  `detail_desc` text,
  `detail_html` text COMMENT 'product detail in html',
  `detail_mobile_html` text COMMENT 'product detail in app html',
  `promotion_start_time` datetime DEFAULT NULL COMMENT 'promotion start time',
  `promotion_end_time` datetime DEFAULT NULL COMMENT 'promotion end time',
  `promotion_per_limit` int(11) DEFAULT NULL COMMENT 'promotion limit buying',
  `promotion_type` int(1) DEFAULT NULL COMMENT 'promotion type：0->original price;1->promotion price；2->member price；3->differential pricing；4->full reduction；5->limit time',
  `brand_name` varchar(255) DEFAULT NULL COMMENT 'brand name',
  `product_category_name` varchar(255) DEFAULT NULL COMMENT 'product category name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='product information';

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES ('1', '49', '7', '0', '0', 'Legging1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '1', '1', '1', '100', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging1', 'Legging', null, 'Legging', 'Legging', 'Legging', 'Legging', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('2', '49', '7', '0', '0', 'Legging2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86578', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging2', 'Legging', null, 'Legging', 'Legging', '<p>Legging</p>', '<p>Legging</p>', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('3', '1', '7', '0', '0', 'Legging3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86579', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging3', 'Legging', null, 'Legging', 'Legging', 'Legging', 'Legging', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('4', '1', '7', '0', '0', 'Legging4', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86580', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging4', 'Legging', null, 'Legging', 'Legging', 'Legging', 'Legging', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('5', '1', '7', '0', '0', 'Legging5', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86581', '1', '0', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging5', 'Legging', null, 'Legging', 'Legging', 'Legging', 'Legging', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('6', '1', '7', '0', '0', 'Legging6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86582', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', 'piece', '1000.00', '0', null, 'Legging6', 'Legging', null, 'Legging', 'Legging', 'Legging', 'Legging', null, null, null, '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('7', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('8', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('9', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('10', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('11', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('12', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('13', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('14', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('18', '1', '7', '0', '1', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', 'Sweater', 'Sweater', '299.00', '100', '0', 'piece', '0.00', '0', 'string', 'Sweater', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', 'Boob', 'outwear');
INSERT INTO `pms_product` VALUES ('22', '6', '7', '0', '1', 'test', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '', '1', '1', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'test', '', '0.00', '100', '0', '', '0.00', '1', '1,2', '', '', '', '', '', '', '', null, null, '0', '0', 'Mi', 'outwear');
INSERT INTO `pms_product` VALUES ('23', '6', '19', '0', '1', 'outwear', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 'NO.1098', '1', '1', '1', '1', '0', '0', '0', '99.00', null, '99', '99', '1000', 'Sweater', 'xxx', '109.00', '100', '0', 'piece', '1000.00', '1', '1,2,3', 'Sweater', 'Sweater', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 'outwear', 'outwear', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/155x54.bmp\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录bg1080.jpg\" width=\"500\" height=\"500\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录界面.jpg\" width=\"500\" height=\"500\" /></p>', '', null, null, '0', '2', 'Mi', 'Phone');
INSERT INTO `pms_product` VALUES ('24', '6', '7', '0', null, 'xxx', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'xxx', '', '0.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Mi', 'outwear');
INSERT INTO `pms_product` VALUES ('26', '3', '19', '0', '3', 'Huawei P20 ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '6946605', '0', '1', '1', '1', '0', '100', '0', '3788.00', null, '3788', '3788', '0', 'Phone', '', '4288.00', '1000', '0', '件', '0.00', '1', '2,3,1', '', '', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44f1cNf51f3bb0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa8Nfcf71c10.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa9N40e78ee0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f4N1c94bdda.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f5Nd30de41d.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5b10fb0eN0eb053fb.jpg\" /></p>', '', null, null, '0', '1', 'Huawei', 'Phone');
INSERT INTO `pms_product` VALUES ('27', '6', '19', '0', '3', 'Mi 8 ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '7437788', '0', '1', '1', '1', '0', '0', '0', '2699.00', null, '2699', '2699', '0', 'Phone', 'Phone', '2699.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b2254e8N414e6d3a.jpg\" width=\"500\" /></p>', '', null, null, '0', '3', 'Mi', 'Phone');
INSERT INTO `pms_product` VALUES ('28', '6', '19', '0', '3', 'Red Mi 5A', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '7437789', '0', '1', '1', '1', '0', '0', '0', '649.00', null, '649', '649', '0', 'Phone', '', '649.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '4', 'Mi', 'Phone');
INSERT INTO `pms_product` VALUES ('29', '51', '19', '0', '3', 'Apple iPhone 8 Plus 64GB', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', '7437799', '0', '1', '1', '0', '0', '0', '0', '5499.00', null, '5499', '5499', '0', 'Phone', '', '5499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Apple', 'Phone');
INSERT INTO `pms_product` VALUES ('30', '50', '8', '0', '1', 'T-Shirt', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 'HNTBJ2E042A', '0', '1', '1', '1', '0', '0', '0', '98.00', null, '0', '0', '0', 'Phone', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Family', 'T-Shirt');
INSERT INTO `pms_product` VALUES ('31', '50', '8', '0', '1', 'T-Shirt', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg', 'HNTBJ2E080A', '0', '1', '0', '0', '0', '0', '0', '98.00', null, '0', '0', '0', 'Phone', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Family', 'T-Shirt');
INSERT INTO `pms_product` VALUES ('32', '50', '8', '0', null, 'T-Shirt', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg', 'HNTBJ2E153A', '0', '1', '0', '0', '0', '0', '0', '68.00', null, '0', '0', '0', 'Phone', '', '68.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Family', 'T-Shirt');
INSERT INTO `pms_product` VALUES ('33', '6', '35', '0', null, 'Mi TV ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg', '4609652', '0', '1', '0', '0', '0', '0', '0', '2499.00', null, '0', '0', '0', 'Phone', '', '2499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Mi', 'Phone');
INSERT INTO `pms_product` VALUES ('34', '6', '35', '0', null, 'Mi TV', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg', '4609660', '0', '1', '0', '0', '0', '0', '0', '3999.00', null, '0', '0', '0', ' L65M5-AZ/L65M5-AD 2GB+8GB HDR ', '', '3999.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'Mi', 'Phone');
INSERT INTO `pms_product` VALUES ('35', '58', '29', '0', null, 'NIKE ROSHE RUN', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg', '6799342', '0', '1', '0', '0', '0', '0', '0', '369.00', null, '0', '0', '0', 'Nike', '', '369.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'NIKE', 'Shoe');
INSERT INTO `pms_product` VALUES ('36', '58', '29', '0', null, 'NIKE AIR MAX 90 ESSENTIAL', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '6799345', '0', '1', '1', '1', '0', '0', '0', '499.00', null, '0', '0', '0', 'Nike', '', '499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'NIKE', 'Shoe');

-- ----------------------------
-- Table structure for pms_product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `select_type` int(1) DEFAULT NULL COMMENT 'attribute select type：0->unique；1->single；2->multiple',
  `input_type` int(1) DEFAULT NULL COMMENT 'attribute input type：0->hand；1->from list',
  `input_list` varchar(255) DEFAULT NULL COMMENT 'input list, separate with comma',
  `sort` int(11) DEFAULT NULL COMMENT 'sort: the highest will able to upload picture',
  `filter_type` int(1) DEFAULT NULL COMMENT 'filter type：1->normal；1->color',
  `search_type` int(1) DEFAULT NULL COMMENT 'search type；0->no；1->keyword search；2->range search',
  `related_status` int(1) DEFAULT NULL COMMENT 'whether same attribute product related；0->no；1->yes',
  `hand_add_status` int(1) DEFAULT NULL COMMENT 'whether support hand add；0->no；1->yes',
  `type` int(1) DEFAULT NULL COMMENT 'attribute type；0->specification；1->parameter',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='product attribute parameter table';

-- ----------------------------
-- Records of pms_product_attribute
-- ----------------------------
INSERT INTO `pms_product_attribute` VALUES ('1', '1', 'size', '2', '1', 'S,M,X,XL,2XL,3XL,4XL', '0', '0', '0', '0', '0', '0');
INSERT INTO `pms_product_attribute` VALUES ('7', '1', 'color', '2', '1', 'Black,Red,Blue,Pink', '100', '0', '0', '0', '1', '0');
INSERT INTO `pms_product_attribute` VALUES ('13', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('14', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('15', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('16', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('17', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('18', '0', 'year', '1', '1', '2013,2014,2015,2016,2017', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('19', '0', 'people', '1', '1', 'Young Female,Old Female', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('20', '0', 'target', '2', '1', 'Young Female,Old Female', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('21', '0', 'target', '2', '1', 'Young Female,Old Female', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('24', '1', 'product#', '1', '0', '', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('25', '1', 'season', '1', '1', 'spring,summer,fall,winter', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('32', '2', 'target', '0', '1', 'kid,young,old', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('33', '2', 'style', '0', '1', 'business,hiphop,classic', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('35', '2', 'color', '0', '0', '', '100', '0', '0', '0', '1', '0');
INSERT INTO `pms_product_attribute` VALUES ('37', '1', 'target', '1', '1', 'kid,young,old', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('38', '1', 'year', '1', '1', '2017,2017,2018,2018', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('39', '1', 'sleeve', '1', '1', 'short,long', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('40', '2', 'size', '0', '1', '29,30,31,32,33,34', '0', '0', '0', '0', '0', '0');
INSERT INTO `pms_product_attribute` VALUES ('41', '2', 'place', '0', '1', 'house,gym,business', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('42', '2', 'year', '0', '1', '2018,2018', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('43', '3', 'color', '0', '0', '', '100', '0', '0', '0', '1', '0');
INSERT INTO `pms_product_attribute` VALUES ('44', '3', 'capacity', '0', '1', '16G,32G,64G,128G', '0', '0', '0', '0', '0', '0');
INSERT INTO `pms_product_attribute` VALUES ('45', '3', 'screen_size', '0', '0', '', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('46', '3', 'internet', '0', '1', '3G,4G', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('47', '3', 'os', '0', '1', 'Android,IOS', '0', '0', '0', '0', '0', '1');
INSERT INTO `pms_product_attribute` VALUES ('48', '3', 'battery_capacity', '0', '0', '', '0', '0', '0', '0', '0', '1');

-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `attribute_count` int(11) DEFAULT '0' COMMENT 'attribute count',
  `param_count` int(11) DEFAULT '0' COMMENT 'parameter count',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='product attribute category table';

-- ----------------------------
-- Records of pms_product_attribute_category
-- ----------------------------
INSERT INTO `pms_product_attribute_category` VALUES ('1', 'clothing_t-shirt', '2', '5');
INSERT INTO `pms_product_attribute_category` VALUES ('2', 'clothing_pant', '2', '4');
INSERT INTO `pms_product_attribute_category` VALUES ('3', 'mobile-digital_mobile-phone', '2', '4');
INSERT INTO `pms_product_attribute_category` VALUES ('4', 'accessories', '0', '0');
INSERT INTO `pms_product_attribute_category` VALUES ('5', 'house', '0', '0');
INSERT INTO `pms_product_attribute_category` VALUES ('6', 'clean', '0', '0');
INSERT INTO `pms_product_attribute_category` VALUES ('10', 'test', '0', '0');

-- ----------------------------
-- Table structure for pms_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_attribute_id` bigint(20) DEFAULT NULL,
  `value` varchar(64) DEFAULT NULL COMMENT 'hand add specification or parameter value, parameter single value, separate with comma when multiple specification',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 COMMENT='product parameter info table';

-- ----------------------------
-- Records of pms_product_attribute_value
-- ----------------------------
INSERT INTO `pms_product_attribute_value` VALUES ('1', '9', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('2', '10', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('3', '11', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('4', '12', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('5', '13', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('6', '14', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('7', '18', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('8', '7', '1', 'X');
INSERT INTO `pms_product_attribute_value` VALUES ('9', '7', '1', 'XL');
INSERT INTO `pms_product_attribute_value` VALUES ('10', '7', '1', 'XXL');
INSERT INTO `pms_product_attribute_value` VALUES ('11', '22', '7', 'x,xx');
INSERT INTO `pms_product_attribute_value` VALUES ('12', '22', '24', 'no110');
INSERT INTO `pms_product_attribute_value` VALUES ('13', '22', '25', 'spring');
INSERT INTO `pms_product_attribute_value` VALUES ('14', '22', '37', 'young');
INSERT INTO `pms_product_attribute_value` VALUES ('15', '22', '38', '2018');
INSERT INTO `pms_product_attribute_value` VALUES ('16', '22', '39', 'long');
INSERT INTO `pms_product_attribute_value` VALUES ('124', '23', '7', 'white,yellow');
INSERT INTO `pms_product_attribute_value` VALUES ('125', '23', '24', 'no1098');
INSERT INTO `pms_product_attribute_value` VALUES ('126', '23', '25', 'spring');
INSERT INTO `pms_product_attribute_value` VALUES ('127', '23', '37', 'young');
INSERT INTO `pms_product_attribute_value` VALUES ('128', '23', '38', '2018');
INSERT INTO `pms_product_attribute_value` VALUES ('129', '23', '39', 'long');
INSERT INTO `pms_product_attribute_value` VALUES ('130', '1', '13', null);
INSERT INTO `pms_product_attribute_value` VALUES ('131', '1', '14', null);
INSERT INTO `pms_product_attribute_value` VALUES ('132', '1', '15', null);
INSERT INTO `pms_product_attribute_value` VALUES ('133', '1', '16', null);
INSERT INTO `pms_product_attribute_value` VALUES ('134', '1', '17', null);
INSERT INTO `pms_product_attribute_value` VALUES ('135', '1', '18', null);
INSERT INTO `pms_product_attribute_value` VALUES ('136', '1', '19', null);
INSERT INTO `pms_product_attribute_value` VALUES ('137', '1', '20', null);
INSERT INTO `pms_product_attribute_value` VALUES ('138', '1', '21', null);
INSERT INTO `pms_product_attribute_value` VALUES ('139', '2', '13', null);
INSERT INTO `pms_product_attribute_value` VALUES ('140', '2', '14', null);
INSERT INTO `pms_product_attribute_value` VALUES ('141', '2', '15', null);
INSERT INTO `pms_product_attribute_value` VALUES ('142', '2', '16', null);
INSERT INTO `pms_product_attribute_value` VALUES ('143', '2', '17', null);
INSERT INTO `pms_product_attribute_value` VALUES ('144', '2', '18', null);
INSERT INTO `pms_product_attribute_value` VALUES ('145', '2', '19', null);
INSERT INTO `pms_product_attribute_value` VALUES ('146', '2', '20', null);
INSERT INTO `pms_product_attribute_value` VALUES ('147', '2', '21', null);
INSERT INTO `pms_product_attribute_value` VALUES ('183', '31', '24', null);
INSERT INTO `pms_product_attribute_value` VALUES ('184', '31', '25', 'summer');
INSERT INTO `pms_product_attribute_value` VALUES ('185', '31', '37', 'young');
INSERT INTO `pms_product_attribute_value` VALUES ('186', '31', '38', '2018');
INSERT INTO `pms_product_attribute_value` VALUES ('187', '31', '39', 'short');
INSERT INTO `pms_product_attribute_value` VALUES ('198', '30', '24', null);
INSERT INTO `pms_product_attribute_value` VALUES ('199', '30', '25', 'summer');
INSERT INTO `pms_product_attribute_value` VALUES ('200', '30', '37', 'young');
INSERT INTO `pms_product_attribute_value` VALUES ('201', '30', '38', '2018');
INSERT INTO `pms_product_attribute_value` VALUES ('202', '30', '39', 'short');
INSERT INTO `pms_product_attribute_value` VALUES ('203', '26', '43', 'golden,silver');
INSERT INTO `pms_product_attribute_value` VALUES ('204', '26', '45', '5.0');
INSERT INTO `pms_product_attribute_value` VALUES ('205', '26', '46', '4G');
INSERT INTO `pms_product_attribute_value` VALUES ('206', '26', '47', 'Android');
INSERT INTO `pms_product_attribute_value` VALUES ('207', '26', '48', '3000');
INSERT INTO `pms_product_attribute_value` VALUES ('213', '27', '43', 'black,blue');
INSERT INTO `pms_product_attribute_value` VALUES ('214', '27', '45', '5.8');
INSERT INTO `pms_product_attribute_value` VALUES ('215', '27', '46', '4G');
INSERT INTO `pms_product_attribute_value` VALUES ('216', '27', '47', 'Android');
INSERT INTO `pms_product_attribute_value` VALUES ('217', '27', '48', '3000ml');
INSERT INTO `pms_product_attribute_value` VALUES ('218', '28', '43', 'golden,silver');
INSERT INTO `pms_product_attribute_value` VALUES ('219', '28', '45', '5.0');
INSERT INTO `pms_product_attribute_value` VALUES ('220', '28', '46', '4G');
INSERT INTO `pms_product_attribute_value` VALUES ('221', '28', '47', 'Android');
INSERT INTO `pms_product_attribute_value` VALUES ('222', '28', '48', '2800ml');
INSERT INTO `pms_product_attribute_value` VALUES ('223', '29', '43', 'golden,silver');
INSERT INTO `pms_product_attribute_value` VALUES ('224', '29', '45', '4.7');
INSERT INTO `pms_product_attribute_value` VALUES ('225', '29', '46', '4G');
INSERT INTO `pms_product_attribute_value` VALUES ('226', '29', '47', 'IOS');
INSERT INTO `pms_product_attribute_value` VALUES ('227', '29', '48', '1960ml');

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT 'parent category id：0 means the very first category',
  `name` varchar(64) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT 'category level：0->1；1->2',
  `product_count` int(11) DEFAULT NULL,
  `product_unit` varchar(64) DEFAULT NULL,
  `nav_status` int(1) DEFAULT NULL COMMENT 'whether in the nav：0->no；1->yes',
  `show_status` int(1) DEFAULT NULL COMMENT 'display status：0->no；1->yes',
  `sort` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL COMMENT 'icon',
  `keywords` varchar(255) DEFAULT NULL,
  `description` text COMMENT 'description',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='product category';

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES ('1', '0', 'clothing', '0', '100', 'piece', '1', '1', '1', null, 'clothing', 'clothing');
INSERT INTO `pms_product_category` VALUES ('2', '0', 'mobile-digital', '0', '100', 'piece', '1', '1', '1', null, 'mobile-digital', 'mobile-digital');
INSERT INTO `pms_product_category` VALUES ('3', '0', 'electronic', '0', '100', 'piece', '1', '1', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_jiadian.png', 'electronic', 'electronic');
INSERT INTO `pms_product_category` VALUES ('4', '0', 'furniture', '0', '100', 'piece', '1', '1', '1', null, 'furniture', 'furniture');
INSERT INTO `pms_product_category` VALUES ('5', '0', 'car', '0', '100', 'piece', '1', '1', '1', null, 'car', 'car');
INSERT INTO `pms_product_category` VALUES ('7', '1', 'outwear', '1', '100', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_waitao.png', 'outwear', 'outwear');
INSERT INTO `pms_product_category` VALUES ('8', '1', 't-shirt', '1', '100', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_tshirt.png', 't-shirt', 't-shirt');
INSERT INTO `pms_product_category` VALUES ('9', '1', 'pant', '1', '100', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_xiuxianku.png', 'pant', 'pant');
INSERT INTO `pms_product_category` VALUES ('10', '1', 'jean', '1', '100', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_niuzaiku.png', 'jean', 'jean');
INSERT INTO `pms_product_category` VALUES ('11', '1', 'shirt', '1', '100', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_chenshan.png', 'shirt', 'shirt');
INSERT INTO `pms_product_category` VALUES ('13', '12', 'electronic', '1', '1', 'string', '0', '1', '0', 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES ('14', '12', 'electronic', '1', '1', 'string', '0', '1', '0', 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES ('19', '2', 'mobile-phone', '1', '0', 'piece', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_shouji.png', 'mobile-phone', 'mobile-phone');
INSERT INTO `pms_product_category` VALUES ('29', '1', 'male-shoe', '1', '0', '', '0', '0', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_xie.png', '', '');
INSERT INTO `pms_product_category` VALUES ('30', '2', 'phone-accessory', '1', '0', '', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_peijian.png', 'phone-accessory', 'phone-accessory');
INSERT INTO `pms_product_category` VALUES ('31', '2', 'camera', '1', '0', '', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_sheying.png', '', '');
INSERT INTO `pms_product_category` VALUES ('32', '2', 'film', '1', '0', '', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_yule.png', '', '');
INSERT INTO `pms_product_category` VALUES ('33', '2', 'electronic', '1', '0', '', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_yule.png', '', '');
INSERT INTO `pms_product_category` VALUES ('34', '2', 'electronic', '1', '0', '', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_zhineng.png', '', '');
INSERT INTO `pms_product_category` VALUES ('35', '3', 'tv', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('36', '3', 'air-conditioner', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('37', '3', 'laundry', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('38', '3', 'refridge', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('39', '3', 'living-electronic', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('40', '3', 'living-electronic', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('41', '3', 'living-electronic', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('42', '3', 'personal-care', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('43', '4', 'kitchen', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('44', '4', 'light', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('45', '4', 'Hardware', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('46', '4', 'furniture', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('47', '4', 'furniture', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('48', '5', 'car', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('49', '5', 'car', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('50', '5', 'car', '1', '0', '', '1', '1', '0', '', '', '');
INSERT INTO `pms_product_category` VALUES ('51', '5', 'car', '1', '0', '', '1', '1', '0', '', '', '');

-- ----------------------------
-- Table structure for pms_product_category_attribute_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category_attribute_relation`;
CREATE TABLE `pms_product_category_attribute_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` bigint(20) DEFAULT NULL,
  `product_attribute_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='product category and attribute relation, used to set category filter, only support level one category';

-- ----------------------------
-- Records of pms_product_category_attribute_relation
-- ----------------------------
INSERT INTO `pms_product_category_attribute_relation` VALUES ('1', '24', '24');
INSERT INTO `pms_product_category_attribute_relation` VALUES ('5', '26', '24');
INSERT INTO `pms_product_category_attribute_relation` VALUES ('7', '28', '24');
INSERT INTO `pms_product_category_attribute_relation` VALUES ('9', '25', '24');
INSERT INTO `pms_product_category_attribute_relation` VALUES ('10', '25', '25');

-- ----------------------------
-- Table structure for pms_product_full_reduction
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_full_reduction`;
CREATE TABLE `pms_product_full_reduction` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `full_price` decimal(10,2) DEFAULT NULL,
  `reduce_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='full reduction, only support same product';

-- ----------------------------
-- Records of pms_product_full_reduction
-- ----------------------------
INSERT INTO `pms_product_full_reduction` VALUES ('1', '7', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('2', '8', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('3', '9', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('4', '10', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('5', '11', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('6', '12', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('7', '13', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('8', '14', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('9', '18', '100.00', '20.00');
INSERT INTO `pms_product_full_reduction` VALUES ('10', '7', '200.00', '50.00');
INSERT INTO `pms_product_full_reduction` VALUES ('11', '7', '300.00', '100.00');
INSERT INTO `pms_product_full_reduction` VALUES ('14', '22', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('16', '24', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('34', '23', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('44', '31', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('46', '32', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('48', '33', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('53', '36', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('54', '35', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('55', '34', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('56', '30', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('57', '26', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('59', '27', '0.00', '0.00');
INSERT INTO `pms_product_full_reduction` VALUES ('60', '28', '500.00', '50.00');
INSERT INTO `pms_product_full_reduction` VALUES ('61', '28', '1000.00', '120.00');
INSERT INTO `pms_product_full_reduction` VALUES ('62', '29', '0.00', '0.00');

-- ----------------------------
-- Table structure for pms_product_ladder
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_ladder`;
CREATE TABLE `pms_product_ladder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT 'ladder product count',
  `discount` decimal(10,2) DEFAULT NULL COMMENT 'discount',
  `price` decimal(10,2) DEFAULT NULL COMMENT 'final price',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='product ladder price table(only for same product)';

-- ----------------------------
-- Records of pms_product_ladder
-- ----------------------------
INSERT INTO `pms_product_ladder` VALUES ('1', '7', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('2', '8', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('3', '9', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('4', '10', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('5', '11', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('6', '12', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('7', '13', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('8', '14', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('12', '18', '3', '0.70', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('14', '7', '4', '0.60', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('15', '7', '5', '0.50', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('18', '22', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('20', '24', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('38', '23', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('48', '31', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('50', '32', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('52', '33', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('57', '36', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('58', '35', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('59', '34', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('60', '30', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('61', '26', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('64', '27', '2', '0.80', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('65', '27', '3', '0.75', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('66', '28', '0', '0.00', '0.00');
INSERT INTO `pms_product_ladder` VALUES ('67', '29', '0', '0.00', '0.00');

-- ----------------------------
-- Table structure for pms_product_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_operate_log`;
CREATE TABLE `pms_product_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `price_old` decimal(10,2) DEFAULT NULL,
  `price_new` decimal(10,2) DEFAULT NULL,
  `sale_price_old` decimal(10,2) DEFAULT NULL,
  `sale_price_new` decimal(10,2) DEFAULT NULL,
  `gift_point_old` int(11) DEFAULT NULL COMMENT 'gift integration',
  `gift_point_new` int(11) DEFAULT NULL,
  `use_point_limit_old` int(11) DEFAULT NULL,
  `use_point_limit_new` int(11) DEFAULT NULL,
  `operate_man` varchar(64) DEFAULT NULL COMMENT 'operator',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for pms_product_verify_record
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_verify_record`;
CREATE TABLE `pms_product_verify_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `verify_man` varchar(64) DEFAULT NULL COMMENT 'verify staff',
  `status` int(1) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL COMMENT 'detail for verify',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='product verify record';

-- ----------------------------
-- Records of pms_product_verify_record
-- ----------------------------
INSERT INTO `pms_product_verify_record` VALUES ('1', '1', '2018-04-27 16:36:41', 'test', '1', 'pass');
INSERT INTO `pms_product_verify_record` VALUES ('2', '2', '2018-04-27 16:36:41', 'test', '1', 'pass');

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `sku_code` varchar(64) NOT NULL COMMENT 'sku code',
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT '0' COMMENT 'stock',
  `low_stock` int(11) DEFAULT NULL COMMENT 'low stock',
  `sp1` varchar(64) DEFAULT NULL COMMENT 'sale properties1',
  `sp2` varchar(64) DEFAULT NULL,
  `sp3` varchar(64) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL COMMENT 'display picture',
  `sale` int(11) DEFAULT NULL COMMENT 'sale',
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT 'single promotion price',
  `lock_stock` int(11) DEFAULT '0' COMMENT 'lock stock',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='sku stock';

-- ----------------------------
-- Records of pms_sku_stock
-- ----------------------------
INSERT INTO `pms_sku_stock` VALUES ('1', '7', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('2', '8', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('3', '9', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('4', '10', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('5', '11', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('6', '12', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('7', '13', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('8', '14', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('9', '18', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('10', '7', 'string', '0.00', '0', '0', 'string', 'string', 'sp3', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('11', '7', 'string', '0.00', '0', '0', 'string', 'string', 'sp33', 'string', '0', null, '0');
INSERT INTO `pms_sku_stock` VALUES ('12', '22', '111', '99.00', '0', null, 'x', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('13', '22', '112', '99.00', '0', null, 'xx', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2018032614134591_20180326141345650 (4).png', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('78', '23', '201806070023001', '99.00', '0', null, 'white', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('79', '23', '201806070023002', '99.00', '0', null, 'white', 'X', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('80', '23', '201806070023003', '99.00', '0', null, 'yellow', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('81', '23', '201806070023004', '99.00', '0', null, 'yellow', 'X', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('90', '26', '201806070026001', '3788.00', '499', null, 'golden', '16G', null, null, null, '3588.00', '-8');
INSERT INTO `pms_sku_stock` VALUES ('91', '26', '201806070026002', '3999.00', '500', null, 'golden', '32G', null, null, null, '3799.00', '0');
INSERT INTO `pms_sku_stock` VALUES ('92', '26', '201806070026003', '3788.00', '500', null, 'silver', '16G', null, null, null, '3588.00', '0');
INSERT INTO `pms_sku_stock` VALUES ('93', '26', '201806070026004', '3999.00', '500', null, 'silver', '32G', null, null, null, '3799.00', '0');
INSERT INTO `pms_sku_stock` VALUES ('98', '27', '201808270027001', '2699.00', '97', null, 'black', '32G', null, null, null, null, '-24');
INSERT INTO `pms_sku_stock` VALUES ('99', '27', '201808270027002', '2999.00', '100', null, 'black', '64G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('100', '27', '201808270027003', '2699.00', '100', null, 'blue', '32G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('101', '27', '201808270027004', '2999.00', '100', null, 'blue', '64G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('102', '28', '201808270028001', '649.00', '99', null, 'golden', '16G', null, null, null, null, '-8');
INSERT INTO `pms_sku_stock` VALUES ('103', '28', '201808270028002', '699.00', '99', null, 'golden', '32G', null, null, null, null, '-8');
INSERT INTO `pms_sku_stock` VALUES ('104', '28', '201808270028003', '649.00', '100', null, 'silver', '16G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('105', '28', '201808270028004', '699.00', '100', null, 'silver', '32G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('106', '29', '201808270029001', '5499.00', '99', null, 'golden', '32G', null, null, null, null, '-8');
INSERT INTO `pms_sku_stock` VALUES ('107', '29', '201808270029002', '6299.00', '100', null, 'golden', '64G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('108', '29', '201808270029003', '5499.00', '100', null, 'silver', '32G', null, null, null, null, '0');
INSERT INTO `pms_sku_stock` VALUES ('109', '29', '201808270029004', '6299.00', '100', null, 'silver', '64G', null, null, null, null, '0');

-- ----------------------------
-- Table structure for sms_coupon
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon`;
CREATE TABLE `sms_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(1) DEFAULT NULL COMMENT 'coupon type；0->all coupon；1->member coupon；2->shopping coupon；3->register coupon',
  `name` varchar(100) DEFAULT NULL,
  `platform` int(1) DEFAULT NULL COMMENT 'platform：0->all；1->mobile；2->PC',
  `count` int(11) DEFAULT NULL COMMENT 'count',
  `amount` decimal(10,2) DEFAULT NULL COMMENT 'amount',
  `per_limit` int(11) DEFAULT NULL COMMENT 'limit',
  `min_point` decimal(10,2) DEFAULT NULL COMMENT 'min integration need to use, 0 means no min',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `use_type` int(1) DEFAULT NULL COMMENT 'use type：0->all use；1->specific category；2->specific product',
  `note` varchar(200) DEFAULT NULL COMMENT 'note',
  `publish_count` int(11) DEFAULT NULL COMMENT 'publish count ',
  `use_count` int(11) DEFAULT NULL COMMENT 'used count',
  `receive_count` int(11) DEFAULT NULL COMMENT 'receive count',
  `enable_time` datetime DEFAULT NULL COMMENT 'enable time',
  `code` varchar(64) DEFAULT NULL COMMENT 'code',
  `member_level` int(1) DEFAULT NULL COMMENT 'member type：0->no limit',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='coupon table';

-- ----------------------------
-- Records of sms_coupon
-- ----------------------------
INSERT INTO `sms_coupon` VALUES ('2', '0', 'all-coupon', '0', '92', '10.00', '1', '100.00', '2018-08-27 16:40:47', '2018-11-23 16:40:47', '0', '10 off', '100', '0', '8', '2018-08-27 16:40:47', null, null);
INSERT INTO `sms_coupon` VALUES ('3', '0', 'mi-coupon', '0', '92', '50.00', '1', '1000.00', '2018-08-27 16:40:47', '2018-11-16 16:40:47', '2', 'mi-coupon', '100', '0', '8', '2018-08-27 16:40:47', null, null);
INSERT INTO `sms_coupon` VALUES ('4', '0', 'mobile-coupon', '0', '92', '300.00', '1', '2000.00', '2018-08-27 16:40:47', '2018-09-15 16:40:47', '1', 'mobile-coupon', '100', '0', '8', '2018-08-27 16:40:47', null, null);
INSERT INTO `sms_coupon` VALUES ('7', '0', 'tshirt-coupon', '0', '93', '50.00', '1', '500.00', '2018-08-27 16:40:47', '2018-08-15 16:40:47', '1', '50 off', '100', '0', '7', '2018-08-27 16:40:47', null, null);
INSERT INTO `sms_coupon` VALUES ('8', '0', 'new-coupon', '0', '100', '100.00', '1', '1000.00', '2018-11-08 00:00:00', '2018-11-27 00:00:00', '0', 'test', '100', '0', '1', null, null, null);
INSERT INTO `sms_coupon` VALUES ('9', '0', 'all-coupon', '0', '100', '5.00', '1', '100.00', '2018-11-08 00:00:00', '2018-11-10 00:00:00', '0', null, '100', '0', '1', null, null, null);
INSERT INTO `sms_coupon` VALUES ('10', '0', 'all-coupon', '0', '100', '15.00', '1', '200.00', '2018-11-08 00:00:00', '2018-11-10 00:00:00', '0', null, '100', '0', '1', null, null, null);
INSERT INTO `sms_coupon` VALUES ('11', '0', 'all-coupon', '0', '1000', '50.00', '1', '1000.00', '2018-11-08 00:00:00', '2018-11-10 00:00:00', '0', null, '1000', '0', '0', null, null, null);
INSERT INTO `sms_coupon` VALUES ('12', '0', 'mobile-all-coupon', '1', '1', '10.00', '1', '100.00', '2018-11-08 00:00:00', '2018-11-10 00:00:00', '0', null, '100', '0', '0', null, null, null);
INSERT INTO `sms_coupon` VALUES ('19', '0', 'phone-coupon', '0', '100', '100.00', '1', '1000.00', '2018-11-09 00:00:00', '2018-11-17 00:00:00', '1', 'phone-coupon', '100', '0', '0', null, null, null);
INSERT INTO `sms_coupon` VALUES ('20', '0', 'mi-coupon', '0', '100', '200.00', '1', '1000.00', '2018-11-09 00:00:00', '2018-11-24 00:00:00', '2', 'mi-coupon', '100', '0', '0', null, null, null);
INSERT INTO `sms_coupon` VALUES ('21', '0', 'xxx', '0', '100', '10.00', '1', '100.00', '2018-11-09 00:00:00', '2018-11-30 00:00:00', '2', null, '100', '0', '0', null, null, null);

-- ----------------------------
-- Table structure for sms_coupon_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_history`;
CREATE TABLE `sms_coupon_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `coupon_code` varchar(64) DEFAULT NULL,
  `member_nickname` varchar(64) DEFAULT NULL COMMENT 'receiver nickname',
  `get_type` int(1) DEFAULT NULL COMMENT 'get type：0->system send；1->active acquisition',
  `create_time` datetime DEFAULT NULL,
  `use_status` int(1) DEFAULT NULL COMMENT 'use status：0->unused；1->used；2->expired',
  `use_time` datetime DEFAULT NULL COMMENT 'use time',
  `order_id` bigint(20) DEFAULT NULL COMMENT 'order number',
  `order_sn` varchar(100) DEFAULT NULL COMMENT 'order number',
  PRIMARY KEY (`id`),
  KEY `idx_member_id` (`member_id`) USING BTREE,
  KEY `idx_coupon_id` (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='coupon use and history table';

-- ----------------------------
-- Records of sms_coupon_history
-- ----------------------------
INSERT INTO `sms_coupon_history` VALUES ('2', '2', '1', '4931048380330002', 'windir', '1', '2018-08-29 14:04:12', '0', '2019-03-21 15:03:40', '12', '201809150101000001');
INSERT INTO `sms_coupon_history` VALUES ('3', '3', '1', '4931048380330003', 'windir', '1', '2018-08-29 14:04:29', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('4', '4', '1', '4931048380330004', 'windir', '1', '2018-08-29 14:04:32', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('11', '7', '1', '4931048380330001', 'windir', '1', '2018-09-04 16:21:50', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('12', '2', '4', '0340981248320004', 'zhensan', '1', '2018-11-12 14:16:50', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('13', '3', '4', '0342977234360004', 'zhensan', '1', '2018-11-12 14:17:10', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('14', '4', '4', '0343342928830004', 'zhensan', '1', '2018-11-12 14:17:13', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('15', '2', '5', '0351883832180005', 'lisi', '1', '2018-11-12 14:18:39', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('16', '3', '5', '0352201672680005', 'lisi', '1', '2018-11-12 14:18:42', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('17', '4', '5', '0352505810180005', 'lisi', '1', '2018-11-12 14:18:45', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('18', '2', '6', '0356114588380006', 'wangwu', '1', '2018-11-12 14:19:21', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('19', '3', '6', '0356382856920006', 'wangwu', '1', '2018-11-12 14:19:24', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('20', '4', '6', '0356656798470006', 'wangwu', '1', '2018-11-12 14:19:27', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('21', '2', '3', '0363644984620003', 'windy', '1', '2018-11-12 14:20:36', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('22', '3', '3', '0363932820300003', 'windy', '1', '2018-11-12 14:20:39', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('23', '4', '3', '0364238275840003', 'windy', '1', '2018-11-12 14:20:42', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('24', '2', '7', '0385034833070007', 'lion', '1', '2018-11-12 14:24:10', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('25', '3', '7', '0385350208650007', 'lion', '1', '2018-11-12 14:24:13', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('26', '4', '7', '0385632733900007', 'lion', '1', '2018-11-12 14:24:16', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('27', '2', '8', '0388779132990008', 'shari', '1', '2018-11-12 14:24:48', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('28', '3', '8', '0388943658810008', 'shari', '1', '2018-11-12 14:24:49', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('29', '4', '8', '0389069398320008', 'shari', '1', '2018-11-12 14:24:51', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('30', '2', '9', '0390753935250009', 'aewen', '1', '2018-11-12 14:25:08', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('31', '3', '9', '0390882954470009', 'aewen', '1', '2018-11-12 14:25:09', '0', null, null, null);
INSERT INTO `sms_coupon_history` VALUES ('32', '4', '9', '0391025542810009', 'aewen', '1', '2018-11-12 14:25:10', '0', null, null, null);

-- ----------------------------
-- Table structure for sms_coupon_product_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_category_relation`;
CREATE TABLE `sms_coupon_product_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  `product_category_name` varchar(200) DEFAULT NULL COMMENT 'product category name',
  `parent_category_name` varchar(200) DEFAULT NULL COMMENT 'parent category name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='coupon and product category relation';

-- ----------------------------
-- Records of sms_coupon_product_category_relation
-- ----------------------------
INSERT INTO `sms_coupon_product_category_relation` VALUES ('4', '19', '30', 'phone-accessory', 'electornic');

-- ----------------------------
-- Table structure for sms_coupon_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_relation`;
CREATE TABLE `sms_coupon_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(500) DEFAULT NULL COMMENT 'product names',
  `product_sn` varchar(200) DEFAULT NULL COMMENT 'product number',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='product and coupon relation';

-- ----------------------------
-- Records of sms_coupon_product_relation
-- ----------------------------
INSERT INTO `sms_coupon_product_relation` VALUES ('9', '21', '33', 'Mi TV 4A ', '4609652');

-- ----------------------------
-- Table structure for sms_flash_promotion
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion`;
CREATE TABLE `sms_flash_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `start_date` date DEFAULT NULL COMMENT 'start date',
  `end_date` date DEFAULT NULL COMMENT 'end date',
  `status` int(1) DEFAULT NULL COMMENT 'status',
  `create_time` datetime DEFAULT NULL COMMENT 'flash create time ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='flash promotion table';

-- ----------------------------
-- Records of sms_flash_promotion
-- ----------------------------
INSERT INTO `sms_flash_promotion` VALUES ('2', 'Forniture1', '2019-01-28', '2019-01-15', '0', '2018-11-16 11:12:13');
INSERT INTO `sms_flash_promotion` VALUES ('3', 'test', '2018-11-03', '2019-02-28', '1', '2018-11-16 11:11:31');
INSERT INTO `sms_flash_promotion` VALUES ('4', 'Forniture1', '2018-11-24', '2018-11-25', '0', '2018-11-16 11:12:19');
INSERT INTO `sms_flash_promotion` VALUES ('5', 'Forniture1', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:24');
INSERT INTO `sms_flash_promotion` VALUES ('6', 'Forniture1', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:31');
INSERT INTO `sms_flash_promotion` VALUES ('7', 'Forniture1', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:35');
INSERT INTO `sms_flash_promotion` VALUES ('8', 'Forniture1', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:39');
INSERT INTO `sms_flash_promotion` VALUES ('9', 'Forniture1', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:42');
INSERT INTO `sms_flash_promotion` VALUES ('13', 'test', '2018-11-01', '2018-11-30', '0', '2018-11-19 10:34:24');

-- ----------------------------
-- Table structure for sms_flash_promotion_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_log`;
CREATE TABLE `sms_flash_promotion_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `member_phone` varchar(64) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `subscribe_time` datetime DEFAULT NULL COMMENT 'member subscribe time',
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='flash promotion log';

-- ----------------------------
-- Records of sms_flash_promotion_log
-- ----------------------------

-- ----------------------------
-- Table structure for sms_flash_promotion_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_product_relation`;
CREATE TABLE `sms_flash_promotion_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `flash_promotion_id` bigint(20) DEFAULT NULL,
  `flash_promotion_session_id` bigint(20) DEFAULT NULL COMMENT 'id',
  `product_id` bigint(20) DEFAULT NULL,
  `flash_promotion_price` decimal(10,2) DEFAULT NULL COMMENT 'limit time price',
  `flash_promotion_count` int(11) DEFAULT NULL COMMENT 'limit time count',
  `flash_promotion_limit` int(11) DEFAULT NULL COMMENT 'limit count',
  `sort` int(11) DEFAULT NULL COMMENT 'sort',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='productlimit time and product relation table';

-- ----------------------------
-- Records of sms_flash_promotion_product_relation
-- ----------------------------
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('1', '2', '1', '26', '3000.00', '10', '1', '0');
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('2', '2', '1', '27', '2000.00', '10', '1', '20');
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('3', '2', '1', '28', '599.00', '19', '1', '0');
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('4', '2', '1', '29', '4999.00', '10', '1', '100');
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('9', '2', '2', '26', '2999.00', '100', '1', '0');
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('10', '2', '2', '27', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('11', '2', '2', '28', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('12', '2', '2', '29', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('13', '2', '2', '30', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('14', '2', '3', '31', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('15', '2', '3', '32', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('16', '2', '4', '33', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('17', '2', '4', '34', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('18', '2', '5', '36', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('19', '2', '6', '33', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('20', '2', '6', '34', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('21', '3', '1', '26', '3000.00', '100', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('22', '3', '1', '27', '1999.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('23', '3', '1', '28', '599.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('24', '3', '1', '29', '4999.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('25', '3', '2', '31', '90.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('26', '3', '2', '32', '60.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('27', '3', '2', '33', '2299.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('28', '3', '2', '34', '3888.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('29', '3', '3', '36', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('30', '3', '3', '35', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('31', '3', '3', '31', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('32', '3', '3', '32', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('33', '3', '4', '26', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('34', '3', '4', '27', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('35', '3', '4', '28', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('36', '3', '4', '29', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('37', '3', '5', '26', '3688.00', '100', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('38', '3', '5', '27', '2599.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('39', '3', '5', '28', '599.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('40', '3', '5', '29', '4999.00', '10', '1', null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('41', '3', '6', '26', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('42', '3', '6', '27', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('43', '3', '6', '28', null, null, null, null);
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('44', '3', '6', '29', null, null, null, null);

-- ----------------------------
-- Table structure for sms_flash_promotion_session
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_session`;
CREATE TABLE `sms_flash_promotion_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT 'promotion session name',
  `start_time` time DEFAULT NULL COMMENT 'start time',
  `end_time` time DEFAULT NULL COMMENT 'end time',
  `status` int(1) DEFAULT NULL COMMENT 'status：0->no；1->yes',
  `create_time` datetime DEFAULT NULL COMMENT 'create date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='limit time session table';

-- ----------------------------
-- Records of sms_flash_promotion_session
-- ----------------------------
INSERT INTO `sms_flash_promotion_session` VALUES ('1', '8:00', '08:00:00', '10:00:33', '1', '2018-11-16 13:22:17');
INSERT INTO `sms_flash_promotion_session` VALUES ('2', '10:00', '10:00:00', '12:00:00', '1', '2018-11-16 13:22:34');
INSERT INTO `sms_flash_promotion_session` VALUES ('3', '12:00', '12:00:00', '14:00:00', '1', '2018-11-16 13:22:37');
INSERT INTO `sms_flash_promotion_session` VALUES ('4', '14:00', '14:00:00', '16:00:00', '1', '2018-11-16 13:22:41');
INSERT INTO `sms_flash_promotion_session` VALUES ('5', '16:00', '16:00:00', '18:00:00', '1', '2018-11-16 13:22:45');
INSERT INTO `sms_flash_promotion_session` VALUES ('6', '18:00', '18:00:00', '20:00:00', '1', '2018-11-16 13:21:34');
INSERT INTO `sms_flash_promotion_session` VALUES ('7', '20:00', '20:00:33', '21:00:33', '0', '2018-11-16 13:22:55');

-- ----------------------------
-- Table structure for sms_home_advertise
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_advertise`;
CREATE TABLE `sms_home_advertise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT 'advertise position：0->pc main page；1->app main page',
  `pic` varchar(500) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT 'status：0->no；1->yes',
  `click_count` int(11) DEFAULT NULL COMMENT 'click count',
  `order_count` int(11) DEFAULT NULL COMMENT 'order count',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  `note` varchar(500) DEFAULT NULL COMMENT 'note',
  `sort` int(11) DEFAULT '0' COMMENT 'sort',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='main page advertise table';

-- ----------------------------
-- Records of sms_home_advertise
-- ----------------------------
INSERT INTO `sms_home_advertise` VALUES ('2', 'summer sale', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '2018-11-01 14:01:37', '2018-11-15 14:01:37', '0', '0', '0', null, 'summer sale', '0');
INSERT INTO `sms_home_advertise` VALUES ('3', 'summer sale', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '2018-11-13 14:01:37', '2018-11-13 14:01:37', '0', '0', '0', null, 'summer sale', '0');
INSERT INTO `sms_home_advertise` VALUES ('4', 'summer sale', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '2018-11-13 14:01:37', '2018-11-13 14:01:37', '1', '0', '0', null, 'summer sale', '0');
INSERT INTO `sms_home_advertise` VALUES ('9', 'file', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/movie_ad.jpg', '2018-11-01 00:00:00', '2018-11-24 00:00:00', '1', '0', '0', 'www.google.com', 'film', '100');
INSERT INTO `sms_home_advertise` VALUES ('10', 'car', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad.jpg', '2018-11-13 00:00:00', '2018-11-24 00:00:00', '1', '0', '0', 'xxx', null, '99');
INSERT INTO `sms_home_advertise` VALUES ('11', 'car', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad2.jpg', '2018-11-13 00:00:00', '2018-11-30 00:00:00', '1', '0', '0', 'xxx', null, '98');

-- ----------------------------
-- Table structure for sms_home_brand
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_brand`;
CREATE TABLE `sms_home_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `brand_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='main page recommend brand table';

-- ----------------------------
-- Records of sms_home_brand
-- ----------------------------
INSERT INTO `sms_home_brand` VALUES ('1', '1', 'GreenP', '1', '200');
INSERT INTO `sms_home_brand` VALUES ('2', '2', 'Samsung', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('6', '6', 'Mi', '1', '300');
INSERT INTO `sms_home_brand` VALUES ('8', '5', 'Fun', '1', '100');
INSERT INTO `sms_home_brand` VALUES ('32', '50', 'Family', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('33', '51', 'Apple', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('35', '3', 'Huawei', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('36', '4', 'GE', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('37', '5', 'Fun', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('38', '1', 'GreenP', '1', '0');
INSERT INTO `sms_home_brand` VALUES ('39', '21', 'OPPO', '1', '0');

-- ----------------------------
-- Table structure for sms_home_new_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_new_product`;
CREATE TABLE `sms_home_new_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='new product table';

-- ----------------------------
-- Records of sms_home_new_product
-- ----------------------------
INSERT INTO `sms_home_new_product` VALUES ('2', '27', 'Mi 8', '1', '200');
INSERT INTO `sms_home_new_product` VALUES ('8', '26', 'Huawei P20', '1', '0');
INSERT INTO `sms_home_new_product` VALUES ('9', '27', 'Mi 8', '1', '0');
INSERT INTO `sms_home_new_product` VALUES ('10', '28', 'Red Mi 5A ', '1', '0');
INSERT INTO `sms_home_new_product` VALUES ('11', '29', 'Apple iPhone 8 Plus 64GB', '1', '0');
INSERT INTO `sms_home_new_product` VALUES ('12', '30', 'HLA Tshirt', '1', '0');

-- ----------------------------
-- Table structure for sms_home_recommend_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_product`;
CREATE TABLE `sms_home_recommend_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='recommend product table';

-- ----------------------------
-- Records of sms_home_recommend_product
-- ----------------------------
INSERT INTO `sms_home_recommend_product` VALUES ('3', '26', 'Huawei P20', '1', '0');
INSERT INTO `sms_home_recommend_product` VALUES ('4', '27', 'Mi 8 ', '1', '0');
INSERT INTO `sms_home_recommend_product` VALUES ('5', '28', 'Red Mi 5A ', '1', '0');
INSERT INTO `sms_home_recommend_product` VALUES ('6', '29', 'Apple iPhone 8 Plus 64GB', '1', '0');
INSERT INTO `sms_home_recommend_product` VALUES ('7', '30', 'HLA T-shirt', '1', '100');

-- ----------------------------
-- Table structure for sms_home_recommend_subject
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_subject`;
CREATE TABLE `sms_home_recommend_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `subject_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='main page recommend subject table';

-- ----------------------------
-- Records of sms_home_recommend_subject
-- ----------------------------
INSERT INTO `sms_home_recommend_subject` VALUES ('14', '1', 'polo', '1', '0');
INSERT INTO `sms_home_recommend_subject` VALUES ('15', '2', 'polo', '1', '0');
INSERT INTO `sms_home_recommend_subject` VALUES ('16', '3', 'polo', '1', '0');
INSERT INTO `sms_home_recommend_subject` VALUES ('17', '4', 'polo', '1', '0');
INSERT INTO `sms_home_recommend_subject` VALUES ('18', '5', 'polo', '1', '100');
INSERT INTO `sms_home_recommend_subject` VALUES ('19', '6', 'polo', '1', '0');

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'icon',
  `email` varchar(100) DEFAULT NULL COMMENT 'email',
  `nick_name` varchar(200) DEFAULT NULL COMMENT 'nickname',
  `note` varchar(500) DEFAULT NULL COMMENT 'note',
  `create_time` datetime DEFAULT NULL COMMENT 'create date',
  `login_time` datetime DEFAULT NULL COMMENT 'last login',
  `status` int(1) DEFAULT '1' COMMENT 'account status：0->no；1->yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='admin user table';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('1', 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, 'test', null, '2018-09-29 13:55:30', '2018-09-29 13:55:39', '1');
INSERT INTO `ums_admin` VALUES ('3', 'admin', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/170157_yIl3_1767531.jpg', 'xuehao712@gmail.com', 'system admin', 'system admin', '2018-10-08 13:32:47', '2019-03-20 15:38:50', '1');

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_agent` varchar(100) DEFAULT NULL COMMENT 'browser login type',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='backend admin login log table';

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO `ums_admin_login_log` VALUES ('5', '3', '2018-12-06 13:59:12', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('6', '3', '2018-12-17 13:23:20', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('7', '3', '2018-12-18 13:51:42', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('8', '3', '2018-12-18 13:51:51', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('9', '3', '2019-01-28 16:20:41', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('10', '3', '2019-01-29 09:16:25', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('11', '3', '2019-01-29 10:10:51', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('12', '3', '2019-02-18 11:03:06', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('13', '3', '2019-03-12 10:03:55', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('14', '3', '2019-03-12 10:06:19', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('15', '3', '2019-03-12 10:15:22', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('16', '3', '2019-03-20 15:35:33', '0:0:0:0:0:0:0:1', null, null);
INSERT INTO `ums_admin_login_log` VALUES ('17', '3', '2019-03-20 15:38:50', '0:0:0:0:0:0:0:1', null, null);

-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='admin and permission relation table';

-- ----------------------------
-- Records of ums_admin_permission_relation
-- ----------------------------

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='admin and role relation table';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES ('13', '3', '1');
INSERT INTO `ums_admin_role_relation` VALUES ('15', '3', '2');
INSERT INTO `ums_admin_role_relation` VALUES ('17', '3', '3');
INSERT INTO `ums_admin_role_relation` VALUES ('16', '3', '4');

-- ----------------------------
-- Table structure for ums_growth_change_history
-- ----------------------------
DROP TABLE IF EXISTS `ums_growth_change_history`;
CREATE TABLE `ums_growth_change_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_type` int(1) DEFAULT NULL COMMENT 'change type：0->increase；1->decrease',
  `change_count` int(11) DEFAULT NULL COMMENT 'integration change quantity',
  `operate_man` varchar(100) DEFAULT NULL COMMENT 'operator',
  `operate_note` varchar(200) DEFAULT NULL COMMENT 'note',
  `source_type` int(1) DEFAULT NULL COMMENT 'integration source：0->shopping；1->admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='growth history';

-- ----------------------------
-- Records of ums_growth_change_history
-- ----------------------------
INSERT INTO `ums_growth_change_history` VALUES ('1', '1', '2018-08-29 17:16:35', '0', '1000', 'test', 'test', '1');

-- ----------------------------
-- Table structure for ums_integration_change_history
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_change_history`;
CREATE TABLE `ums_integration_change_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_type` int(1) DEFAULT NULL COMMENT 'change type：0->increase；1->decrease',
  `change_count` int(11) DEFAULT NULL COMMENT 'integration change quantity',
  `operate_man` varchar(100) DEFAULT NULL COMMENT 'operator',
  `operate_note` varchar(200) DEFAULT NULL COMMENT 'operation note',
  `source_type` int(1) DEFAULT NULL COMMENT 'integration source：0->shopping；1->admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='integration change history';

-- ----------------------------
-- Records of ums_integration_change_history
-- ----------------------------

-- ----------------------------
-- Table structure for ums_integration_consume_setting
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_consume_setting`;
CREATE TABLE `ums_integration_consume_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deduction_per_amount` int(11) DEFAULT NULL COMMENT 'integrations need for one dollar',
  `max_percent_per_order` int(11) DEFAULT NULL COMMENT 'each order max discount',
  `use_unit` int(11) DEFAULT NULL COMMENT 'each time min integration unit to use',
  `coupon_status` int(1) DEFAULT NULL COMMENT 'whether use with coupon；0->no；1->yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='integration setting';

-- ----------------------------
-- Records of ums_integration_consume_setting
-- ----------------------------
INSERT INTO `ums_integration_consume_setting` VALUES ('1', '100', '50', '100', '1');

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT 'username',
  `password` varchar(64) DEFAULT NULL COMMENT 'password',
  `nickname` varchar(64) DEFAULT NULL COMMENT 'nickname',
  `phone` varchar(64) DEFAULT NULL COMMENT 'phone',
  `email` varchar(100) DEFAULT NULL COMMENT 'email',
  `status` int(1) DEFAULT NULL COMMENT 'account status:0->no；1->yes',
  `create_time` datetime DEFAULT NULL COMMENT 'register time',
  `icon` varchar(500) DEFAULT NULL COMMENT 'icon',
  `gender` int(1) DEFAULT NULL COMMENT 'gender：0->unknow；1->male；2->female',
  `birthday` date DEFAULT NULL COMMENT 'birthday',
  `city` varchar(64) DEFAULT NULL COMMENT 'city',
  `job` varchar(100) DEFAULT NULL COMMENT 'job',
  `personalized_signature` varchar(200) DEFAULT NULL COMMENT 'personlized description',
  `source_type` int(1) DEFAULT NULL COMMENT 'source type',
  `integration` int(11) DEFAULT NULL COMMENT 'integration',
  `growth` int(11) DEFAULT NULL COMMENT 'growth',
  `lucky_count` int(11) DEFAULT NULL COMMENT 'lucky draw',
  `history_integration` int(11) DEFAULT NULL COMMENT 'history integration count',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='member table';

-- ----------------------------
-- Records of ums_member
-- ----------------------------
INSERT INTO `ums_member` VALUES ('1', '4', 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windir', '18061581849','xuehao712@gmail.com', '1', '2018-08-02 10:35:44', null, '1', '2009-06-01', 'NY', 'student', 'test', null, '5000', null, null, null);
INSERT INTO `ums_member` VALUES ('3', '4', 'windy', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windy', '18061581848','xuehao712@gmail.com', '1', '2018-08-03 16:46:38', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('4', '4', 'zhengsan', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581847','xuehao712@gmail.com', '1', '2018-11-12 14:12:04', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('5', '4', 'lisi', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581841','xuehao712@gmail.com', '1', '2018-11-12 14:12:38', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('6', '4', 'wangwu', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581842','xuehao712@gmail.com', '1', '2018-11-12 14:13:09', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('7', '4', 'lion', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581845','xuehao712@gmail.com', '1', '2018-11-12 14:21:39', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('8', '4', 'shari', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581844','xuehao712@gmail.com', '1', '2018-11-12 14:22:00', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ums_member` VALUES ('9', '4', 'aewen', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'Tmmy', '18061581843','xuehao712@gmail.com', '1', '2018-11-12 14:22:55', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for ums_member_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_level`;
CREATE TABLE `ums_member_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `growth_point` int(11) DEFAULT NULL,
  `default_status` int(1) DEFAULT NULL COMMENT 'whether default level：0->no；1->yes',
  `free_freight_point` decimal(10,2) DEFAULT NULL COMMENT 'free shipping point',
  `comment_growth_point` int(11) DEFAULT NULL COMMENT 'comment retrive growth',
  `priviledge_free_freight` int(1) DEFAULT NULL COMMENT 'whether free shipping',
  `priviledge_sign_in` int(1) DEFAULT NULL COMMENT 'whether signin privilege',
  `priviledge_comment` int(1) DEFAULT NULL COMMENT 'whether comment prize privilege',
  `priviledge_promotion` int(1) DEFAULT NULL COMMENT 'whether promotion privilege',
  `priviledge_member_price` int(1) DEFAULT NULL COMMENT 'whether member price privilege',
  `priviledge_birthday` int(1) DEFAULT NULL COMMENT 'whether birthday privilege',
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='member level';

-- ----------------------------
-- Records of ums_member_level
-- ----------------------------
INSERT INTO `ums_member_level` VALUES ('1', 'Golden', '1000', '0', '199.00', '5', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `ums_member_level` VALUES ('2', 'Platium', '5000', '0', '99.00', '10', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `ums_member_level` VALUES ('3', 'Golden', '15000', '0', '69.00', '15', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `ums_member_level` VALUES ('4', 'Regular', '1', '1', '199.00', '20', '1', '1', '1', '1', '0', '0', null);

-- ----------------------------
-- Table structure for ums_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_login_log`;
CREATE TABLE `ums_member_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `login_type` int(1) DEFAULT NULL COMMENT 'login platform：0->PC；1->android;2->ios;3->other',
  `province` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member login log';

-- ----------------------------
-- Records of ums_member_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_member_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_member_tag_relation`;
CREATE TABLE `ums_member_member_tag_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `tag_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member and tag relation';

-- ----------------------------
-- Records of ums_member_member_tag_relation
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_product_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_product_category_relation`;
CREATE TABLE `ums_member_product_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member and product category relation(user favorite product category)';

-- ----------------------------
-- Records of ums_member_product_category_relation
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_receive_address`;
CREATE TABLE `ums_member_receive_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT 'receiver name',
  `phone_number` varchar(64) DEFAULT NULL,
  `default_status` int(1) DEFAULT NULL COMMENT 'whether default',
  `zip_code` varchar(100) DEFAULT NULL COMMENT 'zip code',
  `province` varchar(100) DEFAULT NULL COMMENT 'state',
  `city` varchar(100) DEFAULT NULL COMMENT 'city',
  `detail_address` varchar(128) DEFAULT NULL COMMENT 'detail address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='member receive address table';

-- ----------------------------
-- Records of ums_member_receive_address
-- ----------------------------
INSERT INTO `ums_member_receive_address` VALUES ('1', '1', 'Ting', '18033441849', '0', '11222', 'NY', 'Brooklyn', '2882 75th st');
INSERT INTO `ums_member_receive_address` VALUES ('3', '1', 'Ting', '18033441849', '0', '11434', 'NY', 'Brooklyn', '2882 75th st');
INSERT INTO `ums_member_receive_address` VALUES ('4', '1', 'Ting', '18033441849', '1', '11247', 'NY', 'Brooklyn', '2882 20th st');

-- ----------------------------
-- Table structure for ums_member_rule_setting
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_rule_setting`;
CREATE TABLE `ums_member_rule_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `continue_sign_day` int(11) DEFAULT NULL COMMENT 'continue signin',
  `continue_sign_point` int(11) DEFAULT NULL COMMENT 'continue signin point',
  `consume_per_point` decimal(10,2) DEFAULT NULL COMMENT 'integration to get when spend one dollar',
  `low_order_amount` decimal(10,2) DEFAULT NULL COMMENT 'min order amount to get integration',
  `max_point_per_order` int(11) DEFAULT NULL COMMENT 'max integration to get',
  `type` int(1) DEFAULT NULL COMMENT 'type：0->integration rule；1->growth rule',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member integration growth rule table';

-- ----------------------------
-- Records of ums_member_rule_setting
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_statistics_info`;
CREATE TABLE `ums_member_statistics_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `consume_amount` decimal(10,2) DEFAULT NULL COMMENT 'total consume amount',
  `order_count` int(11) DEFAULT NULL COMMENT 'order count',
  `coupon_count` int(11) DEFAULT NULL COMMENT 'coupon count',
  `comment_count` int(11) DEFAULT NULL COMMENT 'comment count',
  `return_order_count` int(11) DEFAULT NULL COMMENT 'return count',
  `login_count` int(11) DEFAULT NULL COMMENT 'login count',
  `attend_count` int(11) DEFAULT NULL COMMENT 'attention count',
  `fans_count` int(11) DEFAULT NULL COMMENT 'fans count',
  `collect_product_count` int(11) DEFAULT NULL,
  `collect_subject_count` int(11) DEFAULT NULL,
  `collect_topic_count` int(11) DEFAULT NULL,
  `collect_comment_count` int(11) DEFAULT NULL,
  `invite_friend_count` int(11) DEFAULT NULL,
  `recent_order_time` datetime DEFAULT NULL COMMENT 'recent order time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member statistic info';

-- ----------------------------
-- Records of ums_member_statistics_info
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_tag
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_tag`;
CREATE TABLE `ums_member_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `finish_order_count` int(11) DEFAULT NULL COMMENT 'finish order count',
  `finish_order_amount` decimal(10,2) DEFAULT NULL COMMENT 'finish order amount',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member tag table';

-- ----------------------------
-- Records of ums_member_tag
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_task
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_task`;
CREATE TABLE `ums_member_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `growth` int(11) DEFAULT NULL COMMENT 'gift growth',
  `integration` int(11) DEFAULT NULL COMMENT 'gift integration',
  `type` int(1) DEFAULT NULL COMMENT 'task type：0->novice task；1->daily task',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member task table';

-- ----------------------------
-- Records of ums_member_task
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT 'parent ID',
  `create_time` datetime DEFAULT NULL COMMENT 'create date',
  `title` varchar(100) DEFAULT NULL COMMENT 'menu name',
  `level` int(11) DEFAULT NULL COMMENT 'menu level',
  `sort` int(11) DEFAULT NULL COMMENT 'menu sorting',
  `name` varchar(100) DEFAULT NULL COMMENT 'front end name',
  `icon` varchar(500) DEFAULT NULL COMMENT 'front end icon',
  `hidden` int(11) DEFAULT NULL COMMENT 'front end hidden',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='member menu table';
-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT 'parent id permission',
  `name` varchar(100) DEFAULT NULL COMMENT 'name',
  `value` varchar(200) DEFAULT NULL COMMENT 'permission value',
  `icon` varchar(500) DEFAULT NULL COMMENT 'icon',
  `type` int(1) DEFAULT NULL COMMENT 'permission type：0->catalog；1->menu；2->button(portal bind permission)',
  `uri` varchar(200) DEFAULT NULL COMMENT 'frontend source url',
  `status` int(1) DEFAULT NULL COMMENT 'yesstatus；0->no；1->yes',
  `create_time` datetime DEFAULT NULL COMMENT 'create date',
  `sort` int(11) DEFAULT NULL COMMENT 'sort',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='backend user permission';

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
INSERT INTO `ums_permission` VALUES ('1', '0', 'product', null, null, '0', null, '1', '2018-09-29 16:15:14', '0');
INSERT INTO `ums_permission` VALUES ('2', '1', 'product list', 'pms:product:read', null, '1', '/pms/product/index', '1', '2018-09-29 16:17:01', '0');
INSERT INTO `ums_permission` VALUES ('3', '1', 'add product', 'pms:product:create', null, '1', '/pms/product/add', '1', '2018-09-29 16:18:51', '0');
INSERT INTO `ums_permission` VALUES ('4', '1', 'product sort', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1', '2018-09-29 16:23:07', '0');
INSERT INTO `ums_permission` VALUES ('5', '1', 'product type', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1', '2018-09-29 16:24:43', '0');
INSERT INTO `ums_permission` VALUES ('6', '1', 'brand manage', 'pms:brand:read', null, '1', '/pms/brand/index', '1', '2018-09-29 16:25:45', '0');
INSERT INTO `ums_permission` VALUES ('7', '2', 'modify product', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1', '2018-09-29 16:34:23', '0');
INSERT INTO `ums_permission` VALUES ('8', '2', 'delete product', 'pms:product:delete', null, '2', '/pms/product/delete', '1', '2018-09-29 16:38:33', '0');
INSERT INTO `ums_permission` VALUES ('9', '4', 'add product sort', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1', '2018-09-29 16:43:23', '0');
INSERT INTO `ums_permission` VALUES ('10', '4', 'modify product sort', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1', '2018-09-29 16:43:55', '0');
INSERT INTO `ums_permission` VALUES ('11', '4', 'delete product sort', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:44:38', '0');
INSERT INTO `ums_permission` VALUES ('12', '5', 'add product type', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create', '1', '2018-09-29 16:45:25', '0');
INSERT INTO `ums_permission` VALUES ('13', '5', 'modify product type', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update', '1', '2018-09-29 16:48:08', '0');
INSERT INTO `ums_permission` VALUES ('14', '5', 'delete product type', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:48:44', '0');
INSERT INTO `ums_permission` VALUES ('15', '6', 'add brand', 'pms:brand:create', null, '2', '/pms/brand/add', '1', '2018-09-29 16:49:34', '0');
INSERT INTO `ums_permission` VALUES ('16', '6', 'modify brand', 'pms:brand:update', null, '2', '/pms/brand/update', '1', '2018-09-29 16:50:55', '0');
INSERT INTO `ums_permission` VALUES ('17', '6', 'delete brand', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', '2018-09-29 16:50:59', '0');
INSERT INTO `ums_permission` VALUES ('18', '0', 'home', null, null, '0', null, '1', '2018-09-29 16:51:57', '0');

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `name` varchar(100) DEFAULT NULL COMMENT 'name',
  `url` varchar(500) DEFAULT NULL COMMENT 'source url',
  `description` varchar(500) DEFAULT NULL COMMENT 'description',
  `category_id` bigint(20) DEFAULT NULL COMMENT 'category id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='resource';

-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `name` varchar(100) DEFAULT NULL COMMENT 'name',
  `sort` int(11) DEFAULT NULL COMMENT 'sorting',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='resource';
-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT 'name',
  `description` varchar(500) DEFAULT NULL COMMENT 'description',
  `admin_count` int(11) DEFAULT NULL COMMENT 'backend user count',
  `create_time` datetime DEFAULT NULL COMMENT 'create date',
  `status` int(1) DEFAULT '1' COMMENT 'yesstatus：0->no；1->yes',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='backend user role';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', 'product admin', 'productadmin', '0', '2018-09-30 15:46:11', '1', '0');
INSERT INTO `ums_role` VALUES ('2', 'product sort admin', 'product category admin', '0', '2018-09-30 15:53:45', '1', '0');
INSERT INTO `ums_role` VALUES ('3', 'product type admin', 'product type admin', '0', '2018-09-30 15:53:56', '1', '0');
INSERT INTO `ums_role` VALUES ('4', 'brand admin', 'brand admin', '0', '2018-09-30 15:54:12', '1', '0');

-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT 'role id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT 'menu id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='backend user role';

-- ----------------------------
-- Table structure for ums_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='backend user role and permission relation table';

-- ----------------------------
-- Records of ums_role_permission_relation
-- ----------------------------
INSERT INTO `ums_role_permission_relation` VALUES ('1', '1', '1');
INSERT INTO `ums_role_permission_relation` VALUES ('2', '1', '2');
INSERT INTO `ums_role_permission_relation` VALUES ('3', '1', '3');
INSERT INTO `ums_role_permission_relation` VALUES ('4', '1', '7');
INSERT INTO `ums_role_permission_relation` VALUES ('5', '1', '8');
INSERT INTO `ums_role_permission_relation` VALUES ('6', '2', '4');
INSERT INTO `ums_role_permission_relation` VALUES ('7', '2', '9');
INSERT INTO `ums_role_permission_relation` VALUES ('8', '2', '10');
INSERT INTO `ums_role_permission_relation` VALUES ('9', '2', '11');
INSERT INTO `ums_role_permission_relation` VALUES ('10', '3', '5');
INSERT INTO `ums_role_permission_relation` VALUES ('11', '3', '12');
INSERT INTO `ums_role_permission_relation` VALUES ('12', '3', '13');
INSERT INTO `ums_role_permission_relation` VALUES ('13', '3', '14');
INSERT INTO `ums_role_permission_relation` VALUES ('14', '4', '6');
INSERT INTO `ums_role_permission_relation` VALUES ('15', '4', '15');
INSERT INTO `ums_role_permission_relation` VALUES ('16', '4', '16');
INSERT INTO `ums_role_permission_relation` VALUES ('17', '4', '17');

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT 'role id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT 'resource id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='backend user role';
