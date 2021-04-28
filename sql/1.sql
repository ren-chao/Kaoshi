/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - pet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pet` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `pet`;

/*Table structure for table `button` */

DROP TABLE IF EXISTS `button`;

CREATE TABLE `button` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(260) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `button` */

insert  into `button`(`id`,`name`) values (1,'<button TYPE=\"button\" lay-event=\"dele\" class=\"layui-btn\" lay-filtre=\"deleteuser\">删除</button>'),(2,'<button TYPE=\"button\" lay-event=\"insert\" class=\"layui-btn\" lay-filtre=\"deleteuser\">新增</button>'),(3,'<button TYPE=\"button\" lay-event=\"updat\" class=\"layui-btn\" lay-filtre=\"deleteuser\">修改</button>'),(4,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*Table structure for table `pet` */

DROP TABLE IF EXISTS `pet`;

CREATE TABLE `pet` (
  `petId` int(11) NOT NULL AUTO_INCREMENT,
  `petName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `petBreed` int(11) NOT NULL,
  `petSex` int(11) NOT NULL,
  `birthday` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`petId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pet` */

insert  into `pet`(`petId`,`petName`,`petBreed`,`petSex`,`birthday`,`description`) values (1,'大黄',1,1,'2020-1-1','宠物'),(2,'小鹤',3,2,'2020-1-3','宠物'),(5,'海贼王',4,1,'2020-1-4','霸气'),(7,'裴擒虎',1,1,'2938-1-9','能变身'),(8,'小月',2,2,'30-34-29-34','可爱'),(9,'a',2,1,'20sadasd','asx'),(10,'a',1,2,'sad',''),(11,'a0',1,2,'20sadasd','dcdsvds'),(12,'sdad',3,2,'ASDd','asdasD');

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `path` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `mbth` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `power` */

insert  into `power`(`id`,`name`,`fid`,`path`,`type`,`mbth`) values (1,'权限基础管理',0,NULL,1,''),(2,'权限信息',1,'ABC/qu?action=seleniu',2,'Quan.js'),(3,'角色信息',1,'ABC/jue?action=selerole',2,'jue.js'),(4,'员工信息',1,'ABC/sta?action=chaniu1',2,'userlist.js'),(5,'新增',4,NULL,3,'<button TYPE=\"button\" lay-event=\"addMenu\"class=\"layui-btn\" >新增用户</button>'),(6,'删除',4,NULL,3,'<button TYPE=\"button\" lay-event=\"delMenu\"class=\"layui-btn\" >删除用户</button>'),(7,'增加',4,NULL,3,'<button TYPE=\"button\" lay-event=\"updataMenu\"class=\"layui-btn\" >修改用户</button>'),(8,'新增权限',2,NULL,3,'<button TYPE=\"button\" lay-event=\"addUser\"class=\"layui-btn\" >新增权限</button>'),(9,'删除权限',2,NULL,3,'<button TYPE=\"button\" lay-event=\"deleUser\"class=\"layui-btn\" >删除权限</button>'),(10,'修改权限',2,NULL,3,'<button TYPE=\"button\" lay-event=\"updataMenu\"class=\"layui-btn\" >修改权限</button>'),(12,'arer阿萨斯',4,'',3,'<button type=\"button\" lay-event=\"dele\" class=\"layui-btn\" lay-filtre=\"deleteuser\">删除</button>'),(14,'分配权限',3,'savffds',3,'<button type=\"button\" lay-event=\"fenFunc\" class=\"layui-btn layui-btn-primary xz\"><i class=\"layui-icon\"></i>分配</button>'),(15,'新增部门',18,NULL,3,'<button TYPE=\"button\" lay-event=\"updataMenu\"class=\"layui-btn\" >新增部门</button>'),(16,'删除部门',18,NULL,3,'<button TYPE=\"button\" lay-event=\"updataMenu\"class=\"layui-btn\" >删除部门</button>'),(17,'修改部门',18,NULL,3,'<button TYPE=\"button\" lay-event=\"updataMenu\"class=\"layui-btn\" >部门信息</button>'),(18,'部门信息',1,'ABC/bu?action=SeleBuMenButton',3,'bumen.js');

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` int(11) DEFAULT NULL,
  `userid` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `privilege` */

insert  into `privilege`(`id`,`userid`) values (2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(1,1),(1,2),(1,3),(1,14),(3,1),(3,2),(3,8),(3,9),(3,10);

/*Table structure for table `rank` */

DROP TABLE IF EXISTS `rank`;

CREATE TABLE `rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rank` */

insert  into `rank`(`id`,`name`) values (1,'组长'),(2,'组员'),(3,'其他');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `address` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`count`,`address`) values (1,'超级管理员',12,'12'),(2,'普通员工',13,'13'),(3,'管理员',14,'14');

/*Table structure for table `section` */

DROP TABLE IF EXISTS `section`;

CREATE TABLE `section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `section` */

insert  into `section`(`id`,`name`,`count`,`address`) values (1,'开发部',20,NULL),(2,'测试部',20,NULL),(3,'销售部',NULL,NULL),(4,'其他部',NULL,NULL);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sectionid` int(11) DEFAULT NULL,
  `rankid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `staff` */

insert  into `staff`(`id`,`name`,`sectionid`,`rankid`,`roleid`) values (1,'张三',1,2,3),(2,'1',1,2,1),(3,'5206',1,1,1),(5,'王五',2,2,3);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户名',
  `userName` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `loginName` varchar(20) NOT NULL COMMENT '用户登陆用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `sex` int(1) NOT NULL COMMENT '性别',
  `identityCode` bigint(18) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(1) NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`loginName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type`) values (2,'系统管理员','admin','123456',1,130406198302141869,'hello11@bdqn.com','15832335151',1),(10,'程广宁','cgn','123456',2,140225189987854589,'1044732267@qq.com','13366055011',1),(11,'韩语良','hyl','e10adc3949ba59abbe56e057f20f883e',1,140225198874584539,'1044732267@qq.com','13366055010',0),(12,'陈康','ck','e10adc3949ba59abbe56e057f20f883e',1,140225189987854589,'1044732267@qq.com','13366055010',0),(13,'康有沈','kys','e10adc3949ba59abbe56e057f20f883e',1,140225198551254152,'1044732267@qq.com','13366055010',0),(14,'沈白','sb','e10adc3949ba59abbe56e057f20f883e',1,140225158987854589,'1044732267@qq.com','13366055010',0),(15,'李白','lb','e10adc3949ba59abbe56e057f20f883e',1,140225189987854589,'10447322658@qq.com','13369985541',0),(16,'李高伟','lgw','e10adc3949ba59abbe56e057f20f883e',1,140225189987854589,'1011322658@qq.com','13369985545',0),(18,'尚泽忠','szz','e10adc3949ba59abbe56e057f20f883e',1,140225198810013745,'1044888844@qq.com','13366528458',0),(20,'李光亮','szz','e10adc3949ba59abbe56e057f20f883e',1,140225198810013748,'1044732267@qq.com','13366555010',1),(21,'6','6sdssasadfsa','6adsdasaasfsadf',1,NULL,'q6@qq.com','12345678988',2),(22,'sdsdsdfsd','5sdssdedef','123456',1,NULL,'2@qq.com','11234567898',1),(24,'哈哈哈哈','6666666','123456',1,NULL,'2@qq.com','11234567898',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
