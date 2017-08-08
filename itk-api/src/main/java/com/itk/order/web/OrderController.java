package com.itk.order.web;

import com.itk.exception.ResultCode;
import com.itk.exception.SystemException;
import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderInfoVO;
import com.itk.order.model.PurchaseInfoVO;
import com.itk.order.model.ShoppingCartVO;
import com.itk.order.service.OrderFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by enchen on 5/5/17.
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderFrontServiceImpl orderFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addOrderHeader(@RequestBody OrderHeader orderHeader) {
        if (orderFrontService.addOrderHeader(orderHeader) > 0) {
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateOrderHeader(@RequestBody OrderHeader orderHeader) {
        if (orderFrontService.updateOrderHeader(orderHeader) > 0) {
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public WebResult delPurchase(@PathVariable(value = "id") Long id) {
        if (orderFrontService.delOrderHeader(id) > 0) {
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectByOrderId/{orderId}", method = RequestMethod.GET)
    public WebResult selectByOrderId(@PathVariable(value = "orderId") String orderId) {
        return WebResult.ok(orderFrontService.selectByOrderId(orderId));
    }


    //购物车到订单结算页面
    @RequestMapping(value = "/ShoppingCart/Info", method = RequestMethod.POST)
    public ResponseEntity<?> getOrderInfo(@RequestBody ShoppingCartVO shoppingCartVO) {
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.getOrderInfoVoDetail(shoppingCartVO)),
                HttpStatus.OK);
    }

    //订单结算到提交订单
    @RequestMapping(value = "/submit/Order/info", method = RequestMethod.POST)
    public ResponseEntity<?> getSubmitOrderDetail(@RequestBody PurchaseInfoVO purchaseInfoVO) {
        List<String> orderIds = purchaseInfoVO.getOrderIds();
        if(CollectionUtils.isEmpty(orderIds)){
            throw new SystemException(ResultCode.ORDER_ID_REQUIRED);
        }
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.purchaseOrders(purchaseInfoVO)),
                HttpStatus.OK);
    }

    //订单支付
    @RequestMapping(value = "/orders/purchase", method = RequestMethod.POST)
    public ResponseEntity<?> getSubmitOrderDetail(@RequestBody OrderInfoVO orderInfoVO) {
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.getSubmitOrderDetail(orderInfoVO)),
                HttpStatus.OK);
    }

    //订单完成
    @RequestMapping(value = "/complete/{orderId}", method = RequestMethod.POST)
    public ResponseEntity<?> orderComplete(@PathVariable(value = "orderId") String orderId) {
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.orderComplete(orderId)),
                HttpStatus.OK);
    }

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
    @RequestMapping(value = "/allocationFlow", method = RequestMethod.POST)
    public ResponseEntity<?> orderAllocationFlow(@RequestParam(value = "orderId") String orderId,
                                                 @RequestParam(value = "status") Integer status,
                                                 @RequestParam(value = "allocationType") Integer allocationType,
                                                 @RequestParam(value = "allocationFromTime", required = false) Date allocationFromTime,
                                                 @RequestParam(value = "allocationToTime", required = false) Date allocationToTime,
                                                 @RequestParam(value = "pickSelfLocationId", required = false) Integer pickSelfLocationId,
                                                 @RequestParam(value = "arrivalTime", required = false) Date arrivalTime) {
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.orderAllocationFlow(orderId, status, allocationType, allocationFromTime, allocationToTime, pickSelfLocationId, arrivalTime)),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/cancel/{orderId}", method = RequestMethod.POST)
    public ResponseEntity<?> orderCancel(@PathVariable(value = "orderId") String orderId){
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.orderCancel(orderId)),
                HttpStatus.OK
        );
    }
}
