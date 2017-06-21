package com.itk.order.web;

import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderInfoVO;
import com.itk.order.model.ShoppingCartVO;
import com.itk.order.service.OrderFrontServiceImpl;

import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/purchase/Order/info", method = RequestMethod.POST)
    public ResponseEntity<?> getPurchaseOrderDetail(@RequestBody OrderInfoVO orderInfoVO) {
        return new ResponseEntity<>(
                WebResult.ok(orderFrontService.getPurchaseOrderDetail(orderInfoVO)),
                HttpStatus.OK);
    }
}
