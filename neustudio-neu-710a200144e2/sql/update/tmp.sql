alter table `neu_employee` add column `avatarId` int(11) DEFAULT NULL COMMENT '员工照片id' after `id`;

CREATE TABLE IF NOT EXISTS `neu_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `catalog` int(10) DEFAULT NULL COMMENT '附件类别. 1:员工照片',
  `filename` varchar(100) DEFAULT NULL COMMENT '附件名称',
  `content` longblob DEFAULT NULL COMMENT '附件内容',
  `content_type` varchar(100) DEFAULT NULL COMMENT 'content_type',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10000 ;

CREATE TABLE IF NOT EXISTS `neu_knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employeeId` int(11) NOT NULL COMMENT '员工id',
  `date` varchar(50) DEFAULT NULL COMMENT '日期',
  `safe1` int(10) DEFAULT NULL COMMENT '安全',
  `theory1` int(10) DEFAULT NULL COMMENT '理论',
  `practice1` int(10) DEFAULT NULL COMMENT '实作',
  `safe2` int(10) DEFAULT NULL COMMENT '安全',
  `theory2` int(10) DEFAULT NULL COMMENT '理论',
  `practice2` int(10) DEFAULT NULL COMMENT '实作',
  `theory3` int(10) DEFAULT NULL COMMENT '理论',
  `safe3` int(10) DEFAULT NULL COMMENT '安全',
  `score` int(10) DEFAULT NULL COMMENT '分值',
  `rating` int(10) DEFAULT NULL COMMENT '评级',
  `winter` int(10) DEFAULT NULL COMMENT '',
  `risk` int(10) DEFAULT NULL COMMENT '',
  `standard` int(10) DEFAULT NULL COMMENT '',
  `flood` int(10) DEFAULT NULL COMMENT '',
  `status` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10000 ;

CREATE TABLE IF NOT EXISTS `neu_ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employeeId` int(11) NOT NULL COMMENT '员工id',
  `catalog` int(10) DEFAULT NULL COMMENT '培训类别',
  `name` varchar(50) DEFAULT NULL COMMENT '培训名称',
  `startDate` varchar(50) DEFAULT NULL COMMENT '培训开始日期',
  `endDate` varchar(50) DEFAULT NULL COMMENT '培训结束日期',
  `mode` int(1) DEFAULT NULL COMMENT '培训方式',
  `goal` varchar(500) DEFAULT NULL COMMENT '培训目标',
  `content` varchar(500) DEFAULT NULL COMMENT '培训内容',
  `score` int(10) DEFAULT NULL COMMENT '分值',
  `issue` int(1) DEFAULT NULL COMMENT '是否办法证书',
  `certificate` varchar(500) DEFAULT NULL COMMENT '证书名称',
  `status` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10000 ;


