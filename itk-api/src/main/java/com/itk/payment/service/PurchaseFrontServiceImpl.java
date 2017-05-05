package com.itk.payment.service;

import com.itk.payment.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class PurchaseFrontServiceImpl {

    @Autowired
    PurchaseService purchaseService;

    public int addPurchase(Purchase purchase){
        return  purchaseService.addPurchase(purchase);
    }

    public int delPurchase(Integer id){
        return purchaseService.delPurchase(id);
    }

    public int updatePurchase(Purchase purchase){
        return purchaseService.updatePurchase(purchase);
    }

    public Purchase selectByPurchaseId(String purchaseId){
        return purchaseService.selectByPurchaseId(purchaseId);
    }

    public List<Purchase> selectByStatus(Integer status){
        return purchaseService.selectByStatus(status);
    }
}
