package com.itk.payment.service.impl;

import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoService;
import com.itk.order.model.OrderDetail;
import com.itk.order.service.OrderDetailService;
import com.itk.order.service.OrderHeaderService;
import com.itk.payment.mapper.PurchaseMapper;
import com.itk.payment.model.Purchase;
import com.itk.payment.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by enchen on 5/5/17.
 */
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseMapper purchaseMapper;

    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ItemInfoService itemInfoService;

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

    @Override
    @Transactional
    public Purchase createOrderPurchase(Integer type, String[] orderList) {
        List<String> orderStringList = Arrays.asList(orderList);
        //每个商品减库存
        //计算所有订单总价,获得支付金额
        List<BigDecimal> orderAmountList = new ArrayList<BigDecimal>();
        ConcurrentHashMap<Long, OrderDetail> orderDetailMap = new ConcurrentHashMap<Long, OrderDetail>();
        for (String orderId: orderList) {
            orderAmountList.add(orderHeaderService.selectByOrderId(orderId).getActualAmount());
            //更新库存
            List<OrderDetail> orderDetailList = orderDetailService.selectByOrderId(orderId);
            for (OrderDetail orderDetail: orderDetailList) {
                ItemInfo itemInfo = itemInfoService.selectByItemId(orderDetail.getItemInfoId());
                Integer stock = itemInfo.getCurrentStock();
                stock -= orderDetail.getItemCount();
                itemInfo.setCurrentStock(stock > 0 ? stock : 0);
                itemInfoService.updateItemInfo(itemInfo);
            }
        }
        BigDecimal purchaseAmount = orderAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(UUID.randomUUID().toString());
        purchase.setType(type);
        purchase.setOrderId(String.join(",",orderStringList));
        purchase.setIsDel(0);
        purchase.setAmount(purchaseAmount);
        purchase.setStatus(0);
        purchase.setCreateTime(new Date());
        purchaseMapper.insertSelective(purchase);
        return purchase;
    }

    @Override
    public int cancelOrderPurchase(String purchaseId) {
        Purchase purchase = this.selectByPurchaseId(purchaseId);
        return 0;
    }

}
