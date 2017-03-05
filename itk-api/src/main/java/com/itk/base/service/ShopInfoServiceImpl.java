package com.itk.base.service;

import com.itk.base.model.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class ShopInfoServiceImpl {

    @Autowired
    private ShopInfoService shopInfoService;

    public int addShopInfo(ShopInfo shopInfo){
        return shopInfoService.addShopInfo(shopInfo);
    }

    public int updateShopInfo(ShopInfo shopInfo){
        return shopInfoService.updateShopInfo(shopInfo);
    }

    public int delShopInfo(Long shopInfoId){
        return shopInfoService.delShopInfo(shopInfoId);
    }

    public ShopInfo selectByPrimaryKey(Long id){
        return shopInfoService.selectByPrimaryKey(id);
    }

    public List<ShopInfo> selectShopInfoByTownshipId(Long townShipId){
        return shopInfoService.selectShopInfoByTownshipId(townShipId);
    }

    public List<ShopInfo> selectShopInfos(){
        return shopInfoService.selectShopInfos();
    }
}
