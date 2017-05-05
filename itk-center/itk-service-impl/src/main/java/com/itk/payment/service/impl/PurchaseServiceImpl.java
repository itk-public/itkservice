package com.itk.payment.service.impl;

import com.itk.payment.mapper.PurchaseMapper;
import com.itk.payment.model.Purchase;
import com.itk.payment.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public int addPurchase(Purchase purchase) {
        return purchaseMapper.insertSelective(purchase);
    }

    @Override
    public int delPurchase(Integer id) {
        Purchase purchase = purchaseMapper.selectByPrimaryKey(id);
        purchase.setIsDel(1);
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }

    @Override
    public int updatePurchase(Purchase purchase) {
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }

    @Override
    public Purchase selectByPurchaseId(String purchaseId) {
        return purchaseMapper.selectByPurchaseId(purchaseId);
    }

    @Override
    public List<Purchase> selectByStatus(Integer status) {
        return purchaseMapper.selectByStatus(status);
    }
}
