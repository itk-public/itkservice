package com.itk.order.web;

import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderInfoVO;
import com.itk.order.model.ShoppingCartVO;
import com.itk.order.service.OrderHeaderFrontServiceImpl;
import com.itk.user.web.mapper.UserShippingAddressMapper;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * Created by enchen on 5/5/17.
 */
@RestController
@RequestMapping("/api/order")
public class OrderHeaderController {

    @Autowired
    OrderHeaderFrontServiceImpl orderHeaderFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addOrderHeader(@RequestBody OrderHeader orderHeader) throws Exception{
        if(orderHeaderFrontService.addOrderHeader(orderHeader) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateOrderHeader(@RequestBody OrderHeader orderHeader) throws Exception {
        if(orderHeaderFrontService.updateOrderHeader(orderHeader) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public WebResult delPurchase(@PathVariable(value = "id") Long id) throws Exception {
        if(orderHeaderFrontService.delOrderHeader(id) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectByOrderId/{orderId}", method = RequestMethod.GET)
    public WebResult selectByOrderId(@PathVariable(value = "orderId") String orderId) throws Exception {
        return WebResult.ok(orderHeaderFrontService.selectByOrderId(orderId));
    }


    //购物车到订单结算页面
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ResponseEntity<?> getOrderInfo(@RequestBody ShoppingCartVO shoppingCartVO) throws Exception {
        return new ResponseEntity<>(
                WebResult.ok(orderHeaderFrontService.getOrderInfoVoDetail(shoppingCartVO)),
                HttpStatus.OK);
    }
}
