package com.itk.payment.service;

import com.itk.payment.model.Purchase;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public interface PurchaseService {

    int addPurchase(Purchase purchase);

    int delPurchase(Integer id);

    int updatePurchase(Purchase purchase);

    Purchase selectByPurchaseId(String purchaseId);

    List<Purchase> selectByStatus(Integer status);

    Purchase createOrderPurchase(Integer type, String[] orderList);

    Purchase cancelOrderPurchase(String purchaseId);
}
