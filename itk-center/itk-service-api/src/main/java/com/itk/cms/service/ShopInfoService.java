package com.itk.cms.service;

import com.itk.base.model.ShopInfo;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public interface ShopInfoService {

    int addShopInfo(ShopInfo shopInfo);

    int updateShopInfo(ShopInfo shopInfo);

    int delShopInfo(Long shopInfoId);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectShopInfoByTownshipId(Long townshipId);
}
