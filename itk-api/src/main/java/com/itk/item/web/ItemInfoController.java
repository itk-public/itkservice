package com.itk.item.web;

import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/item/itemInfo")
public class ItemInfoController {

    @Autowired
    private ItemInfoFrontServiceImpl itemInfoFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addItemInfo(@RequestBody ItemInfo itemInfo) throws Exception{
        if(itemInfoFrontService.addItemInfo(itemInfo) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateItemComment(@RequestBody ItemInfo itemInfo) throws Exception {
        if(itemInfoFrontService.updateItemInfo(itemInfo) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/deleteItemInfo/{itemInfoId}", method = RequestMethod.DELETE)
    public WebResult delItemInfo(@PathVariable(value = "itemInfoId") Integer itemInfoId) throws Exception {
        if(itemInfoFrontService.delItemInfo(itemInfoId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectByCategoryIdAndStatus", method = RequestMethod.GET)
    public WebResult selectByCategoryIdAndStatus(@RequestParam("categoryId")Long categoryId,
                                                 @RequestParam("status")Integer status) throws Exception {
        return WebResult.ok(itemInfoFrontService.selectByCategoryIdAndStatus(categoryId, status));
    }

    @RequestMapping(value = "/selectByShopIdAndStatus", method = RequestMethod.GET)
    public WebResult selectByShopIdAndStatus(@RequestParam("shopId")Long shopId,
                                             @RequestParam("status")Integer status) throws Exception {
        return WebResult.ok(itemInfoFrontService.selectByShopIdAndStatus(shopId, status));
    }

    @RequestMapping(value = "/selectByShopCategoryIdAndStatus", method = RequestMethod.GET)
    public WebResult selectByShopCategoryIdAndStatus(@RequestParam("shopCategoryId")Integer shopCategoryId,
                                                     @RequestParam("status")Integer status) throws Exception {
        return WebResult.ok(itemInfoFrontService.selectByShopCategoryIdAndStatus(shopCategoryId, status));
    }
}
