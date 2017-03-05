package com.itk.base.web;

import com.itk.base.model.ShopInfo;
import com.itk.base.service.PositionProvinceServiceImpl;
import com.itk.base.service.ShopInfoServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/base/shop/info")
public class shopInfoController {

    @Autowired
    private ShopInfoServiceImpl shopInfoService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addShopInfo(@RequestBody ShopInfo shopInfo) throws Exception{
        if(shopInfoService.addShopInfo(shopInfo) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateShopInfo(@RequestBody ShopInfo shopInfo) throws Exception {
        if(shopInfoService.updateShopInfo(shopInfo) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{shopInfoId}", method = RequestMethod.DELETE)
    public WebResult delShopInfo(@PathVariable(value = "shopInfoId") Long shopInfoId) throws Exception {
        if(shopInfoService.delShopInfo(shopInfoId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{shopInfoId}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "shopInfoId") Long shopInfoId) throws Exception {
        return WebResult.ok(shopInfoService.selectByPrimaryKey(shopInfoId));
    }

    @RequestMapping(value = "/selectShopInfoByTownShipId", method = RequestMethod.GET)
    public WebResult selectShopInfoByTownShipId(@RequestParam("townShipId") Long townShipId) throws Exception {
        return WebResult.ok(shopInfoService.selectShopInfoByTownshipId(townShipId));
    }
}
