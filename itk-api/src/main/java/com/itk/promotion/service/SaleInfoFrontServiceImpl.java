package com.itk.promotion.service;

import com.itk.promotion.model.SaleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class SaleInfoFrontServiceImpl {

    @Autowired
    private SaleInfoService saleInfoService;

    public int addSaleInfo(SaleInfo saleInfo){
        return saleInfoService.addSaleInfo(saleInfo);
    }

    public int updateSaleInfo(SaleInfo saleInfo){
        return saleInfoService.updateSaleInfo(saleInfo);
    }

    public int delSaleInfo(Integer saleInfoId){
        return saleInfoService.delSaleInfo(saleInfoId);
    }

    public SaleInfo selectByPrimaryKey(Integer saleInfoId){
        return saleInfoService.selectByPrimaryKey(saleInfoId);
    }

    public List<SaleInfo> selectByShopId(String shopId){
        return saleInfoService.selectByShopId(shopId);
    }
}
