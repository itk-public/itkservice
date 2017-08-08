package com.itk.order.service;

import com.itk.dto.OrderInfoDTO;
import com.itk.dto.PurchaseInfoDTO;
import com.itk.order.model.OrderHeader;
import com.itk.payment.model.Purchase;

import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 5/6/17.
 */
public interface OrderHeaderService {

    int addOrderHeader(OrderHeader orderHeader);

    int delOrderHeader(Long id);

    int updateOrderHeader(OrderHeader orderHeader);

    OrderHeader selectByOrderId(String orderId);

    // 订单提交
    OrderInfoDTO getSubmitOrderDetail(OrderInfoDTO orderInfoDTO, String userId);

    //支付订单
    PurchaseInfoDTO purchaseOrders(PurchaseInfoDTO purchaseInfoDTO);

    //订单完成
    OrderHeader orderComplete(String orderId);

    //订单取消
    OrderHeader orderCancel(String orderId);

    /**
     * 订单配送过程流转
     *
     * @param orderId
     * @param status             订单流程流转（2 = 商品打包中, 3 = 配送中, 4 = 待自提, 5 = 已签收）
     * @param allocationType     配送方式(0: 平台配送, 1: 用户自提)
     * @param allocationFromTime 配送起始时间
     * @param allocationToTime   配送到达时间
     * @param pickSelfLocationId 自提点id
     * @param arrivalTime        送达时间
     * @return
     */
    OrderHeader orderAllocationFlow(String orderId, Integer status, Integer allocationType, Date allocationFromTime, Date allocationToTime, Integer pickSelfLocationId, Date arrivalTime);
}
