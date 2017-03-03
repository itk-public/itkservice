package com.itk.base.service;

import com.itk.base.model.ShopInfo;

import java.util.List;

/**
 * Created by zhouhui on 2017/3/3.
 */
public interface ShopInfoService {


    int addShopInfo(ShopInfo ShopInfo);

    int updateShopInfo(ShopInfo ShopInfo);

    int deleShopInfo(ShopInfo ShopInfo);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectShopInfos();
}
