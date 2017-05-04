package com.itk.promotion.service.impl;

import com.itk.promotion.mapper.SaleInfoMapper;
import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public class SaleInfoServiceImpl implements SaleInfoService {

    @Autowired
    private SaleInfoMapper saleInfoMapper;


    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insertSelective(saleInfo);
    }

    @Override
    public int updateSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateByPrimaryKeySelective(saleInfo);
    }

    @Override
    public int delSaleInfo(Integer id) {
        SaleInfo saleInfo = saleInfoMapper.selectByPrimaryKey(id);
        saleInfo.setIsDel(1);//删除状态 0:正常 1:删除
        return saleInfoMapper.updateByPrimaryKeySelective(saleInfo);
    }

    @Override
    public SaleInfo selectByPrimaryKey(Integer id) {
        return saleInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SaleInfo> selectByShopId(String shopId) {
        return saleInfoMapper.selectByShopId(shopId);
    }
}
