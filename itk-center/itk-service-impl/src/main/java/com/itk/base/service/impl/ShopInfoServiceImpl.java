package com.itk.base.service.impl;

import com.itk.base.mapper.ShopInfoMapper;
import com.itk.base.model.ShopInfo;
import com.itk.base.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/3/3.
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
        return shopInfoMapper.updateByPrimaryKey(shopInfo);
    }

    @Override
    public int deleShopInfo(ShopInfo shopInfo) {
        return shopInfoMapper.updateByPrimaryKey(shopInfo);
    }

    @Override
    public ShopInfo selectByPrimaryKey(Long id) {
        return shopInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopInfo> selectShopInfos() {
        return shopInfoMapper.selectShopInfos();
    }
}
