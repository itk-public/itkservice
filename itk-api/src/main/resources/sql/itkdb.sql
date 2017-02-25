CREATE TABLE `t_security_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `security_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '验证码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 1：有效 0：失效',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='验证码信息';

CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) NOT NULL DEFAULT '1' COMMENT '性别 0:女 1:男',
  `nick_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `passwd_error_time` int(11) DEFAULT '0' COMMENT '错误次数',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `lastlogin_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_info_phone_uindex` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

CREATE TABLE `t_seckill_season` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `season_time` datetime DEFAULT NULL COMMENT '场次时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='场次管理';

CREATE TABLE `t_home_page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` bigint(100) DEFAULT NULL COMMENT '名称',
  `township_id` varchar(100) DEFAULT NULL COMMENT '乡镇id',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='首页';

CREATE TABLE `t_page_sort` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sort_id` int(10) DEFAULT NULL COMMENT '显示位置',
  `home_page_id` bigint(20) DEFAULT NULL COMMENT '主页id',
  `assembly_name` varchar(20) DEFAULT NULL COMMENT '组件信息定位组件表例如：hbanner --》t_hbanner表',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='首页顺序';

CREATE TABLE `t_gallery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` bigint(10) DEFAULT NULL COMMENT '首页顺序表id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `src` varchar(400) DEFAULT NULL COMMENT '图片上传',
  `action` varchar(1024) DEFAULT NULL COMMENT  '跳转链接',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='轮播图';

CREATE TABLE `t_jewel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` int(10) DEFAULT NULL COMMENT '首页顺序表id',
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `src` varchar(400) DEFAULT NULL COMMENT '图片上传',
  `position` bigint(10) DEFAULT NULL COMMENT '位置',
  `action` varchar(1024) DEFAULT NULL COMMENT  '跳转链接',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='八宝箱';

CREATE TABLE `t_partingline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` int(10) DEFAULT NULL COMMENT '首页顺序表id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `src` varchar(400) DEFAULT NULL COMMENT '图片上传',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='分割线';

CREATE TABLE `t_seckill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` int(10) DEFAULT NULL COMMENT '首页顺序表id',
  `season_id` bigint(20) DEFAULT NULL COMMENT '场次id',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='秒杀或每日专享';

CREATE TABLE `t_skupos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` int(10) DEFAULT NULL COMMENT '首页顺序表id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `src` varchar(400) DEFAULT NULL COMMENT '图片上传',
  `position` bigint(10) DEFAULT NULL COMMENT '位置',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `action` varchar(1024) DEFAULT NULL COMMENT  '跳转链接',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品位';

CREATE TABLE `t_hbanner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_sort_id` int(10) DEFAULT NULL COMMENT '首页顺序表id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `src` varchar(400) DEFAULT NULL COMMENT '图片上传',
  `action` varchar(1024) DEFAULT NULL COMMENT  '跳转链接',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Banner放平台促销信息';

CREATE TABLE `t_nearby_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` varchar(100) DEFAULT NULL COMMENT '附近商家id',
  `icon` varchar(400) DEFAULT NULL COMMENT '商家图标',
  `action` varchar(1024) DEFAULT NULL COMMENT  '跳转链接',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='附近商家';


CREATE TABLE `t_nearby_business_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nearby_business_id` bigint(20) DEFAULT NULL COMMENT '附近商家表的id',
  `whether_promotion` int(1) DEFAULT NULL COMMENT '是否有促销:1有促销 0无促销 如果有读取促销信息',
  `whether_month_order_number` varchar(400) DEFAULT NULL COMMENT '是否显示月订单数量:1显示真实数量 0后台输入',
  `month_order_number` bigint(20) DEFAULT NULL COMMENT '月订单数量',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='附近商家';




