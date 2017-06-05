package com.itk.order.web;

import com.itk.order.model.OrderHeader;
import com.itk.order.service.OrderHeaderFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 5/5/17.
 */
@RestController
@RequestMapping("/order")
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() throws Exception {
        orderHeaderFrontService.test("orderIDSuffix");
        //System.out.println("###########origin: " + orderHeaderFrontService.test("orderIDSuffix"));
    }
}
