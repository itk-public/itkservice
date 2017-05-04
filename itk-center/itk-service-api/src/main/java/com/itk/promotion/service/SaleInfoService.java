package com.itk.promotion.service;

import com.itk.promotion.model.SaleInfo;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public interface SaleInfoService {

    int addSaleInfo(SaleInfo saleInfo);

    int updateSaleInfo(SaleInfo saleInfo);

    int delSaleInfo(Integer id);

    SaleInfo selectByPrimaryKey(Integer id);

    List<SaleInfo> selectByShopId(String shopId);
}
