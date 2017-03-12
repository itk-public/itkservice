package com.itk.promotion.web;

import com.itk.promotion.model.SaleInfo;
import com.itk.promotion.service.SaleInfoFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/saleInfo")
public class SaleInfoController {

    @Autowired
    private SaleInfoFrontServiceImpl saleInfoFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addSaleInfo(@RequestBody SaleInfo saleInfo) throws Exception{
        if(saleInfoFrontService.addSaleInfo(saleInfo) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateSaleInfo(@RequestBody SaleInfo saleInfo) throws Exception {
        if(saleInfoFrontService.updateSaleInfo(saleInfo) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/deleteSaleInfo/{saleInfoId}", method = RequestMethod.DELETE)
    public WebResult delSaleInfo(@PathVariable(value = "saleInfoId") Integer saleInfoId) throws Exception {
        if(saleInfoFrontService.delSaleInfo(saleInfoId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectSaleInfoDetail/{saleInfoId}", method = RequestMethod.DELETE)
    public WebResult selectItemCommentByItemId(@PathVariable(value = "saleInfoId") Integer saleInfoId) throws Exception {
        return WebResult.ok(saleInfoFrontService.selectByPrimaryKey(saleInfoId));
    }

    @RequestMapping(value = "/selectByShopId/{shopId}", method = RequestMethod.DELETE)
    public WebResult selectByShopId(@PathVariable(value = "shopId") String shopId) throws Exception {
        return WebResult.ok(saleInfoFrontService.selectByShopId(shopId));
    }
}
