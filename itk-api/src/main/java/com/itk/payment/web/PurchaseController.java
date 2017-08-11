package com.itk.payment.web;

import com.itk.payment.model.Purchase;
import com.itk.payment.service.PurchaseFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by enchen on 5/5/17.
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseFrontServiceImpl purchaseFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addPurchase(@RequestBody Purchase purchase) {
        purchase.setPurchaseId(UUID.randomUUID().toString());
        purchase.setCreateTime(new Date());
        if (purchaseFrontService.addPurchase(purchase) > 0) {
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updatePurchase(@RequestBody Purchase purchase) {
        if (purchaseFrontService.updatePurchase(purchase) > 0) {
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/deletePurchase/{id}", method = RequestMethod.DELETE)
    public WebResult delPurchase(@PathVariable(value = "id") Integer id) {
        if (purchaseFrontService.delPurchase(id) > 0) {
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectByPurchaseId/{purchaseId}", method = RequestMethod.GET)
    public WebResult selectMemberByUserId(@PathVariable(value = "purchaseId") String purchaseId) {
        return WebResult.ok(purchaseFrontService.selectByPurchaseId(purchaseId));
    }

    @RequestMapping(value = "/selectByStatus/{status}", method = RequestMethod.GET)
    public WebResult selectById(@RequestParam(value = "status", required = false) Integer status) {
        return WebResult.ok(purchaseFrontService.selectByStatus(status));
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public WebResult purchaseOrderCreate(
            @RequestParam(name = "type") Integer type,
            @RequestParam(name = "orderList") String[] orderList) {
        return WebResult.ok(purchaseFrontService.createOrderPurchase(type, orderList));
    }

    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    public WebResult purchaseOrderCancel(
            @RequestParam(name = "purchaseId") String purchaseId) {
        return WebResult.ok(purchaseFrontService.cancelPurchaseOrder(purchaseId));
    }
}
