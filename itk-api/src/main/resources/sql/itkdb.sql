CREATE TABLE `t_security_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(30)  DEFAULT NULL COMMENT '手机号码',
  `security_code` varchar(20)  DEFAULT NULL COMMENT '验证码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 1：有效 0：失效',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='验证码信息';

CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100)  NOT NULL COMMENT '用户id',
  `phone` varchar(30)  DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100)  NOT NULL COMMENT '密码',
  `email` varchar(80)  DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) NOT NULL DEFAULT '1' COMMENT '性别 0:女 1:男',
  `nick_name` varchar(40)  DEFAULT NULL COMMENT '昵称',
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


CREATE TABLE `t_position_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(10) unsigned NOT NULL COMMENT '地级市id',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '县级市id',
  `city_name` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `city_id` (`city_id`),
  KEY `province_id` (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='县级市数据库';


CREATE TABLE `t_position_county` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地级市主键ID',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '地级市id',
  `county_id` bigint(20) unsigned NOT NULL COMMENT '县级id',
  `county_name` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `county_id` (`county_id`),
  KEY `city_id` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2857 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区市数据库';

CREATE TABLE `t_position_town` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `county_id` bigint(20) unsigned NOT NULL COMMENT '县级市id',
  `town_id` bigint(20) unsigned NOT NULL COMMENT '镇id',
  `town_name` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `town_id` (`town_id`),
  KEY `county_id` (`county_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43855 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='镇数据库';

CREATE TABLE `t_position_village` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `town_id` bigint(20) unsigned NOT NULL COMMENT '镇id',
  `village_id` bigint(20) unsigned NOT NULL COMMENT '村id--唯一',
  `village_name` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `village_id` (`village_id`),
  KEY `town_id` (`town_id`)
) ENGINE=InnoDB AUTO_INCREMENT=693338 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='省市县镇村数据';

CREATE TABLE `t_position_provice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `provice_id` int(11) unsigned NOT NULL COMMENT '省份id、省份编号',
  `provice_name` char(32) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `provice_id` (`provice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='省份数据库';

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

CREATE TABLE `t_shop_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `township_id` bigint(20) DEFAULT NULL COMMENT '乡镇id',
  `shop_code` varchar(20) NOT NULL COMMENT '门店编码',
  `src` varchar(200) NOT NULL COMMENT '门店logo',
  `shop_name` varchar(200) DEFAULT NULL COMMENT '门店名称',
  `address` varchar(1024) DEFAULT NULL COMMENT '具体地址',
  `phone` varchar(30) DEFAULT NULL COMMENT  '联系电话',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家信息';

CREATE TABLE `t_back_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100)  NOT NULL COMMENT '账号',
  `phone` varchar(30)  DEFAULT NULL COMMENT '手机号码',
  `name` varchar(100)  NOT NULL COMMENT '姓名',
  `password` varchar(100)  NOT NULL COMMENT '密码',
  `email` varchar(80)  DEFAULT NULL COMMENT '邮箱',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `lastlogin_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_back_user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

CREATE TABLE `t_display_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20)  NOT NULL COMMENT '父类id',
  `name` varchar(200)  DEFAULT NULL COMMENT '名称',
  `src` varchar(100)  NOT NULL COMMENT '图片',
  `isShow`  int(1) DEFAULT NULL COMMENT '是否显示 0:不显示 1:显示',
  `is_leaf_category` int(1)  DEFAULT NULL COMMENT '是否叶子类目 0:不是 1:是',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(200)  DEFAULT NULL COMMENT '创建人',
  `updator` varchar(200)  DEFAULT NULL COMMENT '更新人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='分类类目信息';

CREATE TABLE `t_shop_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200)  DEFAULT NULL COMMENT '分类名称',
  `isShow`  int(1) DEFAULT NULL COMMENT '是否显示 0:不显示 1:显示',
  `is_leaf_category` int(1) DEFAULT NULL COMMENT '是否叶子类目 0:不是 1:是',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(200)  DEFAULT NULL COMMENT '创建人',
  `updator` varchar(200)  DEFAULT NULL COMMENT '更新人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家分类';

CREATE TABLE `t_item_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200)  DEFAULT NULL COMMENT '商品名称',
  `mainSrc` varchar(100)  NOT NULL COMMENT '商品主图',
  `bar_code` varchar(100)  NOT NULL COMMENT '条形码',
  `item_id` varchar(100)  NOT NULL COMMENT '商品id',
  `detailSrc`  varchar(400) DEFAULT NULL COMMENT '商品详情图',
  `price` decimal(15,4) DEFAULT NULL COMMENT '商品价格',
  `current_price` decimal(15,4) DEFAULT NULL COMMENT '当前商品进价',
  `history_price` decimal(15,4) DEFAULT NULL COMMENT '历史商品进价',
  `pay_period`  varchar(40) DEFAULT NULL COMMENT '结算周期 每月15号或者月末最后一天结算）',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `shop_category_id` int(11)  NOT NULL COMMENT '商家类目id',
  `total_stock` int(11)  NOT NULL COMMENT '商品总库存',
  `current_stock` int(11)  NOT NULL COMMENT '当前库存',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '商家id',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类类目',
  `status` int(11) DEFAULT '1' COMMENT '状态 1：有效 0：失效',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(200)  DEFAULT NULL COMMENT '创建人',
  `updator` varchar(200)  DEFAULT NULL COMMENT '更新人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品基本信息';

CREATE TABLE `t_item_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(100)  NOT NULL COMMENT '商品id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `rate` int(11) DEFAULT '1' COMMENT '好评度 1：一星 2：二星 3：三星 4：四星 5：五星',
  `comment` varchar(1000)  NOT NULL COMMENT '评价信息',
  `status` int(11) DEFAULT '1' COMMENT '状态 1：有效 0：失效',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品评价信息';

CREATE TABLE `t_sale_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_number` varchar(200)  DEFAULT NULL COMMENT '促销券号',
  `code` varchar(200)  DEFAULT NULL COMMENT '券代码',
  `name` varchar(100)  NOT NULL COMMENT '券名称',
  `sale_type` int(1) DEFAULT NULL COMMENT '促销类型 （满减 现金券）',
  `sale_amount` decimal(15,4) DEFAULT NULL COMMENT '当如果是满减券需要判断当前订单是否满足当前金额',
  `type` int(1) DEFAULT NULL COMMENT '1：全场券（平台） 2：商家券（商家）  3：会员全场券(平台) 4：会员商家券（商家）',
  `tag` varchar(1000)  NOT NULL COMMENT '打折标签 （本店满xx元使用）',
  `is_del` int(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `effective_date` datetime DEFAULT NULL COMMENT '券生效时间',
  `invalid_date` datetime DEFAULT NULL COMMENT '券过期时间',
  `creator` varchar(200)  DEFAULT NULL COMMENT '创建人',
  `updator` varchar(200)  DEFAULT NULL COMMENT '更新人',
  `priority` bigint(10) DEFAULT '0' COMMENT '优先级',
  `total_ticket` int(11)  NOT NULL COMMENT '券总数',
  `used_ticket` int(11)  NOT NULL COMMENT '券领取数量',
  `amount` decimal(15,4) DEFAULT NULL COMMENT '券金额',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '市id',
  `county_id` bigint(20) unsigned NOT NULL COMMENT '县id',
  `town_id` bigint(20) unsigned NOT NULL COMMENT '乡镇id',
  `shop_id` varchar(100) DEFAULT NULL COMMENT '商家id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='促销信息';

CREATE TABLE `t_member` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `member_id` VARCHAR(100) NOT NULL COMMENT '会员 id',
  `user_id` INT(11) NOT NULL COMMENT '用户 id',
  `level` INT(4) NOT NULL DEFAULT 0 COMMENT '会员等级(0 普通会员)',
  `balance` DECIMAL(20,4) NOT NULL COMMENT '余额',
  `is_del` INT(4) NOT NULL DEFAULT 0 COMMENT '是否可用(0 可用, 1 不可用)',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会员信息表';

CREATE TABLE `t_user_member_recharge_record` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `member_id` VARCHAR(100) NOT NULL COMMENT '会员id',
  `recharge_amount` DECIMAL(20,4) NOT NULL COMMENT '冲值金额',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会员充值记录表';


CREATE TABLE `t_order_header` (
  `id` BIGINT(20) UNSIGNED NOT  NULL  AUTO_INCREMENT,
  `order_id` VARCHAR(100) NOT NULL COMMENT '订单 id',
  `status` INT(4) NOT NULL COMMENT '订单状态(1 = 待支付, 2 = 商品打包中, 3 = 配送中, 4 = 待自提, 5 = 已签收, 6 = 订单完成, 7 = 订单取消, 8 = 退款审核中, 9 = 退货审核中)',
  `is_del` INT(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `is_expired` INT(1) DEFAULT NULL COMMENT '过期状态 0:正常 1:过期',
  `address_id` VARCHAR(16) DEFAULT NOT NULL COMMENT '地址信息 id',
  `actual_amount` DECIMAL(20,4) NOT NULL COMMENT '实际支付金额',
  `total_amount` DECIMAL(20,4) NOT NULL COMMENT '总金额',
  `shop_id` VARCHAR(100) NOT NULL COMMENT ' 店铺信息 id',
  `allocation_from_time` DATETIME DEFAULT NOT NULL COMMENT '配送起始时间',
  `allocation_to_time` DATETIME DEFAULT NOT NULL COMMENT '配送到达时间',
  `allocation_type` INT(4) DEFAULT '0' NOT NULL COMMENT '配送方式(0: 平台配送, 1: 用户自提)',
  `comment` VARCHAR(200) COMMENT '备注',
  `arrival_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '送达时间',
  `complete_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '完成时间',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `user_id` VARCHAR(100)  DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单头部信息';

CREATE TABLE `t_order_detail` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` VARCHAR(100) NOT NULL COMMENT '订单 id',
  `item_info_id` VARCHAR(100) NOT NULL COMMENT '商品信息 id',
  `item_count` INT(10) NOT NULL COMMENT '商品购买数量',
  `freight_id` INT(4) DEFAULT NULL COMMENT '运费 id',
  `platform_promotion_code` INT(20) COMMENT '平台券id',
  `platform_promotion_cost` DECIMAL(20,4) COMMENT '平台券使用金额',
  `shop_promotion_code` INT(20) COMMENT '商家券 id',
  `shop_promotion_cost` DECIMAL(20,4) COMMENT '商家券使用金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单详情';


CREATE TABLE `t_purchase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchase_id` VARCHAR(100) NOT NULL COMMENT '支付 id',
  `type` INT(3) NOT NULL COMMENT '支付类型(待定)',
  `order_id` VARCHAR(100) NOT NULL COMMENT '订单 id',
  `is_del` INT(1) DEFAULT NULL COMMENT '删除状态 0:正常 1:删除',
  `amount` DECIMAL(20,4) NOT NULL COMMENT '支付金额',
  `status` INT(1) NOT NULL COMMENT '支付状态(0: 未支付, 1: 支付)',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `complete_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='支付记录详情';


CREATE TABLE `t_refund_flow` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flow_id` VARCHAR(100) NOT NULL COMMENT '流水 id',
  `purchase_id` VARCHAR(100) NOT NULL COMMENT '支付 id',
  `order_id` VARCHAR(100) NOT NULL COMMENT '订单 id',
  `shop_id` VARCHAR(100) NOT NULL COMMENT ' 店铺信息 id',
  `refund_detail_id` VARCHAR(100) NOT NULL COMMENT '退款明细 id',
  `type` INT(1) NOT NULL COMMENT '退款类型(0: 部分退款, 1: 整单退款)',
  `promotion_status` INT(1) NOT NULL COMMENT '退券状态(0: 未退, 1: 已退)',
  `status` INT(1) NOT NULL COMMENT '退款状态(0: 未退款, 1: 已退款)',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `complete_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='退款流水';

CREATE TABLE `t_refund_detail` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `refund_detail_id` VARCHAR(100) NOT NULL COMMENT '退款详情 id',
  `flow_id` VARCHAR(100) NOT NULL COMMENT '流水 id',
  `item_info_id` VARCHAR(100) NOT NULL COMMENT '商品信息 id',
  `refund_count` INT(10) NOT NULL COMMENT '退货数量',
  `platform_promotion_code` INT(20) COMMENT '平台券id',
  `shop_promotion_code` INT(20) COMMENT '商家券 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='退款明细';

# 缺 地址表
# 缺 时间规则表
# 缺 运费表
# 所有 varchar 类型的 id 规则