/*
SQLyog Ultimate v13.1.1 (32 bit)
MySQL - 5.7.29-log : Database - order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`order` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `order`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `a_id` varchar(40) NOT NULL COMMENT '管理员账户',
  `passord` varchar(20) DEFAULT NULL COMMENT '密码',
  `role` varchar(40) DEFAULT NULL COMMENT '权限',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

/*Table structure for table `delivers` */

DROP TABLE IF EXISTS `delivers`;

CREATE TABLE `delivers` (
  `d_id` varchar(40) NOT NULL COMMENT '人员编号',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `f_card` varchar(40) DEFAULT NULL COMMENT '身份证正面',
  `b_card` varchar(40) DEFAULT NULL COMMENT '身份证反面',
  `grade` double DEFAULT NULL COMMENT '评分等级',
  `p_fine` varchar(40) DEFAULT NULL COMMENT '健康证图片',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `delivers` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `o_id` varchar(40) NOT NULL COMMENT '订单编号',
  `o_time` date NOT NULL COMMENT '下单时间',
  `s_time` date DEFAULT NULL COMMENT '送达时间',
  `s_status` varchar(20) NOT NULL COMMENT '接送状态',
  `is_send` varchar(20) NOT NULL COMMENT '是否送达',
  `o_status` varchar(20) NOT NULL COMMENT '订单状态',
  `p_status` varchar(20) NOT NULL COMMENT '支付状态',
  `o_money` decimal(20,2) NOT NULL COMMENT '订单总额',
  `s_address` varchar(50) NOT NULL COMMENT '送餐地址',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `orders` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `p_id` varchar(40) NOT NULL COMMENT '菜品编号',
  `s_id` varchar(40) NOT NULL COMMENT '餐馆编号',
  `food` varchar(20) DEFAULT NULL COMMENT '菜名',
  `a_price` decimal(20,2) DEFAULT NULL COMMENT '原来价格',
  `promotion` decimal(20,2) DEFAULT NULL COMMENT '优惠价格',
  `discount` decimal(5,2) DEFAULT NULL COMMENT '折扣',
  `picture` varchar(50) DEFAULT NULL COMMENT '图片',
  `remark` varchar(100) DEFAULT NULL COMMENT '简介',
  `type` varchar(40) DEFAULT NULL COMMENT '菜品类型',
  `nutrition` varchar(50) DEFAULT NULL COMMENT '营养属性',
  `c_time` date DEFAULT NULL COMMENT '创建时间',
  `grade` double(4,1) DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`p_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `shop` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `product` */

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `s_id` varchar(40) NOT NULL COMMENT '餐馆编号',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `phone` varchar(20) NOT NULL COMMENT '联系方式',
  `name` varchar(20) NOT NULL COMMENT '负责人',
  `licence` varchar(50) NOT NULL COMMENT '营业照',
  `type` varchar(30) DEFAULT NULL COMMENT '类型标签',
  `remark` varchar(100) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `shop` */

/*Table structure for table `system` */

DROP TABLE IF EXISTS `system`;

CREATE TABLE `system` (
  `sy_id` varchar(40) NOT NULL COMMENT '账户',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `role` varchar(40) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`sy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `system` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` varchar(40) NOT NULL COMMENT '用户编号',
  `name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `account` varchar(20) NOT NULL COMMENT '账户',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `brief` varchar(100) DEFAULT NULL COMMENT '简介',
  `c_time` date NOT NULL COMMENT '创建时间',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `token` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录标识',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`u_id`,`name`,`account`,`password`,`phone`,`sex`,`birthday`,`brief`,`c_time`,`address`,`token`) values 
('12341234','lin','12345678','12345678','12345678','男','2020-04-08','简介','2020-04-14','战舰',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
