package com.itk.base.service.impl;

import com.itk.base.mapper.ShopInfoMapper;
import com.itk.base.model.ShopInfo;
import com.itk.base.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public class ShopInfoServiceImpl implements ShopInfoService {

    @Autowired
    private ShopInfoMapper shopInfoMapper;


    @Override
    public int addShopInfo(ShopInfo shopInfo) {
        return shopInfoMapper.insertSelective(shopInfo);
    }

    @Override
    public int updateShopInfo(ShopInfo shopInfo) {
        return shopInfoMapper.updateByPrimaryKeySelective(shopInfo);
    }

    @Override
    public int delShopInfo(Long shopInfoId) {
        ShopInfo shopInfo = shopInfoMapper.selectByPrimaryKey(shopInfoId);
        shopInfo.setIsDel(1);// isDel 0: 可用  1: 已删除
        return shopInfoMapper.updateByPrimaryKeySelective(shopInfo);
    }

    @Override
    public ShopInfo selectByPrimaryKey(Long id) {
        return shopInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopInfo> selectShopInfoByTownshipId(Long townshipId) {
        return shopInfoMapper.selectByTownshipId(townshipId);
    }
}
